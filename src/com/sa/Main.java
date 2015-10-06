package com.sa;

import com.sa.gui.MainWindow;

import javax.swing.*;

public class Main {

    private static void createAndShowGUI() {
        try {
            new MainWindow();
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
