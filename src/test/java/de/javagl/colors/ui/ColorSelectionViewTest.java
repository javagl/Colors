/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.colorchooser.ColorSelectionModel;

import de.javagl.colors.selection.ColorSelection;
import de.javagl.colors.selection.ColorSelections;
import de.javagl.colors.ui.ColorSelectionView;

/**
 * Simple integration test for the {@link ColorSelectionView} class
 */
@SuppressWarnings("javadoc")
public class ColorSelectionViewTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JColorChooser colorChooser = new JColorChooser();
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(colorChooser, BorderLayout.CENTER);
        
        ColorSelection colorSelection = ColorSelections.create();
        
        ColorSelectionModel selectionModel = colorChooser.getSelectionModel();
        selectionModel.addChangeListener(e -> 
        {
            Color color = selectionModel.getSelectedColor();
            colorSelection.setColor(color);
        });
        
        ColorSelectionView colorSelectionView = 
            new ColorSelectionView(colorSelection);

        f.getContentPane().add(colorSelectionView, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
