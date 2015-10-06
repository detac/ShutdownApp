package com.sa.gui;

import com.sa.app.ShutdownThread;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    private static String SHUTDOWN = "Shutdown";
    private static String CANCLE = "Cancle";

    private JFrame frame;
    private JPanel panel;
    private JTextField hh;
    private JLabel l_hh;
    private JTextField mm;
    private JLabel l_mm;
    private JTextField ss;
    private JButton button;
    private JLabel info;
    private ShutdownThread thread;

    public MainWindow() throws Exception {
        init();
        add();
        frameSetup();

        textFieldSetup();
        labelSetup();
        buttonSetup();

        frame.setVisible(true);
    }

    public void init() throws Exception {
        frame = new JFrame();
        panel = new JPanel();
        hh = new JTextField();
        l_hh = new JLabel();
        mm = new JTextField();
        l_mm = new JLabel();
        ss = new JTextField();
        button = new JButton();
        info = new JLabel();
    }

    public void add() {
        panel.add(hh);
        panel.add(l_hh);
        panel.add(mm);
        panel.add(l_mm);
        panel.add(ss);
        panel.add(button);
        panel.add(info);
        frame.add(panel);
    }

    private void textFieldSetup() {
        hh.setColumns(2);
        hh.addKeyListener(new JTextFieldKeyAdapter(hh));
        hh.requestFocus();
        mm.setColumns(2);
        mm.addKeyListener(new JTextFieldKeyAdapter(mm));
        ss.setColumns(2);
        ss.addKeyListener(new JTextFieldKeyAdapter(ss));
    }

    private void setEditableTextFieldSetup(boolean isEditable) {
        hh.setEditable(isEditable);
        mm.setEditable(isEditable);
        ss.setEditable(isEditable);
    }

    private void labelSetup() {
        l_hh.setText(":");
        l_mm.setText(":");
    }

    private void buttonSetup() {
        button.setText(SHUTDOWN);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String status = button.getText();
                    if (status.equals(SHUTDOWN)) {
                        thread = new ShutdownThread(info);
                        thread.shutdown(collectData());
                        button.setText(CANCLE);
                        setEditableTextFieldSetup(false);
                    } else {
                        info.setText("");
                        button.setText(SHUTDOWN);
                        setEditableTextFieldSetup(true);
                        thread.cancle();
                    }
                } catch (Exception ex) {
                }
            }
        });
    }

    private void frameSetup() {
        frame.setTitle("Shutdown App");
        frame.setBounds(100, 50, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private long collectData() {
        int hours = castStringToInt(hh.getText());
        int minutes = castStringToInt(mm.getText());
        int seconds = castStringToInt(ss.getText());

        return ((hours * 3600) + (minutes * 60) + seconds) * 1000;
    }

    private int castStringToInt(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        if (value.startsWith("0")) {
            return Integer.valueOf(value.charAt(1) + "");
        }

        return Integer.valueOf(value);
    }
}
