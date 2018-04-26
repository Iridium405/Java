package com.lukerau;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdSerialNumber() {
        return idSerialNumber;
    }

    public void setIdSerialNumber(String idSerialNumber) {
        this.idSerialNumber = idSerialNumber;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    Service roomCleaning = new Service("Room cleaning",12.00);
    private Set<Service> serviceList = new HashSet<>();
    private Set<Double> fullCosts = new HashSet<>();

    public void addServiceToGuest(Service service) {
        serviceList.add(service);
        this.totalServiceCost += service.getServiceCost();
    }

    public void printServiceList(){
        for(Service s : serviceList){
            System.out.println("Name: " + s.getServiceName() + "; Cost: $" + s.getServiceCost());
        }
        System.out.println("Service total: " + totalServiceCost);
    }

    public void accommodateToRoom (Room room) {
        if (!room.isOccupied()){
            this.theRoom = room;
            int days = daysToStay();
            theRoom.setFullPrice(theRoom.getPriceDaily() * days);
            System.out.println("Price daily: " + theRoom.getPriceDaily() + " Days to stay: " + days);
            fullCosts.add(theRoom.getFullPrice());
            room.isOccupied();
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is occupied.");
        }
    }

    public int daysToStay(){
        long start = theRoom.getBookingStart().toEpochDay();
        long end = theRoom.getBookingEnd().toEpochDay();
        int diff =  (int) end - (int) start;
        return diff;
    }

    public void printTotalCost(){
        System.out.println("Name: Room no." + theRoom.getRoomNumber() + ". Cost: " + theRoom.getFullPrice());
        printServiceList();
        setTotalCost(totalServiceCost + theRoom.getFullPrice());
        System.out.print("\tTotal: " + getTotalCost());

    }

    public String completeIntel(){
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Address: " + getAddress());
        System.out.println("Total: " + getTotalCost());
        return "1";
    }
}
