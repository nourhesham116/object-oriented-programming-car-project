/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class AddCarForm extends Scene{
    int year;
    double price;
    boolean av;
    public AddCarForm(Parent parent,Stage primaryStage,double d, double d1) throws FileNotFoundException {
        super(parent, d, d1);
        /////////////////////////////
        primaryStage.setTitle("Car regesteration");
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
    /////////////////////////////////////////
        GridPane root = new GridPane();
        Label brand_lb= new Label("Brand");
        TextField brand_tb= new TextField();
        Label model_lb= new Label("Model");
        TextField model_tb= new TextField();
        Label color_lb=new Label("Color");
        TextField color_tb=new TextField();
        Label year_lb= new Label("Release Year");
        TextField year_tb= new TextField();
        Label carId_lb= new Label("Car Id");
        TextField carId_tb= new TextField();
        Label price_lb=new Label ("Price Per Day");
        TextField price_tb=new TextField();
        Label available_lb = new Label("Available");
         VBox hb = new VBox();
                ObservableList<String> options = FXCollections.observableArrayList(
                "YES", "NO"
        );
        ComboBox combobox = new ComboBox(options);
        hb.getChildren().add(combobox);
        combobox.setItems(options);
        
        Button add_btn= new Button("ADD");
        Button edit_btn= new Button("EDIT");
        Button delete_btn= new Button("Delete");
        Label note= new   Label(" NOTE: For the 'delete' its enough to enter carid only ");
        BorderPane border=new BorderPane();
        TableView<Car> table= new TableView<>();
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
        TableColumn <Car,Double> price_column=new TableColumn<>("Price");
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn <Car,Boolean> available_column=new TableColumn<>("Availabilty");
        available_column.setCellValueFactory(new PropertyValueFactory<>("available"));
        table.getColumns().add(brand_column);
        table.getColumns().add(model_column);
        table.getColumns().add(color_column);
        table.getColumns().add(year_column);
        table.getColumns().add(carid_column);
        table.getColumns().add(price_column);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        border.setCenter(table);
        table.getColumns().add(available_column);
        border.setCenter(table);
        VBox v2= new VBox();
        root.add(brand_lb, 1, 5);
        root.add(brand_tb, 2, 5);
        root.add(model_lb, 1, 10);
        root.add(model_tb, 2, 10);
        root.add(color_lb, 1, 15);
        root.add(color_tb, 2, 15);
        root.add(year_lb, 1, 20);
        root.add(year_tb, 2, 20);
        root.add(carId_lb, 1, 25);
        root.add(carId_tb, 2, 25);
        root.add(price_lb, 1, 35);
        root.add(price_tb, 2, 35);
        root.add(available_lb,1,50);
        root.add(hb, 2, 50);
        root.add(add_btn,5,50);
        root.add(edit_btn,6,50);
        root.add(delete_btn,7,50);
root.add(note,1,65);
root.add(border,1,70);
        root.setPadding(new Insets(50));
        root.setHgap(5);
        Manager m1= new Manager();
        m1.DisplayAllCars(table);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //////////////////////////
        add_btn.setOnAction((ActionEvent event) -> {
            
            
           try{
               year=Integer.parseInt(year_tb.getText());
           }
           catch(Exception e){
              if(!year_tb.getText().contentEquals("")){
                    alert.setContentText("Enter a valid release year ");
                    alert.showAndWait();
                    year_tb.setText("");}
           }
           try{
               price=Double.parseDouble(price_tb.getText());
           }
           catch(Exception e){
               if(!price_tb.getText().contentEquals("")){
                    alert.setContentText("Enter a valid price ");
                    alert.showAndWait();
                    price_tb.setText("");
                }
           }
           if(!year_tb.getText().matches("\\d{4}")){
               alert.setContentText("enter a valid year ");
                    alert.showAndWait();
                    year_tb.setText("");
           }
           if(brand_tb.getText().contentEquals("")||model_tb.getText().contentEquals("")||color_tb.getText().contentEquals("")||year_tb.getText().contentEquals("")||carId_tb.getText().contentEquals("")||price_tb.getText().contentEquals("")||combobox.getValue()==null){
               alert.setContentText("Please fill all the form ");
                    alert.showAndWait();
           }
           else{
                 try {
                     if(combobox.getValue().toString()=="YES"){
                         av=true;
                     }
                     else{
                         av=false;
                     }
                     
                     String mess=m1.addCar(brand_tb.getText(), model_tb.getText(), color_tb.getText(), year, carId_tb.getText(), price, av);
                     if (mess.contentEquals("Invalid id ,enter another one")){
                             alert.setContentText("This car ID is taken");
                             alert.showAndWait();
                             
                     }
                     else{
                         alert.setContentText("Added successfully");
                             alert.showAndWait();
                             table.getItems().clear();
                             m1.DisplayAllCars(table);
                     }
                    
                 } catch (IOException ex) {
                     Logger.getLogger(AddCarForm.class.getName()).log(Level.SEVERE, null, ex);
                     System.out.println("file not found exception elhwa file manager");
                 }
           }
        });
        ///////////////////////
         ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    ManagerMenu mm1= new ManagerMenu(v1,m1,primaryStage,800,600);
    primaryStage.setScene(mm1);
     primaryStage.show();
});

        //////////////////////////////////
        delete_btn.setOnAction((ActionEvent event) -> {
            try {
               String mess= m1.DeleteCar(carId_tb.getText());
                if(mess.contentEquals("id not found")){
                    alert.setContentText("This car ID is not found");
                             alert.showAndWait();
                }
                else{
                    alert.setContentText("Deleted successfully");
                             alert.showAndWait();
                             table.getItems().clear();
                             m1.DisplayAllCars(table);
                }
            } catch (IOException ex) {
                Logger.getLogger(AddCarForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        edit_btn.setOnAction((ActionEvent event) -> {
             try{
               year=Integer.parseInt(year_tb.getText());
           }
           catch(Exception e){
             if(!year_tb.getText().contentEquals("")){
                    alert.setContentText("Enter a valid release year ");
                    alert.showAndWait();
                    year_tb.setText("");
             }
           }
           try{
               
           
               price=Double.parseDouble(price_tb.getText());
           }
           catch(Exception e){
              if(!price_tb.getText().contentEquals("")){
                    alert.setContentText("Enter a valid price ");
                    alert.showAndWait();
                    price_tb.setText("");
              }
           }
           if(brand_tb.getText().contentEquals("")||model_tb.getText().contentEquals("")||color_tb.getText().contentEquals("")||year_tb.getText().contentEquals("")||carId_tb.getText().contentEquals("")||price_tb.getText().contentEquals("")||combobox.getValue()==null){
               alert.setContentText("Please fill all the form ");
                    alert.showAndWait();
           }
           else{
                 try {
                     if(combobox.getValue().toString()=="YES"){
                         av=true;
                     }
                     else{
                         av=false;
                     }
                     boolean b1=m1.EditCar(carId_tb.getText(),brand_tb.getText(), model_tb.getText(), color_tb.getText(), year, price, av);
                     if (b1){
                             alert.setContentText("car updated");
                             alert.showAndWait();
                             table.getItems().clear();
                             m1.DisplayAllCars(table);
                             
                     }
                     else{
                         alert.setContentText("car Id is wrong");
                             alert.showAndWait();
                             carId_tb.setText("");
                             
                     }
                 }
                     catch (IOException ex) {
                     Logger.getLogger(AddCarForm.class.getName()).log(Level.SEVERE, null, ex);
                     System.out.println("file not found exception elhwa file manager");
                 }
           }       
        });
        v2.getChildren().addAll(v,root);
        setRoot(v2);
    }
    
}
