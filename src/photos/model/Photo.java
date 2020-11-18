/**
* This class helps with Photo Model.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.model;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Photo implements Serializable
{
	 /**
     * Serial Version UID
     */
	private static final long serialVersionUID = 1972277178174046585L;
	private String path;
	private UUID id;
	private String caption;
	private LocalDateTime datetime;
	private ObservableList<Tag> tags;

	public Photo(String path)
	{
		this.path = path;
		id = UUID.randomUUID();
		caption = path;
		datetime = null;
		tags = FXCollections.observableArrayList();
	}
	
	public Photo(Photo photo)
	{
		this.path = photo.getPath();
		id = UUID.randomUUID();
		caption = photo.getCaption();
		datetime = photo.getDatetime();
		tags = photo.getTags();
	}
	
	public String getPath()
	{
		return path;
	}
	
	public UUID getId()
	{
		return id;
	}
	
	public String getCaption()
	{
		return caption;
	}

	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	
	public LocalDateTime getDatetime()
	{
		return datetime;
	}
	
	public ObservableList<Tag> getTags()
	{
		return tags;
	}
	
	public boolean addTag(Tag tag)
	{
		for (Tag tag1 : tags)
		{
			if ( (tag1.getName().equals(tag.getName()) && tag1.isSingle()) || (tag1.getName().equals(tag.getName()) && tag1.getValue().equals(tag.getValue())) )
			{
				return false;
			}
		}
		tags.add(tag);
		return true;
	}
	
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
	
//	public Node getPicture()
//	{
//		
//	}
	
}
