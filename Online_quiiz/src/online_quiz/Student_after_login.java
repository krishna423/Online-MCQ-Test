/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author root
 */
public class Student_after_login implements Initializable {
    List<String> year = new ArrayList<String>();
    List<String> sol = new ArrayList<String>();
    List<String> pra = new ArrayList<String>();
    List<String> key = new ArrayList<String>();
    List<String> state = new ArrayList<String>();
    List<String> previous = new ArrayList<String>();
    public static int sol_pra_flag=0;    //     1 solve      2 practice
    public static String backup_paper_name="";
    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXRadioButton jRadiosol;

    @FXML
    private ToggleGroup my;

    @FXML
    private JFXRadioButton jRadiopra;

    @FXML
    private JFXRadioButton jRadioread;

    @FXML
    private JFXButton jbtnsubmit;

    @FXML
    private JFXComboBox<?> solyear;

    @FXML
    private JFXComboBox<?> prayear;

    @FXML
    private JFXRadioButton jRadiokey;

    @FXML
    private ToggleGroup my1;

    @FXML
    private JFXButton solupdate;

    @FXML
    private JFXComboBox<?> solpaper;

    @FXML
    private JFXButton praupdate;

    @FXML
    private JFXComboBox<?> prapaper;

    @FXML
    private JFXComboBox<?> keyyear;

    @FXML
    private JFXButton keyupdate;

    @FXML
    private JFXComboBox<?> keypaper;
    @FXML
    private JFXButton back;

    @FXML
    private JFXButton logout;
     @FXML
    private JFXComboBox<?> previousyear;

    @FXML
    private JFXButton previousupdate;

    @FXML
    private JFXComboBox<?> previouspaper;
    @FXML
    private MenuBar menuuser;
   
    
        @FXML
    void btnjRadiokey(ActionEvent event) {
        previousyear.setVisible(false);
        keyyear.setVisible(true);
        solyear.setVisible(false);
        prayear.setVisible(false);
        previousupdate.setVisible(false);
        keyupdate.setVisible(true);
        solupdate.setVisible(false);
        praupdate.setVisible(false);
        previouspaper.setVisible(false);
        keypaper.setVisible(true);
        solpaper.setVisible(false);
        prapaper.setVisible(false);
        
    }

    @FXML
    void btnjRadiopra(ActionEvent event) {
        previousyear.setVisible(false);
        keyyear.setVisible(false);
        solyear.setVisible(false);
        prayear.setVisible(true);
        previousupdate.setVisible(false);
        keyupdate.setVisible(false);
        solupdate.setVisible(false);
        praupdate.setVisible(true);
        previouspaper.setVisible(false);
        keypaper.setVisible(false);
        solpaper.setVisible(false);
        prapaper.setVisible(true);
        
    }

    @FXML
    void btnjRadioread(ActionEvent event) {
        previousyear.setVisible(true);
        keyyear.setVisible(false);
        solyear.setVisible(false);
        prayear.setVisible(false);
        previousupdate.setVisible(true);
        keyupdate.setVisible(false);
        solupdate.setVisible(false);
        praupdate.setVisible(false);
        previouspaper.setVisible(true);
        keypaper.setVisible(false);
        solpaper.setVisible(false);
        prapaper.setVisible(false);
    }

    @FXML
    void btnjRadiosol(ActionEvent event) {
        previousyear.setVisible(false);
        keyyear.setVisible(false);
        solyear.setVisible(true);
        prayear.setVisible(false);
        previousupdate.setVisible(false);
        keyupdate.setVisible(false);
        solupdate.setVisible(true);
        praupdate.setVisible(false);
        previouspaper.setVisible(false);
        keypaper.setVisible(false);
        solpaper.setVisible(true);
        prapaper.setVisible(false);
        
    }
    @FXML
    void jbtnpreviousupdate(ActionEvent event) {
        previouspaper.getItems().removeAll(previous);
        if(previousyear.getValue()!=null){
            PreparedStatement pstmt = null;
            ResultSet rst=null;
            try{
                Connection conn =connection_db.connection();
                String sort=(String)previousyear.getValue().toString();
                if(sort.equals("All"))
                    sort="_";
                sort=sort +"%";
                System.out.println(sort);
         //       String quer = "select * from faculity_access where paper_name like ? && ans_time<=current_time() && rls_date<=current_date()";
                String quer ="select * from faculity_access where paper_name like ? && (rls_date < current_date() || ( rls_date = current_date() && ans_time <= current_time() )) order by paper_name"; 
                pstmt=conn.prepareStatement(quer);
                pstmt.setString(1,sort);
               rst=pstmt.executeQuery();
                while(rst.next()){
                //    System.out.println(rst.getString(2));
                    previous.add(rst.getString(2));
                }
                ObservableList obListprevious = FXCollections.observableList(previous);
                previouspaper.setItems(obListprevious);
            }
            
            catch(Exception ee){
                JOptionPane.showMessageDialog(null, "Connection Error","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
            
        
        }else{
            JOptionPane.showMessageDialog(null, "Choose any Year","Error ",JOptionPane.ERROR_MESSAGE);
        }

        

    }
   
    
    
    @FXML
    void jbtnkeyupdate(ActionEvent event) {
        keypaper.getItems().removeAll(key);
        if(keyyear.getValue()!=null){
            PreparedStatement pstmt = null;
            ResultSet rst=null;
            try{
                Connection conn =connection_db.connection();
                String sort=(String)keyyear.getValue().toString();
                if(sort.equals("All"))
                    sort="_";
                sort=sort +"%";
                System.out.println(sort);
         //       String quer = "select * from faculity_access where paper_name like ? && ans_time<=current_time() && rls_date<=current_date()";
                String quer ="select * from faculity_access where paper_name like ? && (rls_date < current_date() || ( rls_date = current_date() && ans_time <= current_time() )) order by paper_name "; 
                pstmt=conn.prepareStatement(quer);
                pstmt.setString(1,sort);
               rst=pstmt.executeQuery();
                while(rst.next()){
                //    System.out.println(rst.getString(2));
                    key.add(rst.getString(2));
                }
                ObservableList obListkey = FXCollections.observableList(key);
                keypaper.setItems(obListkey);
            }
            
            catch(Exception ee){
                JOptionPane.showMessageDialog(null, "Connection Error","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
            
        
        }else{
            JOptionPane.showMessageDialog(null, "Choose any Year","Error ",JOptionPane.ERROR_MESSAGE);
        }

    

    }

    @FXML
    void jbtnpraupdate(ActionEvent event) {
        prapaper.getItems().removeAll(pra);
        if(prayear.getValue()!=null){
            PreparedStatement pstmt = null;
            ResultSet rst=null;
            try{
                Connection conn =connection_db.connection();
                String sort=(String)prayear.getValue().toString();
                if(sort.equals("All"))
                    sort="_";
                sort=sort +"%";
                System.out.println(sort);
               // String quer = "select * from faculity_access where paper_name like ? && ans_time<=current_time() && rls_date<=current_date()";
               String quer ="select * from faculity_access where paper_name like ? && (rls_date < current_date() || ( rls_date = current_date() && ans_time <= current_time() ))order by paper_name ";  
               pstmt=conn.prepareStatement(quer);
               pstmt.setString(1,sort);
               rst=pstmt.executeQuery();
               while(rst.next()){
                //    System.out.println(rst.getString(2));
                    pra.add(rst.getString(2));
                }
                ObservableList obListpra = FXCollections.observableList(pra);
                prapaper.setItems(obListpra);
            }
            
            catch(Exception ee){
            }
            
            
        
        }else{
        JOptionPane.showMessageDialog(null, "Choose any Year","Error ",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

    @FXML
    void jbtnsolupdate(ActionEvent event) {
        solpaper.getItems().removeAll(sol);
        if(solyear.getValue()!=null){
            PreparedStatement pstmt = null;
            ResultSet rst=null;
            try{
                Connection conn =connection_db.connection();
                String sort=(String)solyear.getValue().toString();
                if(sort.equals("All"))
                    sort="_";
                sort=sort +"%";
                System.out.println(sort);
                String quer ="select * from faculity_access where paper_name like ? && (rls_date > current_date() || ( rls_date = current_date() && ans_time > current_time() )) order by paper_name ";
                pstmt=conn.prepareStatement(quer);
                pstmt.setString(1,sort);
                rst=pstmt.executeQuery();
                while(rst.next()){
                //    System.out.println(rst.getString(2));
                    sol.add(rst.getString(2));
                }
                ObservableList obListsol = FXCollections.observableList(sol);
                solpaper.setItems(obListsol);
            }
            
            catch(Exception ee){
            }
            
            
        
        }else{
        JOptionPane.showMessageDialog(null, "Choose any Year","Error ",JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    void jbtnsubmit(ActionEvent event) {
        PreparedStatement pstmt = null;
        ResultSet rst=null;
        backup_paper_name="";
        if(jRadioread.isSelected()){
            if(previouspaper.getValue()==null)
                JOptionPane.showMessageDialog(null, "Select anyone","Error ",JOptionPane.ERROR_MESSAGE);
           else{ 
                try{
                    backup_paper_name=previouspaper.getValue().toString();    
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student_previous.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    
                    stage.close();
                    sta1.setTitle("PREVIOUS PAPER");
                }catch(Exception ee){}
            }
        }
        
        else if(jRadiokey.isSelected()){
            if(keypaper.getValue()==null)
                JOptionPane.showMessageDialog(null, "Select anyone","Error ",JOptionPane.ERROR_MESSAGE);
           else{ 
                try{
                        backup_paper_name=keypaper.getValue().toString();
                        Stage stage1 = (Stage) jbtnsubmit.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Answer_key.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage1.close();
                        sta1.setTitle("ANSWER KEY");
                }catch(Exception e){
                
                }
            }
        }
        
        else if(jRadiosol.isSelected()){
            int sol_flag=0;
            Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
            if(solyear.getValue()!=null){
                try{
                    backup_paper_name=solpaper.getValue().toString();
                    Connection co=connection_db.connection();
                    String query="insert into marks_list " +"(username,paper,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30)"+"values"+"(?,?,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
                    //    conn = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
                    pstmt = co.prepareStatement(query);
                    pstmt.setString(1, first_page.logged_user);
                    pstmt.setString(2, backup_paper_name);
                    pstmt.executeUpdate();
                    sol_flag=1;
                }catch(Exception dd){
                    System.out.println(dd);
                    try{
                        Connection conn=connection_db.connection();
                        //co = DriverManager.getConnection(connection_db.db_marks, connection_db.user_d, connection_db.pass_d);
                        String query="select * from marks_list where username =? && paper =?";
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, first_page.logged_user);
                        pstmt.setString(2, backup_paper_name);
                        rst=pstmt.executeQuery();
                        while(rst.next()){
                            sol_flag=1;
                        }
                    }catch(Exception asd){
                        System.out.println(asd);
                        JOptionPane.showMessageDialog(null, "Something Went Wrong","Error ",JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(sol_flag==1){
                try{
                        sol_pra_flag=1;
                        backup_paper_name=solpaper.getValue().toString();
                        Stage stage1 = (Stage) jbtnsubmit.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Solve_paper.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage1.close();
                        sta1.setTitle("Solve PAPER");
                }catch(Exception e){}
                }
            }    
            else{
                JOptionPane.showMessageDialog(null, "Choose any paper","Error ",JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        else if(jRadiopra.isSelected()){
            try{
                        sol_pra_flag=2;
                        backup_paper_name=prapaper.getValue().toString();
                        Stage stage1 = (Stage) jbtnsubmit.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Practise.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage sta1 = new Stage();
                        sta1.setScene(new Scene(root1));  
                        sta1.show();
                        stage1.close();
                        sta1.setTitle("PRACTICE PAPER");
                }catch(Exception e){
                
                }
                
            
            
        }
            
        else{
        JOptionPane.showMessageDialog(null, "Choose any Year","Error ",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        

    }


 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setStyle("-fx-background-radius: 100" ); 
      // mt1.setStyle("-fx-background-color: #0c00ff" );
       mt1.setOnAction(actionEvent -> funback());
       mt2.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       menuuser.getMenus().addAll(me);
        
        year.add("All");
        year.add("2017");
        year.add("2018");
        year.add("2019");
        year.add("2020");
        year.add("2021");
        year.add("2022");
        year.add("2023");
        year.add("2024");
        ObservableList obList = FXCollections.observableList(year);
        solyear.setItems(obList);
        prayear.setItems(obList);
        keyyear.setItems(obList);
        previousyear.setItems(obList);
        
        
        
    }   
    
    
    public void funback(){
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
    public void funlogout(){
        try{      
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));
                    sta1.setTitle("LOGIN");
                    sta1.show();
                    stage.close();
                    }catch(Exception eee){
                    System.out.println("error");
                    }
         
       
    }
    
}
