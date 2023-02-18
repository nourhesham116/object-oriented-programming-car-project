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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class ViewAllUsersForm extends Scene {

    public ViewAllUsersForm(Parent parent,Manager m1, Stage primaryStage, double d, double d1) {
        super(parent, d, d1);
        
        primaryStage.setTitle("View all users");
        
        GridPane roott = new GridPane();
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
    ////////////////////////////////
        BorderPane pane = new BorderPane();
        TableView table = new TableView<Customer>();
        TableColumn firstnamecolumn = new TableColumn<Customer, String>("First Name");
        firstnamecolumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        
        TableColumn lastnamecolumn = new TableColumn<Customer, String>("Last Name");
        lastnamecolumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        
        TableColumn nationalIdcolumn = new TableColumn<Customer, Long>("National Id");
        nationalIdcolumn.setCellValueFactory(new PropertyValueFactory<Customer, Long>("nationalId"));
        
        TableColumn phonecolumn = new TableColumn<Customer, Long>("Phone");
        phonecolumn.setCellValueFactory(new PropertyValueFactory<Customer, Long>("phoneNum"));
        table.getColumns().add(firstnamecolumn);
        table.getColumns().add(lastnamecolumn);
        table.getColumns().add(nationalIdcolumn);
        table.getColumns().add(phonecolumn);

        pane.setCenter(table);
        VBox things = new VBox();
        
        things.getChildren().addAll(v,pane);
          m1.DisplayAllUsers(table);
        setRoot(things);

    }

}
