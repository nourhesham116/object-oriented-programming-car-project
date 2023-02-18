/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
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

/**
 *
 * @author Nour Hesham
 */
public class BookingStatusForm extends Scene{
    int rentId;
    public BookingStatusForm(Parent parent,Customer c1,Stage primaryStage , double d, double d1) {
        super(parent, d, d1);
          primaryStage.setTitle("Booking status");
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
//////////////////////////
ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    CustomerMenu m1= new CustomerMenu(v1,c1,primaryStage,800,600);
    primaryStage.setScene(m1);
     primaryStage.show();
});
        Label l1 = new Label("Enter you booking id");
        TextField t1= new TextField();
        VBox v1 = new VBox();
        Button vieww = new Button("View Status");
        v1.getChildren().addAll(v,l1,t1,vieww);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
        vieww.setOnAction((ActionEvent event) -> {
            try{
                rentId= Integer.parseInt(t1.getText());
            }
            catch(Exception e){
                alert.setContentText("enter a valid rent id");
                alert.showAndWait();
                t1.setText("");
            }
            if(!t1.getText().contentEquals("")){
              int check= c1.CheckStatus(rentId,c1.getUsername());
               if(check==1){
                   alert.setContentText("your booking is confirmed");
                alert.showAndWait();
               }
               else if(check==2){
                    alert.setContentText("your booking is pending");
                alert.showAndWait();
               }
               else if (check==3){
                    alert.setContentText("enter a valid rent id");
                alert.showAndWait();
               }
                }
            
            
        });
        setRoot(v1);
    }
    
}
