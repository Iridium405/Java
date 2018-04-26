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
        if(occupationCheck) {
            return occupied;
        }
        return !occupied;
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

    public boolean occupationCheck(){
        // każdy pokój ma mieć hashSet z klasą Terminarz, gdzie zapisywane będą początki i końce rezerwacji
        // a także blokowane wszystkie dni pomiędzy tymi datami
        // occupationCheck będzie sprawdzał dostępność pokoju w danym terminie.
    }

    /*
    * Napisać metodę wyszukującą wszystkie wolne pokoje w podanym przedziale czasowym.
        [wpisuję: 5.07.18 - 8.07.18 -> pokazuje mi, które pokoje będą wolne).
    * Napisać metodę wyszukującą najbliższy wolny termin dla konkretnego pokoju z ilością dni, kiedy jest dostępny.
      Dodać opcję szukania kolejnych wolnych terminów.
        [wpisuję: pokój nr 5 -> pokazuje mi np. 5.07.18 (5 dni)]
        [wpisuję: pokój nr 5, szukaj dalej -> pokazuje mi następny termin z ilością dostępnych dni.
     */
}
