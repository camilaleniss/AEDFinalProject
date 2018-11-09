package model;

import java.util.List;

public class AdjListGraph<T> implements IGraph<T>{

	private boolean directed;
	private boolean weighted;
	private int numberOfVertices;
	private int numberOfEdges;
	
	public AdjListGraph(boolean directed, boolean weighted) {
		this.directed=directed;
		this.weighted=weighted;
	}
	
	public List<Vertex> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isDirected() {
		return directed;
	}
	
	public boolean isWeighted() {
		return weighted;
	}
	
	public void addVertex(Vertex x) {
		// TODO Auto-generated method stub
		
	}
	
	public void addEdge(Vertex x, Vertex y) {
		// TODO Auto-generated method stub
		
	}
	
	public void addEdge(Vertex x, Vertex y, double w) {
		// TODO Auto-generated method stub
		
	}
	
	public void removeVertex(Vertex v) {
		// TODO Auto-generated method stub
		
	}
	
	public void removeEdge(Vertex x, Vertex y) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Vertex> getNeighbors(Vertex x) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean areAdjacent(Vertex x, Vertex y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isInGraph(T value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double getEdgeWeight(Vertex x, Vertex y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setEdgeWeight(Vertex x, Vertex y, double w) {
		// TODO Auto-generated method stub
		
	}
	
	public void bfs(Vertex s) {
		
	}
	
	public void dfs() {
		// TODO Auto-generated method stub
		
	}
	
	
}
