package lection1.volume;

public class VolumeTest {
    public static void main(String[] args){
        System.out.println(new CalculateVolume().calcObjectVolume(200, Metal.Steel));
        new CalculateVolume().calcObjectVolumeForAllMetals(6000);
    }
}
