package lection19;

import java.util.LinkedList;

/**
 * Класс Вагона
 *
 */
public class Wagon {
	/**
	 * Максимальная вместимость вагона
	 */
	public static final int MAX_CAPAITY = 10;

	/**
	 * Является ли вагон "головным"
	 */
	public boolean isHeaderWagon;
	public String name;
	public String wagonNumber;
	int capacity;
	/**
	 * Список пассажиров вагона
	 */
	LinkedList<Passenger> passengers;

	public Wagon(String name, boolean isHeaderWagon) {
		this.name = name;
		this.isHeaderWagon = isHeaderWagon;
		capacity = 0;
		passengers = new LinkedList<>();
	}

	public boolean isHeaderWagon() {
		return isHeaderWagon;
	}

	public void setHeaderWagon(boolean isHeaderWagon) {
		this.isHeaderWagon = isHeaderWagon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWagonNumber() {
		return wagonNumber;
	}

	public void setWagonNumber(String wagonNumber) {
		this.wagonNumber = wagonNumber;
	}

	@Override
	public String toString() {
		return "Wagon [head=" + isHeaderWagon + ", name=" + name + ", num=" + wagonNumber + "]";
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
