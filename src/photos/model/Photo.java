/**
* This class helps with Photo Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Photo implements Serializable
{
	 /**
     * Serial Version UID
     */
	private static final long serialVersionUID = 1972277178174046585L;
	
	
	private String path;
	private String caption;
	private long date;
	private ObservableList<Tag> tags;

	/**
     * Method to derive photo attributes
     */
	public Photo(String path)
	{
		this.path = path;
		caption = path;
		date = (new File(path)).lastModified();
		tags = FXCollections.observableArrayList();
	}
	
	/**
     * Method to assign photo attribute values
     */
	public Photo(Photo photo)
	{
		this.path = photo.getPath();
		caption = photo.getCaption();
		date = (new File(path)).lastModified();
		tags = photo.getTags();
	}
	
	/**
     * Method to get photo path
     */
	public String getPath()
	{
		return path;
	}
	
	
	/**
     * Method to get photo caption
     */
	public String getCaption()
	{
		return caption;
	}

	
	/**
     * Method to set photo caption
     */
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	
	
	/**
     * Method to get photo date
     */
	public long getDate()
	{
		return date;
	}
	
	
	/**
     * Method to get photo tags
     */
	public ObservableList<Tag> getTags()
	{
		return tags;
	}
	
	/**
     * Method to add photo tag
     */
	public boolean addTag(Tag tag)
	{
		for (Tag tag1 : tags)
		{
			if ( (tag1.getName().equals(tag.getName()) && (tag1.isSingle() || tag.isSingle())) || (tag1.getName().equals(tag.getName()) && tag1.getValue().equals(tag.getValue())) )
			{
				return false;
			}
		}
		tags.add(tag);
		return true;
	}
	
	public boolean addTag(String name, String value, boolean single)
	{
		Tag tag = new Tag(name, value, single);
		for (Tag tag1 : tags)
		{
			if ( (tag1.getName().equals(tag.getName()) && (tag1.isSingle() || tag.isSingle())) || (tag1.getName().equals(tag.getName()) && tag1.getValue().equals(tag.getValue())) )
			{
				return false;
			}
		}
		tags.add(tag);
		return true;
	}
	
	/**
     * Method to to display photo thumbnails in album
     */
	
	public BorderPane getThumbnail(EventHandler<MouseEvent> handler)
	{
        Image image = null;
        ImageView view;
        try
        {
            image = new Image(new FileInputStream(getPath()));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
		view = new ImageView(image);
        view.setFitWidth(150);
        view.setFitHeight(120);
        view.setSmooth(true);
        
        view.setOnMouseClicked(handler);
        view.setUserData(this);
        
        Photo photo = this;
        TextField textfield = new TextField(getCaption());
        textfield.setPrefWidth(150);
        textfield.setOnAction(event ->
        {
            TextField textField = (TextField) event.getSource();
            String temp = textField.getText().trim();
            if (temp.length() == 0)
            {
                textField.setText(photo.getCaption());
            }
            else
            {
                photo.setCaption(temp);
            }
        });
        
        VBox vbox = new VBox(2);
        vbox.getChildren().addAll(view, textfield);
        
        BorderPane wrapper = new BorderPane(vbox);
        wrapper.setStyle("-fx-border-color: black");
        
        return wrapper;
	}
	
	public Node getPicture(EventHandler<MouseEvent> handler)
	{
		Image image = null;
        ImageView view;
        try
        {
            image = new Image(new FileInputStream(getPath()));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
		view = new ImageView(image);
        view.setFitWidth(500);
        view.setFitHeight(460);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        
        view.setOnMouseClicked(handler);
        view.setUserData(this);
        
        Photo photo = this;
        TextField textfield = new TextField(getCaption());
        textfield.setPrefWidth(150);
        textfield.setOnAction(event ->
        {
            TextField textField = (TextField) event.getSource();
            String temp = textField.getText().trim();
            if (temp.length() == 0)
            {
                textField.setText(photo.getCaption());
            }
            else
            {
                photo.setCaption(temp);
            }
        });
        
        VBox vbox = new VBox(2);
        vbox.getChildren().addAll(view, textfield);
        
        BorderPane wrapper = new BorderPane(vbox);
        wrapper.setStyle("-fx-border-color: black");
        
        return wrapper;
	}
	
	public static String epochToLocalTime(long time)
	{
        LocalDateTime datetime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //
        return datetime.format(formatter);
    }
	
}
