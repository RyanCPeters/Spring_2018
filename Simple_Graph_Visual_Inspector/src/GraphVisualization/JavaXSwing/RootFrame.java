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
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static GraphVisualization.JavaXSwing.ColorBot.EXPLORER;
import static GraphVisualization.JavaXSwing.ColorBot.INIT;
import static GraphVisualization.JavaXSwing.ColorBot.MAPPER;

/*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                TestPanel panel = new TestPanel();
                frame.add(panel);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
*/

public class RootFrame extends JFrame {
  
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
  public RootFrame(String[] fileName_ForRefMatrix, int x, int y) throws UnsupportedLookAndFeelException {
    super("Visual Matrix Traversals");
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception e) {
      // If Nimbus is not available, you can set the GUI to another look and feel.
    }
    
    masterDataList = new ArrayList<>(fileName_ForRefMatrix.length);
    JTabbedPane tPane = new JTabbedPane();
    JPanel content = new JPanel(new BorderLayout(2,2));
    
    for(int comps = 0; comps < fileName_ForRefMatrix.length; ++comps){
      JPanel tmp = buildMatrixPane(parseFile(fileName_ForRefMatrix[comps]));

      JButton jb = new JButton("Identify Contiguous sets of 1's");
      jb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          IDContOnes.countContiguous(masterDataList.get(tPane.getSelectedIndex()),false);

        }
      });
      jb.setMinimumSize(new Dimension(100,25));
      JPanel boxer = new JPanel();
      boxer.setBackground(Color.BLACK);
      boxer.setOpaque(true);
      boxer.setLayout(new BoxLayout(boxer, BoxLayout.X_AXIS));
      boxer.add(jb);
      boxer.add(Box.createGlue());
      tmp.add(boxer, BorderLayout.NORTH);
      
      tPane.add(fileName_ForRefMatrix[comps].substring(fileName_ForRefMatrix[comps].lastIndexOf('_')+1,
          fileName_ForRefMatrix[comps].lastIndexOf('.')),tmp);
    }
    content.add(tPane, BorderLayout.CENTER);
    content.setBackground(StaticColorPalette.awtShades[2]);
    content.setBackground(Color.BLACK);
    content.setOpaque(true);
    setContentPane(content);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  
  }// end RootFrame constructor
  
  public ArrayList<MyComp[][]> getMasterDataList(){
    return masterDataList;
  }
  
  private JPanel buildMatrixPane(Integer[][] templateMatrix){
    int x = templateMatrix.length, y = templateMatrix[0].length;
    JPanel ret = new JPanel(new BorderLayout(2,2));
    JPanel contents = new JPanel(new GridLayout(x,y));
    contents.setBackground(Color.BLACK);
    contents.setOpaque(true);
    MyComp[][] ref = new MyComp[x][y];
    masterDataList.add(ref);
    for(int row = 0; row < x; ++row){
      for(int col = 0; col < y; ++col){
  
        CellData<Integer> cd = new CellData<>(templateMatrix[row][col], row,col,masterDataList.get(masterDataList.size
            ()-1));
        MyComp mc = new MyComp(cd);
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
  ///////////   The inner class,   class MyComp extends JLabel , begins bellow
  ///////////////////////////////////////////////////////////////////////////////////
  class MyComp extends JPanel {
    private JLabel label;
    private CellData<Integer> cd;
    private boolean isDrawn = false;
    
    /**
     *
     * @param data the CellData object that holds the needed information for building this component
     */
    MyComp(CellData<Integer> data){
      super(false);
      setLayout(new GridLayout(1,1));
      label = new JLabel(data.data.toString(),SwingConstants.CENTER);
      this.cd = data;
      label.setText(data.getData().toString());
      label.setOpaque(false);
      add(label);
    }
  
    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Function<Graphics,Graphics2D> circleGradientLambda = new Function<Graphics, Graphics2D>() {
        @Override
        public Graphics2D apply(Graphics graphics) {
          Graphics2D g2d = (Graphics2D) g;
          g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
          int w = getWidth();
          int h = getHeight();
          int radius = (w < h)?((w&1) == 0)?(w/2)-1:w/2:((h&1)==0)?(h/2)-1:h/2;
          Color c1 = cd.getMyLightFGCompliment();
          Color c2 = cd.getMyFontColorL();
          double rdStep = (c2.getRed()-c1.getRed())/(double)radius,
              grnStep = (c2.getGreen()-c1.getGreen())/(double)radius,
              bluStep = (c2.getBlue()-c1.getBlue())/(double)radius;
          Color[] colors = new Color[radius];
          float[] fractions = new float[radius];
//        Stream.of(fractions).flatMap((0f,frac) -> frac )
          float curFrac = 0, fracIncrementer = 1f/radius;
          for(int i = 0; i < radius; ++i){
            colors[i] = new Color(c1.getRed()+(int)(rdStep*i), c1.getGreen()+(int)(grnStep*i),c1.getBlue()+(int)(bluStep*i));
            fractions[i] = curFrac;
            curFrac+=fracIncrementer;
          }
  
          g2d.setPaint(new RadialGradientPaint(
              w/2,
              h/2,
              radius/*-(radius*0.15f)-2f//*/,
              fractions,
              colors));
          
          return g2d;
        }
      };
      switch (cd.getState()){
        default:
        case DEFAULT:
          if(!cd.isDrawn()) {
            cd.setDrawn( true);
            cd.setPalette(1);
  
            Graphics2D g2 = circleGradientLambda.apply(g);
            g2.fillRect(0, 0, getWidth(), getHeight());
            label.setForeground(cd.getMyFontColorL());
          }
          break;
        case MAPPED:
          if(!cd.isDrawn()) {
            cd.setDrawn(true);
            cd.setPalette(0);
            Border emptyBorder = new EmptyBorder(1, 1, 1, 1);
  
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke((float) 1.0)));
            Border linedBorder = getBorder();
            setBorder(new CompoundBorder(emptyBorder, linedBorder));
            
            Graphics2D g2 = circleGradientLambda.apply(g);
            g2.fillRect(0, 0, getWidth(), getHeight());
            
            label.setForeground(cd.getMyFontColorL());
          }
          break;
        case EXPLORED:
          if(!cd.isDrawn()) {
            cd.setDrawn(true);
            cd.setPalette(1);
            setBackground(cd.getMyBg());
            Border emptyBorder = new EmptyBorder(1, 1, 1, 1);
  
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke((float) 2.0)));
            Border linedBorder = getBorder();
            setBorder(new CompoundBorder(emptyBorder, linedBorder));
  
            Graphics2D g2 = circleGradientLambda.apply(g);
            g2.fillRect(0, 0, getWidth(), getHeight());
  
            label.setForeground(cd.getMyFontColorL());
            Font labelFont = label.getFont();
            String labelText = label.getText();
  
            int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
            int componentWidth = label.getWidth();

// Find out how much the font can grow in width.
            double widthRatio = (double)componentWidth / (double)stringWidth;
  
            int newFontSize = (int)(labelFont.getSize() * widthRatio);
            int componentHeight = label.getHeight();

// Pick a new font size so it will not be larger than the height of label.
            int fontSizeToUse = Math.min(newFontSize, componentHeight);

// Set the label's font size to the newly determined size.
            label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
          }
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

    public void callPapa(int contOnesIdx){
      cd.setContOnesIdx(contOnesIdx);
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
      cd.setState(state);
      cd.contOnesIdx = contOnesIdx;
//      cd.setPalette(0);
      callPapa(contOnesIdx);
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
      callPapa(val);
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
    
    private Color myFontColorL;
    private Color myFontColorD;
    private Color myBg;
    private Color myLightFGCompliment;
    private Color myDarkFGCompliment;
    private int paletteNumber = 0;
  
  
    /**
     *
     */
    private int contOnesIdx = -1;
    CellState state = CellState.DEFAULT;
    private boolean isDrawn = false;
  
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
        position[0] = x;
        position[1] = y;
        this.data = data;
        notifyLeftAndUp(matrix);
      }else{
        this.data = null;
        up = down = left = right = null;
      }
  
  
      myFontColorL = INIT.getDarkFG();
      myFontColorD = INIT.getDarkFG();
      myBg = INIT.getBG();
      myLightFGCompliment = INIT.getAltLighFG();
      myDarkFGCompliment = INIT.getAltDarkFG();
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
          myBg = EXPLORER.getBG();
          break;
        case MAPPED:
          myBg = MAPPER.getBG();
          
          break;
          default:
            myFontColorL = INIT.getLightFG();
            myFontColorD = INIT.getDarkFG();
            myBg = INIT.getBG();
            myLightFGCompliment = INIT.getAltLighFG();
            myDarkFGCompliment = INIT.getAltDarkFG();
            break;
      }

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
    public Color getMyFontColorL() {
      return myFontColorL;
    }
  
    /**
     *
     * @return
     */
    public Color getMyFontColorD() {
      return myFontColorD;
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
    public Color getMyLightFGCompliment() {
      return myLightFGCompliment;
    }
  
    /**
     *
     * @return
     */
    public Color getMyDarkFGCompliment() {
      return myDarkFGCompliment;
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
    public CellState getState(){return state;}


    public void setLtFGComp() {
      myLightFGCompliment = StaticColorPalette.awtContOnesTransition[contOnesIdx];
    }
  
    public void setDrawn(boolean drawn) {
      isDrawn = drawn;
    }
  
    public boolean isDrawn() {
      return isDrawn;
    }
  
    public void setState(CellState state) {
      this.state = state;
      this.isDrawn = false;
    }
  
    public void setContOnesIdx(int contOnesIdx) {this.contOnesIdx = contOnesIdx;}
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
  private static void recursiveDFS(boolean[][] checked, RootFrame.MyComp[][] arr, int x_, int y_, int rows, int cols,
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
  
  @SuppressWarnings("all")
  private static boolean validIndexToCheck(int x_, int y_, int rows, int cols, boolean[][] checked) {
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
   */
  @SuppressWarnings("all")
  private static void iterativeBFS(boolean[][] checked, RootFrame.MyComp[][] arr, int x_, int y_, int rows, int cols,
                                   int colorNumber) {
    LinkedList<int[]> loc_queue = new LinkedList<>();
    loc_queue.add(new int[]{x_, y_});
    
    while (!loc_queue.isEmpty()) {
      int loc[] = loc_queue.pollFirst();
      checked[loc[0]][loc[1]] = true;
      arr[loc[0]][loc[1]].update(RootFrame.CellState.EXPLORED, colorNumber); // There's a call to update, so shits getting drawn
      for (int dir[] : dirs) {
        int dx = loc[0] + dir[0], dy = loc[1] + dir[1];
        if (dx >= 0 && dx < cols && dy >= 0 && dy < rows && !checked[dx][dy] && arr[dx][dy].getCd().getData() == 1) {
          loc_queue.add(new int[]{dx, dy});
        }
      }
    }
  }
  
  @SuppressWarnings("all")
  public static int countContiguous(RootFrame.MyComp[][] arr, boolean use_recursion) {

    int count = 0;
    try {
      int cols = arr.length, rows = arr[0].length;
      ConsoleColorEnum.resetPlaceInList();
      boolean checkedArr[][] = new boolean[cols][rows];

      int colorNumber = 0;
      boolean incColoNum = true;
      for (int x = 0; x < cols; ++x) {
        for (int y = 0; y < rows; ++y) {

//          Thread.sleep(100);
          if (!checkedArr[x][y]) {
            checkedArr[x][y] = true;
            if (arr[x][y].getCd().getData() == 1) {
              incColoNum = true;
              ++count;
              if (use_recursion)
                recursiveDFS(checkedArr, arr, x, y, rows, cols, colorNumber);
              else
                iterativeBFS(checkedArr, arr, x, y, rows, cols, colorNumber);
            } else {
              if (incColoNum) {
                incColoNum = false;
                colorNumber = (colorNumber + 1) % StaticColorPalette.awtContOnesTransition.length;
              }
//            colorArray[x][y] = ConsoleColorEnum.assignColor(false, false, true, "0");
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

  private static Color deriveColor(/*boolean increment,*/ RootFrame.MyComp mc){

      return (mc.getCd().getData() == 1)?
              StaticColorPalette.awtContOnesTransition[mc.getCd().getContOnesIdx()]:
              Color.BLACK;
    }

  public static void resetPlaceInList(){
    placeInList = 0;
  }
} // end of class IDContOnes
