package lection1.volume;

public class VolumeTest {
    public static void main(String[] args){
        System.out.println(new CalculateVolume().calcObjectVolume(4000, Metal.Silver));
        new CalculateVolume().calcObjectVolumeForAllMetals(6000);
    }
}
