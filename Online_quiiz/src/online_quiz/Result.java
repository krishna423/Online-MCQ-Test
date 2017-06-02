/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_quiz;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
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
public class Result implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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
       
       int no_of_q=0,i=0;
       
       
       if(Student_after_login.sol_pra_flag==1){
            attempt.setText("Attempt - "+Solve_paper.attempt);
            notattempt.setText("Not Attempt - "+Solve_paper.not_attempt);
            right.setText("Score - "+Solve_paper.score);
            wrong.setText("Wrong - "+ Solve_paper.wrong);
            no_of_q=Solve_paper.no_of_ques;
        }
       
       if(Student_after_login.sol_pra_flag==2){
            attempt.setText("Attempt - "+Practise.attempt);
            notattempt.setText("Not Attempt - "+Practise.not_attempt);
            right.setText("Score - "+Practise.score);
            wrong.setText("Wrong - "+ Practise.wrong);
            no_of_q=Practise.no_of_ques;
        }
       
       
       for(i=0;i<=no_of_q;i++){
           l[i]=new Label();
           l[i].setFont(Font.font(20));
           l[i].setStyle("-fx-border-color: #000000");
           l[i].setText("  "+i);
           l[i].setVisible(true);
           l[i].setMaxSize(110, 30);
           ll[i]=new Label();
           ll[i].setFont(Font.font(20));
           ll[i].setStyle("-fx-border-color: #000000");
           
           ll[i].setVisible(true);
           ll[i].setMaxSize(110, 30);
           lll[i]=new Label();
           lll[i].setFont(Font.font(20));
           lll[i].setStyle("-fx-border-color: #000000");
           
           lll[i].setVisible(true);
           lll[i].setMaxSize(110, 30);
           llll[i]=new Label();
           llll[i].setFont(Font.font(20));
           llll[i].setStyle("-fx-border-color: #000000");
           llll[i].setVisible(true);
           llll[i].setMaxSize(70, 25);
           if(Student_after_login.sol_pra_flag==1){
               ll[i].setText(" "+Solve_paper.an[i]);
               lll[i].setText(" "+Solve_paper.yourans[i]);
           }
           if(Student_after_login.sol_pra_flag==2){
               ll[i].setText(" "+Practise.an[i]);
               lll[i].setText(" "+Practise.yourans[i]);
           }
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
        if(Student_after_login.sol_pra_flag==1){
            if(i>0){
                if(Solve_paper.yourans[i]==""){ 
                }
                else if(Solve_paper.an[i].equals(Solve_paper.yourans[i])){
                    ImageView img1 = new ImageView("/background/right.png");
                    img1.setFitWidth(60);  
                    img1.setFitHeight(25);
                    llll[i].setGraphic(img1);
                }
                else{
                    ImageView img = new ImageView("/background/a.png");
                    img.setFitWidth(60);  
                    img.setFitHeight(25);
                    llll[i].setGraphic(img);
                }
            }
       }
        if(Student_after_login.sol_pra_flag==2){
            if(i>0){
                System.out.println("dfjdfjbdkjfhhjvdfbvhjdfjvdf");
                if(Practise.yourans[i]==""){ 
                }
                else if(Practise.an[i].equals(Practise.yourans[i])){
                    ImageView img1 = new ImageView("/background/right.png");
                    img1.setFitWidth(60);  
                    img1.setFitHeight(25);
                    llll[i].setGraphic(img1);
                }
                else{
                    ImageView img = new ImageView("/background/a.png");
                    img.setFitWidth(60);  
                    img.setFitHeight(25);
                    llll[i].setGraphic(img);
                }
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
