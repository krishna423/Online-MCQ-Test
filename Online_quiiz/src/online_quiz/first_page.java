/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author root
 */
public class first_page implements Initializable {
    @FXML
    private JFXButton exit;

    @FXML
    private JFXButton faculity;

    @FXML
    private JFXButton student;

    @FXML
    void btnexit(ActionEvent event) {
        System.exit(0);
    } 
    public static String who="";
    public static String logged_user="";
    public static int add_ques_row=1;
    public static int modify_back=0;
    public static String paper_name="";
    
    
    @FXML
    void btnfaculity(ActionEvent event) {
      who="faculity";
      try{
            Stage stage = (Stage) faculity.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage sta1 = new Stage();
            sta1.setScene(new Scene(root1));
            sta1.setTitle(" LOGIN WINDOW ");
            sta1.show();
            stage.close();
        }
        catch(Exception ee)
        {
            
        }
     
      
       
    }

    @FXML
    void btnstudent(ActionEvent event) {
        who="student";
      try{
            Stage stage = (Stage) student.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage sta1 = new Stage();
            sta1.setScene(new Scene(root1));  
            sta1.show();
            sta1.setTitle(" LOGIN ");
            stage.close();
        }
        catch(Exception ee)
        {}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
