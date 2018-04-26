/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package issuetrackinglite;

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
    
    String possible_errMsg = "",resName = "IssueTrackingLite.fxml";
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
                        "           resName = " + resName+
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
    if(possible_errMsg.length() > 1)throw new InternalError( "\n\n" +
                                                             "[-] Internal Logic Error inside\n" +
                                                             "    AdaptedFXguiMain.start( Stage primaryStage )\n" + possible_errMsg );
  }
}


