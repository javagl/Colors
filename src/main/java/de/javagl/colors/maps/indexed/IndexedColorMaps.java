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
package de.javagl.colors.maps.indexed;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Methods to create {@link IndexedColorMap1D} instances
 */
public class IndexedColorMaps
{
    /**
     * Creates an {@link IndexedColorMap1D} of the given colors. A copy of
     * the given array will be stored internally.
     * 
     * @param colors The colors
     * @return The {@link IndexedColorMap1D}
     */
    public static IndexedColorMap1D create(Color ... colors)
    {
        return create(Arrays.asList(colors));
    }

    /**
     * Creates an {@link IndexedColorMap1D} of the given colors. A copy of
     * the given collection will be stored internally.
     * 
     * @param colors The colors
     * @return The {@link IndexedColorMap1D}
     */
    public static IndexedColorMap1D create(Collection<? extends Color> colors)
    {
        List<Color> resultColors = new ArrayList<Color>(colors);
        return new IndexedColorMap1D()
        {
            @Override
            public int getSize()
            {
                return resultColors.size();
            }
            
            @Override
            public Color getColor(int index)
            {
                return resultColors.get(index);
            }
        };
    }
    
    /**
     * Returns an {@link IndexedColorMap1D} that provides a wrapping access
     * to the given delegate. This means that negative indices or indices
     * that are not smaller than the size of the given delegate will be
     * wrapped to be in the valid range.
     * 
     * @param delegate The delegate
     * @return The resulting {@link IndexedColorMap1D}
     */
    public static IndexedColorMap1D wrapping(IndexedColorMap1D delegate)
    {
        Objects.requireNonNull(delegate, "The delegate may not be null");
        return new IndexedColorMap1D()
        {
            @Override
            public int getSize()
            {
                return delegate.getSize();
            }
            
            @Override
            public Color getColor(int index)
            {
                int i = index % getSize();
                if (index < 0)
                {
                    i += getSize();
                }
                return delegate.getColor(i);
            }
        };
    }
    
    /**
     * Returns an {@link IndexedColorMap1D} that provides a clamping access
     * to the given delegate. This means that negative indices or indices
     * that are not smaller than the size of the given delegate will be
     * clamped to be in the valid range.
     * 
     * @param delegate The delegate
     * @return The resulting {@link IndexedColorMap1D}
     */
    public static IndexedColorMap1D clamping(IndexedColorMap1D delegate)
    {
        Objects.requireNonNull(delegate, "The delegate may not be null");
        return new IndexedColorMap1D()
        {
            @Override
            public int getSize()
            {
                return delegate.getSize();
            }
            
            @Override
            public Color getColor(int index)
            {
                int i = Math.max(0, Math.min(getSize(), index));
                return delegate.getColor(i);
            }
        };
    }
    
    /**
     * Private constructor to prevent instantiation
     */
    private IndexedColorMaps()
    {
        // Private constructor to prevent instantiation
    }
    
}
