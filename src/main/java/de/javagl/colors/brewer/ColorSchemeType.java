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

/**
 * An enumeration of possible color scheme types for the {@link ColorBrewer}
 * class
 */
public enum ColorSchemeType
{
    /**
     * Qualitative color scheme type
     */
    QUALITATIVE,
    
    /**
     * Sequential color scheme type
     */
    SEQUENTIAL, 
    
    /**
     * Diverging color scheme type
     */
    DIVERGING;
    
    /**
     * Returns the type for the given abbreviation. The input may be
     * the (quoted!) strings <code>"qual"</code>, <code>"seq"</code>, 
     * or <code>"div"</code>, returning the corresponding type
     *  
     * @param abbreviation The abbreviation
     * @return The type
     * @throws IllegalArgumentException If the given string was invalid
     */
    static ColorSchemeType fromAbbreviation(String abbreviation)
    {
        if (abbreviation.equals("\"qual\""))
        {
            return ColorSchemeType.QUALITATIVE;
        }
        if (abbreviation.equals("\"seq\""))
        {
            return ColorSchemeType.SEQUENTIAL;
        }
        if (abbreviation.equals("\"div\""))
        {
            return ColorSchemeType.DIVERGING;
        }
        throw new IllegalArgumentException(
            "Invalid abbreviation string for type:" + abbreviation);
    }
}
