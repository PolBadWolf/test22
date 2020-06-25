package org.example.test22.rs232;

public interface Interface_RS232 {
    Interface_RS232 getRS232();
    String[] getListPorts();
    int init(String portName, RS232.BAUD baud);
    boolean reciveStart();
    void reciveStop();
    boolean getRecive();
    final int INITCODE_OK = 0;
    final int INITCODE_NOTEXIST = 1;
    final int INITCODE_ERROROPEN = 2;
}
