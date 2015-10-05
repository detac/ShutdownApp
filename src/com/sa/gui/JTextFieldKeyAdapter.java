package com.sa.gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextFieldKeyAdapter extends KeyAdapter {

    private JTextField jTextField;

    public JTextFieldKeyAdapter(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        if (isNumber(c)) {
            if (jTextField.getText().isEmpty() && checkFirst(c)) {
                return;
            } else {
                if (jTextField.getText().length() == 1 && checkSecond(c)) {
                    return;
                }
            }
        }
        e.consume();
    }

    private boolean isNumber(char c) {
        return !((c < '0' || c > '9') && (c != '\b'));
    }

    private boolean checkFirst(char c) {
        return (c >= '0') && (c <= '5');
    }

    private boolean checkSecond(char c) {
        return (c >= '0') && (c <= '9');
    }
}
