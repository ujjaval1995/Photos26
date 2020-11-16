package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import photos.model.*;

public class HomeController extends MainController
{
	@FXML TableView<Album> table;
	@FXML TableColumn<Album, String> name_col;
	@FXML TableColumn<Album, Integer> photos_col;
	@FXML TableColumn<Album, String> start_col;
	@FXML TableColumn<Album, String> end_col;
	
	@FXML TextField albumfield;
	
	@FXML DatePicker fromdate;
	@FXML DatePicker todate;
	
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
