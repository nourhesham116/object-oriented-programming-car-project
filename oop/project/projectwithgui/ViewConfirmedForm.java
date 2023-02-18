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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class ViewConfirmedForm extends Scene {
    
    public ViewConfirmedForm(Parent parent,Manager m1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
         primaryStage.setTitle("View Confrimed rents");
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
    ManagerMenu mm1= new ManagerMenu(v1,m1,primaryStage,800,600);
    primaryStage.setScene(mm1);
     primaryStage.show();
});
     /////////////////////////////////
         BorderPane border=new BorderPane();
       VBox v3= new VBox();
        TableView< Renting> table=new TableView< Renting>();
      TableColumn<Renting,String> rentidcolumn=new TableColumn<Renting,String>("rentid");
       rentidcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentId"));
       
           TableColumn<Renting,String> rentedCaridcolumn =new TableColumn<Renting,String>("rentedCarid");
       rentedCaridcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentedCarid"));
       
           TableColumn<Renting,String> pickupDatecolumn=new TableColumn<Renting,String>("pickupDate");
       pickupDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("pickupDate"));
       
       TableColumn<Renting,String> returnDatecolumn=new TableColumn<Renting,String>("returnDate");
     returnDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("returnDate"));
     table.getColumns().add(rentidcolumn);
        table.getColumns().add(rentedCaridcolumn);
        table.getColumns().add(pickupDatecolumn);
        table.getColumns().add(returnDatecolumn);
     table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
     v3.getChildren().addAll(v,border);
     m1.DisplayConfirmed(table);
        border.setCenter(table);
        setRoot(v3);

    }
    
}
