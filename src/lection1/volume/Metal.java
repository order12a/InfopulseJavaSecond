package lection1.volume;

public enum Metal {
    Steel(10000),
    Silumine(2000),
    Bronze(9000),
    Gold(11000),
    Silver(9500),
    Platimun(10500);

    private int density;

    Metal(int density){
        this.density = density;
    }

    public int getDensity() {
        return density;
    }
}
