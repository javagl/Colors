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
import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelectionListener;

/**
 * A panel painting a {@link ColorMap1D}.<br>
 * <br>
 * Note that this panel may have an associated {@link ColorSelection}.
 * If this color selection is not <code>null</code>, the panel will 
 * allow selecting a color with the mouse. It will also try to paint
 * an indicator of the selected color, but of course, this indicator
 * can only be sensibly painted if the selected color actually appears
 * in the color map that is shown in this panel. If the color map does
 * not contain the color, then the indicator will be painted at the
 * color that is "closest" to the selected color. Details about what
 * this means are intentionally unspecified.
 */
public class ColorMapPanel1D extends JPanel
{
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 378916351584447624L;
    
    /**
     * The {@link ColorMap1D} that is painted
     */
    private ColorMap1D colorMap;
    
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
     * @param colorMap The {@link ColorMap1D} to be painted
     */
    ColorMapPanel1D(ColorMap1D colorMap)
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
    public void setColorMap(ColorMap1D colorMap)
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
        double d = (double) x / (getWidth() - 1);
        Color color = colorMap.getColor(d);
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
        Color selectedColor = null;
        if (colorSelection != null)
        {
            selectedColor = colorSelection.getColor();
        }
        double minSquaredDistance = Double.POSITIVE_INFINITY;
        int minDistanceIndex = -1;
        for (int x = 0; x < getWidth(); x++)
        {
            Color color = colorAt(x);
            g.setColor(color);
            if (selectedColor != null)
            {
                double squaredDistance = 
                    squaredDistance(color, selectedColor);
                if (squaredDistance < minSquaredDistance)
                {
                    minSquaredDistance = squaredDistance;
                    minDistanceIndex = x;
                }
            }
            g.drawLine(x, 0, x, getHeight());
        }
        if (selectedColor != null)
        {
            Color selectionBorderColor = 
                Colors.computeContrastingColor(selectedColor.getRGB());
            g.setColor(selectionBorderColor);
            g.drawRect(minDistanceIndex - 1, 0, 2, getHeight() - 1);
        }
    }
    
    /**
     * Returns the squared distance between the given colors, in the ARGB
     * coordinate space
     * 
     * @param c0 The first color
     * @param c1 The second color
     * @return The squared distance
     */
    private static double squaredDistance(Color c0, Color c1)
    {
        int a0 = c0.getAlpha();
        int r0 = c0.getRed();
        int g0 = c0.getGreen();
        int b0 = c0.getBlue();
        
        int a1 = c1.getAlpha();
        int r1 = c1.getRed();
        int g1 = c1.getGreen();
        int b1 = c1.getBlue();
        
        int da = a1 - a0;
        int dr = r1 - r0;
        int dg = g1 - g0;
        int db = b1 - b0;
        
        return da * da + dr * dr + dg * dg + db * db;
    }
}