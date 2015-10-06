package com.sa.app;

import javax.swing.*;

public class ShutdownThread extends Thread {

    private JLabel info;
    private long time;
    private Shutdown shutdown;
    private ShutdownTimer shutdownTimer;

    public ShutdownThread(JLabel info) throws Exception {
        this.info = info;
        shutdown = new Shutdown();
        shutdownTimer = new ShutdownTimer();
    }

    public void shutdown(long time) {
        this.time = time;
        this.start();
    }

    public void cancle() throws Exception {
        this.time = -1;
        info.setText("00:00:00");
        this.interrupt();
        this.join();
    }

    @Override
    public void run() {
        try {
            while (time > 0) {
                sleep(1000);
                time = time - 1000;
                info.setText(shutdownTimer.recalculate(time));
            }
            shutdown.execute();
        } catch (Exception ex) {
            System.out.println("...cancle...");
            return;
        }
    }
}
