package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Mansion;
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
    private JFXListView<Room> listRoomsTo;

    @FXML
    private JFXListView<Room> listRoomsFrom;
    
    private Mansion mansion;

    @FXML
    void addRoom(ActionEvent event) {

    }

    @FXML
    void deleteRoom(ActionEvent event) {

    }

    @FXML
    void modifyRoom(ActionEvent event) {

    }

    @FXML
    void returnToMansion(ActionEvent event) {

    }

    @FXML
    void visit(ActionEvent event) {

    }
    
    public void init(Mansion mansion) {
    	this.mansion = mansion;
    }

}
