
/**
 * I borrowed the idea and some of the syntax for this class from:
 *
 *    https://stackoverflow.com/a/45444716/7412747
 */
class ConColor {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String blk = "\033[0;30m";   // blk
    public static final String rd = "\033[0;31m";     // rd
    public static final String grn = "\033[0;32m";   // grn
    public static final String ylo = "\033[0;33m";  // ylo
    public static final String blu = "\033[0;34m";    // blu
    public static final String prpl = "\033[0;35m";  // prpl
    public static final String cyan = "\033[0;36m";    // cyan
    public static final String wht = "\033[0;37m";   // wht

    // Bold
    public static final String blk_bld = "\033[1;30m";  // blk
    public static final String rd_bld = "\033[1;31m";    // rd
    public static final String grn_bld = "\033[1;32m";  // grn
    public static final String ylo_bld = "\033[1;33m"; // ylo
    public static final String blu_bld = "\033[1;34m";   // blu
    public static final String prpl_bld = "\033[1;35m"; // prpl
    public static final String cyan_bld = "\033[1;36m";   // cyan
    public static final String wht_bld = "\033[1;37m";  // wht

    // Underline
    public static final String blk_ul = "\033[4;30m";  // blk
    public static final String rd_ul = "\033[4;31m";    // rd
    public static final String grn_ul = "\033[4;32m";  // grn
    public static final String ylo_ul = "\033[4;33m"; // ylo
    public static final String blu_ul = "\033[4;34m";   // blu
    public static final String prpl_ul = "\033[4;35m"; // prpl
    public static final String cyan_ul = "\033[4;36m";   // cyan
    public static final String wht_ul = "\033[4;37m";  // wht

    // Background
    public static final String blk_bg = "\033[40m";  // blk
    public static final String rd_bg = "\033[41m";    // rd
    public static final String grn_bg = "\033[42m";  // grn
    public static final String ylo_bg = "\033[43m"; // ylo
    public static final String blu_bg = "\033[44m";   // blu
    public static final String prpl_bg = "\033[45m"; // prpl
    public static final String cyan_bg = "\033[46m";   // cyan
    public static final String wht_bg = "\033[47m";  // wht

    // High Intensity
    public static final String blk_brt = "\033[0;90m";  // blk
    public static final String rd_brt = "\033[0;91m";    // rd
    public static final String grn_brt = "\033[0;92m";  // grn
    public static final String ylo_brt = "\033[0;93m"; // ylo
    public static final String blu_brt = "\033[0;94m";   // blu
    public static final String prpl_brt = "\033[0;95m"; // prpl
    public static final String cyan_brt = "\033[0;96m";   // cyan
    public static final String wht_brt = "\033[0;97m";  // wht

    // Bold High Intensity
    public static final String blk_bld_brt = "\033[1;90m"; // blk
    public static final String rd_bld_brt = "\033[1;91m";   // rd
    public static final String grn_bld_brt = "\033[1;92m"; // grn
    public static final String ylo_bld_brt = "\033[1;93m";// ylo
    public static final String blu_bld_brt = "\033[1;94m";  // blu
    public static final String prpl_bld_brt = "\033[1;95m";// prpl
    public static final String cyan_bld_brt = "\033[1;96m";  // cyan
    public static final String wht_bld_brt = "\033[1;97m"; // wht

    // High Intensity backgrounds
    public static final String blk_bg_brt = "\033[0;100m";// blk
    public static final String rd_bg_brt = "\033[0;101m";// rd
    public static final String grn_bg_brt = "\033[0;102m";// grn
    public static final String ylo_bg_brt = "\033[0;103m";// ylo
    public static final String blu_bg_brt = "\033[0;104m";// blu
    public static final String prpl_bg_brt = "\033[0;105m"; // prpl
    public static final String cyan_bg_brt = "\033[0;106m";  // cyan
    public static final String wht_bg_brt = "\033[0;107m";   // wht

}
