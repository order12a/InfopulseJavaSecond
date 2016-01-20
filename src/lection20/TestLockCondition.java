package lection20;

public class TestLockCondition {
	public static final int WAGONS = 10;
	public static final int INITIAL_NUMBER_OF_PASSENGERS = 200;

	public static void main(String[] args) {

		Train train = new TrainSimple(WAGONS, INITIAL_NUMBER_OF_PASSENGERS);
//		Train train = new TrainLock(WAGONS, INITIAL_NUMBER_OF_PASSENGERS);
//		Train train = new TrainLockCondition(WAGONS, INITIAL_NUMBER_OF_PASSENGERS);
//		Train train = new TrainSynchronized(WAGONS, INITIAL_NUMBER_OF_PASSENGERS);

		for (int i = 0; i < WAGONS; i++) {
			MovePassengersRunnable r = new MovePassengersRunnable(train, i, INITIAL_NUMBER_OF_PASSENGERS);
			Thread t = new Thread(r);
			t.start();
		}

	}

}
