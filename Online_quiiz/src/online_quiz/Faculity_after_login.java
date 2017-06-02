/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author root
 */
public class Faculity_after_login implements Initializable {
  
    /**
     * Initializes the controller class.
     */
    public static String paper_name="";
    @FXML
    private JFXComboBox<?> cmbyear;

    @FXML
    private JFXButton refresh;

    @FXML
    private JFXComboBox<?> cmbname;

    @FXML
    private JFXRadioButton jRadionew;

    @FXML
    private JFXRadioButton jRadioedit;

    @FXML
    private JFXRadioButton jRadioold;
    @FXML
    private JFXButton jbtnsubmit;
    @FXML
    private MenuBar menuuser;
      @FXML
    private Label yyy;

    @FXML
    private Label ppp;

     
     @FXML
    void jbtnnew(ActionEvent event) {
        refresh.setVisible(false);
        cmbyear.setVisible(false);
        cmbname.setVisible(false);
        yyy.setVisible(false);
        ppp.setVisible(false);

    }

    @FXML
    void jbtnown(ActionEvent event) {
        refresh.setVisible(true);
        cmbyear.setVisible(true);
        cmbname.setVisible(true);
        yyy.setVisible(true);
        ppp.setVisible(true);
    }

    @FXML
    void jbtnread(ActionEvent event) {
        refresh.setVisible(true);
        cmbyear.setVisible(true);
        cmbname.setVisible(true);
        yyy.setVisible(true);
        ppp.setVisible(true);
    }

    List<String> nn = new ArrayList<String>();
    @FXML
    void jbtnrefresh(ActionEvent event) {
        PreparedStatement pstmt = null;
        ResultSet rst=null;
        String teacher="";
        nn.removeAll(nn);
        cmbname.getItems().removeAll();
       
        if(cmbyear.getValue()==null)
            JOptionPane.showMessageDialog(null, "Select any year","Error ",JOptionPane.ERROR_MESSAGE);
        else{
           
           try{
               Connection conn =connection_db.connection();
               String sort=(String)cmbyear.getValue();
               if(sort.equals("All"))
                    sort="_";
               sort=sort+"%";
               System.out.println(sort);
                teacher=first_page.logged_user;
                String quer = "select * from faculity_access where creator=? || paper_name like ?";
                pstmt=conn.prepareStatement(quer);
                pstmt.setString(1,teacher);
                pstmt.setString(2,sort);
                rst=pstmt.executeQuery();
                while(rst.next()){
                   nn.add(rst.getString(2));
                }
                ObservableList ob = FXCollections.observableList(nn);
                cmbname.setItems(ob);
                
               
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null, "server error","Error ",JOptionPane.ERROR_MESSAGE);
           }
        }

    }


      @FXML
    void jbtnsubmit(ActionEvent event) {
        if(!jRadionew.isSelected() && jRadioedit.isSelected() && !jRadioold.isSelected()){
           System.out.println("edit");
           if(cmbname.getValue()==null)
                JOptionPane.showMessageDialog(null, "Select any paper","Error ",JOptionPane.ERROR_MESSAGE);
           else{ 
                paper_name=cmbname.getValue().toString();
                try{
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modify_paper.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    sta1.setTitle("MODIFY PAPER");
                }catch(Exception ee){}
            }
        }
        else if(!jRadionew.isSelected() && !jRadioedit.isSelected() && jRadioold.isSelected()){
           System.out.println("old");
           if(cmbname.getValue()==null)
                JOptionPane.showMessageDialog(null, "Select anyone","Error ",JOptionPane.ERROR_MESSAGE);
           else{ 
               paper_name=cmbname.getValue().toString();
               System.out.println(paper_name);
                try{
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Previous.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    sta1.setTitle("PREVIOUS PAPER");
                }catch(Exception ee){}
            }
        }
        else if(jRadionew.isSelected() && !jRadioedit.isSelected() && !jRadioold.isSelected()){
            try{
                Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("New_paper_type.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage sta1 = new Stage();
                sta1.setScene(new Scene(root1));  
                sta1.show();
                stage.close();
                sta1.setTitle("PAPER TITLE");
              }catch(Exception ee){}  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select anyone","Error ",JOptionPane.ERROR_MESSAGE);
        }     
 }
    
    
    
    
    
    
    
    
  
 
    
    
    
     List<String> yy = new ArrayList<String>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent -> func());
       mt2.setOnAction(actionEvent -> func());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       
       menuuser.getMenus().addAll(me);
       yy.add("All");
       yy.add("2015");
       yy.add("2016");
       yy.add("2017");
       yy.add("2018");
       yy.add("2019");
       yy.add("2020");
       yy.add("2021");
       yy.add("2022");
       ObservableList obList = FXCollections.observableList(yy);
       cmbyear.setItems(obList);
            
    }    
    
    public void func(){
        try{      
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    sta1.setTitle("LOGIN");
                    }catch(Exception eee){
                    System.out.println("error");
                    }
         
       
    }
    
}
