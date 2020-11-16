package photos.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements Comparable<User>
{
	private String name;
	private ObservableList<Album> albums;
	private Album currentAlbum;

	public User(String name)
	{
		this.name = name;
		albums = FXCollections.observableArrayList();
		currentAlbum = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ObservableList<Album> getAlbums()
	{
		return albums;
	}
	
	public Album getCurrentAlbum()
	{
		return currentAlbum;
	}
	
	public void setCurrentAlbum(Album album)
	{
        currentAlbum = album;
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
	
	public void addAlbum(String name)
	{
		Album album = new Album(name);
		albums.add(album);
	}
	
	public void addAlbum(Album album)
	{
		albums.add(album);
	}
	
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
