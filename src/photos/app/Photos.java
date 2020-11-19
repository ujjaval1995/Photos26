/**
* This class helps with Main Application.
* @author Jishnu Patel
* @author Ujjaval Shah
*/
package photos.app;
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
	
		launch(args);
		
	}
	/**
	 * Store data to file upon program stop
	 */
	@Override
	public void stop(){
        MainController.storeModelToFile();
	}
}
