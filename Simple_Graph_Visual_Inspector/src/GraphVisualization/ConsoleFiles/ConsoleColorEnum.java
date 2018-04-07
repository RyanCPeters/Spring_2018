package GraphVisualization.ConsoleFiles;

/**
 *
 */
public enum ConsoleColorEnum {
  RED (ConsolColor.rd, ConsolColor.rd_bld, ConsolColor.rd_brt, ConsolColor.rd_bld_brt),
  GREEN (ConsolColor.grn, ConsolColor.grn, ConsolColor.grn, ConsolColor.grn_bld_brt),
  YELLOW (ConsolColor.ylo, ConsolColor.ylo_bld, ConsolColor.ylo_brt, ConsolColor.ylo_bld_brt),
  BLUE (ConsolColor.blu, ConsolColor.blu_bld, ConsolColor.blu_brt, ConsolColor.blu_bld_brt),
  PURPLE (ConsolColor.prpl, ConsolColor.prpl_bld, ConsolColor.prpl_brt, ConsolColor.prpl_bld_brt),
  CYAN (ConsolColor.cyan, ConsolColor.cyan_bld, ConsolColor.cyan_brt, ConsolColor.cyan_bld_brt),
  WHITE (ConsolColor.wht, ConsolColor.wht_bld, ConsolColor.wht_brt, ConsolColor.wht_bld_brt),
  BLACK(ConsolColor.blk, ConsolColor.blk_bld, ConsolColor.blk_brt, ConsolColor.blk_bld_brt),
  RESET (ConsolColor.RESET, ConsolColor.RESET, ConsolColor.RESET, ConsolColor.RESET);

  public final String basic;
  public final String bold;
  public final String bright;
  public final String brightBold;
  public static final String bg_white = ConsolColor.wht_bg_brt;
  private static int placeInList = 0;
  private static boolean onZeros = true;
  
  /**
   *
   */
  ConsoleColorEnum(String bas, String bld, String bri, String briBol) {
    basic = bas;
    bold = bld;
    bright = bri;
    brightBold = briBol;
  }
  
/**
 *
 * @param mapPath
 * @param deadEnd
 * @param contig1
 * @param val
 * @return
 */
  public static String assignColor(boolean mapPath, boolean deadEnd, boolean contig1, String val){
      if(mapPath){
        return bg_white + ((deadEnd)?"":WHITE.bright) + val;
      }else if(contig1){
        if(val.equals("1"))return deriveColor(false)+val;
        else return deriveColor(true)+val;
      }
      
      return RESET.basic;
  }

  private static String deriveColor(boolean increment){
    if(increment) {
      if(!onZeros)placeInList = (placeInList + 1) % 12;
      onZeros = true;
      return BLACK.brightBold;
    }else {
      onZeros = false;
      switch (placeInList) {
        case 0:
          return RED.basic;
        case 1:
          return BLUE.basic;
        case 2:
          return GREEN.basic;
        case 3:
          return PURPLE.basic;
        case 4:
          return YELLOW.basic;
        case 5:
          return CYAN.basic;
        case 6:
          return RED.brightBold;
        case 7:
          return BLUE.brightBold;
        case 8:
          return GREEN.brightBold;
        case 9:
          return PURPLE.brightBold;
        case 10:
          return YELLOW.brightBold;
        case 11:
          return CYAN.brightBold;
        default:
          return RESET.basic;
      }
    }
  }
  
  public static void resetPlaceInList(){
    placeInList = 0;
  }
}