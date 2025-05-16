package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private String username;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Attendance(String username) {
        this.username = username;
        this.date = LocalDate.now();
    }

    public void punchIn() {
        this.startTime = LocalTime.now();
    }

    public void punchOut() {
        this.endTime = LocalTime.now();
    }

    public String getSummary() {
        return date + " 出勤: " + startTime + " 退勤: " + endTime;
    }
}
