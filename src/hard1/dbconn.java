/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hard1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DUL
 */
public class dbconn {
    
     public static Connection connect()
            
    {
        Connection con=null;
        
        try{
            Class.forName("con.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/businessmanagementsystem","root","");
            }
        catch(Exception e)
            {
            System.out.println(e);
            }
        return con;
    
    }
    
    
    
}
