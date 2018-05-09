import com.ConsolColor;

/**
 <pre>
    i)  Determine which of the three properties (reflexive, symmetric, transitive)
        R satises.
        Be sure to briefly justify your answers.
 
    ii) If R is an equivalence relation, determine the equivalence classes of R.
 
    7. {@code R = {(a, b)∈ ZxZ such that 3|(a + 2b)}}
 
 </pre>
 */
public
class A5P7
{
  
  private String B2A = ConsolColor.cyan_brt;
  
  private String A2B = ConsolColor.rd_brt;
  
  private String FAIL = ConsolColor.blk_bld_brt;
  
  private String winStr = ConsolColor.grn_brt;
  
  private boolean does3Divide(int a, int b){
    return ((a+2*b) == 0)||(Math.abs(a + 2*b)/3 >= 1 && Math.abs( a + 2 * b )%3 ==0);
  }
  
  public
  A5P7() {
    this(-20,20,-20,20);
  }
  
  A5P7(int aLo, int aHi, int bLo, int bHi){
  
    int width = Math.max( String.valueOf( aLo ).length(), String.valueOf( aHi ).length() );
  
    width = Math.max( String.valueOf( width ).length(), String.valueOf( bLo ).length() );
  
    width = Math.max( String.valueOf( width ).length(), String.valueOf( bHi ).length() ) +
            ( ( bLo < 0 )? 2 : 1 );
    int packedWidth = width - ( ( bLo < 0 )? 2 : 1 );
  
    StringBuilder sbSpaced = new StringBuilder();
    StringBuilder sbPacked = new StringBuilder();
  
    String
      aAxisBounds =
        "\nb is represented by the vertical axis, in the range of   [" + bLo + "," + bHi + "]",
      bAxisBounds =
        "\na is represented by the horizontal axis, in the range of [" + aLo + "," + aHi + "]\n\n";
 
    sbSpaced.append(
      "\n"+ConsolColor.cyan_brt+"denotes where 3|(a +2b) and a < b"+ConsolColor.RESET+
      "\n"+ConsolColor.rd_brt+"denotes where 3|(a +2b) and a > b"+ConsolColor.RESET+
      "\n"+ConsolColor.grn_brt+"denotes where 3|(a +2b) and a == b\n\n"+ConsolColor.RESET )
            .append( aAxisBounds ).append( bAxisBounds )
            .append( "Figure 7.1: Stretched version of graph showing (a,b) values on the axis."+
                     "\nWhere a is the horizontal-axis, and b is the vertical-axis.\n" );
  
    sbPacked.append(
      "\n"+ConsolColor.cyan_brt+"denotes where 3|(a +2b) and a < b"+ConsolColor.RESET+
      "\n"+ConsolColor.rd_brt+"denotes where 3|(a +2b) and a > b"+ConsolColor.RESET+
      "\n"+ConsolColor.grn_brt+"denotes where 3|(a +2b) and a == b\n\n"+ConsolColor.RESET )
            .append( aAxisBounds ).append( bAxisBounds )
            .append( "Figure 7.2: Square graph for better visual understanding of ratios.\n" );
    
    int packedEntryWidth = 1;
    
    // generating a matrix of binary values that represent whether
    // a|b or b|a.
    //
    //  prints 1 if true
    //  prints 0 if false
    // let i represent the row number in the matrix, and map to the
    // a values on the given low to hi bounds.
    //
    // let j represent the column number in the matrix, and map the
    // b values on the given low to hi bounds.
    for( int b = bHi; b >= bLo; --b ) {
      if(b!=0)sbSpaced.append( String.format( "%1s","" ) );
      for( int a = aLo; a <= aHi; ++a ) {
        String locSymbol = "H";
//        String locSymbol = "1";
//
//        if( a < 0 && b < 0 ) locSymbol = "3";
//        else if( a < 0 ) locSymbol = "4";
//        else if( b < 0 ) locSymbol = "2";

//        boolean a2b = does3Divide( a, b ), b2a = does3Divide( a, b );
        boolean a2b = does3Divide( b,a );
        
        sbPacked.append( ( (b == 0 && a == 0)?FAIL:
                           ( a2b /*&& b2a*/ )?
                           ( (b < a)? A2B:( b == a )? winStr: B2A) :
                           ( /*( a2b )? A2B : */ /*( b2a )? B2A :*/ FAIL ) ) );
        
        sbSpaced.append( ( ( b == 0 && a == 0 )? "" :
                           ( a2b /*&& b2a*/ )?
                           ( ( b < a )? A2B : ( b == a )? winStr : B2A ) :
                           ( /*( a2b )? A2B :*/ /*( b2a )? B2A :*/ FAIL ) ) );
        
        if(b == 0 && a == 0){
          sbPacked.append( ConsolColor.RESET )
                  .append( "0" )
                  .append( FAIL )
                  .append( "-" )
                  .append( ConsolColor.RESET );
          
  
          sbSpaced.append( String.format( ConsolColor.RESET+"%-" + ( width ) + "s", " 0" ) );
        } else if( b == 0 ^ a == 0 ) {
          String nonZeroVal = (b!=0)?
                              (String.valueOf( b )) :
                              String.valueOf( a );
          if( a == 0 && b > 0 )sbSpaced.append( String.format( "%-4s", (" "+nonZeroVal) ) );
          else sbSpaced.append( String.format( "%-4s", nonZeroVal ) );
          
          sbSpaced.append( ConsolColor.RESET );
          
          sbPacked.append( ( ( b == 0 )? "--" : "| " ) )
                  .append( ConsolColor.RESET );
    
        }else if( a2b /*&& b2a*/ ) {
          sbPacked.append( locSymbol )
                  .append( " " )
                  .append( ConsolColor.RESET );
          if(a == -1)sbSpaced.append( String.format( "%-" + ( width-1 ) + "s", locSymbol ) );
          else sbSpaced.append( String.format( "%-"+( width )+"s", locSymbol ) );
          
          sbSpaced.append( ConsolColor.RESET );
        }else {
          sbPacked.append( "  " );
          if(a == -1)sbSpaced.append( String.format( "%-" + ( width-1 ) + "s", " " ) );
          else sbSpaced.append( String.format( "%-"+( width )+"s", " " ) );
        }
      
      }
      sbSpaced.append( ConsolColor.RESET ).append( "\n" );
      sbPacked.append(ConsolColor.RESET).append( "\n" );
    }
    System.out.println( sbSpaced.toString() );
    System.out.println( sbPacked.toString() );
  }
  
}
