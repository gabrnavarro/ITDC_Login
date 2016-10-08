//comment niyo changes
//also don't commit if may error :)
package rommel;

import javafx.application.Application;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;public class Main extends Application {

    public static void main(String[] args) {
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
		Connection connection = null;

		try {
			String url = "jdbc:postgresql:login";
			String username = "postgres";
			String password = "postgresql";
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("frame.fxml"));
        Image applicationIcon = new Image(getClass().getResourceAsStream("logo.jpg"));
        primaryStage.getIcons().add(applicationIcon);

        primaryStage.setTitle("LogApp");
        primaryStage.setScene(new Scene(root, 700, 750));
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }


}