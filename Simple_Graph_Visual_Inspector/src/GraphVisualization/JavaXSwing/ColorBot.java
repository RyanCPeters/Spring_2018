package GraphVisualization.JavaXSwing;

import java.awt.*;

import static GraphVisualization.JavaXSwing.StaticColorPalette.*;

public enum ColorBot {
  
  EXPLORER(awtMatchingGradient),
  MAPPER(awtDustPalette),
  INIT(awtMyCustomChoice);
  
  private Color lightFG;
  private Color darkFG;
  private Color bground;
  private Color altLighFG;
  private Color altDarkFG;
  private static final Color Zeros = awtMyCustomChoice[2];
  
  ColorBot(Color[] palette) {
    lightFG = palette[0];
    darkFG = palette[1];
    bground = palette[2];
    if(palette.length > 3){
      altLighFG = palette[3];
      if(palette.length > 4){
        altDarkFG = palette[4];
      }else{
        altDarkFG = palette[2];
      }
    }else {
      altLighFG = palette[0];
      altDarkFG = palette[2];
    }
  }
  
  public Color getBG(){
    return bground;
  }
  
  public Color getLightFG() {
    return lightFG;
  }
  
  public Color getDarkFG() {
    return darkFG;
  }
  
  public Color getAltLighFG() {
    return altLighFG;
  }
  
  public Color getAltDarkFG() {
    return altDarkFG;
  }
}
