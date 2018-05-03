package com.lukerau;

import java.util.HashSet;
import java.util.Set;

public class Guest {
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String idSerialNumber;
    private double totalCost;
    private double totalServiceCost;
    private Room theRoom;

    public Guest(String name, String surname, String address, String phoneNumber, String idSerialNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idSerialNumber = idSerialNumber;
        this.totalServiceCost = 0;
        this.totalCost = 0;
    }

    private Set<Service> serviceList = new HashSet<>();
    private Set<Double> fullCosts = new HashSet<>();

    private String getName() {
        return name;
    }

    private String getSurname() {
        return surname;
    }

    private String getAddress() {
        return address;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private String getIdSerialNumber() {
        return idSerialNumber;
    }

    private double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    private int nightsToStay(){
        long start = theRoom.getBookingStart().toEpochDay();
        long end = theRoom.getBookingEnd().toEpochDay();
        return (int) end - (int) start;
    }

    public void accommodateToRoom (Room room) {
        this.theRoom = room;
        int nights = nightsToStay();
        System.out.println(getName() + " " + getSurname() + " accommodated to room no." + theRoom.getRoomNumber());
        theRoom.setFullPrice(theRoom.getPriceDaily() * nights);
        System.out.println("Price daily: $" + theRoom.getPriceDaily() + "." + "\nArrival: " + theRoom.getBookingStart()
                + "\nDeparture: " + theRoom.getBookingEnd() + "\nNights to stay: " + nights);
        fullCosts.add(theRoom.getFullPrice());
    }

    public void addServiceToGuest(Service service) {
        serviceList.add(service);
        this.totalServiceCost += service.getServiceCost();
    }

    private void printServiceList(){
        for(Service s : serviceList){
            System.out.println("\tService: " + s.getServiceName() + "; Cost: $" + s.getServiceCost());
        }
        System.out.println("\tService summary: " + totalServiceCost);
    }

    private void printTotalCost(){
        System.out.println("Reservation: Room no. " + theRoom.getRoomNumber() + " - Cost: " + theRoom.getFullPrice());
        printServiceList();
        setTotalCost(totalServiceCost + theRoom.getFullPrice());
        System.out.print("\nTotal: " + getTotalCost());
    }

    public void completeIntel(){
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("ID: " + getIdSerialNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println();
        printTotalCost();
    }
}
