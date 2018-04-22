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

    public Room(int roomNumber, int maxAccommodated) {
        this.roomNumber = roomNumber;
        this.maxAccommodated = maxAccommodated;
    }


    SimpleDateFormat df = new SimpleDateFormat("E dd.mm.yyyy 'at' kk a zzz");

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public LocalDate getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(LocalDate bookingStart) {
        this.bookingStart = bookingStart;
    }

    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(LocalDate bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public double getPriceDaily() {
        return priceDaily;
    }
}
