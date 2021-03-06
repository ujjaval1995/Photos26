package photos.controller;

import java.io.File;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import photos.model.*;

public class AlbumController extends MainController implements EventHandler<MouseEvent>
{
	@FXML Menu albummenu;
	@FXML TilePane tile;
	 public static final String AlbumHelp = "/photos/view/AlbumHelp.fxml";
	
	final ContextMenu menu = new ContextMenu();
	Menu copy = new Menu("Copy");
	Menu move = new Menu("Move");
	MenuItem delete = new MenuItem("Delete");
	
	public void initialize()
	{
		delete.setOnAction(e ->
		{
            Photo photo = (Photo) menu.getUserData();
            Album album = model.getCurrentUser().getCurrentAlbum();
            album.deletePhoto(photo);
            refreshThumbnails();
        });
		menu.getItems().add(copy);
		menu.getItems().add(move);
    	menu.getItems().add(delete);
	}
	
	public void init()
	{
		refreshThumbnails();
		refreshMenu();
	}
	
	public void doAddPhoto()
	{
		FileChooser fc = new FileChooser();
        fc.setTitle("Open Photo");
		FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
		fc.getExtensionFilters().add(imageFilter);
		
        File file = fc.showOpenDialog(new Stage());
        
        if (file != null)
        {
        	Photo photo = new Photo(file.getAbsolutePath());
        	for (Photo p : model.getCurrentUser().getCurrentAlbum().getPhotos())
			{
					if (photo.getPath().equals(p.getPath()) )
					{
						Alert error = new Alert(AlertType.ERROR, "Path Already Exists");
						error.showAndWait();
						return;
						
					}
				}
        	model.getCurrentUser().getCurrentAlbum().addPhoto(photo);
        	BorderPane wrapper = photo.getThumbnail(this);
        	tile.getChildren().add(wrapper);
        }
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
            	
            	model.getCurrentUser().getCurrentAlbum().setCurrentPhoto(photo);
            	toPhoto(photo);
	        }
			else if (event.getButton() == MouseButton.SECONDARY)
			{
				Object obj1 = view.getUserData();
				Photo photo = (Photo) obj1;
            	
            	copy.getItems().clear();
            	for (Album a : model.getCurrentUser().getAlbums())
            	{
            		if (!a.equals(model.getCurrentUser().getCurrentAlbum()))
            		{
            			MenuItem item = new MenuItem(a.getName());
	                	item.setOnAction(e ->
	                	{
	                        MenuItem item1 = (MenuItem) e.getSource();
	                       // Photo photo1 = (Photo) menu.getUserData();
	                        Album target = model.getCurrentUser().getAlbum(item1.getText());
	                        for (Photo p : target.getPhotos())
	            			{
	            					if (photo.getPath().equals(p.getPath()) )
	            					{
	            						Alert error = new Alert(AlertType.ERROR, "Path Already Exists");
	            						error.showAndWait();
	            						return;
	            						
	            					}
	            				}
	                        target.addPhoto((Photo) menu.getUserData());
	                    });
	                	copy.getItems().add(item);
            		}
            	}
            	
            	move.getItems().clear();
            	for (Album a : model.getCurrentUser().getAlbums())
            	{
            		if (!a.equals(model.getCurrentUser().getCurrentAlbum()))
            		{
            			MenuItem item = new MenuItem(a.getName());
	                	item.setOnAction(e ->
	                	{
	                        MenuItem item1 = (MenuItem) e.getSource();
	                     //   Photo photo1 = (Photo) menu.getUserData();
	                        Album target = model.getCurrentUser().getAlbum(item1.getText());
	                        
	                        for (Photo p : target.getPhotos())
	            			{
	            					if (photo.getPath().equals(p.getPath()) )
	            					{
	            						Alert error = new Alert(AlertType.ERROR, "Path Already Exists");
	            						error.showAndWait();
	            						return;
	            						
	            					}
	            				}
	                        target.addPhoto((Photo) menu.getUserData());
	                        model.getCurrentUser().getCurrentAlbum().deletePhoto((Photo) menu.getUserData());
	                        refreshThumbnails();
	                    });
	                	move.getItems().add(item);
            		}
            	}
            	
				menu.setUserData(photo);
	        	menu.show(view, event.getScreenX(), event.getScreenY());
	        }
	        event.consume();
		}
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
			BorderPane wrapper = photo.getThumbnail(this);
			tile.getChildren().add(wrapper);
		}
	}
	public void doAbout()
	{
		About(AlbumHelp);
	}
}
