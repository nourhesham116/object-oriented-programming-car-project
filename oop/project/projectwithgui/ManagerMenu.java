/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class ManagerMenu extends Scene {
    
    public ManagerMenu(Parent parent,Manager m1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
          primaryStage.setTitle("Main menu");
        Button addCar= new Button("Car registeration");
       // Button viewCar= new Button("View all cars");
      
          Button viewpending= new Button("View pending rents to confrim"); 
          Button viewconfirmed= new Button("View confrimed rents");
          Button returnCar= new Button("return car");
       Button displayuser= new Button("Display all users");
       Button logout= new Button("logout");
        VBox layout = new VBox();
        layout.getChildren().addAll(addCar,viewpending,viewconfirmed,displayuser,logout);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setSpacing(30);
        Font font = new Font("Arial Black",18);
       addCar.setFont(font);
       //viewCar.setFont(font);
     
       viewpending.setFont(font);
       viewconfirmed.setFont(font);
     
       displayuser.setFont(font);
        setRoot(layout);
        addCar.setOnAction((ActionEvent event) -> {
            try {
                VBox v1= new VBox();
                AddCarForm f1=new  AddCarForm(v1,primaryStage,1000,600);
                primaryStage.setScene(f1);
                primaryStage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManagerMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         viewpending.setOnAction((ActionEvent event) -> {
              VBox v1= new VBox();
                ViewPendingForm f1=new  ViewPendingForm(v1,m1,primaryStage,1000,600);
                primaryStage.setScene(f1);
                primaryStage.show();
         });
         viewconfirmed.setOnAction((ActionEvent event) -> {
             VBox v1= new VBox();
                ViewConfirmedForm f1=new  ViewConfirmedForm(v1,m1,primaryStage,1000,600);
                primaryStage.setScene(f1);
                primaryStage.show();
         });
        displayuser.setOnAction((ActionEvent event) -> {
             VBox v1= new VBox();
                ViewAllUsersForm f1=new  ViewAllUsersForm(v1,m1,primaryStage,1000,600);
                primaryStage.setScene(f1);
                primaryStage.show();
         });
        logout.setOnAction((ActionEvent event)->{
            VBox v1= new VBox();
           GetStarted b1= new GetStarted(v1,primaryStage,900,600);
           primaryStage.setScene(b1);
                         primaryStage.show();
        });

    }
    
}
