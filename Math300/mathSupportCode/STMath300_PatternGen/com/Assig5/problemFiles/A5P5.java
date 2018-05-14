package Assig5.problemFiles;

import com.ConsolColor;

public
class A5P5
{
  
  private String MOD0 = ConsolColor.cyan_brt;
  
  private String MOD1 = ConsolColor.rd_brt;
  
  private String FAIL = ConsolColor.blk_bld_brt;
  
  private String winStr = ConsolColor.grn_brt;
  
  private
  boolean checkCongruence( int a, int b, int n ) {
    
    return (a == b) || ((a*a)%n == (b*b)%n);
  }
  
  public
  A5P5() {
    this( -20, 20, -20, 20 );
  }
  
  A5P5( int xLo, int xHi, int yLo, int yHi ) {
    
    
    int width = Math.max( String.valueOf( xLo ).length(), String.valueOf( xHi ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( yLo ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( yHi ).length()  )+1;
    
    StringBuilder sbSpaced = new StringBuilder();
    StringBuilder sbPacked = new StringBuilder();
    
    String
      bAxisBounds =
      "\nb is represented by the vertical axis, in the range of   ["+yLo+","+yHi+"]\n\n",
      aAxisBounds =
        "\na is represented by the horizontal axis, in the range of ["+xLo+","+xHi+"]";
    
    sbSpaced.append(
      "\n"+ConsolColor.cyan_brt+"denotes where a^2 ≡3 b^2 ≡3 0 "+ConsolColor.RESET+
      "\n"+ConsolColor.rd_brt+"denotes where a^2 ≡3 b^2  ≡3 1"+ConsolColor.RESET+
      "\n"+ConsolColor.grn_brt+"denotes where a^2 ≡3 b^2 and a == b"+ConsolColor.RESET+
      "\n"+ConsolColor.blk_bld_brt+"denotes where a^2 and b^2 are NOT congruent mod 3\n\n"+ConsolColor.RESET)
            .append( aAxisBounds )
            .append( bAxisBounds )
            .append( "Figure 5.1: Stretched version of graph showing (a,b) values on the axis."+
                     "\nWhere a is the horizontal-axis, and b is the vertical-axis.\n" );
    
    sbPacked.append(
      "\n"+ConsolColor.cyan_brt+"denotes where a^2 ≡3 b^2 ≡3 0 "+ConsolColor.RESET+
      "\n"+ConsolColor.rd_brt+"denotes where a^2 ≡3 b^2  ≡3 1"+ConsolColor.RESET+
      "\n"+ConsolColor.grn_brt+"denotes where a^2 ≡3 b^2 and a == b"+ConsolColor.RESET+
      "\n"+ConsolColor.blk_bld_brt+"denotes where a^2 and b^2 are NOT congruent mod 3\n\n"+
      ConsolColor.RESET )
            .append( aAxisBounds )
            .append( bAxisBounds )
            .append( "Figure 5.2: Square graph for better visual understanding of ratios.\n" );
    
    
    // generating a matrix of binary values that represent whether
    // a^2 is congruent to b^2 mod 3
    //
    // let b represent the row number in the matrix, and map to the
    // a values on the given low to hi bounds.
    //
    // let a represent the column number in the matrix, and map the
    // b values on the given low to hi bounds.
    for( int b = yHi; b >= yLo; --b ) {
      if( b != 0 && xLo < 0 ) sbSpaced.append( String.format( "%2s", "" ) );
      for( int a = xLo; a <= xHi; ++a ) {
        String
          locSymbol = "H",
          aStr = String.valueOf(Math.abs(a)),
          bStr = String.valueOf( Math.abs( b ) );
        
        boolean abCongruent = checkCongruence( b, a, 3 );
        
        sbPacked.append( (
                           ( abCongruent )?
                           ( ( ( a*a )%3 == 1 )? MOD1 : ( b == a )? winStr : ( ( a*a )%3 == 0 )? MOD0 : FAIL ) :
                           ( FAIL ) ) );
        
        sbSpaced.append( (
                           ( abCongruent )?
                           ( ( (a*a)%3==1 )? MOD1 : ( b == a )? winStr :((a*a)%3==0)? MOD0:FAIL ) :
                           ( FAIL ) ) );
        
        if( b == 0 && a == 0 ) {
          sbPacked.append( ConsolColor.RESET )
                  .append( "0" )
                  .append( FAIL )
                  .append( "-" )
                  .append( ConsolColor.RESET );
          
          
          sbSpaced.append( String.format( ConsolColor.RESET+"%-"+( width )+"s", "0" ) );
        }else
          if( b == 0 ^ a == 0 ) {
            String nonZeroVal = ( b != 0 )?
                                ( bStr ) :
                                aStr;
            if( a == 0 ) {
              sbSpaced.append( String.format( "%-"+width+"s", ( nonZeroVal ) ) );
            }else {
              
              if( a == 9 ) {
                sbSpaced.append( String.format( "%-"+( width-1 )+"s", ( nonZeroVal ) ) );
              }else if( a == -10 ) {
                
                sbSpaced.append( String.format( "%-"+( width+ 1 )+"s", ( nonZeroVal ) ) );
              }else if(a == xLo){
                sbSpaced.append( String.format( "%-"+( width+1 )+"s", (" "+ nonZeroVal ) ) );
              }else if(a == -1){
                sbSpaced.append( String.format( "%-"+( width-1 )+"s", ( nonZeroVal ) ) );
              }else {
                sbSpaced.append( String.format( "%-"+width+"s", ( nonZeroVal ) ) );
              }
              
            }
            
            sbSpaced.append( ConsolColor.RESET );
            
            sbPacked.append( ( ( b == 0 )? "--" : "| " ) );
            
          }else
            if( abCongruent ) {
              sbPacked.append( locSymbol )
                      .append( " " );
              if( a == -1 ) {
                sbSpaced.append( String.format( "%-"+( width-1 )+"s", locSymbol ) );
              }else sbSpaced.append( String.format( "%-"+( width )+"s", locSymbol ) );
              
            }else {
              sbPacked.append( ": " );
              if( a == -1 ) {
                sbSpaced.append( String.format( "%-"+( width-1 )+"s", ":" ) );
              }else sbSpaced.append( String.format( "%-"+( width )+"s", ":" ) );
            }
      }
      sbSpaced.append( ConsolColor.RESET )
              .append( "\n" );
      sbPacked.append( ConsolColor.RESET )
              .append( "\n" );
    }
    System.out.println( sbSpaced.toString() );
    System.out.println( sbPacked.toString() );
  }
  
  A5P5( int xLo, int xHi, int yLo, int yHi, int[] aInterval ) {
    boolean print = false;
    for(int a = aInterval[0]; a <= aInterval[1]; ++a){
      a5PatternGen( xLo,xHi,yLo,yHi,a, print);
//      print = false;
    }
  }
  
  private void a5PatternGen( int xLo, int xHi, int yLo, int yHi, int a, boolean printSpaced ){
    
    int width = Math.max( String.valueOf( xLo ).length(), String.valueOf( xHi ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( yLo ).length() );
    
    width = Math.max( String.valueOf( width ).length(), String.valueOf( yHi ).length() )+( ( yLo < 0 )? 2 : 1 );
    
    StringBuilder sbSpaced = new StringBuilder();
    StringBuilder sbPacked = new StringBuilder();
    
    String
      bAxisBounds =
      "\nWith the value for 'a' set to "+a+"\nb is represented by the vertical axis, in the range of   ["+yLo+","+yHi+"]\n\n",
      aAxisBounds =
        "\na is represented by the horizontal axis, in the range of ["+xLo+","+xHi+"]";
    if(printSpaced) {
      sbSpaced.append(
        "\n"+ConsolColor.cyan_brt+"denotes where a^2 ≡3 b^2 and a < b"+ConsolColor.RESET+
        "\n"+ConsolColor.rd_brt+"denotes where a^2 ≡3 b^2 and a > b"+ConsolColor.RESET+
        "\n"+ConsolColor.grn_brt+"denotes where a^2 ≡3 b^2 and a == b\n\n"+ConsolColor.RESET )
              .append( aAxisBounds )
              .append( bAxisBounds )
              .append( "Figure 5.1: Stretched version of graph showing (a,b) values on the axis."+
                       "\nWhere a is the horizontal-axis, and b is the vertical-axis.\n" );
      sbPacked.append( "Figure 5.2: Square graph for better visual understanding of ratios.\n" );
    }else {
      sbPacked.append(
        "\n"+ConsolColor.cyan_brt+"denotes where a^2 ≡3 b^2 and a < b"+ConsolColor.RESET+
        "\n"+ConsolColor.rd_brt+"denotes where a^2 ≡3 b^2 and a > b"+ConsolColor.RESET+
        "\n"+ConsolColor.grn_brt+"denotes where a^2 ≡3 b^2 and a == b\n\n"+ConsolColor.RESET )
              .append( aAxisBounds )
              .append( bAxisBounds )
              .append( "Figure 5.2: Square graph for better visual understanding of ratios.\n" );
    }
    String aStr = String.valueOf( a );
    
    // generating a matrix of binary values that represent whether
    // a^2 is congruent to b^2 mod 3
    //
    // let b represent the row number in the matrix, and map to the
    // a values on the given low to hi bounds.
    //
    // let a represent the column number in the matrix, and map the
    // b values on the given low to hi bounds.
    for( int y = yHi; y >= yLo; --y ) {
      if( y != 0 && xLo < 0 ) sbSpaced.append( String.format( "%2s", "" ) );
      for( int x = xLo; x <= xHi; ++x ) {
        String locSymbol = (x == a && y == 0)?aStr: "H";
        
        boolean a2b = checkCongruence( a, y, 3 );
        
        sbPacked.append( (
                           ( x == a && y == 0 )? ConsolColor.prpl_brt :
                           ( y == 0 && x == 0 )? FAIL :
                           ( a2b )?
                           ( ( y < x && x == a)?
                             MOD0 : ( y == x && a == x )? winStr : ( x == a)? MOD1 : FAIL ) :
                           ( FAIL ) ) );
        
        sbSpaced.append( (
                           (x == a && y == 0)? ConsolColor.ylo_brt:
                           ( y == 0 && x == 0 )? "" :
                           ( a2b )?
                           ( ( y < x )? MOD0 : ( y == x )? winStr : MOD1 ) :
                           ( FAIL ) ) );
        
        if( y == 0 && x == 0 ) {
          // inside this if block we handle the special formatting for the (0,0) position in the graph.
          sbPacked.append( ConsolColor.RESET )
                  .append( "0" )
                  .append( FAIL )
                  .append( "-" );
          
          
          sbSpaced.append( String.format( ConsolColor.RESET+"%-"+( width )+"s", "0" ) );
        }else if( y == 0 ^ x == 0 ) {
          // inside this if block we handle the task of formatting and spacing the x and y axis values.
          String axisValue = ( y != 0 )?( String.valueOf( y ) ):String.valueOf( x );
          if( x == 0 ) {
            if( y > 0 ) sbSpaced.append( String.format( "%-"+width+"s", ( axisValue ) ) );
            else sbSpaced.append( String.format( "%-"+( width+1 )+"s", ( axisValue ) ) );
          } else {
            if( x == 9 ) sbSpaced.append( String.format( "%-"+( width-1 )+"s", ( axisValue ) ) );
            else if( x == -10 ) sbSpaced.append( String.format( "%-"+( width+1 )+"s", ( axisValue ) ) );
            else sbSpaced.append( String.format( "%-"+width+"s", ( axisValue ) ) );
          }
          
          if(x == a-1 && a == xHi){
            sbPacked.append("-");
          }else if(x == a && a == xHi){
            sbPacked.append(locSymbol);
          }else if( x == 0 && a == 0 && a2b){
            sbPacked.append( "H " );
          }else if (y == 0){
            if(a < -1) {
              if(a == xLo && (x == a+1 || x == 1)){
                sbPacked.append( "-" );
              }else if(x>a && x == 1){
                sbPacked.append( "-" );
              }else if(x == a-1){
                sbPacked.append( "-" );
              }else if(x == a){
                sbPacked.append( locSymbol );
              }else if(a > -10 && x == a+1){
                sbPacked.append("---");
              }else {
                sbPacked.append( "--" );
              }
              
            }else if(x == a){
              sbPacked.append( aStr ).append( FAIL );
              if(x == 1){
                sbPacked.append( "--" );
              } else {
                sbPacked.append( "-" );
              }
            }else if(x == a-1){
              if(a < 0){
                sbPacked.append( "-" );
              }else {
                sbPacked.append( "--" );
              }
            }else if(x == xHi){
              if(a < 0){
                sbPacked.append("--");
              }else if(a >= 0 && a <=9){
                sbPacked.append("-");
              }else {
              
              }
              
            }else {
              sbPacked.append( "--" );
            }
          }else {
            sbPacked.append( "| " );
          }
          
        }else if( a2b && x == a ) {
          // inside this if block, we handle the task of assigning spacing and formatting the points
          // on the graph where the relation tests to true.
          sbPacked.append( locSymbol )
                  .append( " " );
          if( x == -1 ) { // special formatting conditions needed where we stop\start using negative signs
            if( y < 0 )  sbSpaced.append( String.format( "%-"+( width-2 )+"s", locSymbol ) );
            else sbSpaced.append( String.format( "%-"+( width-1 )+"s", locSymbol ) );
          }else sbSpaced.append( String.format( "%-"+( width )+"s", locSymbol ) );
        }else {
          sbPacked.append( ": " );
          if( x == -1 ) {
            if( y > 0 ) sbSpaced.append( String.format( "%-"+( width-1 )+"s", ":" ) );
            else sbSpaced.append( String.format( "%-"+( width-2 )+"s", ":" ) );
          }else sbSpaced.append( String.format( "%-"+( width )+"s", ":" ) );
        }
      } // ends for int x loop
      sbSpaced.append( ConsolColor.RESET )
              .append( "\n" );
      sbPacked.append( ConsolColor.RESET )
              .append( "\n" );
    }// ends for int y loop
    if(printSpaced) System.out.println( sbSpaced.toString() );
    else System.out.println( sbPacked.toString() );
  }
  
}
