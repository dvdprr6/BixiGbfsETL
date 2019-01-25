package com.david.GBFSCron.main;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){

    }

    private static void sleep5Seconds(){
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
