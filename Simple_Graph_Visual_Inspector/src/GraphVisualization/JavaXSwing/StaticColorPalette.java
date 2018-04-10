package GraphVisualization.JavaXSwing;

import java.awt.Color;

public class StaticColorPalette {
    /**
     *
     * @param palette
     * @param colorIDX
     * @return
     */
    public static Color getPaletteAsAWTColor(int[][] palette, int colorIDX){
        return new Color(palette[colorIDX][0],palette[colorIDX][1],palette[colorIDX][2]);
    }

    /**
     *
     */
    public static final Integer[][] arrDustPalette =
            {
                    {255,  73,  31},
                    {142, 104, 204},
                    { 85,  78,  93},
                    {186, 178, 195},
                    {255, 138, 112}
            };
    /**
     *
     */
    public static final Color[] awtDustPalette =
            {
                    new Color(255,  73,  31),
                    new Color(142, 104, 204),
                    new Color( 85,  78,  93),
                    new Color(186, 178, 195),
                    new Color(255, 138, 112)
            };

    /**
     *
     */
    public static final Integer[][] arrMyCustomChoice =
            {
                    {154, 161, 202},
                    { 12,  12,  12},
                    { 90,  69,  59},
                    {177, 197, 246},
                    {122, 103,  96}
            };
    /**
     *
     */
    public static final Color[] awtMyCustomChoice =
            {
                    new Color(122, 103,  96),
                    new Color( 90,  69,  59),
                    new Color(177, 197, 246),
                    new Color(100, 122, 202),
                    new Color( 12,  12,  12)
            };
    /**
     *
     */
    public static final Color[] awtContOnesTransition =
            {
                    new Color(255,  73,  31),
                    new Color(137,  61,  33),
                    new Color( 95,  52,  35),
                    new Color( 73,  46,  38),
                    new Color( 61,  41,  41),
                    new Color( 52,  38,  46),
                    new Color( 46,  41,  52),
                    new Color( 41,  46,  61),
                    new Color( 38,  52,  73),
                    new Color( 35,  61,  95),
                    new Color( 33,  73, 137),
                    new Color( 31,  95, 255)
            };
    /**
     *
     */
    public static final Integer[][] intContOnesTransition =
            {
                    {255,  73,  31},
                    {137,  61,  33},
                    { 95,  52,  35},
                    { 73,  46,  38},
                    { 61,  41,  41},
                    { 52,  38,  46},
                    { 46,  41,  52},
                    { 41,  46,  61},
                    { 38,  52,  73},
                    { 35,  61,  95},
                    { 33,  73, 137},
                    { 31,  95, 255}
            };
    /**
     *
     */
    public static final Integer[][] arrMatchingGradient =
            {
                    {161,  71,  71},
                    {172,  73, 113},
                    {160,  89, 159},
                    {118, 113, 200},
                    {  0, 137, 224},
                    {  0, 157, 223}
            };
    /**
     *
     */
    public static final Color[] awtMatchingGradient =
            {
                    new Color(118, 113, 200),
                    new Color(160,  89, 159),
                    new Color( 12,  12,  12),
                    new Color(  0, 157, 223),
                    new Color(172,  73, 113),
                    new Color(161,  71,  71),
                    new Color(  0, 137, 224)
            };
    /**
     *
     */
    public static final Integer[][] arrMatchingPalette =
            {
                    {161,  71,  71},
                    { 87,  66,  64},
                    {191, 165, 163},
                    {  0, 112, 157},
                    {  0, 164, 212}
            };
    /**
     *
     */
    public static final Color[] awtMatchingPalette =
            {
                    new Color(161,  71,  71),
                    new Color( 87,  66,  64),
                    new Color(191, 165, 163),
                    new Color(  0, 112, 157),
                    new Color(  0, 164, 212)
            };

/////////////////////////////////////////////////////////////////////////////
/////////// Bellow are color options that we aren't using for now
/////////////////////////////////////////////////////////////////////////////
    /**
     *
     */
    public static final Integer[][] arrClassyPalette =
            {
                    {171,  81,  81},
                    { 97,  76,  74},
                    {201, 175, 173},
                    { 98, 116,  43},
                    {150, 168,  92}
            };
    /**
     *
     */
    public static final Color[] awtClassyPalette =
            {
                    new Color(171,  81,  81),
                    new Color( 97,  76,  74),
                    new Color(201, 175, 173),
                    new Color( 98, 116,  43),
                    new Color(150, 168,  92)
            };
    public static final Integer[][] arrGenericGradient =
            {
                    {161,  71,  71},
                    {145,  68,  95},
                    {118,  71, 111},
                    { 86,  75, 113},
                    { 60,  75, 104},
                    { 47,  72,  88}
            };

    public static final Color[] awtGenericGradient =
            {
                    new Color(161,  71,  71),
                    new Color(145,  68,  95),
                    new Color(118,  71, 111),
                    new Color( 86,  75, 113),
                    new Color( 60,  75, 104),
                    new Color( 47,  72,  88)
            };



    public static final Integer[][] arrSpotPalette =
            {
                    {161,  71,  71},
                    {220, 122, 119},
                    {255, 228, 224},
                    {  0, 194, 255}
            };

    public static final Color[] awtSpotPalette =
            {
                    new Color(161,  71,  71),
                    new Color(220, 122, 119),
                    new Color(255, 228, 224),
                    new Color(  0, 194, 255)
            };

    public static final Integer[][] arrTwistedSpotPalette =
            {
                    {161,  71,  71},
                    {  0, 194, 255},
                    {198, 248, 255},
                    { 76, 125, 147}
            };

    public static final Color[] awtTwistedSpotPalette =
            {
                    new Color(161,  71,  71),
                    new Color(  0, 194, 255),
                    new Color(198, 248, 255),
                    new Color( 76, 125, 147)
            };




    public static final Integer[][] arrCubePalette =
            {
                    {161,  71,  71},
                    {175, 127, 135},
                    {121, 136, 151}
            };

    public static final Color[] awtCubePalette =
            {
                    new Color(161,  71,  71),
                    new Color(175, 127, 135),
                    new Color(121, 136, 151)
            };

    public static final Integer[][] arrSwitchPalette =
            {
                    {161,  71,  71},
                    {255, 186, 181},
                    {  0, 194, 255},
                    {243, 238, 217}
            };

    public static final Color[] awtSwitchPalette =
            {
                    new Color(161,  71,  71),
                    new Color(255, 186, 181),
                    new Color(  0, 194, 255),
                    new Color(243, 238, 217)
            };

    public static final Integer[][] arrSmallSwitchPalette =
            {
                    {161,  71,  71},
                    {255, 236, 239},
                    {178, 114, 126}
            };

    public static final Color[] awtSmallSwitchPalette =
            {
                    new Color(161,  71,  71),
                    new Color(255, 236, 239),
                    new Color(178, 114, 126)
            };

    public static final Integer[][] arrSkipGradient =
            {
                    {161,  71,  71},
                    {255, 192, 255},
                    {242, 137, 198},
                    {184,  83, 144}
            };

    public static final Color[] awtSkipGradient =
            {
                    new Color(161,  71,  71),
                    new Color(255, 192, 255),
                    new Color(242, 137, 198),
                    new Color(184,  83, 144)
            };

    public static final Integer[][] arrNaturalPalette =
            {
                    {161,  71,  71},
                    {189, 130, 126},
                    {255, 244, 243},
                    {243, 238, 217}
            };

    public static final Color[] awtNaturalPalette =
            {
                    new Color(161,  71,  71),
                    new Color(189, 130, 126),
                    new Color(255, 244, 243),
                    new Color(243, 238, 217)
            };

    public static final Integer[][] arrSquashPalette =
            {
                    {161,  71,  71},
                    {  0, 120,  69},
                    { 99,  87, 175}
            };

    public static final Color[] awtSquashPalette =
            {
                    new Color(161,  71,  71),
                    new Color(  0, 120,  69),
                    new Color( 99,  87, 175)
            };

    public static final Integer[][] arrGreyFriends =
            {
                    {161,  71,  71},
                    { 87,  66,  64},
                    {191, 165, 163}
            };

    public static final Color[] awtGreyFriends =
            {
                    new Color(161,  71,  71),
                    new Color( 87,  66,  64),
                    new Color(191, 165, 163)
            };

    public static final Integer[][] arrDottingPalette =
            {
                    {161,  71,  71},
                    {191, 165, 163},
                    { 88, 106,  33},
                    {170, 173, 155}
            };

    public static final Color[] awtDottingPalette =
            {
                    new Color(161,  71,  71),
                    new Color(191, 165, 163),
                    new Color( 88, 106,  33),
                    new Color(170, 173, 155)
            };

    public static final Integer[][] arrSkipShadeGradient =
            {
                    {161,  71,  71},
                    {213, 107, 125},
                    {255, 147, 187},
                    {255, 192, 255}
            };

    public static final Color[] awtSkipShadeGradient =
            {
                    new Color(161,  71,  71),
                    new Color(213, 107, 125),
                    new Color(255, 147, 187),
                    new Color(255, 192, 255)
            };

    public static final Integer[][] arrThreedom =
            {
                    {161,  71,  71},
                    {  0, 117,  39},
                    {  0, 107, 196}
            };

    public static final Color[] awtThreedom =
            {
                    new Color(161,  71,  71),
                    new Color(  0, 117,  39),
                    new Color(  0, 107, 196)
            };

    public static final Integer[][] arrHighlightPalette =
            {
                    {161,  71,  71},
                    {255, 116, 119},
                    {243, 238, 217},
                    {121, 136, 151}
            };

    public static final Color[] awtHighlightPalette =
            {
                    new Color(161,  71,  71),
                    new Color(255, 116, 119),
                    new Color(243, 238, 217),
                    new Color(121, 136, 151)
            };

    public static final Integer[][] arrNeighborPalette =
            {
                    {161,  71,  71},
                    {106,  63,  72},
                    {174, 104, 118},
                    {196, 171, 174}
            };

    public static final Color[] awtNeighborPalette =
            {
                    new Color(161,  71,  71),
                    new Color(106,  63,  72),
                    new Color(174, 104, 118),
                    new Color(196, 171, 174)
            };

    public static final Integer[][] arrDiscreetPalette =
            {
                    {161,  71,  71},
                    {189, 130, 126},
                    {255, 243, 241},
                    {121, 136, 151}
            };

    public static final Color[] awtDiscreetPalette =
            {
                    new Color(161,  71,  71),
                    new Color(189, 130, 126),
                    new Color(255, 243, 241),
                    new Color(121, 136, 151)
            };

    public static final Integer[][] arrCollective =
            {
                    {161,  71,  71},
                    {168,  68,  25},
                    { 80, 109,   0}
            };

    public static final Color[] awtCollective =
            {
                    new Color(161,  71,  71),
                    new Color(168,  68,  25),
                    new Color( 80, 109,   0)
            };

    public static final Integer[][] arrFriendpalette =
            {
                    {161,  71,  71},
                    {243, 143, 140},
                    {  0, 194, 255},
                    {  0,  89, 165}
            };

    public static final Color[] awtFriendpalette =
            {
                    new Color(161,  71,  71),
                    new Color(243, 143, 140),
                    new Color(  0, 194, 255),
                    new Color(  0,  89, 165)
            };

    public static final Integer[][] arrPinPalette =
            {
                    {161,  71,  71},
                    {255, 116, 119},
                    {243, 238, 217},
                    {  0, 194, 255}
            };

    public static final Color[] awtPinPalette =
            {
                    new Color(161,  71,  71),
                    new Color(255, 116, 119),
                    new Color(243, 238, 217),
                    new Color(  0, 194, 255)
            };

    public static final Integer[][] arrShades =
            {
                    {161,  71,  71},
                    {195, 100,  99},
                    {229, 131, 127},
                    {255, 162, 158},
                    {255, 194, 189}
            };

    public static final Color[] awtShades =
            {
                    new Color(161,  71,  71),
                    new Color(195, 100,  99),
                    new Color(229, 131, 127),
                    new Color(255, 162, 158),
                    new Color(255, 194, 189)
            };




}
