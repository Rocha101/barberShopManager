package com.barber.barbershop.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeIntervalCalculator {

    public static List<LocalTime> calculateTimeIntervals(LocalTime start_time, LocalTime end_time) {
        List<LocalTime> intervals = new ArrayList<>();

        // Make sure start_time is before end_time
        if (start_time.isAfter(end_time)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        // Calculate intervals
        LocalTime current_time = start_time;
        while (current_time.isBefore(end_time) || current_time.equals(end_time)) {
            intervals.add(current_time);
            current_time = current_time.plusMinutes(45);
        }

        return intervals;
    }

//    public static void main(String[] args) {
//        LocalTime start_time = LocalTime.of(8, 0); // Replace with your start time
//        LocalTime end_time = LocalTime.of(18, 0);  // Replace with your end time
//
//        List<LocalTime> intervals = calculateTimeIntervals(start_time, end_time);
//
//        for (LocalTime interval : intervals) {
//            System.out.println(interval);
//        }
//    }


}
