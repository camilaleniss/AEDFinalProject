package model;

public class Edge<T> {

	private double weight;
	
	private Vertex<T> source;
	private Vertex<T> destination;
	
	public Edge(Vertex<T> source, Vertex<T> destination) {
		this.source=source;
		this.destination=destination;
	}
	
	public Edge(Vertex<T> source, Vertex<T> destination, double weight) {
		this.source=source;
		this.destination=destination;
		this.weight=weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}
	
}
