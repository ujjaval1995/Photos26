package photos.model;

import java.io.Serializable;

public class Tag implements Comparable<Tag>,Serializable
{
	
	 /**
     * Serial Version UID
     */
	private static final long serialVersionUID = -3857758798627188080L;
	private String name;
	private String value;
	private boolean single;
	
	public Tag(String name, String value)
	{
		this.name = name;
		this.value = value;
		single = false;
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
