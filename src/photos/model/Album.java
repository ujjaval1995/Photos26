/**
* This class helps with Album Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.model;

import java.util.*;

public class Album implements Comparable<Album>
{
	private String name;
	private int photoCount;
	private String startDate;
	private String endDate;
	private ArrayList<Photo> photos;
	private Photo currentPhoto;
	
	public Album(String name)
	{
		this.name = name;
		photoCount = 0;
		startDate = "-";
		endDate = "-";
		photos = new ArrayList<>();
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
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public String getEndDate()
	{
		return endDate;
	}
	
	public ArrayList<Photo> getPhotos()
	{
		return photos;
	}
	
	public Photo addPhoto(Photo photo)
	{
		photos.add(photo);
		photoCount++;
		setDates();
		return photo;
	}
	
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