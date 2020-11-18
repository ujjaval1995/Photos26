package photos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import photos.model.*;

public class AlbumController extends MainController
{
	@FXML Menu albummenu;
	@FXML TilePane tile;
	
	public void initialize()
	{
		//tile = new TilePane();
	}
	
	public void init()
	{
		// DEBUG THIS ---------------------------------------------------------
		
		// i am trying to display 001.png in the tilepane
		
		if (model.getCurrentUser().getCurrentAlbum().getPhotoCount() > 0)
		{
			try
			{
		        Image image = new Image(new FileInputStream("data/001.png"));
		        ImageView view = new ImageView(image);
		        view.setImage(image);
		        view.setFitWidth(400);
		        view.setFitHeight(300);
		        
		        VBox vbox = new VBox(4);
		        vbox.getChildren().addAll(view);
		        BorderPane viewWrapper = new BorderPane(vbox);
		        
		       tile.getChildren().add(viewWrapper);
		       // tile.add(viewWrapper);
		    }
			catch (FileNotFoundException e)
			{
		        e.printStackTrace();
		    }
		}
		
		// --------------------------------------------------------------------
		
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
