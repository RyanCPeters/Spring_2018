import java.util.LinkedList;

public class ContiguousOnes {
  // to make it easier to handle directional checks, use this 2D array of int offsets
  private static final int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
  
  
  // declaring colors to be used in console output text. Used in making it easier
  // to visually inspect that the algorithm is traversing the array properly.
  
  /**
   * Index # : Color
   *    0 : Red
   *    1 : Blue
   *    2 : Green
   *    3 : Magenta
   *    4 : Yellow
   *    5 : Cyan
   *    6 : BLACKOUT the text
   */
  public static final String Colors[] = {
      ConColor.rd,
      ConColor.blu,
      ConColor.grn,
      ConColor.prpl,
      ConColor.ylo,
      ConColor.cyan,
      ConColor.RED_BOLD_BRIGHT,
      ConColor.BLUE_BOLD_BRIGHT,
      ConColor.GREEN_BOLD_BRIGHT,
      ConColor.PURPLE_BOLD_BRIGHT,
      ConColor.YELLOW_BOLD_BRIGHT,
      ConColor.CYAN_BOLD_BRIGHT,
      ConColor.BLACK_BRIGHT,
      ConColor.RESET
  };
  static final int numberOfColors = 12;
  
  /**
   *
   * @param checked
   * @param arr
   * @param x_
   * @param y_
   * @param rows
   * @param cols
   * @param colorArr
   * @param colorNumber
   * @return true until the x_ or y_ point beyond the array's bounds.
   */
  private static void recursiveDFS(boolean[][] checked, int[][] arr, int x_, int y_, int rows, int cols, String[][] colorArr, int colorNumber){
    // sanity checking the indices for out-of-bounds conditions
    
    
    checked[x_][y_] = true;
    colorArr[x_][y_] = Colors[colorNumber] + arr[x_][y_];
    boolean dirsToFollow[] = {false,false,false,false};
    for(int dir = 0; dir < 4; ++dir){
      int x = x_ + dirs[dir][0], y = y_ + dirs[dir][1];
      if(validIndexToCheck(x,y,rows,cols,checked)){
        dirsToFollow[dir] = (arr[x][y] == 1);
        if(dirsToFollow[dir]){
          recursiveDFS(checked,arr,x,y,rows,cols,colorArr,colorNumber);
        }else{
          colorArr[x][y] = ConColor.BLACK_BRIGHT + arr[x][y];
          checked[x][y] = true;
        }
      }
    }
  }
  
  private static boolean validIndexToCheck(int x_, int y_, int rows, int cols, boolean[][] checked){
    return (x_ >= 0 && x_ < cols) && (y_ >= 0 && y_ < rows) && !checked[x_][y_];
  }
  
  /**
   * @param checked
   * @param arr
   * @param x_
   * @param y_
   * @param rows
   * @param cols
   * @param colorArr
   * @param colorNumber
   */
  private static void iterativeBFS(boolean[][] checked, int[][] arr, int x_, int y_, int rows, int cols, String[][] colorArr, int colorNumber){
    LinkedList<int[]> loc_queue = new LinkedList<>();
    loc_queue.add(new int[]{x_,y_});
    
    while(!loc_queue.isEmpty()){
      int loc[] = loc_queue.pollFirst();
      checked[loc[0]][loc[1]] = true;
      colorArr[loc[0]][loc[1]] = Colors[colorNumber] + arr[loc[0]][loc[1]];
      for(int dir[] : dirs){
        int dx = loc[0]+dir[0], dy = loc[1]+dir[1];
        if(dx >= 0 && dx < cols && dy >= 0 && dy < rows && !checked[dx][dy] && arr[dx][dy] == 1){
          loc_queue.add(new int[]{dx,dy});
        }
      }
    }
  }
  
  static int countContiguous(int[][] arr, int rows, int cols, String[][] colorArray, boolean use_recursion, boolean show_output){
    int count = 0;
    boolean useWhiteBG = false;
    boolean  checkedArr[][] = new boolean[cols][rows];
  
    int colorNumber = 0;
    
    for(int x = 0; x < cols; ++x) {
      for (int y = 0; y < rows; ++y) {
        if (!checkedArr[x][y]) {
          checkedArr[x][y] = true;
          if (arr[x][y] == 1) {
            ++count;
            if(use_recursion) recursiveDFS(checkedArr, arr, x, y, rows, cols, colorArray, colorNumber);
            else              iterativeBFS(checkedArr, arr, x, y, rows, cols, colorArray, colorNumber);
            
            colorNumber = (++colorNumber)%numberOfColors;
          }else {
            colorArray[x][y] = ConColor.BLACK_BRIGHT + arr[x][y];
          }
        }
      }
    }
    return count;
  }
}

/**
 * I borrowed the idea and some of the syntax for this class from:
 *
 *    https://stackoverflow.com/a/45444716/7412747
 */
class ConColor {
  // Reset
  public static final String RESET = "\033[0m";  // Text Reset
  
  // Regular Colors
  public static final String blk = "\033[0;30m";   // blk
  public static final String rd = "\033[0;31m";     // rd
  public static final String grn = "\033[0;32m";   // grn
  public static final String ylo = "\033[0;33m";  // ylo
  public static final String blu = "\033[0;34m";    // blu
  public static final String prpl = "\033[0;35m";  // prpl
  public static final String cyan = "\033[0;36m";    // CYAN
  public static final String WHITE = "\033[0;37m";   // WHITE
  
  // Bold
  public static final String BLACK_BOLD = "\033[1;30m";  // blk
  public static final String RED_BOLD = "\033[1;31m";    // rd
  public static final String GREEN_BOLD = "\033[1;32m";  // grn
  public static final String YELLOW_BOLD = "\033[1;33m"; // ylo
  public static final String BLUE_BOLD = "\033[1;34m";   // blu
  public static final String PURPLE_BOLD = "\033[1;35m"; // prpl
  public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
  public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
  
  // Underline
  public static final String BLACK_UNDERLINED = "\033[4;30m";  // blk
  public static final String RED_UNDERLINED = "\033[4;31m";    // rd
  public static final String GREEN_UNDERLINED = "\033[4;32m";  // grn
  public static final String YELLOW_UNDERLINED = "\033[4;33m"; // ylo
  public static final String BLUE_UNDERLINED = "\033[4;34m";   // blu
  public static final String PURPLE_UNDERLINED = "\033[4;35m"; // prpl
  public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
  public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
  
  // Background
  public static final String BLACK_BACKGROUND = "\033[40m";  // blk
  public static final String RED_BACKGROUND = "\033[41m";    // rd
  public static final String GREEN_BACKGROUND = "\033[42m";  // grn
  public static final String YELLOW_BACKGROUND = "\033[43m"; // ylo
  public static final String BLUE_BACKGROUND = "\033[44m";   // blu
  public static final String PURPLE_BACKGROUND = "\033[45m"; // prpl
  public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
  public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
  
  // High Intensity
  public static final String BLACK_BRIGHT = "\033[0;90m";  // blk
  public static final String RED_BRIGHT = "\033[0;91m";    // rd
  public static final String GREEN_BRIGHT = "\033[0;92m";  // grn
  public static final String YELLOW_BRIGHT = "\033[0;93m"; // ylo
  public static final String BLUE_BRIGHT = "\033[0;94m";   // blu
  public static final String PURPLE_BRIGHT = "\033[0;95m"; // prpl
  public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
  public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
  
  // Bold High Intensity
  public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // blk
  public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // rd
  public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // grn
  public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// ylo
  public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // blu
  public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// prpl
  public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
  public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
  
  // High Intensity backgrounds
  public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// blk
  public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// rd
  public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// grn
  public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// ylo
  public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// blu
  public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // prpl
  public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
  public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
  
}