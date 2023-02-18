/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectwithgui;

import java.util.Date;

/**
 *
 * @author Nour Hesham
 */
public class Renting {
    protected int rentId ;
    protected String rentedCarid;
    protected String renterUser;
    protected String pickupDate;
    protected String returnDate;
    protected boolean status=false;
    protected double totalAmmount;
  
public Renting(int rentId1, String rentedCarid1, String pickupDate1, String returnDate1, double totalAmmount1){
     this.rentId = rentId1;
        this.rentedCarid = rentedCarid1;
        this.pickupDate = pickupDate1;
        this.returnDate = returnDate1;
        this.totalAmmount=totalAmmount1;
}
public Renting(){
    
}
    
    public Renting(int rentId, String rentedCarid, String pickupDate, String returnDate ) {
        this.rentId = rentId;
        this.rentedCarid = rentedCarid;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
      
    }

    public double getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(double totalAmmount) {
        this.totalAmmount = totalAmmount;
    }
     

    public String getRentedCarid() {
        return rentedCarid;
    }

    public void setRentedCarid(String rentedCarid) {
        this.rentedCarid = rentedCarid;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public String getRenterUser() {
        return renterUser;
    }

    public void setRenterUser(String renterUser) {
        this.renterUser = renterUser;
    }


}
