package lection20;

public class MovePassengersRunnable implements Runnable {
	private Train train;
	private int fromWagon;
	private int maxNumberofPassengers;
	private int DELAY = 10;

	public MovePassengersRunnable(Train train, int fromWagon, int maxNumberofPassengers) {
		this.train = train;
		this.fromWagon = fromWagon;
		this.maxNumberofPassengers = maxNumberofPassengers;
	}

	public void run() {
		try {
			while (true) {
				int toAccount = (int) (train.size() * Math.random());
				int amount = (int) (maxNumberofPassengers * Math.random());
				train.movePassengersFromTo(fromWagon, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}
}
