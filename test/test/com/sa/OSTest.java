package test.com.sa;

import com.sa.app.OS;
import org.junit.Test;

import static org.junit.Assert.*;

public class OSTest {

    @Test
    public void testGetOperatingSystem() throws Exception {
        String expected = OS.LINUX.getName();
        String result = OS.getOperatingSystem();
        assertTrue(expected.equals(result));
    }

    @Test
    public void testGetEnumOS() throws Exception {
        OS expected = OS.LINUX;
        OS result = OS.getEnumOS("Linux");
        assertTrue(expected == result);
    }

    @Test
    public void testGetShutdownCommandLinux() throws Exception {
        String expected = "shutdown -h now";
        String result = OS.getEnumOS("Linux").getShutdownCommand();
        assertTrue(expected.equals(result));
    }
}
