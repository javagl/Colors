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
import java.util.Objects;

/**
 * Default implementation of a {@link ColorMap1D} that is backed by
 * a simple color array
 */
class DefaultColorMap1D implements ColorMap1D
{
    /**
     * The backing array containing the colors
     */
    private final Color array[];

    /**
     * Creates a color map that is backed by the given array
     *
     * @param array The array containing colors
     */
    DefaultColorMap1D(Color array[])
    {
        this.array = Objects.requireNonNull(array, "The array may not be null");
    }

    @Override
    public Color getColor(double value)
    {
        double d = Math.max(0.0, Math.min(1.0, value));
        int i = (int)Math.round(d * (array.length - 1));
        return array[i];
    }
}
