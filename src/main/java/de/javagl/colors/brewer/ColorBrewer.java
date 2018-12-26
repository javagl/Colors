package de.javagl.colors.brewer;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * A class providing color schemes based on the ColorBrewer colors.<br>
 * <br>
 * <br>
 * Original license:<br>
 * <pre>
 * Apache-Style Software License for ColorBrewer software and ColorBrewer Color
 * Schemes
 * 
 * Copyright (c) 2002 Cynthia Brewer, Mark Harrower, and The Pennsylvania State
 * University.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions as source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. The end-user
 * documentation included with the redistribution, if any, must include the
 * following acknowledgment: This product includes color specifications and
 * designs developed by Cynthia Brewer (http://colorbrewer.org/). Alternately,
 * this acknowledgment may appear in the software itself, if and wherever such
 * third-party acknowledgments normally appear. 4. The name "ColorBrewer" must
 * not be used to endorse or promote products derived from this software without
 * prior written permission. For written permission, please contact Cynthia
 * Brewer at cbrewer@psu.edu. 5. Products derived from this software may not be
 * called "ColorBrewer", nor may "ColorBrewer" appear in their name, without
 * prior written permission of Cynthia Brewer.
 * </pre>
 */
public class ColorBrewer
{
    /**
     * The logger used in this class
     */
    private static final Logger logger =
        Logger.getLogger(ColorBrewer.class.getName());
    
    /**
     * The {@link ColorScheme} instances
     */
    private static List<ColorScheme> colorSchemes;
    
    /**
     * Returns an unmodifiable list of {@link ColorScheme} instances as
     * defined by ColorBrewer. 
     * 
     * @return The {@link ColorScheme} instances
     */
    private static synchronized List<ColorScheme> getColorSchemes()
    {
        if (colorSchemes == null)
        {
            try
            {
                colorSchemes = createColorSchemes();
            }
            catch (IOException e)
            {
                logger.severe(e.getMessage());
            }   
        }
        return Collections.unmodifiableList(colorSchemes);
    }
    
    /**
     * Returns the maximum number of colors that any color scheme with
     * the given name and type has
     * 
     * @param type The type
     * @param name The name
     * @return The maximum number of colors
     * @throws IllegalArgumentException If no color scheme with the given
     * name and requested type could be found
     */
    public static int getMax(ColorSchemeType type, String name)
    {
        List<ColorScheme> colorSchemes = getColorSchemes();
        OptionalInt max = colorSchemes.stream()
            .filter(cs -> cs.getType() == type)
            .filter(cs -> cs.getName().equals(name))
            .mapToInt(cs -> cs.getColors().size())
            .max();
        if (max.isPresent())
        {
            return max.getAsInt();
        }
        throw new IllegalArgumentException(
            "No color schemes found with type " + type + " and name " + name);
    }
    
    /**
     * Returns an unmodifiable list containing the colors of a color scheme 
     * with the given name and the given number of colors
     * 
     * @param type The type
     * @param name The name
     * @param numColors The number of colors
     * @return The colors
     * @throws IllegalArgumentException If no color scheme with the given
     * name and requested type and number of colors could be found
     */
    public static List<Color> get(
        ColorSchemeType type, String name, int numColors)
    {
        List<ColorScheme> colorSchemes = getColorSchemes();
        Optional<ColorScheme> matchingColorScheme = colorSchemes.stream()
            .filter(cs -> cs.getType() == type)
            .filter(cs -> cs.getName().equals(name))
            .filter(cs -> cs.getColors().size() == numColors)
            .findFirst();
        if (matchingColorScheme.isPresent())
        {
            return matchingColorScheme.get().getColors();
        }
        throw new IllegalArgumentException(
            "No color scheme found with type " + type + " and name " + name 
            + " and " + numColors + " colors");
        
    }
    
    
    /**
     * Returns the names of all {@link ColorScheme} instances with the given
     * type
     * 
     * @param type The type
     * @return The names
     */
    public static List<String> getNames(ColorSchemeType type)
    {
        List<ColorScheme> colorSchemes = getColorSchemes();
        List<String> names = colorSchemes.stream()
            .filter(cs -> cs.getType() == type)
            .map(ColorScheme::getName)
            .collect(Collectors.toList());
        return new ArrayList<String>(new LinkedHashSet<String>(names));
    }
    

    
    
    /**
     * Create the list of {@link ColorScheme} instances
     * 
     * @return The {@link ColorScheme} instances
     * @throws IOException If something goes wrong
     */
    private static List<ColorScheme> createColorSchemes() throws IOException
    {
        List<ColorScheme> colorSchemes = new ArrayList<ColorScheme>();
        InputStream inputStream = ColorBrewer.class.getResourceAsStream(
            "/ColorBrewer_all_schemes_RGBonly3.csv");
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(inputStream));
        int lineCounter = 0;
        while (true)
        {
            String line = br.readLine();
            if (line == null)
            {
                break;
            }
            if (lineCounter == 0)
            {
                // Ignore header
                lineCounter++;
                continue;
            }
            String tokens[] = line.split(";");
            
            // The name, without "quotes"
            String name = tokens[0].substring(1, tokens[0].length() - 1);
            
            // The number of colors
            String numberOfColorsString = tokens[1];
            int numberOfColors = 
                tryParseInt(numberOfColorsString, "number of colors");

            // The type
            String typeAbbreviation = tokens[2];
            ColorSchemeType type = 
                ColorSchemeType.fromAbbreviation(typeAbbreviation);
            
            // The actual RGB values
            List<Color> colors = new ArrayList<Color>();
            for (int i = 0; i < numberOfColors; i++)
            {
                String rString = tokens[6];
                String gString = tokens[7];
                String bString = tokens[8];
                int r = Integer.parseInt(rString);
                int g = Integer.parseInt(gString);
                int b = Integer.parseInt(bString);
                colors.add(new Color(r, g, b));
                if (i < numberOfColors - 1)
                {
                    line = br.readLine();
                    if (line == null)
                    {
                        // Should never happen
                        throw new IOException(
                            "Expected " + numberOfColors 
                            + " lines, but only found " + i);
                    }
                    tokens = line.split(";");
                }
            }
            ColorScheme colorScheme = new ColorScheme(type, name, colors);
            //System.out.println("Read "+colorScheme);
            colorSchemes.add(colorScheme);
            
            lineCounter++;
        }
        return colorSchemes;
    }
    
    
    
    /**
     * Try to parse an integer from the given string, wrapping 
     * number format exceptions into IO exceptions
     * 
     * @param s The string
     * @param name The name for the value that was attempted to parse.
     * Only used in the exception message
     * @return The integer value
     * @throws IOException If the value cannot be parsed
     */
    private static int tryParseInt(String s, String name) throws IOException
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            if (name == null)
            {
                throw new IOException("Expected int value, found " + s);
            }
            throw new IOException("Expected " + name + ", found " + s);
        }
    }
    
}

