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
import java.util.EventObject;

/**
 * An event indicating a change in a {@link ColorSelection}
 */
public final class ColorSelectionEvent extends EventObject
{
    /**
     * Serial UID
     */
    private static final long serialVersionUID = -7540819148659816418L;
    
    /**
     * The {@link ColorSelection} from which this event originated
     */
    private final ColorSelection colorSelection;
    
    /**
     * The old color
     */
    private final Color oldColor;
    
    /**
     * The new color
     */
    private final Color newColor;

    /**
     * Creates a new instance
     * 
     * @param colorSelection The {@link ColorSelection}
     * @param oldColor The old color
     * @param newColor The new color
     */
    public ColorSelectionEvent(
        ColorSelection colorSelection, Color oldColor, Color newColor)
    {
        super(colorSelection);
        this.colorSelection = colorSelection;
        this.oldColor = oldColor;
        this.newColor = newColor;
    }

    /**
     * Returns the {@link ColorSelection} from which this event originated
     * 
     * @return The {@link ColorSelection}
     */
    public ColorSelection getColorSelection()
    {
        return colorSelection;
    }
    
    /**
     * Returns the old color. This may be <code>null</code> if no color
     * was previously selected
     * 
     * @return The old color
     */
    public Color getOldColor()
    {
        return oldColor;
    }

    /**
     * Returns the new color. This may be <code>null</code> if no color
     * is selected
     * 
     * @return The old color
     */
    public Color getNewColor()
    {
        return newColor;
    }
    
    @Override
    public String toString()
    {
        return "ColorSelectionEvent[" 
            + "colorSelection=" + colorSelection + ","
            + "oldColor=" + oldColor + "," 
            + "newColor=" + newColor + "]";
    }
    
}
