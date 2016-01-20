package lection19;

import java.util.LinkedList;

/**
 * Класс для Поезда метро
 *
 */
public class Train {

	/**
	 * Максимальное количество вагонов в поезде
	 */
	public static final byte MAX_NUMBER_OF_WAGONS = 5;

	public String name;
	public String number;
	public int size;
	/**
	 * Может ли поезд выходить на линию
	 */
	public boolean readyToGo;

	/**
	 * Машинист поезда
	 */
	Driver driver;
	public int passangersserved = 0;

	/**
	 * Вагоны поезда
	 */
	public LinkedList<Wagon> wagons;

	public Train(String name, String number) {
		this.name = name;
		this.number = number;
		this.size = 0;
		wagons = new LinkedList<Wagon>();
		readyToGo = false;
	}

	/**
	 * Является ли первый вагон "головным"
	 * 
	 * @return true, если да, является
	 */
	public boolean hasHeaderWagon() {
		if (wagons.size() >= 1)
			if (wagons.getFirst().isHeaderWagon)
				return true;
		return false;
	}

	/**
	 * Является ли последний вагон "головным"
	 * 
	 * @return true, если да, является
	 */
	public boolean hasTrailerWagon() {
		if (wagons.size() >= 1)
			if (wagons.getLast().isHeaderWagon)
				return true;
		return false;
	}

	/**
	 * Добавление вагона в поезд
	 * 
	 * @param wgn
	 *            - вагон для добавления
	 */
	public void addWagon(Wagon wgn) {
		if (this.size < MAX_NUMBER_OF_WAGONS) {
			if (wgn.isHeaderWagon & !hasHeaderWagon())
				wagons.addFirst(wgn);
			else {
				if (wgn.isHeaderWagon & !hasTrailerWagon())
					wagons.addLast(wgn);
				else {
					if (!hasHeaderWagon() || !hasTrailerWagon())
						wagons.add(wgn);
					else
						wagons.add(1, wgn);
				}
			}

			renumberWagons();
			this.size = this.wagons.size();
			readyToGo = hasHeaderWagon() & hasTrailerWagon() & (size == MAX_NUMBER_OF_WAGONS);

		} else
			System.out.println("Can't add more wagons!");
	}

	/**
	 * Присваивание номеров вагонам
	 */
	public void renumberWagons() {
		for (Wagon wgn : wagons) {
			wgn.setWagonNumber(this.number + "" + wagons.indexOf(wgn));
		}
	}

	@Override
	public String toString() {
		return "Train [name=" + name + ", ready=" + readyToGo + ", num=" + number + ", size=" + size
		// + ", wagons=" + wagons
				+ ", driver=" + driver + "]\n";
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
