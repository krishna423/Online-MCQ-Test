/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.management.Query.value;
import javax.swing.JOptionPane;

/** 
 * FXML Controller class
 *
 * @author root
 */
public class Modify_paper implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField ques;

    @FXML
    private Label qno;
    @FXML
    private Button update;
    @FXML
    private Button add;

    @FXML
    private JFXTextField opt1;

    @FXML
    private JFXTextField opt2;

    @FXML
    private JFXTextField opt3;

    @FXML
    private JFXTextField opt4;

    @FXML
    private Label ans;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private MenuBar menuuser;
    @FXML
    void btnadd(ActionEvent event){
        try{      
                    Stage stage = (Stage) add.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Create_new_paper.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage sta1 = new Stage();
                    sta1.setScene(new Scene(root1));  
                    sta1.show();
                    stage.close();
                    first_page.modify_back=1;
                    first_page.paper_name=Faculity_after_login.paper_name;
                    sta1.setTitle("ADD NEW QUESTION");
            }catch(Exception eee){
                    System.out.println("error");
            }
    
    }
     @FXML
    private JFXComboBox<?> cmbans;
     Button btn[]=new Button[100];
    String qu[]=new String[100];
    String o1[]=new String[100];
    String o2[]=new String[100];
    String o3[]=new String[100];
    String o4[]=new String[100];
    String an[]=new String[100];
    String yourans[]=new String[100];
    int row=0;
     @FXML
    void btnupdate(ActionEvent event) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try{
            Connection conn = connection_db.connection();
            String query="update "+Faculity_after_login.paper_name+" set question =?, opt1=?, opt2=?, opt3=?, opt4=?, ans=? where Q_no= "+row;
        //    String query="update  2017_04_28__PPL_End set question =?, opt1=?, opt2=?, opt3=?, opt4=?, ans=? where Q_no= "+row;
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ques.getText());
            pstmt.setString(2, opt1.getText());
            pstmt.setString(3, opt2.getText());
            pstmt.setString(4, opt3.getText());
            pstmt.setString(5, opt4.getText());
            pstmt.setString(6, cmbans.getValue().toString());
            pstmt.executeUpdate();
            qu[row]=ques.getText();
            o1[row]=opt1.getText();
            o2[row]=opt2.getText();
            o3[row]=opt3.getText();
            o4[row]=opt4.getText();
            an[row]=cmbans.getValue().toString();
            ans.setText(an[row]);
            cmbans.setValue(null);
            JOptionPane.showMessageDialog(null, "question successfully updated","Success ",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, "Update Error","Error ",JOptionPane.ERROR_MESSAGE);
        }
        
    }

    
    
    private void jb1MousePressed(ActionEvent evt,int p) {                                    
        // TODO add your handling code here:
        // int i=(int)a;\
        btn[p].setStyle("-fx-background-color: #3b6fd6;");
        if(row>0)
            btn[row].setStyle("-fx-background-color: #ffffff;");
        ques.setText(qu[p]);
        opt1.setText(o1[p]);
        opt2.setText(o2[p]);
        opt3.setText(o3[p]);
        System.out.println(qu[p]);
        opt4.setText(o4[p]);
        ans.setText(an[p]);
        row=p;
    }
     List<String> nn = new ArrayList<String>();
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
       
       
       nn.add(""+1);
       nn.add(""+2);
       nn.add(""+3);
       nn.add(""+4);
       ObservableList ob = FXCollections.observableList(nn);
       cmbans.setItems(ob);
       
       
       
       PreparedStatement pstmt = null;
       ResultSet rst=null;
       int i=1,k=0;
       double r=17;
       try{
           Connection conn = connection_db.connection();
          String quer = "select * from " +Faculity_after_login.paper_name;
          System.out.println(Faculity_after_login.paper_name);
          // String quer = "select * from 2017_04_28__PPL_End ";
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
               first_page.add_ques_row=i;
           }
       }
       catch(Exception e){}
    }    
    
    public void funback(){
        try{      
                    Stage stage = (Stage) update.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculity_after_login.fxml"));
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
                    Stage stage = (Stage) update.getScene().getWindow();
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
