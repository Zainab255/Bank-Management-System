package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // Load the MySQL driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "zainabroot");
            
            // Create the statement
            s = c.createStatement();
            
            System.out.println("Connection successful!");

        } catch (Exception e) {
            // Print the error to help with debugging
            e.printStackTrace();
        }
    }
}
