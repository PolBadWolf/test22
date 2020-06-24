package org.example.test22.rs232;

import com.fazecast.jSerialComm.SerialPort;

import java.util.concurrent.atomic.AtomicBoolean;

public class RS232 implements Interface_RS232, Runnable {
    private static RS232 rs232 = null;
    public static Interface_RS232 Create() {
        if (rs232 == null) {
            rs232 = new RS232();
        }
        return rs232;
    }
    // =============================
    private RS232() {
        thread = new Thread(rs232);
    }
    private AtomicBoolean running = new AtomicBoolean(false);
    private Thread thread = null;
    @Override
    public void run() {
        while (running.get()) {

        }
    }
    // =============================
    public void start() {
        running.set(true);
        thread.start();
    }
    public void stop() {
        running.set(false);
    }
    // =============================
    // =============================
}
