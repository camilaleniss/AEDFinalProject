package controller;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception { 

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/MainView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main");
//		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/baloncesto.png")));
		MainView contr = loader.getController();
		primaryStage.show();
		contr.init();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}