/**
* This class helps with Photo Controller.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.controller;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import photos.model.*;

public class PhotoController extends MainController implements EventHandler<MouseEvent>
{
	@FXML Menu albummenu;
	@FXML Pagination pages;
	@FXML ListView<Tag> listview;
	@FXML TextField namefield;
	@FXML TextField valuefield;
	@FXML Label datefield;
	@FXML CheckBox singular;
	@FXML Button add;
	@FXML Button delete;
	
	public void initialize()
	{
		pages.setPageFactory(pageIndex ->
		{
			Album album = model.getCurrentUser().getCurrentAlbum();
	        if (album.getPhotoCount() > 0)
	        {
	            Photo photo = album.getPhotos().get(pageIndex);
	            album.setCurrentPhoto(photo);
	            
	            listview.setItems(photo.getTags());
	            datefield.setText(Photo.epochToLocalTime(photo.getDate()));
	            return photo.getPicture(this);
	        }
	        else
	        {
	            return null;
	        }
		});
	}
	
	public void init()
	{
		refreshPages();
		Album album = model.getCurrentUser().getCurrentAlbum();
		Photo photo = album.getCurrentPhoto();
        album.setCurrentPhoto(photo);
        
        listview.setItems(photo.getTags());
        datefield.setText(Photo.epochToLocalTime(photo.getDate()));
		pages.setCurrentPageIndex(album.getPhotos().indexOf(album.getCurrentPhoto()));
		
		namefield.clear();
		valuefield.clear();
		singular.setSelected(false);
		refreshPages();
		refreshMenu();
	}

	@Override
	public void handle(MouseEvent event)
	{
		Object obj = event.getSource();
		
		if (obj instanceof ImageView)
		{
			ImageView view = (ImageView) obj;
			
			if (event.getButton().equals(MouseButton.PRIMARY))
			{
            	Object obj1 = view.getUserData();
            	Photo photo = (Photo) obj1;
            	
            	Album album = model.getCurrentUser().getCurrentAlbum();
            	album.setCurrentPhoto(photo);
            	toAlbum(album.getName());
	        }
	        event.consume();
		}
	}
	
	public void doAddTag()
	{
		Photo photo = model.getCurrentUser().getCurrentAlbum().getCurrentPhoto();
		ObservableList<Tag> tags = photo.getTags();
		String name = namefield.getText().trim();
		String value = valuefield.getText().trim();
		
		if (name.length() != 0 && value.length() != 0)
		{
			Tag tag = new Tag(name, value, singular.isSelected());
			if (photo.addTag(tag))
			{
				listview.setItems(tags);
				listview.getSelectionModel().select(tag);
			}
			else
			{
				Alert error = new Alert(AlertType.ERROR, "Invalid or duplicate tag");
	            error.showAndWait();
			}
			namefield.clear();
			valuefield.clear();
			singular.setSelected(false);
		}
	}
	
	public void doDeleteTag()
	{
		ObservableList<Tag> tags = model.getCurrentUser().getCurrentAlbum().getCurrentPhoto().getTags();
		Tag tag = listview.getSelectionModel().getSelectedItem();
		tags.remove(tag);
		listview.setItems(tags);
	}
	
	public void refreshPages()
	{
		Album album = model.getCurrentUser().getCurrentAlbum();
		Photo photo = album.getCurrentPhoto();
		pages.setPageCount(album.getPhotoCount());
		pages.setCurrentPageIndex(album.getPhotos().indexOf(photo));
	}
	
	public void refreshMenu()
	{
		albummenu.getItems().clear();
		for (Album album : model.getCurrentUser().getAlbums())
		{
			if (!album.equals(model.getCurrentUser().getCurrentAlbum()))
			{
				MenuItem item = new MenuItem(album.getName());
	        	item.setOnAction(e ->
	        	{
	        		MenuItem item1 = (MenuItem) e.getSource();
	        		model.getCurrentUser().setCurrentAlbum(item1.getText());
	        		toAlbum(item1.getText());
	            });
	        	albummenu.getItems().add(item);
			}
    	}
	}
}
