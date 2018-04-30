package examples_references.issuetrackinglite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public
class AdaptedFXguiMain
  extends Application
{
  
  /**
   @param args
   the command line arguments
   */
  public static
  void main( String[] args ) {
    
    Application.launch( AdaptedFXguiMain.class, (java.lang.String[])null );
  }
  
  @Override
  public
  void start( Stage primaryStage ) {
    
    String possible_errMsg = "", resName = "IssueTrackingLite.fxml";
    try {
      VBox page = FXMLLoader.load( AdaptedFXguiMain.class.getResource( resName ) );
      Scene scene = new Scene( page );
      primaryStage.setScene( scene );
      primaryStage.setTitle( "Issue Tracking Lite Sample" );
      primaryStage.show();
    }catch( IOException ioe ) {
      
      possible_errMsg = "   |\n" +
                        "   '-> [-] IOException caused in\n" +
                        "           void start( Stage primaryStage ) \n" +
                        "\n" +
                        "           resName = " + resName +
                        "\nBegin stack trace \n" +
                        ioe.getMessage();
      
      Logger.getLogger( AdaptedFXguiMain.class.getName() ).log( Level.SEVERE, null, ioe );
      
    }catch( Exception e ) {
      
      possible_errMsg = "   |\n" +
                        "   '-> [-] Exception caused in\n" +
                        "           void start( Stage primaryStage ) \n" +
                        "\nBegin stack trace \n" +
                        e.getMessage();
    }
    if( possible_errMsg.length() > 1 ) throw new InternalError( "\n\n" +
                                                                "[-] Internal Logic Error inside\n" +
                                                                
                                                                "    AdaptedFXguiMain.start( " +
                                                                "Stage primaryStage )\n" +
                                                                possible_errMsg );
  } // end void start( Stage primaryStage)
}



