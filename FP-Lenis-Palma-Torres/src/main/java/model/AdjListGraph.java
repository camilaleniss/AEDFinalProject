package model;

import java.util.LinkedList;
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
		
		vertices = new LinkedList<Vertex<T>>();
		
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
	
	@Override
	public void addVertex(T value) {
		AdjVertex<T> vertex = new AdjVertex<T>(value);
		vertices.add(vertex);
		numberOfVertices++;
	}
	
	/*
	public void addEdge(Vertex<T> x, Vertex<T> y) {
		Edge <T> edge = new Edge<T>(x, y);
		numberOfEdges++;
	}
	*/

	@Override
	public void addEdge(T x, T y) {
		AdjVertex<T> from = searchVertex(x);
		AdjVertex<T> to = searchVertex(y);
		if (from!=null && to!=null) {
			Edge<T> edge = new Edge<T>(from, to);
			from.getAdjList().add(edge);
			if (!isDirected()) {
				to.getAdjList().add(edge);
			}
		}
		numberOfEdges++;
	}
	
	/*
	public void addEdge(Vertex<T> x, Vertex<T> y, double w) {
		Edge <T> edge = new Edge(x,y,w);
		numberOfEdges++;
	}*/
	
	@Override
	public void addEdge(T x, T y, double w) {
		AdjVertex<T> from = searchVertex(x);
		AdjVertex<T> to = searchVertex(y);
		if (from!=null && to!=null) {
			Edge<T> edge = new Edge<T>(from, to, w);
			from.getAdjList().add(edge);
			if (!isDirected()) {
				to.getAdjList().add(edge);
			}
		}
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
	
	private AdjVertex<T> searchVertex(T value){
		for (int i=0; i<vertices.size(); i++) {
			if (vertices.get(i).getValue()==value) {
				return (AdjVertex<T>) vertices.get(i);
			}
		}
		return null;
	}
	
	public void bfs(Vertex<T> s) {
		
	}
	
	public void dfs() {
		
	}
	
	

	
}
