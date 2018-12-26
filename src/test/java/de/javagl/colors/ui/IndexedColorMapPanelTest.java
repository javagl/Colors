/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import de.javagl.colors.brewer.ColorBrewer;
import de.javagl.colors.brewer.ColorSchemeType;
import de.javagl.colors.maps.indexed.IndexedColorMap1D;
import de.javagl.colors.maps.indexed.IndexedColorMaps;
import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelections;

/**
 * Simple integration test for the {@link ColorMapPanel1D} class
 */
@SuppressWarnings("javadoc")
public class IndexedColorMapPanelTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        IndexedColorMap1D colorMap = 
            IndexedColorMaps.create(ColorBrewer.get(
                ColorSchemeType.QUALITATIVE, "Set2", 6));
        IndexedColorMapPanel1D colorMapPanel = 
            new IndexedColorMapPanel1D(colorMap);
        
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(colorMapPanel, BorderLayout.CENTER);
        
        ColorSelection colorSelection = ColorSelections.create();
        colorMapPanel.setColorSelection(colorSelection);
        
        colorSelection.setColor(Color.GREEN);
        
        ColorSelectionView colorSelectionView = 
            new ColorSelectionView(colorSelection);

        f.getContentPane().add(colorSelectionView, BorderLayout.SOUTH);
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
