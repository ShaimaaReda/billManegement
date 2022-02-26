/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billmanegement;

import java.sql.Connection;
import java.sql.SQLException;
import static billmanegement.DBconnect.connect;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ta-rek,sohaila
 */
public class BillManegement {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException  {
        Scanner input = new Scanner(System.in);
        //Connection con = connect();
        //start statement
        System.out.println("--------------------Welcome to our system--------------------");
        char y = 0;
        do{
        System.out.println("Enter your selection based on your recipe.....");
        System.out.println("1)Old Customer.");
        System.out.println("2)New Customer(log in system).");
        System.out.println("3)Operator.");
        System.out.println("4)Admin.");
        System.out.println("5)Mail (customers).");
        System.out.print("?: ");
        int choise = input.nextInt();
        switch (choise){
            //old customer choise::
            case 1:
            {
              oldCustomerInterface.interFace();
              break;
            }
            //end old customer
            //start new customer
            case 2:
            {
              newCustomers.fillInfo();
              break;
            }
            //end of new customer
            //start of operator
            case 3:
            {
              operatorInterface.opratorInterFace();
              break;
            }
            
            case 4:
            {
              adminInterface.admin_InterFace();
              break;
            }
            case 5:
            {
                mailInterface.mail_InterFace();
                break;
            }
             default :
             {
                 System.out.println("invalid choise...");
                 break;
             }
             
            } 
            
           System.out.println("Want another operation in system ? (y\n).");
           y = input.next().charAt(0);
        }while (y!='n');
  } 
}
    











///*
// email 
//Dear customer, your account has been temporarily suspended due to the existence of unpaid bills for three months. Please go to the company branch to pay the bills
//*/
//
//
////          char choise ;
////          do{
////           System.out.println("Enter your metercode: ");
////           int metercode = input.nextInt();
////           boolean x = oldCustomer.login(metercode);
////           if (x==true)
////               System.out.println("chose a choise: ");
////           else if (x==false)
////               System.out.println("want another operation (y/n): ");
////           choise = input.next().charAt(0);
////          } while (choise!='n');
////    Mailer.sendFromGMail("tarekmostafa602@gmail.com", "1362001116", "Sohailamohsen8@gmail.com", "java", "hi");
////    operator.paidValidation(201090);
//
//
//
//
//
//
//
//
//
//
//
//        //operator x = new operator();
////        String name = input.next();
////        int password = input.nextInt(); 
////        boolean y=operator.login(name, password);
////        if (y==true)
////            System.out.println("welcome "+name);
////        else 
////            System.out.println("sorry username and password not matched...........");
////              System.out.println("Enter meter code: ");
////              int metercode = input.nextInt();
////              System.out.println("enter current reading: ");
////              int currentReading = input.nextInt();
////              boolean x =operator.validation(metercode, currentReading);
////              if (x==true)
////                  System.out.println("correct reading");
////              else if (x==false)
////                  System.out.println("your reading is incorrect............");
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///*
//Connection con = connect();
//        //Statement stmt =  con.createStatement();
//        
//        PreparedStatement pstmt = con.prepareStatement("update cusinfo set name = ? where metercode=?");
//        System.out.println("Enter meter code: ");
//        int mt = input.nextInt();
////        System.out.println("Enter new name: ");
////        String nm=input.next();
////        pstmt.setString(1, nm);
////        pstmt.setInt(2,mt);
////        pstmt.executeUpdate();
//        
//        PreparedStatement st = con.prepareStatement("select * from cusinfo where metercode =?");
//        st.setInt(1, mt);
//        
//        ResultSet rs=st.executeQuery();
//       rs.next();
//        System.out.println("\nNew customer info:");
//              System.out.println("meter code:   " + rs.getInt(1));
//              System.out.println("region:   " + rs.getString(2));
//              System.out.println("name: " + rs.getString(3));
//              System.out.println("reading:  " + rs.getString(4));
//              System.out.println("trafirr:  " + rs.getString(5));
//              System.out.println("flag: " + rs.getString(6));
//              System.out.println("cost: " + rs.getString(7));
//            
//            con.close();
//        
//*/
//
//
//
//
//
//
//        
//    /* while(mt.next()&&nm.next()&&rg.next()&&rd.next()) {
//                System.out.println(mt.getInt(1));
//                System.out.println(nm.getString(2));
//                System.out.println(rg.getString(3));
//                System.out.println(rd.getInt(4));
//            }*/
//
// /*ResultSet mt =stmt.executeQuery("select metercode from cusinfo");
//        ResultSet nm =stmt.executeQuery("select name from cusinfo");
//        ResultSet rg =stmt.executeQuery("select region from cusinfo");
//        ResultSet rd =stmt.executeQuery("select reading from cusinfo");*/