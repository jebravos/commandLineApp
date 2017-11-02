package org.jebs.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DateUtils {

    public static Date getDateFromLocalDateTime(LocalDateTime localDateTime){
        if(localDateTime == null){
            throw new IllegalArgumentException("localDateTime should not be null");
        }

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime getLocalDateTimeFromDate(Date date){
        return getLocalDateTimeFomDate(date, null);
    }

    public static LocalDateTime getLocalDateTimeFomDate(Date date, ZoneId zoneId){
        if(date == null){
            throw new IllegalArgumentException("date should not be null");
        }

        return LocalDateTime.ofInstant(date.toInstant(), zoneId != null ? zoneId : ZoneId.systemDefault());
    }

    public static Date addDays(Date date, int days){
        LocalDateTime newDate = getLocalDateTimeFromDate(date);
        return getDateFromLocalDateTime(newDate.plusDays(days));
    }

    public static Date addMonths(Date date, int months){
        LocalDateTime newDate = getLocalDateTimeFromDate(date);
        return getDateFromLocalDateTime(newDate.plusMonths(months));
    }

    public static Date addYears(Date date, int years){
        LocalDateTime newDate = getLocalDateTimeFromDate(date);
        return getDateFromLocalDateTime(newDate.plusYears(years));
    }

    public static Long until(Date fromDate, Date untilDate, TemporalUnit unit){
        return getLocalDateTimeFromDate(fromDate).until(getLocalDateTimeFromDate(untilDate), unit);
    }


}
