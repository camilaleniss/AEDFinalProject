package model;

import java.util.*;

public class AdjMatrixGraph<T> implements IGraph<T> {
	
	private boolean directed;
	private boolean weighted;
	private int numberOfVertices;
	private int numberOfEdges;

	private List<Vertex<T>> vertices;
	private List<ArrayList<Vertex<T>>> adjMatrix;
	private List<List<Vertex<T>>> weightsMatrix;
	private HashMap<T, AdjVertex<T>> map;
	
	public AdjMatrixGraph(boolean directed, boolean weighted) {
		this.directed = directed;
		this.weighted = weighted;
		numberOfVertices = 0;
		numberOfEdges = getNumberOfEdges();
		vertices = new LinkedList<Vertex<T>>();
		adjMatrix = new ArrayList<ArrayList<Vertex<T>>>();
		map = new HashMap<>();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWeighted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVertex(T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T x, T y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(T x, T y, double w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(T v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(T x, T y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vertex<T>> getNeighbors(Vertex<T> x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInGraph(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bfs(Vertex<T> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

}
