package com.ping.utile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtiles {
    public static  String DatetoString(Date date, String patt){
        SimpleDateFormat sft=new SimpleDateFormat(patt);
        String form=  sft.format(date);
        return form;
    }
    public  static  Date StringtoDate(String patt,String s) throws Exception{
        SimpleDateFormat sf=new SimpleDateFormat(s);
       Date date= sf.parse(patt);
      return date;
    }
}
