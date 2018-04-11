package GraphVisualization.JavaXSwing;

import GraphVisualization.ConsoleFiles.ConsoleColorEnum;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static GraphVisualization.JavaXSwing.ColorBot.EXPLORER;
import static GraphVisualization.JavaXSwing.ColorBot.INIT;
import static GraphVisualization.JavaXSwing.ColorBot.MAPPER;

public class RootFrame {
  JFrame frame;
  
  enum CellState {DEFAULT, EXPLORED,MAPPED}
  
  public static final String[] KNOWN_FILES = {"readable_Matrix_3x4.json","Readable_Matrix_20x22.json","Readable_Matrix_40x60.json"};
  
  // SETTING UP NAMED CONSTANTS
  /**private final int CELL = 10;
   * <p>
   * Because the game board's size will be given to RootFrame as a count of rows and columns which
   * will be used to create a matrix of cells, it is important to set up a constant value for the
   * height and width of a single cell in pixels so we can consistently set up esthetically pleasing
   * board layouts.
   */
  private static final int CELL = 8;
  
  private int xBound = 0, yBound = 0, boardSize = 0;
  
  /**
   *
   */
  public static final Color WHITE = Color.white;
  
  // TODO: 4/8/2018 define the purpose of the private static ArrayList<CellData<Integer>> binaryDataMatrix; 
  /**
   * 
   */
  public ArrayList<MyComp[][]> masterDataList;

  
  /**Class RootFrame Constructor
   * <p>
   * RootFrame( SudokuBase b ) {
   * <p>
   * The RootFrame Constructor requires the SudokuBase object to provide information about
   * the number of rows and columns that will be used for the instantiation of any particular
   * game's set up.
   */
  public RootFrame(String[] fileName_ForRefMatrix, int x, int y) {
    frame = new JFrame("Visual Matrix Traversals");
    frame.setLayout(new BorderLayout(1,1));
  
    JPanel content = new JPanel(new BorderLayout(2,2));
    JTabbedPane tPane = generateFrameContents(fileName_ForRefMatrix);
    
    content.add(tPane, BorderLayout.CENTER);
    content.setBackground(StaticColorPalette.awtShades[2]);
    frame.setContentPane(content);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.validate();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  
  }// end RootFrame constructor
  
  private JTabbedPane generateFrameContents(String[] fileName_ForRefMatrix){
  
    JMenuBar menuBar=new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu file=new JMenu("File");
    JMenuItem exit=new JMenuItem("Exit");
    JMenuItem reset=new JMenuItem("Reset");
    file.add(exit);
    file.add(reset);
    menuBar.add(file);
    exit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });
  
    reset.addActionListener(new ActionListener(){//help me
      public void actionPerformed(ActionEvent e){
        
        frame.setVisible(false);
        
        frame.getContentPane().removeAll();
        JTabbedPane tNewPane = new JTabbedPane();
        for(int comps = 0; comps < fileName_ForRefMatrix.length; ++comps){
          
          int x =  masterDataList.get(comps).length, y = masterDataList.get(comps)[0].length;
          
          JPanel tmp = new JPanel(new BorderLayout(2, 2));
          JPanel contents = new JPanel(new GridLayout(x, y));
          JButton jb = new JButton(1 + comps + ") Identify Contiguous sets of 1s");
          
          jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Explorer actionExplorer = new Explorer("1",
                  0,
                  masterDataList.get(tNewPane.getSelectedIndex()).length,
                  0,
                  masterDataList.get(tNewPane.getSelectedIndex())[0].length,
                  tNewPane,
                  tNewPane.getSelectedIndex());
      
              new Thread(actionExplorer).start();
      
      
            }
          });
          
          jb.setMinimumSize(new Dimension(100, 25));
          JPanel boxer = new JPanel();
          boxer.setLayout(new BoxLayout(boxer, BoxLayout.X_AXIS));
          boxer.add(jb);
          boxer.add(Box.createGlue());
          boxer.add(new JLabel("Count of sets of contiguous ones found so far: "));
          boxer.add(new JLabel("0"));
          boxer.add(Box.createGlue());
          tmp.add(boxer, BorderLayout.NORTH);
          
          for(int row = 0; row < x;++row) {
            for(int col = 0; col < y; ++col) {
              
              contents.add(masterDataList.get(comps)[row][col]);
  
              
            }
          }
          tmp.add(contents,BorderLayout.CENTER);
          tmp.setPreferredSize(new Dimension(y*CELL*2,x*CELL*2));
          tmp.setMinimumSize(new Dimension(y*CELL*2,x*CELL*2));
          tNewPane.add(fileName_ForRefMatrix[comps].substring(fileName_ForRefMatrix[comps].lastIndexOf('_') + 1,
              fileName_ForRefMatrix[comps].lastIndexOf('.')), tmp);
        }
        
        frame.pack();
        frame.validate();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  
  
    masterDataList = new ArrayList<>(fileName_ForRefMatrix.length);
    JTabbedPane tPane = new JTabbedPane();
  
    for(int comps = 0; comps < fileName_ForRefMatrix.length; ++comps){
      JPanel tmp = buildMatrixPane(parseFile(fileName_ForRefMatrix[comps]));
      
      JButton jb = new JButton(1+comps+") Identify Contiguous sets of 1s");
      jb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Explorer actionExplorer = new Explorer("1",
              0,
              masterDataList.get(tPane.getSelectedIndex()).length,
              0,
              masterDataList.get(tPane.getSelectedIndex())[0].length,
              tPane,
              tPane.getSelectedIndex());
        
          new Thread(actionExplorer).start();
        
        
        }
      });
      jb.setMinimumSize(new Dimension(100,25));
      JPanel boxer = new JPanel();
      boxer.setLayout(new BoxLayout(boxer, BoxLayout.X_AXIS));
      boxer.add(jb);
      boxer.add(Box.createGlue());
      boxer.add(new JLabel("Count of sets of contiguous ones found so far: "));
      boxer.add(new JLabel("0"));
      boxer.add(Box.createGlue());
      tmp.add(boxer, BorderLayout.NORTH);
    
      tPane.add(fileName_ForRefMatrix[comps].substring(fileName_ForRefMatrix[comps].lastIndexOf('_')+1,
          fileName_ForRefMatrix[comps].lastIndexOf('.')),tmp);
    }
    
    return tPane;
  }
  
  public ArrayList<MyComp[][]> getMasterDataList(){
    return masterDataList;
  }
  
  private JPanel buildMatrixPane(Integer[][] templateMatrix){
    int x = templateMatrix.length, y = templateMatrix[0].length;
    JPanel ret = new JPanel(new BorderLayout(2,2));
    JPanel contents = new JPanel(new GridLayout(x,y));
    MyComp[][] ref = new MyComp[x][y];
    masterDataList.add(ref);
    for(int row = 0; row < x; ++row){
      for(int col = 0; col < y; ++col){
  
        CellData<Integer> cd = new CellData<>(templateMatrix[row][col], row,col,masterDataList.get(masterDataList.size
            ()-1));
        MyComp mc = myCellFactory(cd);
        if(!mc.isOpaque())mc.setOpaque(true);
        masterDataList.get(masterDataList.size()-1)[row][col] = mc;
        contents.add(mc);
      }
    }
    ret.add(contents,BorderLayout.CENTER);
    ret.setPreferredSize(new Dimension(y*CELL*2,x*CELL*2));
    ret.setMinimumSize(new Dimension(y*CELL*2,x*CELL*2));
    return ret;
  }
  
  /**public JComponent myCellFactory( boolean hasEmptyMargin, boolean hasLine, int height, int width, Color c)
   * <p>
   * Use this method to create an empty JComponent with one of four border
   * configurations
   * <p>
   * The border options are:
   * <ul>
   * 	<li>a basic empty margin border for spacing </li>
   * 	<li>a basic black line border with an even line around the objects perimeter </li>
   * 	<li>a combo border which has the empty margin surrounding the black line</li>
   * 	<li>or, a borderless component </li>
   * </ul>
   */
  private MyComp myCellFactory(CellData<Integer> cd){
  
    MyComp factoryJCell = new MyComp(cd);
    Border emptyBorder = new EmptyBorder(1,1,1,1);
  
    factoryJCell.setMinimumSize(new Dimension(5,5));
    factoryJCell.setPreferredSize(new Dimension(5,5));
    factoryJCell.setSize(5,5);
  
    // set the details pertaining to the font in the component
    factoryJCell.setForeground(cd.myPrime);
    
    // Now we apply boarders to this component
//    factoryJCell.setBorder(BorderFactory.createLineBorder(Color.PINK));
    Border linedBorder = factoryJCell.getBorder();
  
    factoryJCell.setBorder(new CompoundBorder(emptyBorder, linedBorder));
    factoryJCell.setOpaque(true);
    return factoryJCell;
  }// EMD myCellFactory(boolean hasEmptyMargin, boolean hasLine, int height, int width)

  /**
   *
   * @param fileName
   * @return
   * @throws InternalError
   */
  @SuppressWarnings("all")
  public static Integer[][] parseFile(String fileName)throws InternalError{
    String possible_errMsg;
    BufferedReader br;
    try {
      final Pattern p = Pattern.compile("[\\[|\\]]");
      br = new BufferedReader(new FileReader(fileName));
      Integer[][] ret;
      ArrayList<String> collected = br.lines().parallel().filter(l -> l.length() > 1)
          .map((String l) ->{
            l = l.trim().replaceAll(p.pattern(),"");
            if(l.endsWith(","))return l.substring(0,l.lastIndexOf(','));
            return l;
          }).collect(Collectors.toCollection(ArrayList::new));
      br.close();
      
      
      ret = new Integer[collected.size()][];
      for (int row = 0; row  < collected.size(); ++row) {
        
        String[] arr = collected.get(row).split(" ");
        ret[row] = new Integer[arr.length];
        for(int i = 0; i < arr.length; ++i){
          ret[row][i] = Integer.parseInt(arr[i]);
        }
      }
      return ret;
    } catch (FileNotFoundException fnfe) {
      possible_errMsg = "|\n -> [-] FileNotFoundException caused in\n\t\t" +
                        "JavaHexColorParser.parseFile(String fileName)\n\n" +
                        fnfe.getMessage();
    } catch (IOException ioe){
      possible_errMsg = "|\n -> [-] IOException caused in\n\t\t" +
                        "JavaHexColorParser.parseFile(String fileName)\n\n" +
                        ioe.getMessage();
    }
    throw new InternalError("\n\n[-] Internal Logic Error inside\n\tpublic static ArrayList<String> parseFile" +
                            "(String fileName)\n"+possible_errMsg);
  }
  
  
  ///////////////////////////////////////////////////////////////////////////////////
  ///////////   The inner class,   class Explorer extends Thread , begins bellow
  ///////////////////////////////////////////////////////////////////////////////////
  class Explorer implements Runnable {
    int x_left, x_right, y_top, y_bot,numberOfElements, maxThreads,groupNumber,threadNumber;
    JTabbedPane pane;
    IDContOnes logic;
    String name;
  
    /**
     * @param name a name for this thread, should probably use something meaningful.
     * @param x_left the left most column this thread should consider when rastering the matrix
     * @param x_right the right most column this thread should consider when rastering the matrix
     * @param y_top the top my row this thread should consider when rastering the matrix
     * @param y_bot the bottom most row this thread should consider when rastering the matrix
     * @param tPane the JTabbedPane which we will use as the indicator for which index within the masterDataList we
     * @param groupNumber
     */
    public Explorer(String name,
                    int x_left,
                    int x_right,
                    int y_top,
                    int y_bot,
                    JTabbedPane tPane,
                    int groupNumber)
    {
      this.x_left = x_left;
      this.x_right = x_right;
      this.y_top = y_top;
      this.y_bot = y_bot;
      this.pane = tPane;
      this.numberOfElements = (x_right - x_left)*(y_bot - y_top);
      this.logic = new IDContOnes(masterDataList.get(pane.getSelectedIndex()), name);
      this.maxThreads = (numberOfElements/20 > 8)? 8 : numberOfElements/20 < 1 ? 1 : numberOfElements/20;
      this.threadNumber = 1;
      this.groupNumber = groupNumber;
      
    }
  
    /**
     *  @param name
     * @param x_left
     * @param x_right
     * @param y_top
     * @param y_bot
     * @param tPane
     * @param groupNumber
     * @param threadNumber
     * @param maxThreads
     * @param logic
     */
    private Explorer(String name,
                     int x_left,
                     int x_right,
                     int y_top,
                     int y_bot,
                     JTabbedPane tPane,
                     int groupNumber,
                     int threadNumber,
                     int maxThreads,
                     IDContOnes logic)
    {
      this.x_left = x_left;
      this.x_right = x_right;
      this.y_top = y_top;
      this.y_bot = y_bot;
      this.pane = tPane;
      this.groupNumber = groupNumber;
      this.threadNumber = threadNumber;
      this.maxThreads = maxThreads;
      this.logic = logic;
    }
  
    /**
     *
     */
    @Override
    public void run() {
      int newExplorerNums = threadNumber+1;
      while(--maxThreads > 0){
        
        int dx_right = x_right, dy_bott = y_bot;
        if((x_right -x_left)>=(y_bot-y_top)){
          dx_right = (x_right+x_left)/2;
          
          new Thread(new Explorer(String.valueOf(newExplorerNums++),
              dx_right,
              x_right,
              y_top,
              y_bot,
              pane,
              groupNumber,
              newExplorerNums++,
              maxThreads,
              logic));
          x_right = dx_right;
        }else{
          dy_bott = (y_bot+y_top)/2;
  
          new Thread(new Explorer(String.valueOf(newExplorerNums++),
              dx_right,
              x_right,
              dy_bott,
              y_bot,
              pane,
              groupNumber,
              newExplorerNums++,
              maxThreads,
              logic));
          y_bot = dy_bott;
        }
        
      }
      logic.countContiguous(new int[]{x_right,y_top},new int[]{x_right,y_bot});
    }// end of public void run()
  
    public String getName() {
      return name;
    }
  
    public int getX_left() {
      return x_left;
    }
  
    public int getX_right() {
      return x_right;
    }
  
    public int getY_top() {
      return y_top;
    }
  
    public int getY_bot() {
      return y_bot;
    }
  
    public int getNumberOfElements() {
      return numberOfElements;
    }
  
    public int getMaxThreads() {
      return maxThreads;
    }
  
    public int getGroupNumber() {
      return groupNumber;
    }
  
    public int getThreadNumber() {
      return threadNumber;
    }
  
    public JTabbedPane getPane() {
      return pane;
    }
  
    public IDContOnes getLogic() {
      return logic;
    }
  }
  
  ///////////////////////////////////////////////////////////////////////////////////
  ///////////   The inner class,   class MyComp extends JLabel , begins bellow
  ///////////////////////////////////////////////////////////////////////////////////
  class MyComp extends JLabel {
    private CellData<Integer> cd;
  
    /**
     *
     * @param data the CellData object that holds the needed information for building this component
     */
    MyComp(CellData<Integer> data){
      super(data.data.toString(),SwingConstants.CENTER);
      this.cd = data;
    }
  
    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      switch (cd.getCellState()){
        default:
        case DEFAULT:
          setForeground(cd.getMyPrime());
          setBackground(cd.getMyBg());
          Border emptyBorder = new EmptyBorder(1,1,1,1);

          setBorder(BorderFactory.createStrokeBorder(new BasicStroke((float)2.0)));
          Border linedBorder = getBorder();

          setBorder(new CompoundBorder(emptyBorder, linedBorder));
          
          break;
        case MAPPED:
          cd.setPalette(0);
          setForeground(cd.getMyPrime());
          setBackground(cd.getMyBg());
          break;
        case EXPLORED:
          cd.setPalette(1);
          setForeground(cd.getMyPrime());
          setBackground(cd.getMyBg());
          break;
          
      }
      
      if(cd.contOnesIdx > -1){
        setForeground( StaticColorPalette.awtContOnesTransition[cd.contOnesIdx]);
      }


    }
  
    /**
     *
     * @return
     */
    public CellData<Integer> getCd() {
      return cd;
    }

    public void callPapa(){
      repaint();
//      getParent().getParent().getParent().getParent().repaint();

      getRootPane().repaint();
    }
    /**
     *
     * @param state identifies if the cell in the default undescovered state, discovered (but not mapped), or mapped
     *              states.
     * @param contOnesIdx this int will be used to identify which color from the contiguous-ones color cycle this
     *                    cluster is using.
     * @see CellData#contOnesIdx
     */
    public void update(CellState state, int contOnesIdx){
      cd.state = state;
      cd.contOnesIdx = contOnesIdx;
      cd.setPalette(1);
      callPapa();
    }
  
    /**
     *
     * @param val the data value for this cell. When we attempt to find a continuous path of zeros from top left to
     *            bottom right, we may find that there is no such path. In that case, we will want to identify the
     *            path the requires us to remove the fewest 1's as possible in order to satisfy that goal.
     */
    public void update(Integer val){

      cd.setData(val);
      cd.setPalette(-1);
      callPapa();
    }
  }// end of class MyComp
  
  ///////////////////////////////////////////////////////////////////////////////////
  ///////////   The inner class, CellData<V extends Comparable>, begins bellow
  ///////////////////////////////////////////////////////////////////////////////////

  /**
   *
   * @param <V>
   */
  class CellData<V extends Number> {
    
    private int[] position = new int[2];
    
    private Color myPrime;
    private Color mySec;
    private Color myBg;
    private Color myAcc1;
    private Color myAcc2;
    
    private String discoveredByThreadName = "-";
  
  
    /**
     *
     */
    private int contOnesIdx = -1;
    CellState state = CellState.DEFAULT;

    /**
     *
     * @return
     */
    public final int getContOnesIdx() {
      return contOnesIdx;
    }

    // As the matrix is populated, we will fill it from top left to bottom right.
    //
    // The safest logic for creating a linked web of cells is to instruct the cells to
    // form links with their up and let neighbors as we build.
    //
    // We can avoid null pointers by using logic to infer when the cell is at an edge of the board.
    //
    // Once the cell is created, it gets added to the matrix and in the same move updates the
    // adjacent neighbors it can form contact with.
    private CellData up, down,left, right;
    
    private V data;
  
    /**
     * the empty ctor for this class, sets the uninitialized member variables to be null.
     */
    CellData(){
      this(null,-1,-1,null);
    }
  
    /**
     *
     * @param data the value to be graphically shown in this cell
     * @param x the index position with a row for this cell
     * @param y the index position with a column for this cell.
     * @param matrix the relational mapping of all the cells according to their index values, (x,y)
     */
    CellData(V data, int x, int y, MyComp[][] matrix){
      if(x > -1) {
        setPalette();
        position[0] = x;
        position[1] = y;
        this.data = data;
        notifyLeftAndUp(matrix);
      }else{
        this.data = null;
        up = down = left = right = null;
      }
    }
  
    /**
     *
     * @param matrix the relational mapping of all the cells according to their index values, (x,y)
     */
    private void notifyLeftAndUp(MyComp[][] matrix){
      // precondition checking for if there is a neighbor ino the left direction;
      if(position[0] > 0){
        left = matrix[position[0]-1][position[1]].cd;
        left.syncWithNeighbor(this, 1);
      }
  
      // precondition checking for if there is a neighbor ino the up direction
      if(position[1] > 0){
        up = matrix[position[0]][position[1]-1].cd;
        up.syncWithNeighbor(this, 2);
      }
    }// end of notifyLeftAndUp
  

     /**
     *
     * @param x the index position with a row for this cell
     * @param y the index position with a column for this cell.
     * @param matrix the relational mapping of all the cells according to their index values, (x,y)
     */
    public void setPlaceInMatrix(int x, int y, MyComp[][] matrix){
      position[0] = x;
      position[1] = y;
      notifyLeftAndUp(matrix);
    }
  
    /**
     *
     * @param data the value to be graphically shown in this cell
     * @param x the index position with a row for this cell
     * @param y the index position with a column for this cell.
     * @param matrix the relational mapping of all the cells according to their index values, (x,y)
     */
    public void setPlaceInMatrix(V data, int x, int y, MyComp[][] matrix){
      this.data = data;
      setPlaceInMatrix(x,y,matrix);
    }
    
    /**
     *
     * @param cd a reference the CellData object which is to be set as the adjacent neighbor according to the
     *           provided dir
     * @param dir the value of either 1, or 2, this corresponds to right and down respectively. This is used to
     *            determine what direction the reference, cd, is from this CellData object.
     */
    private void syncWithNeighbor(CellData cd, int dir){
      switch (dir){
        case 1:
          right = cd;
          return;
        case 2:
          down = cd;
          return;
        default:break;
      }
    }
  
    /**
     *
     * @param dataValForUsingAcc This lets us handle the task of assigning different text colors based upon
     *                           the CellState value stored in this CellData object, and the type V val stored
     *                           here when checked against this specific use case value.
     */
    public void setPalette(V dataValForUsingAcc){
      switch (state){
        case EXPLORED:
          mySec =  EXPLORER.getDarkFG();
          myBg = EXPLORER.getBG();
          myAcc1 = EXPLORER.getAltLighFG();
          myAcc2 = EXPLORER.getAltDarkFG();
          if(data != null && data.equals(dataValForUsingAcc))myPrime = EXPLORER.getAltLighFG();
          else if(data == null)myPrime = EXPLORER.getAltDarkFG();
          break;
        case MAPPED:
          mySec = MAPPER.getDarkFG();
          myBg = MAPPER.getBG();
          myAcc1 = MAPPER.getAltLighFG();
          myAcc2 = MAPPER.getAltDarkFG();
          if(data != null && data.equals(dataValForUsingAcc))myPrime = MAPPER.getAltLighFG();;
          break;
          default:
            myPrime = INIT.getDarkFG();
            mySec = INIT.getDarkFG();
            myBg = INIT.getBG();
            myAcc1 = INIT.getAltLighFG();
            myAcc2 = INIT.getAltDarkFG();
            break;
      }
    }
  
    /**
     *
     * @param discoveredByThreadName
     */
    protected void setDiscoveredByThreadName(String discoveredByThreadName) {
      this.discoveredByThreadName = discoveredByThreadName;
    }
  
    /**
     *
     * @return
     */
    public String getDiscoveredByThreadName() {
      return discoveredByThreadName;
    }
  
    /**
     *
     */
    public void setPalette(){
      setPalette(null);
    }
  
    /**
     *
     * @param dat
     */
    public void setData(V dat){data = dat;}
    
    /**
     *
     * @return
     */
    public final int[] getPosition() {
      return position;
    }
  
    /**
     *
     * @return
     */
    public Color getMyPrime() {
      return myPrime;
    }
  
    /**
     *
     * @return
     */
    public Color getMySec() {
      return mySec;
    }
  
    /**
     *
     * @return
     */
    public Color getMyBg() {
      return myBg;
    }
  
    /**
     *
     * @return
     */
    public Color getMyAcc1() {
      return myAcc1;
    }
  
    /**
     *
     * @return
     */
    public Color getMyAcc2() {
      return myAcc2;
    }
  
    /**
     *
     * @return
     */
    public CellState getState() {
      return state;
    }
  
    /**
     *
     * @return
     */
    public CellData getUp() {
      return up;
    }
  
    /**
     *
     * @return
     */
    public CellData getDown() {
      return down;
    }
  
    /**
     *
     * @return
     */
    public CellData getLeft() {
      return left;
    }
  
    /**
     *
     * @return
     */
    public CellData getRight() {
      return right;
    }
  
    /**
     *
     * @return
     */
    public V getData() {
      return data;
    }
  
    /**
     *
     * @return
     */
    public CellState getCellState(){return state;}


    public void setAcc1() {
      myAcc1 = StaticColorPalette.awtContOnesTransition[contOnesIdx];
    }
  }// end of class CellData

}// end of class RootFrame

///////////////////////////////////////////////////////////////////////////////////
///////////   The inner class, lass IDContOnes , begins bellow
///////////////////////////////////////////////////////////////////////////////////
@SuppressWarnings("all")
class IDContOnes {
  // to make it easier to handle directional checks, use this 2D array of int offsets
  private static final int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int placeInList = 0;
  private RootFrame.MyComp[][] arr;
  private static int count = 0;
  private String threadName;
  
  public IDContOnes(RootFrame.MyComp[][] ref, String ThreadName) {
    this.arr = ref;
    this.threadName = ThreadName;
  }
  
  /**
   * @param checked
   * @param arr
   * @param x_
   * @param y_
   * @param rows
   * @param cols
   * @param colorArr
   * @param colorNumber
   * @return true until the x_ or y_ point beyond the array's bounds.
   */
  @SuppressWarnings("all")
  private void recursiveDFS(boolean[][] checked, RootFrame.MyComp[][] arr, int x_, int y_, int rows, int cols,
                                   int colorNumber) {
    
    // sanity checking the indices for out-of-bounds conditions
    checked[x_][y_] = true;
//    colorArr[x_][y_] = ConsoleColorEnum.assignColor(false, false, true, String.valueOf(arr[x_][y_]));
    arr[x_][y_].update(RootFrame.CellState.EXPLORED, colorNumber);
    boolean dirsToFollow[] = {false, false, false, false};
    for (int dir = 0; dir < 4; ++dir) {
      int x = x_ + dirs[dir][0], y = y_ + dirs[dir][1];
      if (validIndexToCheck(x, y, rows, cols, checked)) {
        dirsToFollow[dir] = (arr[x][y].getCd().getData() == 1);
        if (dirsToFollow[dir]) {
          recursiveDFS(checked, arr, x, y, rows, cols,colorNumber);
        }
      }
    }
  }
  
  /**
   *
   * @param x_
   * @param y_
   * @param rows
   * @param cols
   * @param checked
   * @return
   */
  @SuppressWarnings("all")
  private boolean validIndexToCheck(int x_, int y_, int rows, int cols, boolean[][] checked) {
    return (x_ >= 0 && x_ < cols) && (y_ >= 0 && y_ < rows) && !checked[x_][y_];
  }
  
  /**
   * @param checked
   * @param arr
   * @param x_
   * @param y_
   * @param rows
   * @param cols
   * @param colorArr
   * @param colorNumber
   * @return if this BFS encounters the edge of it's bounds, it will check if the MyComp object it's currently at has
   *          a neighbor in that direction that would be considered a contiguous part of this set of 1's. Should the
   *          neighbor have a 1, then check if the neighbor has already been explored.
   *
   *          If any neighbor cell, outside of this thread's search boundaries, would be considered contiguous with
   *          this set of ones, then after we exhaust all contiguous ones in this set we need to
   *
   */
  @SuppressWarnings("all")
  private boolean iterativeBFS(boolean[][] checked, RootFrame.MyComp[][] arr, int x_, int y_, int rows, int cols,
                                   int colorNumber) {
    int countOfOnesFounHere = 0;
    Stack<int[]> foundLocs = new Stack<>();
    LinkedList<int[]> loc_queue = new LinkedList<>();
    loc_queue.add(new int[]{x_, y_});
    
    while (!loc_queue.isEmpty()) {
      int[] loc = loc_queue.pollFirst();
      foundLocs.push(loc);
      ++countOfOnesFounHere;
      arr[loc[0]][loc[1]].getCd().setDiscoveredByThreadName(threadName);
      arr[loc[0]][loc[1]].update(RootFrame.CellState.EXPLORED, colorNumber); // There's a call to update, so shits getting drawn
      for (int dir[] : dirs) {
        int dx = loc[0] + dir[0], dy = loc[1] + dir[1];
        
        if (dx >= 0 && dx < cols && dy >= 0 && dy < rows ) {
          if(arr[dx][dy].getCd().state == RootFrame.CellState.EXPLORED) {
            if(!arr[dx][dy].getCd().getDiscoveredByThreadName().equals(threadName)){
              // TODO: 4/10/2018 using the name of the thread that already discovered this cell, compare who has
              // found more so far, then the smaller collection hands off it's list of locs
            }
          } else if( arr[dx][dy].getCd().getData() == 1 )loc_queue.add(new int[]{dx, dy});
        }
      }
    }
    return true;
  }
  
  /**
   *
   * @param arr
   * @param initPos
   * @param endPos
   * @return
   */
  @SuppressWarnings("all")
  public int countContiguous(int[] initPos, int[] endPos) {
//    int count = 0;
    try {
      int cols = arr.length, rows = arr[0].length;
      ConsoleColorEnum.resetPlaceInList();
      boolean checkedArr[][] = new boolean[cols][rows];
    
      int colorNumber = 0;
      for (int x = initPos[0]; x < endPos[0]; ++x) {
        for (int y = initPos[1]; y < endPos[0]; ++y) {

          if (!checkedArr[x][y]) {
            checkedArr[x][y] = true;
            if (arr[x][y].getCd().getData() == 1) {
              if(iterativeBFS(checkedArr, arr, x, y, rows, cols, count%12)) {
                ++count;
              }
            } else {
              arr[x][y].update(RootFrame.CellState.EXPLORED, -1);
            }
          }
        }
      }
    } catch (Throwable t) {
      System.err.printf("", t.getMessage());
    }
    return count;
  }
  
  /**
   *
   * @param mc
   * @return
   */
  private Color deriveColor(/*boolean increment,*/ RootFrame.MyComp mc){
      return (mc.getCd().getData() == 1)?
              StaticColorPalette.awtContOnesTransition[mc.getCd().getContOnesIdx()]:
              Color.BLACK;
    }
  
  /**
   *
   */
  public void resetPlaceInList(){
    placeInList = 0;
  }

} // end of class IDContOnes
