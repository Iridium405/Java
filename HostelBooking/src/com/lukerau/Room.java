package com.lukerau;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Room {
    private int roomNumber;
    private int maxAccommodated;
    private boolean occupied;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private double priceDaily;
    private double fullPrice;

    public Room(int roomNumber, int maxAccommodated) {
        this.roomNumber = roomNumber;
        this.maxAccommodated = maxAccommodated;
        if(maxAccommodated == 1){
            this.priceDaily = 60;
        } else if (maxAccommodated ==2) {
            this.priceDaily = maxAccommodated * 45;
        } else if (maxAccommodated > 2 && maxAccommodated < 6) {
            this.priceDaily = maxAccommodated * 30;
        } else {
            System.out.println("There cannot be more than 6 people in the room or less than 1.");
        }
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public LocalDate getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(int day, int month, int year) {
        this.bookingStart = LocalDate.of(year, month, day);
    }

    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(int day, int month, int year) {
        this.bookingEnd = LocalDate.of(year, month, day);
    }

    public double getPriceDaily() {
        return priceDaily;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }
}
