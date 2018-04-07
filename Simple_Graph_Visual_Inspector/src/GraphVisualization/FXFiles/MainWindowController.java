package GraphVisualization.FXFiles;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;

public class MainWindowController {
  
  
  @FXML private MenuItem resetBoard;
  @FXML private MenuItem exit;
  
  @FXML private Text outputCountOfContOnes;
  
  @FXML private Text shortestCompletePathLen;
  // labels for the width of the board
  @FXML private Text textBoardWidth;
  @FXML private Text textBoardHeight;
  

  
  @FXML private GridPane board;
  
  public static final double MAX_WIDTH = Screen.getPrimary().getBounds().getWidth();
  public static final double MAX_HEIGHT = Screen.getPrimary().getBounds().getHeight();
  public static final int TILE_EDGE_LEN = 10;
  
  
  /** The board is this many tiles accross */
  private int boardWidth = 15;
  
  /** The board is this many tiles high */
  private int boardHeight = 15;
  
  boolean setBoardWidth(int boardWidth) {
    if(boardWidth > 0 && boardWidth < (MAX_WIDTH / TILE_EDGE_LEN)) {
      this.boardWidth = boardWidth;
      return true;
    }else return false;
  }
  
  boolean setBoardHeight(int boardHeight) {
    if(boardHeight > 0 && boardHeight < (MAX_HEIGHT / TILE_EDGE_LEN)) {
      this.boardHeight = boardHeight;
      return true;
    }else return false;
  }
  /**
   * Handles keyboard input (in case we ever want to add keyboard shortcuts).
   */
  @FXML
  public void handleKeyboardInput(InputEvent event) {
  
  }
  
  /**
   * This method gets called when the user chooses to exit via the file menu or by pressing Alt-F4
   */
  @FXML
  public void exit(ActionEvent event) {
    Platform.exit();
  }
  
  /**
   * This method gets called when someone either selects "reset board" in the file menu, or presses ctrl+r.
   */
  @FXML
  public void resetBoard(ActionEvent event) {
  
  }
  
  /**
   * Called when the GUI is created. If we need to do something special to anything in the GUI, we do it in here.
   */
  @FXML
  public void initialize() {
    outputCountOfContOnes = new Text("0");
    outputCountOfContOnes.setTextAlignment(TextAlignment.LEFT);
    outputCountOfContOnes.setFont(new Font(20));
    shortestCompletePathLen = new Text(String.valueOf(boardWidth*boardHeight));
    shortestCompletePathLen.setTextAlignment(TextAlignment.LEFT);
    shortestCompletePathLen.setFont(new Font(20));
    board = new GridPane();
    board.setGridLinesVisible(true);
    //Gives the "reset board" menu option the shortcut of ctrl+r
    resetBoard.setAccelerator(new KeyCodeCombination(KeyCode.R,  KeyCombination.CONTROL_DOWN));
    exit.setAccelerator(new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN));
    int[][] localTestMatrix = TheStaticDefaults.the3x4DefaultMatrix;
    setBoardHeight(TheStaticDefaults.get3x4Width());
    setBoardWidth(TheStaticDefaults.get3x4Height());
    for (int row = 0; row < boardWidth; row++) {
      for (int col = 0; col < boardHeight; col++) {
        FXMatrixElement fxm = new FXMatrixElement(localTestMatrix[row][col]);
        board.add(fxm,row,col);
      }
    }
    
    textBoardWidth = new Text();
    textBoardWidth.setText(String.valueOf(boardWidth));
    
    textBoardHeight = new Text();
    textBoardHeight.setText(String.valueOf(boardHeight));
    
    board.setHgap(1);
    board.setVgap(1);
    board.setGridLinesVisible(true);
    board.setMaxWidth(FXMatrixElement.getEdgeLen()* boardWidth);
    board.setMaxHeight(FXMatrixElement.getEdgeLen() * boardHeight);
    
    board.setBorder(new Border(new BorderStroke(Color.LIGHTGREY,
                                   BorderStrokeStyle.SOLID,
                                   CornerRadii.EMPTY, new BorderWidths(1))));
  }
}
