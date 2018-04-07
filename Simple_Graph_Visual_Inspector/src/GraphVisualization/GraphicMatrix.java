package GraphVisualization;

import GraphVisualization.ConsoleFiles.ConsolColor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The GraphicMatrix class will create a window and populate it with a binary
 * matrix, assign colors such that each distinct cluster of contiguous ones
 * has a relatively distinct color assigned to it.
 *
 *    -- this color shall only need to be distinct relative to the other
 *       clusters of contiguous ones surrounding it
 *
 * Any zeros in the matrix will be colored black and shall then serve as a
 * maze path which this class shall then manipulate so as to assure there
 * exists at least 1 continuous path of zeros from the top left corner of the
 * matrix to the bottom right corner.
 */
public class GraphicMatrix extends JFrame{
  private String[][] mappedMatrix;
  private ArrayList<Colorizer> colorTeam;
  private ArrayList<Mapper> mapTeam;
  
  
  public GraphicMatrix(String title, String[][] mappedMatrix)
      throws HeadlessException {
    super(title);
    this.mappedMatrix = mappedMatrix;
    Colorizer first = new Colorizer(
        ConsolColor.grn_bg_brt + ConsolColor.blk,
                                     new int[]{0,0});
    colorTeam = new ArrayList<>(1);
  }
  
  /**
   * Mappers will traverse the contiguous zeros, starting in the top left
   * corner of the matrix. At each zero's index, the mapper will record the
   * number of adjacent zeros to that index; this then represents the number
   * of viable path options for each possible path space on the matrix.
   */
  private class Mapper {
    public int[] currentLoc;
    public String iconColor;
  
    public Mapper(int[] currentLoc) {
      this.currentLoc = currentLoc;
      iconColor = ConsolColor.blk_bg_brt;
    }
  }
  
  
  /**
   * Colorizers will traverse the matrix and identify all of the contiguous sets
   * of ones therein.
   *
   * The intent is to allow for multiple Colorizers to conduct the traversal in
   * parallel, which requires the use of strategies for allowing concurrent
   * manipulation of the matrix's color data.
   */
  private class Colorizer {
    public int[] currentLoc;
    public String iconColor;
  
    public Colorizer(String personalColor, int[] startLoc) {
      currentLoc = startLoc;
      this.iconColor = personalColor;
    }
  }
  
  enum Clors{
    RED(),
    
  }
  
}


