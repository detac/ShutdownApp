package com.sa.app;

public class Shutdown {

    public Shutdown(){
    }

    public void execute(){
        try{
            OS os = OS.getEnumOS();
            String shutdownCommand = os.getShutdownCommand();
            Runtime.getRuntime().exec(shutdownCommand);
            System.exit(0);
        }catch(Exception ex){}
    }
}