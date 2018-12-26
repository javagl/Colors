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
package de.javagl.colors;

/**
 * Methods to create string representations of colors
 */
public class ColorStrings
{
    
    /**
     * Create a simple string containing the decimal representations of
     * the alpha, red, green, and blue components of the given ARGB color, 
     * separated by slashes <code>/</code>
     * 
     * @param argb The ARGB color
     * @return The string
     */
    public static String createSimpleArgbString(int argb)
    {
        return createArgbString(argb, "%d", "/");
    }

    /**
     * Create a simple string containing the decimal representations of
     * the red, green, and blue components of the given ARGB color, 
     * aligned to 3 characters, separated by slashes <code>/</code>
     * 
     * @param argb The ARGB color
     * @return The string
     */
    public static String createAlignedRgbString(int argb)
    {
        return createRgbString(argb, "%3d", "/");
    }
    
    /**
     * Create a simple string containing the decimal representations of
     * the alpha, red, green, and blue components of the given ARGB color, 
     * aligned to 3 characters, separated by slashes <code>/</code>
     * 
     * @param argb The ARGB color
     * @return The string
     */
    public static String createAlignedArgbString(int argb)
    {
        return createArgbString(argb, "%3d", "/");
    }
    
    /**
     * Create a string containing the decimal representations of the 
     * red, green, and blue components of the given ARGB color, 
     * with the given format and separator
     * 
     * @param argb The ARGB color
     * @param format The format
     * @param separator The separator
     * @return The string
     */
    public static String createRgbString(
        int argb, String format, String separator)
    {
        int r = Colors.getRed(argb);
        int g = Colors.getGreen(argb);
        int b = Colors.getBlue(argb);
        String s = format + separator 
            + format + separator 
            + format;
        return String.format(s, r, g, b);
    }
    
    /**
     * Create a string containing the decimal representations of the 
     * alpha, red, green, and blue components of the given ARGB color, 
     * with the given format and separator
     * 
     * @param argb The ARGB color
     * @param format The format
     * @param separator The separator
     * @return The string
     */
    public static String createArgbString(
        int argb, String format, String separator)
    {
        int a = Colors.getAlpha(argb);
        int r = Colors.getRed(argb);
        int g = Colors.getGreen(argb);
        int b = Colors.getBlue(argb);
        String s = format + separator 
            + format + separator 
            + format + separator 
            + format;
        return String.format(s, a, r, g, b);
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private ColorStrings()
    {
        // Private constructor to prevent instantiation
    }
}
