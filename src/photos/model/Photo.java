package photos.model;

import java.util.*;
import java.io.File;
import java.time.LocalDateTime;

public class Photo
{
	private String path;
	private File file;
	private UUID id;
	private String caption;
	private LocalDateTime datetime;
	private HashMap<String, HashSet<String>> tags;
	
	public Photo(File file)
	{
		this.file = file;
		id = UUID.randomUUID();
		caption = "";
		datetime = null;
		tags = new HashMap<>();
	}

	public Photo(String path)
	{
		this.path = path;
		file = new File(path);
		id = UUID.randomUUID();
		caption = path;
		datetime = null;
		tags = new HashMap<>();
	}
	
	public String getPath()
	{
		return path;
	}
	
	public File getFile()
	{
		return file;
	}
	
	public UUID getId()
	{
		return id;
	}
	
	public String getCaption()
	{
		return caption;
	}
	
	public LocalDateTime getDatetime()
	{
		return datetime;
	}
	
	public HashMap<String, HashSet<String>> getTags()
	{
		return tags;
	}
}
