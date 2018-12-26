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

/**
 * Interface for a simple, indexed, 1D color map. 
 */
public interface IndexedColorMap1D
{
    /**
     * Returns the size (number of colors) of this color map
     * 
     * @return The size
     */
    int getSize();
    
    /**
     * Returns the color at the given index. <br>
     * <br>
     * This interface does not require a particular behavior for indices 
     * that are negative or not smaller than the size of this map, meaning 
     * that the behavior in these cases is implementation dependent.<br>
     * <br> 
     * The {@link IndexedColorMaps#clamping(IndexedColorMap1D)} and
     * {@link IndexedColorMaps#wrapping(IndexedColorMap1D)} methods may
     * be used to create instances that will never throw an
     * <code>IndexOutOfBoundsException</code>. 
     * 
     * @param index The index
     * @return The color
     * @throws IndexOutOfBoundsException May be thrown if the index is 
     * negative or not smaller than the size
     */
    Color getColor(int index);
}
