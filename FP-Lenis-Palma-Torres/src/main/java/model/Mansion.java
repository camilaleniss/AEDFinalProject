package model;

import java.util.*;

public class Mansion {

//	private AdjListGraph<Room> adjList;
//	private AdjMatrixGraph<Room> adjMatrix;
	private IGraph<Room> graph;

	private ArrayList<Vertex<Room>> exits;
	private HashMap<String, Room> mapRooms;

	private boolean isList;

//	public Mansion() {
//		adjList = new AdjListGraph<>(true, true);
//		adjMatrix = new AdjMatrixGraph<>(true, true);
//		mapRooms = new HashMap<>();
//		exits = new ArrayList<>();
//		state=ISLIST;
//		initMansion();
//	}

	public Mansion(boolean isList) {
//		adjList = new AdjListGraph<>(true, true);
//		adjMatrix = new AdjMatrixGraph<>(true, true);
		graph = isList ? new AdjListGraph<>(true, true) : new AdjMatrixGraph<>(true, true);
		mapRooms = new HashMap<>();
		exits = new ArrayList<>();
		this.isList = isList;
		initMansion();
	}
//
//	/**
//	 * This method changes the state of the Graph used from AdjList to AdjMatrix and
//	 * viceversa
//	 */
//	public void changeState() {
//		if (state) {
//			state = false;
//		} else {
//			state = ISLIST;
//		}
//	}

	/**
	 * This method find the minimum path to an exit from the mansion The mansion can
	 * have many exits, so it finds the minimum time with all the different options
	 * 
	 * @param room The name of the room where it wants to exit
	 * @return The minimum time to an exit
	 */
	public List<Room> shortestWayOut(String room) throws NotFoundException {

		Vertex<Room> rr = search(room);
		if (rr == null)
			throw new NotFoundException("The room does not exist");

		graph.dijkstra(rr);

		Vertex<Room> minExit = exits.get(0);

		for (int i = 0; i < exits.size(); i++) {
			if (exits.get(i).getD() < minExit.getD())
				minExit = exits.get(i);
		}

		List<Room> path = new ArrayList<Room>();
		while (minExit != null) {
			path.add(0, minExit.getValue());
			minExit = minExit.getPred();
		}

		return path;
//		int indexrr=0;
//		double time=0, mintime=IGraph.INF;
//		double[][] times;
//			//It does the FloydWarshall algorithm to find the shortest part from all the exits
//			if (state) {
//				times= adjList.floydwarshall();
//				indexrr=adjList.getIndexOf(rr);
//			}else {
//				times=adjMatrix.floydwarshall();
//				indexrr=adjMatrix.getIndexOf(rr);
//			}
//			//Here it search the shortest path from the all the exits
//			for (int i=0; i<exits.size(); i++) {
//				int index;
//				if(state)
//					index=adjList.getIndexOf(exits.get(i));
//				else
//					index=adjMatrix.getIndexOf(exits.get(i));	
//				time = times[indexrr][index];
//				mintime = Math.min(time, mintime);
//			}
//		return mintime;
	}

	public double getPathLength(List<Room> path) throws NotFoundException {
		double total = 0;
		for (Room r : path) {
			Vertex<Room> v = graph.searchVertex(r);
			if (v == null)
				throw new NotFoundException("The room does not exist");
			total += v.getD();
		}
		return total;
	}

	/**
	 * This method finds the vertex of the room given the name of it.
	 * 
	 * @param room The name of the room
	 * @return The vertex where is saved the room
	 * @throws NotFoundException If the room does not exist
	 */
	public Vertex<Room> search(String room) {

//		for (int i=0; i<adjList.getNumberOfVertices(); i++) {
//			if (adjList.getVertices().get(i).getValue().getName().equals(room))
//				return adjList.getVertices().get(i);
//		}
//		return null;
		Room r = searchRoom(room);
		return r == null ? null : graph.searchVertex(r);
	}

	public Room searchRoom(String room) {
//		for (int i=0; i<adjList.getNumberOfVertices(); i++) {
//			if (adjList.getVertices().get(i).getValue().getName().equals(room))
//				return adjList.getVertices().get(i).getValue();
//		}
//		return null;
		return mapRooms.get(room);
	}

	public void addRoom(String name, boolean isExit) throws RoomAlreadyExistsException {
		if (searchRoom(name) != null) {
			throw new RoomAlreadyExistsException();
		}
		Room r = new Room(name, isExit);
		graph.addVertex(r);
		if (isExit)
			exits.add(graph.searchVertex(r));
//		adjList.addVertex(new Room(name, isExit));
//		adjMatrix.addVertex(new Room(name, isExit));
	}

	public void deleteCorridor(String from, String to) throws NotFoundException {
		Room fromRoom = searchRoom(from);
		Room toRoom = searchRoom(to);

		if (fromRoom == null || toRoom == null)
			throw new NotFoundException("The room does not exist");
		if (!graph.areAdjacent(search(from), search(to))) {
			throw new NotFoundException("The corridor does not exist");
		}

		graph.removeEdge(fromRoom, toRoom);
	}

	public void createCorridor(String from, String to, double time)
			throws NotFoundException, CorridorAlreadyExistsException {
		Room fromRoom = searchRoom(from);
		Room toRoom = searchRoom(to);

		if (fromRoom == null || toRoom == null)
			throw new NotFoundException("The room does not exist");
		if (graph.areAdjacent(search(from), search(to))) {
			throw new CorridorAlreadyExistsException();
		}

//		adjList.addEdge(fromvertex, tovertex, time);
//		adjMatrix.addEdge(fromvertex, tovertex, time);

	}

	public void deleteRoom(String room) throws NotFoundException {
		Room roomdelete = searchRoom(room);
		if (roomdelete == null)
			throw new NotFoundException("The room does not exist");
		graph.removeVertex(roomdelete);
	}

	public void getTreasures() {

	}

	public double announceClosure() {
		double time = 0;
		IGraph<Room> nondir = getNonDirected();
		List<Edge<Room>> E = nondir.kruskal();
		for (Edge<Room> e : E) {
			time += e.getWeight();
		}

		return time;
	}

	public IGraph<Room> getNonDirected() {
		IGraph<Room> nondir = isList ? new AdjListGraph<>(false, true) : new AdjMatrixGraph<>(false, true);

		List<Vertex<Room>> V = graph.getVertices();
		List<Edge<Room>> E = graph.getEdges();

		for (int i = 0; i < V.size(); i++) {
			nondir.addVertex(V.get(i).getValue());
		}
		for (Edge<Room> e : E) {
			if (e.getSource() != e.getDestination())
				nondir.addEdge(e.getSource().getValue(), e.getDestination().getValue(), e.getWeight());
		}

		return nondir;
	}

	public void initMansion() {

	}

	public List<Room> shortestPath(String from, String to) throws NotFoundException {

		Vertex<Room> vFrom = search(from);
		Vertex<Room> vTo = search(to);
		if (vFrom == null || vTo == null)
			throw new NotFoundException("The room does not exist");

		graph.bfs(vFrom);

		List<Room> path = new ArrayList<Room>();
		while (vTo != null) {
			path.add(0, vTo.getValue());
			vTo = vTo.getPred();
		}

		return path;
	}

}
