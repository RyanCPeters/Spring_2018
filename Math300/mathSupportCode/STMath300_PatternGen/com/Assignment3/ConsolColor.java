package com.Assignment3;

/**
 * I borrowed the idea and some of the syntax for this class from:
 *
 *    https://stackoverflow.com/a/45444716/7412747
 */
public class ConsolColor {
    // Reset
    public static final String RESET = "\u001B[0m";  // Text Reset
    


    // Regular Colors
    public static final String blk = "\u001B[0;30m";   // blk
    public static final String rd = "\u001B[0;5;31m";     // rd
    public static final String grn = "\u001B[0;32m";   // grn
    public static final String ylo = "\u001B[0;33m";  // ylo
    public static final String blu = "\u001B[0;34m";    // blu
    public static final String prpl = "\u001B[0;35m";  // prpl
    public static final String cyan = "\u001B[0;36m";    // cyan
    public static final String wht = "\u001B[0;37m";   // wht

    // Bold
    public static final String blk_bld = "\u001B[3;30m";  // blk
    public static final String rd_bld = "\u001B[3;5;31m";    // rd
    public static final String grn_bld = "\u001B[3;32m";  // grn
    public static final String ylo_bld = "\u001B[3;33m"; // ylo
    public static final String blu_bld = "\u001B[3;34m";   // blu
    public static final String prpl_bld = "\u001B[3;35m"; // prpl
    public static final String cyan_bld = "\u001B[3;36m";   // cyan
    public static final String wht_bld = "\u001B[3;37m";  // wht

    // Underline
    public static final String blk_ul = "\u001B[4;30m";  // blk
    public static final String rd_ul = "\u001B[4;5;31m";    // rd
    public static final String grn_ul = "\u001B[4;32m";  // grn
    public static final String ylo_ul = "\u001B[4;33m"; // ylo
    public static final String blu_ul = "\u001B[4;34m";   // blu
    public static final String prpl_ul = "\u001B[4;35m"; // prpl
    public static final String cyan_ul = "\u001B[4;36m";   // cyan
    public static final String wht_ul = "\u001B[4;37m";  // wht

    // Background
    public static final String blk_bg = "\u001B[2;40m";  // blk
    public static final String rd_bg = "\u001B[2;41m";    // rd
    public static final String grn_bg = "\u001B[2;42m";  // grn
    public static final String ylo_bg = "\u001B[2;43m"; // ylo
    public static final String blu_bg = "\u001B[2;44m";   // blu
    public static final String prpl_bg = "\u001B[2;45m"; // prpl
    public static final String cyan_bg = "\u001B[2;2;2;46m";   // cyan
    public static final String wht_bg = "\u001B[2;47m";  // wht

    // High Intensity
    public static final String blk_brt = "\u001B[1;30m";  // blk
    public static final String rd_brt = "\u001B[1;5;31m";    // rd
    public static final String grn_brt = "\u001B[1;32m";  // grn
    public static final String ylo_brt = "\u001B[1;33m"; // ylo
    public static final String blu_brt = "\u001B[1;34m";   // blu
    public static final String prpl_brt = "\u001B[1;35m"; // prpl
    public static final String cyan_brt = "\u001B[1;36m";   // cyan
    public static final String wht_brt = "\u001B[1;37m";  // wht

    // Bold High Intensity
    public static final String blk_bld_brt = "\033[3;1;30m"; // blk
    public static final String rd_bld_brt = "\u001B[3;1;5;31m";   // rd
    public static final String grn_bld_brt = "\u001B[3;1;32m"; // grn
    public static final String ylo_bld_brt = "\u001B[3;1;1;33m";// ylo
    public static final String blu_bld_brt = "\u001B[3;1;34m";  // blu
    public static final String prpl_bld_brt = "\u001B[3;1;35m";// prpl
    public static final String cyan_bld_brt = "\u001B[3;1;36m";  // cyan
    public static final String wht_bld_brt = "\u001B[3;1;37m"; // wht

    // High Intensity backgrounds
    public static final String blk_bg_brt = "\u001B[0;100m";// blk
    public static final String rd_bg_brt = "\u001B[0;101m";// rd
    public static final String grn_bg_brt = "\u001B[0;102m";// grn
    public static final String ylo_bg_brt = "\u001B[0;103m";// ylo
    public static final String blu_bg_brt = "\u001B[0;104m";// blu
    public static final String prpl_bg_brt = "\u001B[0;105m"; // prpl
    public static final String cyan_bg_brt = "\u001B[0;106m";  // cyan
    public static final String wht_bg_brt = "\u001B[0;107m";   // wht
    
    
    public static final String[] bright_bold_array = {
        blk_bld_brt, rd_bld_brt,
        grn_bld_brt, ylo_bld_brt,
        blu_bld_brt, prpl_bld_brt,
        cyan_bld_brt, wht_bld_brt
    };
}
