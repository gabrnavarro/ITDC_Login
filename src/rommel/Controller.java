
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
		
		//DB TEST
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection db = null;

		try {
			String url = "jdbc:postgresql:login";
			String username = "postgres";
			String password = "postgresql";
			db = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (db != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		//TEST END
		
		
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
