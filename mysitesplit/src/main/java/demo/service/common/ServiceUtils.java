package demo.service.common;

import java.io.IOException;

public class ServiceUtils {

    /**
     * 挣扎
     * @param i 挣扎的次数
     */
    public void struggle(Integer i) throws IOException {
        if(i == 4) System.exit(0);
        stop(6);
        if(i == 3){
            System.out.println(("I am Alive"));
            return;
        }else{
            System.out.println(("aaaa"));
            struggle(i+1);
        }

    }


    public static void stop(Integer s){
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            System.out.println("睡眠不足");
        }
    }

    public static void main(String[] args) throws IOException {

        new ServiceUtils().struggle(0);
        System.out.println("hahaha");
    }
}
