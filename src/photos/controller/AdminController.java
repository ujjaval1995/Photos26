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
		ObservableList<User> users = model.getUsers();
		if (!users.isEmpty())
    	{
            userlist.setItems(users);
            userlist.getSelectionModel().select(0);
    	}
	}
	
	public void doAdd()
	{
		ObservableList<User> users = model.getUsers();
		String name = namefield.getText().trim();
		
		if (name.equals(Model.ADMIN))
		{
			Alert error = new Alert(AlertType.ERROR, "Username cannot be \"admin\"");
            error.showAndWait();
		}
		else if (name.length() != 0)
		{
			User user = new User(name);
			
			if (users.contains(user))
			{
				Alert error = new Alert(AlertType.ERROR, "User already exists");
				error.showAndWait();
			}
			else
			{
				if (users.isEmpty())
		    	{
		            users.add(user);
		            userlist.setItems(users);
		            userlist.getSelectionModel().select(0);
		    	}
				else
				{
					int i = 0;
		    		for (; i < users.size(); i++)
			    	{	    		
			            if (user.compareTo(users.get(i)) < 0)
			            {
			                break;
			            }
			    	}
		    		users.add(i, user);
			        userlist.setItems(users);
			        userlist.getSelectionModel().select(user);
				}
				delete.setDisable(false);
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
    		ObservableList<User> users = model.getUsers();
    		int size = users.size();
    	
	    	User user = users.get(index);
	    	users.remove(index);
	    	model.deleteUser(user);;
	        userlist.setItems(users);
	        
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
	    	if (users.isEmpty())
	    	{
	    		delete.setDisable(true);
	    	}
    	}
	}
	
	public void doAbout()
	{
		// complete
	}
}
