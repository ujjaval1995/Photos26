/**
* This class helps with User Model.
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

public class User implements Comparable<User>, Serializable
{
	
	/**
     * Serial Version UID
     */
	private static final long serialVersionUID = 7071842589774998235L;

//	public static final String storeDir ="dat";
//	public static final String storeFile = "User.dat";
//	
//
//	public static void writeUser(User user1) throws IOException {
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
//		oos.writeObject(user1); 
//		}
	
	private String name;
	
	/**
     * List of Albums
     */
	private ObservableList<Album> albums;
	
	/**
     * current album
     */
	private Album currentAlbum;

	public User(String name)
	{
		this.name = name;
		albums = FXCollections.observableArrayList();
		currentAlbum = null;
	}
	/**
     * method to Username
     */
	public String getName()
	{
		return name;
	}
	
	/**
     * method to get albums
     */
	public ObservableList<Album> getAlbums()
	{
		return albums;
	}
	
	/**
     * Method to get current Album
     */
	public Album getCurrentAlbum()
	{
		return currentAlbum;
	}
	
	
	/**
     * Method to set current album
     */
	public void setCurrentAlbum(Album album)
	{
        currentAlbum = album;
    }
	
	public void setCurrentAlbum(String name)
	{
		for (Album album : albums)
		{
			if (album.getName().equals(name))
			{
				currentAlbum = album;
			}
		}
    }
	
	public Album getAlbum(String name)
	{
		for (Album album : albums)
		{
			if (album.getName().equals(name))
			{
				return album;
			}
		}
		return null;
	}
	
	public Album getAlbum(Album album)
	{
		for (Album album1 : albums)
		{
			if (album1.getName().equals(album.getName()))
			{
				return album;
			}
		}
		return null;
	}
	
	/**
     * Method to add Album
     */
	public Album addAlbum(String name)
	{
		Album album = new Album(name);
		albums.add(album);
		return album;
	}
	
	public Album addAlbum(Album album)
	{
		albums.add(album);
		return album;
	}
	/**
     * Method to Delete Albums
     */
	public void deleteAlbum(Album album)
	{
		albums.remove(album);
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public int compareTo(User user)
	{
		return name.compareToIgnoreCase(user.name);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if ((o == null) || !(o instanceof User))
		{
			return false;
		}
		User other = (User) o;
		return name.equals(other.name);
	}
}
