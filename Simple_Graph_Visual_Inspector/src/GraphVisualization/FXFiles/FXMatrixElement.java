package GraphVisualization.FXFiles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.swing.text.EditorKit;

public class FXMatrixElement extends Text{
  // Note that the FXMatrixElents are square.
  static final int EDGE_LEN = 10; // edge length in pixels
  private int binVal;
  private int areaSum;
  private int viableDirs;
  private Color c;
  
  private boolean found = false;
  private boolean colorized = false;
  private boolean mapped = false;
  
  public FXMatrixElement() {
    super(String.valueOf(0));
    binVal = 0;
    areaSum = 0;
    viableDirs = 0;
    c = Color.BLACK.brighter();
    this.setFill(c);
    this.setTextAlignment(TextAlignment.CENTER);
  }
  
  public FXMatrixElement(int binVal) {
    super(String.valueOf(0));
    
    this.binVal = binVal;
    areaSum = 0;
    viableDirs = 0;
    c = Color.BLACK.brighter();
    this.setFill(c);
    this.setTextAlignment(TextAlignment.CENTER);
  }
  
  public void setFill(Color c){
    super.setFill(c);
    this.c = c;
  }
  
  public static int getEdgeLen() {
    return EDGE_LEN;
  }
  
  public int getBinVal() {
    return binVal;
  }
  
  public int getAreaSum() {
    return areaSum;
  }
  
  public int getViableDirs() {
    return viableDirs;
  }
  
  public Color getC() {
    return c;
  }
  
  public boolean isFound() {
    return found;
  }
  
  public boolean isColorized() {
    return colorized;
  }
  
  public boolean isMapped() {
    return mapped;
  }
  
  public void setBinVal(int binVal) {
    this.binVal = binVal;
  }
  
  public void setAreaSum(int areaSum) {
    this.areaSum = areaSum;
  }
  
  public void setViableDirs(int viableDirs) {
    this.viableDirs = viableDirs;
  }
  
  public void setC(Color c) {
    this.c = c;
  }
  
  public void setFound(boolean found) {
    this.found = found;
  }
  
  public void setColorized(boolean colorized) {
    this.colorized = colorized;
  }
  
  public void setMapped(boolean mapped) {
    this.mapped = mapped;
  }
}
