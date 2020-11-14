package photos.model;

import java.util.*;

public class Tag implements Comparable<Tag>
{
	private String name;
	private ArrayList<String> values;
	
	public Tag(String name, String value)
	{
		this.name = name;
		values = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<String> getValues()
	{
		return values;
	}
	
	public void addValue(String value)
	{
		values.add(value);
	}
	
	public void deleteValue(String value)
	{
		values.remove(value);
	}
	
	@Override
	public String toString()
	{
    	return name;
    }

	@Override
	public int compareTo(Tag tag)
	{
		return name.compareToIgnoreCase(tag.name);
	}
}
