package com.sa.app;

public enum OS {

    LINUX("Linux", "shutdown -h now"),
    MACOS("Mac OS X", "shutdown -h now"),
    WINDOWS("Windows", "shutdown.exe -s -t 0");

    private final String name;
    private final String shutdownCommand;

    private OS(String name, String shutdownCommand) {
        this.name = name;
        this.shutdownCommand = shutdownCommand;
    }

    public String getName() {
        return name;
    }

    public String getShutdownCommand() {
        return shutdownCommand;
    }

    public static String getOperatingSystem() {
        return System.getProperty("os.name");
    }

    public static OS getEnumOS(String operatingSystemName) throws Exception {
        for (OS os : values()) {
            if (os.name.equals(operatingSystemName)) {
                return os;
            }
        }
        throw new Exception();
    }

    public static OS getEnumOS()throws Exception{
        return getEnumOS(getOperatingSystem());
    }
}
