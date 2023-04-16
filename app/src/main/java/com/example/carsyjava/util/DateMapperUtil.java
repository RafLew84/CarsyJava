package com.example.carsyjava.util;

import java.time.Month;

public final class DateMapperUtil {
    private DateMapperUtil(){}

    public static String polishMonthsNames(Month month) {
        switch (month) {
            case JANUARY:
                return "STYCZEŃ";
            case FEBRUARY:
                return "LUTY";
            case MARCH:
                return "MARZEC";
            case APRIL:
                return "KWIECIEŃ";
            case MAY:
                return "MAJ";
            case JUNE:
                return "CZERWIEC";
            case JULY:
                return "LIPIEC";
            case AUGUST:
                return "SIERPIEŃ";
            case SEPTEMBER:
                return "WRZESIEŃ";
            case OCTOBER:
                return "PAŹDZIERNIK";
            case NOVEMBER:
                return "LISTOPAD";
            case DECEMBER:
                return "GRUDZIEŃ";
            default:
                return "unknown";
        }
    }

}

