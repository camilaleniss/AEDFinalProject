package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.IGraph;
import model.Mansion;
import model.NotFoundException;
import model.Room;

public class MainView {

    @FXML
    private JFXButton btnPath;

    @FXML
    private JFXButton btnMessage;

    @FXML
    private JFXButton btnTreasures;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnRoom;

    @FXML
    private JFXListView<Room> listRooms;
    
    private Mansion mansion;
    
    public void init() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Select Graph");
    	alert.setHeaderText("Select the type of graph to use during this execution");
    	alert.setContentText("If none is selected, adjacency list will be used");
    	ButtonType list = new ButtonType("Adjacency list");
    	ButtonType mat = new ButtonType("Adjacency matrix");
    	alert.getButtonTypes().setAll(list, mat);
    	Optional<ButtonType> result = alert.showAndWait();
    	if(result.get() == mat) {
    		mansion = new Mansion(false);
    	} else {
    		mansion = new Mansion(true);
    	}
    	updateList();
    }
    
    public void init(Mansion mansion) {
    	this.mansion = mansion;
    	updateList();
    }
    
    private void updateList() {
    	ArrayList<Room> rooms = (ArrayList<Room>) mansion.getRooms();
    	ObservableList<Room> list = FXCollections.observableArrayList(rooms);
    	listRooms.setItems(list);
    	listRooms.getSelectionModel().select(0);
    }
    
    @FXML
    void exitPath(ActionEvent event) {
    	String name = listRooms.getSelectionModel().getSelectedItem().getName();
    	try {
			List<Room> path = mansion.shortestWayOut(name);
			double length = mansion.getPathLength(path);
			
			String msg = "";
			
			if(length < IGraph.INF) {
				msg = "The shortest way out from the selected room takes "+length+" minutes and is: \n"+path.get(0);
				for (int i = 1; i < path.size(); i++) {
					msg += " - "+path.get(i);
				}
			} else {
				msg = "There is NO way out!";
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shortest way out");
			alert.setHeaderText(null);
			alert.setContentText(msg);

			alert.showAndWait();
		} catch (NotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}
    }

    @FXML
    void message(ActionEvent event) {

    }

    @FXML
    void seeRoom(ActionEvent event) {

    }

    @FXML
    void shortestPath(ActionEvent event) {

    }

    @FXML
    void tresures(ActionEvent event) {

    }

}
