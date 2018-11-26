package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import model.Mansion;
import model.NotFoundException;
import model.Room;
import model.RoomAlreadyExistsException;
import model.Vertex;
import model.CorridorAlreadyExistsException;
import model.IGraph;


class TestMansion {

	private Mansion mansion;
	
	public TestMansion() {
		
	}
	
	public void setUpStage1(boolean type) {
		mansion = new Mansion (type);
	}
	
	public void setUpStage2(boolean type) throws RoomAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("Main exit", true);
		mansion.addRoom("Room", false);
		mansion.addRoom("Kitchen", false);
	}
	
	public void setUpStage3(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage2(type);
		mansion.createCorridor("Main exit", "Room", 1);
		mansion.createCorridor("Room", "Kitchen", 3);
	}
	
	public void setUpStage4(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("Main exit", true);
		mansion.addRoom("1", false);
		mansion.addRoom("2", false);
		mansion.addRoom("4", false);
		mansion.createCorridor("Main exit", "4", 2);
		mansion.createCorridor("1", "Main exit", 9);
		mansion.createCorridor("1","2", 5);
		mansion.createCorridor("2","Main exit", 1);
		mansion.createCorridor("4","2", 3);
	}
	
	public void setUpStage5(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("Main exit", true);
		mansion.addRoom("3", false);
		mansion.addRoom("2", false);
		mansion.addRoom("4", false);
		mansion.createCorridor("3", "4", 2);
		mansion.createCorridor("Main exit", "3", 9);
		mansion.createCorridor("Main exit","2", 5);
		mansion.createCorridor("2","3", 1);
		mansion.createCorridor("4","2", 3);
	}
	
	public void setUpStage6(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("r", false);
		mansion.addRoom("s", false);
		mansion.addRoom("t", false);
		mansion.addRoom("u", false);
		mansion.addRoom("v", false);
		mansion.addRoom("w", false);
		mansion.addRoom("x", false);
		mansion.addRoom("y", false);
		mansion.createCorridor("u", "t", 1);
		mansion.createCorridor("u", "x", 1);
		mansion.createCorridor("u", "y", 1);
		mansion.createCorridor("t", "x", 1);
		mansion.createCorridor("x", "w", 1);
		mansion.createCorridor("t", "w", 1);
		mansion.createCorridor("w", "s", 1);
		mansion.createCorridor("s", "r", 1);
		mansion.createCorridor("r", "v", 1);
	}
	
	public void setUpStage7(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("1", true);
		mansion.addRoom("2", false);
		mansion.addRoom("3", false);
		mansion.addRoom("4", false);
		mansion.addRoom("5", false);
		mansion.addRoom("6", false);
		mansion.createCorridor("1", "3", 4);
		mansion.createCorridor("3", "2", 3);
		mansion.createCorridor("2", "4", 3);
		mansion.createCorridor("3", "4", 4);
		mansion.createCorridor("1", "5", 4);
		mansion.createCorridor("5", "3", 2);
		mansion.createCorridor("3", "6", 2);
		mansion.createCorridor("6", "4", 3);	
	}
	
	public void setUpStage8(boolean type) throws RoomAlreadyExistsException, NotFoundException, CorridorAlreadyExistsException {
		setUpStage1(type);
		mansion.addRoom("1", true);
		mansion.addRoom("2", false);
		mansion.addRoom("3", false);
		mansion.addRoom("4", false);
		mansion.addRoom("5", false);
		mansion.addRoom("6", false);
		mansion.addRoom("7", false);
		mansion.addRoom("8", false);
		mansion.addRoom("9", false);
		mansion.createCorridor("1", "2", 4);
		mansion.createCorridor("2", "3", 9);
		mansion.createCorridor("1", "8", 9);
		mansion.createCorridor("2", "8", 11);
		mansion.createCorridor("8", "9", 7);
		mansion.createCorridor("9", "3", 2);
		mansion.createCorridor("9", "7", 6);
		mansion.createCorridor("7", "8", 1);
		mansion.createCorridor("4", "5", 10);
		mansion.createCorridor("5", "6", 11);
		mansion.createCorridor("4", "6", 15);
	}
	
	public void setUpStage9(boolean type) throws NotFoundException {
		setUpStage1(type);
		mansion.addTreasure("Kitchen", "Treas1", 30000);
	}
	
	public void setUpStage10(boolean type) throws NotFoundException {
		setUpStage9(type);
		mansion.addTreasure("Room", "Ring", 20000);
		mansion.addTreasure("Kitchen", "Knife", 40000);
	}
	
	public void setUpStage11(boolean type) throws NotFoundException {
		setUpStage10(type);
		mansion.deleteRoom("Room");
	}
	
	public void setUpStage12(boolean type) throws NotFoundException {
		setUpStage9(type);
		mansion.addTreasure("Kitchen", "Knife", 40000);
		mansion.deleteRoom("Room");
	}
	
	public void setUpStage13(boolean type) throws NotFoundException, CorridorAlreadyExistsException, RoomAlreadyExistsException {
		setUpStage6(type);
		mansion.addRoom("a", false);
		mansion.createCorridor("a", "r", 1);
	}
	
	@Test
	void testAddRoom() {
		//Test 1
		try {
			//Test 1
			setUpStage2(true);
			mansion.addRoom("Bathroom", false);
			assertTrue(mansion.getMapRooms().size()==4);
			assertTrue(mansion.getMapRooms().get("Bathroom").getName().equals("Bathroom"));
			
			//Test 2
			setUpStage2(false);
			mansion.addRoom("Bathroom", false);
			assertTrue(mansion.getMapRooms().size()==4);
			assertTrue(mansion.getMapRooms().get("Bathroom").getName().equals("Bathroom"));
		} catch (RoomAlreadyExistsException e) {
			fail("It must not fail");
		}
		
		//Test 3
		try {
			setUpStage2(true);
			mansion.addRoom("Kitchen", false);
			fail("It must no add the Kitchen");
		} catch (RoomAlreadyExistsException e) {
			assert(true);
		}
		
		//Test 2
		try {
			setUpStage2(false);
			mansion.addRoom("Kitchen", false);
			fail("It must no add the Kitchen");
		} catch (RoomAlreadyExistsException e) {
			assert(true);
		}
	}
	
	@Test
	void testDeleteRoom() {
		try {
			//Test 1
			setUpStage2(true);
			mansion.deleteRoom("Room");
			assertTrue(mansion.getMapRooms().size()==2);
			assertTrue(mansion.getMapRooms().get("Room")==null);
			
			//Test 2
			setUpStage2(false);
			mansion.deleteRoom("Room");
			assertTrue(mansion.getMapRooms().size()==2);
			assertTrue(mansion.getMapRooms().get("Room")==null);
			
		} catch (RoomAlreadyExistsException | NotFoundException e) {
			fail("It must not throw any exception");
		}
		
		try {
			//Test 3
			setUpStage2(true);
			mansion.deleteRoom("Main exit");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		}
		
		try {
			//Test 4
			setUpStage2(false);
			mansion.deleteRoom("Main exit");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		}
		
		try {
			//Test 5
			setUpStage2(true);
			mansion.deleteRoom("Bath");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		}
		
		try {
			//Test 6
			setUpStage2(false);
			mansion.deleteRoom("Bath");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		}
	}
	
	@Test
	void testCreateCorridor() {
		Vertex<Room> fromV, toV;
		
		try {
			//Test 1
			setUpStage3(true);
			mansion.createCorridor("Main exit", "Kitchen", 3);
			fromV=mansion.search("Main exit");
			toV=mansion.search("Kitchen");
			assertTrue(mansion.getGraph().areAdjacent(fromV, toV));
			assertTrue(!mansion.getGraph().areAdjacent(toV, fromV));
			
			//Test 2
			setUpStage3(false);
			mansion.createCorridor("Main exit", "Kitchen", 3);
			fromV=mansion.search("Main exit");
			toV=mansion.search("Kitchen");
			assertTrue(mansion.getGraph().areAdjacent(fromV, toV));
			assertTrue(!mansion.getGraph().areAdjacent(toV, fromV));
		} catch (RoomAlreadyExistsException | NotFoundException | CorridorAlreadyExistsException e) {
			fail("It must not throw any exception");
		}
		
		//Test 3
		try {
			setUpStage3(true);
			mansion.createCorridor("Room", "Kitchen", 2);
			fail("It must not add that corridor");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			fail("It must not throw this exception");
		} catch (CorridorAlreadyExistsException e) {
			assert(true);
		}
		
		//Test 4
		try {
			setUpStage3(false);
			mansion.createCorridor("Room", "Kitchen", 2);
			fail("It must not add that corridor");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			fail("It must not throw this exception");
		} catch (CorridorAlreadyExistsException e) {
			assert(true);
		}		
		
		//Test 5
		try {
			setUpStage3(true);
			mansion.createCorridor("Bathroom", "Kitchen", 2);
			fail("It must not add that corridor");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		} catch (CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		}
		
		
		//Test 6
		try {
			setUpStage3(false);
			mansion.createCorridor("Bathroom", "Kitchen", 2);
			fail("It must not add that corridor");
		} catch (RoomAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assert(true);
		} catch (CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		}
	}
	
	@Test
	void testDeleteCorridor() {
		Vertex<Room> fromV, toV;
		try {
			//Test 1
			setUpStage3(true);
			mansion.deleteCorridor("Main exit", "Room");
			fromV= mansion.search("Main exit");
			toV= mansion.search("Room");
			assertTrue(!mansion.getGraph().areAdjacent(fromV, toV));
			
			//Test 2
			setUpStage3(false);
			mansion.deleteCorridor("Main exit", "Room");
			fromV= mansion.search("Main exit");
			toV= mansion.search("Room");
			assertTrue(!mansion.getGraph().areAdjacent(fromV, toV));
		} catch (RoomAlreadyExistsException | NotFoundException | CorridorAlreadyExistsException e) {
			fail("It must not throw any exceptions");
		}
		
		//Test 3
		try {
			setUpStage3(true);
			mansion.deleteCorridor("Kitchen", "Room");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
		
		//Test 4
		try {
			setUpStage3(false);
			mansion.deleteCorridor("Kitchen", "Room");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
		
		//Test 5
		try {
			setUpStage3(true);
			mansion.deleteCorridor("Bathroom", "Room");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
				
		//Test 6
		try {
			setUpStage3(false);
			mansion.deleteCorridor("Bathroom", "Room");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
		
		
		//Test 7
		try {
			setUpStage3(true);
			mansion.deleteCorridor("Room", "Bathroom");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
						
		//Test 8
		try {
			setUpStage3(false);
			mansion.deleteCorridor("Room", "Bathroom");
			fail("It must not delete any corridor");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw this exception");
		} catch (NotFoundException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	void testShortestWayOut() {
		List<Room> path;
		String msg="";
	
		try {
			//Test 1
			setUpStage4(true);
			path = mansion.shortestWayOut("2");
			msg=getMessage(path);
			assertTrue(msg.equals("-2-Main exit (exit)"));
			assertTrue(mansion.getPathLength(path)==1);
			
			//Test 2
			setUpStage4(false);
			path = mansion.shortestWayOut("2");
			msg=getMessage(path);
			assertTrue(msg.equals("-2-Main exit (exit)"));
			assertTrue(mansion.getPathLength(path)==1);
			
			
			//Test 3
			setUpStage4(true);
			path = mansion.shortestWayOut("1");
			msg=getMessage(path);
			assertTrue(msg.equals("-1-2-Main exit (exit)"));
			//Fails in the pathLength
			assertTrue(mansion.getPathLength(path)==6);
			
			//Test 4
			setUpStage4(false);
			path = mansion.shortestWayOut("1");
			msg=getMessage(path);
			assertTrue(msg.equals("-1-2-Main exit (exit)"));
			assertTrue(mansion.getPathLength(path)==6);
			
			
			//Test 5
			setUpStage5(true);
			path = mansion.shortestWayOut("4");
			assertTrue(mansion.getPathLength(path)==IGraph.INF);
			
			//Test 6
			setUpStage5(false);
			path = mansion.shortestWayOut("4");
			assertTrue(mansion.getPathLength(path)==IGraph.INF);
			
		} catch (RoomAlreadyExistsException | NotFoundException | CorridorAlreadyExistsException e) {
			fail("It must not throw any exceptions");
		}
		
		//Test 7
		try {
			setUpStage4(true);
			path = mansion.shortestWayOut("6");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw these exceptions");
		} catch (NotFoundException e) {
			assert(true);
		}
		
		//Test 8
		try {
			setUpStage4(false);
			path = mansion.shortestWayOut("6");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw these exceptions");
		} catch (NotFoundException e) {
			assert(true);
		}
	}
	
	private String getMessage(List<Room> path) {
		String msg="";
		for (int i = 0; i < path.size(); i++) {
			msg += "-"+path.get(i);
		}
		return msg;
	}
	
	
	@Test
	void testShortesPath() {
		List<Room> path;
		String msg="";
		try {
			//Test 1
			setUpStage6(true);
			path=mansion.shortestPath("u", "w");
			msg=getMessage(path);
			assertTrue(msg.equals("-u-t-w"));
			assertTrue(mansion.getPathLength(path)==3);
			
			//Test 2
			setUpStage6(false);
			path=mansion.shortestPath("u", "w");
			msg=getMessage(path);
			assertTrue(msg.equals("-u-t-w"));
			assertTrue(mansion.getPathLength(path)==3);
			
			//Test 3
			setUpStage13(true);
			path=mansion.shortestPath("u", "a");
			assertTrue(mansion.getPathLength(path)==IGraph.INF);
			
			//Test 4
			setUpStage13(false);
			path=mansion.shortestPath("u", "a");
			assertTrue(mansion.getPathLength(path)==IGraph.INF);
		} catch (RoomAlreadyExistsException | NotFoundException | CorridorAlreadyExistsException e) {
			fail("It must not throw any exceptions");
		}
		
		//Test 5
		try {
			setUpStage6(true);
			path=mansion.shortestPath("u", "a");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw any of these exceptions");
		}catch(NotFoundException e) {
			assert(true);
		}
		
		//Test 6
		try {
			setUpStage6(false);
			path=mansion.shortestPath("u", "a");
		} catch (RoomAlreadyExistsException | CorridorAlreadyExistsException e) {
			fail("It must not throw any of these exceptions");
		}catch(NotFoundException e) {
			assert(true);
		}
	}

}
