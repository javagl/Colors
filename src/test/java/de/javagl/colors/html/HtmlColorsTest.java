/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.html;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import de.javagl.colors.Colors;

/**
 * Simple integration test for the {@link HtmlColors} class
 */
@SuppressWarnings("javadoc")
public class HtmlColorsTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Set<String> names = HtmlColors.getNames();
        JPanel p = new JPanel(new GridLayout(0,5));
        
        for (String name : names)
        {
            Color color = HtmlColors.getColor(name);
            JLabel label = new JLabel(name);
            label.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            label.setOpaque(true);
            label.setBackground(color);
            label.setForeground(Colors.computeContrastingColor(color.getRGB()));
            p.add(label);
        }
        
        JScrollPane scrollPane = new JScrollPane(p);
        f.getContentPane().add(scrollPane);
        f.setSize(1000, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
