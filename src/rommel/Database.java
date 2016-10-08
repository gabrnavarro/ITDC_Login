package rommel;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
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

public class Database {
	public Connection db = null;
	
	public void initialize(){
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
	}
	
	public void insertStudent(String FirstName, String LastName, int StudentNumber ){
		String str = "INSERT INTO students VALUES(?, ?, ?)"; 
		try {
			PreparedStatement st = db.prepareStatement(str);
			st.setString(1, FirstName);
			st.setString(2,  LastName);
			st.setInt(3,StudentNumber);
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertVisitor(String FirstName, String LastName, String MiddleName, String Purpose, String Organization, String Office){
		String str = "INSERT INTO visitors VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = db.prepareStatement(str);
			st.setString(1,FirstName);
			st.setString(2,LastName);
			st.setString(3,MiddleName);
			st.setString(4,Purpose);
			st.setString(5,Organization);
			st.setString(6,Office);

			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
