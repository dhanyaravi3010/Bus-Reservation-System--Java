/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus_reservation;

/**
 *
 * @author ANAND
 */
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking {
    String passengerName;
    int busNo;
    Date date;
    
    Booking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the passenger:  ");
        passengerName = scanner.next();
        System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
    this.date = dateFormat.parse(dateInput);  // ✅ this fixes the null issue
} catch (ParseException e) {
    e.printStackTrace();
}
        
    }
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses){
        int capacity = 0;
        for(Bus bus:buses){
            if(bus.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }
        int booked =0;
        for(Booking b:bookings){
            if(b.busNo == busNo && b.date.equals(date)){
                booked++;
            }
        }
        return booked<capacity?true:false;
    }

}
