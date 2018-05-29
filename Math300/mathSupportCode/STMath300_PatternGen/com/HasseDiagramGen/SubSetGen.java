package HasseDiagramGen;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public
class SubSetGen
{
  ConcurrentHashMap<String,String> masterSet;
  
  public
  SubSetGen( ConcurrentHashMap<String,String> masterSet ) {
    
    this.masterSet = masterSet;
  }
  
  public
  SubSetGen() {
    this.masterSet = new ConcurrentHashMap<>();
  }
}
