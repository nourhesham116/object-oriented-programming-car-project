/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 *
 * @author Nour Hesham
 */
public class Customer extends User{
       protected String firstName;
    protected String lastName;
protected long nationalId;
    protected long phoneNum;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    
public Customer(){
    
}
    public Customer(String firstName, String lastName, long nationalId, long phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.phoneNum = phoneNum;
    }
     
    public String registeration( String firstName, String LastName, String username, String password, long nationalId, long phoneNum)  {
        Scanner input = new Scanner(System.in);

        
       this.firstName=firstName;
       this.lastName=LastName;
       this.username=username;
       this.password=password;
       this.nationalId=nationalId;
       this.phoneNum=phoneNum;
       
        if (!data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).username.compareTo(username) == 0) {
                    return("username is repeated");
                }

            }
        }
        
        

        data.add(this);

       return("account created successfully");
    }


    public double rentAcar(String ID,String pickup,String ret,Alert alert,int days) throws IOException {
boolean foundc=false;
double price=0;
        for(int i=0;i<cars.size();i++){
            if(ID.contains(cars.get(i).Carid)){
                price=cars.get(i).price;
                foundc=true;
            }
        }
        if (!foundc){
            alert.setContentText("car id not found");
            alert.showAndWait();
            return -1;
        }
            
           else{
            
                Renting r1 = new Renting();
                  boolean foundrentId=false;
                  int random = (int) (Math.random() * (10000 - 1 + 1) + 1);
          
                    for(int j=0;j<rent.size();j++){
                    if(random==rent.get(j).rentId){
                        foundrentId=true;
                    }
                    }
            
                    if(foundrentId){
                    random = (int) (Math.random() * (10000 - 1 + 1) + 1);
                    }
                   
                    
                    
                    r1.rentedCarid=ID;
                    r1.rentId = random;
                    r1.renterUser = username;
                    r1.pickupDate=pickup;
                    r1.returnDate=ret;
                    r1.totalAmmount= days*price;
                    rent.add(r1);
                    
                
            alert.setContentText("RENT ID IS "+random);
            alert.showAndWait();
            alert.setContentText("your total price is "+r1.totalAmmount+" in "+days+" days");
            alert.showAndWait();
           
            }
  return 1;
    }

    public boolean DeleteBooking(int Bid) {
        
        String Cid = "";
        
        for (int i = 0; i < rent.size(); i++) {
            if (Bid == rent.get(i).rentId&&rent.get(i).renterUser.contentEquals(username)) {
                Cid = rent.get(i).rentedCarid;
                rent.remove(i);
                for(int j=0;j<cars.size();j++){
                    if(cars.get(i).Carid.contentEquals(Cid)){
                        Car c1= new Car();
                        c1.Carid=Cid;
                        c1.available=true;
                        c1.brand=cars.get(i).brand;
                        c1.color=cars.get(i).color;
                        c1.model=cars.get(i).model;
                        c1.year=cars.get(i).year;
                        c1.price=cars.get(i).price;
                        cars.set(i,c1);
                    }
                }
                return true;

            }
        }
        return false;
        

    }
    public boolean EditBooking(int rentId,String username,String carid,String pickup,String returnd) {
        boolean found=false;
        for(int i=0;i<cars.size();i++){
            if(carid.contentEquals(cars.get(i).Carid)){
                found=true;
            }
        }
        if(!found)return false;
        for(int i=0;i<rent.size();i++){
            if(rentId==rent.get(i).rentId ){
                if(rent.get(i).renterUser.compareTo(username)==0){
                    Renting r1= new Renting(rent.get(i).rentId, rent.get(i).rentedCarid, rent.get(i).pickupDate, rent.get(i).returnDate, rent.get(i).totalAmmount);
                    r1.pickupDate=pickup;
                    r1.rentId=rentId;
                    r1.rentedCarid=carid;
                    r1.renterUser=username;
                    r1.returnDate=returnd;
                    rent.set(i, r1);
                    return true;
                }
            }
        }
        return false;
    }
    public int CheckStatus(int rentId,String username){
        
        for(int i=0;i<rent.size();i++){
            if(rent.get(i).rentId==rentId &&rent.get(i).renterUser.contains(username)){
                boolean hold = rent.get(i).status;
                if(hold){
                    return 1;
                }
                if(!hold){
                   return 2;
                }
                break;
            }
        }
        return 3;
    }

    public void viewmyBookingHistory(TableView table) {
        for (int i = 0; i < rent.size(); i++) {
            if (username.compareTo(rent.get(i).renterUser) == 0) {
                
              table.getItems().add(new Renting(rent.get(i).rentId,rent.get(i).rentedCarid,rent.get(i).pickupDate,rent.get(i).returnDate,rent.get(i).totalAmmount));
//               System.out.println(rent.get(i).rentId);
//               System.out.println(rent.get(i).rentedCarid);
            }
        }
    }

    
}
