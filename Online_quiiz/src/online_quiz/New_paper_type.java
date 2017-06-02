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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author root
 */
public class New_paper_type implements Initializable {
    List<String> list = new ArrayList<String>();
    List<String> mode = new ArrayList<String>();
    List<String> hh = new ArrayList<String>();
    List<String> mm = new ArrayList<String>();
    List<String> state = new ArrayList<String>();
    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXRadioButton manu;
    @FXML
    void jbtnmanu(ActionEvent event) {

    }
    
     @FXML
    private JFXButton jbtnsubmit;
     @FXML
    private JFXTextField jfldsubject;
     

    @FXML
    private JFXTextField jfldmode;
  
    @FXML
    private JFXComboBox<?> starthh;
    @FXML
    private JFXComboBox<?> startmm;
    @FXML
    private JFXComboBox<?> endhh;
    @FXML
    private JFXComboBox<?> endmm;
    

    @FXML
    private JFXComboBox<?> jcbsubjects;

    @FXML
    private JFXComboBox<?> jcbmode;

    @FXML
    private JFXButton jbtnadd;
    @FXML
    private JFXDatePicker time_chose;
   
      static String paper_name="";
      String main_date="";
      String main_pname="";
      String start="";
    @FXML
    private MenuBar menuuser;
    @FXML
    void jbtnsubmit(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pstmt,pst=null;
        Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
        if(time_chose.getValue()!=null &&jcbsubjects.getValue()!=null && jcbmode.getValue()!=null && starthh.getValue()!=null && startmm.getValue()!=null && endhh.getValue()!=null && endmm.getValue()!=null){
            System.out.println("yessssss");
            int i=0,j=0;
           String d="",s_h="",s_m="",e_h="",e_m="",sub="",mod="";
           LocalDate tim=time_chose.getValue();
           d=tim.toString();
           s_h=(String)starthh.getValue();
           s_m=(String)startmm.getValue();
           e_h=(String)endhh.getValue();
           e_m=(String)endmm.getValue();
           sub=(String)jcbsubjects.getValue();
           mod=(String)jcbmode.getValue();
           String dateParts[] = d.split("-");
           String year  = dateParts[0];
           String month  = dateParts[1];
           String day = dateParts[2];    
           System.out.println(month+day+year);
           String main_pname=year+"_"+month+"_"+day+"_"+"_"+sub+"_"+mod;
           
        //   start=h+":"+m+":"+"00";
            try{
                Connection conn = connection_db.connection();
                //      conn = DriverManager.getConnection(connection_db.db_paper,connection_db.user_d ,connection_db.pass_d);
                //    conn = DriverManager.getConnection("jdbc:mysql://localhost/paper", "root", "");
                String query="create table " + main_pname +"(Q_no int(3) primary key not null auto_increment,question varchar(500) not null,opt1 varchar(100) not null,opt2 varchar(100) not null,opt3 varchar(100) not null,opt4 varchar(100) not null,ans varchar(2))";
                pstmt = conn.prepareStatement(query);
                pstmt.executeUpdate();
                first_page.paper_name=main_pname;
                first_page.add_ques_row=1;
                query="insert into faculity_access (paper_name,creator,start_time,ans_time,rls_date)"+"values"+"(?,?,?,?,?)";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1,main_pname);
                //  pstmt.setString(2, FXMLDocumentController.teacher);
                pstmt.setString(2, first_page.logged_user);
                pstmt.setString(3, s_h+":"+s_m+":00");
                pstmt.setString(4, e_h+":"+e_m+":00");
                pstmt.setString(5, d);
                pstmt.executeUpdate();
                try{
                    FXMLLoader fxmlLoader;
                    if(manu.isSelected()){
                        fxmlLoader = new FXMLLoader(getClass().getResource("Create_new_paper.fxml"));
                        first_page.modify_back=0;
                        first_page.add_ques_row=1;
                    }
                    else
                    {
                        first_page.modify_back=0;
                        first_page.add_ques_row=1;
                        JOptionPane.showMessageDialog(null, "no Pdf Database faculity add","Error ",JOptionPane.ERROR_MESSAGE); 
                        fxmlLoader = new FXMLLoader(getClass().getResource("Create_new_paper.fxml"));   
                    }
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    }catch(Exception eee){}
          
              
                
            }catch(Exception ee){
                JOptionPane.showMessageDialog(null, "Paper exist","Error ",JOptionPane.ERROR_MESSAGE); 
            }
                              
        }else{
            JOptionPane.showMessageDialog(null, "Fill All Entries","Error ",JOptionPane.ERROR_MESSAGE); 
        }
        
      
    }
    
    
    @FXML
    void jbtnadd(ActionEvent event) {
    if(!jfldsubject.getText().isEmpty()){
        list.add(jfldsubject.getText());
        ObservableList obList = FXCollections.observableList(list);
        jcbsubjects.setItems(obList);
    }
    if(!jfldmode.getText().isEmpty()){
        mode.add(jfldmode.getText());
        ObservableList modeList = FXCollections.observableList(mode);
        jcbmode.setItems(modeList);
    }
        
 }
 
    
    
    
    List<String> log = new ArrayList<String>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.add("Epoc");
        list.add("DAA");
        list.add("SMAT");
        list.add("PPL");
        list.add("DBMS");
        ObservableList obList = FXCollections.observableList(list);
        jcbsubjects.setItems(obList);
        mode.add("Quiz_1");
        mode.add("Quiz_2");
        mode.add("Mid");
        mode.add("End");
        ObservableList modeList = FXCollections.observableList(mode);
        jcbmode.setItems(modeList);
        int i=0;
        for(i=0;i<10;i++){
            hh.add("0"+i);
            mm.add("0"+i);
        }
        for(i=10;i<23;i++){
            hh.add(""+i);
            mm.add(""+i);
        }
        for(i=23;i<60;i++)
            mm.add(""+i);
        state.add("AM");
        state.add("PM");
        ObservableList h_list = FXCollections.observableList(hh);
        ObservableList m_list = FXCollections.observableList(mm);
        ObservableList st = FXCollections.observableList(state);
    //    ObservableList<String> asd = FXCollections.observableArrayList("01");
        starthh.setItems(h_list);
        startmm.setItems(m_list);
        endhh.setItems(h_list);
        endmm.setItems(m_list);
     //  time_chose.setValue(LocalDate.now());
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent ->funback());
       mt3.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       
       menuuser.getMenus().addAll(me);
     
       
    }    
    
    void funback(){
        try{      
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculity_login_after.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    
                    }catch(Exception eee){}
         
       
    }
    void funlogout(){
       try{      
                    Stage stage = (Stage) jbtnsubmit.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    sta1.setTitle(" LOGIN ");
                    }catch(Exception eee){}
         
       
    }
   
}
