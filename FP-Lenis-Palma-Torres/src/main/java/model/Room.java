package model;

import java.util.ArrayList;
import java.util.List;

public class Room implements Comparable<Room> {

	private String name;

	private List<Treasure> treasures;

	private boolean isExit;

	public Room(String name, boolean isExit) {
		this.name = name;
		this.isExit = isExit;
		treasures = new ArrayList<Treasure>();
	}

	public String getName() {
		return name;
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean exit) {
		this.isExit = exit;
	}

	public void addValuable(String n, double v) {
		Treasure newTreasure = new Treasure(n, v, name);
		addValuable(newTreasure);
	}

	private void addValuable(Treasure treasure) {
		treasures.add(treasure);
	}

	@Override
	public String toString() {
		return name + (isExit ? " (exit)" : "");
	}

	@Override
	public int compareTo(Room arg0) {
		return name.compareTo(arg0.name);
	}

}
