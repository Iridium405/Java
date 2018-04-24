package com.lukerau;


public class Main {

    public static void main(String[] args) {

        Room room001 = new Room(1,2);
        Room room002 = new Room(2,1);
        Room room003 = new Room(3,4);

        Guest guest001 = new Guest("Luke","Rau","Spacerowa","997-112-123", "123465798");
        Guest guest002 = new Guest("Anna","Unknown","Unknown","456-1237-89", "555999461");

        Service roomcleaning = new Service("Room cleaning",12.00);
        Service breakfast = new Service("Breakfast", 8.50);
        Service dogAccommodation = new Service("Dog Accommodation", 15.00);


        room001.setBookingStart(5,5,2018);
        room001.setBookingEnd(12,5,2018);
        guest001.accommodateToRoom(room001);
        guest001.addServiceToGuest(roomcleaning);
        guest001.addServiceToGuest(breakfast);
        guest001.printTotalCost();

        room001.setBookingStart(5,5,2018);
        room001.setBookingEnd(12,5,2018);
        guest002.accommodateToRoom(room001);                // bug
        guest002.printTotalCost();



    }
}
