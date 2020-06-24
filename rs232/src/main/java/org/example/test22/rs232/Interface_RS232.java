package org.example.test22.rs232;

public interface Interface_RS232 {
    String[] getListPorts();
    boolean init(String portName, RS232.BAUD baud);
    boolean reciveStart();
    void reciveStop();
}
