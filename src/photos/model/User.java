package photos.model;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements Comparable<User>
{
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
	
	public Album getSelectedAlbum()
	{
		return select_album;
	}

	public ObservableList<Album> getObsAlbums()
	{
        return obs_albums;
    }
	
	public void addAlbum(String name)
	{
		albums.add(new Album(name));
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
