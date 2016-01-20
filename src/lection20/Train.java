package lection20;

public abstract class Train {
	protected final int[] wagons;

	public Train(int numberOfPassengers, int initialPassengers) {
		wagons = new int[numberOfPassengers];
		for (int i = 0; i < wagons.length; i++)
			wagons[i] = initialPassengers;
	}

	public abstract void movePassengersFromTo(int fromWagon, int toWagon, int passengers);

	public abstract int getTotalNumberOfPassengers();

	public int size() {
		return wagons.length;
	}
}
