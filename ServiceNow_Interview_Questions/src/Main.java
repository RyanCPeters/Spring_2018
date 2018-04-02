public class Main {
  public static final String grn = "\033[0;32m";
  public static final String rd = "\033[0;31m";
  // Reset
  public static final String RESET = "\033[0m";
  
  public static void main(String[] args) {
    BST_tool tree = new BST_tool();
    for(int target = -100; target < 100; ++target) {
//      System.out.println("seeking " + target);
      int[] sol = tree.find2sum(target);
      System.out.print("\nfor target = " + target);
      if(sol[0] > -101 ) {
        System.out.println(grn + "\n\t{" + sol[0] + ", " + sol[1] + "}");
      }else {
        System.out.println(rd + "\n\tNo solution");
      }
      System.out.print(RESET);
      
    }
  
    System.out.println("End of Main func");
  }
}
