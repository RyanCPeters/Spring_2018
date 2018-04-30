package com.Statements;

/**
 
 <pre>
 public enum PropositionalOperators serves as a tool to help ensure the consistent
 use of exact strings for each of the propositional ansiOperators.
 
  cheat sheet for getting ansiOperators from ansi code:
    prefix the alpha-numeric codes for your chosen symbol with
    {@literal \\}u  , that is to say, if we wanted to write the Logican AND symbol,
    we would type:
     {@literal \}u2227
      eg., ( pAND~q ) should be written as ({@literal p\}u2227~q ) which will be
      interpreted into ( p\u2227~q ).
 
 And extended list of relevant logic ansiOperators:
  
  ~ not sign
  ¬ 00AC not sign
  ∧ 2227 Logical AND
  ∨ 2228 Logical OR
  ∀ 2200, FOR ALL , forall, ForAll
  ∃ 2203, THERE EXISTS , exist, Exists
  ∄ 2204, THERE DOES NOT EXIST , nexist, NotExists, nexists
 
  ∝ 221D prop, propto, Proportional, vprop, varpropto, proportional to
  ∣ 2223 divides
  ∤ 2224 does not divide
  ≃ 2243 asymptotically equal to
  ≄ 2244 not asymptotically equal to
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
 </pre>
*/
public
enum PropositionalOperators {
  COND      (0), // ->, conditional dependence
  AND       (1), // ∧, \u2227 Logical AND
  OR        (2), // ∨, \u2228 Logical OR
  BICON     (3), // <->, biconditional dependence
  EXISTS    (4), // ∃, \u2203, exist,exists
  NOTEXISTS (5), // ∄, \u2204, notexist , nexist, notexists, nexists
  ALL       (6), // ∀, \u2200, forall, ForAll, all
  NOT       (7), // ¬, \u00AC, ~, notsign, nsign, not
  DIVIDES   (8), // ∣, \u2223 divides, div
  NOTDIVIDES(9); // ∤, \u2224 notdivide, ndivide, notdiv, ndiv
  
  
  public String[] operator;
  public final int len;
  
  // this array is made of the ansi-codes for the ansiOperators in this enum's javadoc.
  private static String[] ansiOperators = {
    "~", "¬", "∧", "∨", "∀", "∃", "∄", "∝", "∣", "∤", "≃", "≄", "≠", "≡", "≤",
    "≥", "≪", "≫", "⊂", "⊃", "⊆", "⊇", "⊄", "∩", "∪", "∈", "∊", "∉", "∋", "∍", "∌", "∅"
  };
  
  private static String[] wordOperators = {
    "notsign", "not", "and", "or", "for", "exists", "does",
    "proportional", "divides", "notdivide", "asymptequal", "notasymptequal", "notequal",
    "congruent", "lessorequal", "greaterorequal", "muchless", "muchgreater", "subset",
    "superset", "subsetorequal", "supersetorequal", "notinset", "intersection", "union",
    "element", "element", "notelement", "reverseelement", "reverseelement", "notreverseelement",
    "emptyset"
  };
  
  PropositionalOperators( int selector ) {
    switch( selector ){
      case 0: // COND :: conditional dependence
        operator = new String[]{"->","then","follows"};
        break;
      case 1: // AND
        operator = new String[]{"\u2227", "and", "&", "&&"};
        break;
      case 2: // OR
        operator = new String[]{"\u2228", "or", "|", "||"};
        break;
      case 3: // BICON :: biconditional dependence
        operator = new String[]{"<->", "<=>", "iff"};
        break;
      case 4: // EXISTS existential quantifier: ∃, \u2203, exist,exists
        operator = new String[]{"\u2203", "exist","exists"};
        break;
      case 5:// NOTEXISTS existential quantifier: ∄, \u2204, notexist , nexist, notexists, nexists
        operator = new String[]{"\u2204", "notexist", "nexist", "notexists", "nexists"};
        break;
      case 6: // ALL universal quantifier: ∀, \u2200, forall, all
        operator = new String[]{ "\u2200", "forall", "all"};
        break;
      case 7: // NOT operator, expresses negation: ~, ¬ 00AC not sign
        operator = new String[]{ "\u00AC", "~", "notsign", "nsign", "not"};
        break;
      case 8:// DIVIDES( 8 ), // ∣, \u2223 divides, div
        operator = new String[]{"\u2223", "divides", "div"};
        break;
      case 9: // NOTDIVIDES( 9 ); // ∤, \u2224 notdivide, ndivide, notdiv, ndiv
        operator = new String[]{"\u2224", "notdivide", "ndivide", "notdiv", "ndiv"};
        break;
        default: break;
      
    }
    len = operator.length;
  }
  
  
  /**
   
   @param checkMe the string for which we want confirmation of if it is an operator
   @return
   */
  public static
  boolean isAnOperator(String checkMe) {
    StringBuilder sb = new StringBuilder(15);
    
    for( PropositionalOperators en : PropositionalOperators.values()){
      for(int i = 0; i < en.operator.length; ++i){
        sb.replace( 0,en.operator[i].length() , en.operator[i] );
        if( sb.indexOf( checkMe ) >= 0 )return true;
        sb.setLength( 0 );
      }
    }
    
    return false;
  } // ends boolean isAnOperator(String checkMe)
  
}
