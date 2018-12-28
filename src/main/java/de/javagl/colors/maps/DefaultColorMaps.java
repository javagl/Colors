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
package de.javagl.colors.maps;

import java.awt.Color;

/**
 * Methods to create some fairly arbitrary default color maps
 */
public class DefaultColorMaps
{
    /**
     * Create the rainbow color map, consisting of blue, cyan, green, yellow,
     * and red. (No magenta here)
     * 
     * @return The {@link ColorMap1D}
     */
    public static ColorMap1D createRainbow()
    {
        return ColorMaps.create(
            Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED);
    }
    
    /**
     * Create a default diverging color map, from blue over gray to red.
     * (https://www.kennethmoreland.com/color-maps/ColorMapsExpanded.pdf)
     * 
     * @return The {@link ColorMap1D}
     */
    public static ColorMap1D createDiverging()
    {
        Color colors[] =
        { 
            new Color(59, 76, 192), 
            new Color(68, 90, 204),
            new Color(77, 104, 215), 
            new Color(87, 117, 225),
            new Color(98, 130, 234), 
            new Color(108, 142, 241),
            new Color(119, 154, 247), 
            new Color(130, 165, 251),
            new Color(141, 176, 254),
            new Color(152, 185, 255),
            new Color(163, 194, 255),
            new Color(174, 201, 253),
            new Color(184, 208, 249),
            new Color(194, 213, 244),
            new Color(204, 217, 238),
            new Color(213, 219, 230),
            new Color(221, 221, 221),
            new Color(229, 216, 209),
            new Color(236, 211, 197),
            new Color(241, 204, 185),
            new Color(245, 196, 173),
            new Color(247, 187, 160),
            new Color(247, 177, 148),
            new Color(247, 166, 135),
            new Color(244, 154, 123),
            new Color(241, 141, 111),
            new Color(236, 127, 99),
            new Color(229, 112, 88),
            new Color(222, 96, 77),
            new Color(213, 80, 66),
            new Color(203, 62, 56),
            new Color(192, 40, 47),
            new Color(180, 4, 38) 
        };
        return ColorMaps.create(colors);
    }

    /**
     * Create a default diverging color map, from blue over gray to red.
     * This color map contains the part of the one that is created with
     * {@link #createDiverging()} that has a high contrast to 
     * <code>Color.BLACK</code>.
     * 
     * @return The {@link ColorMap1D}
     */
    public static ColorMap1D createDivergingBright()
    {
        Color colors[] = 
        {
            new Color(87, 117, 225),
            new Color(98, 130, 234), 
            new Color(108, 142, 241),
            new Color(119, 154, 247), 
            new Color(130, 165, 251),
            new Color(141, 176, 254),
            new Color(152, 185, 255),
            new Color(163, 194, 255),
            new Color(174, 201, 253),
            new Color(184, 208, 249),
            new Color(194, 213, 244),
            new Color(204, 217, 238),
            new Color(213, 219, 230),
            new Color(221, 221, 221),
            new Color(229, 216, 209),
            new Color(236, 211, 197),
            new Color(241, 204, 185),
            new Color(245, 196, 173),
            new Color(247, 187, 160),
            new Color(247, 177, 148),
            new Color(247, 166, 135),
            new Color(244, 154, 123),
            new Color(241, 141, 111),
            new Color(236, 127, 99),
            new Color(229, 112, 88),
            new Color(222, 96, 77),
            new Color(213, 80, 66)
        };
        return ColorMaps.create(colors);
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private DefaultColorMaps()
    {
        // Private constructor to prevent instantiation
    }
}
