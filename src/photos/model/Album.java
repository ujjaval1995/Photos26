/**
* This class helps with Album Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.model;

import java.util.*;
import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Album implements Comparable<Album>, Serializable
{
	/**
     * Serial Version UID
     */
	private static final long serialVersionUID = 4299782837955524379L;
	
//	public static final String storeDir ="dat";
//	public static final String storeFile = "Album.dat";
	
	private String name;
	private int photoCount;
	private String startDate;
	private String endDate;
	private ArrayList<Photo> photos;
	private Photo currentPhoto;
	
//	public static void writeAlbum(Album album1) throws IOException {
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
//		oos.writeObject(album1); 
//		}
	
	public Album(String name)
	{
		this.name = name;
		photoCount = 0;
		startDate = "-";
		endDate = "-";
		photos = new ArrayList<>();
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
	public String getStartDate()
	{
		return startDate;
	}
	
	/**
     * End Date of the album
     */
	public String getEndDate()
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
	public Photo addPhoto(Photo photo)
	{
		photos.add(photo);
		photoCount++;
		setDates();
		return photo;
	}
	
	
	/**
     * Method to delete photo from the album
     */
	public void deletePhoto(Photo photo)
	{
		photos.remove(photo);
		setDates();
		photoCount--;
	}

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
	

	public void setDates()
	{
		if (photoCount == 0)
		{
		    startDate = "-";
		    endDate = "-";
		}
		else
		{
			boolean start = true;
			long min = 0;
			long max = 0;
			for (Photo photo: photos)
			{
				if (start)
				{
					min	= photo.getDate();
					max	= photo.getDate();
					start = false;
				}
				else
				{
					long date = photo.getDate();
					if (date > max)
					{
						max = date;
					}
					if (date < min)
					{
						min = date;
					}
				}
			}
		    startDate = Photo.epochToLocalTime(min);
		    endDate = Photo.epochToLocalTime(max);
		}
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