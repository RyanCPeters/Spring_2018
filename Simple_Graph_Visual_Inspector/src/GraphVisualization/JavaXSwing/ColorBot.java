package GraphVisualization.JavaXSwing;

import java.awt.*;

public enum ColorBot {
  
  EXPLORE(StaticColorPalette.ClassyPalette),
  MAPPER(StaticColorPalette.DustPalette),
  INIT(StaticColorPalette.MyCustomChoice);
  
  private Color prime;
  private Color secondary;
  private Color bground;
  private Color accent1;
  private Color accent2;
  
  ColorBot(int[][] palette) {
    prime = new Color(palette[2][0],palette[2][1],palette[2][2]);
    secondary = new Color(palette[1][0],palette[1][1],palette[1][2]);
    bground = new Color(palette[0][0],palette[0][1],palette[0][2]);
    if(palette.length > 3){
      accent1 = new Color(palette[3][0],palette[3][1],palette[3][2]);
      if(palette.length > 4){
        accent2 = new Color(palette[4][0],palette[4][1],palette[4][2]);
      }else{
        accent2 = new Color(palette[0][0],palette[0][1],palette[0][2]);
      }
    }else {
      accent1 = new Color(palette[0][0],palette[0][1],palette[0][2]);
      accent2 = new Color(palette[0][0],palette[0][1],palette[0][2]);
    }
  }
  
  public Color getBG(){
    return bground;
  }
  
  public Color getPrimaryC() {
    return prime;
  }
  
  public Color getSecondaryC() {
    return secondary;
  }
  
  public Color getAccent1C() {
    return accent1;
  }
  
  public Color getAccent2C() {
    return accent2;
  }
}
