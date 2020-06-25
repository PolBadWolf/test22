package org.example.test22.screen;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame mainFrame = null;

    public static MainFrame Create() {
        if (mainFrame == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    mainFrame = new MainFrame();
                    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });
        }
        while (mainFrame == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mainFrame;
    }

    private MainFrame() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(1440, 960);
        this.setResizable(false);
        this.setVisible(true);
    }
}
