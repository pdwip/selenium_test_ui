package com.hmh.technicalTest.ui.helpers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CommonHelpers {

    private final int SUCCESS_RESPONSE_CODE = 200;

    public String getCurrentDateAndTime(){
        LocalDate localDate = LocalDate.now();
        System.out.println("time:: "+localDate);

        int day = localDate.getDayOfMonth();
        System.out.println("day:: "+day);

        Month month = localDate.getMonth();
        System.out.println("month:: "+month);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("day of week :: "+dayOfWeek);

        String currentDateNTime = dayOfWeek.toString()+","+" "+String.valueOf(day)+" "+month.toString();
        System.out.println("final date:: "+currentDateNTime);
        return currentDateNTime;
    }
}
