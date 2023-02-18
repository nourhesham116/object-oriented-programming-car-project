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
public class DeleteBookingForm extends Scene {
    
int Bid;
    public DeleteBookingForm(Parent parent,Customer c1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
      primaryStage.setTitle("Delete Booking");
        VBox h=new VBox();
        GridPane g=new GridPane();
        Button btn = new Button("confirm deleting");
        
      Label Delete=new Label("Rent Id");
      TextField delete=new TextField();
      g.add(Delete, 0, 0);
      g.add(delete, 1, 0);
      g.add(btn, 1, 5);
      g.setHgap(20);
      g.setPadding(new Insets(60));
      btn.setAlignment(Pos.CENTER);
    
      
      ///////////////////////////////////////////////
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
h.getChildren().addAll(v,g);
ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    CustomerMenu m1= new CustomerMenu(v1,c1,primaryStage,800,600);
    primaryStage.setScene(m1);
     primaryStage.show();
});
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
     
        
       btn.setOnAction((ActionEvent event) -> {
           try{
      Bid=Integer.parseInt(delete.getText());
      }
      catch(Exception e){
          alert.setContentText("please enter a valid rent id");
          delete.setText("");
          alert.showAndWait();
      }
           if(!delete.getText().contentEquals("")){
        boolean x=c1.DeleteBooking(Bid);
        if(x){
        alert.setContentText("rent deleted");
          alert.showAndWait();
        }
        else{
           alert.setContentText("enter a valid rent id");
           delete.setText("");
          alert.showAndWait(); 
        }
           }
       });
      setRoot(h);
      
    
    }
    
}
