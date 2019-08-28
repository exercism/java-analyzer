package com.df.datafast.gigasecond;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Gigasecond() {
    }

    public Gigasecond(LocalDate birthDate) {
        this.startDateTime = birthDate.atStartOfDay();
        this.endDateTime = startDateTime.plusSeconds(1000000000);
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.startDateTime = birthDateTime;
        this.endDateTime = startDateTime.plusSeconds(1000000000);
    }

    public LocalDateTime getDateTime() {
        return endDateTime;
    }

}
