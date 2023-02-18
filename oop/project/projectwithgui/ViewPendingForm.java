/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class ViewPendingForm extends Scene {
    int conf;
    public ViewPendingForm(Parent parent,Manager m1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
         primaryStage.setTitle("View Pending rents");
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
    ///////////////////////////////////////
     ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    ManagerMenu mm1= new ManagerMenu(v1,m1,primaryStage,800,600);
    primaryStage.setScene(mm1);
     primaryStage.show();
});
     /////////////////////////////////////
        VBox v1= new VBox();
        VBox v2= new VBox();
        Label rentId_lb= new Label("Rent Id");
        TextField rentId_tb= new TextField();
        Button confirm= new Button("Confirm");
        
        BorderPane border=new BorderPane();
        v2.getChildren().addAll(rentId_lb,rentId_tb,confirm);
       
        TableView< Renting> table=new TableView< Renting>();
      TableColumn<Renting,String> rentidcolumn=new TableColumn<Renting,String>("rentid");
       rentidcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentId"));
       
           TableColumn<Renting,String> rentedCaridcolumn =new TableColumn<Renting,String>("rentedCarid");
       rentedCaridcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentedCarid"));
       
           TableColumn<Renting,String> pickupDatecolumn=new TableColumn<Renting,String>("pickupDate");
       pickupDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("pickupDate"));
       
       TableColumn<Renting,String> returnDatecolumn=new TableColumn<Renting,String>("returnDate");
     returnDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("returnDate"));
     
      TableColumn<Renting,Double> ammcolumn=new TableColumn<Renting,Double>("Total Amount");
     ammcolumn.setCellValueFactory(new PropertyValueFactory<Renting,Double>("totalAmmount"));
     table.getColumns().add(rentidcolumn);
        table.getColumns().add(rentedCaridcolumn);
        table.getColumns().add(pickupDatecolumn);
        table.getColumns().add(returnDatecolumn);
        table.getColumns().add(ammcolumn);
     table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        border.setCenter(table);
        v1.setSpacing(20);
        v1.setPadding(new Insets(30));
        m1.DisplayPending(table);
     v1.getChildren().addAll(v,v2,border);
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     confirm.setOnAction((ActionEvent event) -> {
         try{
           conf=  Integer.parseInt(rentId_tb.getText());
         }
         catch(Exception e){
             alert.setContentText("please enter the rent id in a valid form");
             alert.show();
             rentId_tb.setText("");
         }
         
         if(!rentId_tb.getText().contentEquals("")){
             
            boolean b= m1.RentConfirmation( conf);
         
         if(b){
             alert.setContentText("rent confirmed");
             alert.showAndWait();
             m1.DisplayPending(table);
             
         }
         else{
            alert.setContentText("please enter a valid rent id");
            alert.showAndWait();
            rentId_tb.setText("");
            
         }
         }
     });
             
     setRoot(v1);
    }
    
}
