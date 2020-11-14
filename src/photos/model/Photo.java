package photos.model;

import java.util.*;
import java.time.LocalDateTime;

public class Photo
{
	private UUID id;
	private String caption;
	private LocalDateTime datetime;
	private HashMap<String, HashSet<String>> tags;
	
	public Photo()
	{
		id = UUID.randomUUID();
		caption = "";
		datetime = null;
		tags = new HashMap<>();
	}

}
