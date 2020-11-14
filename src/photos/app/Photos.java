package photos.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
		
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/Photos/view/Login.fxml"));
//		Parent root = loader.load();
//		sceneLogin = new Scene(root);
//		controllerLogin = loader.getController();
//		
//		
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/Photos/view/Admin.fxml"));
//		Parent root = loader.load();
//		sceneAdmin = new Scene(root);
//		controllerAdmin = loader.getController();
//	
//	
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/Photos/view/User.fxml"));
//		Parent root = loader.load();
//		sceneUser = new Scene(root);
//		controllerUser = loader.getController();
//	
//	
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("/Photos/view/Album.fxml"));
//		Parent root = loader.load();
//		sceneAlbum = new Scene(root);
//		controllerAlbum = loader.getController();
	
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
