package controller;

import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.Mansion;
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
    	
    }
    
    @FXML
    void exitPath(ActionEvent event) {

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
