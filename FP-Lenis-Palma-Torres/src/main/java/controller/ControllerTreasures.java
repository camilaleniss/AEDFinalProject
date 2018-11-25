package controller;

import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Mansion;
import model.NotFoundException;
import model.Room;
import model.Treasure;

public class ControllerTreasures {

	@FXML
	private JFXListView<String> listTreasures;

	@FXML
	private JFXButton btnAdd;

	@FXML
	private JFXButton btnBack;

	private Mansion mansion;

	@FXML
	void add(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Treasure creation");
		dialog.setHeaderText(null);
		dialog.setContentText("What is the name of the treasure?");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent() && !result.get().equals("")) {
			String name = result.get();
			dialog = new TextInputDialog("1");
			dialog.setTitle("Treasure creation");
			dialog.setHeaderText(null);
			dialog.setContentText("What is the value of the treasure?");

			result = dialog.showAndWait();
			if (result.isPresent()) {
				try {
					double value = Double.parseDouble(result.get());
					if (value <= 0)
						throw new NumberFormatException();
					
					List<Room> choices = mansion.getRooms();
					
					ChoiceDialog<Room> d = new ChoiceDialog<Room>(choices.get(0), choices);
					d.setTitle("Treasure creation");
					d.setHeaderText(null);
					d.setContentText("Choose the location of the treasure");
					Optional<Room> r = d.showAndWait();
					if (result.isPresent()) {
						Room room = r.get();
						mansion.addTreasure(room.getName(), name, value);
						updateList();
					}

				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("You must enter a positive number");

					alert.showAndWait();
				} catch (NotFoundException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
				}
			}
		}

	}

	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/MainView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = (Stage) btnBack.getScene().getWindow();
			stage.setScene(scene);
			MainView contr = loader.getController();
			contr.init(mansion);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(Mansion mansion) {
		this.mansion = mansion;

		updateList();
	}
	
	private void updateList() {
		List<String> tresures = mansion.getTreasures();

		ObservableList<String> list = FXCollections.observableArrayList(tresures);
		listTreasures.setItems(list);
		if (list.size() > 0)
			listTreasures.getSelectionModel().select(0);
	}

}
