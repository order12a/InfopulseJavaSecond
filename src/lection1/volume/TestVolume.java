package lection1.volume;

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
    public void TestVolume(){
        Assert.assertEquals(44.0, calculateVolume.calcObjectVolume(4000, Metal.Bronze), 10.0);
    }
}
