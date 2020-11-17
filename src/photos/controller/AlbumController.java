package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import photos.model.Album;

public class AlbumController extends MainController
{
	@FXML Menu albummenu;
	
	public void init()
	{
		refreshMenu();
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
