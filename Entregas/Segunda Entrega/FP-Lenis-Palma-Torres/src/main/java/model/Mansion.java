package model;

public class Mansion {
	public String ADJMATRIX="adjMatrix";
	public String ADJLIST="adjList";
	
	private String name;
	private IGraph<Room> graph;
	
	public Mansion(String n, String gt, boolean d, boolean w) {
		name=n;
		if(gt==ADJMATRIX) {
			graph= new AdjMatrixGraph(d,w);
		}else if(gt==ADJLIST) {
			graph=new AdjListGraph(d,w);
		}
	}
//	public Room search() {
//		
//	}
	
	public void addRoom() {
		
	}
	public void deleteCorridor() {
		
	}
	public void createCorridor() {
		
	}
	public void deleteRoom() {
		
	}
	public getTreasures() {
		
	}
	public void announceClosure() {
		
	}
	public  shortestWayOut() {
		
	}
}