package model;

import java.util.*;

public class AdjMatrixGraph<T> implements IGraph<T> {

	private boolean directed;
	private boolean weighted;
	private int numberOfVertices;
	private int numberOfEdges;

	private List<Vertex<T>> vertices;
	private List<ArrayList<Integer>> adjMatrix;
	private List<ArrayList<Double>> weightsMatrix;
	private HashMap<T, AdjVertex<T>> map;

	public AdjMatrixGraph(boolean directed, boolean weighted) {
		this.directed = directed;
		this.weighted = weighted;
		numberOfVertices = 0;
		numberOfEdges = getNumberOfEdges();
		vertices = new LinkedList<Vertex<T>>();
		adjMatrix = new ArrayList<ArrayList<Integer>>();
		weightsMatrix = new ArrayList<ArrayList<Double>>();
		map = new HashMap<>();
	}

	public List<Vertex<T>> getVertices() {
		return vertices;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
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
		if (!isInGraph(value)) {
			AdjVertex<T> vertex = new AdjVertex<T>(value);
			map.put(value, vertex);
			vertices.add(vertex);

			ArrayList<Integer> adj = new ArrayList<>();
			ArrayList<Double> we = new ArrayList<>();
			for (int i = 0; i < adjMatrix.size(); i++) {
				adjMatrix.get(i).add(0);
				weightsMatrix.get(i).add((double) INF);
			}
			for (int i = 0; i < vertices.size(); i++) {
				adj.add(0);
				we.add((double) INF);
			}
			we.set(we.size()-1, 0.0);
			adjMatrix.add(adj);
			weightsMatrix.add(we);

			numberOfVertices++;
		}
	}

}
