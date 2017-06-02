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
 *
 * @author root
 */
public class Login implements Initializable {
    @FXML
    private JFXTextField jfldUsername;
    @FXML
    private JFXPasswordField jfldPassword;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton register;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("first_page.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage sta1 = new Stage();
            sta1.setScene(new Scene(root1));  
            sta1.show();
            sta1.setTitle("ONLINE QUIZ PORTAL");
            stage.close();
        }
        catch(Exception ee){}
        
    }
    
    @FXML
    void jbtnLogin(ActionEvent event) {
        String Username=jfldUsername.getText();
        first_page.logged_user=Username;
        String Password=jfldPassword.getText();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String query="";
             try{
                int i=0;
                Connection conn = connection_db.connection();
                if(first_page.who.equals("faculity"))
                    query="select * from  faculity where username=? and password=?";
                else
                    query="select * from  student where username=? and password=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1,jfldUsername.getText());
                pstmt.setString(2,jfldPassword.getText());
                rs=pstmt.executeQuery();
                while(rs.next())
                {
                    i=2;
                }
                if(i==2){
                    
                    jfldUsername.setText(null);
                    jfldPassword.setText(null);
                    try{
                        Stage stage = (Stage) login.getScene().getWindow();
                        FXMLLoader fxmlLoader;
                        if(first_page.who.equals("faculity")){
                            fxmlLoader = new FXMLLoader(getClass().getResource("Faculity_after_login.fxml"));
                        }
                        else{
                            fxmlLoader = new FXMLLoader(getClass().getResource("Student_after_login.fxml"));
                        }
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage.close();
                    }
                    catch(Exception ee){}
                     
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
                   
                }
            
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, "Server Connection error","Error",JOptionPane.ERROR_MESSAGE);
           
            }
        jfldUsername.setText(null);
        jfldPassword.setText(null);
    }
    
    @FXML
    void jbtnRegister(ActionEvent event) {
      try{
            Stage stage = (Stage) register.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage sta1 = new Stage();
            sta1.setScene(new Scene(root1));  
            sta1.show();
            stage.close();
        }
        catch(Exception ee){}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
