/*
 * Class: CMSC203 CRN 46519
 * Instructor: Farnaz Eivazi
 * Description: Encrypts and Decrypts a phrase using Caesar Cipher and Bellaso Cipher
 * Due: 7/14/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Philip Song
*/



import java.io.IOException;




import javafx.application.Application;
//import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws Exception {
		//call the main scene which is a BorderPane
		FXMainPane root = new FXMainPane();
        stage.setScene(new Scene(root, 600, 400));
		// Set stage title and show the stage.
		stage.setTitle("Cybersecurity Encryption and Decryption");
		stage.show();

	}
}
