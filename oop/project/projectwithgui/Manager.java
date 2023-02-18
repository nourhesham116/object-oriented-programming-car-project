/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.control.TableView;

/**
 *
 * @author Nour Hesham
 */
public class Manager extends User {

    public Manager() throws FileNotFoundException {
        File file = new File("manager_reg.txt");
        Scanner read = new Scanner(file);
        while (read.hasNext()) {
            username = read.nextLine();
            password = read.nextLine();

        }
    }

    public String addCar(String brand, String model, String color, int year, String Carid, double price, boolean available) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean checkId = true;
        Car c1 = new Car();

        c1.Carid = Carid;

        c1.brand = brand;

        c1.model = model;

        c1.color = color;

        c1.year = year;
        c1.price=price;
       c1.available=available;
        for (int j = 0; j < cars.size(); j++) {
            if (cars.get(j).Carid.compareTo(c1.Carid) == 0) {
                checkId = false;

            }
        }
        if(!checkId) {
            return("Invalid id ,enter another one");
        }
            

           
        
        cars.add(c1);
    return ("car is added succesfully");
    }

//    public static void fillArrayList() throws IOException {
//
//        String Brand, Model, Color, Id;
//        boolean Available;
//        int Year;
//        File file = new File("cars.txt");
//        Scanner read = new Scanner(file);
//
//        while (read.hasNext()) {
//            Car c2 = new Car();
//            Id = read.nextLine();
//            Brand = read.nextLine();
//            Model = read.nextLine();
//            Color = read.nextLine();
//            Year = read.nextInt();
//            read.nextLine();
//            Available = read.nextBoolean();
//            read.nextLine();
//
//            c2.Carid = Id;
//            c2.brand = Brand;
//            c2.model = Model;
//            c2.color = Color;
//            c2.year = Year;
//            c2.available = Available;
//            cars.add(c2);
//
//        }
//
//        read.close();
//    }

//    public void DisplayAllCars() throws IOException {
//
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.println("car id :" + cars.get(i).Carid);
//            System.out.println("car brand : " + cars.get(i).brand);
//            System.out.println("car model : " + cars.get(i).model);
//            System.out.println("car color :" + cars.get(i).color);
//            System.out.println("car release year :" + cars.get(i).year);
//            System.out.println("car availablity :" + cars.get(i).available);
//
//            System.out.println("");
//        }
//    }
    public void DisplayAllUsers(TableView table)  {
        for (int i = 0; i < data.size(); i++) {
            table.getItems().add(new Customer(data.get(i).firstName,data.get(i).lastName,data.get(i).nationalId,data.get(i).phoneNum));

        }
    }

    public boolean EditCar(String carid,String brand,String model,String color,int year,double price,boolean available) throws IOException {

        
       
        Car c1 = new Car();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).Carid.compareTo(carid) == 0) {
                c1.Carid = carid;
                
                    c1.model =model;
                    c1.color = color;
                    c1.year = year;
                    c1.brand = brand;
                    c1.price=price;
                    c1.available=available;
                    cars.set(i, c1);
                   return true;

                
            }

        }
        return false;
    }
    public String DeleteCar(String ID) throws IOException {
     
       
        
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).Carid.compareTo(ID) == 0) {
                cars.remove(i);
                return("the selected car is deleted");
                
                
            }
        }
        return("id not found");

    }
public void DisplayPending(TableView table){
    for(int i=0;i<rent.size();i++){
        if(rent.get(i).status==false){
    table.getItems().add(new Renting(rent.get(i).rentId,rent.get(i).rentedCarid,rent.get(i).pickupDate,rent.get(i).returnDate, rent.get(i).totalAmmount));
}
    }
}
  public void DisplayConfirmed(TableView table){
    for(int i=0;i<rent.size();i++){
        if(rent.get(i).status==true){
            
    table.getItems().add(new Renting(rent.get(i).rentId,rent.get(i).rentedCarid,rent.get(i).pickupDate,rent.get(i).returnDate, rent.get(i).totalAmmount));
}
    }
}
    public boolean RentConfirmation(int confirmed) {
        String Carid="";
        for (int i = 0; i < rent.size(); i++) {
            if (confirmed == rent.get(i).rentId) {
               Renting r1=new Renting();
               Carid=rent.get(i).rentedCarid;
               r1.pickupDate=rent.get(i).pickupDate;
               r1.rentId=rent.get(i).rentId;
               r1.rentedCarid=rent.get(i).rentedCarid;
               r1.renterUser=rent.get(i).renterUser;
               r1.returnDate=rent.get(i).returnDate;
               r1.status=true;
               r1.totalAmmount=rent.get(i).totalAmmount;
               rent.set(i,r1);
              break;
                
            }
        }
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).Carid.contentEquals(Carid)){
                Car c1= new Car();
                c1.Carid=cars.get(i).Carid;
                c1.available=false;
                c1.brand=cars.get(i).brand;
                c1.color=cars.get(i).color;
                c1.model=cars.get(i).model;
                c1.price=cars.get(i).price;
                c1.year=cars.get(i).year ;
                cars.set(i, c1);
                return true;
                
            }
        }
return false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
