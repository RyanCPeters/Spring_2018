package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Assig3 {
  private enum PropositionType {SINGLE,BICON}
  

  
  private static void generateTruthTable(HashMap<Integer,Boolean[]> map, String[] labels, PropositionType pt){
    int columnWidt = labels[labels.length-1].length();
    String HeaderRow = String.format("| %"+columnWidt+"s | %"+columnWidt+"s | %"+columnWidt+"s | %"+columnWidt+"s |",
        labels[0],labels[1],labels[2],labels[3]);
  
    // generating the horizontal dashed line that will separate the header row from the data rows.
    // given the 4 columns we are working with (matching the 4 header labels we've made) we need to generate
    // a dashed line with -+- intersections that occur every columnWidt spaces apart.
    StringBuilder horizontal_dashed_line = new StringBuilder("|");
    for(int colums = 0; colums < 4; ++colums){
      for(int width = 0; width < columnWidt+2; ++width){
        horizontal_dashed_line.append("-");
      }
      horizontal_dashed_line.append(((colums<3)?"+":"|"));
    }
    horizontal_dashed_line.append("\n");
    System.out.println();
    System.out.println();
    System.out.print(horizontal_dashed_line.toString().replace("+","-"));
    System.out.println(HeaderRow);
    System.out.print(horizontal_dashed_line.toString());
    System.out.print(horizontal_dashed_line.toString());
    for(int i = -10; i <11; ++i ){
      boolean nothing = true;
      boolean[] isBicconTrue = {false,false};
      StringBuilder sb = new StringBuilder("| ");
    
      sb.append(String.format("%s%"+columnWidt+"s",ConsolColor.ylo_bld_brt, String.valueOf(i)));
      sb.append(ConsolColor.RESET);
    
      sb.append(" | ");
    
      sb.append(String.format("%s%"+columnWidt+"s",(map.get(i)[2]? "":ConsolColor.rd_bg)+((map.get(i)[0])?ConsolColor.ylo_bld_brt:ConsolColor.blk_bld_brt),map.get(i)[0]));
      sb.append(ConsolColor.RESET);
  
      sb.append(" | ");
    
      sb.append(ConsolColor.RESET);
      sb.append(String.format("%s%"+columnWidt+"s",(map.get(i)[2]?"":ConsolColor.rd_bg)+((map.get(i)[1])?ConsolColor.ylo_bld_brt:ConsolColor.blk_bld_brt),map.get(i)[1]));
  
      sb.append(ConsolColor.RESET);
      sb.append(" | ");
      sb.append(String.format("%s%"+columnWidt+"s",(map.get(i)[2]?"":ConsolColor.rd_bg)+((map.get(i)[2])?ConsolColor.ylo_bld_brt:ConsolColor.blk_bld_brt),map.get(i)[2]));
      sb.append(ConsolColor.RESET);
    
      sb.append(" |\n");
      System.out.print(sb.toString());
      System.out.print(horizontal_dashed_line.toString().replace("+","-"));
      
    
    }
  }
  
  
  public static void problem1(){
    Function<Integer,Integer> pOfN = n -> (2*n + 2);
    HashMap<Integer,Boolean[]> truthTableCollection = new HashMap<>();
    for(int i =-1000; i < 1000; ++i){
      truthTableCollection.put(i,new Boolean[]{pOfN.apply(i)%3==0,i%3==2,((pOfN.apply(i)%3==0)?i%3==2:true)});
    }
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", conLabel = " p->q ";
    generateTruthTable(truthTableCollection,new String[]{nthrow,pLabel,qLabel,conLabel},PropositionType.SINGLE);
  }
  public static void problem2(){
    HashMap<Integer,Boolean[]> trutTableCollection = new HashMap<>();
//    for(int test = -10; test < 11; ++test) System.out.println(test+" "+(test%5));
    
    
    for(int a =-100; a < 101; ++a){
  
      int sign = (a >=0)?1:-1;
      trutTableCollection.put(a,new Boolean[]{((a*sign)%5==2),((a*a)%5==4),((a*sign)%5==2)==((a*a)%5==4)});
  }
    
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", biconLabel = " p<->q ";
    
    generateTruthTable(trutTableCollection,new String[]{nthrow,pLabel,qLabel,biconLabel},PropositionType.BICON);
  
  }
}
