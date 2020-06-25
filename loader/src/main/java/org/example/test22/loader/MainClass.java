package org.example.test22.loader;

import org.example.test22.rs232.*;

import java.util.Arrays;

public class MainClass {
    private static MainClass mainClass = null;
    private Interface_RS232 rs232;
    public static void main(String[] args) {
        mainClass = new MainClass();
        if (args.length == 0)   mainClass.start(null);
        else                    mainClass.start(args[0]);
    }
    private void start(String name) {
        System.out.println("start constructor");
        rs232 = RS232.Create();
        int fl;
        if (name == null)   fl = Interface_RS232.INITCODE_NOTEXIST;
        else                fl = rs232.init(name, RS232.BAUD.baud57600);
        switch (fl) {
            case Interface_RS232.INITCODE_NOTEXIST:
                System.out.println("This port is not exist");
                System.out.println("System exist ports: " + Arrays.toString(rs232.getListPorts()));
                return;
            case Interface_RS232.INITCODE_ERROROPEN:
                System.out.println("Error open port");
                System.out.println("System exist ports: " + Arrays.toString(rs232.getListPorts()));
                return;
        }
        System.out.println("Port \"" + name + "\" is open");
        rs232.reciveStart();
        //
        while (rs232.reciveStart()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
