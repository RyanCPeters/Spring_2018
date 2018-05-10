import com.ConsolColor;

import java.util.Arrays;
import java.util.stream.IntStream;

public
class A5P6
{
  private String A_DIVS_B = ConsolColor.cyan_brt;
  
  private String B_DIVS_A = ConsolColor.rd_brt;
  
  private String FAIL = ConsolColor.blk_bld_brt;
  
  private String winStr = ConsolColor.grn_brt;
  
  
  A5P6(int aLo, int aHi, int bLo, int bHi){
    
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
      "\n"+ConsolColor.cyan_brt+"denotes where only a|b"+ConsolColor.RESET+"\n"+
      ConsolColor.rd_brt+"denotes where only b|a"+ConsolColor.RESET+
      "\n"+ConsolColor.grn_brt+"denotes where a|b AND b|a\n"+ConsolColor.RESET )
            .append( aAxisBounds ).append( bAxisBounds )
            .append("Figure 6.1: Stretched version of graph showing (a,b) values on the zeros." +
                    "\nWhere a is the horizontal-axis, and b is the vertical-axis.\n" );
    
    sbPacked.append(
      "\n" + ConsolColor.cyan_brt + "denotes where only a|b" + ConsolColor.RESET + "\n" +
      ConsolColor.rd_brt + "denotes where only b|a" + ConsolColor.RESET +
      "\n" + ConsolColor.grn_brt + "denotes where a|b AND b|a\n" + ConsolColor.RESET )
            .append( aAxisBounds ).append( bAxisBounds )
            .append( "Figure 6.2: Square graph for better visual understanding of ratios.\n" );
    
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
      if(b != 0)sbSpaced.append( " " );
      for( int a = aLo; a <= aHi; ++a ) {
        String locSymbol = "H";
        
        boolean AbyB = b!=0 && a%b == 0;
        boolean BbyA = a!=0 && b % a == 0;
        
        sbPacked.append( ((AbyB && BbyA)?winStr:(AbyB?B_DIVS_A:(BbyA?A_DIVS_B:FAIL))) );
        
        if( AbyB && BbyA) {
          sbPacked.append( locSymbol )
                  .append( " " );
          
          sbSpaced.append(String.format( "%-"+( ( ( a == -1 )? width-1 : width ) )+"s", locSymbol ) );
        }else if( AbyB ) {
          
          sbPacked.append( locSymbol )
                  .append( " " );
          
          sbSpaced.append( String.format( "%-"+( ( ( a == -1 )? width-1 : width ))+"s", locSymbol ) );
        }else if( BbyA ) {
          
          sbPacked.append( locSymbol )
                  .append( " " );
          
          sbSpaced.append( String.format( "%-" + ( ((a == -1)?width-1:width) ) + "s", locSymbol ) );
          
        }else if( b == 0 ^ a == 0 ) {
          String nonZeroVal = String.format(
            "%-" + ( width  ) + "s",
            b != 0? (((b > 0)? " ":"")+String.valueOf( b )) : String.valueOf( a ) );
          sbSpaced.append(  nonZeroVal );
          
          sbPacked.append( ( ( b == 0 )? "--" : "| " ) );
          
        }else if( b == 0 ) {
          // implicitly, both a and b must be 0 if either is zero at this point in the if block
          sbPacked.append( "0-" );
          
          sbSpaced.append(
            String.format( "%-" + ( width ) + "s", " 0" ) );
        }else {
          sbPacked.append( ((a == -1)?":":": ") );
          sbSpaced.append(String.format( "%-" + ( width ) + "s", ":" ) );
        }
        
      }
      sbSpaced.append( ConsolColor.RESET)
              .append( "\n" );
      
      sbPacked.append( ConsolColor.RESET )
              .append( "\n" );
    }
    System.out.println( sbSpaced.toString() );
    System.out.println( sbPacked.toString() );
  }
  
  A5P6(){
    this(-20,20,-20,20);
  }
  
}
