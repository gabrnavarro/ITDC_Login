package rommel;

import com.github.sarxos.webcam.Webcam;
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
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Controller {
	Webcam webcam = Webcam.getDefault();
	@FXML 
	public TextField XFirstName;
	@FXML 
	public TextField XLastName;
	@FXML 
	public TextField XStudentNumber;
	@FXML
	public TextField FirstName, LastName, MiddleName, Purpose, Organization;
	@FXML
	public Button setAt1;
	@FXML
	public Button setAt2;
	@FXML
	public void loadSecond(ActionEvent event) throws IOException{

		Stage stage=(Stage) setAt2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("WebCamPreview.fxml"));
		
		//DB initialize
		
		Database DBManager = new Database();
		DBManager.initialize();
		//END
		System.out.println(XFirstName.getText());
		//INSERT QUERY (no pics)
		String result = XStudentNumber.getText().replaceAll("[-+.^:,]","");
		DBManager.insertStudent(XFirstName.getText(), XLastName.getText(), Integer.parseInt(result));
		
		
		stage.getScene().setRoot(root);
		stage.setFullScreen(true);
		stage.show();
		
	}
	@FXML
	public void buttonClicked(){
		System.out.println("Stop it.");
	}
	ObservableList<String> officeToVisitList=FXCollections.observableArrayList("ITDC","DCS","OUR");
	@FXML
	private ChoiceBox<String> visitBox;
	
	public void loadThird() throws IOException{
		Database DBManager = new Database();
		DBManager.initialize();
		System.out.println(FirstName.getText() + LastName.getText()+ MiddleName.getText()+ Purpose.getText()+ Organization.getText()+ "sampleoffice");
		DBManager.insertVisitor(FirstName.getText(), LastName.getText(), MiddleName.getText(), Purpose.getText(), Organization.getText(), visitBox.getValue());
		System.out.println("correct");
		
		Stage stage=(Stage) setAt2.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("WebCamPreview_visitor.fxml"));
		
		stage.getScene().setRoot(root);
		stage.setFullScreen(true);
		stage.show();
	}
	
	public void setClicked(){
		System.out.print("Hello");
	}
	public void initialize() {
		// TODO Auto-generated method stub
		visitBox.setValue("ITDC");
		visitBox.setItems(officeToVisitList);
		webcam.close();
		
	}
}
