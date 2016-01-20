package lection19;

import java.util.LinkedList;

/**
 * Класс для Станции
 *
 */
public class Station {
	/**
	 * Имя станции
	 */
	String name;
	/**
	 * Список пассажиров на станции
	 */
	LinkedList<Passenger> waitingPassengers;
	static volatile LinkedList<Passenger> vestibuleList;
	public Escalator escalator1;
	public Escalator escalator2;
	public Escalator escalator3;
	public Vestibule vestibule;

	public Station(String name) {
		this.name = name;
		vestibuleList = new LinkedList<>();

		vestibule = new Vestibule(vestibuleList, "Vestibule Created");
		escalator1 = new Escalator(vestibuleList, "escalator1");
		escalator2 = new Escalator(vestibuleList, "escalator2");
		escalator3 = new Escalator(vestibuleList, "escalator3");
		this.waitingPassengers = new LinkedList<Passenger>();
	}

	@Override
	public String toString() {
		return "Station [(" + name + "); wait(" + waitingPassengers.size() + ")]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Passenger> getWaitingPassengers() {
		return waitingPassengers;
	}

	public void setWaitingPassengers(LinkedList<Passenger> waitingPassengers) {
		this.waitingPassengers = waitingPassengers;
	}


	public void fillVestibule(){
		vestibule.start();
		escalator1.start();
		escalator2.start();
		escalator3.start();
//		escalator1.run();
//		escalator2.run();
//		escalator3.run();
	}

	public LinkedList<Passenger> getVestibuleList(){
		return vestibuleList;
	}
}
