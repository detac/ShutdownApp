package test.com.sa;

import com.sa.app.ShutdownTimer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShutdownTimerTest {

    private ShutdownTimer shutdownTimer = new ShutdownTimer();

    @Test
    public void testHours()throws Exception{
        String expected = "01:00:00";
        String result = shutdownTimer.recalculate(3600000);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testMinutes()throws Exception{
        String expected = "00:01:00";
        String result = shutdownTimer.recalculate(60000);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testSeconds()throws Exception{
        String expected = "00:00:01";
        String result = shutdownTimer.recalculate(1000);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testHoursAndMinutes()throws Exception{
        String expected = "01:01:00";
        String result = shutdownTimer.recalculate(3600000+60000);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testHoursAndSeconds()throws Exception{
        String expected = "01:00:01";
        String result = shutdownTimer.recalculate(3600000+1000);
        assertTrue(expected.equals(result));
    }


    @Test
    public void testMinutesAndSeconds()throws Exception{
        String expected = "00:01:01";
        String result = shutdownTimer.recalculate(60000+1000);
        assertTrue(expected.equals(result));
    }


    @Test
    public void testAll()throws Exception{
        String expected = "01:01:01";
        String result = shutdownTimer.recalculate(3600000+60000+1000);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testZero()throws Exception{
        String expected = "00:00:00";
        String result = shutdownTimer.recalculate(0);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testNegative()throws Exception{
        String expected = "00:00:00";
        String result = shutdownTimer.recalculate(-60000);
        assertTrue(expected.equals(result));
    }
}
