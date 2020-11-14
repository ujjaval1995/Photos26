package photos.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Photos extends Application
{
	private static BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{		
		Parent main = FXMLLoader.load(getClass().getResource("/photos/view/main.fxml"));
		AnchorPane login = FXMLLoader.load(getClass().getResource("/photos/view/login.fxml"));
		
		root.setTop(main);
	    root.setCenter(login);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(root, 900, 625));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static BorderPane getRoot()
	{
	    return root;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
