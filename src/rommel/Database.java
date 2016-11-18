package rommel;
import java.io.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
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
		String str = "INSERT INTO students(firstname, lastname, studentnumber, timestamp) VALUES(?, ?, ?,?)"; 
		try {
			PreparedStatement st = db.prepareStatement(str);
			st.setString(1, FirstName);
			st.setString(2,  LastName);
			st.setInt(3,StudentNumber);
			ZonedDateTime zdt = ZonedDateTime.now();
			java.util.Date date = java.util.Date.from( zdt.toInstant() );
			long time  = date.getTime();
			System.out.println(Long.toString(time));
			st.setTimestamp(4, new Timestamp(time));
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void insertVisitor(String FirstName, String LastName, String MiddleName, String Purpose, String Organization, String Office){
		String str = "INSERT INTO visitors(firstname,lastname,middlename,purpose,organization,office,timestamp) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = db.prepareStatement(str);
			st.setString(1,FirstName);
			st.setString(2,LastName);
			st.setString(3,MiddleName);
			st.setString(4,Purpose);
			st.setString(5,Organization);
			st.setString(6,Office);
			
			ZonedDateTime zdt = ZonedDateTime.now();
			java.util.Date date = java.util.Date.from( zdt.toInstant() );
			long time  = date.getTime();
			System.out.println(Long.toString(time));
			st.setTimestamp(7, new Timestamp(time));

			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertStudentPicture() throws SQLException, IOException{
		File file = new File("0.jpg");
	    FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    PreparedStatement ps = db.prepareStatement("UPDATE Students set image = ? WHERE image IS NULL");
	    ps.setBinaryStream(1, fis, file.length());
	    ps.executeUpdate();
	    ps.close();
	    fis.close();
	    
	    
		
		
	}
	
	public void insertVisitorPicture() throws SQLException, IOException{
		File file = new File("0.jpg");
	    FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    PreparedStatement ps = db.prepareStatement("UPDATE Visitors SET image = ? WHERE image IS NULL");
	    ps.setBinaryStream(1, fis, file.length());
	    ps.executeUpdate();
	    ps.close();
	    fis.close();
	}
}
