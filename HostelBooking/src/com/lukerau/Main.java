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

        System.out.println("\n");
        room001.setBookingStart(15,5,2018);
        room001.setBookingEnd(17,5,2018);
        room001.printDates();
        guest002.accommodateToRoom(room001);
        guest002.completeIntel();

        System.out.println("\n");

        room001.setBookingStart(10,5,2018);
        room001.setBookingEnd(14,5,2018);
//        room001.printDates();



    }
}

/*
MENU:
    A. LOG IN
        A1. LOG OUT (AUTO-SAVE)
            1. RESERVATIONS
                1.1 MAKE NEW RESERVATION
                1.2 CONFIRM RESERVATION (unconfirmed reservations will be canceled automatically -> 4.3.1)
                1.3 SEARCH BY ROOM (shows available dates)
                1.4 SEARCH BY DATE (shows available rooms)
                1.5 EDIT RESERVATION
                1.6 CANCEL RESERVATION (and "Add a new one?")
                1.7 GO BACK
            2. CHECK-IN / CHECK-OUT
                2.1 CHECK-IN
                2.2 CHECK-OUT
                    2.2.1 PRINT BILL
                    2.2.2 GO BACK
                2.3 SEARCH BY NAME
                2.4 SEARCH BY ROOM
                2.5 SEARCH BY RESERVATION
                2.6 GO BACK
            3. PRINT
                3.1 DAILY INCOME
                3.2 MONTHLY INCOME
                3.3 GO BACK
            4. OPTIONS
                4.1 ROOMS
                    4.1.1 ADD NEW ROOM
                    4.1.2 EDIT ROOM
                    4.1.3 REMOVE ROOM
                    4.1.4 GO BACK
                4.2 SERVICES
                    4.2.1 ADD NEW SERVICE
                    4.2.2 EDIT SERVICE
                    4.2.3 REMOVE SERVICE
                    4.2.4 GO BACK
                4.3 OTHERS
                    4.3.1 SET AUTO-CANCELLING
                    4.3.2 GO BACK
                4.4 ACCOUNT
                    4.4.1 ADD NEW USER
                    4.4.2 EDIT USER
                    4.4.3 REMOVE USER
                    4.4.4 GO BACK
            5. GO BACK
    B. EXIT (AUTO-LOG OUT WITH AUTO-SAVE)
 */