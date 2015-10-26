package lection1.volume;

public class CalculateVolume {


    public double calcObjectVolume(int mass, Metal metal){
        double volume = 0.0;
        try {
//            if (metal.getDensity() > 0 && mass > 0){
//                System.out.println(metal.getDensity());
                volume = Math.round((double) mass / (double) metal.getDensity() * 10000) / 100;
            System.out.println(volume);
//            }
        }catch (Exception e){
            throw new IllegalArgumentException("Division by zero. Density of metal could not be less or equal 0.");
        }
        return volume;
    }

    public double[] calcObjectVolumeForAllMetals(int mass){
        double[] volume = new double[12];
        for(Metal metal: Metal.values()){
            int i = 0;
            try{
//                System.out.println(metal.getDensity());
                    volume[i] = Math.round((double) mass / (double) metal.getDensity() * 10000) / 100;
                    System.out.println("Calculated volume: " + volume[i]);
            }catch (Exception e){
                throw new IllegalArgumentException("Incorrect density. Could not be less than 0 or 0.");
            }
        }
        return volume;
    }
}
