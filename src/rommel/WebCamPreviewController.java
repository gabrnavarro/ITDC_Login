package rommel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class WebCamPreviewController implements Initializable {

	
	@FXML
	AnchorPane WebcamPanelHolder;

	@FXML
	ImageView imgWebCamCapturedImage;
	
	//Initialize webcam stream
	Webcam webcam = Webcam.getDefault();
	WebcamPanel campanel = new WebcamPanel(webcam,false);
	SwingNode swingNode = new SwingNode();

	public void startCountdown(){
		Thread r = new Thread(){
		@Override
		public void run(){
			try{
			int n = 0;
			 try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            throw new RuntimeException(e);
		        }
		    BufferedImage image = webcam.getImage();
		    ImageIO.write(image, "JPG", new File(n + ".jpg"));
		    //IMAGE QUERY
		    
		    
		    campanel.pause();
		    Thread.sleep(1000);
		       
		    
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				Parent root = FXMLLoader.load(getClass().getResource("frame.fxml"));
				Stage stage;
				stage=(Stage) WebcamPanelHolder.getScene().getWindow();
				stage.getScene().setRoot(root);
				stage.setFullScreen(true);
				stage.show();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		r.setDaemon(true);
		r.start();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		campanel.setFPSDisplayed(true);
		campanel.setDisplayDebugInfo(true);
		campanel.setImageSizeDisplayed(true);
		campanel.setFillArea(true);
		swingNode.setContent(campanel);
		WebcamPanelHolder.getChildren().add(swingNode);
		AnchorPane.setTopAnchor(swingNode,1.0);
		AnchorPane.setBottomAnchor(swingNode,1.0);
		AnchorPane.setRightAnchor(swingNode,1.0);
		AnchorPane.setLeftAnchor(swingNode,1.0);
		webcam.open();
		campanel.start();
		startCountdown();
		//switchBack();
	}

	
}