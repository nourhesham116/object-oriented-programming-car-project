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
import javafx.scene.control.DatePicker;
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
public class EditBookingForm extends Scene{
    int rentId;
    public EditBookingForm(Parent parent,Customer c1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
          primaryStage.setTitle("Edit Booking");
         GridPane root= new GridPane();
        BorderPane border=new BorderPane();
        VBox h1= new VBox();
        TableView<Car> table= new TableView<>();
        
         Label rentid_lb= new Label("Enter  "
                 + "your rent id");      
        TextField rentid_tb= new TextField();
        Label edit_lb= new Label("* make sure its correct"); 
        Label id_lb= new Label("Car id");
        TextField id_tb= new TextField();
        Label pickupd_lb= new Label("Pickup date");
    DatePicker date1= new DatePicker();
        Label returnd_lb=new Label("return date");
       DatePicker date2= new DatePicker();
       Button save=new Button("edit");
      // Button b= new Button("edit");
       ///////////////////////////////
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
        TableColumn <Car,String> brandcolumn=new TableColumn<>("Brand");
        brandcolumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        TableColumn <Car,String> modelcolumn=new TableColumn<>("Model");
        modelcolumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn <Car,String> colorcolumn=new TableColumn<>("Color");
        colorcolumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        TableColumn <Car,Integer> yearcolumn=new TableColumn<>("Year");
       yearcolumn.setCellValueFactory(new PropertyValueFactory<>("year"));
       TableColumn <Car,String> caridcolumn=new TableColumn<>("Car Id");
        caridcolumn.setCellValueFactory(new PropertyValueFactory<>("carid"));
        TableColumn <Car,Double> pricecolumn=new TableColumn<>("Price per day");
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table.getColumns().add(brandcolumn);
        table.getColumns().add(modelcolumn);
        table.getColumns().add(colorcolumn);
        table.getColumns().add(yearcolumn);
        table.getColumns().add(caridcolumn);
        table.getColumns().add(pricecolumn);
       
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        border.setCenter(table);
        c1.DisplayAllCars(table);
         root.add(rentid_lb,0,0);
          root.add(rentid_tb,1,0);
          root.add(edit_lb, 1, 1);
        root.add(id_lb, 0, 2);
        root.add(id_tb,1,2);
        root.add(pickupd_lb,0,3);
        root.add(date1, 1, 3);
        root.add(returnd_lb,0,4);
        root.add(date2, 1, 4);
        root.add(save, 1, 5);
        //root.add(root1,1,6);
        root.setHgap(20);
        root.setPadding(new Insets(20));
        h1.getChildren().addAll(v,root,border);
       h1.setPadding(new Insets(30));
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       //////////////////////////////////
//      

      
      /////////////////////////
       save.setOnAction((ActionEvent event) -> {
           try{
           rentId=Integer.parseInt(rentid_tb.getText());
                   
           }
           catch(Exception e){
               alert.setContentText("enter a valid rent id");
               alert.show();
               rentid_tb.setText("");
           }
           boolean b1=false;
           if(!rentid_tb.getText().contentEquals("")||!id_tb.getText().contentEquals("")||!date1.getValue().toString().contentEquals("")||!date2.getValue().toString().contentEquals("")){
              b1= c1.EditBooking(rentId,c1.getUsername(),id_tb.getText(),date1.getValue().toString(),date2.getValue().toString());
           }
           if(b1){
               alert.setContentText("your rent edited successfully");
               alert.show();
           }
           else{
               alert.setContentText("please recheck the data you entered somthing is wrong");
               alert.show();
           }
       });
      setRoot(h1);
    
    }
    
}
