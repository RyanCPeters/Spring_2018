package GraphVisualization.SwingWindow;

import java.awt.*;


public enum ColorBot {
  EXPLORER(1),
  MAPPER(2),
  INIT(0);
  
  
  /**
   *
   */
  public final Color[] localMatchingGradient =
      {
          new Color(118, 113, 200),
          new Color(160,  89, 159),
          new Color( 12,  12,  12),
          new Color(  0, 157, 223),
          new Color(172,  73, 113),
          new Color(161,  71,  71),
          new Color(  0, 137, 224)
      };
  
  private final Color[] localDust =
  {
    new Color(255,  73,  31),
        new Color(142, 104, 204),
        new Color( 85,  78,  93),
        new Color(186, 178, 195),
        new Color(255, 138, 112)
  };
  
  /**
   *
   */
  private final Color[] awtMyCustomChoice =
      {
          new Color(122, 103,  96),
          new Color( 90,  69,  59),
          new Color(177, 197, 246),
          new Color(100, 122, 202),
          new Color( 12,  12,  12)
      };
  
  /**
   *
   */
  private static final Color[] contrastingColorWheel =
      {
          new Color(255,  41,  31),
          new Color( 31,  61, 255),
          new Color( 95,  52,  35),
          new Color( 35,  95,  95),
          new Color( 61,  73,  41),
          new Color( 41, 255,  61),
          new Color( 46, 137,  52),
          new Color( 52,  95,  46),
          new Color( 38, 137,  73),
          new Color( 73,  61,  38),
          new Color( 33,  73, 137),
          new Color(137,  46,  33)
      };
  
  private Color lightFG;
  private Color darkFG;
  private Color bground;
  private Color altLighFG;
  private Color altDarkFG;
//  private static final Color Zeros = awtMyCustomChoice[2];
  
  ColorBot(int paletteNumber) {
    Color[] theWheel;
    switch (paletteNumber){
      default:
      case 0:
        theWheel = awtMyCustomChoice;
        break;
      case 1:
        theWheel = localMatchingGradient;
        break;
      case 2:
        theWheel = localDust;
        break;
    }
    
    lightFG = theWheel[0];
    darkFG = theWheel[1];
    bground = theWheel[2];
    if(theWheel.length > 3){
      altLighFG = theWheel[3];
      if(theWheel.length > 4){
        altDarkFG = theWheel[4];
      }else{
        altDarkFG = theWheel[2];
      }
    }else {
      altLighFG = theWheel[0];
      altDarkFG = theWheel[2];
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
  
  public static Color getContrastingColor(int placeInWheel){
    return contrastingColorWheel[placeInWheel];
  }
  
  public static int getColorWheelLen(){
    return contrastingColorWheel.length;
  }
  
}
