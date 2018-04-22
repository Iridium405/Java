package com.lukerau;


public class Main {

    public static void main(String[] args) {

        Room room001 = new Room(1,2);

        Guest guest001 = new Guest("Luke","Rau","Spacerowa","997-112-123", "123465798");

        Service roomcleaning = new Service("Room cleaning",12.00);
        Service breakfast = new Service("Breakfast", 8.50);

        guest001.addServiceToGuest(roomcleaning);
        guest001.addServiceToGuest(breakfast);
        guest001.printServiceList();


    }
}
