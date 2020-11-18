package photos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
	
	public void init()
	{
		// DEBUG THIS ---------------------------------------------------------
		
		ObservableList<Node> obslist = tile.getChildren();
		
		if (model.getCurrentUser().getCurrentAlbum().getPhotoCount() > 0)
		{
			for (int i=0; i<20; i++)
			{
				try
				{
			        Image image = new Image(new FileInputStream("data/001.png"));
			        ImageView view = new ImageView(image);
			        view.setImage(image);
			        view.setFitWidth(120);
			        view.setFitHeight(80);
			        //obslist.add(new Photo("data/001.png").getNode());
			        
			        tile.getChildren().add(view);
			        
			    }
				catch (FileNotFoundException e)
				{
			        e.printStackTrace();
			    }
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
