package photos.controller;

import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
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
		ObservableList<User> obs_users = model.getObsUsers();
		if (!obs_users.isEmpty())
    	{
            userlist.setItems(obs_users);
            userlist.getSelectionModel().select(0);
    	}
	}
	
	public void doAdd()
	{
		ObservableList<User> obs_users = model.getObsUsers();
		String name = namefield.getText().trim();
		
		if (model.getUser(name) != null)
		{
			// bad
		}
		else
		{
			User user = new User(name);
			model.addUser(user);
			
			if (obs_users.isEmpty())
	    	{
	            obs_users.add(user);
	            userlist.setItems(obs_users);
	            userlist.getSelectionModel().select(0);
	    	}
			else
			{
				int i = 0;
	    		for (; i < obs_users.size(); i++)
		    	{	    		
		            if (user.compareTo(obs_users.get(i)) < 0)
		            {
		                break;
		            }
		    	}
	    		obs_users.add(i, user);
		        userlist.setItems(obs_users);
		        userlist.getSelectionModel().select(i);
			}
		}
		namefield.clear();
	}
	
	public void doDelete()
	{
		
	}
	
	public void doAbout()
	{
		// complete
	}
}
