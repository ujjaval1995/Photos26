package photos.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Tag implements Comparable<Tag>,Serializable
{
	
	 /**
     * Serial Version UID
     */
	private static final long serialVersionUID = -3857758798627188080L;
	
	public static final String storeDir ="dat";
	public static final String storeFile = "Tag.dat";
	

	public static void writeTag(Tag tag1) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
		oos.writeObject(tag1); 
		}
	private String name;
	private String value;
	private boolean single;
	
	public Tag(String name, String value, boolean single)
	{
		this.name = name;
		this.value = value;
		this.single = single;
	}
	
	 /**
     * Tag name
     */
	public String getName()
	{
		return name;
	}
	
	
	 /**
     * Tag value
     */
	public String getValue()
	{
		return value;
	}

	public boolean isSingle()
	{
		return single;
	}
	
	@Override
	public String toString()
	{
    	return name + ((single) ? " (singular)" : "") + " = " + value;
    }

	 /**
     * method to compare similar tags
     */
	@Override
	public int compareTo(Tag tag)
	{
		int ret = name.compareToIgnoreCase(tag.name);
		if (ret == 0)
		{
			ret = value.compareToIgnoreCase(tag.value);
		}
		return ret;
	}
}
