public
class A5Driver
{
  
  public static
  void main( String[] args ) {
  
  
    System.out.println();
    System.out.println( String.format( "%90s", "" )
                              .replace( " ", "-" ) );
    System.out.println( String.format( "%90s", "" )
                              .replace( " ", "-" ) );
    System.out.println( "Assignment 5, problem 5" );
    System.out.println();
    new A5P5();
//    new A5P5(-20,20,-20,20,new int[]{-20,20});
    System.out.println();
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println( "Assignment 5, problem 6");
    System.out.println();

    new A5P6(-40,40,-40,40);

    System.out.println();
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println( String.format( "%90s","" ).replace( " ", "-" ));
    System.out.println( "Assignment 5, problem 7");
    System.out.println();

    new A5P7( -20, 20, -20, 20);

    System.out.println();
    System.out.println( String.format( "%90s", "" )
                              .replace( " ", "-" ) );
    System.out.println( String.format( "%90s", "" )
                              .replace( " ", "-" ) );
    System.out.println();
    
    new A5P7(-20,20,-20,20,5);
  
    System.out.println();
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println();
  
    new A5P7( -20, 20, -20, 20, 5, 9);
  
    System.out.println();
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println( String.format( "%90s", "" ).replace( " ", "-" ) );
    System.out.println();
  }
}
