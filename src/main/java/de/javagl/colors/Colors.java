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

import java.awt.Color;
import java.util.List;

/**
 * Utility methods related to colors
 */
public class Colors
{
    /**
     * Create a new color, clamping the given values to be in [0, 255]
     * 
     * @param r The red component
     * @param g The green component
     * @param b The blue component
     * @return The color
     */
    public static Color createClamped(int r, int g, int b)
    {
        return new Color(clamp(r), clamp(g), clamp(b));
    }
    
    /**
     * Create a new color, clamping the given values to be in [0, 255].
     *
     * @param r The red component
     * @param g The green component
     * @param b The blue component
     * @param a The alpha component
     * @return The color
     */
    public static Color createClamped(int r, int g, int b, int a)
    {
        return new Color(clamp(r), clamp(g), clamp(b), clamp(a));
    }
    
    /**
     * Clamp the given value to be in [0,255]
     * 
     * @param i The input 
     * @return The clamped value
     */
    private static int clamp(int i)
    {
        return Math.max(0, Math.min(255, i));
    }

    /**
     * Create a new color, clamping the given values to be in [0, 1]
     * 
     * @param r The red component
     * @param g The green component
     * @param b The blue component
     * @return The color
     */
    public static Color createClamped(double r, double g, double b)
    {
        return new Color(clamp(r), clamp(g), clamp(b));
    }
    
    /**
     * Create a new color, clamping the given values to be in [0, 1].
     *
     * @param r The red component
     * @param g The green component
     * @param b The blue component
     * @param a The alpha component
     * @return The color
     */
    public static Color createClamped(double r, double g, double b, double a)
    {
        return new Color(clamp(r), clamp(g), clamp(b), clamp(a));
    }
    
    /**
     * Clamp the given value to be in [0,1]
     * 
     * @param d The input 
     * @return The clamped value
     */
    private static float clamp(double d)
    {
        return (float)Math.max(0, Math.min(1.0, d));
    }

    /**
     * Returns the alpha component of the given ARGB color
     * 
     * @param argb The ARGB color
     * @return The alpha component
     */
    public static int getAlpha(int argb)
    {
        return (argb >> 24) & 0xFF;
    }

    /**
     * Returns the red component of the given ARGB color
     * 
     * @param argb The ARGB color
     * @return The red component
     */
    public static int getRed(int argb)
    {
        return (argb >> 16) & 0xFF;
    }
    
    /**
     * Returns the green component of the given ARGB color
     * 
     * @param argb The ARGB color
     * @return The green component
     */
    public static int getGreen(int argb)
    {
        return (argb >> 8) & 0xFF;
    }
    
    /**
     * Returns the blue component of the given ARGB color
     * 
     * @param argb The ARGB color
     * @return The blue component
     */
    public static int getBlue(int argb)
    {
        return argb & 0xFF;
    }
    
    /**
     * Returns the ARGB color that is composed from the given values
     * 
     * @param a The alpha value
     * @param r The red value
     * @param g The green value
     * @param b The blue value
     * @return The ARGB color
     */
    public static int getARGB(int a, int r, int g, int b)
    {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
    
    /**
     * Returns a the ARGB color that is the same as the given one, but
     * with the given alpha component.
     * 
     * @param a The alpha component
     * @param argb The ARGB color
     * @return The ARGB color
     */
    public static int withAlpha(int a, int argb)
    {
        int r = getRed(argb);
        int g = getGreen(argb);
        int b = getBlue(argb);
        return getARGB(a, r, g, b);
    }
    
    /**
     * Returns a the ARGB color that is the same as the given one, but
     * with the given red component.
     * 
     * @param r The red component
     * @param argb The ARGB color
     * @return The ARGB color
     */
    public static int withRed(int r, int argb)
    {
        int a = getAlpha(argb);
        int g = getGreen(argb);
        int b = getBlue(argb);
        return getARGB(a, r, g, b);
    }

    /**
     * Returns a the ARGB color that is the same as the given one, but
     * with the given green component.
     * 
     * @param g The green component
     * @param argb The ARGB color
     * @return The ARGB color
     */
    public static int withGreen(int g, int argb)
    {
        int a = getAlpha(argb);
        int r = getRed(argb);
        int b = getBlue(argb);
        return getARGB(a, r, g, b);
    }


    /**
     * Returns a the ARGB color that is the same as the given one, but
     * with the given blue component.
     * 
     * @param b The blue component
     * @param argb The ARGB color
     * @return The ARGB color
     */
    public static int withBlue(int b, int argb)
    {
        int a = getAlpha(argb);
        int r = getRed(argb);
        int g = getGreen(argb);
        return getARGB(a, r, g, b);
    }
    
    
    /**
     * Returns a the color that is the same as the given one, but
     * with the given alpha component.
     * 
     * @param a The alpha component
     * @param color The color
     * @return The color
     */
    public static Color withAlpha(int a, Color color)
    {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return new Color(r, g, b, a);
    }
    
    /**
     * Returns a the color that is the same as the given one, but
     * with the given red component.
     * 
     * @param r The red component
     * @param color The color
     * @return The color
     */
    public static Color withRed(int r, Color color)
    {
        int a = color.getAlpha();
        int g = color.getGreen();
        int b = color.getBlue();
        return new Color(r, g, b, a);
    }

    /**
     * Returns a the color that is the same as the given one, but
     * with the given green component.
     * 
     * @param g The green component
     * @param color The color
     * @return The color
     */
    public static Color withGreen(int g, Color color)
    {
        int a = color.getAlpha();
        int r = color.getRed();
        int b = color.getBlue();
        return new Color(r, g, b, a);
    }

    /**
     * Returns a the color that is the same as the given one, but
     * with the given blue component.
     * 
     * @param b The blue component
     * @param color The color
     * @return The color
     */
    public static Color withBlue(int b, Color color)
    {
        int a = color.getAlpha();
        int r = color.getRed();
        int g = color.getGreen();
        return new Color(r, g, b, a);
    }
    
    /**
     * Creates an array containing the ARGB values of the given colors
     * 
     * @param colors The colors
     * @return The ARGB values
     */
    public static int[] createArgbs(List<? extends Color> colors)
    {
        int argbs[] = new int[colors.size()];
        for (int i = 0; i < colors.size(); i++)
        {
            Color color = colors.get(i);
            argbs[i] = color.getRGB();
        }
        return argbs;
    }

    /**
     * Creates an array containing the colors for the given ARGB values
     * 
     * @param argbs The ARGB values
     * @return The colors
     */
    public static Color[] createColors(int... argbs)
    {
        Color colors[] = new Color[argbs.length];
        for (int i = 0; i < argbs.length; i++)
        {
            int argb = argbs[i];
            int a = getAlpha(argb);
            int r = getRed(argb);
            int g = getGreen(argb);
            int b = getBlue(argb);
            colors[i] = new Color(r, g, b, a);
        }
        return colors;
    }
    
    /**
     * Linearly interpolate between the given ARGB colors.<br>
     * <br>
     * Note: The interpolation value should be in [0,1]. Otherwise, the
     * result may contain unexpected colors due to overflow and underflow. 
     * 
     * @param argb0 The first color
     * @param argb1 The second color
     * @param v The interpolation value
     * @return The interpolated color
     */
    public static int interpolate(int argb0, int argb1, double v)
    {
        int a0 = getAlpha(argb0);
        int r0 = getRed(argb0);
        int g0 = getGreen(argb0);
        int b0 = getBlue(argb0);

        int a1 = getAlpha(argb1);
        int r1 = getRed(argb1);
        int g1 = getGreen(argb1);
        int b1 = getBlue(argb1);
        
        int da = a1 - a0;
        int dr = r1 - r0;
        int dg = g1 - g0;
        int db = b1 - b0;

        int a = (int)(a0 + v * da);
        int r = (int)(r0 + v * dr);
        int g = (int)(g0 + v * dg);
        int b = (int)(b0 + v * db);
        
        return getARGB(a, r, g, b);
    }
    
    /**
     * Linearly interpolate between the given ARGB colors, clamping each
     * component to be in [0,255]
     * <br>
     * 
     * @param argb0 The first color
     * @param argb1 The second color
     * @param v The interpolation value
     * @return The interpolated color
     */
    public static int interpolateClamping(int argb0, int argb1, double v)
    {
        int a0 = getAlpha(argb0);
        int r0 = getRed(argb0);
        int g0 = getGreen(argb0);
        int b0 = getBlue(argb0);

        int a1 = getAlpha(argb1);
        int r1 = getRed(argb1);
        int g1 = getGreen(argb1);
        int b1 = getBlue(argb1);
        
        int da = a1 - a0;
        int dr = r1 - r0;
        int dg = g1 - g0;
        int db = b1 - b0;

        int a = clamp((int)(a0 + v * da));
        int r = clamp((int)(r0 + v * dr));
        int g = clamp((int)(g0 + v * dg));
        int b = clamp((int)(b0 + v * db));
        
        return getARGB(a, r, g, b);
    }
    
    /**
     * Linearly interpolate between the given colors, clamping each
     * component to be in [0,255]
     * <br>
     * 
     * @param c0 The first color
     * @param c1 The second color
     * @param v The interpolation value
     * @return The interpolated color
     */
    public static Color interpolateClamping(Color c0, Color c1, double v)
    {
        int argb = interpolateClamping(c0.getRGB(), c1.getRGB(), v);
        int a = getAlpha(argb);
        int r = getRed(argb);
        int g = getGreen(argb);
        int b = getBlue(argb);
        return new Color(r, g, b, a);
    }
    
    
    
    /**
     * Compute a color (either black or white) that as a large contrast
     * to the given ARGB color. Some details of this method are intentionally
     * not specified.
     * 
     * @param argb The ARGB color
     * @return The contrasting color
     */
    public static Color computeContrastingColor(int argb)
    {
        if (computeLuminance(argb) > 0.179)
        {
            return Color.BLACK;
        }
        return Color.WHITE;
    }
    
    /**
     * Compute the contrast ratio between the given colors, as defined by
     * <pre>https://www.w3.org/TR/UNDERSTANDING-WCAG20/
     *   visual-audio-contrast-contrast.html</pre>
     *   
     * @param argb0 The first ARGB color
     * @param argb1 The second ARGB color
     * @return The contrast ratio
     */
    public static double computeContrastRatio(int argb0, int argb1)
    {
        double y0 = computeLuminance(argb0);
        double y1 = computeLuminance(argb1);
        return (y0 + 0.05) / (y1 + 0.05);
    }
    
    /**
     * Returns the luminance of the given ARGB color
     * 
     * @param argb The ARGB color
     * @return The luminance
     */
    public static double computeLuminance(int argb)
    {
        int r = getRed(argb);
        int g = getGreen(argb);
        int b = getBlue(argb);
        double nr = Math.pow((r / 255.0), 2.2);
        double ng = Math.pow((g / 255.0), 2.2);
        double nb = Math.pow((b / 255.0), 2.2);
        double y = 0.2126 * nr + 0.7151 * ng + 0.0721 * nb;
        return y;
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private Colors()
    {
        // Private constructor to prevent instantiation
    }
}
