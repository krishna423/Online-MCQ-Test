/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author root
 */
public class Register implements Initializable {
    static int j=0,row=0;
    @FXML
    private JFXTextField fusername;
    String backupusername="";
    String backupphoneno="";
    
     @FXML
    private JFXTextField jfldusernamef;

    @FXML
    private JFXTextField jfldphonenof;

    @FXML
    private JFXPasswordField jpasswordf;

    @FXML
    private JFXPasswordField jretypepasswordf;

    @FXML
    private JFXButton jbtnupdate;

    @FXML
    private JFXTextField jfldnewusernamer;

    @FXML
    private JFXPasswordField jpasswordr;

    @FXML
    private JFXPasswordField jretypepasswordr;

    @FXML
    private JFXTextField jfldphonenor;

    @FXML
    private JFXButton jbtnadduser;
    @FXML
    private JFXButton c_status;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton exit;
     @FXML
    void jbtnexit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void jbtnback(ActionEvent event) {
        try{
            Stage stage = (Stage) back.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage sta1 = new Stage();
            sta1.setScene(new Scene(root1));  
            sta1.show();
            stage.close();
        }
        catch(Exception ee){}
    }
    @FXML
    void jbtnc_status(ActionEvent event) {
        if(!jfldusernamef.getText().equals("") && !jfldphonenof.getText().equals("")){
            j=0;
            backupusername=jfldusernamef.getText();
            backupphoneno=jfldphonenof.getText();
            ResultSet rs = null;
            PreparedStatement pstmt = null;
            String query="";
            try{
                Connection conn =connection_db.connection();
                //   conn = DriverManager.getConnection(connection_db.db_user,connection_db.user_d ,connection_db.pass_d);
                //    conn = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
                if(first_page.who.equals("faculity"))
                    query="select * from  faculity where username=? and phone_no=?";
                else
                    query="select * from  student where username=? and phone_no=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1,jfldusernamef.getText());
                pstmt.setString(2,jfldphonenof.getText());
                rs=pstmt.executeQuery();
                while(rs.next())
                    j=2;
                
                if(j==2)
                    JOptionPane.showMessageDialog(null, "you can change your password","Successfull",JOptionPane.INFORMATION_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(null, "wrong User name or phone no","error",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "server error","error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null, " Fill entries","Error ",JOptionPane.ERROR_MESSAGE);
        jfldphonenof.setText("");  
         jfldusernamef.setText("");
        
    }

    @FXML
    void jbtnadduser(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String query="";
        if(jpasswordr.getText().equals("") || jfldnewusernamer.getText().equals("") || jfldphonenor.getText().equals(""))
            JOptionPane.showMessageDialog(null, " Fill all entries","Error ",JOptionPane.ERROR_MESSAGE);
        else{
              if(jpasswordr.getText().equals(jretypepasswordr.getText()))
        try{
                Connection conn = connection_db.connection();
                //    conn = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
                if(first_page.who.equals("faculity"))
                    query="insert into faculity" +"(username,password,phone_no)"+"values"+"(?,?,?)";
                else
                    query="insert into student" +"(username,password,phone_no)"+"values"+"(?,?,?)";
                //query="insert into faculity" +"(username,password,phone_no)"+"values"+"(?,?,?)";
                pstmt = conn.prepareStatement(query);
              //  pstmt.setInt(1,(row+1));
                pstmt.setString(1, jfldnewusernamer.getText());
                pstmt.setString(2, jpasswordr.getText());
                pstmt.setString(3, jfldphonenor.getText());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "New Faculity Member added","Successful ",JOptionPane.INFORMATION_MESSAGE);
                jfldnewusernamer.setText(null);
                jpasswordr.setText(null);
                jretypepasswordr.setText(null);
                jfldphonenor.setText(null);
            try{
                Stage sta1 = (Stage) jbtnadduser.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage sta2 = new Stage();
                sta2.setScene(new Scene(root1));  
                sta2.show();
                sta1.close();
              }catch(Exception ee){}
            }
            catch(Exception dd)
            {
                System.out.println(dd);
               
                JOptionPane.showMessageDialog(null, "Something Went Wrong","Error ",JOptionPane.ERROR_MESSAGE);
            }
        else
        {
            JOptionPane.showMessageDialog(null, "password and retype password not match","Error ",JOptionPane.ERROR_MESSAGE);
        }
        
      }
    
        
    }

    
    @FXML
    void jbtnupdate(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String query="";
        if(j==0)
            JOptionPane.showMessageDialog(null, "Access Denied","Error",JOptionPane.ERROR_MESSAGE);
        if(jpasswordf.getText().equals(jretypepasswordf.getText()) && j==2)
        {
        try{
                Connection conn = connection_db.connection();
                //    conn = DriverManager.getConnection(connection_db.db_user,connection_db.user_d ,connection_db.pass_d);
                //    conn = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
                //   String query="update faculity set password=" + jpasswordf.getText()+ " where username= "+ backupusername+"&& phone_no= "+ backupphoneno;
                if(first_page.who.equals("faculity"))
                    query="update faculity set password=? where username=? && phone_no=?";
                else
                    query="update student set password=? where username=? && phone_no=?";
                    
                // query="update faculity set password=? where username=? && phone_no=?";
                 pstmt = conn.prepareStatement(query);
                 pstmt.setString(1, jpasswordf.getText());
                 pstmt.setString(2, backupusername);
                 pstmt.setString(3, backupphoneno);
                //   Statement st=conn.createStatement();
                 pstmt.executeUpdate();
                  j=0;
                System.out.println("fsd");
                JOptionPane.showMessageDialog(null, "Password change","Successful",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e)
            {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Something went Wrong","Error",JOptionPane.ERROR_MESSAGE);
            }    
            
        }
        if( !jpasswordf.getText().equals(jretypepasswordf.getText()))
        {
            JOptionPane.showMessageDialog(null, "Both Password not matched","Error",JOptionPane.ERROR_MESSAGE);
            
        }
        jpasswordf.setText("");
        jretypepasswordf.setText("");
       
            
        
       
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
