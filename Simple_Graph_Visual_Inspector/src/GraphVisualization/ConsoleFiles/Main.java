package GraphVisualization.ConsoleFiles;

//import GraphVisualization.FXFiles.JFXVisuals;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Stream;


public class Main {
  
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
//    System.out.println("\nOops, wrong main for now\n");
//    JFXVisuals.main(args);
//    experimentWithContiguousOnesToConsole(true, true);
    contiguousOnesMatricesToFile(0,null);
    contiguousOnesMatricesToFile(1,null);
    contiguousOnesMatricesToFile(2,new int[]{40,60});
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
   * @param fileNamePrefix A general purpose designator that makes it explicitly clear what this file is for
   * @param uniqueID A valid string that describes the unique attributes of this file
   * @param fileNameSuffix the {.type} file extensino
   * @param data the 2d matrix to be iterated over.
   */
  private static void actualFileWriter(String fileNamePrefix,String uniqueID, String fileNameSuffix,
                                       Stream<Integer[][]> data){
    FileWriter fw;
    BufferedWriter bw;
    String possible_errMsg = "";
    try {
      fw = new FileWriter(fileNamePrefix+uniqueID+fileNameSuffix);
      bw = new BufferedWriter(fw);
//      StringBuilder sb = new StringBuilder("{\""+uniqueID+"\":");
      StringBuilder sb = new StringBuilder();
      data.forEach((Integer[][] arr) ->{
//        sb.append("{");
        Arrays.stream(arr).forEach((Integer[] row)->{
          sb.append("[");
          int rowLen = row.length;
          for(Integer itm :row){
            sb.append(itm+" ");
          }
          sb.deleteCharAt(sb.length()-1);
          sb.append("]\n");
        });
//        sb.deleteCharAt(sb.length()-1);
//        sb.append("}");
      });
//      sb.append("}");
      bw.write(sb.toString());
      bw.flush();
      fw.close();
      bw.close();
    return;
    }  catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                        "Main.actualFileWriter(String fileName, int[][] data)\n\n" +
                        fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "Main.actualFileWriter(String fileName, int[][] data)\n\n" +
                        "\t\t\terror occured when trying to interact with file named\n\t\t\t "+
                        fileNamePrefix+uniqueID+fileNameSuffix+"\n\n"+
                        ioe.getMessage();
    }
    throw new InternalError(
        "\n\n[-] Internal Logic Error inside\n\tprivate static void actualFileWriter(String fileName, int[][] data)\n"+
        possible_errMsg
    );
  }
  
  /**
   *
   * @param whichMatrix an int between 0 and 2, inclusive, that is to be used in initializing the int[][] desired
   * @param optional if the value passed into 'whichMatrix' is 2, then optional shall be the (rows,cols) dimensions of
   *                 the new binary matrix that will now be generated from random allocations of 1's and 0's.
   */
  public static void contiguousOnesMatricesToFile(int whichMatrix, int[] optional){
    String fileNamePrefix = "Readable_Matrix_", fileNameSuffix = ".json";
    String uniqueID = "";
    StringBuilder sb = new StringBuilder("{");
    Integer[][] tar;
    switch (whichMatrix){
      case 0:
        uniqueID = "3x4";
        tar = new Integer[][]{{1, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}};
        actualFileWriter(fileNamePrefix,uniqueID,fileNameSuffix,Stream.<Integer[][]>of(tar));
        return;
      case 1:
        uniqueID = "20x22";
        tar = new Integer[][]
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
        actualFileWriter(fileNamePrefix,uniqueID,fileNameSuffix,Stream.<Integer[][]>of(tar));
        return;
      case 2:
        uniqueID = optional[0]+"x"+optional[1];
        int rows = optional[0], cols = optional[1];

        tar = new Integer[rows][cols];
        Random rand = new Random(rows+cols);
        for (int row = 0; row < rows; ++row) {
          for (int col = 0; col < cols; ++col) {
            tar[row][col] = rand.nextInt(2);
          }
        }
        actualFileWriter(fileNamePrefix,uniqueID,fileNameSuffix,Stream.<Integer[][]>of(tar));
        return;
      default:break;
    }
//    actualFileWriter(fileNamePrefix,uniqueID,fileNameSuffix,sb.toString());
  }// end of private static void contiguousOnesMatricesToFile(int whichMatrix, int[] optional)
  /**
   *
   */
  private static void experimentWithContiguousOnesToConsole(boolean useIterative, boolean useRecursive){
    
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
    }// end of if (useIterative && useRecursive)
  }// end of private static void experimentWithContiguousOnesToConsole(boolean useIterative, boolean useRecursive)
}