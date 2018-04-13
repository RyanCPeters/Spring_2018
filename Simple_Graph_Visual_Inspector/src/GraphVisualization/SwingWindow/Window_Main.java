package GraphVisualization.SwingWindow;

import javax.swing.*;

public class Window_Main {
  
  public static void main(String[] args) {
    try {
      new RootFrame(RootFrame.KNOWN_FILES, 40 , 82);
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }
}
