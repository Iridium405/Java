package com.lukerau;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Room {
    private int roomNumber;
    private int maxAccommodated;
    private boolean occupied;
    private boolean booked;
    public static final LocalDate TODAY = LocalDate.now();
    private LocalDate bookingStart;
    private LocalDate midDate_A;
    private LocalDate midDate_B;
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

    List<LocalDate> listOfBookings = Stream.iterate(TODAY, date -> date.plusDays(1))
            .limit(365)
            .collect(Collectors.toList());
    OccupationSchedule occupSchedule = new OccupationSchedule(getBookingStart(),getBookingEnd());
    Set<LocalDate> schedule = new HashSet<>();

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public LocalDate getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(int day, int month, int year) {
        if (!listOfBookings.contains(LocalDate.of(year, month, day))){
            System.out.println("The room is already taken on that day.");
        } else {
            bookingStart = LocalDate.of(year, month, day);
        }
    }


    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(int day, int month, int year) {
        if (!listOfBookings.contains(LocalDate.of(year, month, day))) {
            System.out.println("The room is already booked on that day.");
        } else {
            bookingEnd = LocalDate.of(year, month, day);
            midDate_A = bookingStart;
            while(!midDate_A.isAfter(LocalDate.of(year, month, day))){
                midDate_B = midDate_A.plusDays(1);
                if (isBooked(listOfBookings,midDate_A)) {
                    System.out.println(midDate_A);
                    midDate_A = midDate_B;
                }
            }
        }
    }

    public boolean isBooked(List<LocalDate> list, LocalDate date) {
        if (date.isAfter(TODAY) && list.contains(date)){
            System.out.println("Booking completed: " + date);
            list.remove(date);
            return true;
        } else {
            System.out.println("One of the dates is invalid: " + date);
            return false;
        }
    }


    public void printDates(){
        System.out.println(listOfBookings.size());
        System.out.println(listOfBookings);
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


//    public boolean occupationCheck(){
//        // każdy pokój ma mieć hashSet z klasą Terminarz, gdzie zapisywane będą początki i końce rezerwacji
//        // a także blokowane wszystkie dni pomiędzy tymi datami
//        // occupationCheck będzie sprawdzał dostępność pokoju w danym terminie.
//    }

    /*
    * Napisać metodę wyszukującą wszystkie wolne pokoje w podanym przedziale czasowym.
        [wpisuję: 5.07.18 - 8.07.18 -> pokazuje mi, które pokoje będą wolne).
    * Napisać metodę wyszukującą najbliższy wolny termin dla konkretnego pokoju z ilością dni, kiedy jest dostępny.
      Dodać opcję szukania kolejnych wolnych terminów.
        [wpisuję: pokój nr 5 -> pokazuje mi np. 5.07.18 (5 dni)]
        [wpisuję: pokój nr 5, szukaj dalej -> pokazuje mi następny termin z ilością dostępnych dni.
    * Wprowadzić "potwierdzenie" - jeśli rezerwacja nie zostanie potwierdzona dzień przed - rezerwacja przepada.
     */
}
