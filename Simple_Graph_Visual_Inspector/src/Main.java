import java.util.Random;

public class Main {
    
    /**
     * This function is used in evaluating if the graph traversal properly handled the different contiguous ones
     * @param colorArray
     * @param show_output
     */
    static void vetColorArray(String[][] colorArray, boolean show_output){
        if(show_output) {
            for (String[] row : colorArray) {
                System.out.println();
                for (String col : row) {
                    if (col == (ConColor.blk_brt + 1)) System.err.println("we had a 1 value get labled as a 0");
                    System.out.printf("%s ", col);
                }
            }
        }else {
            for (String[] row : colorArray) {
                for (String col : row) {
                    if (col == (ConColor.blk_brt + 1)) System.err.println("we had a 1 value get labled as a 0");
                }
            }
        }
    
        System.out.println(ConColor.RESET);
    }
    
    static void testContiguousOnes(){
        String[] colors = {
            "rd",
            "blu",
            "grn",
            "prpl",
            "ylo",
            "CYAN",
            "RED_BOLD_BRIGHT",
            "BLUE_BOLD_BRIGHT",
            "GREEN_BOLD_BRIGHT",
            "PURPLE_BOLD_BRIGHT",
            "YELLOW_BOLD_BRIGHT",
            "CYAN_BOLD_BRIGHT",
            "blk_brt"
        };
    
        for (int i = 0; i < colors.length; i++) {
            System.out.println(ConColor.RESET + (i+1) + " " + ContiguousOnes.Colors[i] + colors[i]);
        }
        System.out.println();
    
        System.out.println(ConColor.RESET + "test using 2d array of:\n1 1 0 1\n0 1 0 1\n0 1 1 0\n");
        int arr[][] = {{1,1,0,1},{0,1,0,1},{0,1,1,0}};
        int x[][] =
            {
                {1, 1,  0,  1,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  1},
                {1,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  1,  0,  1,  1,  1,  0,  1,  1,  0,  0,  0},
                {0,  1,  1,  1,  1,  0,  0,  0,  0,  1,  1,  0,  1,  1,  1,  0,  1,  0,  1,  1,  1,  0},
                {1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  1,  0,  0,  1,  0,  0,  1,  1,  1,  0,  0,  0},
                {1,  1,  0,  1,  1,  0,  1,  0,  0,  1,  0,  1,  1,  0,  1,  1,  0,  0,  0,  1,  1,  0},
                {0,  1,  0,  1,  0,  1,  1,  0,  0,  0,  1,  1,  1,  0,  1,  0,  0,  0,  0,  1,  1,  0},
                {0,  1,  0,  1,  1,  0,  0,  0,  1,  0,  1,  0,  0,  0,  1,  1,  1,  1,  0,  1,  1,  0},
                {1,  0,  1,  0,  1,  1,  0,  0,  1,  1,  1,  0,  1,  1,  1,  1,  0,  1,  1,  0,  0,  1},
                {1,  1,  1,  0,  0,  1,  0,  0,  1,  1,  1,  0,  0,  0,  1,  1,  1,  0,  0,  1,  0,  0},
                {1,  0,  1,  0,  1,  1,  1,  0,  0,  0,  1,  0,  0,  1,  1,  0,  1,  1,  1,  0,  0,  1},
                {0,  1,  0,  1,  0,  0,  0,  0,  0,  1,  0,  1,  1,  0,  0,  1,  0,  0,  1,  1,  1,  1},
                {1,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  0,  1,  1,  0,  1,  0,  1,  0,  1,  1,  1},
                {1,  0,  1,  1,  1,  0,  0,  1,  1,  0,  0,  1,  1,  0,  1,  1,  0,  1,  0,  1,  0,  1},
                {0,  0,  0,  0,  1,  1,  0,  1,  0,  0,  0,  1,  0,  1,  0,  1,  1,  1,  0,  0,  1,  1},
                {1,  0,  0,  1,  1,  0,  0,  0,  0,  0,  1,  0,  0,  1,  0,  1,  0,  1,  0,  1,  1,  0},
                {0,  1,  0,  0,  0,  1,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  1,  0,  0,  1,  1},
                {0,  1,  1,  0,  1,  1,  1,  0,  1,  1,  0,  0,  1,  1,  1,  0,  0,  0,  1,  0,  1,  0},
                {1,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,  1},
                {1,  1,  1,  1,  0,  0,  1,  0,  1,  1,  0,  0,  0,  1,  1,  0,  0,  1,  0,  0,  0,  1},
                {1,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  1,  1,  0,  0,  0,  0,  0,  1,  0,  1,  0}
            };
    
    
        String[][] colorArray1, colorArray2, colorArray3, colorArray4, colorArray5, colorArray6;
    
        colorArray1 = new String[3][4];
        int number_of_sections = ContiguousOnes.countContiguous(arr,4,3, colorArray1, false, true);
        System.out.println();
        System.out.println("\tVetting colorArray1 now");
        vetColorArray(colorArray1,true);
        System.out.println();
        System.out.println();
        System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
    
        colorArray2 = new String[3][4];
        number_of_sections = ContiguousOnes.countContiguous(arr,4,3, colorArray2, true, true);
        System.out.println();
        System.out.println("\tVetting colorArray2 now");
        vetColorArray(colorArray2,true);
        System.out.println();
        System.out.println();
        System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
    
        System.out.println(
            "test using 2d array of:"+
            "\n1 1 0 1 0 0 0 1 1 1 1 0 0 0 0 0 0 1 0 0 0 1"+
            "\n1 0 0 0 1 1 1 1 0 0 0 1 0 1 1 1 0 1 1 0 0 0"+
            "\n0 1 1 1 1 0 0 0 0 1 1 0 1 1 1 0 1 0 1 1 1 0"+
            "\n1 1 1 1 1 1 1 1 0 0 1 0 0 1 0 0 1 1 1 0 0 0"+
            "\n1 1 0 1 1 0 1 0 0 1 0 1 1 0 1 1 0 0 0 1 1 0"+
            "\n0 1 0 1 0 1 1 0 0 0 1 1 1 0 1 0 0 0 0 1 1 0"+
            "\n0 1 0 1 1 0 0 0 1 0 1 0 0 0 1 1 1 1 0 1 1 0"+
            "\n1 0 1 0 1 1 0 0 1 1 1 0 1 1 1 1 0 1 1 0 0 1"+
            "\n1 1 1 0 0 1 0 0 1 1 1 0 0 0 1 1 1 0 0 1 0 0"+
            "\n1 0 1 0 1 1 1 0 0 0 1 0 0 1 1 0 1 1 1 0 0 1"+
            "\n0 1 0 1 0 0 0 0 0 1 0 1 1 0 0 1 0 0 1 1 1 1"+
            "\n1 0 1 0 0 0 1 0 0 1 0 0 1 1 0 1 0 1 0 1 1 1"+
            "\n1 0 1 1 1 0 0 1 1 0 0 1 1 0 1 1 0 1 0 1 0 1"+
            "\n0 0 0 0 1 1 0 1 0 0 0 1 0 1 0 1 1 1 0 0 1 1"+
            "\n1 0 0 1 1 0 0 0 0 0 1 0 0 1 0 1 0 1 0 1 1 0"+
            "\n0 1 0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 1"+
            "\n0 1 1 0 1 1 1 0 1 1 0 0 1 1 1 0 0 0 1 0 1 0"+
            "\n1 0 0 0 0 1 1 1 1 1 0 0 0 0 1 1 0 0 0 0 0 1"+
            "\n1 1 1 1 0 0 1 0 1 1 0 0 0 1 1 0 0 1 0 0 0 1"+
            "\n1 0 0 0 0 0 0 0 0 1 0 1 1 0 0 0 0 0 1 0 1 0\n");
    
        colorArray3 = new String[20][22];
        number_of_sections = ContiguousOnes.countContiguous(x,22,20, colorArray3, false, true);
        System.out.println();
        System.out.println("\tVetting colorArray3 now");
        vetColorArray(colorArray3,true);
        System.out.println();
        System.out.println();
        System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
    
        colorArray4 = new String[20][22];
        number_of_sections = ContiguousOnes.countContiguous(x,22,20, colorArray4, true, true);
        System.out.println();
        System.out.println("\tVetting colorArray4 now");
        vetColorArray(colorArray4,true);
        System.out.println();
        System.out.println();
        System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
    
        int number_of_samples = 2;
        for(int seed = 1; seed < number_of_samples; ++seed) {
            int rows = 20, cols = 20;
            if (number_of_samples < 3){
                cols = rows = 75;
            }
            int[][] y = new int[rows][cols];
            Random rand = new Random(seed);
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    y[row][col] = rand.nextInt(2);
                }
            }

            // for shits and giggles, we ensure that the top left, and bottom right corners are 0. Lets now try to write
            // an algorithm that can find the shortest route from top left (start) to bottom right (end), if a path
            // even exists.
            y[0][0] = 0;
            y[cols-1][rows-1] = 0;
            colorArray5 = new String[rows][cols];
            number_of_sections = ContiguousOnes.countContiguous(y, cols, rows, colorArray5, false, false);
            System.out.println();
            System.out.println("\tVetting colorArray5 now");
            vetColorArray(colorArray5, false);
            System.out.println();
            System.out.println();
            System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
        
            colorArray6 = new String[rows][cols];
            number_of_sections = ContiguousOnes.countContiguous(y, cols, rows, colorArray6, true, false);
            System.out.println();
            System.out.println("\tVetting colorArray6 now");
            vetColorArray(colorArray6, false);
            System.out.println();
            System.out.println();
            System.out.println(ConColor.RESET + "The number of sections is: " + number_of_sections);
        
            System.out.println("\n\nlets try to print these arrays");
            for (int row = 0; row < cols; ++row) {
                for (int col = 0; col < rows; ++col) {
                    if (colorArray5[row][col].equals(colorArray5[row][col])) {
                        System.out.printf("%s ", colorArray5[row][col]);
                    } else {
                        System.out.print(ConColor.wht_bg_brt + " " + ConColor.RESET + " ");
                    }
                }
                System.out.println();
            }
        
            System.out.println(ConColor.RESET);
        
        }
    }
    
    public static void main(String[] args) {
        testContiguousOnes();
    }
}
