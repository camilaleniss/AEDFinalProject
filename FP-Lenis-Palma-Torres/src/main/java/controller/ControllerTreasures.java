package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Mansion;
import model.Treasure;

public class ControllerTreasures {

    @FXML
    private JFXListView<Treasure> listTreasures;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnBack;
    
    private Mansion mansion;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }
    
    public void init(Mansion mansion) {
    	this.mansion = mansion;
    }

}
