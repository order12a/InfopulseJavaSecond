package lection20;

import java.util.concurrent.locks.*;

public class TrainLockCondition extends Train {
	private Lock trainLock;
	private Condition hasEnoughPassengers;

	public TrainLockCondition(int numberOfWagons, int initialPassengers) {
		super(numberOfWagons, initialPassengers);
		this.trainLock = new ReentrantLock();
		this.hasEnoughPassengers = trainLock.newCondition();
	}

	public void movePassengersFromTo(int fromWagon, int toWagon, int passengers) {
		trainLock.lock();
		try {
			while (wagons[fromWagon] < passengers)
				hasEnoughPassengers.await();

			System.out.println("");
			System.out.print(Thread.currentThread());
			wagons[fromWagon] -= passengers;
			System.out.print("Pass[" + passengers + "] from [" + fromWagon + "], to [" + toWagon + "]");
			wagons[toWagon] += passengers;
			System.out.print(" Total Pass: " + getTotalNumberOfPassengers());

			hasEnoughPassengers.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
