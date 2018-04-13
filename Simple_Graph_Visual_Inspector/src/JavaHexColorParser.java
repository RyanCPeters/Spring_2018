import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 */
public class JavaHexColorParser {
  public static final String FILENAME = "src/machine_readable_color_options.json",
                             COLORS_IN_JAVA_FORMAT_FILE_NAME= "JAVA_color_options";
  
  private static ArrayList<String[]> colorStrArrList = new ArrayList<>();
  private static LinkedHashMap<String,Integer[][]> map = new LinkedHashMap<>();
  
  enum FileFormat {
    CPP, JAVA, JSON,TXT
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<String> colorStringList = parseFile(FILENAME);

    colorStrArrList.addAll(colorStringList.stream().parallel().map(str -> str.split(",")).collect
            (Collectors.toCollection(ArrayList::new)));
    hexToDecConverter(map);

//    testPrintToConsole(map, colorStrArrList);
    writeToFileSimplified(writeableStreamOutput(map,colorStrArrList,COLORS_IN_JAVA_FORMAT_FILE_NAME,FileFormat.JAVA),
        COLORS_IN_JAVA_FORMAT_FILE_NAME, FileFormat.JAVA);
    
  }
  
  private static void hexToDecConverter(LinkedHashMap<String, Integer[][]> map) {
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
  }
  
  
  /**
   *  @param sb the string builder object that has the pertinent file contents
   * @param fileName a useful bit of information that
   * @param FTypeForSuffix
   */
  private static void writeToFileSimplified(StringBuilder sb, String fileName, FileFormat FTypeForSuffix){
    String possible_errMsg = "", suffix = "";
    switch (FTypeForSuffix){
      case CPP:
        suffix = ".h";
        break;
      case JAVA:
        suffix = ".java";
        break;
      case JSON:
        suffix = ".json";
        break;
      case TXT:
        suffix = ".txt";
        break;
      default:break;
    }
    try(FileWriter fw = new FileWriter(fileName+suffix); BufferedWriter bw = new BufferedWriter(fw)) {
      bw.write(sb.toString());
      bw.flush();
      bw.close();
      fw.close();
      return;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
              "JavaHexColorParser.writeToFileSimplified(StringBuilder sb, String fileName)\n\n" +
              fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
              "JavaHexColorParser.writeToFileSimplified(StringBuilder sb, String fileName)\n\n" +
              ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tprivate static void writeToFileSimplified(StringBuilder sb, String fileName)" +
            "\n"+possible_errMsg);
  }// end of method writeToFileSimplified(StringBuilder sb, String fileName, FileFormat FTypeForSuffix)
  
  /**
   *
   * @param map
   * @param colorStrArrList
   * @param fileName This should give specific details about what this file is for. (Do not include the dot file type
   *                in this string.
   * @param dotFileType Use the enum FileFormat in order to get the stream to output the file in the correct format
   *                    for your desired file type.
   * @return
   */
  private static StringBuilder writeableStreamOutput(LinkedHashMap<String, Integer[][]> map,
                                                      ArrayList<String[]> colorStrArrList, String fileName,
                                                      FileFormat dotFileType){
    StringBuilder sb = new StringBuilder();
    String intVarDeclaration;
    String colorVarDeclaration;
    fileName = fileName.trim();
    
    // this switch block is for creating the file type appropriate header
    switch (dotFileType){
      case CPP:
        colorVarDeclaration = "  static const Color[] awt";
        intVarDeclaration = "  public static final Integer[][] arr";
        // implements the color arrays as member variables of a header file named according to the parameter "fileName"
        String headerGuard = fileName.trim().toUpperCase()+"_H";
        sb.append("\n#ifndef ")
            .append(headerGuard)
            .append("\n#define ").append(headerGuard).append("\n\n#include <string>\n\n");
        break;
      case JAVA:
        colorVarDeclaration = "  public static final Color[] awt";
        intVarDeclaration   = "  public static final Integer[][] arr";
        sb.append("import java.awt.*;\n" +
                  "\n" +
                  "public class ").append(fileName).append(" {");
        break;
      case JSON:
        colorVarDeclaration = "";
        intVarDeclaration = "";
        sb.append("{\n  ");
        break;
      case TXT:
        default:
          colorVarDeclaration = "";
          intVarDeclaration = "";
          break;
    }
    
    Integer[][] iRow;
    for(String[] key : colorStrArrList) {
      String objName = Character.toUpperCase(key[0].trim().charAt(0)) +
                       key[0].trim().substring(1);
    
      iRow = map.get(key[0]);
      sb.append(intVarDeclaration).append(objName).append(" = \n  {");
      int posInRow = 0;
      for (Integer[] val : iRow) {
        sb.append(String.format("" +
                               "\n    {%3d, %3d, %3d}%s", (val[0]+10 <= 255)?(val[0]+10):255,(val[1]+10 <= 255)?(val[1]+10):255, (val[2]+10 <= 255)?(val[2]+10):255, (posInRow++ < iRow.length - 1) ? "," : ""));
      }
      sb.append("\n  };\n\n");
  
      sb.append(colorVarDeclaration).append(objName).append(" = \n  {");
      posInRow = 0;
      for (Integer[] val : iRow) {
        sb.append(String.format("" +
                               "\n    new Color(%3d, %3d, %3d)%s", (val[0]+10 <= 255)?(val[0]+10):255,(val[1]+10 <= 255)?(val[1]+10):255, (val[2]+10 <= 255)?(val[2]+10):255, (posInRow++ < iRow.length - 1) ? "," : ""));
      }
      sb.append("\n  };\n\n");
      
    }
    int redDiv = 1, grnDiv = 8, bluDiv = 12;
    int[][] contigOClrPalette = new int[12][3];
    boolean addToGrnDiv = true;
  
    // generating an array of colors that maintain approximately the same intensity, but will transition from a
    // red'ish hue to a blue'ish hue.
    for(int count = 0; count < 12; ++count){
      if(addToGrnDiv && grnDiv < 2)addToGrnDiv = false;
      contigOClrPalette[count] =
          new int[]{255/(redDiv++),255/((addToGrnDiv)?grnDiv--:grnDiv++),255/(bluDiv--)};
    }
    
    for(int front = 0, back = contigOClrPalette.length; front < back; ++front,--back){
      if(front%2 == 1){
        int[] tmp = contigOClrPalette[front];
        contigOClrPalette[front] = contigOClrPalette[back];
        contigOClrPalette[back] = tmp;
      }
    }
    
    sb.append(colorVarDeclaration).append("CountOnesTransition = \n  {");
    int posInArr = 0;
    for(int[] val : contigOClrPalette) {
      sb.append(String.format("\n    new Color(%3d, %3d, %3d)%s", (val[0] + 10 <= 255) ? val[0] + 10 : 255, (val[1] + 10 <= 255) ? val[1] + 10 : 255, (val[2] + 10 <= 255) ? val[2] + 10 : 255,
          (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
    }
    sb.append("\n  };\n\n");
  
    sb.append(intVarDeclaration).append("CountOnesTransition = \n  {");
    posInArr = 0;
    for(int[] val : contigOClrPalette) {
      sb.append(String.format("\n    {%3d, %3d, %3d}%s", (val[0] + 10 <= 255) ? val[0] + 10 : 255, (val[1] + 10 <= 255) ? val[1] + 10 : 255, (val[2] + 10 <= 255) ? val[2] + 10 : 255,
          (posInArr++ < contigOClrPalette.length - 1) ?"," + "" : ""));
    }
    sb.append("\n  };\n\n");
    
    switch (dotFileType){
      case CPP:
        String headerGuard = fileName.trim().toUpperCase()+"_H";
        sb.append("#endif // ").append(headerGuard);
        break;
      case JAVA:
        sb.append("} // end of class ").append(fileName);
        break;
      case JSON:
        break;
      case TXT:
        break;
        default:break;
    }
    
    return sb;
    
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

}