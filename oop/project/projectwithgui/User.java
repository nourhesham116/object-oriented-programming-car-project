/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;

/**
 *
 * @author Nour Hesham
 */
public  class User {
    
    protected String username;
    protected String password;
   
    protected static ArrayList<Car> cars = new ArrayList<>();
    protected static ArrayList<Renting> rent = new ArrayList<>();

    protected static ArrayList<Customer> data = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    static {
        try {
            fillArrayListuser();
          fillArrayListCars();
           fillRentArrayList();

        } catch (IOException ex) {
            System.out.println("error in static block in user class");
    
        }
//catch (ParseException ex) {
//            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public String login(String Username, String Password) throws FileNotFoundException {

        username = Username;
        password = Password;
        Manager m1 = new Manager();
        if (m1.getUsername().compareTo(username) == 0 && m1.getPassword().compareTo(password) == 0) {
            return ("manager");
        } else {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).username.compareTo(username) == 0) {

                    if (data.get(i).password.compareTo(password) == 0) {
                        return ("user");
                    } else {
                        while (password.compareTo(data.get(i).password) != 0) {
                            return ("correct username,wrong password,enter your password again");

                        }
                    }
                }
            }

        }

        return ("username not found");
    }

    
    public static void fillArrayListuser() throws IOException {

        DataInputStream file = new DataInputStream (new FileInputStream("Data.dat"));

        while (file.available()!=0) {
            Customer u1 = new Customer();
            u1.firstName=file.readUTF();
             u1.lastName = file.readUTF();
             u1.nationalId=file.readLong();
             u1.phoneNum=file.readLong();
             u1.username = file.readUTF();
            u1.password = file.readUTF();

            data.add(u1);

        }
        file.close();
    }

    public static void fillArrayListCars() throws IOException {

       String Brand, Model, Color, Id;
        boolean Available;
        int Year;
        DataInputStream file = new DataInputStream (new FileInputStream("Cars.dat"));
 
        while (file.available()!=0) {
           Car c2 = new Car();
            Id = file.readUTF();
            Brand = file.readUTF();
            Model = file.readUTF();
            Color = file.readUTF();
            Year = file.readInt();
           double price=file.readDouble();
            Available=file.readBoolean();
           
            
            c2.Carid = Id;
            c2.brand = Brand;
            c2.model = Model;
            c2.color = Color;
            c2.year = Year;
            c2.price=price;
            c2.available=Available;
            cars.add(c2);

        }

       file.close();
    }

    public static void fillRentArrayList() throws IOException{

        String Id, user;
        int rid;

        
        DataInputStream file = new DataInputStream (new FileInputStream("Rentings.dat"));
        Scanner read = new Scanner(file);

        while (file.available()!=0) {
            Renting r1 = new Renting();
            Id = file.readUTF();
            rid = file.readInt();
            user =file.readUTF();
            String pickup=file.readUTF();
            String ret=file.readUTF();
            boolean stat=file.readBoolean();
            double amm= file.readDouble();
            r1.rentedCarid = Id;
            r1.rentId = rid;
            r1.renterUser = user;
            r1.pickupDate=pickup;
            r1.returnDate=ret;
            r1.status=stat;
            r1.totalAmmount=amm;
            rent.add(r1);

        }

        file.close();
    }

    
    public void DisplayAllCars(TableView <Car> table)  {

  
        for (int i = 0; i < cars.size(); i++) {
            table.getItems().add(new Car(cars.get(i).brand,cars.get(i).model,cars.get(i).color,cars.get(i).year,cars.get(i).Carid,cars.get(i).price,cars.get(i).available));

        }
    }

    public static void filluFileBeforeClosing() throws IOException {
  DataOutputStream file = new DataOutputStream (new FileOutputStream("Data.dat"));

        for (int i = 0; i < data.size(); i++) {
            file.writeUTF(data.get(i).firstName);
            file.writeUTF(data.get(i).lastName);
            file.writeLong(data.get(i).nationalId);
            file.writeLong(data.get(i).phoneNum);
            file.writeUTF(data.get(i).username);
            file.writeUTF(data.get(i).password);

        }
        file.flush();
        file.close();

    }

    public static void fillCarsFileBeforeClosing() throws IOException {
  DataOutputStream file = new DataOutputStream (new FileOutputStream("Cars.dat"));

        for (int i = 0; i < cars.size(); i++) {
            file.writeUTF(cars.get(i).Carid);
            file.writeUTF(cars.get(i).brand);
            file.writeUTF(cars.get(i).model);
            file.writeUTF(cars.get(i).color);
            file.writeInt(cars.get(i).year);
            file.writeDouble(cars.get(i).price);
            file.writeBoolean(cars.get(i).available);
            
        }
        file.flush();
        file.close();

    }

    public static void fillRentersFileBeforeClosing() throws IOException {
     DataOutputStream file = new DataOutputStream (new FileOutputStream("Rentings.dat"));

        for (int i = 0; i < rent.size(); i++) {
            file.writeUTF(rent.get(i).rentedCarid);
            file.writeInt(rent.get(i).rentId);
            file.writeUTF(rent.get(i).renterUser);
           file.writeUTF(rent.get(i).pickupDate);
            file.writeUTF(rent.get(i).returnDate);
            file.writeBoolean(rent.get(i).status);
            file.writeDouble(rent.get(i).totalAmmount);

        }
        file.flush();
        file.close();


    }

}
