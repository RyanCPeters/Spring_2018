//
//
//enum ColorEnum {
//    RED (ConColor.rd,ConColor.rd_bld, ConColor.rd_brt, ConColor.rd_bld_brt),
//    GREEN (ConColor.grn,ConColor.grn, ConColor.grn, ConColor.grn_bld_brt),
//    YELLOW (ConColor.ylo,ConColor.ylo_bld, ConColor.ylo_brt, ConColor.ylo_bld_brt),
//    BLUE (ConColor.blu,ConColor.blu_bld, ConColor.blu_brt, ConColor.blu_bld_brt),
//    PURPLE (ConColor.prpl,ConColor.prpl_bld, ConColor.prpl_brt, ConColor.prpl_bld_brt),
//    CYAN (ConColor.cyan,ConColor.cyan_bld, ConColor.cyan_brt, ConColor.cyan_bld_brt),
//    WHITE (ConColor.wht,ConColor.wht_bld, ConColor.wht_brt, ConColor.wht_bld_brt),
//    RESET (ConColor.RESET,"","","")
//
//    ;
//
//    private final String basic;
//    private final String bold;
//    private final String bright;
//    private final String brightBold;
//    private static int placeInList = 0;
//
//    private
//
//    ColorEnum(String bas,String bld, String bri, String briBol) {
//        basic = bas;
//        bold = bld;
//        bright = bri;
//        brightBold = briBol;
//    }
//
//
//    public String assignColor(boolean mapPath ,boolean contig1, String val ){
//        if(mapPath){
//
//        }else if(contig1){
//            if(val == "1")return getn
//        }
//    }
//
//    private String deriveColor(boolean increment){
//        switch (){
//            case 0:
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//            case 10:
//            case 11:
//            case 12:
//            default:
//                return
//        }
//    }
//}
//
//
//enum Planet {
//    MERCURY (3.303e+23, 2.4397e6),
//    VENUS   (4.869e+24, 6.0518e6),
//    EARTH   (5.976e+24, 6.37814e6),
//    MARS    (6.421e+23, 3.3972e6),
//    JUPITER (1.9e+27,   7.1492e7),
//    SATURN  (5.688e+26, 6.0268e7),
//    URANUS  (8.686e+25, 2.5559e7),
//    NEPTUNE (1.024e+26, 2.4746e7);
//
//    private final double mass;   // in kilograms
//    private final double radius; // in meters
//    Planet(double mass, double radius) {
//        this.mass = mass;
//        this.radius = radius;
//    }
//    private double mass() { return mass; }
//    private double radius() { return radius; }
//
//    // universal gravitational constant  (m3 kg-1 s-2)
//    public static final double G = 6.67300E-11;
//
//    double surfaceGravity() {
//        return G * mass / (radius * radius);
//    }
//    double surfaceWeight(double otherMass) {
//        return otherMass * surfaceGravity();
//    }
//    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.err.println("Usage: java Planet <earth_weight>");
//            System.exit(-1);
//        }
//        double earthWeight = Double.parseDouble(args[0]);
//        double mass = earthWeight/EARTH.surfaceGravity();
//        for (Planet p : Planet.values())
//            System.out.printf("Your weight on %s is %f%n",
//                    p, p.surfaceWeight(mass));
//    }
//}