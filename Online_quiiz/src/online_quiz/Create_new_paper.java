/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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



public class Create_new_paper implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label jlbl;
    @FXML
    private JFXTextField qq;
    @FXML
    private JFXTextField qq1;

    @FXML
    private JFXTextField op1;

    @FXML
    private JFXTextField op2;

    @FXML
    private JFXTextField op3;

    @FXML
    private JFXTextField op4;

    @FXML
    private JFXTextField ans;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton eee;
    @FXML
    private JFXComboBox<?> cmbans;

    @FXML
    private MenuBar menuuser;
    

    List<String> option = new ArrayList<String>();
    public static int create_row=1;
    @FXML
    void btnadd(ActionEvent event) {
        create_row=first_page.add_ques_row;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String table=first_page.paper_name;
        //String table="2017_04_28__PPL_End ";
        if(!qq.getText().equals("") && !op1.getText().equals("") && !op2.getText().equals("") && !op4.getText().equals("") && cmbans.getValue()!=null){
            try{
                    conn=connection_db.connection();
                    String query="insert into "+ table +"(question,opt1,opt2,opt3,opt4,ans)"+"values"+"(?,?,?,?,?,?)";
                    pstmt = conn.prepareStatement(query);
                    String aa=qq.getText()+"@"+qq1.getText();
                    if(qq1.getText().equals(""))
                       aa=qq.getText();
                    pstmt.setString(1, aa);
                    pstmt.setString(2, op1.getText());
                    pstmt.setString(3, op2.getText());
                    pstmt.setString(4, op3.getText());
                    pstmt.setString(5, op4.getText());
                    pstmt.setString(6, cmbans.getValue().toString());
                    pstmt.executeUpdate();
                    create_row++;
                    JOptionPane.showMessageDialog(null, "Question added","Successful ",JOptionPane.INFORMATION_MESSAGE);
                    qq.setText("");
                    qq1.setText("");
                    op1.setText("");
                    op2.setText("");
                    op3.setText("");
                    op4.setText("");
                    cmbans.setValue(null);
                    jlbl.setText("Q_no"+create_row);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Server Error","error ",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        else{
                JOptionPane.showMessageDialog(null, "fill all","error ",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        
    }

    @FXML
    void btneee(ActionEvent event) {
        Stage stage = (Stage) eee.getScene().getWindow();
      
      try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("after_login.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage sta1 = new Stage();
                sta1.setScene(new Scene(root1));  
                sta1.show();
                stage.close();
      }catch(Exception ee){}
        

    }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        jlbl.setText("Q_no"+first_page.add_ques_row);
        option.add("1");
        option.add("2");
        option.add("3");
        option.add("4");
        ObservableList obList = FXCollections.observableList(option);
       cmbans.setItems(obList);
       
        Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent -> funback());
       mt2.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       
       menuuser.getMenus().addAll(me);
       
    } 
    public void funback(){
        try{      
                    Stage stage = (Stage) add.getScene().getWindow();
                    if(first_page.modify_back==0){
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("New_paper_type.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage.close();
                        sta1.setTitle("PAPER TITLE");
                    }
                    else{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modify_paper.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage.close();
                        sta1.setTitle("MODIFY PAPER");
                    }
                    }catch(Exception eee){
                    System.out.println("error");
                    }
         
       
    }
    public void funlogout(){
        try{      
                    Stage stage = (Stage) add.getScene().getWindow();
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
