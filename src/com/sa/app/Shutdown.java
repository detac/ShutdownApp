package com.sa.app;

public class Shutdown {

    private OS os;
    private String shutdownCommand;

    public Shutdown() throws Exception {
        os = OS.getEnumOS();
        shutdownCommand = os.getShutdownCommand();
    }

    public void execute() throws Exception {
        Runtime.getRuntime().exec(shutdownCommand);
        System.exit(0);

    }

    public OS getOs() {
        return os;
    }

    public String getShutdownCommand() {
        return shutdownCommand;
    }
}