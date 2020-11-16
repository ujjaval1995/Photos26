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
		obs_users = FXCollections.observableArrayList();
		
		User stock = new User("stock");
		users.add(stock);
		obs_users.add(stock);
		
		Album pokemon = new Album("Pokemon");
		Album cs_department = new Album("CS Department");
		Album students = new Album("Students");
		stock.addAlbum(pokemon);
		stock.addAlbum(cs_department);
		stock.addAlbum(students);
		
		Photo bulbasaur = new Photo();
		Photo squirtle = new Photo();
		Photo charmander = new Photo();
		Photo pikachu = new Photo();
		stock.getAlbum(pokemon).addPhoto(bulbasaur);
		stock.getAlbum(pokemon).addPhoto(squirtle);
		stock.getAlbum(pokemon).addPhoto(charmander);
		stock.getAlbum(pokemon).addPhoto(pikachu);
		
		Photo franny = new Photo();
		Photo guna = new Photo();
		Photo santosh = new Photo();
		Photo sesh = new Photo();
		stock.getAlbum(cs_department).addPhoto(franny);
		stock.getAlbum(cs_department).addPhoto(guna);
		stock.getAlbum(cs_department).addPhoto(santosh);
		stock.getAlbum(cs_department).addPhoto(sesh);
		
		Photo jishnu = new Photo();
		Photo ujjaval = new Photo();
		stock.getAlbum(students).addPhoto(jishnu);
		stock.getAlbum(students).addPhoto(ujjaval);
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getUser(String name)
	{
		for (User user : users)
		{
			if (user.getName().equals(name))
			{
				return user;
			}
		}
		return null;
	}
	
	public User getCurrentUser()
	{
        return current_user;
    }
	
	public void addUser(User user)
	{
		users.add(user);
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

	public ObservableList<User> AddObsUser()
	{
        return obs_users;
    }
}
