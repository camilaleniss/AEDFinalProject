package controller;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Mansion;
import model.Room;
import model.RoomAlreadyExistsException;

public class ControllerModify {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXComboBox<Room> comboRoom;

    @FXML
    private JFXButton btnAddCorridor;

    @FXML
    private JFXButton btnDeleteCorridor;

    @FXML
    private JFXCheckBox chkExit;

    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnReturn;
    
    private Mansion mansion;
    
    private Room room;
    
    private Room prevRoom;

    @FXML
    void addCorridor(ActionEvent event) {
    	Room r = comboRoom.getSelectionModel().getSelectedItem();
    	if(r != null) {
    		
    	}
    }

    @FXML
    void deleteCorridor(ActionEvent event) {
    	Room r = comboRoom.getSelectionModel().getSelectedItem();
    	if(r != null) {
    		
    	}
    }

    @FXML
    void update(ActionEvent event) {
    	if(room == null) {
    		if(txtName.getText().equals("")) {
    			Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("You must enter a name");

				alert.showAndWait();
    		} else {
    			try {
					mansion.addRoom(txtName.getText(), chkExit.isSelected());
					init(mansion, mansion.searchRoom(txtName.getText()), prevRoom);
				} catch (RoomAlreadyExistsException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
				}    			
    		}
    	} else {
    		room.setExit(chkExit.isSelected());
    	}
    }
    
    @FXML
    void returnToMansion(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/ControllerHabitacion.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnReturn.getScene().getWindow();
			stage.setScene(scene);
			ControllerRoom contr = loader.getController();
			contr.init(mansion, prevRoom);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void init(Mansion mansion, Room prevRoom) {
    	this.mansion = mansion;
    	this.prevRoom = prevRoom;
    	txtName.setEditable(true);
    }
    
    public void init(Mansion mansion, Room room, Room prevRoom) {
    	this.mansion = mansion;
    	this.room = room;
    	this.prevRoom = prevRoom;
    	txtName.setText(room.getName());
    	txtName.setEditable(false);
    	chkExit.setSelected(room.isExit());
    	
    	List<Room> rooms = mansion.getRooms();
    	rooms.remove(room);
    	
    	if(room.getName().equals("Main exit"))
    		chkExit.setDisable(true);
    	
    	ObservableList<Room> list = FXCollections.observableArrayList(rooms);
    	comboRoom.setItems(list);
    }
}
