package photos.model;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements Comparable<User>
{
	private String name;
	private ArrayList<Album> albums;
	private Album current_album;
	private ObservableList<Album> obs_albums;

	public User(String name)
	{
		this.name = name;
		albums = new ArrayList<>();
		current_album = null;
		obs_albums = null;
		obs_albums = FXCollections.observableArrayList();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Album> getAlbums()
	{
		return albums;
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
	
	public Album getCurrentAlbum()
	{
		return current_album;
	}

	public ObservableList<Album> getObsAlbums()
	{
        return obs_albums;
    }
	
	public void addAlbum(String name)
	{
		Album album = new Album(name);
		albums.add(album);
		obs_albums.add(album);
	}
	
	public void addAlbum(Album album)
	{
		albums.add(album);
		obs_albums.add(album);
	}
	
	public void deleteAlbum(Album album)
	{
		albums.remove(album);
		obs_albums.remove(album);
	}
	
	public void setCurrentAlbum(Album album)
	{
        current_album = album;
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
