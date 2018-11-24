package model;

@SuppressWarnings("serial")
public class CorridorAlreadyExistsException extends Exception{

	public CorridorAlreadyExistsException() {
		super("The corridor is already in the mansion");
	}

}
