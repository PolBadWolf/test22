package org.example.test22.loader;

import org.example.test22.rs232.*;

public class MainClass {
    private static MainClass mainClass = null;
    public static void main(String[] args) {
        (mainClass = new MainClass()).start();
    }
    private void start() {
        System.out.println("start constructor");
        Interface_RS232 rs232 = RS232.Create();
        String[] namePort = rs232.getListPorts();
        for (int i = 0; i < namePort.length; i++) {
            System.out.println(i + ") " + namePort[i]);
        }
    }
}
