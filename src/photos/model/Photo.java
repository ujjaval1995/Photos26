package photos.model;

import java.util.*;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	
	public LocalDateTime getDatetime()
	{
		return datetime;
	}
	
	public HashMap<String, HashSet<String>> getTags()
	{
		return tags;
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
}
