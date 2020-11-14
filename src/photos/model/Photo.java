package photos.model;

import java.time.LocalDateTime;
import java.util.*;

public class Photo
{
	private String name;
	private String caption;
	private LocalDateTime datetime;
	
	public Photo(String name)
	{
		this.name = name;
		caption = "";
		datetime = null;
	}

}
