/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billmanegement;
import static billmanegement.DBconnect.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author tarek&sohaila
 */
public  class operator {
    Scanner input = new Scanner(System.in);
 // to enable operator to log in system          
public static  boolean login (String username , int passwordd) throws ClassNotFoundException, SQLException{
        Connection con = connect();
        try{
        //Statement stmt =  con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("select password from operator where username=? and password=?;");
        pstmt.setNString(1, username);
        pstmt.setInt(2, passwordd);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        if(passwordd!=rs.getInt(1)){
                    System.out.println("invalid");
                    return false;

        }
        else{
        System.out.println("Welcome . mr"+username);
        return true;
        }}
        catch(Exception e)
        {
          System.out.println("Invalid user name or password.");
          return false;
        }
    }
 // to define tariff   
public static float traiff (){
        float traiff = (float) .5;
        return traiff; 
    } 
  //to collect payments  
public static void collect () throws ClassNotFoundException, SQLException {
       

              Connection con = connect();
              Statement stmt = con.createStatement();                 
              ResultSet cost = stmt.executeQuery("select metercode, cost from bill where isPaid =0 and isCollected=1");
              //ResultSet meter = stmt.executeQuery("select metercode from bill where isPaid =0 and isCollected=0");
              ArrayList<Integer> meterc = new ArrayList<Integer>();   
              ArrayList<Integer> costs = new ArrayList<Integer>();
              System.out.println("meter code    cost");
              while(cost.next()) {
              System.out.println(cost.getInt(1)+ "        "+cost.getInt(2));
              meterc.add(cost.getInt(1));
              costs.add(cost.getInt(2));
              }
             int i=0;
              for (i=0;i<meterc.size();i++) { 
               PreparedStatement sq = con.prepareStatement("INSERT INTO collected VALUES (?,?);");
               sq.setInt(1,meterc.get(i));
               sq.setInt(2,costs.get(i));
               sq.executeUpdate();
              }
         String sql=" update bill set isCollected=0 where isPaid=0 and isCollected=1;";
         PreparedStatement p=con.prepareStatement(sql);
         p.executeUpdate();
            con.close();
          }
  //to validate reading  
public static boolean validation (int metercode , int currentreading) throws ClassNotFoundException, SQLException {
       Connection con = connect();
            PreparedStatement stmt = con.prepareStatement("select reading from cusinfo where metercode=?");
            stmt.setInt(1,metercode);
            ResultSet res = stmt.executeQuery();
            res.next();
            //l.getInt(1);
            if(res.getInt(1)<=currentreading)
                return true;
            else
                return false;
   }
 //to make sure about customer's payments
public static boolean paidValidation (int metercode) throws ClassNotFoundException, SQLException{
            Connection con = connect();
            PreparedStatement stmt = con.prepareStatement("select sum(isPaid) from bill where metercode=?");
            stmt.setInt(1,metercode);
            ResultSet res = stmt.executeQuery();
            res.next();
            if (res.getInt(1)>=3)
            {
                String msg = "Dear customer,"+"\n"+"your account has been temporarily suspended due to the existence of unpaid bills for three months."+"\n"+"Please go to the company branch to pay the bills";
                PreparedStatement email = con.prepareStatement("UPDATE cusinfo set emails = ? where metercode = ?");
                email.setString(1, msg);
                email.setInt(2, metercode);
                email.executeUpdate();
                return true;
            }
            else if (res.getInt(1)==0)
            {
                System.out.println("You paid all bill dear customer.");
                return false;
            }
            else
                return false;
        }
  //to print bill with customer meter code
public static void PrintBillWithMeterCode (int metercode) throws SQLException, ClassNotFoundException{
              
              Connection con = connect();
              PreparedStatement stmt = con.prepareStatement("select top(1) cusinfo.metercode,cusinfo.region,cusinfo.name,cusinfo.email,cusinfo.address,bill.consumption,bill.cost from cusinfo join bill on (bill.metercode=cusinfo.metercode and bill.metercode = ?) and bill.isPaid=1");       
              stmt.setInt(1,metercode);             
              ResultSet l = stmt.executeQuery(); 
              l.next();
              
              System.out.println("\nBILL:");
            System.out.println("metercode:         " + l.getInt(1));
            System.out.println("region : " + l.getString(2));
            System.out.println("Name:  " + l.getString(3));
            System.out.println("email:      " + l.getString(4));            
            System.out.println("address:      " + l.getString(5));
            System.out.println("consumption:  " + l.getInt(6));
            System.out.println("cost:      " + l.getInt(7));

              
             
              con.close();
   }
//to view all bills with reading
public static void viewBillsWithRegion(String region) throws SQLException, ClassNotFoundException{
              
              Connection con = connect();
              PreparedStatement stmt = con.prepareStatement("select cusinfo.metercode,cusinfo.region,cusinfo.name,cusinfo.reading,cusinfo.email, cusinfo.address,bill.consumption,bill.cost,bill.isPaid,bill.isCollected from cusInfo,bill where cusInfo.metercode=bill.metercode AND cusinfo.region=?;");       
              stmt.setString(1,region);       
              ResultSet l = stmt.executeQuery(); 
              while(l.next())
              {              
            System.out.println("\nBILL:");
            System.out.println("metercode:         " + l.getInt(1));
            System.out.println("region : " + l.getString(2));
            System.out.println("Name:  " + l.getString(3));
            System.out.println("reading:      " + l.getInt(4));
            System.out.println("email:      " + l.getString(5));            
            System.out.println("address:      " + l.getString(6));
            System.out.println("consumption:  " + l.getInt(7));
            System.out.println("cost:      " + l.getInt(8));
            System.out.println("Is paid?:      " + l.getInt(9));
            System.out.println("Is collected?:      " + l.getInt(10));

              }
             
              con.close();
   }

}