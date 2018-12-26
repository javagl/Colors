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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import de.javagl.colors.Colors;

/**
 * Methods to create {@link ColorMap1D} instances
 */
public class ColorMaps
{
    /**
     * The default number of interpolation steps
     */
    private static final int DEFAULT_INTERPOLATION_STEPS = 1024;
    
    /**
     * Returns a {@link ColorMap1D} that provides a clamping access
     * to the given delegate. This means that arguments that are 
     * passed to the {@link ColorMap1D#getColor(double)} method are
     * clamped to be in [0,1].
     * 
     * @param delegate The delegate
     * @return The resulting {@link ColorMap1D}
     */
    public static ColorMap1D clamping(ColorMap1D delegate)
    {
        Objects.requireNonNull(delegate, "The delegate may not be null");
        return new ColorMap1D()
        {
            @Override
            public Color getColor(double value)
            {
                double v = Math.max(0.0, Math.min(1.0, value));
                return delegate.getColor(v);
            }
        };
    }
    
    /**
     * Returns a {@link ColorMap1D} that is "nested" between the given 
     * colors. This means that arguments that are passed to the 
     * {@link ColorMap1D#getColor(double)} method will be mapped
     * to the <code>smaller</code> color when they are negative, and
     * to the <code>larger</code> color when they are greater than 1.0.
     * 
     * @param delegate The delegate
     * @param smaller The color for values smaller than 0.0
     * @param larger The color for values larger than 1.0
     * @return The resulting {@link ColorMap1D}
     */
    public static ColorMap1D nested(
        ColorMap1D delegate, Color smaller, Color larger)
    {
        Objects.requireNonNull(delegate, "The delegate may not be null");
        return new ColorMap1D()
        {
            @Override
            public Color getColor(double value)
            {
                if (value < 0.0)
                {
                    return smaller;
                }
                if (value > 1.0)
                {
                    return larger;
                }
                return delegate.getColor(value);
            }
        };
    }
    
    
    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally 
     * interpolating between the colors with an unspecified number
     * of steps.
     *
     * @param colors The colors
     * @return The color map
     */
    public static ColorMap1D create(Color ... colors)
    {
        return create(DEFAULT_INTERPOLATION_STEPS, colors);
    }
    
    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally 
     * interpolating between the colors with an unspecified number
     * of steps.
     *
     * @param colors The colors
     * @return The color map
     */
    public static ColorMap1D create(List<? extends Color> colors)
    {
        return create(DEFAULT_INTERPOLATION_STEPS, colors);
    }
    
    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally 
     * interpolating between the colors with an unspecified number
     * of steps.
     *
     * @param argbs The ARGB colors
     * @return The color map
     */
    public static ColorMap1D create(int ... argbs)
    {
        return create(DEFAULT_INTERPOLATION_STEPS, argbs);
    }
    
    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally using 
     * the given number of steps for interpolating between the colors
     *
     * @param steps The number of interpolation steps
     * @param colors The colors
     * @return The color map
     */
    public static ColorMap1D create(int steps, Color ... colors)
    {
        return create(steps, Arrays.asList(colors));
    }
    
    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally using 
     * the given number of steps for interpolating between the colors
     *
     * @param steps The number of interpolation steps
     * @param colors The colors
     * @return The color map
     */
    public static ColorMap1D create(int steps, List<? extends Color> colors)
    {
        int[] argbs = Colors.createArgbs(colors);
        return create(steps, argbs);
    }

    /**
     * Creates a new {@link ColorMap1D} that maps a value between 0.0 
     * and 1.0 (inclusive) to the specified color range, internally using 
     * the given number of steps for interpolating between the colors
     *
     * @param steps The number of interpolation steps
     * @param argbs The ARGB colors
     * @return The color map
     */
    public static ColorMap1D create(int steps, int ... argbs)
    {
        Color colors[] = Colors.createColors(argbs);
        Color colorsArray[] = createColorsArray(steps, Arrays.asList(colors));
        return new DefaultColorMap1D(colorsArray);
    }

    /**
     * Creates the array which contains colors, interpolated through the 
     * given colors.
     *
     * @param steps The number of interpolation steps, and the size
     * of the resulting array
     * @param colors The colors for the array
     * @return The color array
     * @throws IllegalArgumentException If the number of steps is negative,
     * or the given list is <code>null</code> or empty.
     */
    static Color[] createColorsArray(int steps, List<? extends Color> colors)
    {
        if (steps < 0)
        {
            throw new IllegalArgumentException(
                "The steps may not be negative, but is " + steps);
        }
        if (colors == null)
        {
            throw new IllegalArgumentException(
                "Cannot create color map from null colors");
        }
        if (colors.isEmpty())
        {
            throw new IllegalArgumentException(
                "Cannot create color map from empty colors");
        }
        Color colorsArray[] = new Color[steps];
        if (colors.size() == 1)
        {
            Arrays.fill(colorsArray, colors.get(0));
            return colorsArray;
        }
        double colorDelta = 1.0 / (colors.size() - 1);
        for (int i=0; i<steps; i++)
        {
            double globalRel = (double) i / (steps - 1);
            int index0 = (int) (globalRel / colorDelta);
            int index1 = Math.min(colors.size() - 1, index0 + 1);
            double localRel = (globalRel - index0 * colorDelta) / colorDelta;
            
            Color color0 = colors.get(index0);
            Color color1 = colors.get(index1);
            colorsArray[i] = Colors.interpolateClamping(
                color0, color1, localRel);
        }
        return colorsArray;
    }
    
    
    /**
     * Private constructor to prevent instantiation
     */
    private ColorMaps()
    {
        // Private constructor to prevent instantiation
    }
}
