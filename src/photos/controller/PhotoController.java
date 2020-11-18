/**
* This class helps with Photo Controller.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import photos.model.*;

public class PhotoController extends MainController
{
	@FXML Menu albummenu;
	@FXML Pagination pages;
	@FXML ListView<Tag> listview;
	@FXML TextField namefield;
	@FXML TextField valuefield;
	@FXML CheckBox singular;
	@FXML Button add;
	@FXML Button delete;
	
	public void init()
	{
		refreshMenu();
	}
	
	public void initialize()
	{
//		pages.setPageFactory(pageIndex ->
//		{
//	        Album album = model.getCurrentUser().getCurrentAlbum();
//	        
//	        if (album.getPhotoCount() > 0)
//	        {
//	            Photo photo = album.getCurrentPhoto();
//	            return photo.getPicture();
//	        }
//	        else
//	        {
//	            return null;
//	        }
//		});
	}
	
	
	public void doAddTag()
	{
		
	}
	
	public void doDeleteTag()
	{
		
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
