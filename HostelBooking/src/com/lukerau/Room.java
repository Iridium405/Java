package com.lukerau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Room {
    private int roomNumber;
    private int maxAccommodated;
    public static final LocalDate TODAY = LocalDate.now();
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private boolean bookingStartSettingMade = false;
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

    private List<LocalDate> datesAvailable = Stream.iterate(TODAY, date -> date.plusDays(1))
            .limit(365)
            .collect(Collectors.toList());

    private List<LocalDate> bookingList = new ArrayList<>();

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxAccommodated() {
        return maxAccommodated;
    }

    public LocalDate getBookingStart() {
        bookingStartSettingMade = true;
        System.out.println("Booking start set to true.");
        return bookingStart;
    }

    public void setBookingStart(int day, int month, int year) {
        if (LocalDate.of(year, month, day).isBefore(TODAY)){
            System.out.println("That date already passed. Cannot make backward reservation.");
        } else if (!datesAvailable.contains(LocalDate.of(year, month, day))){
            System.out.println("The room is already taken on that day.");
        } else {
            bookingStart = LocalDate.of(year, month, day);
        }
    }

    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(int day, int month, int year) {
        if (bookingStartSettingMade) {
            if (!datesAvailable.contains(LocalDate.of(year, month, day))) {
                System.out.println("The room is already booked on that day.");
            } else {
                bookingEnd = LocalDate.of(year, month, day);
                LocalDate midDate_A = bookingStart;
                while (!midDate_A.isAfter(LocalDate.of(year, month, day))) {
                    LocalDate midDate_B = midDate_A.plusDays(1);
                    if (isBooked(datesAvailable, bookingList, midDate_A)) {
                        System.out.println(midDate_A);
                        midDate_A = midDate_B;
                    }
                }
            }
            bookingStartSettingMade = false;
        } else {
            System.out.println("No booking start date found.");
        }
    }

    private boolean isBooked(List<LocalDate> available, List<LocalDate> booked, LocalDate date) {
        if (date.isAfter(TODAY) && available.contains(date)){
            System.out.println("Booking completed: " + date);
            booked.add(date);
            available.remove(date);
            return true;
        } else {
            System.out.println("One of the dates is invalid: " + date);
            return false;
        }
    }

    public void printDates(){
        System.out.println("Dates available size: " + datesAvailable.size());
        System.out.println("Dates booked size: " + bookingList.size());
        System.out.println("Dates available: " + datesAvailable);
        System.out.println("Dates booked:: " + bookingList);
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
