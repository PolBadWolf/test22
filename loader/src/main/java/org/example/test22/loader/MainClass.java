package org.example.test22.loader;

import org.example.test22.rs232.*;

public class MainClass {
    private static MainClass mainClass = null;
    public static void main(String[] args) {
        mainClass = new MainClass();
        if (args.length == 0)   mainClass.start(null);
        else                    mainClass.start(args[0]);
    }
    private void start(String name) {
        System.out.println("start constructor");
        Interface_RS232 rs232 = RS232.Create();
        boolean fl = false;
        if (name != null) {
            fl = rs232.init(name, RS232.BAUD.baud57600);
        }
        if (!fl) {
            String[] namePort = rs232.getListPorts();
            for (int i = 0; i < namePort.length; i++) {
                System.out.println(i + ") " + namePort[i]);
            }
            return;
        }
        rs232.reciveStart();
        //
    }
}
