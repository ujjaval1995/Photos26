package photos.controller;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
			Alert error = new Alert(AlertType.ERROR, "User already exists");
            error.showAndWait();
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
		        userlist.getSelectionModel().select(user);
			}
		}
		namefield.clear();
	}
	
	public void doDelete()
	{
		int index = userlist.getSelectionModel().getSelectedIndex();
    	
    	if (index < 0)
    	{
    		Alert error = new Alert(AlertType.ERROR, "No user selected");
            error.showAndWait();
    	}
    	else
    	{
    		ObservableList<User> obs_users = model.getObsUsers();
    		int size = obs_users.size();
    	
	    	User user = obs_users.get(index);
	    	obs_users.remove(index);
	    	model.deleteUser(user);;
	        userlist.setItems(obs_users);
	        
	        if (size > index + 1)
	        {
	            userlist.getSelectionModel().select(index);
	        }
	        else if (size >= 2)
	        {
	            userlist.getSelectionModel().select(index-1);
	        }
	        else
	        {
	        	userlist.getSelectionModel().select(0);
	        }
    	}
    	namefield.clear();
	}
	
	public void doAbout()
	{
		// complete
	}
}
