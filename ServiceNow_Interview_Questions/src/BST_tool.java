import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class BST_tool {
  
  class Node{
    Node l;
    Node r;
    int val;
    boolean hasVal = false;
    
    Node(int value){ val = value; hasVal = true;}
    
    public Node leftRightOrHere(int value){
      
      if(!hasVal){
        val = value;
        hasVal = true;
        return this;
      }
      
      if(value <= val){
        if(l != null) return l.leftRightOrHere(value);
        else return l = new Node(value);
      }else{
        if(r != null) return r.leftRightOrHere(value);
        else return r = new Node(value);
      }
      
    }
  }
  
  Node root;
  
  BST_tool(){
    int collection_size = 50;
    Random rand = new Random();
    int[] arr = new int[collection_size];
    int sum = 0, avg = 0;
    for(int i = 1; i < collection_size; ++i){
      arr[i] = rand.nextInt(200) - 100;
      sum += arr[i];
    }
    avg = sum/20;
    arr[0] = avg;
    System.out.print("the order of ints provided is:\n\t[ ");
    for(int itm : arr) {
      System.out.print(itm + " ");
      add(itm);
    }
    System.out.println("]\n");
    ArrayList<Integer> aList = build_sorted_array();
    System.out.print("The new sorted list of vals from the tree:\n\t[ ");
    for (int itm : aList) { System.out.print(itm + " "); }
    System.out.println("]\n");
    
  }
  
  /**
   * This ctor is provided as a means to create a minimal BST where only the root is instantiated.
   * @param val
   */
  BST_tool(int val){
    root = new Node(val);
  }
  
  /**
   * This function is provided for the convenience of being able modify an existing BST
   * @param val
   */
  public void add(int val){
    if (root == null) {
      root = new Node(val);
    }else root.leftRightOrHere(val);
  }
  
  ArrayList<Integer> build_sorted_array(){
    Stack<Node> stk = new Stack<>();
    stk.push(root);
    while(stk.peek().l != null)stk.push(stk.peek().l);
    ArrayList<Integer> aList = new ArrayList<>();
    while(!stk.empty()){
      aList.add(stk.peek().val);
      Node curr = stk.pop();
      if(curr.r != null ){
        stk.push(curr.r);
        while(stk.peek().l != null)stk.push(stk.peek().l);
      }
    }
    return aList;
  }
  
  /**
   * Given a root node, identify if there are 2 values in the BSTree which sum to a value equal to target.
   *
   * @param target the
   * @return
   */
  int[] find2sum(int target){
    ArrayList<Integer> aList = build_sorted_array();

    int end = aList.size();
    for(int first = 0; first < end; ++first){
      int lo = first+1, hi = end, second = (lo + hi)/2;
      while(lo < hi){
        int local = aList.get(first) + aList.get(second);
        if(local == target) return new int[]{aList.get(first),aList.get(second)};
        else if(target < local){
          if(hi == second)--hi;
          else hi = second;
        }else {
          if(lo == second)++lo;
          else lo = second;
        }
        second = (lo+hi)/2;
      }
    }
    return new int[]{-101,-1};
  }
  
}
