package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import model.Mansion;
import model.Room;

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
    
    private Mansion mansion;

    @FXML
    void addCorridor(ActionEvent event) {

    }

    @FXML
    void deleteCorridor(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

    public void init(Mansion mansion) {
    	this.mansion = mansion;
    }
}
