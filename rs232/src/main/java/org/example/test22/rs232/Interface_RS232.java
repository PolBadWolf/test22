package org.example.test22.rs232;

public interface Interface_RS232 {
    String[] getListPorts();
    boolean init(String portName);
    //public boolean start();
    //public void stop();
}
