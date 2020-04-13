package projet.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfox.javafx.view.IConfigDialog;


public class ConfigDialog implements IConfigDialog {


	// Actions

	@Override
	public void configureStage( Stage stage ) {
		
		// Configure le stage
		stage.sizeToScene();
		stage.setResizable( false );
		
	}


	@Override
	public Scene createScene( Parent root ) {
		Scene scene = new Scene( root );
		scene.getStylesheets().add( this.getClass().getResource("application.css").toExternalForm() );
		return scene;
	}

}
