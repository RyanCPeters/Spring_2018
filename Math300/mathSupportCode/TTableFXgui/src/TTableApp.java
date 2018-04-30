
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public
class TTableApp
    extends Application
{
  
  public static
  void main( String[] args ) {
//  Application.launch(TTableApp.class);
//    Application.launch( TTableApp.class, (java.lang.String[])null );
    Application.launch( args );
  }
  
  @Override
  public
  void start( Stage primaryStage ) {
  
    String  possible_errMsg = "",
            resName = "guiElements/TTableFXML.fxml";
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation( getClass().getResource( "guiElements/TTableFXML.fxml" ) );
      Parent content = loader.load();
      
      Scene scene = new Scene( content );
      primaryStage.setScene( scene );
      primaryStage.setTitle( "Truth Table Generator 9000ZX++PLUS" );
      primaryStage.show();
    }catch( IOException ioe ) {
    
      possible_errMsg = "   |\n" +
                        "   '-> [-] IOException caused in\n" +
                        "           void start( Stage primaryStage ) \n" +
                        "\n" +
                        "           resName = " + resName +
                        "\nBegin stack trace" +
                        "\n" +
                        ioe.getMessage();
    
//      Logger.getLogger( TTableApp.class.getName() ).log( Level.SEVERE, null, ioe );
    
    }catch( Exception e ) {
    
      possible_errMsg = "    |\n" +
                        "    '-> [-] Exception caused in\n" +
                        "            void start( Stage primaryStage ) \n" +
                        "\n" +
                        "            Exception type: Can't tell... yeah, shucks..." +
                        "\nBegin stack trace \n" +
                        e.getMessage();
    }
    if( possible_errMsg.length() > 1 )
      throw new InternalError( "\n\n" +
                               "[-] Internal Logic Error inside\n" +
                               "    TTableApp.start( Stage primaryStage )\n" +
                               possible_errMsg );
  }
}
