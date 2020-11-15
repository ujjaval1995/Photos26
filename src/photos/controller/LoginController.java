package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController extends MainController
{
	@FXML Button login;
	
	public void doLogin()
	{
		toAdmin();
	}
	
	public void doAbout()
	{
		// complete
	}
}
