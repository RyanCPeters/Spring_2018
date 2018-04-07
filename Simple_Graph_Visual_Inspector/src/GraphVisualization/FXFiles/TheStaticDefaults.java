package GraphVisualization.FXFiles;

//import GraphVisualization.json.JSONWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TheStaticDefaults {
  
  public static final String FILENAME = "BasicMatricesAsJson.json";
  
  /**
   * public static final int[3][4] the3x4DefaultMatrix
   */
  public static final int[][] the3x4DefaultMatrix =
      {
          {1, 1, 0, 1},
          {0, 1, 0,1},
          {0, 1, 1, 0}
      };
  
  public static int get3x4Width(){return 4;}
  public static int get3x4Height(){return 3;}
  /**
   * public static final int[20][22] the20x22DefaultMatrix
   */
  public static final int[][] the20x22DefaultMatrix =
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
  
  
  
  public static int get20x22Width(){return 22;}
  public static int get20x22Height(){return 24;}
  
  public static final String the20x22String = "\n1101000111100000010001" +
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
                                        "\n1000000001011000001010";
  
  public static final String the3x4String = "\n1101\n" +
                                      "\n0101\n" +
                                      "\n0110";
  
}

class Main {
  public static void main(String[] args) {
    
    BufferedWriter bw = null;
    FileWriter fw = null;
    
    try {
      String contents ="\"threeByFour \" : ["+
                       Stream.of(Arrays.deepToString(TheStaticDefaults.the3x4DefaultMatrix))
                            .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString()+"]\n"+
                       "\"twentyByTwentyTwo \" : ["+
                       Stream.of(Arrays.deepToString(TheStaticDefaults.the20x22DefaultMatrix))
                           .collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString()+"]\n"+"}";
      
      fw = new FileWriter(TheStaticDefaults.FILENAME);
      bw = new BufferedWriter(fw);
      System.out.println(contents);
      bw.write(contents);
    } catch (IOException e) {
      
      e.printStackTrace();
      
    } finally {
      
      try {
        
        if (bw != null)
          bw.close();
        
        if (fw != null)
          fw.close();
        
      } catch (IOException ex) {
        
        ex.printStackTrace();
        
      }
      
    }
    
  }
}