package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import photos.model.*;

public class HomeController extends MainController
{
	@FXML TableView<Album> table;
	@FXML TableColumn<Album, String> name_col;
	@FXML TableColumn<Album, Integer> photos_col;
	@FXML TableColumn<Album, String> start_col;
	@FXML TableColumn<Album, String> end_col;
	
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
	
	public void init()
	{
		
	}
	
	public void doAdd()
	{
		
	}
	
	public void doAbout()
	{
		// complete
	}
}
