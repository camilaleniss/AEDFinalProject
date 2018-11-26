package model;

import java.util.*;

public class Mansion {

	private IGraph<Room> graph;

	private HashMap<String, Room> mapRooms;
	private List<Treasure> museum;

	private boolean isList;

	public Mansion(boolean isList) {
		graph = isList ? new AdjListGraph<>(true, true) : new AdjMatrixGraph<>(true, true);
		mapRooms = new HashMap<>();
		museum = new ArrayList<>();
		this.isList = isList;
	}

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

		List<Vertex<Room>> exits = new ArrayList<>();
		List<Room> rooms = getRooms();
		for (Room r : rooms) {
			if (r.isExit())
				exits.add(graph.searchVertex(r));
		}

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
		Room r = searchRoom(room);
		return r == null ? null : graph.searchVertex(r);
	}

	public Room searchRoom(String room) {
		return mapRooms.get(room);
	}

	public void addRoom(String name, boolean isExit) throws RoomAlreadyExistsException {
		if (searchRoom(name) != null) {
			throw new RoomAlreadyExistsException();
		}
		Room r = new Room(name, isExit);
		mapRooms.put(name, r);
		graph.addVertex(r);
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
		graph.addEdge(fromRoom, toRoom, time);

	}

	public void deleteRoom(String room) throws NotFoundException {
		if (room.equals("Main exit"))
			throw new NotFoundException("You cannot delete the main exit!");
		Room roomdelete = searchRoom(room);
		if (roomdelete == null)
			throw new NotFoundException("The room does not exist");
		mapRooms.remove(room);
		graph.removeVertex(roomdelete);
		for (Treasure t : roomdelete.getTreasures()) {
			t.setLocation("Museum");
			museum.add(t);
		}
	}

	public List<String> getTreasures() {
		List<Room> rooms = graph.getContents();
		List<String> treasures = new ArrayList<>();
		List<Treasure> valuables = new ArrayList<>();
		for (int i = 0; i < rooms.size(); i++) {
			valuables = rooms.get(i).getTreasures();
			for (int j = 0; j < valuables.size(); j++) {
				treasures.add(valuables.get(j).toString());
			}
		}
		for (Treasure t : museum) {
			treasures.add(t.toString());
		}
		Collections.sort(treasures);
		return treasures;
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
		try {
			addRoom("Main exit", true);
		} catch (RoomAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public List<Room> getRooms() {
		Iterator<Room> roomsI = mapRooms.values().iterator();
		ArrayList<Room> rooms = new ArrayList<>();
		while (roomsI.hasNext()) {
			rooms.add(roomsI.next());
		}
		Collections.sort(rooms);
		return rooms;
	}

	public List<Room> getNeighbors(Room r) {
		ArrayList<Room> neigh = new ArrayList<>();
		Vertex<Room> v = graph.searchVertex(r);
		if (v != null) {
			List<Vertex<Room>> n = graph.getNeighbors(v);
			for (Vertex<Room> u : n) {
				neigh.add(u.getValue());
			}
		}
		return neigh;
	}
	
	public void addTreasure(String room, String name, double value) throws NotFoundException {
		Room r = searchRoom(room);
		if(r == null) {
			throw new NotFoundException("The room does not exist");
		}
		r.addValuable(name, value);
	}

}
