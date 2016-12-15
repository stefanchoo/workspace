package com.mj.example.dm.tester;

import java.util.concurrent.TimeUnit;

import com.mj.example.dm.Greeting;

public class Tester {
    
    private volatile Greeting m_greeter;   // new proxy object
    private volatile Thread m_printer;
    
    public void start(){
        System.out.println("Tester service starting ...");
        
        m_printer = new Thread(()->{
            while(!Thread.interrupted()) {
                System.out.println("Greeting: " + m_greeter.greet("Amdatu"));
                
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        m_printer.start();
    }
    
    public void stop() {
        System.out.println("Tester service stopping ...");
        m_printer.interrupt();
    }
}