package photos.controller;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import photos.model.User;

public class AdminController extends MainController
{
	@FXML ListView<User> userlist;
	@FXML TextField name;
	@FXML Button add;
	@FXML Button delete;

	public void doLogout()
	{
		toLogin();
	}
	
	public void doAbout()
	{
		// complete
	}
}
