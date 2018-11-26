package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Mansion;
import model.NotFoundException;
import model.Room;
import model.RoomAlreadyExistsException;
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
		mansion.createCorridor("1","2", 2);
		mansion.createCorridor("2","3", 1);
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
	
	public void setUpStage(boolean type) {
		
	}
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
