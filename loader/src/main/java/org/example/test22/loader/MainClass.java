package org.example.test22.loader;

import org.example.test22.rs232.Interface_RS232;
import org.example.test22.rs232.RS232;

public class MainClass {
    private static MainClass mainClass = null;
    public static void main(String[] args) {
        (mainClass = new MainClass()).start();
    }
    private void start() {
        System.out.println("start constructor");
        Interface_RS232 rs232 = RS232.Create();
        rs232.start();
        try {
            Thread.sleep(1_000_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
