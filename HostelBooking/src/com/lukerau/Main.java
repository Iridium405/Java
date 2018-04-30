package com.lukerau;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final LocalDate TODAY = LocalDate.now();

    public static void main(String[] args) {

        Map<Integer, String> visitors = new HashMap<>();

        Room room001 = new Room(1,2);
        Room room002 = new Room(2,1);
        Room room003 = new Room(3,4);

        Guest guest001 = new Guest("Luke","Rau","Spacerowa","997-112-123", "123465789");
        Guest guest002 = new Guest("Anna","Unknown","Unknown","456-1237-89", "555999461");

        Service roomCleaning = new Service("Room cleaning",12.00);
        Service breakfast = new Service("Breakfast", 8.50);
        Service dogAccommodation = new Service("Dog Accommodation", 15.00);

        System.out.println("[Today: " + TODAY + "]");

//        room001.dates();
//        room001.setBookingStart(5,5,2018);
//        room001.setBookingEnd(12,5,2018);
//        room001.addToSchedule();
//        guest001.accommodateToRoom(room001);

//        guest001.addServiceToGuest(roomCleaning);
//        guest001.addServiceToGuest(breakfast);
//        guest001.printTotalCost();

        room001.setBookingStart(2,5,2018);
        room001.setBookingEnd(4,5,2018);
        room001.addToSchedule();
//        guest002.accommodateToRoom(room001);                // bug
//        guest002.printTotalCost();





    }
}
