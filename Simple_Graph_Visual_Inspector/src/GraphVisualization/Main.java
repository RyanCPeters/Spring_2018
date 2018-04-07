package GraphVisualization;

import GraphVisualization.ConsoleFiles.ConsolColor;
import GraphVisualization.ConsoleFiles.ConsoleColorEnum;
import GraphVisualization.ConsoleFiles.ContiguousOnes;
import GraphVisualization.FXFiles.JFXVisuals;

import java.util.Random;


public class Main {
  
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
//    System.out.println("\nOops, wrong main for now\n");
    JFXVisuals.main(args);
  }
  
  /**
   *
   * @param colorArray
   * @param show_output
   */
  static void vetColorArray(String[][] colorArray, boolean show_output){
    
    if(show_output) {
      for (String[] row : colorArray) {
        System.out.println();
        for (String col : row) {
          if (col.equals(ConsolColor.blk_brt + 1)) System.err.println("we had a 1 value get labeled as a 0");
          System.out.printf("%s", col);
        }
      }
    }else {
      for (String[] row : colorArray) {
        for (String col : row) {
          if (col.equals(ConsolColor.blk_brt + 1)) System.err.println("we had a 1 value get labeled as a 0");
        }
      }
    }
    
    System.out.println(ConsolColor.RESET);
  }
  
  /**
   *
   */
  private void theMessyMethod(){
//    String[][] colorArray1 = new String[0][], colorArray2 = new String[0][], colorArray3 = new String[0][], colorArray4 = new String[0][], colorArray5 = new String[0][], colorArray6 = new String[0][];
//    int number_of_sections;
    
    boolean useIterative = true, useRecursive = true;
    
    System.out.println(ConsolColor.RESET + "test using 2d array of:\n1 1 0 1\n0 1 0 1\n0 1 1 0\n");
    int arr[][] = {{1, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}};
    int x[][] =
        {
            {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1},
            {1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0}
        };
    
    
    String[][] colorArray1 = new String[0][], colorArray2 = new String[0][], colorArray3, colorArray4, colorArray5, colorArray6;
    int number_of_sections;
    
    if (useIterative) {
      colorArray1 = new String[3][4];
      number_of_sections = ContiguousOnes.countContiguous(arr, 4, 3, colorArray1, false);
      System.out.println();
      System.out.println("\tVetting colorArray1 now");
      vetColorArray(colorArray1, false);
      System.out.println();
      System.out.println();
      System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
    }
    
    if (useRecursive) {
      colorArray2 = new String[3][4];
      number_of_sections = ContiguousOnes.countContiguous(arr, 4, 3, colorArray2, true);
      System.out.println();
      System.out.println("\tVetting colorArray2 now");
      vetColorArray(colorArray2, false);
      System.out.println();
      System.out.println();
      System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
    }
    
    if(useIterative && useRecursive){
      System.out.println();
      for (int col = 0; col < 3; col++) {
        for (int row = 0; row < 4; row++) {
          if(colorArray1[col][row].equals(colorArray2[col][row])) System.out.printf("%s",colorArray1[col][row]);
        }
        System.out.println();
      }
      System.out.println(ConsoleColorEnum.RESET.basic);
    }
    System.out.println(
        "test using 2d array of:" +
        "\n1101000111100000010001" +
        "\n1000111100010111011000" +
        "\n0111100001101110101110" +
        "\n1111111100100100111000" +
        "\n1101101001011011000110" +
        "\n0101011000111010000110" +
        "\n0101100010100011110110" +
        "\n1010110011101111011001" +
        "\n1110010011100011100100" +
        "\n1010111000100110111001" +
        "\n0101000001011001001111" +
        "\n1010001001001101010111" +
        "\n1011100110011011010101" +
        "\n0000110100010101110011" +
        "\n1001100000100101010110" +
        "\n0100010000001100010011" +
        "\n0110111011001110001010" +
        "\n1000011111000011000001" +
        "\n1111001011000110010001" +
        "\n1000000001011000001010\n");
    
    if (useIterative) {
      colorArray3 = new String[20][22];
      number_of_sections = ContiguousOnes.countContiguous(x, 22, 20, colorArray3, false);
      System.out.println();
      System.out.println("\tVetting colorArray3 now");
      vetColorArray(colorArray3, true);
      System.out.println();
      System.out.println();
      System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
    }
    if (useRecursive) {
      colorArray4 = new String[20][22];
      number_of_sections = ContiguousOnes.countContiguous(x, 22, 20, colorArray4, true);
      System.out.println();
      System.out.println("\tVetting colorArray4 now");
      vetColorArray(colorArray4, true);
      System.out.println();
      System.out.println();
      System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
    }
    
    if (useIterative && useRecursive) {
      int number_of_samples = 2;
      for (int seed = 1; seed < number_of_samples; ++seed) {
        int rows = 20, cols = 20;
        if (number_of_samples < 3) {
          cols = 75;
          rows = 225;
        }
        int[][] y = new int[rows][cols];
        Random rand = new Random(seed);
        for (int row = 0; row < rows; ++row) {
          for (int col = 0; col < cols; ++col) {
            y[row][col] = rand.nextInt(2);
          }
        }
        
        // for shits and giggles, we ensure that the top left, and bottom right corners are 0. Lets now try to write
        // an algorithm that can find the shortest route from top left (start) to bottom right (end), if a path
        // even exists.
        y[0][0] = 0;
        y[rows - 1][cols - 1] = 0;
        
        colorArray5 = new String[rows][cols];
        number_of_sections = ContiguousOnes.countContiguous(y, cols, rows, colorArray5, false);
        System.out.println();
        System.out.println("\tVetting colorArray5 now");
        vetColorArray(colorArray5, false);
        System.out.println();
        System.out.println();
        System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
        
        colorArray6 = new String[rows][cols];
        number_of_sections = ContiguousOnes.countContiguous(y, cols, rows, colorArray6, true);
        System.out.println();
        System.out.println("\tVetting colorArray6 now");
        vetColorArray(colorArray6, false);
        System.out.println();
        System.out.println();
        System.out.println(ConsolColor.RESET + "The number of sections is: " + number_of_sections);
        
        
        System.out.println("\n\nlets try to print these arrays\n");
        for (int row = 0; row < cols; ++row) {
          for (int col = 0; col < rows; ++col) {
            if (colorArray5[col][row].equals(colorArray5[col][row])) {
              System.out.printf("%s", colorArray5[col][row]);
            } else {
              System.out.print(ConsolColor.wht_bg_brt + " " + ConsolColor.RESET + " ");
            }
          }
          System.out.println();
        }
        
        System.out.println(ConsolColor.RESET);
        
      }
    }
  }
}