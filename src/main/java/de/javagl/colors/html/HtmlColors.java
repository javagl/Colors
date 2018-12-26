/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 * 
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package de.javagl.colors.html;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * The HTML/CSS colors, as defined in 
 * https://www.w3.org/TR/css-color-3/#svg-color
 */
public class HtmlColors
{
    /**
     * The AliceBlue color (0xF0F8FF)
     */
    public static final Color AliceBlue = new Color(0xF0F8FF);
    
    /**
     * The AntiqueWhite color (0xFAEBD7)
     */
    public static final Color AntiqueWhite = new Color(0xFAEBD7);
    
    /**
     * The Aqua color ()
     */
    public static final Color Aqua = new Color(0x00FFFF);
    
    /**
     * The Aquamarine color (0x7FFFD4)
     */
    public static final Color Aquamarine = new Color(0x7FFFD4);
    
    /**
     * The Azure color (0xF0FFFF)
     */
    public static final Color Azure = new Color(0xF0FFFF);
    
    /**
     * The Beige color (0xF5F5DC)
     */
    public static final Color Beige = new Color(0xF5F5DC);
    
    /**
     * The Bisque color (0xFFE4C4)
     */
    public static final Color Bisque = new Color(0xFFE4C4);
    
    /**
     * The Black color (0x000000)
     */
    public static final Color Black = new Color(0x000000);
    
    /**
     * The BlanchedAlmond color (0xFFEBCD)
     */
    public static final Color BlanchedAlmond = new Color(0xFFEBCD);
    
    /**
     * The Blue color (0x0000FF)
     */
    public static final Color Blue = new Color(0x0000FF);
    
    /**
     * The BlueViolet color (0x8A2BE2)
     */
    public static final Color BlueViolet = new Color(0x8A2BE2);
    
    /**
     * The Brown color (0xA52A2A)
     */
    public static final Color Brown = new Color(0xA52A2A);
    
    /**
     * The BurlyWood color (0xDEB887)
     */
    public static final Color BurlyWood = new Color(0xDEB887);
    
    /**
     * The CadetBlue color (0x5F9EA0)
     */
    public static final Color CadetBlue = new Color(0x5F9EA0);
    
    /**
     * The Chartreuse color (0x7FFF00)
     */
    public static final Color Chartreuse = new Color(0x7FFF00);
    
    /**
     * The Chocolate color (0xD2691E)
     */
    public static final Color Chocolate = new Color(0xD2691E);
    
    /**
     * The Coral color (0xFF7F50)
     */
    public static final Color Coral = new Color(0xFF7F50);
    
    /**
     * The CornflowerBlue color (0x6495ED)
     */
    public static final Color CornflowerBlue = new Color(0x6495ED);
    
    /**
     * The Cornsilk color (0xFFF8DC)
     */
    public static final Color Cornsilk = new Color(0xFFF8DC);
    
    /**
     * The Crimson color (0xDC143C)
     */
    public static final Color Crimson = new Color(0xDC143C);
    
    /**
     * The Cyan color (0x00FFFF)
     */
    public static final Color Cyan = new Color(0x00FFFF);
    
    /**
     * The DarkBlue color (0x00008B)
     */
    public static final Color DarkBlue = new Color(0x00008B);
    
    /**
     * The DarkCyan color (0x008B8B)
     */
    public static final Color DarkCyan = new Color(0x008B8B);
    
    /**
     * The DarkGoldenRod color (0xB8860B)
     */
    public static final Color DarkGoldenRod = new Color(0xB8860B);
    
    /**
     * The DarkGray color (0xA9A9A9)
     */
    public static final Color DarkGray = new Color(0xA9A9A9);
    
    /**
     * The DarkGreen color (0x006400)
     */
    public static final Color DarkGreen = new Color(0x006400);
    
    /**
     * The DarkKhaki color (0xBDB76B)
     */
    public static final Color DarkKhaki = new Color(0xBDB76B);
    
    /**
     * The DarkMagenta color (0x8B008B)
     */
    public static final Color DarkMagenta = new Color(0x8B008B);
    
    /**
     * The DarkOliveGreen color (0x556B2F)
     */
    public static final Color DarkOliveGreen = new Color(0x556B2F);
    
    /**
     * The DarkOrange color (0xFF8C00)
     */
    public static final Color DarkOrange = new Color(0xFF8C00);
    
    /**
     * The DarkOrchid color (0x9932CC)
     */
    public static final Color DarkOrchid = new Color(0x9932CC);
    
    /**
     * The DarkRed color (0x8B0000)
     */
    public static final Color DarkRed = new Color(0x8B0000);
    
    /**
     * The DarkSalmon color (0xE9967A)
     */
    public static final Color DarkSalmon = new Color(0xE9967A);
    
    /**
     * The DarkSeaGreen color (0x8FBC8F)
     */
    public static final Color DarkSeaGreen = new Color(0x8FBC8F);
    
    /**
     * The DarkSlateBlue color (0x483D8B)
     */
    public static final Color DarkSlateBlue = new Color(0x483D8B);
    
    /**
     * The DarkSlateGray color (0x2F4F4F)
     */
    public static final Color DarkSlateGray = new Color(0x2F4F4F);
    
    /**
     * The DarkTurquoise color (0x00CED1)
     */
    public static final Color DarkTurquoise = new Color(0x00CED1);
    
    /**
     * The DarkViolet color (0x9400D3)
     */
    public static final Color DarkViolet = new Color(0x9400D3);
    
    /**
     * The DeepPink color (0xFF1493)
     */
    public static final Color DeepPink = new Color(0xFF1493);
    
    /**
     * The DeepSkyBlue color (0x00BFFF)
     */
    public static final Color DeepSkyBlue = new Color(0x00BFFF);
    
    /**
     * The DimGray color (0x696969)
     */
    public static final Color DimGray = new Color(0x696969);
    
    /**
     * The DodgerBlue color (0x1E90FF)
     */
    public static final Color DodgerBlue = new Color(0x1E90FF);
    
    /**
     * The FireBrick color (0xB22222)
     */
    public static final Color FireBrick = new Color(0xB22222);
    
    /**
     * The FloralWhite color (0xFFFAF0)
     */
    public static final Color FloralWhite = new Color(0xFFFAF0);
    
    /**
     * The ForestGreen color (0x228B22)
     */
    public static final Color ForestGreen = new Color(0x228B22);
    
    /**
     * The Fuchsia color (0xFF00FF)
     */
    public static final Color Fuchsia = new Color(0xFF00FF);
    
    /**
     * The Gainsboro color (0xDCDCDC)
     */
    public static final Color Gainsboro = new Color(0xDCDCDC);
    
    /**
     * The GhostWhite color (0xF8F8FF)
     */
    public static final Color GhostWhite = new Color(0xF8F8FF);
    
    /**
     * The Gold color (0xFFD700)
     */
    public static final Color Gold = new Color(0xFFD700);
    
    /**
     * The GoldenRod color (0xDAA520)
     */
    public static final Color GoldenRod = new Color(0xDAA520);
    
    /**
     * The Gray color (0x808080)
     */
    public static final Color Gray = new Color(0x808080);
    
    /**
     * The Green color (0x008000)
     */
    public static final Color Green = new Color(0x008000);
    
    /**
     * The GreenYellow color (0xADFF2F)
     */
    public static final Color GreenYellow = new Color(0xADFF2F);
    
    /**
     * The HoneyDew color (0xF0FFF0)
     */
    public static final Color HoneyDew = new Color(0xF0FFF0);
    
    /**
     * The HotPink color (0xFF69B4)
     */
    public static final Color HotPink = new Color(0xFF69B4);
    
    /**
     * The IndianRed color (0xCD5C5C)
     */
    public static final Color IndianRed = new Color(0xCD5C5C);
    
    /**
     * The Indigo color ()
     */
    public static final Color Indigo = new Color(0x4B0082);
    
    /**
     * The Ivory color (0xFFFFF0)
     */
    public static final Color Ivory = new Color(0xFFFFF0);
    
    /**
     * The Khaki color (0xF0E68C)
     */
    public static final Color Khaki = new Color(0xF0E68C);
    
    /**
     * The Lavender color (0xE6E6FA)
     */
    public static final Color Lavender = new Color(0xE6E6FA);
    
    /**
     * The LavenderBlush color (0xFFF0F5)
     */
    public static final Color LavenderBlush = new Color(0xFFF0F5);
    
    /**
     * The LawnGreen color (0x7CFC00)
     */
    public static final Color LawnGreen = new Color(0x7CFC00);
    
    /**
     * The LemonChiffon color (0xFFFACD)
     */
    public static final Color LemonChiffon = new Color(0xFFFACD);
    
    /**
     * The LightBlue color ()
     */
    public static final Color LightBlue = new Color(0xADD8E6);
    
    /**
     * The LightCoral color (0xF08080)
     */
    public static final Color LightCoral = new Color(0xF08080);
    
    /**
     * The LightCyan color (0xE0FFFF)
     */
    public static final Color LightCyan = new Color(0xE0FFFF);
    
    /**
     * The LightGoldenRodYellow color (0xFAFAD2)
     */
    public static final Color LightGoldenRodYellow = new Color(0xFAFAD2);
    
    /**
     * The LightGray color (0xD3D3D3)
     */
    public static final Color LightGray = new Color(0xD3D3D3);
    
    /**
     * The LightGreen color (0x90EE90)
     */
    public static final Color LightGreen = new Color(0x90EE90);
    
    /**
     * The LightPink color (0xFFB6C1)
     */
    public static final Color LightPink = new Color(0xFFB6C1);
    
    /**
     * The LightSalmon color (0xFFA07A)
     */
    public static final Color LightSalmon = new Color(0xFFA07A);
    
    /**
     * The LightSeaGreen color (0x20B2AA)
     */
    public static final Color LightSeaGreen = new Color(0x20B2AA);
    
    /**
     * The LightSkyBlue color (0x87CEFA)
     */
    public static final Color LightSkyBlue = new Color(0x87CEFA);
    
    /**
     * The LightSlateGray color (0x778899)
     */
    public static final Color LightSlateGray = new Color(0x778899);
    
    /**
     * The LightSteelBlue color (0xB0C4DE)
     */
    public static final Color LightSteelBlue = new Color(0xB0C4DE);
    
    /**
     * The LightYellow color (0xFFFFE0)
     */
    public static final Color LightYellow = new Color(0xFFFFE0);
    
    /**
     * The Lime color (0x00FF00)
     */
    public static final Color Lime = new Color(0x00FF00);
    
    /**
     * The LimeGreen color (0x32CD32)
     */
    public static final Color LimeGreen = new Color(0x32CD32);
    
    /**
     * The Linen color ()
     */
    public static final Color Linen = new Color(0xFAF0E6);
    
    /**
     * The Magenta color (0xFF00FF)
     */
    public static final Color Magenta = new Color(0xFF00FF);
    
    /**
     * The Maroon color (0x800000)
     */
    public static final Color Maroon = new Color(0x800000);
    
    /**
     * The MediumAquaMarine color (0x66CDAA)
     */
    public static final Color MediumAquaMarine = new Color(0x66CDAA);
    
    /**
     * The MediumBlue color (0x0000CD)
     */
    public static final Color MediumBlue = new Color(0x0000CD);
    
    /**
     * The MediumOrchid color (0xBA55D3)
     */
    public static final Color MediumOrchid = new Color(0xBA55D3);
    
    /**
     * The MediumPurple color (0x9370DB)
     */
    public static final Color MediumPurple = new Color(0x9370DB);
    
    /**
     * The MediumSeaGreen color (0x3CB371)
     */
    public static final Color MediumSeaGreen = new Color(0x3CB371);
    
    /**
     * The MediumSlateBlue color (0x7B68EE)
     */
    public static final Color MediumSlateBlue = new Color(0x7B68EE);
    
    /**
     * The MediumSpringGreen color (0x00FA9A)
     */
    public static final Color MediumSpringGreen = new Color(0x00FA9A);
    
    /**
     * The MediumTurquoise color (0x48D1CC)
     */
    public static final Color MediumTurquoise = new Color(0x48D1CC);
    
    /**
     * The MediumVioletRed color (0xC71585)
     */
    public static final Color MediumVioletRed = new Color(0xC71585);
    
    /**
     * The MidnightBlue color ()
     */
    public static final Color MidnightBlue = new Color(0x191970);
    
    /**
     * The MintCream color (0xF5FFFA)
     */
    public static final Color MintCream = new Color(0xF5FFFA);
    
    /**
     * The MistyRose color (0xFFE4E1)
     */
    public static final Color MistyRose = new Color(0xFFE4E1);
    
    /**
     * The Moccasin color (0xFFE4B5)
     */
    public static final Color Moccasin = new Color(0xFFE4B5);
    
    /**
     * The NavajoWhite color (0xFFDEAD)
     */
    public static final Color NavajoWhite = new Color(0xFFDEAD);
    
    /**
     * The Navy color (0x000080)
     */
    public static final Color Navy = new Color(0x000080);
    
    /**
     * The OldLace color (0xFDF5E6)
     */
    public static final Color OldLace = new Color(0xFDF5E6);
    
    /**
     * The Olive color (0x808000)
     */
    public static final Color Olive = new Color(0x808000);
    
    /**
     * The OliveDrab color (0x6B8E23)
     */
    public static final Color OliveDrab = new Color(0x6B8E23);
    
    /**
     * The Orange color (0xFFA500)
     */
    public static final Color Orange = new Color(0xFFA500);
    
    /**
     * The OrangeRed color (0xFF4500)
     */
    public static final Color OrangeRed = new Color(0xFF4500);
    
    /**
     * The Orchid color (0xDA70D6)
     */
    public static final Color Orchid = new Color(0xDA70D6);
    
    /**
     * The PaleGoldenRod color (0xEEE8AA)
     */
    public static final Color PaleGoldenRod = new Color(0xEEE8AA);
    
    /**
     * The PaleGreen color (0x98FB98)
     */
    public static final Color PaleGreen = new Color(0x98FB98);
    
    /**
     * The PaleTurquoise color (0xAFEEEE)
     */
    public static final Color PaleTurquoise = new Color(0xAFEEEE);
    
    /**
     * The PaleVioletRed color (0xDB7093)
     */
    public static final Color PaleVioletRed = new Color(0xDB7093);
    
    /**
     * The PapayaWhip color (0xFFEFD5)
     */
    public static final Color PapayaWhip = new Color(0xFFEFD5);
    
    /**
     * The PeachPuff color (0xFFDAB9)
     */
    public static final Color PeachPuff = new Color(0xFFDAB9);
    
    /**
     * The Peru color (0xCD853F)
     */
    public static final Color Peru = new Color(0xCD853F);
    
    /**
     * The Pink color (0xFFC0CB)
     */
    public static final Color Pink = new Color(0xFFC0CB);
    
    /**
     * The Plum color (0xDDA0DD)
     */
    public static final Color Plum = new Color(0xDDA0DD);
    
    /**
     * The PowderBlue color (0xB0E0E6)
     */
    public static final Color PowderBlue = new Color(0xB0E0E6);
    
    /**
     * The Purple color ()
     */
    public static final Color Purple = new Color(0x800080);
    
    /**
     * The Red color (0xFF0000)
     */
    public static final Color Red = new Color(0xFF0000);
    
    /**
     * The RosyBrown color (0xBC8F8F)
     */
    public static final Color RosyBrown = new Color(0xBC8F8F);
    
    /**
     * The RoyalBlue color (0x4169E1)
     */
    public static final Color RoyalBlue = new Color(0x4169E1);
    
    /**
     * The SaddleBrown color (0x8B4513)
     */
    public static final Color SaddleBrown = new Color(0x8B4513);
    
    /**
     * The Salmon color (0xFA8072)
     */
    public static final Color Salmon = new Color(0xFA8072);
    
    /**
     * The SandyBrown color (0xF4A460)
     */
    public static final Color SandyBrown = new Color(0xF4A460);
    
    /**
     * The SeaGreen color (0x2E8B57)
     */
    public static final Color SeaGreen = new Color(0x2E8B57);
    
    /**
     * The SeaShell color (0xFFF5EE)
     */
    public static final Color SeaShell = new Color(0xFFF5EE);
    
    /**
     * The Sienna color (0xA0522D)
     */
    public static final Color Sienna = new Color(0xA0522D);
    
    /**
     * The Silver color (0xC0C0C0)
     */
    public static final Color Silver = new Color(0xC0C0C0);
    
    /**
     * The SkyBlue color (0x87CEEB)
     */
    public static final Color SkyBlue = new Color(0x87CEEB);
    
    /**
     * The SlateBlue color (0x6A5ACD)
     */
    public static final Color SlateBlue = new Color(0x6A5ACD);
    
    /**
     * The SlateGray color (0x708090)
     */
    public static final Color SlateGray = new Color(0x708090);
    
    /**
     * The Snow color (0xFFFAFA)
     */
    public static final Color Snow = new Color(0xFFFAFA);
    
    /**
     * The SpringGreen color (0x00FF7F)
     */
    public static final Color SpringGreen = new Color(0x00FF7F);
    
    /**
     * The SteelBlue color (0x4682B4)
     */
    public static final Color SteelBlue = new Color(0x4682B4);
    
    /**
     * The Tan color (0xD2B48C)
     */
    public static final Color Tan = new Color(0xD2B48C);
    
    /**
     * The Teal color (0x008080)
     */
    public static final Color Teal = new Color(0x008080);
    
    /**
     * The Thistle color ()
     */
    public static final Color Thistle = new Color(0xD8BFD8);
    
    /**
     * The Tomato color (0xFF6347)
     */
    public static final Color Tomato = new Color(0xFF6347);
    
    /**
     * The Turquoise color (0x40E0D0)
     */
    public static final Color Turquoise = new Color(0x40E0D0);
    
    /**
     * The Violet color (0xEE82EE)
     */
    public static final Color Violet = new Color(0xEE82EE);
    
    /**
     * The Wheat color (0xF5DEB3)
     */
    public static final Color Wheat = new Color(0xF5DEB3);
    
    /**
     * The White color (0xFFFFFF)
     */
    public static final Color White = new Color(0xFFFFFF);
    
    /**
     * The WhiteSmoke color (0xF5F5F5)
     */
    public static final Color WhiteSmoke = new Color(0xF5F5F5);
    
    /**
     * The Yellow color (0xFFFF00)
     */
    public static final Color Yellow = new Color(0xFFFF00);
    
    /**
     * The YellowGreen color (0x9ACD32)
     */
    public static final Color YellowGreen = new Color(0x9ACD32);

    /**
     * The map from lowercase names to color objects
     */
    private static final Map<String, Color> colorsByName;
    
    /**
     * The set of all (CamelCase) names
     */
    private static final Set<String> colorNames;
    
    // Initialization of the color name set and mapping
    static
    {
        LinkedHashMap<String, Color> m = new LinkedHashMap<String, Color>();
        LinkedHashSet<String> s = new LinkedHashSet<String>();
        store(m, s, "AliceBlue", AliceBlue);
        store(m, s, "AntiqueWhite", AntiqueWhite);
        store(m, s, "Aqua", Aqua);
        store(m, s, "Aquamarine", Aquamarine);
        store(m, s, "Azure", Azure);
        store(m, s, "Beige", Beige);
        store(m, s, "Bisque", Bisque);
        store(m, s, "Black", Black);
        store(m, s, "BlanchedAlmond", BlanchedAlmond);
        store(m, s, "Blue", Blue);
        store(m, s, "BlueViolet", BlueViolet);
        store(m, s, "Brown", Brown);
        store(m, s, "BurlyWood", BurlyWood);
        store(m, s, "CadetBlue", CadetBlue);
        store(m, s, "Chartreuse", Chartreuse);
        store(m, s, "Chocolate", Chocolate);
        store(m, s, "Coral", Coral);
        store(m, s, "CornflowerBlue", CornflowerBlue);
        store(m, s, "Cornsilk", Cornsilk);
        store(m, s, "Crimson", Crimson);
        store(m, s, "Cyan", Cyan);
        store(m, s, "DarkBlue", DarkBlue);
        store(m, s, "DarkCyan", DarkCyan);
        store(m, s, "DarkGoldenRod", DarkGoldenRod);
        store(m, s, "DarkGray", DarkGray);
        store(m, s, "DarkGreen", DarkGreen);
        store(m, s, "DarkKhaki", DarkKhaki);
        store(m, s, "DarkMagenta", DarkMagenta);
        store(m, s, "DarkOliveGreen", DarkOliveGreen);
        store(m, s, "DarkOrange", DarkOrange);
        store(m, s, "DarkOrchid", DarkOrchid);
        store(m, s, "DarkRed", DarkRed);
        store(m, s, "DarkSalmon", DarkSalmon);
        store(m, s, "DarkSeaGreen", DarkSeaGreen);
        store(m, s, "DarkSlateBlue", DarkSlateBlue);
        store(m, s, "DarkSlateGray", DarkSlateGray);
        store(m, s, "DarkTurquoise", DarkTurquoise);
        store(m, s, "DarkViolet", DarkViolet);
        store(m, s, "DeepPink", DeepPink);
        store(m, s, "DeepSkyBlue", DeepSkyBlue);
        store(m, s, "DimGray", DimGray);
        store(m, s, "DodgerBlue", DodgerBlue);
        store(m, s, "FireBrick", FireBrick);
        store(m, s, "FloralWhite", FloralWhite);
        store(m, s, "ForestGreen", ForestGreen);
        store(m, s, "Fuchsia", Fuchsia);
        store(m, s, "Gainsboro", Gainsboro);
        store(m, s, "GhostWhite", GhostWhite);
        store(m, s, "Gold", Gold);
        store(m, s, "GoldenRod", GoldenRod);
        store(m, s, "Gray", Gray);
        store(m, s, "Green", Green);
        store(m, s, "GreenYellow", GreenYellow);
        store(m, s, "HoneyDew", HoneyDew);
        store(m, s, "HotPink", HotPink);
        store(m, s, "IndianRed", IndianRed);
        store(m, s, "Indigo", Indigo);
        store(m, s, "Ivory", Ivory);
        store(m, s, "Khaki", Khaki);
        store(m, s, "Lavender", Lavender);
        store(m, s, "LavenderBlush", LavenderBlush);
        store(m, s, "LawnGreen", LawnGreen);
        store(m, s, "LemonChiffon", LemonChiffon);
        store(m, s, "LightBlue", LightBlue);
        store(m, s, "LightCoral", LightCoral);
        store(m, s, "LightCyan", LightCyan);
        store(m, s, "LightGoldenRodYellow", LightGoldenRodYellow);
        store(m, s, "LightGray", LightGray);
        store(m, s, "LightGreen", LightGreen);
        store(m, s, "LightPink", LightPink);
        store(m, s, "LightSalmon", LightSalmon);
        store(m, s, "LightSeaGreen", LightSeaGreen);
        store(m, s, "LightSkyBlue", LightSkyBlue);
        store(m, s, "LightSlateGray", LightSlateGray);
        store(m, s, "LightSteelBlue", LightSteelBlue);
        store(m, s, "LightYellow", LightYellow);
        store(m, s, "Lime", Lime);
        store(m, s, "LimeGreen", LimeGreen);
        store(m, s, "Linen", Linen);
        store(m, s, "Magenta", Magenta);
        store(m, s, "Maroon", Maroon);
        store(m, s, "MediumAquaMarine", MediumAquaMarine);
        store(m, s, "MediumBlue", MediumBlue);
        store(m, s, "MediumOrchid", MediumOrchid);
        store(m, s, "MediumPurple", MediumPurple);
        store(m, s, "MediumSeaGreen", MediumSeaGreen);
        store(m, s, "MediumSlateBlue", MediumSlateBlue);
        store(m, s, "MediumSpringGreen", MediumSpringGreen);
        store(m, s, "MediumTurquoise", MediumTurquoise);
        store(m, s, "MediumVioletRed", MediumVioletRed);
        store(m, s, "MidnightBlue", MidnightBlue);
        store(m, s, "MintCream", MintCream);
        store(m, s, "MistyRose", MistyRose);
        store(m, s, "Moccasin", Moccasin);
        store(m, s, "NavajoWhite", NavajoWhite);
        store(m, s, "Navy", Navy);
        store(m, s, "OldLace", OldLace);
        store(m, s, "Olive", Olive);
        store(m, s, "OliveDrab", OliveDrab);
        store(m, s, "Orange", Orange);
        store(m, s, "OrangeRed", OrangeRed);
        store(m, s, "Orchid", Orchid);
        store(m, s, "PaleGoldenRod", PaleGoldenRod);
        store(m, s, "PaleGreen", PaleGreen);
        store(m, s, "PaleTurquoise", PaleTurquoise);
        store(m, s, "PaleVioletRed", PaleVioletRed);
        store(m, s, "PapayaWhip", PapayaWhip);
        store(m, s, "PeachPuff", PeachPuff);
        store(m, s, "Peru", Peru);
        store(m, s, "Pink", Pink);
        store(m, s, "Plum", Plum);
        store(m, s, "PowderBlue", PowderBlue);
        store(m, s, "Purple", Purple);
        store(m, s, "Red", Red);
        store(m, s, "RosyBrown", RosyBrown);
        store(m, s, "RoyalBlue", RoyalBlue);
        store(m, s, "SaddleBrown", SaddleBrown);
        store(m, s, "Salmon", Salmon);
        store(m, s, "SandyBrown", SandyBrown);
        store(m, s, "SeaGreen", SeaGreen);
        store(m, s, "SeaShell", SeaShell);
        store(m, s, "Sienna", Sienna);
        store(m, s, "Silver", Silver);
        store(m, s, "SkyBlue", SkyBlue);
        store(m, s, "SlateBlue", SlateBlue);
        store(m, s, "SlateGray", SlateGray);
        store(m, s, "Snow", Snow);
        store(m, s, "SpringGreen", SpringGreen);
        store(m, s, "SteelBlue", SteelBlue);
        store(m, s, "Tan", Tan);
        store(m, s, "Teal", Teal);
        store(m, s, "Thistle", Thistle);
        store(m, s, "Tomato", Tomato);
        store(m, s, "Turquoise", Turquoise);
        store(m, s, "Violet", Violet);
        store(m, s, "Wheat", Wheat);
        store(m, s, "White", White);
        store(m, s, "WhiteSmoke", WhiteSmoke);
        store(m, s, "Yellow", Yellow);
        store(m, s, "YellowGreen", YellowGreen);
        
        colorsByName = Collections.unmodifiableMap(m);
        colorNames = Collections.unmodifiableSet(s);
    }
    
    /**
     * Method to store the given color internally
     * 
     * @param m The map
     * @param s The set
     * @param n The name string
     * @param c The color
     */
    private static void store(
        Map<String, Color> m, Set<String> s, String n, Color c)
    {
        s.add(n);
        m.put(n.toLowerCase(), c);
    }
    
    /**
     * Returns an unmodifiable set containing all HTML color names
     *  
     * @return The set
     */
    public static Set<String> getNames()
    {
        return colorNames;
    }
    
    /**
     * Returns the HTML color for the given name. <br>
     * <br>
     * The given string may be any case, and will be converted to lowercase 
     * internally for the lookup.<br>
     * <br>
     * Color names that involve the word <code>"Gray"</code> may either
     * be looked up using the word <code>"Gray"</code> or the word 
     * <code>"Grey"</code>.
     * 
     * @param name The name
     * @return The color, or <code>null</code> if no color with this name
     * exists.
     */
    public static Color getColor(String name)
    {
        Color color = colorsByName.get(name.toLowerCase());
        if (color == null)
        {
            if (name.contains("Gray"))
            {
                String n = name.replace("Gray", "Grey");
                color = colorsByName.get(n.toLowerCase());
            }
        }
        return color;
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private HtmlColors()
    {
        // Private constructor to prevent instantiation
    }
}
