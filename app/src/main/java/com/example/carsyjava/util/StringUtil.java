package com.example.carsyjava.util;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class StringUtil {
    private StringUtil(){}
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.forLanguageTag("pl"));
    public static DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
}
