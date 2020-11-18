package photos.model;

import java.util.*;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.Node;

import java.time.LocalDate;

public class Album implements Comparable<Album>
{
	private String name;
	private int photoCount;
	private LocalDate startDate;
	private LocalDate endDate;
	private ArrayList<Photo> photos;
	// ObservableList<Node> obslist;
	private Photo currentPhoto;
	
	public Album(String name)
	{
		this.name = name;
		photoCount = 0;
		startDate = null;
		endDate = null;
		photos = new ArrayList<>();
		// obslist = FXCollections.observableArrayList();
		currentPhoto = null;
	}

	public void setName(String name)
	{
		this.name = name;
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
		// obslist.add(photo.getThumbnail());
		photoCount++;
	}
	
	public void deletePhoto(Photo photo)
	{
		photos.remove(photo);
		photoCount--;
	}
	
//	public ObservableList<Node> getObslist()
//	{
//		return obslist;
//	}
	
	public Photo getCurrentPhoto()
	{
		return currentPhoto;
	}
	
	public void setCurrentPhoto(Photo photo)
	{
		currentPhoto = photo;
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
	
	@Override
	public boolean equals(Object o)
	{
		if ((o == null) || !(o instanceof Album))
		{
			return false;
		}
		Album other = (Album) o;
		return name.equals(other.name);
	}
}
