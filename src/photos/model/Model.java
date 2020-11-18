package photos.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	public static final String ADMIN = "admin";
	
	private ObservableList<User> users;
	private User currentUser;
	
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
		
		// Photo bulbasaur = new Photo("data/001.png");
		Photo squirtle = new Photo("data/004.png");
		Photo charmander = new Photo("data/007.png");
		Photo pikachu = new Photo("data/025.png");
		// stock.getAlbum(pokemon).addPhoto(bulbasaur);
		stock.getAlbum(pokemon).addPhoto(squirtle);
		stock.getAlbum(pokemon).addPhoto(charmander);
		stock.getAlbum(pokemon).addPhoto(pikachu);
		
		Photo franny = new Photo("data/Franny.jpg");
		Photo guna = new Photo("data/Guna.jpg");
		Photo santosh = new Photo("data/Santosh.jpg");
		Photo sesh = new Photo("data/Sesh.jpg");
		stock.getAlbum(cs_department).addPhoto(franny);
		stock.getAlbum(cs_department).addPhoto(guna);
		stock.getAlbum(cs_department).addPhoto(santosh);
		stock.getAlbum(cs_department).addPhoto(sesh);
		
		Photo jishnu = new Photo("data/Jishnu.jpg");
		Photo ujjaval = new Photo("data/Ujjaval.jpg");
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
