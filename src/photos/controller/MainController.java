/**
 * This class helps with Main Controller.
 * @author Jishnu Patel
 * @author Ujjaval Shah
 */
package photos.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import photos.model.*;

public class MainController
{
	public static Model model;
	
	public static Stage stage;
	
	public final static String Data_File_Path 	= "photo26.dat";
	public static Scene login_scene;
	public static Scene admin_scene;
	public static Scene home_scene;
	public static Scene album_scene;
	public static Scene photo_scene;
	
	public static LoginController login_ctrl;
	public static AdminController admin_ctrl;
	public static HomeController home_ctrl;
	public static AlbumController album_ctrl;
	public static PhotoController photo_ctrl;
	
	/**
     * Basic/Default Startup
     */
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
	
	/**
     * Method to get to Login Screen
     */
	public static void toLogin()
	{
		login_ctrl.init();
		stage.setScene(login_scene);
		stage.setTitle("Welcome To Photos!");
	}

	
	/**
     * Method to get to Admin Screen
     */
	public static void toAdmin()
	{
		admin_ctrl.init();
		stage.setScene(admin_scene);
		stage.setTitle("Admin Subsystem");
	}

	/**
     * Method to get to Home Screen
     */
	public static void toHome()
	{
		model.getCurrentUser().setCurrentAlbum((Album) null);
		home_ctrl.init();
		stage.setScene(home_scene);
		stage.setTitle("Welcome " + model.getCurrentUser());
	}

	/**
     * Method to get to Photo Screen
     */
	public static void toPhoto(Photo photo)
	{
		model.getCurrentUser().getCurrentAlbum().setCurrentPhoto(photo);
		photo_ctrl.init();
		stage.setScene(photo_scene);
		stage.setTitle("Album - " + model.getCurrentUser().getCurrentAlbum() + " (Photo View)");
	}
	
	public static void toAlbum(Album album)
	{
		model.getCurrentUser().setCurrentAlbum(album);
		model.getCurrentUser().getCurrentAlbum().setCurrentPhoto(null);
		album_ctrl.init();
		stage.setScene(album_scene);
		stage.setTitle("Album - " + model.getCurrentUser().getCurrentAlbum());
	}

	
	/**
     * Method to get to Album Screen
     */
	public static void toAlbum(String name)
	{
		model.getCurrentUser().setCurrentAlbum(model.getCurrentUser().getAlbum(name));
		model.getCurrentUser().getCurrentAlbum().setCurrentPhoto(null);
		album_ctrl.init();
		stage.setScene(album_scene);
		stage.setTitle("Album - " + model.getCurrentUser().getCurrentAlbum());
	}
	
	/**
     * Method to get Model
     */
	public static Model getModel() {
        if (model == null) {
            try {
                FileInputStream fileIn = new FileInputStream(Data_File_Path);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                model = (Model)in.readObject();
                in.close();
                fileIn.close();
            }
            catch(IOException | ClassNotFoundException i) {
                model = null;
                //i.printStackTrace();
            }
         
        }    //
        return model;
    
	}


    /**
     * Helps store the Model to file
     */
    public static void storeModelToFile() {
		 if (model!=null) {
	         try {
	            FileOutputStream fileOut = new FileOutputStream(Data_File_Path);
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(model);
	            out.close();
	            fileOut.close();
	         }
	         catch (IOException i) {
	             i.printStackTrace();
	         }
		 }
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
	
	public void About(String fml)
	{
		Parent root;
		try {
			root = FXMLLoader.load(MainController.class.getResource(fml));
		
	    	Stage window = new Stage();
	    
	    	window.initModality(Modality.APPLICATION_MODAL);
		
			Scene scene = new Scene(root);
			window.setScene(scene);
			
			window.setTitle("Help");
			window.setResizable(false);
			
			window.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
		// complete
}
