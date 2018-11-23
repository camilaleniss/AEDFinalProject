package model;

import java.util.ArrayList;

public class Mansion {
	public static boolean ISLIST=true;
	
	private AdjListGraph<Room> adjList;
	private AdjMatrixGraph<Room> adjMatrix;
	
	private ArrayList<Vertex<Room>> exits;
	
	private boolean state;
	
	
	public Mansion() {
		adjList = new AdjListGraph<>(true, true);
		adjMatrix = new AdjMatrixGraph<>(true, true);
		exits = new ArrayList<>();
		state=ISLIST;
		initMansion();
	}
	
	
	/**
	 * This method changes the state of the Graph used from AdjList to AdjMatrix and viceversa
	 */
	public void changeState() {
		if (state) {
			state=false;
		}else {
			state=ISLIST;
		}
	}
	
	/**
	 * This method find the minimum path to an exit from the mansion
	 * The mansion can has many exits, so it finds the minimum time with all the different options
	 * @param room The name of the room where it wants to exit
	 * @return The minimum time to an exit
	 */
	public  double shortestWayOut(String room) {
		Vertex<Room> rr= search(room);
		int indexrr=0;
		double time=0, mintime=IGraph.INF;
		double[][] times;
			//It does the FloydWarshall algorithm to find the shortest part from all the exits
			if (state) {
				times= adjList.floydwarshall();
				indexrr=adjList.getIndexOf(rr);
			}else {
				times=adjMatrix.floydwarshall();
				indexrr=adjMatrix.getIndexOf(rr);
			}
			//Here it search the shortest path from the all the exits
			for (int i=0; i<exits.size(); i++) {
				int index;
				if(state)
					index=adjList.getIndexOf(exits.get(i));
				else
					index=adjMatrix.getIndexOf(exits.get(i));	
				time = times[indexrr][index];
				mintime = Math.min(time, mintime);
			}
		return mintime;
	}
	
	/**
	 * This method finds the vertex of the room given the name of it.
	 * @param room The name of the room
	 * @return The vertex where is saved the room
	 */
	public Vertex<Room> search(String room) {
		for (int i=0; i<adjList.getNumberOfVertices(); i++) {
			if (adjList.getVertices().get(i).getValue().getName().equals(room))
				return adjList.getVertices().get(i);
		}
		return null;
	}
	
	
	public void addRoom() {
		
	}
	public void deleteCorridor() {
		
	}
	public void createCorridor() {
		
	}
	public void deleteRoom() {
		
	}
	
	public void getTreasures() {
		
	}
	
	public void announceClosure() {
		
	}
	
	public void initMansion() {
		
	}
	
}
