import com.ConsolColor;

import java.util.Arrays;
import java.util.stream.IntStream;

public
class A5P6
{
  private String A_DIVS_B = ConsolColor.cyan_brt;
  
  private String B_DIVS_A = ConsolColor.rd_brt;
  
  private String FAIL = ConsolColor.blk_bld_brt;
  
  public
  A5P6(int loBound, int hiBound) {
    
    StringBuilder sb = new StringBuilder();
    int width = Math.max( String.valueOf( loBound ).length(), String.valueOf( hiBound ).length() )+1;
//    width += loBound <0?0:1;
    String winStr = ConsolColor.grn_brt ;
    
    int header = loBound;
    sb.append(String.format( "%"+( width + 1 )+"s| %"+ width +"s"," ",""+header++ ));
    while(header <= hiBound)sb.append( String.format("%"+(width /*+ (header < 0 ? 1:0)*/)+"S",""+header++) );
    String dashRow = String.format( "\n%" + sb.length() + "s", " " ).replace( " ", "-" );
    sb.append( dashRow );
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
    for(int i = 0; i + loBound <= hiBound; ++i){
      int a = i + loBound;
      sb.append(String.format("\n%"+width+"d |"+(loBound<0?"":" "),a));
      for(int j = 0; j +loBound <= hiBound; ++j){
        int b = j + loBound;
        boolean A = a!=0 && b != 0 && b % a == 0, B = a != 0 && b != 0 && a % b == 0;
        if(A && B) sb.append( winStr + String.format( "%" + (width /*+ (b < 0? 1:0)*/)+ "s", "1" ) + ConsolColor.RESET );
        else if (A) sb.append(
          B_DIVS_A + String.format( "%" + (width /*+ ( b < 0? 1 : 0 )*/)+ "S", "1" ) +
          ConsolColor.RESET );
        else if (B) sb.append(
            A_DIVS_B + String.format( "%" + (width /*+ ( b < 0? 1 : 0 )*/) + "S", "1" ) +
            ConsolColor.RESET );
          else if(a == 0 && b == 0)sb.append(
              String.format( "%" + ( width /*+ (b < 0 ? 1 : 0)*/ ) + "s", "0" ) );
            else sb.append( FAIL + String.format( "%" + (width /*+ (b < 0 ? 1 : 0)*/ ) + "s", ((a == 0 || b == 0)?".":" ") ) + ConsolColor.RESET );
      }
    }
    sb.insert( 0, "\n\n" + ConsolColor.cyan_brt + "denotes where only a|b" + ConsolColor.RESET + "\n" +
                  ConsolColor.rd_brt + "denotes where only b|a"+ ConsolColor.RESET +
                  "\n"+ ConsolColor.grn_brt + "denotes where a|b AND b|a\n\n");
    System.out.println(sb.toString());
  }
  
  A5P6(int aLo, int aHi, int bLo, int bHi){
    
    int width = Math.max( String.valueOf( aLo ).length(), String.valueOf( aHi ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( bLo ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( bHi ).length() ) +((bLo < 0)?2:1);
    String winStr = ConsolColor.grn_brt;
    
    StringBuilder sbSpaced = new StringBuilder();
    StringBuilder sbPacked = new StringBuilder();
    
    String
      aAxisBounds = "\na is represented by the vertical axis, in the range of ["+aLo+","+aHi+"]",
      bAxisBounds = "\nb is represented by the horizontal axis, in the range of ["+bLo+","+bHi+"]\n\n";
    
    sbSpaced.append( "\n\n"+ConsolColor.cyan_brt+"denotes where only a|b"+ConsolColor.RESET+"\n"+
               ConsolColor.rd_brt+"denotes where only b|a"+ConsolColor.RESET+
               "\n"+ConsolColor.grn_brt+"denotes where a|b AND b|a\n\n"+ConsolColor.RESET );
    sbSpaced.append( aAxisBounds ).append( bAxisBounds );
    
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
    for( int i = aHi; i >= aLo; --i ) {
      sbPacked.append( String.format( "%"+(width-2)+"s","" ) );
      int a = i;
      for( int j = 0; j + bLo <= bHi; ++ j ) {
        int b = j + bLo;
        boolean A = false,B = false;
        if( a != 0 && b != 0) {
          A = b % a == 0;
          B = a % b == 0;
        }
        
        if( A && B ) {
          sbPacked.append( winStr ).append( "  1" )
                  .append( ConsolColor.RESET );
          sbSpaced
            .append( winStr +String.format( "%"+( width /*+ (b < 0? 1:0)*/ )+"s", "1" ) )
            .append( ConsolColor.RESET );
        }
        else if( A ) {
          
          sbPacked.append( B_DIVS_A+ "  1")
                  .append( ConsolColor.RESET );
          sbSpaced
            .append( B_DIVS_A + String.format( "%" + ( width /*+ ( b < 0? 1 : 0 )*/ ) + "s", "1" ) )
            .append( ConsolColor.RESET );
        }
        else if( B ){
    
            sbPacked.append( A_DIVS_B+"  1" )
                    .append( ConsolColor.RESET );
          sbSpaced
            .append( A_DIVS_B + String.format( "%" + ( width /*+ ( b < 0? 1 : 0 )*/ ) + "s", "1" ) )
            .append( ConsolColor.RESET );
        }
        else if( a == 0 ^ b == 0 ) {
          String nonZeroVal = String.format( "%"+( width /*+ (b < 0? 1:0)*/ )+"s", a != 0? String.valueOf( a ) : String.valueOf( b ));
          sbSpaced
            .append( FAIL+String.format(
              "%"+( width /*+ (b < 0 ? 1 : 0)*/ )+"s",
              nonZeroVal ) )
            .append( ConsolColor.RESET );
          sbPacked.append( ( ( a == 0 )? String.format( " %2s", String.valueOf( Math.abs(b)) ) : "" ) );
          
          }
        else if(a == 0){
          // implicitly, both a and b must be 0 if either is zero at this point in the if chain
          sbPacked.append( "   " );
          sbSpaced.append( String.format( "%"+( width /*+ (b < 0 ? 1 : 0)*/ )+"s", "0" ) );
        }
        else {
          sbPacked.append( "   " );
          sbSpaced.append( String.format( "%" + ( width /*+ (b < 0 ? 1 : 0)*/ ) + "s", " " ) );
        }
        
      }
      sbSpaced.append( "\n" );
      sbPacked.append( String.format( "%6s\n",String.valueOf( Math.abs(a) ) ) );
    }
    System.out.println( sbSpaced.toString() );
    System.out.println();
    System.out.println();
    System.out.println(sbPacked.toString());
  }
}
