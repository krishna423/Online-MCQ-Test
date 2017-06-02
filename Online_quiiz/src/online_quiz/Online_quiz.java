/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Online_quiz extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("first_page.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("Result.fxml")); 
       Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ONLINE QUIZ PORTAl");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn =connection_db.connection();  
        if(connection_db.con_inf==1){
            JOptionPane.showMessageDialog(null, "Connection establised","Successfully",JOptionPane.INFORMATION_MESSAGE);
           launch(args);
        }
        else{
            System.exit(0);
        }
    }
    
}
