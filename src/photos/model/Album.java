package photos.model;

import java.util.*;
import java.time.LocalDate;

public class Album implements Comparable<Album>
{
	private String name;
	private String name2;
	private int photo_count;
	private LocalDate start_date;
	private LocalDate end_date;
	private ArrayList<Photo> photos;
	
	public Album(String name)
	{
		this.name = name;
		name2 = name;
		photo_count = 0;
		start_date = null;
		end_date = null;
		photos = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPhotoCount()
	{
		return photo_count;
	}
	
	public int getPhoto_count()
	{
		return photo_count;
	}
	
	public LocalDate getStartDate()
	{
		return start_date;
	}
	
	public LocalDate getStart_date()
	{
		return start_date;
	}
	
	public LocalDate getEnd_date()
	{
		return end_date;
	}
	
	public ArrayList<Photo> getPhotos()
	{
		return photos;
	}
	
	public void addPhoto(Photo photo)
	{
		photos.add(photo);
	}
	
	public void deletePhoto(Photo photo)
	{
		photos.remove(photo);
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
