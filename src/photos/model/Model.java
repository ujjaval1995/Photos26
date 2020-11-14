package photos.model;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	public static final String ADMIN = "admin";
	
	private ArrayList<User> users;
	private User current_user;
	private ObservableList<User> obs_users;
	
	public Model()
	{
		users = new ArrayList<>();
		current_user = null;
		obs_users = FXCollections.observableArrayList();;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getCurrentUser()
	{
        return current_user;
    }
	
	public void addUser(String name)
	{
		users.add(new User(name));
	}
	
	public void deleteUser(User user)
	{
		users.remove(user);
	}
	
	public void setCurrentUser(User user)
	{
		current_user = user;
	}
	
	public ObservableList<User> getObsUsers()
	{
        return obs_users;
    }
}
