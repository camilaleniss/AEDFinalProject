package model;

import java.util.List;

public class AdjListGraph<T> implements IGraph<T>{

	private boolean directed;
	private boolean weighted;
	private int numberOfVertices;
	private int numberOfEdges;
	
	private List<Vertex<T>> vertices;
	
	public AdjListGraph(boolean directed, boolean weighted) {
		this.directed=directed;
		this.weighted=weighted;
		numberOfVertices=0;
		numberOfEdges=getNumberOfEdges();
		
		//vertices = new List<>();
	}
	
	public List<Vertex<T>> getVertices() {
		return vertices;
	}
	
	public int getNumberOfVertices() {
		return numberOfVertices;
	}
	
	public int getNumberOfEdges() {
		//Depende de si es o no dirigido
		return numberOfEdges;
	}
	
	public boolean isDirected() {
		return directed;
	}
	
	public boolean isWeighted() {
		return weighted;
	}
	
	public void addVertex(Vertex<T> x) {
		vertices.add(x);
		numberOfVertices++;
	}
	
	public void addEdge(Vertex<T> x, Vertex<T> y) {
		Edge <T> edge = new Edge(x, y);
		
		
		numberOfEdges++;
	}
	
	public void addEdge(Vertex<T> x, Vertex<T> y, double w) {
		Edge <T> edge = new Edge(x,y,w);
		
		
		numberOfEdges++;
	}
	
	public void removeVertex(Vertex<T> v) {
		vertices.remove(v);
		numberOfVertices--;
	}
	
	public void removeEdge(Vertex<T> x, Vertex<T> y) {
		
		numberOfEdges--;
	}
	
	public List<Vertex<T>> getNeighbors(Vertex<T> x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isInGraph(T value) {
		for (int i=0; i<vertices.size(); i++) {
			if(vertices.get(i).getValue()==value)
				return true;
		}
		return false;
	}
	
	public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
		
		return 0;
	}
	
	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
		
	}
	
	public void bfs(Vertex<T> s) {
		
	}
	
	public void dfs() {
		
	}
	
}
