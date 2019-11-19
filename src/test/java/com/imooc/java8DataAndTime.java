package com.imooc;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author : Fy
 * @date : 2018-04-24 17:32
 */
public class java8DataAndTime {

    public static void main(String[] args) {


//        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
//        LocalDate date1 = dt1.toLocalDate();
//        System.out.println(date1);
//        LocalTime time1 = dt1.toLocalTime();
//        System.out.println(time1);
//
//
//        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
//        System.out.println(instant);
//
//        Instant now = Instant.now();
//        System.out.println(now);
//
//
//        LocalTime time = LocalTime.of(13, 45, 20);
//        int hour = time.getHour();
//        int minute = time.getMinute();
//        int second = time.getSecond();
//        System.out.println(time);
//
//        Duration d1 = Duration.between(LocalTime.of(13, 45, 10), time);
//        Duration d2 = Duration.between(instant, now);
//        System.out.println(d1.getSeconds());
//        System.out.println(d2.getSeconds());
//
//        Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
//        System.out.println(tenDays);


        LocalDate dateOne = LocalDate.of(2014, 3, 18);
        System.out.println(dateOne);

        //将当前的时间加上一周的开发时间
        LocalDate dateTwo = dateOne.plusWeeks(1);
        System.out.println("Week:" + dateTwo);

        LocalDate localDate3 = dateOne.minusYears(3);
        System.out.println(localDate3);

        LocalDate plus4 = dateOne.plus(6, ChronoUnit.MONTHS);
        System.out.println(plus4);


    }


}
