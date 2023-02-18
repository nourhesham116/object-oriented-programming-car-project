/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;


import java.io.FileInputStream;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class RegisterForm extends Scene {
 long pNum,natId=0;

    public RegisterForm(Parent parent,Stage primaryStage, double d, double d1)  {
        super(parent, d, d1);
         primaryStage.setTitle("Registeration");
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
    v.getChildren().add(root1);ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    GetStarted m1= new GetStarted(v1,primaryStage,800,600);
    primaryStage.setScene(m1);
     primaryStage.show();
});
    /////////////////////////////////
       
        Label firstn_lb = new Label("firstName");
        TextField firstn_tb = new TextField();
        Label lastn_lb = new Label("LastName");
        TextField lastn_tb = new TextField();
        Label username_lb = new Label("username");
        TextField username_tb = new TextField();
        Label password_lb = new Label("password");
        TextField password_tb = new TextField();
        Label natId_lb = new Label("National Id Number");
        TextField natId_tb = new TextField();
        Label phonen_lb = new Label("phoneNumber");
        TextField phonen_tb = new TextField();
        Button create_btn = new Button("Create my Account");
       
//        VBox hb = new VBox();
//        ObservableList<String> options = FXCollections.observableArrayList(
//                "level1", "level2", "level3"
//        );
//        ComboBox combobox = new ComboBox(options);
//        hb.getChildren().add(combobox);
//        combobox.setItems(options);
VBox v1= new VBox();
        GridPane root = new GridPane();
        root.add(firstn_lb, 1, 5);
        root.add(firstn_tb, 6, 5);
        root.add(lastn_lb, 1, 10);
        root.add(lastn_tb, 6, 10);
        root.add(username_lb, 1, 15);
        root.add(username_tb, 6, 15);
        root.add(password_lb, 1, 20);
        root.add(password_tb, 6, 20);
        root.add(natId_lb, 1, 25);
        root.add(natId_tb, 6, 25);
        root.add(phonen_lb, 1, 35);
        root.add(phonen_tb, 6, 35);
        root.add(create_btn, 6, 50);
        v1.getChildren().addAll(v,root);
        v1.setSpacing(5);
         v1.setPadding(new Insets(10));
        //v1.setAlignment(Pos.CENTER);
    create_btn.setOnAction((ActionEvent event) -> {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             try{
        
                pNum= Long.parseLong(phonen_tb.getText());
             }
                 catch(Exception e){
                     
                    alert.setContentText("write a valid phone number");
                    alert.showAndWait();
                    phonen_tb.setText("");
                 }
             try{
        
                natId= Long.parseLong(natId_tb.getText());
             }
                 catch(Exception e){

                    alert.setContentText("write a valid national id ");
                    alert.showAndWait();
                    natId_tb.setText("");
                }  
             if(!natId_tb.getText().contentEquals("")&& !( natId_tb.getText().matches("\\d{14}"))){
                 alert.setContentText("national id has missing numbers");
                    alert.showAndWait();
                    natId_tb.setText("");
             }
             if(!phonen_tb.getText().contentEquals("")&&!( phonen_tb.getText().matches("\\d{11}"))){
                 alert.setContentText("phone number is missing numbers");
                    alert.showAndWait();
                   phonen_tb.setText("");
             }
            
             if(firstn_tb.getText().contentEquals("")||lastn_tb.getText().contentEquals("")||username_tb.getText().contentEquals("")||password_tb.getText().contentEquals("")||natId_tb.getText().contentEquals("")||phonen_tb.getText().contentEquals("")){
            
                    alert.setContentText("please fill all the form");
                    alert.show();
             }
             else{
                
                 
             Customer c1= new Customer();
             alert.setContentText("account created succssefully");
                    alert.show();
        c1.registeration(firstn_tb.getText(),lastn_tb.getText(),username_tb.getText(),password_tb.getText(),natId,pNum);
             }
        });
        
        setRoot(v1);

    }

}
