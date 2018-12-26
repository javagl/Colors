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
package de.javagl.colors.brewer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of a color scheme, as used in the Color Brewer package
 */
class ColorScheme
{
    /**
     * The name of this color schema
     */
    private final String name;
    
    /**
     * The type of this color scheme
     */
    private final ColorSchemeType type;
    
    /**
     * The colors of this color scheme
     */
    private final List<Color> colors;
    
    /**
     * Default constructor
     * @param type The type
     * @param name The name
     * @param colors The colors
     */
    ColorScheme(ColorSchemeType type, String name, Collection<Color> colors)
    {
        this.type = type;
        this.name = name;
        this.colors = 
            Collections.unmodifiableList(new ArrayList<Color>(colors));
    }
    
    /**
     * Returns the name of this scheme
     * 
     * @return The name
     */
    String getName()
    {
        return name;
    }

    /**
     * Returns the type
     * 
     * @return The type
     */
    ColorSchemeType getType()
    {
        return type;
    }
    
    /**
     * Returns an unmodifiable list containing the colors of this scheme
     * 
     * @return The colors
     */
    List<Color> getColors()
    {
        return colors;
    }
    
    @Override
    public String toString()
    {
        return "ColorScheme["+
            "type="+type+","+
            "name="+name+","+
            "colors="+colors+"]";
    }
}
