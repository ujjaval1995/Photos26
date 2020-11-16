package photos.model;

import java.util.*;
import java.time.LocalDate;

public class Album implements Comparable<Album>
{
	private String name;
	private int photoCount;
	private LocalDate startDate;
	private LocalDate endDate;
	private ArrayList<Photo> photos;
	
	public Album(String name)
	{
		this.name = name;
		photoCount = 0;
		startDate = null;
		endDate = null;
		photos = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPhotoCount()
	{
		return photoCount;
	}
	
	public LocalDate getStartDate()
	{
		return startDate;
	}
	
	public LocalDate getEndDate()
	{
		return endDate;
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
