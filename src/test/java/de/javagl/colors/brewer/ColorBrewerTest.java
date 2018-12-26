/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.brewer;

import java.awt.Color;
import java.util.List;

/**
 * Simple integration test for the {@link ColorBrewer} class
 */
@SuppressWarnings("javadoc")
public class ColorBrewerTest
{
    public static void main(String[] args)
    {
        show(ColorSchemeType.QUALITATIVE);
        show(ColorSchemeType.SEQUENTIAL);
        show(ColorSchemeType.DIVERGING);
    }
    
    private static void show(ColorSchemeType type)
    {
        System.out.println("Type: " + type);
        List<String> names = ColorBrewer.getNames(type);
        for (String name : names)
        {
            int min = 3;
            int max = ColorBrewer.getMax(type, name);
            for (int i = min; i < max; i++)
            {
                List<Color> colors = ColorBrewer.get(type, name, i);
                System.out.println(
                    "  " + name + ", with " + i + " colors: " + colors);
            }
        }
    }

}
