package photos.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController
{
	@FXML Button login;
	
	public void start(Stage primaryStage)
	{
		
	}
	
	public void doLogin()
	{
		
	}
	
	public void doExit()
	{
		Platform.exit();
	}
}
