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
package de.javagl.colors.selection;

import java.awt.Color;

/**
 * Interface for classes that represent a color selection
 */
public interface ColorSelection
{
    /**
     * Returns the selected color. This may be <code>null</code> if no 
     * color is selected.
     * 
     * @return The selected color
     */
    Color getColor();
    
    /**
     * Set the selected color. This may be <code>null</code> if no color
     * should be selected
     * 
     * @param color The color
     */
    void setColor(Color color);
    
    /**
     * Add the given {@link ColorSelectionListener} to be informed about
     * changes in this selection
     * 
     * @param colorSelectionListener The {@link ColorSelectionListener}
     */
    void addColorSelectionListener(
        ColorSelectionListener colorSelectionListener);
    
    /**
     * Remove the given {@link ColorSelectionListener}
     * 
     * @param colorSelectionListener The {@link ColorSelectionListener}
     */
    void removeColorSelectionListener(
        ColorSelectionListener colorSelectionListener);
    
}
