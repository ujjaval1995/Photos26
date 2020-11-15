package photos.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import photos.model.User;

public class AdminController implements Ctrl
{
	@FXML ListView<User> users_list;
	@FXML Button add;
	@FXML Button delete;
	
	public void start(Stage primaryStage)
	{
		
	}

	public void doLogout()
	{
		
	}
	
	public void doAbout()
	{
		// complete
	}
	
	public void doExit()
	{
		Platform.exit();
	}
}
