package photos.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import photos.model.Model;

public class MainController
{
	public static Model model;
	
	public static Stage stage;
	
//	public static Stage login_stage;
//	public static Stage admin_stage;
//	public static Stage home_stage;
//	public static Stage album_stage;
//	public static Stage photo_stage;
	
	public static Scene login_scene;
	public static Scene admin_scene;
	public static Scene home_scene;
	public static Scene album_scene;
	public static Scene photo_scene;
	
//	public static Ctrl login_ctrl;
//	public static Ctrl admin_ctrl;
//	public static Ctrl home_ctrl;
//	public static Ctrl album_ctrl;
//	public static Ctrl photo_ctrl;
	
	public static LoginController login_ctrl;
	public static AdminController admin_ctrl;
	public static HomeController home_ctrl;
	public static AlbumController album_ctrl;
	public static PhotoController photo_ctrl;
	
	public static void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader;
		Parent root;
		
		loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("/photos/view/login.fxml"));
		root = loader.load();
		login_scene = new Scene(root);
		login_ctrl = loader.getController();
		
		loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("/photos/view/admin.fxml"));
		root = loader.load();
		admin_scene = new Scene(root);
		admin_ctrl = loader.getController();
		
		loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("/photos/view/home.fxml"));
		root = loader.load();
		home_scene = new Scene(root);
		home_ctrl = loader.getController();
		
		loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("/photos/view/album.fxml"));
		root = loader.load();
		album_scene = new Scene(root);
		album_ctrl = loader.getController();
		
		loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("/photos/view/photo.fxml"));
		root = loader.load();
		photo_scene = new Scene(root);
		photo_ctrl = loader.getController();
		
		stage = primaryStage;
		
		stage.setScene(login_scene);
		stage.setTitle("Welcome To Photos!");
		stage.show();
		
		model = new Model();
	}
	
	public static void toLogin()
	{
		login_ctrl.init();
		stage.setScene(login_scene);
		stage.setTitle("Welcome To Photos!");
	}

	public static void toAdmin()
	{
		admin_ctrl.init();
		stage.setScene(admin_scene);
		stage.setTitle("Admin Subsystem");
	}

	public static void toHome()
	{
		home_ctrl.init();
		stage.setScene(home_scene);
		stage.setTitle("Welcome " + model.getCurrentUser());
	}

	public static void toPhoto()
	{
		photo_ctrl.init();
		stage.setScene(photo_scene);
		stage.setTitle("Album " + model.getCurrentUser().getCurrentAlbum());
	}

	public static void toAlbum()
	{
		album_ctrl.init();
		stage.setScene(album_scene);
		stage.setTitle("Album " + model.getCurrentUser().getCurrentAlbum());
	}
	
	public void doHome()
	{
		toHome();
	}

	public void doLogout()
	{
		toLogin();
	}
	
	public void doExit()
	{
		Platform.exit();
	}
	
	public void doAbout()
	{
		// complete
	}
}
