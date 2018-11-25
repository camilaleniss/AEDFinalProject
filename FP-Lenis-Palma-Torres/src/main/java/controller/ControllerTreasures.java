package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    }

}
