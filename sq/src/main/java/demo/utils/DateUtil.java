package demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat officerSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrDateTime() {
        return officerSdf.format(new Date());
    }
}

