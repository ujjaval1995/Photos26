package photos.model;

public class Tag implements Comparable<Tag>
{
	private String name;
	private String value;
	private boolean single;
	
	public Tag(String name, String value, boolean single)
	{
		this.name = name;
		this.value = value;
		this.single = single;
	}
	
	public String getName()
	{
		return name;
	}
	
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
