package photos.model;

import java.util.*;
import javafx.collections.ObservableList;


public class User implements Comparable<User>
{
	public static final String ADMIN = "admin";
	
	private String username;
	private ObservableList<Album> obs_albums;
	private ArrayList<Album> albums;
	private Album select_album;
	

	public User(String username)
	{
		this.username = username;
		this.obs_albums = null;
		this.albums = null;
		this.select_album = null;
	}
	
	@Override
	public String toString()
	{
		return username;
	}
	
	
	@Override
	public int compareTo(User user)
	{
		return username.compareToIgnoreCase(user.username);
	}
	
	
	
}
