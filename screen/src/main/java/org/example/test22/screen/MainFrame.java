package org.example.test22.screen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Interface_MainFrame {
    private static MainFrame mainFrame = null;

    public static Interface_MainFrame Create() {
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
        this.setContentPane(getjContentPane());
        this.setVisible(true);
        jHighLabelStatus.setText("123");
    }
    // =================================================================
    private JPanel jContentPane = null;
    private JPanel jHighPane = null;
    private JPanel jMidllePane = null;
    private JLabel jHighLabelStatus = null;
    // =================================================================
    private JPanel getjContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.add(getjHighLabelStatus());
        }
        return jContentPane;
    }

    private JPanel getjHighPane() {
        if (jHighPane == null) {
            jHighPane = new JPanel();
            jHighPane.setBounds(0,0,1440,100);
            jHighPane.add(getjHighLabelStatus());
        }
        return jHighPane;
    }

    private JLabel getjHighLabelStatus() {
        if (jHighLabelStatus == null) {
            jHighLabelStatus = new JLabel();
            jHighLabelStatus.setBounds(100, 20, 300, 100);
            jHighLabelStatus.setForeground(Color.BLUE);
            jHighLabelStatus.setBackground(Color.RED);
        }
        return jHighLabelStatus;
    }

    // =================================================================

    @Override
    public void setjHighLabelStatusText(String text) {
        if (jHighLabelStatus == null)   return;
        jHighLabelStatus.setText(text);
    }
}
