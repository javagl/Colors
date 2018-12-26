/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.brewer.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * A simple application for browsing through the ColorBrewer colors
 */
@SuppressWarnings("javadoc")
public class ColorBrewerApp
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
    
    private static void createAndShowGui()
    {
        JFrame f = new JFrame("ColorB..... App");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ColorBrewerAppPanel colorBrewerAppPanel = new ColorBrewerAppPanel();
        f.getContentPane().add(colorBrewerAppPanel);
        
        f.setSize(1200, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

