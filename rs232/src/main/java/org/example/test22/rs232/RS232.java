package org.example.test22.rs232;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RS232 implements Interface_RS232 {
    private static RS232 rs232 = null;
    public static Interface_RS232 Create() {
        if (rs232 == null) {
            rs232 = new RS232();
        }
        return rs232;
    }
    // =============================
    private RS232() {
//        recice = new Recice();
//        thread = new Thread(recice);
    }
//    private Recice recice = null;
//    private Thread thread = null;
    private SerialPort serialPort = null;
    // =============================
    public void start() {
//        recice.start();
//        thread.start();
        serialPort = SerialPort.getCommPort("COM2");
        serialPort.setComPortParameters(57600, 8, SerialPort.TWO_STOP_BITS, SerialPort.NO_PARITY);
        serialPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 1, 1);
        serialPort.addDataListener(new Reciver());
        serialPort.openPort();
    }
    public void stop() {
        serialPort.removeDataListener();
        serialPort.closePort();
        serialPort = null;
    }
    // =============================
    private class Reciver implements SerialPortDataListener {
        byte[] bytes = null;
        @Override
        public int getListeningEvents() {
            return 100;
        }

        @Override
        public void serialEvent(SerialPortEvent serialPortEvent) {
            serialPort.readBytes(bytes, 1);
        }
    }
    // =============================
}
