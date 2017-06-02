/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maurya
 */
public class Answer_key implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label msg;
    @FXML
    private Label attempt;

    @FXML
    private Label right;

    @FXML
    private Label wrong;

    @FXML
    private Label notattempt;

    @FXML
    private MenuBar menuuser;
     @FXML
    private JFXButton temp;
     @FXML
    private VBox v1;

    @FXML
    private VBox v2;

    @FXML
    private VBox v3;
    @FXML
    private VBox v4;
    Label l[]=new Label[50];
    Label ll[]=new Label[50];
    Label lll[]=new Label[50];
    Label llll[]=new Label[50];
    String y_ans[]=new String[50];
    String ans[]=new String[50];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       int ans_flag=0,y_ans_flag=0,i=0,j=0;
       Menu me=new Menu( first_page.logged_user);
       MenuItem mt1=new MenuItem(" Back ");
       MenuItem mt2=new MenuItem(" Log Out ");
       MenuItem mt3=new MenuItem(" Exit ");
       mt1.setOnAction(actionEvent -> funback());
       mt2.setOnAction(actionEvent -> funlogout());
       mt3.setOnAction(actionEvent -> System.exit(0));
       me.getItems().addAll(mt1,mt2,mt3);
       menuuser.getMenus().addAll(me);
       
        ResultSet rst = null;
        PreparedStatement pstmt = null;
        try{
            for(i=0;i<30;i++)
                    y_ans[i]="";
            Connection conn=connection_db.connection();
            String qry="select * from  marks_list where username=? and paper=?";
            pstmt = conn.prepareStatement(qry);
            pstmt.setString(1,first_page.logged_user);
            pstmt.setString(2,Student_after_login.backup_paper_name);
            //pstmt.setString(1,"pppp");
            //pstmt.setString(2,"2017_05_30__java_java");
            rst=pstmt.executeQuery();
            while(rst.next()){
                y_ans_flag=1;
                for(i=1;i<=30;i++){
                        y_ans[i]=rst.getString(i+3);
                        if(y_ans[i].equals("0"))
                            y_ans[i]="";
                    //System.out.println(rst.getString(i+3) ); 
                }
            }
            
        }catch(Exception e){
                System.out.println("asdd  sql");
                
        }
        
        j=1;
        
        try{
                Connection conn=connection_db.connection();
                String query="select * from  "+Student_after_login.backup_paper_name;
                //String query="select * from  2017_05_30__java_java";
                pstmt = conn.prepareStatement(query);
                rst=pstmt.executeQuery();
                while(rst.next()){
                    ans_flag=1;
                    ans[j]=rst.getString(7);
                    //System.out.println(ans[i]);
                    j++;
               }
        }
        catch(Exception ee){
            System.out.println(ee);
        }
       
        
      
     //  Image image = new Image(getClass().getResourceAsStream("right.png"));
             
       int sc=0,wr=0; 
       System.out.println(j+"   "+y_ans_flag+"   "+ ans_flag);
       if(ans_flag==1){
            for(i=0;i<j;i++){
                l[i]=new Label();
                l[i].setFont(Font.font(20));
                l[i].setStyle("-fx-border-color: #000000");
                l[i].setText("  "+i);
                l[i].setVisible(true);
                l[i].setMaxSize(110, 30);
                ll[i]=new Label();
                ll[i].setFont(Font.font(20));
                ll[i].setStyle("-fx-border-color: #000000");
                ll[i].setText(" "+ans[i]);
                ll[i].setVisible(true);
                ll[i].setMaxSize(110, 30);
                lll[i]=new Label();
                lll[i].setFont(Font.font(20));
                lll[i].setStyle("-fx-border-color: #000000");
                lll[i].setText(""+y_ans[i]);
                lll[i].setVisible(true);
                lll[i].setMaxSize(110, 30);
                llll[i]=new Label();
                llll[i].setFont(Font.font(20));
                llll[i].setStyle("-fx-border-color: #000000");
                //    if(Solve_paper.an[i]==Solve_paper.yourans[i])
                //     llll[i].setStyle("-fx-background-color: #1a0eff;" + "-fx-border-color: #000000");
                llll[i].setVisible(true);
                llll[i].setMaxSize(70, 25);
                if(i==0){
                    l[i].setFont(Font.font(20));
                    ll[i].setFont(Font.font(20));
                    lll[i].setFont(Font.font(20));
                    l[i].setText("  Q no");
                    ll[i].setText(" Answers  ");
                    lll[i].setText(" Your Ans ");
                    llll[i].setText(" Rem.");
                }
                //    llll[i].setGraphic(new ImageView(image));
                if(i>0){
                    if(y_ans[i]==""){  }
                    else if(ans[i].equals(y_ans[i])){
                        ImageView img1 = new ImageView("/background/right.png");
                        img1.setFitWidth(60);  
                        img1.setFitHeight(25);
                        llll[i].setGraphic(img1);
                        sc++;
                    }
                    else{
                        ImageView img = new ImageView("/background/a.png");
                        img.setFitWidth(60);  
                        img.setFitHeight(25);
                        llll[i].setGraphic(img);
                        wr++;
                    }
                }
                       
           v1.setSpacing(.1);
           v2.setSpacing(.1);
           v3.setSpacing(.1);
           v4.setSpacing(.1);
           v1.getChildren().add(l[i]);
           v2.getChildren().add(ll[i]);
           v3.getChildren().add(lll[i]);
           v4.getChildren().add(llll[i]);
           }
            
            if(y_ans_flag==0){
                msg.setText("You have not Solve this Paper.");
                
                //v3.setVisible(false);
                //v4.setVisible(false);
            }else{
                attempt.setText("Attempt - "+(sc+wr));
                notattempt.setText("Not Attempt - "+(j-(sc+wr)));
                right.setText("Score - "+sc);
                wrong.setText("Wrong - "+wr);

                attempt.setVisible(true);
                notattempt.setVisible(true);
                right.setVisible(true);
                wrong.setVisible(true);
            }
        }
   
    
       
       
       
    }   
     
    public void funback(){
        try{      
            
                    Stage stage = (Stage) temp.getScene().getWindow();
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
                    Stage stage = (Stage) temp.getScene().getWindow();
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
