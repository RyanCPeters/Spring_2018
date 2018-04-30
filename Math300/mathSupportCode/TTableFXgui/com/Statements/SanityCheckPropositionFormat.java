package com.Statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public
class SanityCheckPropositionFormat
{
  /**
   <pre>
   This method will count opening braces, and closing braces then return a positive or negative
   count to communicate if there's any difference.
   
   @param statement
   
   @return
     <pre>
       {@literal
       
         so long as each opening brace, has an equally nested closing brace of
         the same type, this function will return true. Otherwise false;
         
            ie.,
                
                { ( ) [ ] {} }({[]}) : a braces pattern like this shall return true
                {(})                 : a braces pattern like this shall return false
         
       }
     </pre>
   </pre>
   */
  static
  boolean checkStatementBraces(String statement){
    if(statement == null)return false;
    Stack<Character> stk = new Stack<>();
    for( char c : statement.toCharArray() ) {
      switch( c ){
        case '}':
          if( stk.empty() || stk.pop() != '{')return false;
          break;
        case ')':
          if( stk.empty() || stk.pop() != '{' ) return false;
          break;
        case ']':
          if( stk.empty() || stk.pop() != '{' ) return false;
          break;
        case '{':
        case '(':
        case '[':
          stk.push( c );
        default: break;
      }
    }
      return true;
  }
      /* This comment block is just a reference to how we might format the output
       denoting that there's a brace mismatch.
    
     if(!checkStatementBraces( statement )){
      System.err.println( "\n\n" +
                          "[-] Internal Logic Error\n" +
                          "    SanityCheckPropositionFormat.SanityCheckPropositionFormat(String
                          statement )" +
                          "    throws IllegalArgumentException\n" +
                          "    It appears we missed a check for matched braces. This will" +
                          "    prevent us from being able to build CompositStatementsSet\n" +
                          "\n" );
    }
    
    * */
}
