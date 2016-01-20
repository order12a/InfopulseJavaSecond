package lection20;

import java.util.concurrent.locks.*;

public class TrainLock extends Train {

	private Lock trainLock;

	public TrainLock(int numberOfWagons, int initialPassengers) {
		super(numberOfWagons, initialPassengers);
		this.trainLock = new ReentrantLock(false);
	}

	public void movePassengersFromTo(int fromWagon, int toWagon, int passengers) {

		trainLock.lock();
		try {
			System.out.println("");
			System.out.print(Thread.currentThread());
			wagons[fromWagon] -= passengers;

			System.out.print("Pass[" + passengers + "] from [" + fromWagon + "], to [" + toWagon + "]");
			wagons[toWagon] += passengers;
			System.out.print(" Total Pass: " + getTotalNumberOfPassengers());
		} finally {
			trainLock.unlock();
		}
	}

	public int getTotalNumberOfPassengers() {
		int sum = 0;
		trainLock.lock();
		try {
			for (int numberOfPassengers : wagons)
				sum += numberOfPassengers;
			return sum;
		} finally {
			trainLock.unlock();
		}
	}

}
