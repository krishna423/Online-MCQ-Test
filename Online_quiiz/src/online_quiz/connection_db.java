/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class connection_db {
    public static int con_inf =0;
    public static Connection connection(){
    Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst=null;
        String ip="localhost";
        String user_d="root";
        String pass_d="";
  /*  String ip="172.26.46.13";
    char uu[]={'k','r','i','s','h','n','a','4','2','3'};
    char pp[]={'p','a','n','k','r','i','a','n','5','6','3'};
    String user_d=new String(uu);
    String pass_d=new String (pp);
    */        try{
                
               Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://"+ip+"/quiz", user_d, pass_d);
                con_inf=1;
                return conn;
            }
            catch(Exception ee){
                System.out.println(ee);
                JOptionPane.showMessageDialog(null, "Connection error","error",JOptionPane.ERROR_MESSAGE);
                return conn;
            }
    
        
    }
}
