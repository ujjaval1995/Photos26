/**
 * This class helps with Home View.
 * @author Jishnu Patel
 * @author Ujjaval Shah
 */
package photos.controller;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import photos.model.*;

public class HomeController extends MainController
{
	@FXML TableView<Album> table;
	@FXML TableColumn<Album, String> name_col;
	@FXML TableColumn<Album, Integer> photos_col;
	@FXML TableColumn<Album, LocalDate> start_col;
	@FXML TableColumn<Album, LocalDate> end_col;
	
	@FXML TextField namefield;
	@FXML Button add;
	@FXML Button delete;
	
	@FXML DatePicker fromdate;
	@FXML DatePicker todate;
	@FXML Button searchbydate;

	@FXML TextField name1field;
	@FXML TextField name2field; 
	@FXML TextField value1field;
	@FXML TextField value2field;
	@FXML ToggleGroup group;
	@FXML RadioButton single;
	@FXML RadioButton and;
	@FXML RadioButton or;
	@FXML CheckBox createablum;
	@FXML Button searchbytag;
	
	@FXML Menu albummenu;
	
	public void initialize()
	{
		name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
		photos_col.setCellValueFactory(new PropertyValueFactory<>("photoCount"));
		start_col.setCellValueFactory(new PropertyValueFactory<>("startDate"));
		end_col.setCellValueFactory(new PropertyValueFactory<>("endDate"));
		
		table.setEditable(true);
		name_col.setCellFactory(TextFieldTableCell.forTableColumn());
		name_col.setOnEditCommit(
            new EventHandler<CellEditEvent<Album, String>>()
            {
                @Override
                public void handle(CellEditEvent<Album, String> namecell)
                {
                	ObservableList<Album> albums = model.getCurrentUser().getAlbums();
                	String name = namecell.getNewValue().trim();
            		
            		if (name.length() > 0 && !albums.contains(new Album(name)))
            		{
            			table.getSelectionModel().getSelectedItem().setName(name);
            		}
        			table.refresh();
                }
            }
        );
		
		table.setOnMouseClicked(event ->
		{
			if (!event.getButton().equals(MouseButton.PRIMARY) || event.getClickCount() != 1)
			{
				if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
				{
					model.getCurrentUser().setCurrentAlbum(table.getSelectionModel().getSelectedItem());
                    toAlbum(table.getSelectionModel().getSelectedItem().getName());
                }
			}
		});
	}
	/**
     * Initializes Home Scene
     */
	public void init()
	{
		namefield.clear();
		value1field.clear();
		value2field.clear();
		single.setSelected(true);
		
		ObservableList<Album> albums = model.getCurrentUser().getAlbums();
		table.setItems(albums);
		if (model.getCurrentUser().getAlbums().size() > 0)
		{
        	table.getSelectionModel().select(0);
        }
		refreshMenu();
		table.refresh();
	}
	/**
     * Adds an Album
     */
	public void doAdd()
	{
		ObservableList<Album> albums = model.getCurrentUser().getAlbums();
		String name = namefield.getText().trim();
		Album album = new Album(name);
		
		if (name.length() != 0)
		{
			if (albums.contains(album))
			{
				Alert error = new Alert(AlertType.ERROR, "Album already exists");
				error.showAndWait();
			}
			else
			{
				if (albums.isEmpty())
		    	{
		            albums.add(album);
		            table.setItems(albums);
		            table.getSelectionModel().select(0);
		    	}
				else
				{
					int i = 0;
		    		for (; i < albums.size(); i++)
			    	{	    		
			            if (album.compareTo(albums.get(i)) < 0)
			            {
			                break;
			            }
			    	}
		    		albums.add(i, album);
			        table.setItems(albums);
			        table.getSelectionModel().select(album);
				}
			}
		}
		namefield.clear();
		refreshMenu();
	}
	/**
     * Deletes an Album
     */
	public void doDelete()
	{
		ObservableList<Album> albums = model.getCurrentUser().getAlbums();
		Album album = table.getSelectionModel().getSelectedItem();
		albums.remove(album);
		table.setItems(albums);
		refreshMenu();
	}
	/**
     * Refreshes Menu
     */
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
