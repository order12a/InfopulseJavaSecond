package lection19;

import java.util.Random;

/**
 * Класс для Машиниста
 *
 */
public class Driver {
	/**
	 * Имя машиниста
	 */
	String name;
	/**
	 * Текущий опыт машиниста
	 */
	int experience;
	/**
	 * Текущий поезд
	 */
	Train currentTrain;

	public Driver(String name, int experience) {
		this.name = name;
		this.experience = experience;
	}

	/**
	 * Experience recalculating. Experience can be downgraded for one-threading
	 * purposes.
	 * 
	 * @param kilometres
	 * 
	 */
	public void recalcExperience(int kilometres) {
		Random rnd = new Random();
		this.experience += rnd.nextInt(kilometres) - kilometres / 2;
	}

	/**
	 * Проезд и пересчёт опыта
	 */
	public void doDrive() {
		recalcExperience(80);
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", experience=" + experience + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Train getCurrentTrain() {
		return currentTrain;
	}

	public void setCurrentTrain(Train currentTrain) {
		this.currentTrain = currentTrain;
		currentTrain.setDriver(this);
	}

}
