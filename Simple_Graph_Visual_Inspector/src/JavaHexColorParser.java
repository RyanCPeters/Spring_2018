import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import GraphVisualization.ConsoleFiles.ConsolColor;

/**
 *
 */
public class JavaHexColorParser {
  public static final String FILENAME = "src/machine_readable_color_options.json";



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<String> colorStringList = parseFile(FILENAME);

    ArrayList<String[]> colorStrArrList = colorStringList.stream().parallel().map(str -> str.split(",")).collect
            (Collectors.toCollection(ArrayList::new));

    LinkedHashMap<String,Integer[][]> map = new LinkedHashMap<>();

    System.out.println();



    for(int rows = 0; rows < colorStrArrList.size(); ++rows){
      Integer[][] iRow = new Integer[colorStrArrList.get(rows).length-1][];
      String[] row = colorStrArrList.get(rows);
      for(int i =1; i < row.length; ++i){
        iRow[i-1] = new Integer[3];
        for(int k = row[i].length()-1, bitShift = 0; k >0; --k, bitShift=(bitShift==0)?4:0){
          iRow[i-1][(k-1)/2] = (bitShift == 0)?0:iRow[i-1][(k-1)/2];
          iRow[i-1][(k-1)/2] += (char_to_decimal_converter(row[i].charAt(k))<<bitShift);
        }
        map.put(row[0], iRow);
      }
    }
    String hexDecJSonFileName = "color_options_hex_and_dec.json", decJSonFileName = "color_options_dec.json",
            decCSSFileName = "css_color_options_dec.txt";

//    specialColorTransitionGenerator();
//    testPrintToConsole(map, colorStrArrList);
    writeToFileSimplified(map,colorStrArrList,decCSSFileName);
//    writeToFileInJsonFormat(map,colorStrArrList,hexDecJSonFileName);
//    writeToFileInJsonFormat(map, colorStrArrList, decJSonFileName);
  }


  /**
   *
   * @param map
   * @param colorStrArrList
   * @param fileName
   */
  private static void writeToFileSimplified(LinkedHashMap<String,Integer[][]> map,
                                            ArrayList<String[]> colorStrArrList, String fileName){
    String possible_errMsg = "";
    try(FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
    String[] relevantNames = {"DustPalette","ClassyPalette","MyCustomChoice"};

//      int keyCount = 0, keyCountMax = map.keySet().size();
      Integer[][] iRow;
      for(String[] key : colorStrArrList) {
        String objName = Character.toUpperCase(key[0].trim().charAt(0)) +
                key[0].trim().substring(1);

        iRow = map.get(key[0]);
        boolean writeThisEntry = false;
        for (int entryNum = 0; entryNum < relevantNames.length && !writeThisEntry; ++entryNum) {
          writeThisEntry = ((objName).equals(relevantNames[entryNum]));
        }
        if (writeThisEntry) {
          bw.write("  public static final Integer[][] arr" + objName + " = \n  {");
          int posInRow = 0;
          for (Integer[] val : iRow) {
            bw.write(String.format("" +
                    "\n    {%3d, %3d, %3d}%s", (val[0]+10 <= 255)?(val[0]+10):255,(val[1]+10 <= 255)?(val[1]+10):255, (val[2]+10 <= 255)?(val[2]+10):255, (posInRow++ < iRow.length - 1) ? "," : ""));
          }
          bw.write("\n  };\n\n");
          bw.flush();

          bw.write("  public static final Color[] awt" + objName + " = \n  {");
          posInRow = 0;
          for (Integer[] val : iRow) {
            bw.write(String.format("" +
                    "\n    new Color(%3d, %3d, %3d)%s", (val[0]+10 <= 255)?(val[0]+10):255,(val[1]+10 <= 255)?(val[1]+10):255, (val[2]+10 <= 255)?(val[2]+10):255, (posInRow++ < iRow.length - 1) ? "," : ""));
          }
          bw.write("\n  };\n\n");
          bw.flush();
        }
      }
      int redDiv = 1, grnDiv = 4, bluDiv = 12;
      double[] rgb = {255/redDiv, 255/grnDiv, 255/bluDiv};
      double[][] contigOClrPalette = new double[12][3];
      boolean addToGrnDiv = true;

      // generating an array of colors that maintain approximately the same intensity, but will transition from a
      // red'ish hue to a blue'ish hue.
      for(int count = 0; count < 12; ++count){
        if(addToGrnDiv && grnDiv > 8)addToGrnDiv = false;
        contigOClrPalette[count] = new double[]{255/(redDiv++),255/((addToGrnDiv)?grnDiv++:grnDiv--),255/(bluDiv--)};
      }

      bw.write("  public static final Color[] awtContOnesTransition = \n  {");
      int posInArr = 0;
      for(double[] val : contigOClrPalette) {
        bw.write(String.format("\n    new Color(%3d, %3d, %3d)%s", (((int)val[0])+10 <= 255)?((int)val[0])+10 :255, (((int)val[1])+10 <= 255)?((int)val[1])+10 :255, (((int)val[2])+10 <= 255)?((int)val[2])+10 :255,
                (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
      }
      bw.write("\n  };\n\n");
      bw.flush();

      bw.write("  public static final Integer[][] intContOnesTransition = \n  {");
      posInArr = 0;
      for(double[] val : contigOClrPalette) {
        bw.write(String.format("\n    {%3d, %3d, %3d}%s", (((int)val[0])+10 <= 255)?((int)val[0])+10 :255, (((int)val[1])+10 <= 255)?((int)val[1])+10 :255, (((int)val[2])+10 <= 255)?((int)val[2])+10 :255,
                (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
      }
      bw.write("\n  };\n\n");
      bw.flush();


      bw.close();
      fw.close();
      return;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
              "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
              "colorStrArrList, String fileName\n\n" +
              fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
              "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
              "colorStrArrList, String fileName\n\n" +
              ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tprivate static void writeToFileInJsonFormat" +
            "(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> colorStrArrList, String fileName)" +
            "\n"+possible_errMsg);
  }

  
  /**
   *
   * @param fileName
   * @return
   * @throws InternalError
   */
  public static ArrayList<String> parseFile(String fileName)throws InternalError{
    String possible_errMsg;
    BufferedReader br;
    try {
      final Pattern p = Pattern.compile("[\\p{Cntrl}\\[|\\]]");
       br = new BufferedReader(new FileReader(fileName));
      
      ArrayList<String> ret = br.lines().parallel().filter(l -> l.length() > 1)
          .map(l ->{
            l = l.trim().replaceAll("[ :\"]|(\\],)","").replaceAll(p.pattern(),",");
            if(l.endsWith(","))return l.substring(0,l.lastIndexOf(','));
            return l;
          }).collect(Collectors.toCollection(ArrayList::new));
      br.close();
      return ret;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                         "JavaHexColorParser.parseFile(String fileName)\n\n" +
                          fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "JavaHexColorParser.parseFile(String fileName)\n\n" +
                        ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tpublic static ArrayList<String> parseFile" +
                            "(String fileName)\n"+possible_errMsg);
  }
  
  /**
   *
   * @param c
   * @return
   */
  private static int char_to_decimal_converter(char c) {
    switch (c){
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
      case 'a': case 'A':
        return 10;
      case 'b': case 'B':
        return 11;
      case 'c': case 'C':
        return 12;
      case 'd': case 'D':
        return 13;
      case 'e': case 'E':
        return 14;
      case 'f': case 'F':
        return 15;
      default: throw new InternalError("\n\n[-] Internal Logic Error inside\n\t" +
                                       "Function<Character,Integer> char_to_decimal_converter = new Function<Character, Integer>()\n");
    }
  }
  
  /**
   *
   * @param map
   * @param colorStrArrList
   */
  private static void testPrintToConsole(LinkedHashMap<String,Integer[][]> map,
                                         ArrayList<String[]> colorStrArrList){
    System.out.print("{\n");
    int keyCount = 0, keyCountMax = map.keySet().size();
    for (String[] key : colorStrArrList) {
      Integer[][] iRow = map.get(key[0]);
      System.out.print("\t\"" + key[0] + "\":\n\t[\n");
      int posInRow = 1;
      for (Integer[] val : iRow) {
        System.out.printf("\t\t{\"%s\":{\"%s\": %d, \"%s\": %d, \"%s\": %d}},\n",
            key[posInRow],
            "red", val[0],
            "green", val[1],
            "blue", val[2]);
        ++posInRow;
      }
      System.out.print("\t]");
      System.out.println((keyCount++ < keyCountMax) ? "," : "");
    }
    System.out.println("}");
  }
  
  /**
   *
   * @param map
   * @param colorStrArrList
   * @param fileName
   */
  private static void writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map,
                                              ArrayList<String[]> colorStrArrList, String fileName){
    String possible_errMsg = "";
    try(FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
      
      
      bw.write("{\n");
      int keyCount = 0, keyCountMax = map.keySet().size();
      for(String[] key : colorStrArrList){
        Integer[][] iRow = map.get(key[0]);
        bw.write("\t\""+key[0]+"\":\n\t[\n");
        int posInRow = 1;
        for(Integer[] val : iRow){
          bw.write(String.format("\t\t{\"%s\":{\"%s\": %d, \"%s\": %d, \"%s\": %d}},\n",
              key[posInRow],
              "red",   val[0],
              "green", val[1],
              "blue",  val[2]));
          ++posInRow;
        }
        bw.write("\t]");
        bw.write((keyCount++ < keyCountMax)?",":"");
      }
      bw.write("}\n");
      bw.close();
      fw.close();
      return;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tprivate static void writeToFileInJsonFormat" +
                            "(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> colorStrArrList, String fileName)" +
                            "\n"+possible_errMsg);
  }

  /**
   *
   * @param map
   * @param colorStrArrList
   * @param fileName
   */
  private static void writeToFileInCSSFormat(LinkedHashMap<String,Integer[][]> map,
                                              ArrayList<String[]> colorStrArrList, String fileName){
    String possible_errMsg = "";
    try(FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
      
      
      bw.write("{\n");
      int keyCount = 0, keyCountMax = map.keySet().size();
      for(String[] key : colorStrArrList){
        Integer[][] iRow = map.get(key[0]);
        bw.write("\t\""+key[0]+"\":\n\t[\n");
        for(Integer[] val : iRow){
          bw.write(String.format("\t\t{\"rgb\":[ %3d, %3d, %3d]},\n",  val[0], val[1], val[2]));
        }
        bw.write("\t]");
        bw.write((keyCount++ < keyCountMax)?",":"");
      }
      bw.write("}\n");
      bw.close();
      fw.close();
      return;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tprivate static void writeToFileInJsonFormat" +
                            "(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> colorStrArrList, String fileName)" +
                            "\n"+possible_errMsg);
  }

  
  /**
   *
   */
  public static void specialColorTransitionGenerator(){
    String possible_errMsg = "";
    try(FileWriter fw = new FileWriter("Color_Transition_Array.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
      int redDiv = 1, grnDiv = 4, bluDiv = 12;
      double[] rgb = {255/redDiv, 255/grnDiv, 255/bluDiv};
      double[][] contigOClrPalette = new double[12][3];
      boolean addToGrnDiv = true;
      
      // generating an array of colors that maintain approximately the same intensity, but will transition from a
      // red'ish hue to a blue'ish hue.
      for(int count = 0; count < 12; ++count){
        if(addToGrnDiv && grnDiv > 8)addToGrnDiv = false;
        contigOClrPalette[count] = new double[]{255/(redDiv++),255/((addToGrnDiv)?grnDiv++:grnDiv--),255/(bluDiv--)};
        
 
      }

      bw.write("  public static final Color ContOnesTransition = \n  {");
      int posInArr = 0;
      for(double[] val : contigOClrPalette) {
        bw.write(String.format("\n    new Color(%3d, %3d, %3d)%s", ((int) val[0]), ((int) val[1]), ((int) val[2]),
                (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
      }
      bw.write("\n  };\n\n");
      bw.flush();

      bw.write("public static final Integer[][] ContOnesTransition = \n\t{");
      posInArr = 0;
      for(double[] val : contigOClrPalette) {
        bw.write(String.format("\n\t\t{%3d, %3d, %3d}%s", ((int) val[0]), ((int) val[1]), ((int) val[2]),
            (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
      }
      bw.write("\n};\n\n");
      bw.flush();
      
      
      bw.close();
      fw.close();
      return;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "JavaHexColorParser.writeToFileInJsonFormat(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> " +
                        "colorStrArrList, String fileName\n\n" +
                        ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tprivate static void writeToFileInJsonFormat" +
                            "(LinkedHashMap<String,Integer[][]> map, ArrayList<String[]> colorStrArrList, String fileName)" +
                            "\n"+possible_errMsg);
  }

}