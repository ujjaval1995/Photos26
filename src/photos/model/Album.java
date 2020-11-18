/**
* This class helps with Album Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
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

	/**
     * Set Name of the album
     */
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
     * Name of the album
     */
	
	public String getName()
	{
		return name;
	}
	
	/**
     * Number of photos in the album
     */
	
	public int getPhotoCount()
	{
		return photoCount;
	}
	
	/**
     * Start Date of the Album
     */
	public LocalDate getStartDate()
	{
		return startDate;
	}
	
	
	/**
     * End Date of the album
     */
	public LocalDate getEndDate()
	{
		return endDate;
	}
	
	
	/**
     * List of photos in the album
     */
	public ArrayList<Photo> getPhotos()
	{
		return photos;
	}
	
	/**
     * Method to add photo in the album
     */
	public void addPhoto(Photo photo)
	{
		photos.add(photo);
		// obslist.add(photo.getThumbnail());
		photoCount++;
	}
	
	
	/**
     * Method to delete photo from the album
     */
	public void deletePhoto(Photo photo)
	{
		photos.remove(photo);
		photoCount--;
	}
	
//	public ObservableList<Node> getObslist()
//	{
//		return obslist;
//	}
	
	
	/**
     * Method to get current photo in the album
     */
	public Photo getCurrentPhoto()
	{
		return currentPhoto;
	}
	
	/**
     * Method to set current photo in the album
     */
	
	public void setCurrentPhoto(Photo photo)
	{
		currentPhoto = photo;
	}
	
	/**
     * Name of the album to add/delete
     */
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
