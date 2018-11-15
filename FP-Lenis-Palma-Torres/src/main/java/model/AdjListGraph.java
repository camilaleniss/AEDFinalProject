package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjListGraph<T> implements IGraph<T> {

	private boolean directed;
	private boolean weighted;
	private int numberOfVertices;
	private int numberOfEdges;

	private List<Vertex<T>> vertices;
	private HashMap<T, AdjVertex<T>> map;

	public AdjListGraph(boolean directed, boolean weighted) {
		this.directed = directed;
		this.weighted = weighted;
		numberOfVertices = 0;
		numberOfEdges = getNumberOfEdges();
		vertices = new LinkedList<Vertex<T>>();
		map = new HashMap<>();
	}

	public List<Vertex<T>> getVertices() {
		return vertices;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		// Depende de si es o no dirigido / Not really...
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
			vertex.setIndex(numberOfVertices);
			vertices.add(vertex);
			numberOfVertices++;
		}
	}

	@Override
	public void addEdge(T x, T y) {
		AdjVertex<T> from = searchVertex(x);
		AdjVertex<T> to = searchVertex(y);
		addEdge(from, to);
	}

	public void addEdge(AdjVertex<T> from, AdjVertex<T> to) {
		addEdge(from, to, 1D);
	}

	@Override
	public void addEdge(T x, T y, double w) {
		if (weighted) {
			AdjVertex<T> from = searchVertex(x);
			AdjVertex<T> to = searchVertex(y);
			addEdge(from, to, w);
		}
	}

	public void addEdge(AdjVertex<T> from, AdjVertex<T> to, double w) {
		if (from != null && to != null) {
			Edge<T> edge = new Edge<T>(from, to, w);
			from.getAdjList().add(edge);
			if (!isDirected()) {
				edge = new Edge<T>(to, from, w);
				to.getAdjList().add(edge);
			}
			numberOfEdges++;
		}

	}

	public void removeVertex(Vertex<T> v) {
		for (int i = 0; i < vertices.size(); i++) {
			removeEdge(vertices.get(i), v);
			if (isDirected()) {
				removeEdge(v, vertices.get(i));
			}
		}
		vertices.remove(v);
		map.remove(v.getValue());
		numberOfVertices--;
	}

	public void removeVertex(T v) {
		if (isInGraph(v)) {
			removeVertex(searchVertex(v));
		}
	}

	public void removeEdge(Vertex<T> x, Vertex<T> y) {
		AdjVertex<T> from = (AdjVertex<T>) x;
		AdjVertex<T> to = (AdjVertex<T>) y;
		List<Edge<T>> adjFrom = from.getAdjList();
		Edge<T> e = from.findEdge(to);
		if (e != null)
			adjFrom.remove(e);

		if (!isDirected()) {
			List<Edge<T>> adjTo = to.getAdjList();
			e = to.findEdge(from);
			if (e != null)
				adjTo.remove(e);
		}

		numberOfEdges--;
	}

	public void removeEdge(T x, T y) {
		if (isInGraph(x) && isInGraph(y)) {
			removeEdge(searchVertex(x), searchVertex(y));
		}
	}

	public List<Vertex<T>> getNeighbors(Vertex<T> x) {
		List<Vertex<T>> neigh = new ArrayList<>();
		AdjVertex<T> from = (AdjVertex<T>) x;
		List<Edge<T>> adj = from.getAdjList();
		for (int i = 0; i < adj.size(); i++) {
			neigh.add(adj.get(i).getDestination());
		}
		return neigh;
	}

	public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
		return getNeighbors(x).contains(y);
	}

	public boolean isInGraph(T value) {
		return searchVertex(value) != null;
	}

	public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
		double w = 0;
		if (isInGraph(x.getValue()) && isInGraph(y.getValue())) {
			AdjVertex<T> from = (AdjVertex<T>) x;
			AdjVertex<T> to = (AdjVertex<T>) y;
			Edge<T> e = from.findEdge(to);
			if (e != null)
				w = e.getWeight();
		}
		return w;
	}

	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
		if (isInGraph(x.getValue()) && isInGraph(y.getValue()) && weighted) {
			AdjVertex<T> from = (AdjVertex<T>) x;
			AdjVertex<T> to = (AdjVertex<T>) y;
			Edge<T> e = from.findEdge(to);
			if (e != null)
				e.setWeight(w);

			if (!isDirected()) {
				e = to.findEdge(from);
				if (e != null)
					e.setWeight(w);
			}
		}
	}

	public AdjVertex<T> searchVertex(T value) {
		return map.get(value);
	}

	public int getIndexOf(Vertex<T> v) {
		int index = -1;
		boolean searching = true;
		for (int i = 0; i < vertices.size() && searching; i++) {
			if (vertices.get(i) == v) {
				index = i;
				searching = false;
			}
		}
		return index;
	}

	public void bfs(Vertex<T> x) {
		AdjVertex<T> s = (AdjVertex<T>) x;
		for (Vertex<T> u : vertices) {
			u.setColor(Vertex.WHITE);
			u.setD(INF);
			u.setPred(null);
		}
		s.setColor(Vertex.GRAY);
		s.setD(0);
		s.setPred(null);
		Queue<AdjVertex<T>> q = new LinkedList<>();
		q.offer(s);
		while (!q.isEmpty()) {
			AdjVertex<T> u = q.poll();
			for (int i = 0; i < u.getAdjList().size(); i++) {
				AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
				if (v.getColor() == Vertex.WHITE) {
					v.setColor(Vertex.GRAY);
					v.setD(u.getD() + 1);
					v.setPred(u);
					q.offer(v);
				}
			}
			u.setColor(Vertex.BLACK);
		}
	}

	public void dfs() {
		for (Vertex<T> u : vertices) {
			u.setColor(Vertex.WHITE);
			u.setPred(null);
		}
		int time = 0;
		for (Vertex<T> u : vertices) {
			if (u.getColor() == Vertex.WHITE)
				time = dfsVisit((AdjVertex<T>) u, time);
		}
	}

	private int dfsVisit(AdjVertex<T> u, int time) {
		time++;
		u.setD(time);
		u.setColor(Vertex.GRAY);
		for (int i = 0; i < u.getAdjList().size(); i++) {
			AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
			if (v.getColor() == Vertex.WHITE) {
				v.setPred(u);
				time = dfsVisit(v, time);
			}
		}
		u.setColor(Vertex.BLACK);
		time++;
		u.setF(time);
		return time;
	}

	// public double[] dijkstra(AdjVertex<T> vertex) {
	// // Initialization
	// double[] dist = new double[numberOfVertices];
	// boolean[] visit = new boolean[numberOfVertices];
	// PriorityQueue<AdjVertex<T>> s = new PriorityQueue<>();
	//
	// int index = vertex.getIndex();
	//
	// for (int i = 0; i < visit.length; i++)
	// visit[i] = false;
	//
	// for (int i = 0; i < dist.length; i++)
	// dist[i] = Integer.MAX_VALUE;
	//
	// dist[index] = 0;
	//
	// vertex.setD(0);
	//
	// s.add(vertex);
	//
	// // Dijkstra Algorithm
	//
	// while (!s.isEmpty()) {
	// AdjVertex<T> p = s.poll();
	// // Index of the vertex
	// int x = p.getIndex();
	// // Update visit array
	// visit[x] = true;
	//
	// // Looks for a better path throughout adjacent list
	// for (int i = 0; i < p.getAdjList().size(); i++) {
	//
	// // Look at the weights from p to the adjVertex
	// Edge<T> adjVertex = p.getAdjList().get(i);
	// int e = adjVertex.getDestination().getIndex();
	// double w = adjVertex.getWeight();
	//
	// if (dist[x] + w < dist[e]) {
	// dist[e] = dist[x] + w;
	// AdjVertex<T> toAdd = new AdjVertex<T>(adjVertex.getDestination().getValue());
	// toAdd.setIndex(e);
	// toAdd.setD(dist[e]);
	// s.add(toAdd);
	// }
	// }
	// }
	//
	// return dist;
	// }

	private void initSingleSource(AdjVertex<T> s) {
		for (Vertex<T> u : vertices) {
			u.setD(INF);
			u.setPred(null);
		}
		s.setD(0);
	}

	private void relax(AdjVertex<T> u, AdjVertex<T> v) {
		Edge<T> e = u.findEdge(v);
		double w = e == null ? INF : e.getWeight();
		if (v.getD() > u.getD() + w) {
			v.setD(u.getD() + w);
			v.setPred(u);
		}
	}
	
	public void dijkstra(Vertex<T> x) {
		AdjVertex<T> s = (AdjVertex<T>) x;
		initSingleSource(s);
		PriorityQueue<AdjVertex<T>> q = new PriorityQueue<>();
		for (Vertex<T> u : vertices) {
			AdjVertex<T> v = (AdjVertex<T>) u;
			q.add(v);
		}
	}
}
