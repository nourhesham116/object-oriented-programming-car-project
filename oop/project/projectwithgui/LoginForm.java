/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static projectwithgui.User.data;

/**
 *
 * @author Nour Hesham
 */
public class LoginForm extends Scene {

    public LoginForm(Parent parent,Stage primaryStage, double d, double d1) throws FileNotFoundException {
        super(parent, d, d1);
          primaryStage.setTitle("Log In");
          /////////////////
          FileInputStream input=null;
       try{
           input=new FileInputStream("340.png");
       }
        catch(Exception e){
            e.printStackTrace();
        }
             HBox v= new HBox();
       Image img= new Image(input);
      ImageView view = new ImageView(img);
      view.setFitHeight(30);
      view.setPreserveRatio(true);
      //Creating a Button
      Button ret = new Button("",view);
      //Setting the location of the button
      ret.setTranslateX(10);
      ret.setTranslateY(10);
      //Setting the size of the button
      ret.setPrefSize(10, 10);
      //Setting a graphic to the button
      //button.setGraphic(view);
      //Setting the stage
      Group root1 = new Group(ret); 
    v.getChildren().add(root1);
    //////////////////////////////////////
        
        ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    GetStarted g1= new GetStarted(v1,primaryStage,800,600);
    primaryStage.setScene(g1);
     primaryStage.show();
});
     
        Customer c1 = new Customer();
        Manager m1 = new Manager();

        VBox layout = new VBox();
         VBox v1 = new VBox();
        Label entruser = new Label("please enter your username");
        TextField usern = new TextField();

        Label entrpass = new Label("please enter your password");

        TextField pass = new TextField();

        Button signIn = new Button("Sign In");
         layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(entruser, usern, entrpass, pass, signIn);
        layout.setSpacing(10);
       v1.setSpacing(10);
       v1.setPadding(new Insets(30));
v1.getChildren().addAll(v,layout);
setRoot(v1);
        signIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    String loginMessage=c1.login(usern.getText(),pass.getText());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    if(loginMessage.contentEquals("manager")){
                        alert.setContentText("login succesfull");
                         alert.showAndWait();
                         VBox v1=new VBox();
                         ManagerMenu f1=new ManagerMenu(v1,m1,primaryStage,800,600);
                         primaryStage.setScene(f1);
                         primaryStage.show();
                         
                    }
                    else if(loginMessage.contentEquals("user")){
                        alert.setContentText("login succesfull");
                         alert.showAndWait();
                         VBox v1=new VBox();
                         CustomerMenu m1=new CustomerMenu(v1,c1,primaryStage,800,600);
                         primaryStage.setScene(m1);
                         primaryStage.show();
                    }
                    
                    if(loginMessage.contentEquals("correct username,wrong password,enter your password again")){
                        alert.setContentText(loginMessage);
                         alert.showAndWait();
                        pass.setText("");
                    }
                    if(loginMessage.contentEquals("username not found")){
                        alert.setContentText(loginMessage);
                         alert.showAndWait();
                        usern.setText("");
                        pass.setText("");
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                

           

            }
        });

    }
}
