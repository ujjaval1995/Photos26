package photos.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import photos.controller.LoginController;

public class Photos extends Application
{	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/photos/view/login.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		LoginController login_ctrl = loader.getController();
		login_ctrl.start(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
