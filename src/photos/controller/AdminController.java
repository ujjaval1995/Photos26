package photos.controller;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import photos.model.*;

public class AdminController extends MainController
{
	@FXML ListView<User> userlist;
	@FXML TextField namefield;
	@FXML Button add;
	@FXML Button delete;
	
	public void init()
	{
		namefield.clear();
	}
	
	public void doAdd()
	{
		
	}
	
	public void doDelete()
	{
		
	}
	
	public void doAbout()
	{
		// complete
	}
}
