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
        
//        if( b < 0 && a < 0 ) locSymbol = "3";
//        else if( b < 0 ) locSymbol = "4";
//        else if( a < 0 ) locSymbol = "2";
//        else locSymbol = "1";
        
        boolean A = false, B = false;
        if( b != 0 && a != 0 ) {
          A = Math.abs(a/b) >0 && a % b == 0;
          B = Math.abs(b/a) >0 && b % a == 0;
        }
      
        if( A && B ) {
          sbPacked.append( winStr )
                  .append( locSymbol )
                  .append( " " )
                  .append( ConsolColor.RESET );
          sbSpaced
            .append( winStr )
            .append(String.format( "%-"+( ( ( a == -1 )? width-1 : width ) )+"s", locSymbol ) )
            .append( ConsolColor.RESET );
        }
        else
          if( A ) {
          
            sbPacked.append( B_DIVS_A )
                    .append( locSymbol )
                    .append( " " )
                    .append( ConsolColor.RESET );
            
            sbSpaced.append( B_DIVS_A )
                    .append( String.format( "%-"+( ( ( a == -1 )? width-1 : width ))+"s", locSymbol ) )
                    .append( ConsolColor.RESET );
          }
          else
            if( B ) {
            
              sbPacked.append( A_DIVS_B )
                      .append( locSymbol )
                      .append( " " )
                      .append( ConsolColor.RESET );
              
              sbSpaced.append(A_DIVS_B )
                      .append( String.format( "%-" + ( ((a == -1)?width-1:width) ) + "s", locSymbol ) )
                      .append( ConsolColor.RESET );
            }
            else
              if( b == 0 ^ a == 0 ) {
                String nonZeroVal = String.format(
                  "%-" + ( width  ) + "s",
                  b != 0? (((b > 0)? " ":"")+String.valueOf( b )) : String.valueOf( a ) );
                sbSpaced
                  .append( FAIL )
                  .append(  nonZeroVal )
                  .append( ConsolColor.RESET );
//          sbPacked.append( ( ( a == 0 )? String.format( " %2s", String.valueOf( Math.abs(b)) ) : "" ) );
                sbPacked.append( FAIL )
                        .append( ( ( b == 0 )? "--" : "| " ) )
                        .append( ConsolColor.RESET );
              
              }
              else
                if( b == 0 ) {
                  // implicitly, both a and b must be 0 if either is zero at this point in the if block
                  sbPacked.append( FAIL )
                          .append( "0-" )
                          .append( ConsolColor.RESET );
                
                  sbSpaced.append(
                    String.format( "%-" + ( width ) + "s", " 0" ) );
                }
                else {
                  sbPacked.append( ((a == -1)?" ":"  ") );
                  sbSpaced.append(
                    String.format( "%-" + ( width ) + "s", " " ) );
                }
      
      }
      sbSpaced.append( "\n" );
      sbPacked.append( "\n" );
    }
    System.out.println( sbSpaced.toString() );
    System.out.println( sbPacked.toString() );
  }
  
  A5P6(){
    this(-20,20,-20,20);
  }
  
}
