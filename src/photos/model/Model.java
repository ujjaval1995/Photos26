package photos.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	public static final String ADMIN = "admin";
	
	private User currentUser;
	private ObservableList<User> users;
	
	public Model()
	{
		users = FXCollections.observableArrayList();
		currentUser = null;
		
		User stock = new User("stock");
		users.add(stock);
		
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
	
	
	public User getCurrentUser()
	{
        return currentUser;
    }

	public void setCurrentUser(String name)
	{
		for (User user : users)
		{
			if (user.getName().equals(name))
			{
				currentUser = user;
			}
		}
	}
	
	public ObservableList<User> getUsers()
	{
		return users;
	}
	
	public void addUser(User user)
	{
		users.add(user);
	}
	
	public void deleteUser(User user)
	{
		users.remove(user);
	}
}
