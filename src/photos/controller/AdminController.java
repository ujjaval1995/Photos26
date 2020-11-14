package photos.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import photos.model.User;

public class AdminController
{
	@FXML ListView<User> listview;
	@FXML Button add;
	@FXML Button delete;
	
	public void start(Stage primaryStage)
	{
		
	}

	public void doExit()
	{
		Platform.exit();
	}
}
