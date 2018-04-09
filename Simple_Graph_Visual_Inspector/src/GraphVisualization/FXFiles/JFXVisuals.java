package GraphVisualization.FXFiles;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class JFXVisuals extends Application {
  
  /** True if this GUI is the one that is being used. */
  private static boolean hasStarted = false;
  
  private static MainWindowController controller;
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) throws Exception {

//    Group root = new Group();
    //Tell javafx to use the main_window.fxml file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("main_window.fxml"));
    loader.setClassLoader(getClass().getClassLoader());
    Parent root = loader.load();
  
    controller = loader.getController();
  
    stage.setTitle("Visual Matrix");
    stage.setResizable(false);
    stage.show();
  
    hasStarted = true;
  
    stage.setScene(new Scene(root,Color.BLACK));
    
    stage.show();
  }
}
