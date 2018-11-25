package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Mansion;
import model.NotFoundException;
import model.Room;

public class ControllerRoom {

	@FXML
	private JFXButton btnAddRoom;

	@FXML
	private JFXButton btnDelete;

	@FXML
	private JFXButton btnVisit;

	@FXML
	private JFXButton btnModify;

	@FXML
	private JFXButton btnReturn;

	@FXML
	private JFXTextField txtRoomName;

	@FXML
	private JFXListView<Room> listToRooms;

	private Mansion mansion;

	private Room room;

	@FXML
	void addRoom(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/ContainerModify.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnModify.getScene().getWindow();
			stage.setScene(scene);
			ControllerModify contr = loader.getController();
			contr.init(mansion, room);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void deleteRoom(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Are you sure you want to delete the room?");
		alert.setContentText(null);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    try {
				mansion.deleteRoom(room.getName());
				returnToMansion();
			} catch (NotFoundException e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(e.getMessage());

				alert.showAndWait();
			}
		    
		} 
	}

	@FXML
	void modifyRoom(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/ContainerModify.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnModify.getScene().getWindow();
			stage.setScene(scene);
			ControllerModify contr = loader.getController();
			contr.init(mansion, room, room);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void returnToMansion(ActionEvent event) {
		returnToMansion();
	}
	
	private void returnToMansion() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/MainView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnReturn.getScene().getWindow();
			stage.setScene(scene);
			MainView contr = loader.getController();
			contr.init(mansion);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void visit(ActionEvent event) {
		Room r = listToRooms.getSelectionModel().getSelectedItem();
		if (r != null)
			init(mansion, r);
	}

	public void init(Mansion mansion, Room room) {
		this.mansion = mansion;
		this.room = room;
		this.txtRoomName.setText(room.getName());

		ArrayList<Room> toRooms = (ArrayList<Room>) mansion.getNeighbors(room);
		Collections.sort(toRooms);

		ObservableList<Room> list = FXCollections.observableArrayList(toRooms);
		listToRooms.setItems(list);
		listToRooms.getSelectionModel().select(0);

//    	list = FXCollections.observableArrayList(fromRooms);
//    	listFromRooms.setItems(list);
//    	listFromRooms.getSelectionModel().select(0);
	}

}
