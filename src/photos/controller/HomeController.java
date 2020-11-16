package photos.controller;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import photos.model.*;

public class HomeController extends MainController
{
	@FXML TableView<Album> table;
	@FXML TableColumn<Album, String> name_col;
	@FXML TableColumn<Album, Integer> photos_col;
	@FXML TableColumn<Album, LocalDate> start_col;
	@FXML TableColumn<Album, LocalDate> end_col;
	
	@FXML TextField albumfield;
	@FXML Button add;
	
	@FXML DatePicker fromdate;
	@FXML DatePicker todate;
	@FXML Button searchbydate;

	// add key 1
	// add key 2
	@FXML TextField value1field;
	@FXML TextField value2field;
	@FXML ToggleGroup group;
	@FXML RadioButton single;
	@FXML RadioButton and;
	@FXML RadioButton or;
	@FXML CheckBox createablum;
	@FXML Button searchbytag;
	
	public void initialize()
	{
		name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
		photos_col.setCellValueFactory(new PropertyValueFactory<>("photo_count"));
		start_col.setCellValueFactory(new PropertyValueFactory<>("start_date"));
		end_col.setCellValueFactory(new PropertyValueFactory<>("end_date"));
		
		
	}
	
	public void init()
	{
		model.getCurrentUser().setCurrentAlbum(null);
		albumfield.clear();
		value1field.clear();
		value2field.clear();
		single.setSelected(true);
		
		ObservableList<Album> obs_albums = model.getCurrentUser().getObsAlbums();
		table.setItems(obs_albums);
		if (model.getCurrentUser().getAlbums().size() > 0)
		{
        	table.getSelectionModel().select(0);
        }
	}
	
	public void doAdd()
	{
		ObservableList<Album> obs_albums = model.getCurrentUser().getObsAlbums();
		
		table.setItems(obs_albums);
		
	}
	
	public void doAbout()
	{
		// complete
	}
}
