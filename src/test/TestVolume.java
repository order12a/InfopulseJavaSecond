package test;

import lection1.days.DayDetector;
import lection1.days.God;
import lection1.volume.CalculateVolume;
import lection1.volume.Metal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by order on 21.10.15.
 */
public class TestVolume {
    CalculateVolume calculateVolume;

    @Before
    public void setUp(){
        calculateVolume = new CalculateVolume();
    }

    @Test
    public void testDay(){
        Assert.assertEquals("Monday", new DayDetector().getDay(God.Tutu));
    }

    @Test
    public void testAllDaysResponse(){

    }

    @Test
    public void testVolume(){
        Assert.assertEquals(44.0, calculateVolume.calcObjectVolume(4000, Metal.Bronze), 10.0);
    }

    @After
    public void tearDown(){
        System.out.println("Exit test stub");
    }
}
