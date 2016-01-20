package lection20;

public class TrainSimple extends Train {

	public TrainSimple(int numberOfWagons, int initialPassengers) {
		super(numberOfWagons, initialPassengers);
	}

	public void movePassengersFromTo(int fromWagon, int toWagon, int passengers) {

		if (wagons[fromWagon] < passengers)
			return;
		System.out.println("");
		System.out.print(Thread.currentThread());
		wagons[fromWagon] -= passengers;

		System.out.print("Pass[" + passengers + "] from [" + fromWagon + "], to [" + toWagon + "]");
		wagons[toWagon] += passengers;
		System.out.print(" Total Pass: " + getTotalNumberOfPassengers());
	}

	public int getTotalNumberOfPassengers() {
		int sum = 0;
		for (int numberOfPassengers : wagons)
			sum += numberOfPassengers;
		return sum;
	}

}
