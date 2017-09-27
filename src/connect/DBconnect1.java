package connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author user
 */
public class DBconnect1 

{
  public static Connection connect()
  {
      Connection con=null;
      
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/businessmanagementsystem","root","");
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
      
      return con;
  }
}
