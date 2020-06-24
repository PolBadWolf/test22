package org.example.test22.rs232;

import com.fazecast.jSerialComm.SerialPort;

public class RS232 implements Interface_RS232 {
    private static RS232 rs232 = null;
    private SerialPort port = null;

    public static RS232 Create() {
        if (rs232 == null)  rs232 = new RS232();
        return rs232;
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
    public boolean init(String portName) {
        return false;
    }
}
