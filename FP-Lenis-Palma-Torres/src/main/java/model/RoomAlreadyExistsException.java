package model;

@SuppressWarnings("serial")
public class RoomAlreadyExistsException extends Exception{

	public RoomAlreadyExistsException() {
		super("The room is already in the mansion");
	}

}
