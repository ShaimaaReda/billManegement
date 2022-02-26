/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billmanegement;
import java.io.FileNotFoundException;
import java.io.IOException;
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
 * @author shorouk
 */
public class newCustomers {
    
    public static void fillInfo () throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our System if you want to subscripe in our system,"+"\n"+"please fill this inforamtion below.....");
        System.out.println("Enter your name : ");
        String name = input.nextLine();
        System.out.println("Enter your region : ");
        String region = input.nextLine();
        System.out.println("Enter your address : ");
        String address = input.nextLine();
        System.out.println("Enter your email : ");
        String email = input.nextLine();
        System.out.println("Enter your password : ");
        int password = input.nextInt();
        //System.out.println("Do you want to atta"); 
        System.out.println("Enter The Path Of Photo :");
        String contract =input.next();
                    
        
        admin.add(name,email,region,address,password,contract);
             
    }
    
}