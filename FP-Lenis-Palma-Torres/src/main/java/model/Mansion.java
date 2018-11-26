package model;

import java.util.*;

/**
 * This class represents the Winchester Mansion implementing a graph to model
 * the distribution of it This class do the requeriments
 * 
 * @author Maria Camila Lenis Restrepo, Juan Sebastian Palma, Javier Andrés
 *         Torres Reyes
 *
 */
public class Mansion {
	/**
	 * The graph used to represent the mansion
	 */
	private IGraph<Room> graph;
	/**
	 * The HashMap of the rooms to access fast to them
	 */
	private HashMap<String, Room> mapRooms;
	/**
	 * The list of the treasures of the museum
	 */
	private List<Treasure> museum;
	/**
	 * True if it is represented by an adjacent list False if it is represented by
	 * an adjacent matrix
	 */
	private boolean isList;

	/**
	 * The constructor of the mansion It initialize the state of the mansion
	 * 
	 * @param isList
	 */
	public Mansion(boolean isList) {
		graph = isList ? new AdjListGraph<>(true, true) : new AdjMatrixGraph<>(true, true);
		mapRooms = new HashMap<>();
		museum = new ArrayList<>();
		this.isList = isList;
	}

	/**
	 * Getter of the HashMap of the rooms
	 * 
	 * @return The hashmap of the rooms
	 */
	public HashMap<String, Room> getMapRooms() {
		return mapRooms;
	}

	/**
	 * Getter of the graph that represents the mansion
	 * 
	 * @return the graph that represents the mansion
	 */
	public IGraph<Room> getGraph() {
		return graph;
	}

	/**
	 * This method find the minimum path to an exit from the mansion The mansion can
	 * have many exits, so it finds the minimum time with all the different options
	 * 
	 * @param room The name of the room where it wants to exit
	 * @return The a list that represent the path from the room to an exit
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

	/**
	 * Get the length of a path that is represented by a list
	 * 
	 * @param path The list that represents the path
	 * @return The length of the path
	 * @throws NotFoundException if one vertex of the path is not found
	 */
	public double getPathLength(List<Room> path) throws NotFoundException {
		double total = 0;
		if (!path.isEmpty())
			total = graph.searchVertex(path.get(path.size() - 1)).getD();
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

	/**
	 * This method searches a room from the map
	 * 
	 * @param room The name of the room. room!=null
	 * @return The room if it is founded. null if it is not
	 */
	public Room searchRoom(String room) {
		return mapRooms.get(room);
	}

	/**
	 * This method adds a Room to the mansion
	 * 
	 * @param name   the name of the room. name!=null
	 * @param isExit if it is an exit or not
	 * @throws RoomAlreadyExistsException if the room had been added before
	 */
	public void addRoom(String name, boolean isExit) throws RoomAlreadyExistsException {
		if (searchRoom(name) != null) {
			throw new RoomAlreadyExistsException();
		}
		Room r = new Room(name, isExit);
		mapRooms.put(name, r);
		graph.addVertex(r);
	}

	/**
	 * This method deletes a room from the mansion
	 * 
	 * @param room The name of the room. room!=null
	 * @throws NotFoundException If the room that want to be deleted does not exists
	 */
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

	/**
	 * This methods creates a corridor between two rooms with a given time
	 * 
	 * @param from The from room for the corridor. from!=null
	 * @param to   The to room for the corridor. to!=null
	 * @param time The time that it takes to cross the corridor. time!=null
	 * @throws NotFoundException              If one of the room does not exists
	 * @throws CorridorAlreadyExistsException If the corridor already exists The
	 *                                        graph does not super multi edges
	 */
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

	/**
	 * This method deletes a corridor between two rooms
	 * 
	 * @param from The from room for the corridor. from!=null
	 * @param to   The to room for the corridor. to!=null
	 * @throws NotFoundException if one of the room does not exists
	 */
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

	/**
	 * This method makes a list of all the treasures stored in the mansion
	 * 
	 * @return An ordered list of all the treasures in the mansion
	 */
	public List<String> getTreasures() {
		List<Room> rooms = graph.getContents();
		List<String> treasures = new ArrayList<>();
		List<Treasure> valuables = new ArrayList<>();
		// Find all the treasures in the rooms
		for (int i = 0; i < rooms.size(); i++) {
			valuables = rooms.get(i).getTreasures();
			for (int j = 0; j < valuables.size(); j++) {
				treasures.add(valuables.get(j).toString());
			}
		}
		// Find all the treasures in the museum
		for (Treasure t : museum) {
			treasures.add(t.toString());
		}
		Collections.sort(treasures);
		return treasures;
	}

	/**
	 * This methods transmit he closure message to all the rooms in the mansion
	 * 
	 * @return The time in minutes that takes to transmit the message
	 */
	public double announceClosure() {
		double time = 0;
		// Converts the graph in a non directed one
		IGraph<Room> nondir = getNonDirected();
		// Implements the Kruskal method to find the MST
		List<Edge<Room>> E = nondir.kruskal();
		for (Edge<Room> e : E) {
			time += e.getWeight();
		}

		return time;
	}

	/**
	 * Convert the mansion in a nonDirected Graph
	 * 
	 * @return A Graph that is not directed and represents the matrix
	 */
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

	/**
	 * Initializes the state of the mansion
	 */
	public void initMansion() {
		try {

			String[] names = new String[] { "Main exit", "Kitchen", "Dining hall", "Bedroom", "Bathroom",
					"Definitely not an exit", "Backyard exit", "Library", "Basement", "Grand hall"};

			addRoom(names[0], true);
			addRoom(names[1], false);
			addRoom(names[2], false);
			addRoom(names[3], false);
			addRoom(names[4], false);
			addRoom(names[5], true);
			addRoom(names[6], true);
			addRoom(names[7], false);
			addRoom(names[8], false);
			addRoom(names[9], false);
			
			createCorridor(names[4], names[9], 2);
			createCorridor(names[6], names[3], 8);
			createCorridor(names[1], names[7], 1);
			createCorridor(names[6], names[7], 3);
			createCorridor(names[3], names[2], 14);
			createCorridor(names[1], names[7], 12);
			createCorridor(names[2], names[1], 14);
			createCorridor(names[8], names[9], 1);
			createCorridor(names[7], names[8], 2);
			createCorridor(names[3], names[6], 11);
			createCorridor(names[5], names[7], 13);
			createCorridor(names[7], names[2], 1);
			createCorridor(names[0], names[3], 14);
			createCorridor(names[7], names[4], 10);
			createCorridor(names[1], names[6], 7);
			createCorridor(names[0], names[3], 15);
			createCorridor(names[6], names[2], 12);
			createCorridor(names[1], names[2], 11);
			createCorridor(names[3], names[2], 10);
			createCorridor(names[0], names[8], 11);
			
			addTreasure(names[9], "Aristi's glasses", 100);
			addTreasure(names[3], "Barrios' dinosaur costume", 100);
			addTreasure(names[1], "Pitcher full of the green sauce from Central", 50);
			addTreasure(names[6], "Mysterious coin", 50);
			addTreasure(names[2], "Old toothpaste", 10);
			
		} catch (RoomAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CorridorAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This methods finds the shortest path, in matter of rooms, between two rooms
	 * It implements the BFD algorithm
	 * 
	 * @param from The from room for the corridor. from!=null
	 * @param to   The to room for the corridor. to!=null
	 * @return The list of that represents the path of the two rooms
	 * @throws NotFoundException If one of the rooms does not exists
	 */
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

	/**
	 * Getter of the museum treasures list
	 * 
	 * @return The list that represents the museum treasures list
	 */
	public List<Treasure> getMuseum() {
		return museum;
	}

	/**
	 * It makes a list of all the rooms to show it in the interface
	 * 
	 * @return An ordered List of the rooms
	 */
	public List<Room> getRooms() {
		Iterator<Room> roomsI = mapRooms.values().iterator();
		ArrayList<Room> rooms = new ArrayList<>();
		while (roomsI.hasNext()) {
			rooms.add(roomsI.next());
		}
//		Collections.sort(rooms);
		return rooms;
	}

	/**
	 * This methods gets the adjacent vertices of a room
	 * 
	 * @param r The room. r!=null
	 * @return A list with the adjacent vertex from r
	 */
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

	/**
	 * This method adds a treasure to the mansion, to a room specified
	 * 
	 * @param room  The room where belongs the treasure
	 * @param name  The name of the treasure. name!=null
	 * @param value The value of the treasure. value>0. value!=null
	 * @throws NotFoundException If the room where it belongs does not exists
	 */
	public void addTreasure(String room, String name, double value) throws NotFoundException {
		Room r = searchRoom(room);
		if (r == null) {
			throw new NotFoundException("The room does not exist");
		}
		r.addValuable(name, value);
	}

}
