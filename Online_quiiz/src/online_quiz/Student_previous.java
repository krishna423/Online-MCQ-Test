/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import java.awt.Color;
import static java.awt.Color.RED;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.management.Query.value;
import static javax.management.Query.value;

/** 
 * FXML Controller class
 *
 * @author root
 */
public class Student_previous implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label ques;

    @FXML
    private Label qno;
    @FXML
    private Button bb;

    @FXML
    private Label opt1;

    @FXML
    private Label opt2;

    @FXML
    private Label opt3;

    @FXML
    private Label opt4;

    @FXML
    private Label ans;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private MenuBar menuuser;

    int row=0;
    Button btn[]=new Button[100];
    String qu[]=new String[100];
    String o1[]=new String[100];
    String o2[]=new String[100];
    String o3[]=new String[100];
    String o4[]=new String[100];
    String an[]=new String[100];
    
    private void jb1MousePressed(ActionEvent evt,int p) {                                    
        // TODO add your handling code here:
       // int i=(int)a;
       if(row==p){}
       else{
            btn[p].setStyle("-fx-background-color: #3b6fd6;");
            if(row>0)
                btn[row].setStyle("-fx-background-color: #ffffff;");
        }
        ques.setText(qu[p]);
        opt1.setText(o1[p]);
        opt2.setText(o2[p]);
        opt3.setText(o3[p]);
        System.out.println(qu[p]);
        opt4.setText(o4[p]);
        ans.setText(an[p]);
        row=p;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent -> funback());
       mt2.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       menuuser.getMenus().addAll(me);
       
       
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
                
                
                btn[i]=new Button();
                btn[i].setShape(new Circle(r));
                btn[i].setMinSize(2*r, 2*r);
                btn[i].setMaxSize(2*r, 2*r);
                btn[i].setFont(Font.font(12));
                btn[i].setStyle("-fx-text-fill: black" );
                //ab.setStyle("-fx-background-color: #3b6fd6;" + "-fx-text-fill: white ;");
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
           }
       }
       catch(Exception e){}
    }    
    
    public void funback(){
        try{      
                    Stage stage = (Stage) bb.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student_after_login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    
                    }catch(Exception eee){
                    System.out.println("error");
                    }
         
       
    }
    public void funlogout(){
        try{      
                    Stage stage = (Stage) bb.getScene().getWindow();
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
