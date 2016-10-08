//comment niyo changes
//also don't commit if may error :)
package rommel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;public class Main extends Application {

    public static void main(String[] args) {		
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