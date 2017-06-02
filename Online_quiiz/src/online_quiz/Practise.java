/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import static java.awt.Color.RED;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.management.Query.value;
import javax.swing.JOptionPane;
import static javax.management.Query.value;

/** 
 * FXML Controller class
 *
 * @author root
 */
public class Practise implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField ques;

    @FXML
    private Label qno;
    @FXML
    private Button doubtans;
    @FXML
    private Button finalans;

    @FXML
    private JFXTextField opt1;

    @FXML
    private JFXTextField opt2;

    @FXML
    private JFXTextField opt3;

    @FXML
    private JFXTextField opt4;

    @FXML
    private Label y_ans;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private MenuBar menuuser;
     @FXML
    private JFXButton lock;
     @FXML
    private JFXComboBox<?> cmbans;
     Button btn[]=new Button[100];
    String qu[]=new String[100];
    String o1[]=new String[100];
    String o2[]=new String[100];
    String o3[]=new String[100];
    String o4[]=new String[100];
    public static String an[]=new String[100];
    public static String yourans[]=new String[100];
    int select_ans[]=new int[100]; //0 for initial       1 for doubtful  2 for final 
    int row=-1;
    public static int attempt=0,wrong=0,not_attempt=0,score=0,no_of_ques=0;
     
     @FXML
    void btnlock(ActionEvent event) {
        int count=0;
        for(int j=1;j<=no_of_ques;j++){
            //System.out.println(ans[j] +"" +solve[j]);
            if(yourans[j].equals(""))
            {
                not_attempt++;
            }
            else if(yourans[j].equals(an[j]))
            {
                score++;
            }
            else if(!yourans[j].equals(an[j]))
            {
                wrong++;
            }
            attempt=wrong+score;
        }
            System.out.println(attempt +"  "+wrong+" "+not_attempt+"  "+score);
            try{      
                    Stage stage = (Stage) doubtans.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Result.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));
                    sta1.setTitle("RESULT");
                    sta1.show();
                    stage.close();
                    }catch(Exception eee){
                    System.out.println(eee);
                    }
    }

    
    @FXML
    void btnfinalans(ActionEvent event){
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        if(select_ans[row]==2){
            JOptionPane.showMessageDialog(null, "Sorry, You cann't change final Answer","Error ",JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(row<1){
                JOptionPane.showMessageDialog(null, "Choose Question","Error ",JOptionPane.ERROR_MESSAGE);
            }else{
                if(cmbans.getValue()==null){
                    JOptionPane.showMessageDialog(null, "Choose Answer","Error ",JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        yourans[row]=cmbans.getValue().toString();
                        y_ans.setText(yourans[row]);
                        cmbans.setValue(null);
                        btn[row].setStyle("-fx-background-color: #05fb26;");
                        select_ans[row]=2;
                        JOptionPane.showMessageDialog(null, "Updated successfully","Success ",JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(Student_after_login.backup_paper_name+"   "+row);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Update Error","Error ",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
     @FXML
    void btndoubt(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        if(select_ans[row]==2){
            JOptionPane.showMessageDialog(null, "Sorry, You cann't change final Answer","Error ",JOptionPane.ERROR_MESSAGE);
            }else{
            if(row<1){
                 JOptionPane.showMessageDialog(null, "Choose Question","Error ",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(cmbans.getValue()==null){
                   JOptionPane.showMessageDialog(null, "Choose Answer","Error ",JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        yourans[row]=cmbans.getValue().toString();
                        y_ans.setText(yourans[row]);
                        cmbans.setValue(null);
                        select_ans[row]=1;
                        btn[row].setStyle("-fx-background-color: #f90404;");
                        JOptionPane.showMessageDialog(null, "Updated successfully","Success ",JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(Student_after_login.backup_paper_name+"   "+row);
                    }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Update Error","Error ",JOptionPane.ERROR_MESSAGE);
                    }
                 }
            }
        }
    }

    
    
    private void jb1MousePressed(ActionEvent evt,int p) {                                    
        //  #  blue 1a0eff    green #05fb26  red #f90404   yellow #e4f704
        //       btn[row].setStyle("-fx-text-fill: black");
        if(p==row){
            int  r=17;
            btn[p].setShape(new Rectangle(r,r));
            btn[p].setMinSize(2*r, 2*r);
            btn[p].setMaxSize(2*r, 2*r);
        }
        else{
            if(select_ans[p]==0){
                btn[p].setStyle("-fx-background-color: #1a0eff;");
                if(row>0 && select_ans[row]==0 )
                    btn[row].setStyle("-fx-background-color: #ffffff;");
            
            }
        
            int  r=17;
            btn[p].setShape(new Rectangle(r,r));
            btn[p].setMinSize(2*r, 2*r);
            btn[p].setMaxSize(2*r, 2*r);
            if(row>0){
                 btn[row].setShape(new Circle(r));
                btn[row].setMinSize(2*r, 2*r);
                btn[row].setMaxSize(2*r, 2*r);
            }
        }
        ques.setText(qu[p]);
        opt1.setText(o1[p]);
        opt2.setText(o2[p]);
        opt3.setText(o3[p]);
        System.out.println(qu[p]);
        opt4.setText(o4[p]);
        y_ans.setText(yourans[p]);
        cmbans.setValue(null);
        row=p;
    }
     List<String> nn = new ArrayList<String>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent -> funback());
       mt2.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       menuuser.getMenus().addAll(me);
       
       
       nn.add("1");
       nn.add("2");
       nn.add("3");
       nn.add("4");
       ObservableList ob = FXCollections.observableList(nn);
       cmbans.setItems(ob);
       
       
       
       PreparedStatement pstmt = null;
       ResultSet rst=null;
       int i=1,k=0;
       double r=17;
       try{
           Connection conn = connection_db.connection();
           String quer = "select * from " +Student_after_login.backup_paper_name;
           Statement st=conn.createStatement();
           rst=st.executeQuery(quer);
           while(rst.next()){
                no_of_ques++;
                qu[i]=new String();
                o1[i]=new String();
                o2[i]=new String();
                o3[i]=new String();
                o4[i]=new String();
                an[i]=new String();
                qu[i]=rst.getString(2);
                o1[i]=rst.getString(3);
                o2[i]=rst.getString(4);
                o3[i]=rst.getString(5);
                o4[i]=rst.getString(6);
                an[i]=rst.getString(7);
                yourans[i]="";
                select_ans[i]=0;
                btn[i]=new Button();
                btn[i].setShape(new Circle(r));
                btn[i].setMinSize(2*r, 2*r);
                btn[i].setMaxSize(2*r, 2*r);
                btn[i].setFont(Font.font(12));
                 
               //btn[i].setStyle("-fx-background-color: #e4f704;");
                //btn[i].setStyle("-fx-background-color: #1a0eff;" + "-fx-text-fill: white ;");
                //btn[i].setFocusTraversable(true);
                btn[i].setText(""+i);
                btn[i].setVisible(true);
                vbox1.setSpacing(5);
                vbox2.setSpacing(5);
                int p=i;
                btn[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override 
                    public void handle(ActionEvent e) {
                    System.out.println("scds");
                        jb1MousePressed(e,p);
                    //   fun();
                    }
                });
                if(k==0){
                    vbox1.getChildren().add(btn[i]);
                    k=1;
               }
               else{
                    vbox2.getChildren().add(btn[i]);
                    k=0;
                    
               }
               i++;
            //   first_page.add_ques_row=i;
           }
       }
       catch(Exception e){}
    }    
    
    public void funback(){
        try{      
                    Stage stage = (Stage) doubtans.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student_after_login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    sta1.setTitle("RESULT");
                    stage.close();
                    }catch(Exception eee){
                    System.out.println("error");
                    }
         
       
    }
    public void funlogout(){
        try{      
                    Stage stage = (Stage) doubtans.getScene().getWindow();
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
