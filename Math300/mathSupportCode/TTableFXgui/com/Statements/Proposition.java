package com.Statements;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

public
class Proposition
  extends AbstractProposition
{
  
  public
  Proposition( String statement ) {
    super( statement );
  }
  
  public
  Proposition(){
    super("nullEntry"+nullCount++);
  }
  
  
  /**
   <pre>
   Compares this object with the specified object for order.  Returns a negative
   integer, zero, or a positive integer as this object is less than, equal to, or
   greater than the specified object.
   
   The implementor must ensure
   {@code
      sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.
      (This implies that {@code x.compareTo(y)} must throw an exception iff
      {@code y.compareTo(x)} throws an exception.)
   
   The implementor must also ensure that the relation is transitive:
    {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
   
   Finally, the implementor must ensure that
    {@code x.compareTo(y)==0} implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))},
    for all {@code z}.
   
   It is strongly recommended, but <i>not</i> strictly required that
   {@code (x.compareTo(y)==0) == (x.equals(y))}.
   Generally speaking, any class that implements the {@code Comparable} interface
   and violates this condition should clearly indicate this fact. The recommended
   language is "Note: this class has a natural ordering that is inconsistent with
   equals."
   
   In the foregoing description, the notation {@code sgn(}<i>expression</i>{@code )}
   designates the mathematical <i>signum</i> function, which is defined to return
   one of {@code -1}, {@code 0}, or {@code 1} according to whether the value of
   <i>expression</i> is negative, zero, or positive, respectively.
   
   @param o
   
   the object to be compared.
   
   @return
   
   a negative integer, zero, or a positive integer as this object is less than, equal to, or
   greater than the specified object.
   <br>
   In the event that {@code Object o} isn't of type Proposition, return -99 for debugging.
   
   @throws NullPointerException
   
   if the specified object is null
   
   @throws ClassCastException
   if the specified object's type prevents it from being compared to this object.

   </pre>
   */
  @Override public
  int compareTo( Object o ) {
    if(o instanceof Proposition){
      int val = ( ( (Proposition)o ).getStatement().compareTo( this.getStatement() ) );
      return val >= 0? val == 0? 0:1:-1; // ensuring that the return val is -1, or 0, or 1
    }
    throw new ClassCastException("looking for type Proposition, got type "+ o.getClass());
  }
  
  /**
   
   @param operator
   @param statement
   @return
   */
  public boolean expandStatement(String operator, String statement){
    for(Object p : observedStatementsList.toArray()){
      if(p.toString().equals( this.getStatement() + operator + statement ))return false;
    }
    if(operator.length() >0)observedStatementsList.add( new Proposition( this.getStatement() + operator + statement ) );
    else observedStatementsList.add(
      new Proposition( statement ) );
    return true;
  }
  
  @Override public
  String toString() {
    
    return getStatement();
  }
}
