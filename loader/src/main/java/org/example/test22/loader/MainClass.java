package org.example.test22.loader;

public class MainClass {
    private static MainClass mainClass = null;
    public static void main(String[] args) {
        (mainClass = new MainClass()).start();
    }
    private void start() {
        System.out.println("start constructor");
    }
}
