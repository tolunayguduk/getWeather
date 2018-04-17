package com.tolunayguduk.hava_durumu;

import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tolunayguduk on 16.04.2018.
 */

public class getDateFromTimeMilis {
    public static String time(long time) {



        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date(time);
        String dayOfTheWeek = sdf.format(d);






        return dayOfTheWeek;
    }
}
