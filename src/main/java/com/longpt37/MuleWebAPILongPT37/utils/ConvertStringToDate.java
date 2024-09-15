package com.longpt37.MuleWebAPILongPT37.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertStringToDate {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
    public Date convertDate(String date) throws ParseException {
        Date tmp = new Date(formatter.parse(date).getTime());
        return tmp;
    }
}
