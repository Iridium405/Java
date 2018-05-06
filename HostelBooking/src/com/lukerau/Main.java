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

        Guest guest001 = new Guest("Luke","Rau","Spacerowa 12, 78-300 Świdwin","997-112-123", "123465789");
        Guest guest002 = new Guest("Unknown","Unknown","Unknown","456-1237-89", "555999461");

        Service roomCleaning = new Service("Room cleaning",12.00);
        Service breakfast = new Service("Breakfast", 8.50);
        Service dogAccommodation = new Service("Dog Accommodation", 15.00);

        System.out.println("[Today: " + TODAY + "]");

        room001.printDates();
        room001.setBookingStart(7,5,2018);
        room001.setBookingEnd(12,5,2018);
        room001.printDates();
        guest001.accommodateToRoom(room001);

        guest001.addServiceToGuest(roomCleaning);
        guest001.addServiceToGuest(breakfast);
        System.out.println("\n");
        guest001.completeIntel();

//        System.out.println("\n");
//        room001.setBookingStart(15,5,2018);
//        room001.setBookingEnd(17,5,2018);
//        room001.printDates();
//        guest002.accommodateToRoom(room001);
//        guest002.printTotalCost();
//
//        System.out.println("\n");

//        room001.setBookingStart(10,5,2018);
//        room001.setBookingEnd(15,5,2018);
//        room001.printDates();



    }
}
