package model;

import java.util.List;

public class AdjVertex<T> extends Vertex<T> {

	private List<Edge <T>> adjList;
	
	public AdjVertex(T value) {
		super(value);
		//adjList= new List<Edge<T>>();
	}
	
	public List<Edge<T>> getAdjList(){
		return adjList;
	}

}
