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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
public class BookingHistoryForm extends Scene{
    
    public BookingHistoryForm(Parent parent,Customer c1, Stage primaryStage,double d, double d1) {
        super(parent, d, d1);
          primaryStage.setTitle("Booking History");
         GridPane roott = new GridPane();
      
          
       BorderPane root=new BorderPane();
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
///////////////////////
ret.setOnAction((ActionEvent event) -> {
    VBox v1= new VBox();
    CustomerMenu m1= new CustomerMenu(v1,c1,primaryStage,800,600);
    primaryStage.setScene(m1);
     primaryStage.show();
});
       TableView< Renting> table=new TableView< Renting>();
      TableColumn<Renting,String> rentidcolumn=new TableColumn<Renting,String>("rentid");
       rentidcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentId"));
       
           TableColumn<Renting,String> rentedCaridcolumn =new TableColumn<Renting,String>("rentedCarid");
       rentedCaridcolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("rentedCarid"));
       
           TableColumn<Renting,String> pickupDatecolumn=new TableColumn<Renting,String>("pickupDate");
       pickupDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("pickupDate"));
       
       TableColumn<Renting,String> returnDatecolumn=new TableColumn<Renting,String>("returnDate");
     returnDatecolumn.setCellValueFactory(new PropertyValueFactory<Renting,String>("returnDate"));
     TableColumn<Renting,Double> totalcolumn=new TableColumn<Renting,Double>("totalnAmmount");
     totalcolumn.setCellValueFactory(new PropertyValueFactory<Renting,Double>("TotalAmmount"));
     
     table.getColumns().add(rentidcolumn);
     table.getColumns().add(rentedCaridcolumn);
     table.getColumns().add(pickupDatecolumn);
     table.getColumns().add(returnDatecolumn);
     table.getColumns().add(totalcolumn);
     
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    
 
        HBox h1=new HBox();
//         TextField firstname=new TextField();
//         firstname.setPromptText("first name");
//       
//         TextField id=new TextField();
//        
//          id.setPromptText("id");
//         h1.setSpacing(10);
//         h1.setPadding(new Insets(10,10,10,10));
//          firstname.setTooltip(new Tooltip("enter name"));
//          id.setTooltip(new Tooltip("enter id"));
//         h1.getChildren().addAll(firstname,id);
//            
         
         h1.setAlignment(Pos.BOTTOM_RIGHT);
          HBox h2=new HBox();
          Button enter=new Button("View");
          h2.getChildren().addAll(enter);
           h2.setAlignment(Pos.BOTTOM_RIGHT);
   //  roottt.add(l1, 1, 5);
   // roottt.getChildren().add(l1);
    roott.getChildren().addAll(root,h1,h2); ///////////
   //roottt.add(root,1,70);
      //  roottt.setPadding(new Insets(50));
      //  roottt.setHgap(5);
   
   root.setCenter(table);
  // roott.add(h1,1,5);
 roott.add(v,0,0);
    roott.add(table,1,70);
    
    c1.viewmyBookingHistory(table);
    setRoot(roott);
    }
    
}
