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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.function.Function;

import javax.swing.JComponent;

import de.javagl.colors.ColorStrings;
import de.javagl.colors.Colors;
import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelectionListener;

/**
 * A view component for a {@link ColorSelection}
 */
public class ColorSelectionView extends JComponent
{
    /**
     * Serial UID
     */
    private static final long serialVersionUID = -6486397984776015147L;

    /**
     * Create an function that creates an unspecified string representation
     * of a color
     * 
     * @return The color string formatter
     */
    public static Function<Color, String> createDefaultColorStringFormatter()
    {
        return color -> 
        {
            if (color == null)
            {
                return "null";
            }
            String string = ColorStrings.createArgbString(
                color.getRGB(), "%3d", " ");
            return "ARGB: " + string;
        };
    }
    
    /**
     * The {@link ColorSelection} of this view
     */
    private ColorSelection colorSelection;

    /**
     * The {@link ColorSelectionListener} listening for changes
     */
    private final ColorSelectionListener colorSelectionListener =
        event -> repaint();
    
    /**
     * Whether a checkerboard background should be painted
     */
    private boolean paintingCheckerBackground;    
        
    /**
     * The formatter that is used for the string representation of the color
     */
    private Function<? super Color, String> colorStringFormatter;
    
    /**
     * Creates a new instance
     * 
     * @param colorSelection The {@link ColorSelection} to display
     */
    public ColorSelectionView(ColorSelection colorSelection)
    {
        setColorSelection(colorSelection);
        setColorStringFormatter(createDefaultColorStringFormatter());
        setPaintingCheckerBackground(true);
        setFont(new Font("Monospaced", Font.PLAIN, 11));
    }
    
    /**
     * Set the {@link ColorSelection} shown in this view. This may be
     * <code>null</code> if no selection should be shown, and to detach
     * this view (as a listener) from any selection that was previously
     * set.
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
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        if (super.isPreferredSizeSet())
        {
            return super.getPreferredSize();
        }
        if (colorStringFormatter != null)
        {
            String s = colorStringFormatter.apply(Color.WHITE);
            FontMetrics fontMetrics = getFontMetrics(getFont());
            int h = fontMetrics.getHeight();
            int w = fontMetrics.getMaxAdvance() * s.length();
            return new Dimension(w + 10, h + 4);
        }
        return new Dimension(16, 16);
    }
    
    /**
     * Set whether a checkerboard background should be painted, to indicate
     * whether a color is not fully opaque
     * 
     * @param paintingCheckerBackground The flag
     */
    public void setPaintingCheckerBackground(boolean paintingCheckerBackground)
    {
        this.paintingCheckerBackground = paintingCheckerBackground;
        repaint();
    }
    
    /**
     * Set the formatter that should be used for the string representation
     * of the color. If this is <code>null</code>, no string will be 
     * painted
     * 
     * @param colorStringFormatter The color string formatter
     */
    public void setColorStringFormatter(
        Function<? super Color, String> colorStringFormatter)
    {
        this.colorStringFormatter = colorStringFormatter;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (paintingCheckerBackground)
        {
            paintBackground(g, getWidth(), getHeight());
        }
        Color color = colorSelection.getColor();
        if (color == null)
        {
            g.setColor(Color.BLACK);
            g.drawLine(0, 0, getWidth(), getHeight());
            g.drawLine(0, getHeight(), getWidth(), 0);
        }
        else
        {
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if (colorStringFormatter != null)
        {
            if (color == null)
            {
                g.setColor(Color.BLACK);
            }
            else
            {
                int a = color.getAlpha();
                if (a < 128)
                {
                    g.setColor(Color.BLACK);
                }
                else
                {
                    g.setColor(Colors.computeContrastingColor(color.getRGB()));
                }
            }
            String string = colorStringFormatter.apply(color);
            g.drawString(string, 5, 14);
        }
    }
    
    /**
     * Paint a (largely unspecified) checkerboard-like pattern into the
     * given graphics
     * 
     * @param g The graphics
     * @param w The width
     * @param h The height
     */
    private static void paintBackground(Graphics g, int w, int h)
    {
        Color veryLightGray = new Color(240, 240, 240);
        int cellSize = 8;
        int stepsX = (w - 1) / cellSize + 1;
        int stepsY = (h - 1) / cellSize + 1;
        for (int x = 0; x < stepsX; x++)
        {
            for (int y = 0; y < stepsY; y++)
            {
                if (((x + y) & 1) == 0)
                {
                    g.setColor(veryLightGray);
                }
                else
                {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }
}
