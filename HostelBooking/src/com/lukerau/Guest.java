package com.lukerau;

import java.util.HashSet;
import java.util.Set;

public class Guest {
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String idSerialNumber;
    private double totalCost = 0;
    private double totalServiceCost = 0;

    public Guest(String name, String surname, String address, String phoneNumber, String idSerialNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idSerialNumber = idSerialNumber;

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

    Service roomcleaning = new Service("Room cleaning",12.00);
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
        System.out.println("Total: " + totalServiceCost);
    }

    public void printTotalCost(){

    }
}
