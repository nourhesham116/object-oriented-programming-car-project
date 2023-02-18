/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Period;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nour Hesham
 */
public class BookCarForm extends Scene{
    String pickupd,returnd;
    double price;
    public BookCarForm(Parent parent, Customer c1,Stage primaryStage, double d, double d1) {
        super(parent, d, d1); 
          primaryStage.setTitle("Book a Car");
        //////////////////////////////////////
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
    /////////////////////////////////////
    
        GridPane root= new GridPane();
        BorderPane border=new BorderPane();
        VBox h1= new VBox();
        TableView<Car> table= new TableView<>();
        Label id_lb= new Label("Car id");
        TextField id_tb= new TextField();
        Label pickupd_lb= new Label("Pickup date");
    DatePicker date1= new DatePicker();
        Label returnd_lb=new Label("return date");
       DatePicker date2= new DatePicker();
       Button book= new Button("Book");
        TableColumn <Car,String> brand_column=new TableColumn<>("Brand");
        brand_column.setCellValueFactory(new PropertyValueFactory<>("brand"));
        TableColumn <Car,String> model_column=new TableColumn<>("Model");
        model_column.setCellValueFactory(new PropertyValueFactory<>("model"));
        TableColumn <Car,String> color_column=new TableColumn<>("Color");
        color_column.setCellValueFactory(new PropertyValueFactory<>("color"));
        TableColumn <Car,Integer> year_column=new TableColumn<>("Year");
       year_column.setCellValueFactory(new PropertyValueFactory<>("year"));
       TableColumn <Car,String> carid_column=new TableColumn<>("Car Id");
        carid_column.setCellValueFactory(new PropertyValueFactory<>("carid"));
        TableColumn <Car,Double> price_column=new TableColumn<>("Price per day");
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table.getColumns().add(brand_column);
        table.getColumns().add(model_column);
        table.getColumns().add(color_column);
        table.getColumns().add(year_column);
        table.getColumns().add(carid_column);
        table.getColumns().add(price_column);
      
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        border.setCenter(table);
    

        root.add(id_lb, 0, 0);
        root.add(id_tb,1,0);
        root.add(pickupd_lb,0,1);
        root.add(date1, 1, 1);
        root.add(returnd_lb,0,2);
        root.add(date2, 1, 2);
        root.add(book,2,3);
      
        root.setHgap(20);
        root.setPadding(new Insets(20));
       
       h1.setPadding(new Insets(30));
       
        c1.DisplayAllCars(table); 
       
    ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    CustomerMenu m1= new CustomerMenu(v1,c1,primaryStage,800,600);
    primaryStage.setScene(m1);
     primaryStage.show();
});
//////////////////////////

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //////////////////////////////////////
        book.setOnAction((ActionEvent event) -> {
            //////////////////////////////
            if(date1.getValue()!=null&&date2.getValue()!=null){
            pickupd= date1.getValue().toString();
            returnd=date2.getValue().toString();
            Period period = Period.between(date1.getValue(), date2.getValue());
           int diff = Math.abs(period.getDays());//days to calculate price;
           //////////////////////////
           if(pickupd.contentEquals("")||returnd.contentEquals("")||id_tb.getText().contentEquals("")){
               alert.setContentText("please Fill all the form");
           }
           else if(!pickupd.contentEquals("")&&!returnd.contentEquals("")&&!id_tb.getText().contentEquals("")){
                try {
                    
                    double x=c1.rentAcar(id_tb.getText(), pickupd, returnd,alert,diff);
                    if(x==-1){
                       id_tb.setText("");
                    }
                    
////                    
                }
                 catch (IOException ex) {
                    Logger.getLogger(BookCarForm.class.getName()).log(Level.SEVERE, null, ex);
          
                         }
                
           }// 
            }
            else{
                alert.setContentText("please fill all form");
                alert.show();
            }
        }); 
        h1.getChildren().addAll(v,root,border);
        setRoot(h1);
    }
    
}
