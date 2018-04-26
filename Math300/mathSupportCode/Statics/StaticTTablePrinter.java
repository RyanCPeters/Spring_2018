package Statics;

import com.Assignment3.ConsolColor;

import javax.swing.text.*;
import java.util.HashMap;
import java.util.Map;

public
class StaticTTablePrinter
{
  
  public static final String[] INIT_STYLES =
      { "regular", "italic", "bold", "small", "large", "button", "icon"
      };
  
  /**
   <pre>
   This function provides a boilerplate mechanism for generating a truth table
   that will colorize and highlight rows of the table where propositional logic
   statements result in a false outcome.
   
   
   </pre>
   
   @param map
   <br>
   a {@code HashMap<Integer, Boolean[]>} object that accepts an integer<br>
   value, n, as the key to a boolean array that represents the truth states<br>
   for a given row to a truth table which corresponds to propositional<br>
   function outputs for a given input of n.<br><br>
   @param labels
   <br>
   an array of strings which represent the header labels for your columns.<br>
   For example, {@code new String[]{"n","p(n)","q(n)","p->q"}}<br><br>
   @param pt
   <br>
   An enumerator reference that is used communicate if this table should<br>
   @param tableID
   */
  public static void generateTruthTable(
      HashMap<Integer[],Boolean[]> map, String[] labels, PropositionType pt, int tableID ) {
    
    int columnWidt = 0;
    
    for( String s : labels ) {
      columnWidt =
          ( columnWidt >= s.length() )? columnWidt : ( s.length() > 20 )? 20 : s.length() + 2;
    }
    
    StringBuilder headerBuilder = new StringBuilder( "|" );
    
    for( String label : labels ) {
      headerBuilder.append( String.format( " %" + columnWidt + "s |", label ) );
    }
    
    // generating the horizontal dashed line that will separate the header row from the data rows.
    // given the 4 columns we are working with (matching the 4 header labels we've made) we need
    // to generate
    // a dashed line with -+- intersections that occur every columnWidt spaces apart.
    StringBuilder horizontal_dashed_line = new StringBuilder( String.valueOf( tableID ) );
    for( int colums = 0; colums < labels.length; ++ colums ) {
      for( int width = 0; width < columnWidt + 2; ++ width ) {
        horizontal_dashed_line.append( "-" );
      }
      horizontal_dashed_line.append( ( ( colums < labels.length - 1 )? "+" : "|" ) );
    }
    
    String tableHorizontalLines = horizontal_dashed_line.toString().replace( "+", "-" );
    
    System.out.println();
    
    System.out.println();
    System.out.println( tableHorizontalLines );
    
    System.out.println( headerBuilder.toString() );
    System.out.println( horizontal_dashed_line.toString().replace( "-", "=" ) );
    
    horizontal_dashed_line.toString().replace( "=", "-" );
  
  
    int stopAt = ( map.size() > 30 )? 30 : map.size();
    int pos = 0;
    int end = stopAt;
    
    for( Map.Entry ent : map.entrySet() ) {
      Boolean[] boolForI = (Boolean[])ent.getValue();
      
      StringBuilder sb = new StringBuilder( "| " );
      {
        Integer[] keyArr = (Integer[])ent.getKey();
        
        sb.append( String.format( "%s%" + columnWidt + "s" + ConsolColor.RESET,
                                  ConsolColor.ylo_bld_brt, keyArr[ 0 ].toString() ) );
        
        for( int i = 1; i < keyArr.length; ++ i ) {
          sb.append( String.format( " | %s%" + columnWidt + "s" + ConsolColor.RESET,
                                    ConsolColor.ylo_bld_brt, keyArr[ i ].toString() ) );
        }
      }
      
      for( int k = 0; k < boolForI.length; ++ k ) {
        sb.append( String.format( " | %s%" + columnWidt + "s" + ConsolColor.RESET, (
            boolForI[ k ]? ConsolColor.grn_bld_brt : ConsolColor.rd_bld_brt ), boolForI[ k ] ) );
      }
      
      sb.append( " |" );
      
      System.out.println( sb.toString() + (
          boolForI[ boolForI.length - 1 ]?
          "" :
          ConsolColor.cyan_bg + ConsolColor.wht_bld_brt + "<---" ) + ConsolColor.RESET );
      
      System.out.println( (
                              ( pos < end - 1 )?
                              horizontal_dashed_line.toString() :
                              tableHorizontalLines ) );
      if(++pos > end) break;
    }
  }
  
  /**
   
   @param map
   @param labels
   @param doc
   */
  public static void generateTruthTable(
      HashMap<Integer[],Boolean[]> map, String[] labels, StyledDocument doc ) {
    
    addStylesToDocument( doc );
    int columnWidt = 0;
    
    for( String s : labels ) {
      columnWidt =
          ( columnWidt >= s.length() )? columnWidt : ( s.length() > 20 )? 20 : s.length() + 2;
    }
    
    StringBuilder headerBuilder = new StringBuilder( "|" );
    
    for( String label : labels ) {
      headerBuilder.append( String.format( " %" + columnWidt + "s |", label ) );
    }
    // generating the horizontal dashed line that will separate the header row from the data rows.
    // given the 4 columns we are working with (matching the 4 header labels we've made) we need
    // to generate
    // a dashed line with -+- intersections that occur every columnWidt spaces apart.
    StringBuilder horizontal_dashed_line = new StringBuilder( "|" );
    for( int colums = 0; colums < labels.length; ++ colums ) {
      for( int width = 0; width < columnWidt + 2; ++ width ) {
        horizontal_dashed_line.append( "-" );
      }
      horizontal_dashed_line.append( ( ( colums < labels.length - 1 )? "+" : "|" ) );
    }
    
    String tableHorizontalLines = horizontal_dashed_line.toString().replace( "+", "-" );
    
    try {
      doc.insertString( doc.getLength(), "\n\n", doc.getStyle( INIT_STYLES[ 0 ] ) );
      doc.insertString( doc.getLength(), tableHorizontalLines, doc.getStyle( INIT_STYLES[ 0 ] ) );
      doc.insertString( doc.getLength(), headerBuilder.toString(),
                        doc.getStyle( INIT_STYLES[ 0 ] ) );
      
      doc.insertString( doc.getLength(), horizontal_dashed_line.toString().replace( "-", "=" ),
                        doc.getStyle( INIT_STYLES[ 0 ] ) );
      
      horizontal_dashed_line.toString().replace( "=", "-" );
      
      
      int pos = 0;
      
      int end = map.values().size();
      
      for( Map.Entry ent : map.entrySet() ) {
        Boolean[] boolForI = (Boolean[])ent.getValue();
        StringBuilder sb = new StringBuilder( "| " );
        
        
        Integer[] keyArr = (Integer[])ent.getKey();
        
        sb.append( String.format( "%s%" + columnWidt + "s" + ConsolColor.RESET,
                                  ConsolColor.ylo_bld_brt, keyArr[ 0 ].toString() ) );
        
        for( int i = 1; i < keyArr.length; ++ i ) {
          sb.append( String.format( " | %s%" + columnWidt + "s" + ConsolColor.RESET,
                                    ConsolColor.ylo_bld_brt, keyArr[ i ].toString() ) );
        }
        
        
        for( int k = 0; k < boolForI.length; ++ k ) {
          sb.append( String.format( " | %s%" + columnWidt + "s" + ConsolColor.RESET, (
              boolForI[ k ]? ConsolColor.grn_bld_brt : ConsolColor.rd_bld_brt ), boolForI[ k ] ) );
          
        }
        
        sb.append( " |" );
        doc.insertString( doc.getLength(), sb.toString() + (
                              boolForI[ boolForI.length - 1 ]?
                              "" :
                              ConsolColor.cyan_bg + ConsolColor.wht_bld_brt + "<---" ) +
                                           ConsolColor.RESET,
                          doc.getStyle( INIT_STYLES[ 0 ] ) );
        doc.insertString( doc.getLength(), (
                              ( pos < end - 1 )? horizontal_dashed_line.toString() :
                              tableHorizontalLines ),
                          doc.getStyle( INIT_STYLES[ 0 ] ) );
        ++pos;
      }
      
    }catch( BadLocationException ble ) {
      System.err.println( "Couldn't insert initial text into text pane." );
    }
  }
  
  /**
   
   @param doc
   */
  static void addStylesToDocument( StyledDocument doc ) {
    //Initialize some styles.
    Style def = StyleContext.getDefaultStyleContext().getStyle( StyleContext.DEFAULT_STYLE );
    
    Style regular = doc.addStyle( "regular", def );
    StyleConstants.setFontFamily( def, "SansSerif" );
    
    Style s = doc.addStyle( "italic", regular );
    StyleConstants.setItalic( s, true );
    
    s = doc.addStyle( "bold", regular );
    StyleConstants.setBold( s, true );
    
    s = doc.addStyle( "small", regular );
    StyleConstants.setFontSize( s, 10 );
    
    s = doc.addStyle( "large", regular );
    StyleConstants.setFontSize( s, 16 );
    
    s = doc.addStyle( "icon", regular );
    StyleConstants.setAlignment( s, StyleConstants.ALIGN_CENTER );
    
    s = doc.addStyle( "button", regular );
    StyleConstants.setAlignment( s, StyleConstants.ALIGN_CENTER );
  }
  
  /**
   
   */
  public enum PropositionType
  {
    SINGLE, BICON
  }
  
}


