/**
* This class helps with Main Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model implements Serializable
{
	/**
     * Serial Version UID
     */
	private static final long serialVersionUID = -3317259650904411150L;

	public static final String storeDir ="dat";
	public static final String storeFile = "Model.dat";
	

	public static void writeModel(Model model1) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
		oos.writeObject(model1); 
		}

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
	}
	
	/**
     * Method to get Current User
     */
	public User getCurrentUser()
	{
        return currentUser;
    }

	
	/**
     * Method to set Current User
     */
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
	
	
	/**
     * List of Users
     */
	public ObservableList<User> getUsers()
	{
		return users;
	}
	
	/**
     * Method to add User
     */
	public User addUser(User user)
	{
		users.add(user);
		return user;
	}
	
	
	/**
     * Method to delete User
     */
	public void deleteUser(User user)
	{
		users.remove(user);
	}
}
