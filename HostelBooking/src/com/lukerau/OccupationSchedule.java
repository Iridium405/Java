package com.lukerau;

import java.time.LocalDate;

public class OccupationSchedule {
    private LocalDate start;
    private LocalDate end;

    public OccupationSchedule(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }


    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

//    public LocalDate booked() {
//
//    }

}
