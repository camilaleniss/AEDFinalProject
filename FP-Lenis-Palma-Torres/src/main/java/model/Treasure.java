package model;

public class Treasure {
	
	private String name;
	private double value;
	
	public Treasure(String n, double v) {
		name=n;
		value=v;
	}
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}
	public void setName(String n) {
		name=n;
	}
	public void setValue(double v) {
		value=v;
	}

	@Override
	public String toString() {
		return name+" / "+ " $"+value+" from: ";
	}

}
