/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectwithgui;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nour Hesham
 */
public class ProjectWithGui extends Application {

    public void start(Stage primaryStage) throws FileNotFoundException{
        primaryStage.setTitle("Get Started");
        VBox v1=new VBox();
       GetStarted b1= new GetStarted( v1,primaryStage,900,600);
//         LoginForm lf =new LoginForm( v1,600,600);
   //     DeleteBookingForm d1= new DeleteBookingForm(v1,800,600);
//   BookingHistoryForm h1= new BookingHistoryForm(v1,900,600);
//        AddCarForm c1= new AddCarForm(v1,900,600);
//Customer c1= new Customer();
//EditBookingForm b1= new EditBookingForm(v1,c1,900,600);
//ViewPendingForm b1= new ViewPendingForm(v1,primaryStage,800,800);
primaryStage.setScene(b1);
        primaryStage.show();
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
     launch (args);
//    Customer c1= new Customer();
//     c1.setUsername("nour hesham");
//     c1.viewmyBookingHistory();
     User.filluFileBeforeClosing();
     User.fillCarsFileBeforeClosing();
     User.fillRentersFileBeforeClosing();
    }
    
}
