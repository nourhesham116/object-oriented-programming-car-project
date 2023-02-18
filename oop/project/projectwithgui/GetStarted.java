/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class GetStarted extends Scene {
    
    public GetStarted(Parent parent,Stage PrimaryStage, double d, double d1) {
        super(parent, d, d1);
       FileInputStream input=null;
        try{
          
           input=new FileInputStream("backg.jpg");
       }
        catch(Exception e){
            e.printStackTrace();
        }
             HBox v= new HBox();
       Image img= new Image(input);
      ImageView view = new ImageView(img);
      view.setFitHeight(1400);
      view.setFitWidth(1300);
      view.setPreserveRatio(true);
    
      StackPane s1= new StackPane();
    
        GridPane layout = new GridPane();
        Button login=new Button("Sign in");
        
        login.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
            
            try {
                VBox v1=new VBox();
                LoginForm l1= new LoginForm(v1,PrimaryStage,500,500);
                PrimaryStage.setScene(l1);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetStarted.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      });
        Button reg= new Button("Create An Account");
         reg.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            VBox v1=new VBox();
             RegisterForm r1= new RegisterForm(v1,PrimaryStage,500,500);
              PrimaryStage.setScene(r1);
        }
        
      });
         Label welcome= new Label("Car Rental System");
         Font font = new Font("Arial Black",19);
         welcome.setTextFill(Color.BLACK);
         welcome.setFont(font);
         welcome.setBackground(Background.fill(Color.WHITE));
         VBox v1 = new VBox();
         v1.getChildren().add(welcome);
         v1.setAlignment(Pos.TOP_CENTER);
        
        layout.add(login,0,3);
         layout.add(reg,2,3);
         layout.setHgap(20);
         layout.setAlignment(Pos.CENTER_LEFT);
         layout.setPadding(new Insets(40));
         layout.setVgap(20);
         s1.setPadding(new Insets(30));
         s1.getChildren().addAll(view,v1,layout);
        setRoot(s1);
                
    }
    
}
