package demo;

import org.junit.Test;

public class HotLoadTest {

    private String str = "aqiang";

    @Test
    public void testOne() throws InterruptedException {
        for(int i = 0 ;i < 20 ;i++){
            Thread.sleep(5000);
            System.out.println(i+" testOne : "+str);
        }
    }

    @Test
    public void testTwo() throws InterruptedException {
        for(int i = 0 ;i < 20 ;i++){
            Thread.sleep(5000);
            System.out.println(i+" testTwo1 : "+str);
        }
    }


}
