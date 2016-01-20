package lection20;

public class TrainSynchronized extends Train {
	public static Integer someInt = 0;

	public TrainSynchronized(int numberOfWagons, int initialPassengers) {
		super(numberOfWagons, initialPassengers);
	}

	public synchronized void movePassengersFromTo(int fromWagon, int toWagon, int passengers) {

		while (wagons[fromWagon] < passengers)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("");
		System.out.print(Thread.currentThread());
		wagons[fromWagon] -= passengers;
		System.out.print("Pass[" + passengers + "] from [" + fromWagon + "], to [" + toWagon + "]");
		wagons[toWagon] += passengers;
		System.out.print(" Total Pass: " + getTotalNumberOfPassengers());

		notifyAll();

	}

	public void incSomeInt() {
		synchronized (someInt) {
			System.out.println("SomeInt = " + someInt++);
		}

	}

	public synchronized int getTotalNumberOfPassengers() {
		int sum = 0;
		for (int numberOfPassengers : wagons)
			sum += numberOfPassengers;
		return sum;
	}

}
