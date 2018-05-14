package Assig3;

public class Assig3Main
{
  
  public static void main(String[] args)
  {
    int[] problemlist = {1,2,4,5};
    for( int i :
        problemlist ) {
      problemChooser( i );
    }
    System.out.println(
      "Output Remarks:\n* The output for problem 5's truth tables is a bit overkill, but it " +
      "seemed necessary for verifying the results");
  }
  
  private static void problemChooser(int problemNumber){
    boolean defaultDo = false;
    switch( problemNumber ){
      case 1:
        Assig3.problem1();
        break;
      case 2:
        Assig3.problem2();
        break;
      case 3:
        System.out.println( "Invalid function call for problem #3" );
        defaultDo = true;
        break;
      case 4:
        Assig3.problem4();
        break;
      case 5:
        Assig3.problem5();
        break;
      case 6:
        System.out.println( "Invalid function call for problem #6" );
        defaultDo = true;
        break;
      case 7:
        System.out.println( "Invalid function call for problem #7" );
        defaultDo = true;
        break;
      default:
        defaultDo = true;
    }
    
    if( defaultDo)System.out.printf( "for input of %d, no such function exists.", problemNumber );
  }
}
