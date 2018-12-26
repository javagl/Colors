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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Default implementation of a {@link ColorSelection}
 */
class DefaultColorSelection implements ColorSelection
{
    /**
     * The currently selected color
     */
    private Color color;
    
    /**
     * The list of {@link ColorSelectionListener} instances
     */
    private final List<ColorSelectionListener> colorSelectionListeners;
    
    /**
     * Default constructor
     */
    DefaultColorSelection()
    {
        color = null;
        colorSelectionListeners = 
            new CopyOnWriteArrayList<ColorSelectionListener>();
    }
    @Override
    public Color getColor()
    {
        return color;
    }

    @Override
    public void setColor(Color newColor)
    {
        Color oldColor = color;
        this.color = newColor;
        if (oldColor == null)
        {
            if (newColor != null)
            {
                fireColorChanged(oldColor, newColor);
            }
        }
        else
        {
            if (!oldColor.equals(newColor))
            {
                fireColorChanged(oldColor, newColor);
            }
        }
    }

    /**
     * Inform all {@link ColorSelectionListener} instances about a change
     * in the selection
     * 
     * @param oldColor The old color
     * @param newColor The new color
     */
    protected final void fireColorChanged(Color oldColor, Color newColor)
    {
        if (!colorSelectionListeners.isEmpty())
        {
            ColorSelectionEvent colorSelectionEvent = 
                new ColorSelectionEvent(this, oldColor, newColor);
            for (ColorSelectionListener listener : colorSelectionListeners)
            {
                listener.colorChanged(colorSelectionEvent);
            }
        }
    }
    @Override
    public final void addColorSelectionListener(
        ColorSelectionListener colorSelectionListener)
    {
        colorSelectionListeners.add(colorSelectionListener);
    }

    @Override
    public final void removeColorSelectionListener(
        ColorSelectionListener colorSelectionListener)
    {
        colorSelectionListeners.remove(colorSelectionListener);
    }
    
}
