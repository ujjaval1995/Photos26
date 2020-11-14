package photos.model;

import javafx.collections.ObservableList;

import java.util.*;


public class User implements Comparable<User>
{
	public static final String ADMIN = "admin";
	
	private String name;
	private ArrayList<Album> albums;
	private Album select_album;
	private ObservableList<Album> obs_albums;

	public User(String name)
	{
		this.name = name;
		albums = new ArrayList<>();
		select_album = null;
		obs_albums = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Album> getAlbums()
	{
		return albums;
	}
	
	public Album getSelectedAlbum()
	{
		return select_album;
	}
	
	// obs list
	// complete
	
	public void addAlbum(String name)
	{
		Album album = new Album(name);
		albums.add(album);
	}
	
	public void deleteAlbum(Album album)
	{
		albums.remove(album);
	}
	
	public void setSelectedAlbum(Album album)
	{
        select_album = album;
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
}
