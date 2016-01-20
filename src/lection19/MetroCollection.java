package lection19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class MetroCollection {
	final static int WAGONS_IN_DEPOT = 100;

	/**
	 * Депо с вагонами
	 */
	LinkedList<Wagon> depot;
	/**
	 * Все поезда
	 */
	HashSet<Train> trains;

	// HashMap<String, Line> allLines;

	Line redLine, blueLine, greenLine;
	Queue<Driver> driverQueue;
	Map<String, LinkedList<Passenger>> passengersInStation;
	Random rnd;

	Comparator<Driver> comparator;

	/**
	 * Всё метро
	 */
	ArrayList<Line> metroKiev;

	/**
	 * Constructs Mrtro
	 */
	public MetroCollection() {
		rnd = new Random();

		metroKiev = new ArrayList<>();
		depot = new LinkedList<Wagon>();
		trains = new LinkedHashSet<Train>();
		passengersInStation = new HashMap<>();
	}

	/**
	 * Creates wagons for depot collection. Approx. 30% of header wagons will be
	 * created
	 */
	public void createWagons() {
		for (int i = 0; i < WAGONS_IN_DEPOT; i++) {
			Wagon wgn = new Wagon("wagonchik" + i, (rnd.nextInt(100) < 30));
			depot.add(wgn);
		}
	}

	/**
	 * Creates trains from depot wagons using train
	 * {@link jII_collections_practice9.Train#addWagon addWagon} method. <br>
	 * Adds ready to go train to trains collection
	 */
	public void createTrains() {
		// наполнение поездов вагонами
		// максимальное количество поездов - размер депо / на количество вагонов
		// в поезде
		int maxTrainsNumber = depot.size() / Train.MAX_NUMBER_OF_WAGONS;

		for (int j = 0; j < maxTrainsNumber; j++) {
			Train train = new Train("Train " + j, "00" + j);
			while (!depot.isEmpty()) {
				train.addWagon(depot.poll());
				if (train.size == Train.MAX_NUMBER_OF_WAGONS)
					break;
			}
			if (train.readyToGo)
				trains.add(train);
		}
	}

	/**
	 * Creates three lines. Adds them to metroKiev collection.
	 */
	public void createLines() {
		redLine = new Line("Red");
		blueLine = new Line("Blue");
		greenLine = new Line("Green");

		metroKiev.add(redLine);
		metroKiev.add(blueLine);
		metroKiev.add(greenLine);
	}

	/**
	 * Adds trains from trains collection to a line trains.
	 */
	public void createLineTrains() {
		redLine.setLineTrains(new LinkedList<Train>());
		blueLine.setLineTrains(new LinkedList<Train>());
		greenLine.setLineTrains(new LinkedList<Train>());

		Iterator<Train> iter = trains.iterator();

		while (iter.hasNext()) {
			redLine.lineTrains.add(iter.next());
			if (iter.hasNext())
				blueLine.lineTrains.add(iter.next());
			if (iter.hasNext())
				greenLine.lineTrains.add(iter.next());
		}

	}

	/**
	 * Auxillary method to print queue in a right order. Using a copy of queue
	 * to poll
	 * 
	 * @param queue
	 *            - a PriorityQueue to print
	 */
	public void printPriorityQueue(Queue<Driver> queue) {
		Queue<Driver> temp;
		temp = new PriorityQueue<Driver>(10, comparator);
		for (Driver e : queue) {
			temp.add(e);
		}

		System.out.println("---------------Result Queue---------------------");
		while (!temp.isEmpty())
			System.out.println(temp.poll());
	}

	/**
	 * Creates drivers and froms a driver queue from them. Comparator of queue
	 * is based on drivers experience. Run all trains with available drivers in
	 * different threads After all threads are finished - print a resulting
	 * queue
	 */
	public void manageDriversQueue() {
		comparator = new Comparator<Driver>() {
			@Override
			public int compare(Driver o1, Driver o2) {

				if (o1.getExperience() > o2.getExperience()) {
					return -1;
				}
				if (o1.getExperience() < o2.getExperience()) {
					return 1;
				}
				return 0;

			}
		};

		driverQueue = new PriorityQueue<Driver>(10, comparator);

		driverQueue.add(new Driver("Konstantin", 8));
		driverQueue.add(new Driver("Kryvorukov I.I.", 29));
		driverQueue.add(new Driver("Petrovich", 56));
		driverQueue.add(new Driver("Stazher Seryozha", 6));

		// print the initial state of queue
		printPriorityQueue(driverQueue);

		Driver currentDriver = null;

		for (Train trn : trains) {
			while (!driverQueue.isEmpty()) {
				currentDriver = driverQueue.poll();
				currentDriver.setCurrentTrain(trn);
				currentDriver.doDrive();
				driverQueue.add(currentDriver);
				break;
			}
		}
	}

	/**
	 * Add stations to the lines(line station collection).
	 */
	public void createLineStations() {

		for (int i = 0; i < 10; i++) {
			redLine.lineStations.add(new Station(redLine.name + "Station " + i));
			blueLine.lineStations.add(new Station(blueLine.name + "Station " + i));
			greenLine.lineStations.add(new Station(greenLine.name + "Station " + i));
		}
	}

	/**
	 * Creating passengers and running all trains through stations
	 */
	public void passengersInOutTrains() {

		for (Line line : metroKiev) {
			System.out.println(line.getName() + " : ");
			Iterator<Train> iterLine = line.getLineTrains().iterator();
			while (iterLine.hasNext()) {
				Train train = iterLine.next();
				System.out.println(" " + train.name + " <====> " + train.driver);
				runTrainForLine(line, train);
			}
		}
	}

	/**
	 * Runs train through line. Train stays at every station and let passengers
	 * go out and in.
	 * 
	 * @param line
	 *            - metro Line
	 * @param train
	 *            - current train
	 */
	public void runTrainForLine(Line line, Train train) {
		Random rnd = new Random();
		int cntToOperate = 0, resultOper = 0;

		for (Station station : line.lineStations) {
			cntToOperate = rnd.nextInt(45);
			// С прибытием поезда, на каждой станции появляется
			// несколько пассажиров.
			for (int i = 0; i < cntToOperate; i++) {
				station.waitingPassengers.add(new Passenger("Passenger " + rnd.nextInt(1111)));
			}
			System.out.println("  " + station + "->");

			// высадка пассажиров (если они есть) из вагонов
			// проходим по всем вагонам поезда
			for (Wagon wgn : train.wagons) {
				System.out.print("  " + wgn.name + "[" + wgn.passengers.size() + "] :  ");
				resultOper = 0;
				// если вагон не пуст
				if (!wgn.passengers.isEmpty()) {
					// проходим про всем пассажирам вагона
					Iterator<Passenger> passIter = wgn.passengers.iterator();
					cntToOperate = rnd.nextInt(10);
					// выходит несколько пассажиров
					while (passIter.hasNext() && cntToOperate > 0) {
						wgn.passengers.removeFirst();
						cntToOperate--;
						resultOper++;
					}
					System.out.print("   " + resultOper + " out; ");
				}

				// Пассажиры на станции садятся в вагоны (все, кто могут
				// поместиться)

				resultOper = 0;
				// если в вагоне есть место и на станции есть пассажиры
				while (wgn.passengers.size() < Wagon.MAX_CAPAITY & station.waitingPassengers.size() > 0) {

					wgn.passengers.add(station.waitingPassengers.getFirst());
					station.waitingPassengers.removeFirst();
					resultOper++;
				}
				System.out.print("" + resultOper + " in; ");
				System.out.println("");
			}
		}
		System.out.println("");
	}

	/**
	 * 
	 * Add remaining passengers into HashMap for quick find and print passengers
	 * list
	 */
	public void showPasssengersLeft() {

		for (Line line : metroKiev) {
			for (Station station : line.lineStations) {
				passengersInStation.put(station.name, station.waitingPassengers);
			}

		}

		System.out.println("Passengers at end station of Red line:");
		for (Passenger pass : passengersInStation.get("RedStation 9")) {
			System.out.println(" " + pass.name);
		}

		System.out.println("Passengers at end station of Blue line:");
		for (Passenger pass : passengersInStation.get("BlueStation 9")) {
			System.out.println(" " + pass.name);
		}
		System.out.println("Passengers at end station of Green line:");
		for (Passenger pass : passengersInStation.get("GreenStation 9")) {
			System.out.println(" " + pass.name);
		}

	}
}
