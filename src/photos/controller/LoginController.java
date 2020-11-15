package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import photos.model.*;

public class LoginController extends MainController
{
	@FXML TextField namefield;
	@FXML Button login;
	
	public void init()
	{
		model.setCurrentUser(null);
		namefield.clear();
	}
	
	public void doLogin()
	{
		String name = namefield.getText().trim();
		if (name.equals(Model.ADMIN))
		{
			toAdmin();
		}
		else
		{
			User user = model.getUser(name);
			if (user != null)
			{
				model.setCurrentUser(user);
				toHome();
			}
			else
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Invalid username");
				alert.showAndWait();
			}
		}
	}
	
	public void doAbout()
	{
		// complete
	}
}
