package projet.view.maps;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.converter.IntegerStringConverter;
import projet.data.Equipe;

public class ControllerMaps {
	
	@FXML
    private WebView webView;
	@FXML
	private Button addMarker;
	
	@FXML
	private void initialize() {

		// Data binding
		WebEngine webEngine = webView.getEngine();
        webEngine.load( getClass().getResource("maps.html").toString() );
		
        String param = "document.addMarker(\"test2\",45.818971, 1.272345)";
        addMarker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                webEngine.executeScript(param);
            }
        });
		
	}
	 
}
