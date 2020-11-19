/**
 * This class helps with Login View.
 * @author Jishnu Patel
 * @author Ujjaval Shah
 */
package photos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import photos.model.*;

public class LoginController extends MainController
{
	
	/**
     * TextField for username
     */
	@FXML TextField namefield;
	
	
	@FXML Text message;
	
	/**
     * Button to login
     */
	@FXML Button login;
	
	 public static final String LoginHelp = "/photos/view/LoginHelp.fxml";

	/**
     * Initializes Login Scene
     */
	public void init()
	{
		model.setCurrentUser(null);
		namefield.clear();
		message.setText("");
	}
	
	/**
     * Logs in
     */
	public void doLogin()
	{
		String name = namefield.getText().trim();
		
		if (name.equals(Model.ADMIN))
		{
			toAdmin();
		}
		else
		{
			User user = new User(name);
			if (model.getUsers().contains(user))
			{
				model.setCurrentUser(name);
				toHome();
			}
			else
			{
				message.setText("Invalid username");
				namefield.clear();
			}
		}
	}
	
	public void doAbout()
	{
		About(LoginHelp);
	}
}
