package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String start = (startTime != null) ? startTime.format(timeFormatter) : "未打刻";
        String end = (endTime != null) ? endTime.format(timeFormatter) : "未打刻";

        return date + " 出勤: " + start + " 退勤: " + end;
    }
}
