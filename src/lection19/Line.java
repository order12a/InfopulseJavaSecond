package lection19;

import java.util.LinkedList;

/**
 * Класс для Линии метро
 *
 */
public class Line {
	/**
	 * Название линии
	 */
	String name;
	/**
	 * Список поездов этой линии
	 */
	LinkedList<Train> lineTrains;
	/**
	 * Список станций этой линии
	 */
	LinkedList<Station> lineStations;

	public Line(String name) {
		this.name = name;
		this.lineStations = new LinkedList<Station>();
	}

	@Override
	public String toString() {
		return "Line [name=" + name + "]";
	}

	public LinkedList<Train> getLineTrains() {
		return lineTrains;
	}

	public void setLineTrains(LinkedList<Train> lineTrains) {
		this.lineTrains = lineTrains;
	}

	public LinkedList<Station> getLineStations() {
		return lineStations;
	}

	public void setLineStations(LinkedList<Station> lineStations) {
		this.lineStations = lineStations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
