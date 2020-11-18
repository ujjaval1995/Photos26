package photos.controller;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import photos.model.*;

public class AlbumController extends MainController
{
	@FXML Menu albummenu;
	@FXML TilePane tile;
	
	final ContextMenu menu = new ContextMenu();
	
	public void initialize()
	{
		Menu copy = new Menu("Copy");
		Menu move = new Menu("Move");
		menu.getItems().add(copy);
		menu.getItems().add(move);
		
		MenuItem delete = new MenuItem("Delete");
    	delete.setOnAction(e ->
    	{
    		Object obj = e.getSource();
    		
    		System.out.println(obj);
    		
    		if (obj instanceof ImageView)
    		{
    			System.out.println("img");
    			
    			ImageView view = (ImageView) obj;
    			Object obj1 = view.getUserData();
            	Photo photo = (Photo) obj1;
            	User user = model.getCurrentUser();
                Album album = user.getCurrentAlbum();
                album.deletePhoto(photo);
                refreshThumbnails();
    		}
        });
    	menu.getItems().add(delete);
	}
	
	public void init()
	{
		refreshThumbnails();
		refreshMenu();
		refreshRightClickMenu();
	}
	
	public void doAdd()
	{
		FileChooser fc = new FileChooser();
        fc.setTitle("Open Photo");
		FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		fc.getExtensionFilters().add(imageFilter);
		
//        File file = fc.showOpenDialog(new Stage());
//        
//        if (file != null)
//        {
//        	Photo photo = new Photo(file.getAbsolutePath());
//        	model.getCurrentUser().getCurrentAlbum().addPhoto(photo);
//        	BorderPane wrapper = photo.getThumbnail(this);
//        	tile.getChildren().add(wrapper);
//        }
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
	
	public void refreshThumbnails()
	{		
		tile.getChildren().clear();
		for (Photo photo : model.getCurrentUser().getCurrentAlbum().getPhotos())
		{
			BorderPane wrapper = photo.getThumbnail(e -> menu.show((Node) e.getSource(), e.getScreenX(), e.getScreenY()));
			tile.getChildren().add(wrapper);
			wrapper.setOnContextMenuRequested(e -> menu.show(wrapper, e.getScreenX(), e.getScreenY()));
//			wrapper.setOnMouseClicked(event ->
//	        {
//	            if (event.getButton() == MouseButton.SECONDARY)
//	            {
//	                menu.show(wrapper, event.getScreenX(), event.getScreenY());
//	            }
//	        });
		}
	}
	
	public void refreshRightClickMenu()
	{
		
	}
}
