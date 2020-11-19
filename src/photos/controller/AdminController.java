/**
 * This class helps with admin View.
 * @author Jishnu Patel
 * @author Ujjaval Shah
 */
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
	/**
     * ListView for List of Users
     */
	@FXML ListView<User> userlist;
	
	/**
     * TextField for name of user to be added
     */
	@FXML TextField namefield;
	
	/**
     * Button for adding username to be added
     */
	@FXML Button add;
	
	/**
     * Button for deleting username to be deleted
     */
	@FXML Button delete;
	
	 public static final String AdminHelp = "/Photos/view/AdminHelp.fxml";
	
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
	/**
     * Adds an user(by admin)
     */
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
			}
		}
		namefield.clear();
	}
	
	/**
     * Deletes an user
     */
	public void doDelete()
	{
		ObservableList<User> users = model.getUsers();
		User user = userlist.getSelectionModel().getSelectedItem();
		users.remove(user);
		userlist.setItems(users);
	}
	
	public void doAbout()
	{
		About(AdminHelp);
	}
}
