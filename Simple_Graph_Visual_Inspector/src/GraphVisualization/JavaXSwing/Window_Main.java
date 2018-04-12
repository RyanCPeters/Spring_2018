package GraphVisualization.JavaXSwing;

import javax.swing.*;

public class Window_Main {
  
  public static void main(String[] args) {
  
    RootFrame rf;
  
    try {
      rf = new RootFrame(RootFrame.KNOWN_FILES, 40 , 82);
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

//    for (String name :
//        RootFrame.KNOWN_FILES) {
//       rf = new RootFrame(name, false );
//      System.out.println();
//    }
  }
}
