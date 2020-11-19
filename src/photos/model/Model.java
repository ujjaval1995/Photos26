/**
* This class helps with Main Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
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
		
		User stock = addUser(new User("stock"));
		
		Album pokemon = stock.addAlbum(new Album("Pokemon"));
		Album cs_department = stock.addAlbum(new Album("CS Department"));
		Album students = stock.addAlbum(new Album("Students"));
		
		Photo bulbasaur = pokemon.addPhoto(new Photo("data/001.png"));
		Photo charmander = pokemon.addPhoto(new Photo("data/004.png"));
		Photo squirtle = pokemon.addPhoto(new Photo("data/007.png"));
		Photo pikachu = pokemon.addPhoto(new Photo("data/025.png"));
		
		bulbasaur.addTag("type", "grass", false);
		charmander.addTag("type", "fire", false);
		squirtle.addTag("type", "water", false);
		pikachu.addTag("type", "electric", false);
		
		Photo franny = cs_department.addPhoto(new Photo("data/Franny.jpg"));
		Photo guna = cs_department.addPhoto(new Photo("data/Guna.jpg"));
		Photo santosh = cs_department.addPhoto(new Photo("data/Santosh.jpg"));
		Photo sesh = cs_department.addPhoto(new Photo("data/Sesh.jpg"));
		
		Photo jishnu = students.addPhoto(new Photo("data/Jishnu.jpg"));
		Photo ujjaval = students.addPhoto(new Photo("data/Ujjaval.jpg"));
		
//		Photo bulbasaur = stock.getAlbum(pokemon).addPhoto(new Photo("data/001.png"));
//		Photo squirtle = stock.getAlbum(pokemon).addPhoto(new Photo("data/004.png"));
//		Photo charmander = stock.getAlbum(pokemon).addPhoto(new Photo("data/007.png"));
//		Photo pikachu = stock.getAlbum(pokemon).addPhoto(new Photo("data/025.png"));
//		
//		Photo franny = stock.getAlbum(cs_department).addPhoto(new Photo("data/Franny.jpg"));
//		Photo guna = stock.getAlbum(cs_department).addPhoto(new Photo("data/Guna.jpg"));
//		Photo santosh = stock.getAlbum(cs_department).addPhoto(new Photo("data/Santosh.jpg"));
//		Photo sesh = stock.getAlbum(cs_department).addPhoto(new Photo("data/Sesh.jpg"));
//		
//		Photo jishnu = stock.getAlbum(students).addPhoto(new Photo("data/Jishnu.jpg"));
//		Photo ujjaval = stock.getAlbum(students).addPhoto(new Photo("data/Ujjaval.jpg"));
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
	
	public User addUser(User user)
	{
		users.add(user);
		return user;
	}
	
	public void deleteUser(User user)
	{
		users.remove(user);
	}
}
