import java.util.LinkedList;

public class ContiguousOnes {
  // to make it easier to handle directional checks, use this 2D array of int offsets
  private static final int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
  
  
  // declaring colors to be used in console output text. Used in making it easier
  // to visually inspect that the algorithm is traversing the array properly.
  
  /**
   * Index # : Color
   *    0 : rd
   *    1 : blu
   *    2 : Green
   *    3 : Magenta
   *    4 : Yellow
   *    5 : cyan
   *    6 : blkOUT the text
   */
  public static final String Colors[] = {
      ConColor.rd,
      ConColor.blu,
      ConColor.grn,
      ConColor.prpl,
      ConColor.ylo,
      ConColor.cyan,
      ConColor.rd_bld_brt,
      ConColor.blu_bld_brt,
      ConColor.grn_bld_brt,
      ConColor.prpl_bld_brt,
      ConColor.ylo_bld_brt,
      ConColor.cyan_bld_brt,
      ConColor.blk_brt,
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
          colorArr[x][y] = ConColor.blk_brt + arr[x][y];
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
    boolean usewhtBG = false;
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
            colorArray[x][y] = ConColor.blk_brt + arr[x][y];
          }
        }
      }
    }
    return count;
  }
}
