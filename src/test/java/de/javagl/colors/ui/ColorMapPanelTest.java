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

import de.javagl.colors.maps.ColorMap1D;
import de.javagl.colors.maps.ColorMaps;
import de.javagl.colors.maps.DefaultColorMaps;
import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelections;

/**
 * Simple integration test for the {@link ColorMapPanel1D} class
 */
@SuppressWarnings("javadoc")
public class ColorMapPanelTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ColorMap1D colorMap = null;
        
        colorMap = ColorMaps.create(Color.RED, Color.GREEN, Color.BLUE);
        //colorMap = DefaultColorMaps.createRainbow();
        colorMap = DefaultColorMaps.createDiverging();
        
        ColorMapPanel1D colorMapPanel = new ColorMapPanel1D(colorMap);
        
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(colorMapPanel, BorderLayout.CENTER);
        
        ColorSelection colorSelection = ColorSelections.create();
        colorMapPanel.setColorSelection(colorSelection);
        
        ColorSelectionView colorSelectionView = 
            new ColorSelectionView(colorSelection);

        f.getContentPane().add(colorSelectionView, BorderLayout.SOUTH);
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
