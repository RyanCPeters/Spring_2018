package examples_references.collectionsdemo;


import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class CollectionsDemoList
{
 
    public static void main(String[] args) {
 
      // Use Java Collections to create the List.
      List<String> list = new ArrayList<>();

      // Now add observability by wrapping it with ObservableList.
      ObservableList<String> observableList = FXCollections.observableList(list);
      observableList.addListener(new ListChangeListener() {

          @Override
          public void onChanged(ListChangeListener.Change change) {
              System.out.println("Detected a change! ");
            while( change.next() ) {
              System.out.println( "Was added? " + change.wasAdded() );
              System.out.println( "Was removed? " + change.wasRemoved() );
              System.out.println( "Was replaced? " + change.wasReplaced() );
              System.out.println( "Was permutated? " + change.wasPermutated() );
            }
          }
      });
 
      // Changes to the observableList WILL be reported.
      // This line will print out "Detected a change!"
      observableList.add("item one");

      // Changes to the underlying list will NOT be reported
      // Nothing will be printed as a result of the next line.
      list.add("item two");

      System.out.println("Size: "+observableList.size());
    }
}
