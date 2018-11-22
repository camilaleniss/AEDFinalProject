package model;

import java.util.ArrayList;

public class Room {
	public String ADJMATRIX="adjmatrix";
	public String ADJLIST="adjlist";
	
	private String type;
	private ArrayList<Treasure> valuables;
	
	public Room(String t) {
		type=t;
		valuables=new ArrayList<Treasure>();
	}
	public String getType() {
		return type;
	}
	public ArrayList<Treasure> getValuables(){
		return valuables;
	}
	public void setType(String n) {
		type=n;
	}
	public void addValuable(String n, double v) {
		Treasure newTreasure= new Treasure(n,v);
		addValuable(newTreasure);
	}
	public void addValuable(Treasure t) {
		valuables.add(t);
	}
}
