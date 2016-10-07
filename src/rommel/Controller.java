
package rommel;

import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Controller {
	@FXML
	public Button setAt1;
	@FXML
	public Button setAt2;
	@FXML
	public void loadSecond(ActionEvent event) throws IOException{
		Stage stage;
		Parent root;
		stage=(Stage) setAt2.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("WebCamPreview.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
		
	}
	@FXML
	public void buttonClicked(){
		System.out.println("Stop it.");
	}
	ObservableList<String> officeToVisitList=FXCollections.observableArrayList("ITDC","DCS","OUR");
	@FXML
	private ChoiceBox<String> visitBox;
	
	public void setClicked(){
		System.out.print("Hello");
	}
	public void initialize() {
		// TODO Auto-generated method stub
		visitBox.setValue("ITDC");
		visitBox.setItems(officeToVisitList);
		
	}
}
