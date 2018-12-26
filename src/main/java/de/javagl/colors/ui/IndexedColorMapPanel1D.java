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
package de.javagl.colors.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.javagl.colors.Colors;
import de.javagl.colors.maps.ColorMap1D;
import de.javagl.colors.maps.indexed.IndexedColorMap1D;
import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelectionListener;

/**
 * A panel painting a {@link IndexedColorMap1D}
 */
public class IndexedColorMapPanel1D extends JPanel
{
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 378916351584447624L;
    
    /**
     * The {@link IndexedColorMap1D} that is painted
     */
    private IndexedColorMap1D colorMap;
    
    /**
     * The selection model for the colors
     */
    private ColorSelection colorSelection;
    
    /**
     * The {@link ColorSelectionListener} for the selection model
     */
    private final ColorSelectionListener colorSelectionListener;
    
    /**
     * Creates a new panel that paints the given color map
     *
     * @param colorMap The {@link IndexedColorMap1D} to be painted
     */
    IndexedColorMapPanel1D(IndexedColorMap1D colorMap)
    {
        setColorMap(colorMap);
        this.colorSelectionListener = e -> repaint();
        MouseAdapter mouseAdapter = createSelectionMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    
    /**
     * Create the mouse adapter that will handle the selection
     * 
     * @return The mouse adapter
     */
    private MouseAdapter createSelectionMouseAdapter()
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (colorSelection != null)
                {
                    if (e.getButton() == MouseEvent.BUTTON3)
                    {
                        colorSelection.setColor(null);
                    }
                    else
                    {
                        colorSelection.setColor(colorAt(e.getX()));
                    }
                }
            }
            
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0)
                {
                    if (colorSelection != null)
                    {
                        colorSelection.setColor(colorAt(e.getX()));
                    }
                }
            }
        };
    }
    
    /**
     * Set the {@link ColorMap1D} that is painted
     * 
     * @param colorMap The {@link ColorMap1D}
     */
    public void setColorMap(IndexedColorMap1D colorMap)
    {
        this.colorMap = colorMap;
        repaint();
    }
    
    /**
     * Set the {@link ColorSelection} that is associated with this panel
     * 
     * @param colorSelection The {@link ColorSelection}
     */
    public void setColorSelection(ColorSelection colorSelection)
    {
        if (this.colorSelection != null)
        {
            this.colorSelection.removeColorSelectionListener(
                colorSelectionListener);
        }
        this.colorSelection = colorSelection;
        if (this.colorSelection != null)
        {
            this.colorSelection.addColorSelectionListener(
                colorSelectionListener);
        }
        repaint();
    }
    
    /**
     * Returns the color that is displayed at the given x-coordinate, 
     * relative to the width of this panel, or <code>null</code> if 
     * this panel does not display a color map.
     * 
     * @param x The x-coordinate
     * @return The color
     */
    private Color colorAt(int x)
    {
        if (colorMap == null)
        {
            return null;
        }
        int n = colorMap.getSize();
        int cellWidth = getWidth() / n;
        int index = x / cellWidth;
        Color color = colorMap.getColor(index);
        return color;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (colorMap == null)
        {
            return;
        }
        int selectedIndex = -1;
        Color selectedColor = null;
        if (colorSelection != null)
        {
            selectedColor = colorSelection.getColor();
        }
        int n = colorMap.getSize();
        int cellWidth = getWidth() / n;
        for (int i = 0; i < n; i++)
        {
            Color color = colorMap.getColor(i);
            g.setColor(color);
            g.fillRect(i * cellWidth + 1, 0, cellWidth - 1, getHeight());
            if (color.equals(selectedColor))
            {
                selectedIndex = i;
            }
        }
        if (selectedIndex != -1)
        {
            Color selectionBorderColor = 
                Colors.computeContrastingColor(selectedColor.getRGB());
            g.setColor(selectionBorderColor);
            g.drawRect(selectedIndex * cellWidth + 1, 0, 
                cellWidth - 2, getHeight() - 1);
        }
    }
    
}
