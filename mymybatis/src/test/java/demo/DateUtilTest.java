package demo;

import demo.util.DateUtil;
import org.junit.Test;

import java.text.ParseException;

public class DateUtilTest {

    @Test
    public void testGetMonthBetween() throws ParseException {
        String startTime = "2017-12";
        String endTime = "2017-12";
        System.out.println(DateUtil.getMonthBetween(startTime,endTime));
    }
}
