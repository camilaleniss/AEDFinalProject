package model;

import java.util.List;

public interface IGraph<T> {

	public List<Vertex> getVertices();
	
	public boolean isDirected();
	
	public boolean isWeighted();
	
	public void addVertex(Vertex x);
	
	public void addEdge(Vertex x, Vertex y);
	
	public void addEdge(Vertex x, Vertex y, double w);
	
	public void removeVertex(Vertex v);
	
	public void removeEdge(Vertex x, Vertex y);
	
	public List<Vertex> getNeighbors(Vertex x);
	
	public int getNumberOfVertices();
	
	public int getNumberOfEdges();
	
	public boolean areAdjacent(Vertex x, Vertex y);
	
	public boolean isInGraph(T value);
	
	public double getEdgeWeight(Vertex x, Vertex y);
	
	public void setEdgeWeight(Vertex x, Vertex y, double w);
	
	public void bfs(Vertex s);
	
	public void dfs();
	
}
