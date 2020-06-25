package org.example.test22.loader;

import org.example.test22.rs232.*;
import org.example.test22.screen.MainFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

public class MainClass {
    private static MainClass mainClass = null;
    protected Interface_RS232 rs232;
    private MainFrame mainFrame;

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
        mainFrame = MainFrame.Create();
        mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                rs232.reciveStop();
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        //
    }
}
