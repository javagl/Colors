/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

/**
 * Some basic tests for the {@link Colors} class
 */
@SuppressWarnings("javadoc")
public class ColorsTest
{
    @Test
    public void testCreateColors()
    {
        int argbs[] =
        { 0x01020304, 0x05060708 };
        Color[] colors = Colors.createColors(argbs);

        assertEquals(0x01, colors[0].getAlpha());
        assertEquals(0x02, colors[0].getRed());
        assertEquals(0x03, colors[0].getGreen());
        assertEquals(0x04, colors[0].getBlue());

        assertEquals(0x05, colors[1].getAlpha());
        assertEquals(0x06, colors[1].getRed());
        assertEquals(0x07, colors[1].getGreen());
        assertEquals(0x08, colors[1].getBlue());
    }

    @Test
    public void testInterpolateClamping()
    {
        Color c0 = new Color(0, 0, 0, 0);
        Color c1 = new Color(32, 64, 128, 254);

        Color actual0 = Colors.interpolateClamping(c0, c1, 0.0);
        Color expected0 = new Color(0, 0, 0, 0);
        assertEquals(expected0, actual0);

        Color actual1 = Colors.interpolateClamping(c0, c1, 1.0);
        Color expected1 = new Color(32, 64, 128, 254);
        assertEquals(expected1, actual1);

        Color actual2 = Colors.interpolateClamping(c0, c1, 0.5);
        Color expected2 = new Color(16, 32, 64, 127);
        assertEquals(expected2, actual2);

        Color actual3 = Colors.interpolateClamping(c0, c1, -1.0);
        Color expected3 = new Color(0, 0, 0, 0);
        assertEquals(expected3, actual3);

        Color actual4 = Colors.interpolateClamping(c0, c1, 2.0);
        Color expected4 = new Color(64, 128, 255, 255);
        assertEquals(expected4, actual4);

    }

}
