package photos.controller;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import photos.model.*;

public class AlbumController extends MainController
{
	@FXML Menu albummenu;
	@FXML TilePane tile;
	
	public void init()
	{
		refreshThumbnail();
		refreshMenu();
	}
	
	public void doAdd()
	{
		FileChooser fc = new FileChooser();
        fc.setTitle("Open Photo");
		FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		fc.getExtensionFilters().add(imageFilter);
		
        File file = fc.showOpenDialog(new Stage());
        
        if (file != null)
        {
//        	Photo photo = new Photo(file);
//        	model.getCurrentUser().getCurrentAlbum().addPhoto(photo);
//        	BorderPane wrapper = photo.getThumbnail(this);
//        	tile.getChildren().add(wrapper);
        }
	}

	public void refreshMenu()
	{
		albummenu.getItems().clear();
		for (Album album : model.getCurrentUser().getAlbums())
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
	
	public void refreshThumbnail()
	{		
		tile.getChildren().clear();
		for (Photo photo : model.getCurrentUser().getCurrentAlbum().getPhotos())
		{
			BorderPane wrapper = photo.getThumbnail();
			tile.getChildren().add(wrapper);
		}
	}
}
