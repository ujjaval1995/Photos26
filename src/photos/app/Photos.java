/**
* This class helps with Main Application.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.app;
import photos.model.*;

import javafx.application.Application;
import javafx.stage.Stage;
import photos.controller.MainController;

public class Photos extends Application
{	
	/**
	 * @param primaryStage Primary stage of application
	 * @throws Exception In case stage does not start
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		MainController.start(primaryStage);
	}
	/**
	 * @param args Input command line arguments
	 */
	public static void main(String[] args)
	{
	//	Album album1 = new Album();
	//	Model model1 = new Model();
	//	Photo photo1 = new Photo();
	//	Tag tag1=new Tag();
	//	User user1=new User();
		launch(args);
	//	writeAlbum(album1);
	//	writeModel(model1);
	//	writePhoto(photo1);
	//	writeTag(tag1);
	//	writeUser(user1);
		
	}
}
