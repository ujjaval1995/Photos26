package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import photos.model.User;

public class AdminController extends MainController
{
	@FXML ListView<User> users_list;
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
