package photos.model;

import java.time.LocalDate;
import java.util.*;

public class Album implements Comparable<Album>
{
	private String name;
	private int photo_count;
	private LocalDate start_date;
	private LocalDate end_date;
	private ArrayList<Photo> photos;
	
	public Album(String name)
	{
		this.name = name;
		photo_count = 0;
		start_date = null;
		end_date = null;
		photos = new ArrayList<>();
	}
	
	
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public int compareTo(Album album)
	{
		return name.compareToIgnoreCase(album.name);
	}
}
