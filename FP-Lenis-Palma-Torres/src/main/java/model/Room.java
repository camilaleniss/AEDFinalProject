package model;

import java.util.ArrayList;

public class Room {
	
	private String name;
	
	private ArrayList<Treasure> treasures;
	
	private boolean isExit;
	
	public Room(String name, boolean isExit) {
		this.name=name;
		this.isExit=isExit;
		treasures=new ArrayList<Treasure>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Treasure> getTreasures(){
		return treasures;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public boolean isExit() {
		return isExit;
	}
	
	public void addValuable(String n, double v) {
		Treasure newTreasure= new Treasure(n,v);
		addValuable(newTreasure);
	}
	
	private void addValuable(Treasure treasure) {
		treasures.add(treasure);
	}
	
	
}
