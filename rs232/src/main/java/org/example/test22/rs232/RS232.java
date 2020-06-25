package org.example.test22.rs232;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class RS232 implements Interface_RS232 {
    private static RS232 rs232 = null;
    private SerialPort port = null;

    @Override
    public Interface_RS232 getRS232() {
        return rs232;
    }

    public static RS232 Create() {
        if (rs232 == null)  rs232 = new RS232();
        return rs232;
    }
    public enum BAUD {
        baud300    (300),
        baud600    (600),
        baud1200   (1200),
        baud2400   (2400),
        baud4800   (4800),
        baud9600   (9600),
        baud14400  (14400),
        baud19200  (19200),
        baud28800  (28800),
        baud38400  (38400),
        baud56000  (56000),
        baud57600  (57600),
        baud115200 (115200);
        private int baud;

    BAUD(int baud) {
        this.baud = baud;
    }
    public int getValue() { return baud; }
}

    private RS232() {
    }

    @Override
    public String[] getListPorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        String[] namePorts = new String[ports.length];
        for (int i = 0; i < ports.length; i++) {
            namePorts[i] = ports[i].getSystemPortName();
        }
        return namePorts;
    }

    @Override
    public int init(String portName, RS232.BAUD baud) {
        boolean tmpFlag = false;
        // check exist port
        String name = portName.toUpperCase();
        SerialPort[] ports = SerialPort.getCommPorts();
        for (int i = 0; i < ports.length; i++) {
            if (ports[i].getSystemPortName().toUpperCase().equals(name)) tmpFlag = true;
        }
        if (!tmpFlag)   return INITCODE_NOTEXIST;
        // open port
        port = SerialPort.getCommPort(portName);
        port.setComPortParameters(baud.getValue(), 8, SerialPort.TWO_STOP_BITS, SerialPort.NO_PARITY);
        port.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 1000);
        tmpFlag = port.openPort(200);
        if (!tmpFlag)   return INITCODE_ERROROPEN;
        return INITCODE_OK;
    }

    @Override
    public boolean reciveStart() {
        if (port == null)   return false;
        if (!port.isOpen()) return false;
        port.removeDataListener();
        port.addDataListener(new ReciveListener());
        return true;
    }

    @Override
    public void reciveStop() {
        port.removeDataListener();
    }

    private static class ReciveListener implements SerialPortDataListener {
        @Override
        public int getListeningEvents() {
            return 100;
        }

        @Override
        public void serialEvent(SerialPortEvent event) {
            SerialPort curPort = event.getSerialPort();
            byte[] bytes = null;
            curPort.readBytes(bytes, 1);
        }
    }
}
