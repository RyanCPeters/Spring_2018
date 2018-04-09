package GraphVisualization.JavaXSwing;

import java.awt.Color;

public class StaticColorPalette {
  
  public static final int[][] DustPalette =
      {
          {132,  94, 194},
          { 75,  68,  83},
          {176, 168, 185},
          {255, 128, 102}
      };
  
  public static final int[][] GenericGradient =
      {
          {161,  71,  71},
          {145,  68,  95},
          {118,  71, 111},
          { 86,  75, 113},
          { 60,  75, 104},
          { 47,  72,  88}
      };
  
  public static final int[][] MatchingGradient =
      {
          {161,  71,  71},
          {172,  73, 113},
          {160,  89, 159},
          {118, 113, 200},
          {  0, 137, 224},
          {  0, 157, 223}
      };
  
  public static final int[][] SpotPalette =
      {
          {161,  71,  71},
          {220, 122, 119},
          {255, 228, 224},
          {  0, 194, 255},
          {  0, 194, 255},
          {198, 248, 255},
          { 76, 125, 147},
          {175, 127, 135},
          {121, 136, 151}
      };
  
  public static final int[][] ClassyPalette =
      {
          {161,  71,  71},
          { 87,  66,  64},
          {191, 165, 163},
          { 88, 106,  33},
          {140, 158,  82}
      };
  


  
  public static final int[][] SwitchPalette =
      {
          {161,  71,  71},
          {255, 186, 181},
          {  0, 194, 255},
          {243, 238, 217}
      };
  
  public static final int[][] SmallSwitchPalette =
      {
          {161,  71,  71},
          {255, 236, 239},
          {178, 114, 126}
      };
  
  public static final int[][] SkipGradient =
      {
          {161,  71,  71},
          {255, 192, 255},
          {242, 137, 198},
          {184,  83, 144}
      };
  
  public static final int[][] NaturalPalette =
      {
          {161,  71,  71},
          {189, 130, 126},
          {255, 244, 243},
          {243, 238, 217}
      };
  
  public static final int[][] MatchingPalette =
      {
          {161,  71,  71},
          { 87,  66,  64},
          {191, 165, 163},
          {  0, 112, 157},
          {  0, 164, 212}
      };
  
  public static final int[][] SquashPalette =
      {
          {161,  71,  71},
          {  0, 120,  69},
          { 99,  87, 175}
      };
  
  public static final int[][] GreyFriends =
      {
          {161,  71,  71},
          { 87,  66,  64},
          {191, 165, 163}
      };
  
  public static final int[][] DottingPalette =
      {
          {161,  71,  71},
          {191, 165, 163},
          { 88, 106,  33},
          {170, 173, 155}
      };
  
  public static final int[][] SkipShadeGradient =
      {
          {161,  71,  71},
          {213, 107, 125},
          {255, 147, 187},
          {255, 192, 255}
      };
  
  public static final int[][] Threedom =
      {
          {161,  71,  71},
          {  0, 117,  39},
          {  0, 107, 196}
      };
  
  public static final int[][] HighlightPalette =
      {
          {161,  71,  71},
          {255, 116, 119},
          {243, 238, 217},
          {121, 136, 151}
      };
  
  public static final int[][] NeighborPalette =
      {
          {161,  71,  71},
          {106,  63,  72},
          {174, 104, 118},
          {196, 171, 174}
      };
  
  public static final int[][] DiscreetPalette =
      {
          {161,  71,  71},
          {189, 130, 126},
          {255, 243, 241},
          {121, 136, 151}
      };
  
  public static final int[][] Collective =
      {
          {161,  71,  71},
          {168,  68,  25},
          { 80, 109,   0}
      };
  
  public static final int[][] Friendpalette =
      {
          {161,  71,  71},
          {243, 143, 140},
          {  0, 194, 255},
          {  0,  89, 165}
      };
  
  public static final int[][] PinPalette =
      {
          {161,  71,  71},
          {255, 116, 119},
          {243, 238, 217},
          {  0, 194, 255}
      };
  
  public static final int[][] Shades =
      {
          {161,  71,  71},
          {195, 100,  99},
          {229, 131, 127},
          {255, 162, 158},
          {255, 194, 189}
      };
  
  public static final int[][] MyCustomChoice =
      {
          {144, 151, 192},
          {  2,   2,   2},
          { 80,  59,  49},
          {167, 187, 236},
          {112,  93,  86}
      };
  public static final int[][] ContOnesTransition =
      {
          {255,  63,  21},
          {127,  51,  23},
          { 85,  42,  25},
          { 63,  36,  28},
          { 51,  31,  31},
          { 42,  28,  36},
          { 36,  31,  42},
          { 31,  36,  51},
          { 28,  42,  63},
          { 25,  51,  85},
          { 23,  63, 127},
          { 21,  85, 255}
      };
  
  
  
  public static Color getPaletteAsAWTColor(int[][] palette, int colorIDX){
    return new Color(palette[colorIDX][0],palette[colorIDX][1],palette[colorIDX][2]);
  }
  
}
