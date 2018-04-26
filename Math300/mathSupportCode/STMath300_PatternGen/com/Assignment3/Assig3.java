package com.Assignment3;

import Statics.StaticTTablePrinter;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.function.Function;

import static Statics.StaticTTablePrinter.*;


public class Assig3
{
  
  
  
  private static PropositionType staticPT;
  /*
  * cheat sheet for getting operators from ansi code:
  * prefix the alpha-numeric codes for your chosen symbol with
  * \\u  , that is to say, if we wanted to write
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

  */
  
  
  public static void problem1() {
    
    problem1( null );
  }
  
  
  public static void problem1( StyledDocument doc ) {
    
    Function<Integer,Integer> p_of_n = n -> ( 2 * n + 2 );
    LinkedHashMap<Integer[],Boolean[]> truthTableCollection = new LinkedHashMap<>();
    for( int i = - 10; i < 11; ++ i ) {
      int sign = ( i < 0 )? - 1 : 1;
      boolean p = p_of_n.apply( i ) % 3 == 0, q = ( ( ( i ) % 3 == 2 ) || ( ( i ) % 3 == - 1 ) );
      
      boolean pnoq = p && ! q, pq = ! p || q;
      truthTableCollection.put( new Integer[]{ i }, new Boolean[]{
          p,// plabel
          q,// qlabel
          pnoq,//contra
          pq
      } );
    }
    
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", propLabel = " p->q ", contra =
        "p∧(~q)";
    
    if( doc == null ) {
      
      
      System.out.println( "\n\nProblem #1 truth table\n" +
                          "Prove or disprove: For all integers n, if [3|(2n + 2)], then [n\u22613" +
                          " 2]." );
      generateTruthTable( truthTableCollection, new String[]{
          nthrow, pLabel, qLabel, contra, propLabel
      }, PropositionType.SINGLE, 1 );
    }
    else {
      
      try {
        doc.insertString( doc.getLength(),
                          "\n\nProblem #1 truth table\n" +
                          "Prove or disprove: For all integers n, if `[3|(2n + 2)]`, then `[n≡3 " +
                          "2]`.",
                          doc.getStyle( INIT_STYLES[ 0 ] ) );
        StaticTTablePrinter.generateTruthTable( truthTableCollection, new String[]{
            nthrow, pLabel, qLabel, contra, propLabel
        }, doc );
      }catch( BadLocationException e ) {
        e.printStackTrace();
      }
    }
  } // ends problem1()
  
  
  public static void problem2() {
    
    LinkedHashMap<Integer[],Boolean[]> trutTableCollection = new LinkedHashMap<>();
//    for(int test = -10; test < 11; ++test) System.out.println(test+" "+(test%5));
    
    
    for( int a = - 15; a < 16; ++ a ) {
      
      int sign = ( a >= 0 )? 1 : - 1; trutTableCollection.put( new Integer[]{ a }, new Boolean[]{
          ( ( a * sign ) % 5 == 2 ), ( ( a * a ) % 5 == 4 ),
          ( ( a * sign ) % 5 == 2 ) == ( ( a * a ) % 5 == 4 )
      } );
    }
    
    
    
    String nthrow = " n ", pLabel = " p(n) ", qLabel = " q(n) ", biconLabel = " p<->q ";
    
    System.out.println( "\n\nProblem #2 truth table" ); System.out.println(
        "Prove or disprove: For all integers n, [(n*n)\u22615 4] if and only" +
        " if [n\u22615 2]." );
    generateTruthTable( trutTableCollection, new String[]{
        nthrow, pLabel, qLabel, biconLabel
    }, PropositionType.BICON, 2 );
    
  } // ends problem2()
  
  public static void problem3() {
    /*
     This problem doesn't require the evaluation of possible number values that could
     influence how we choose to solve the problem.
    */
  } // ends problem3()
  
  public static void problem4() {

//    boolean printJustification = false;
    //Let t, u and v be integers such that t2 + u2 = v2. Prove that at least one of t
    // or u is divisible by 3.
    //(Hint: use contradiction).
    
    // verification of this proof will require a truth table that shows if u or t can be
    // divided evenly by 3 when those numbers are integer roots of a third sum
    // v, which is again an integer.
    LinkedHashMap<Integer[],Boolean[]> tTableCollection = new LinkedHashMap<>( 100 );
    TreeSet<String> setOfVTU = new TreeSet<>();
    
    String[] labels = new String[]{
        "v", "t", "u", "3|t", "3|u", "p:t,u,v S.T.tt+uu=vv", "q:t,u S.T.(3|t∨3|u)",
        "~q:t,u; S.T.(3∤t∧3∤u)",
        
        "p∧~q", "p->q"
    };
    
    // iterate v from 20 to 0; for each iteration of v, we
    // then look for t, and u integers such that t^2 + u^2 = v^2;
    for( int v = 20; v > 1; --v ) {
      for( int t = -v * 5; t < v * 5 + 1; ++t ) {
        if( t == 0 ) { continue; }
        for( int u = -t; u > t-1; --u ) {
          
          if( u == 0 ) continue;
          int vSquared = v * v, tSquared = t * t, uSquared = u * u;
          
          boolean tbool = Math.abs( t ) % 3 == 0,//3|t
              ubool = Math.abs( u ) % 3 == 0,//3|u
              p = vSquared == ( tSquared + uSquared ),//p
              q = ( tbool || ubool ),//q
              noQ = ( ! tbool && ! ubool ),//!q
              pAndNoQ = ( ! tbool && ! ubool ),//p !q
              pAndQ = ( tbool || ubool );//p->q
          if( setOfVTU.add( v + " " + t + " " + u ) && setOfVTU.add( v + " " + u + " " + t ) ) {
            if( ( p) ) {
              if(q) {
                tTableCollection.put( new Integer[]{ v, t, u }, new Boolean[]{
                    tbool,//3|t
                    ubool,//3|u
                    p, q, noQ, pAndNoQ, pAndQ } );
              }
            }
          }
        }
      }
    } System.out.println(
        "\n\nProblem #4 truth table\nLet t, u and v be integers such that t^2 + u^2 = v^2.\n" +
        "Prove that at least one of t or u is divisible by 3.\n" + "(Hint: use contradiction)." );
    
    generateTruthTable( tTableCollection, labels, PropositionType.SINGLE, 4 );
    
  } // ends problem4()
  
  private static boolean problem5Helper( Boolean[] boo, boolean onlyPrintFalse ) {
    
    boolean doWeHaveFalse = false; String[] s = new String[]{
        ConsolColor.ylo_bld_brt + "u:[d|a]::",//0
        ConsolColor.ylo_bld_brt + "v:[d|b]::",//1
        ConsolColor.ylo_bld_brt + "s:d|(a+b)::",//2
        ConsolColor.ylo_bld_brt + "t:d|(a-b)::",//3
        ConsolColor.ylo_bld_brt + "p:[u\u2227v]::",//4
        ConsolColor.ylo_bld_brt + "q:[s\u2227t]::",//5
        ConsolColor.ylo_bld_brt + "p->q::",//6
        ConsolColor.ylo_bld_brt + "q->p::",//7
        ConsolColor.ylo_bld_brt + "p<->q::"//8
    }; for( int i = 0; i < boo.length; ++ i ) {
      s[ i ] += ( ( boo[ i ] )? ConsolColor.cyan_bld_brt : ConsolColor.rd_bld_brt ) + boo[ i ] +
                ConsolColor.prpl_bld_brt;
    } if( onlyPrintFalse ) {
      for( boolean b : boo ) {
        doWeHaveFalse = ! b;
        if( doWeHaveFalse ) { break; }
      }
      
      if( doWeHaveFalse ) {
        System.out.printf( ConsolColor.prpl_bld_brt +
                           "[%11s;%11s;]->%11s;\n[%11s;%11s;]->%11s;\n%11s;\n%11s;\n%11s;" +
                           "\n" + ConsolColor.RESET,
                           s[ 0 ], s[ 1 ], s[ 4 ], s[ 2 ], s[ 3 ], s[ 5 ], s[ 6 ], s[ 7 ], s[ 8 ] );
      }
    } else {
      System.out.printf( ConsolColor.prpl_bld_brt +
                         "[%11s;%11s;]->%11s;\n[%11s;%11s;]->%11s;\n%11s;\n%11s;\n%11s;" +
                         "\n" + ConsolColor.RESET,
                         s[ 0 ], s[ 1 ], s[ 4 ], s[ 2 ], s[ 3 ], s[ 5 ], s[ 6 ], s[ 7 ], s[ 8 ] );
      
    }
    
    return doWeHaveFalse;
    
  }
  
  @SuppressWarnings({ "SingleStatementInBlock", "Duplicates" })
  public static void problem5() {
    LinkedHashMap<Integer[],Boolean[]> tTableCollection = new LinkedHashMap<>();
    TreeSet<String> setOfDAB = new TreeSet<>();
    TreeSet<String> altFilter = new TreeSet<>();
    String[] labels = new String[] {
        "d", "a", "b", "u:d|a", "v:d|b", "s:d|(a+b)",
        "t:d|(a-b)", "p:d,a,b;(u∧b)", "q:d,a,b;(s∧t)",
        "p->q", "q->p", "p<->q"
    };
    
    Function<Integer[],Boolean> u_of_da = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        return ( dab[ 1 ] ) % dab[ 0 ] == 0;
      }
    };
    
    Function<Integer[],Boolean> v_of_db = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        return ( dab[ 2 ] ) % dab[ 0 ] == 0;
      }
    };
    
    Function<Integer[],Boolean> s_of_dab = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        return ( dab[ 1 ] + dab[ 2 ] ) % dab[ 0 ] == 0;
      }
    };
    
    Function<Integer[],Boolean> t_of_dab = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        return ( dab[ 1 ] - dab[ 2 ] ) % dab[ 0 ] == 0;
      }
    };
    
    Function<Integer[],Boolean> p_of_dab = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        return dab[ 1 ] % dab[ 0 ] == 0 && dab[ 2 ] % dab[ 0 ] == 0;
      }
    };
    
    Function<Integer[],Boolean> q_of_dab = new Function<Integer[],Boolean>() {
      @Override public Boolean apply( Integer[] dab ) {
        
        return ( dab[ 1 ] + dab[ 2 ] ) % dab[ 0 ] == 0 &&
               ( dab[ 1 ] - dab[ 2 ] ) % dab[ 0 ] == 0;
      }
    };
    
    for( int d = 3; d < 30; d += 2 ) {
      Boolean[] truthRow = new Boolean[]{
          false, false, false, false, false, false, false, false, false
      };
      
      for( int a = 20; a > -21; --a ) {
//        if(a == 0)continue;
        for( int b = 20; b > -21; --b ) {
//          if(b == 0)continue;
          Integer[] dab = new Integer[]{ d, a, b };
          
          truthRow[ 0 ] = u_of_da.apply( dab );// u: d|a
          truthRow[ 1 ] = v_of_db.apply( dab );// v: d|b
          truthRow[ 2 ] = s_of_dab.apply( dab );// s: d|(a+b)
          truthRow[ 3 ] = t_of_dab.apply( dab );// t: d|(a-b)
          truthRow[ 4 ] = p_of_dab.apply( dab );// p: u AND v
          truthRow[ 5 ] = q_of_dab.apply( dab );// q: s AND t
          truthRow[ 6 ] = (truthRow[ 4 ])? truthRow[ 5 ] : true;// p->q
          truthRow[ 7 ] = ( truthRow[ 5 ] )? truthRow[ 4 ] : true;//q->p
          truthRow[ 8 ] = truthRow[ 5 ] && truthRow[ 4 ];// p<->q
          
          if( setOfDAB.add( d + " " + a + " " + b ) && setOfDAB.add( d + " " + b + " " + a ) ) {
//            if( (truthRow[6] && !truthRow[7]) || ( truthRow[ 7 ] && !truthRow[ 6 ] )) {
            if(truthRow[4] || truthRow[5]){
              if(truthRow[6] != truthRow[7]){
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
                8"p<->q"
              */
                tTableCollection.put( new Integer[]{ d, a, b }, truthRow );
    
                truthRow =
                    new Boolean[]{ false, false, false, false, false, false, false, false, false };
              }
            }
          }
        }
      }
    }
    
    System.out.println(
        "\n\nProblem #5\nLet a and b be integers, and let d be odd.\n" +
        "Prove that [d|a\u2227d|b] <-> [d|(a + b)\u2227d|(a - b)]." );
    
    generateTruthTable( tTableCollection, labels, PropositionType.SINGLE, 5 );
  }
}
