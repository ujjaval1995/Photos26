package photos.controller;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import photos.model.Album;

public class AlbumController extends MainController
{
	@FXML Menu albummenu;
	
	public void init()
	{
		refreshMenu();
	}
	
	public void addPhotoFile()
	{
		FileChooser fc = new FileChooser();
        fc.setTitle("Open Photo");
		FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		fc.getExtensionFilters().add(imageFilter);
		
        File file = fc.showOpenDialog(new Stage());
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
}
