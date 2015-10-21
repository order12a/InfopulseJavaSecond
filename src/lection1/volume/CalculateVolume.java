package lection1.volume;

public class CalculateVolume {


    public double calcObjectVolume(int mass, Metal metal){
        double volume = 0.0;
        if (metal.getDensity() > 0){
            System.out.println(metal.getDensity());
            volume = Math.round((double) mass / (double) metal.getDensity() * 10000) / 100;
        }else {
            System.out.println("Incorrect density for metal was set!");
        }
        return volume;
    }

    public double[] calcObjectVolumeForAllMetals(int mass){
        double[] volume = new double[12];
        for(Metal metal: Metal.values()){
            int i = 0;
            if (metal.getDensity() > 0){
//                System.out.println(metal.getDensity());
                volume[i] = Math.round((double) mass / (double) metal.getDensity() * 10000) / 100;
                System.out.println("Calculated volume: " + volume[i]);
            }else {
                System.out.println("Incorrect density for metal was set!");
            }
        }

        return volume;
    }
}
