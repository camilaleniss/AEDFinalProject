package model;

public class Treasure {
	
	private String name;
	private double value;
	private String location;
	
	public Treasure(String n, double v, String location) {
		name=n;
		value=v;
		this.location = location;
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
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return name+" / "+ " $"+value+" from: "+location;
	}

}
