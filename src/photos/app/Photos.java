package photos.app;

import javafx.application.Application;
import javafx.stage.Stage;
import photos.controller.MainController;

public class Photos extends Application
{	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		MainController.start(primaryStage);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
