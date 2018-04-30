package examples_references.collectionsdemo;

import java.util.Map;
import java.util.HashMap;

import javafx.collections.ObservableMap;
import javafx.collections.MapChangeListener;
import javafx.collections.FXCollections;

public
class CollectionsDemoMap
{
  
  public static
  void main( String[] args ) {
    
    // Use Java Collections to create the List.
    Map<String,String> map = new HashMap<String,String>();
    
    // Now add observability by wrapping it with ObservableMap.
    ObservableMap<String,String> observableMap = FXCollections.observableMap( map );
    observableMap.addListener( new MapChangeListener()
    {
  
      @Override
      public
      void onChanged( MapChangeListener.Change change ) {
    
        System.out.println( "Detected a change! " );
        System.out.println( "Was added? " + change.wasAdded() );
        System.out.println( "Was removed? " + change.wasRemoved() );
        System.out.println(change.getValueAdded());
        
      }
    } );
    
    // Changes to the observableMap WILL be reported.
    observableMap.put( "key 1", "value 1" );
    System.out.println( "Size: " + observableMap.size() );
    
    // Changes to the underlying map will NOT be reported.
    map.put( "key 2", "value 2" );
    System.out.println( "Size: " + observableMap.size() );
    
  }
}
