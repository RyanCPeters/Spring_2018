package com.Assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Assig3 {
  private enum PropositionType {SINGLE,BICON}
  
  /*
  * cheat sheet for getting operators from ansi code:
  * prefix the alpha-numeric codes for your chosen symbol with
  * \u****, that is to say, if we wanted to write
  * the Logican AND symbol, we would type:
  *     \u2227
  *     eg., (pAND~q) becomes (p\u2227~q) which will later be interpreted into the
  *     ∧ by the console's text parcer.
 
¬ 00AC not sign
∧ 2227 Logical AND
∨ 2228 Logical OR
∎ 220E, END OF PROOF
∴ 2234, THEREFORE , there4, therefore, Therefore
∵ 2235, BECAUSE , becaus, because, Because
∀ 2200, FOR ALL , forall, ForAll
∃ 2203, THERE EXISTS , exist, Exists
∄ 2204, THERE DOES NOT EXIST , nexist, NotExists, nexists


∝ 221D prop, propto, Proportional, vprop, varpropto, proportional to
∣ 2223 divides
∤ 2224 does not divide
≃ 2243 asymptotically equal to
≄ 2244 not asymptotically equal to
≅ 2245 approximately equal to
≆ 2246 approximately but not actually equal to
≇ 2247 neither approximately nor actually equal to
≈ 2248 almost equal to
≉ 2249 not almost equal to
≜ 225C trie, triangleq, delta equal to
≝ 225D equal to by definition
≟ 225F equest, checked equal to
≠ 2260 ne, NotEqual, not equal to
≡ 2261 equiv, Congruent, equivalent to
≤ 2264 less-than or equal to
≥ 2265 greater-than or equal to
≪ 226A much less than
≫ 226B much greater than

⊂ 2282 subset, included in, proper subset
⊃ 2283 superset, includes, proper superset
⊆ 2286 subset of or equal to
⊇ 2287 superset or equal to
⊄ 2284 notin set
∩ 2229 intersection
∪ 222A union
∈ 2208 isin, isinv, Element, in, element of (large symbol)
∊ 220A element of (small symbol)
∉ 2209 notin, NotElement, notinva, not element of
∋ 220B niv, ReverseElement, ni, SuchThat, contains as member (large symbol)
∍ 220D contains as member (small symbol)
∌ 220C notni, notniva, NotReverseElement, does not contain as member
∅ 2205 empty, emptyset, emptyv, varnothing, empty set

  * */
  
//  private static void truthTableLogicTree(HashMap<Integer[],Boolean[]> map, String[] labels, PropositionType pt){
//
//  }
  
  /**<pre>
   * This function provides a boilerplate mechanism for generating a truth table
   * that will colorize and highlight rows of the table where propositional logic
   * statements result in a false outcome.
   *
   *
   * </pre>
   * @param map <br>
   *   a {@code HashMap<Integer, Boolean[]>} object that accepts an integer<br>
   *   value, n, as the key to a boolean array that represents the truth states<br>
   *   for a given row to a truth table which corresponds to propositional<br>
   *   function outputs for a given input of n.<br><br>
   *
   * @param labels <br>
   *   an array of strings which represent the header labels for your columns.<br>
   *   For example, {@code new String[]{"n","p(n)","q(n)","p->q"}}<br><br>
   *
   * @param pt <br>
   *   An enumerator reference that is used communicate if this table should<br>
   *   colorize rows according to conditional or biconditional requirements.<br><br>
   */
  private static void generateTruthTable(HashMap<Integer,Boolean[]> map,
                                         String[] labels, PropositionType pt)
  {
    int columnWidt = 0;
    
    for(String s : labels){
      columnWidt = (columnWidt >= s.length())?columnWidt :(s.length() > 20)?20 : s.length()+2;
    }
    StringBuilder headerBuilder = new StringBuilder("|");
    for (String label : labels) {
      headerBuilder.append(String.format(" %" + columnWidt + "s |", label));
    }
    
    // generating the horizontal dashed line that will separate the header row from the data rows.
    // given the 4 columns we are working with (matching the 4 header labels we've made) we need to generate
    // a dashed line with -+- intersections that occur every columnWidt spaces apart.
    StringBuilder horizontal_dashed_line = new StringBuilder("|");
    for(int colums = 0; colums < labels.length; ++colums){
      for(int width = 0; width < columnWidt+2; ++width){
        horizontal_dashed_line.append("-");
      }
      horizontal_dashed_line.append(((colums<labels.length-1)?"+":"|"));
    }
    String tableHorizontalLines = horizontal_dashed_line.toString().replace("+","-");
    System.out.println();
    System.out.println();
    System.out.println(tableHorizontalLines);
    System.out.println(headerBuilder.toString());
    System.out.println(horizontal_dashed_line.toString().replace("-","="));
    horizontal_dashed_line.toString().replace("=","-");
    
    
    int pos = 0;
    int end = map.values().size();
    for(Map.Entry ent : map.entrySet()){
      Boolean[] boolForI = new Boolean[labels.length-1];
      for(int k = 0; k < boolForI.length; ++k)boolForI[k] = ((Boolean[])(ent.getValue()))[k];
      StringBuilder sb = new StringBuilder("| ");
    
      sb.append(String.format("%s%"+columnWidt+"s",ConsolColor.ylo_bld_brt,
          String.valueOf(ent.getKey())));
      sb.append(ConsolColor.RESET);
    
      
      for(int k = 0; k < boolForI.length; ++k){
        sb.append(" | ");
        sb.append(String.format("%s%"+columnWidt+"s",(boolForI[k]?ConsolColor.grn_bld_brt:ConsolColor.rd_bld_brt),boolForI[k]));
        sb.append(ConsolColor.RESET);
  
      }
    
      sb.append(" |");
      System.out.println(sb.toString()+
                       (boolForI[boolForI.length-1]?"":ConsolColor.cyan_bg+ConsolColor.wht_bld_brt+"<---")+ConsolColor.RESET);
      System.out.println(
          ((pos < end-1)?horizontal_dashed_line.toString():tableHorizontalLines));
      
    ++pos;
    }
    
  }
  
  
  public static void problem1(){
    Function<Integer,Integer> p_of_n = n -> (2*n + 2);
    HashMap<Integer,Boolean[]> truthTableCollection = new HashMap<>();
    for(int i =-1000; i < 1000; ++i){
      int sign = (i<0)?-1:1;
      truthTableCollection.put(i,new Boolean[]{p_of_n.apply(i)%3==0,(i*sign)%3==2,(
          (p_of_n.apply(i) % 3 != 0) || i % 3 == 2)});
    }
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", conLabel = " p->q ";
    System.out.println("\n\nProblem #1 truth table");
    System.out.println("Prove or disprove: For all integers n, if [3|(2n + 2)], then [n"+
                       "\u22613 2].");
    generateTruthTable(truthTableCollection,new String[]{nthrow,pLabel,qLabel,conLabel},PropositionType.SINGLE);
  } // ends problem1()
  
  
  public static void problem2(){
    HashMap<Integer,Boolean[]> trutTableCollection = new HashMap<>();
//    for(int test = -10; test < 11; ++test) System.out.println(test+" "+(test%5));
    
    
    for(int a =-100; a < 101; ++a){
  
      int sign = (a >=0)?1:-1;
      trutTableCollection.put(a,new Boolean[]{((a*sign)%5==2),((a*a)%5==4),((a*sign)%5==2)==((a*a)%5==4)});
  }
    
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", biconLabel = " p<->q ";
    System.out.println("\n\nProblem #2 truth table");
    System.out.println("Prove or disprove: For all integers n, [(n*n)\u22615 4] if and only" +
                       " if [n\u22615 2].");
    generateTruthTable(trutTableCollection,new String[]{nthrow,pLabel,qLabel,biconLabel},PropositionType.BICON);
  
  } // ends problem2()
  
  public static void problem3(){
    // This problem doesn't require the evaluation of possible number values that could
    // influence how we choose to solve the problem.
  } // ends problem3()
  
  public static void problem4(){
    //Let t, u and v be integers such that t2 + u2 = v2. Prove that at least one of t
    // or u is divisible by 3.
    //(Hint: use contradiction).
  
    // verification of this proof will require a truth table that shows if u or t can be
    // divided evenly by 3 when those numbers are integer square roots of a third sum
    // v, which is again an integer.
    HashMap<Integer,Boolean[]> tTableCollection = new HashMap<>();
    String[] labels = new String[]{
        "v",
        "3|t",
        "3|u",
        "p:∀t,u,v;tt+uu=vv",
        "q:∃t,u;(3|t∨3|u)",
        "~q:∀t,u;(3∤t∧3∤u)",
        "p->q",
        "p∧~q"};
    for(int v = 20; v >-1;--v){
      int t = 0,u = v-1;
  
      int vSquared = v*v;
      while(t < u){
        int tSquared = t*t, uSquared = u*u;
        if((tSquared+uSquared)==(vSquared)){
          tTableCollection.put(v,new Boolean[]{t%3==0,u%3==0,true,t%3==0 || u%3==0,t%3!=0 && u%3!=0, t%3==0 || u%3==0, t%3!=0 && u%3!=0});
          ++t;
          --u;
        }else if(tSquared+uSquared < vSquared)++t;
        else --u;
      }
      
      
    }
    System.out.println("\n\nLet t, u and v be integers such that t^2 + u^2 = v^2. Prove that " +
                       "at least one of t or u is divisible by 3.\n" +
                       "(Hint: use contradiction).");
    
    generateTruthTable(tTableCollection,labels,PropositionType.SINGLE);
    
  } // ends problem4()
  
  private static boolean problem5Helper(Boolean[] boo, boolean onlyPrintFalse){
    boolean doWeHaveFalse = false;
    String[] s = new String []{
        ConsolColor.ylo_bld_brt+"u:[d|a]::",//0
        ConsolColor.ylo_bld_brt+"v:[d|b]::",//1
        ConsolColor.ylo_bld_brt+"s:d|(a+b)::",//2
        ConsolColor.ylo_bld_brt+"t:d|(a-b)::",//3
        ConsolColor.ylo_bld_brt+"p:[u\u2227v]::",//4
        ConsolColor.ylo_bld_brt+"q:[s\u2227t]::",//5
        ConsolColor.ylo_bld_brt+"p->q::",//6
        ConsolColor.ylo_bld_brt+"q->p::",//7
        ConsolColor.ylo_bld_brt+"p<->q::"//8
    };
    for(int i =0; i < boo.length;++i) {
      s[i] += ((boo[i])?ConsolColor.cyan_bld_brt:ConsolColor.rd_bld_brt)+boo[i]+ConsolColor.prpl_bld_brt;
    }
    if(onlyPrintFalse) {
      for (boolean b :
          boo) {
        doWeHaveFalse = !b;
        if(doWeHaveFalse)break;
      }
      if(doWeHaveFalse){
        System.out.printf(ConsolColor.prpl_bld_brt +
                          "[%11s;%11s;]->%11s;\n[%11s;%11s;]->%11s;\n%11s;\n%11s;\n%11s;\n" +
    
                          ConsolColor.RESET,
            s[0], s[1], s[4], s[2], s[3], s[5], s[6], s[7], s[8]);
      }
    }else{
      System.out.printf(ConsolColor.prpl_bld_brt +
                        "[%11s;%11s;]->%11s;\n[%11s;%11s;]->%11s;\n%11s;\n%11s;\n%11s;\n" +
  
                        ConsolColor.RESET,
          s[0], s[1], s[4], s[2], s[3], s[5], s[6], s[7], s[8]);
      
    }
    
    return doWeHaveFalse;
    
  }
  
  public static void problem5(){
    HashMap<Integer,Boolean[]> tTableCollection = new HashMap<>();
    String[] labels = new String[]{
        "d",
        "u:d|a",
        "v:d|b",
        "s:d|(a+b)",
        "t:d|(a-b)",
        "p:∀d,a,b;(u∧b)",
        "q:∃d,a,b;(s∧t)",
        "p->q",
        "q->p",
        "p<->q"
    };
  
    Function<Integer[],Boolean> u_of_da = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_ab) {
        return (d_ab[1])%d_ab[0]==0 ;
      }
    };
  
    Function<Integer[],Boolean> v_of_db = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_ab) {
        return (d_ab[2])%d_ab[0]==0 ;
      }
    };
  
    Function<Integer[],Boolean> s_of_dab = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_ab) {
        return (d_ab[1]+d_ab[2])%d_ab[0]==0 ;
      }
    };
  
    Function<Integer[],Boolean> t_of_dab = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_ab) {
        return (d_ab[1]-d_ab[2])%d_ab[0]==0 ;
      }
    };
    
    Function<Integer[],Boolean> p_of_dab = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_a_b) {
        return d_a_b[1]%d_a_b[0]==0 && d_a_b[2]%d_a_b[0]==0;
      }
    };
  
    Function<Integer[],Boolean> q_of_dab = new Function<Integer[], Boolean>() {
      @Override
      public Boolean apply(Integer[] d_a_b) {
        return (d_a_b[1]+d_a_b[2])%d_a_b[0]==0 && (d_a_b[1]-d_a_b[2])%d_a_b[0]==0;
      }
    };
    boolean printOnlyFalse = true;
    Integer low = Integer.MAX_VALUE,hi = Integer.MIN_VALUE;
    for(int d = 3; d < 30;++d){
      Boolean[] truthRow = new Boolean[]{false,false,false,false,false,false,false,false,false};
      for(int a = -50; a<51;++a){
        for(int b = -50; b<51;++b){
          low = ((d*100+a*10+b) < low)?d*100+a*10+b:low;
          hi = ((d*100+a*10+b)>hi)?d*100+a*10+b:hi;
          Integer[] dab = new Integer[]{d,a,b};
          if(!truthRow[5] &&  p_of_dab.apply(dab)){
            truthRow[0] = u_of_da.apply(dab);
            truthRow[1] = v_of_db.apply(dab);
            truthRow[2] = s_of_dab.apply(dab);
            truthRow[3] = t_of_dab.apply(dab);
            truthRow[4] = p_of_dab.apply(dab);
            truthRow[5] = q_of_dab.apply(dab);
            truthRow[6] = truthRow[0] && truthRow[1];
            truthRow[7] = truthRow[2] && truthRow[3];
            truthRow[8] = truthRow[6] && truthRow[7];
            if(problem5Helper(truthRow, printOnlyFalse))System.out.printf("d = %4d; a = %4d; b = %4d;\n",d,a,b);
            tTableCollection.put(d,truthRow);
            truthRow = new Boolean[]{false,false,false,false,false,false,false,false,false};
          }else if(!truthRow[4] && q_of_dab.apply(dab)){
            
            truthRow[0] = u_of_da.apply(dab);
            truthRow[1] = v_of_db.apply(dab);
            truthRow[2] = s_of_dab.apply(dab);
            truthRow[3] = t_of_dab.apply(dab);
            truthRow[4] = p_of_dab.apply(dab);
            truthRow[5] = q_of_dab.apply(dab);
            truthRow[6] = truthRow[0] && truthRow[1];
            truthRow[7] = truthRow[2] && truthRow[3];
            truthRow[8] = truthRow[6] && truthRow[7];
            if(problem5Helper(truthRow, printOnlyFalse))System.out.printf("d = %4d; a = %4d; b = %4d;\n",d,a,b);
            tTableCollection.put(d,truthRow);
            truthRow = new Boolean[]{false,false,false,false,false,false,false,false,false};
          }
        }
      }
    }
    
    /*
        "d",
        0"d|a",
        1"d|b",
        2"d|(a+b)",
        3"d|(a-b)",
        4"p:\u2200d,a,b;(d|a\u2227d|b)",
        5"q:\u2203d,a,b;(d|(a+b)\u2227d|(a-b))",
        6"p->q",
        7"q->p",
        8"p<->q"*/
    System.out.println("\n\nLet a and b be integers, and let d be odd. Prove that [d|a\u2227d|b] <-> [d|(a + b)\u2227d|(a - b)].");
  
    generateTruthTable(tTableCollection,labels,PropositionType.SINGLE);
  }
  
}
