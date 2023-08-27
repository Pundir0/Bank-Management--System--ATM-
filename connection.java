
package bank.management.system;

import java.sql.*;

public class connection {
    
    Connection c;
    Statement s;
    public connection(){
        try{
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagemntsystem", "root", "2830");
        s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
}   
    
}
