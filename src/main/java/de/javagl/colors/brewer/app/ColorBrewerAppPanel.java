/*
 * www.javagl.de - Colors
 *
 * Copyright (c) 2013-2018 Marco Hutter - http://www.javagl.de
 */
package de.javagl.colors.brewer.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import de.javagl.colors.ColorStrings;
import de.javagl.colors.Colors;
import de.javagl.colors.brewer.ColorBrewer;
import de.javagl.colors.brewer.ColorSchemeType;

/**
 * The main panel for the {@link ColorBrewerApp}
 */
class ColorBrewerAppPanel extends JPanel
{
    /**
     * Serial UID 
     */
    private static final long serialVersionUID = 4073692840886470096L;
    
    /**
     * The list of color scheme types
     */
    private JList<ColorSchemeType> typeList;
    
    /**
     * The list of color scheme names for the currently selected type
     */
    private JList<String> nameList;
    
    /**
     * The list model for the name list
     */
    private DefaultListModel<String> nameListModel;
    
    /**
     * The table showing the colors
     */
    private JTable colorsTable;
    
    /**
     * The model for the colors table
     */
    private DefaultTableModel colorsTableModel;
    
    /**
     * The button for selecting code generation based on colors
     */
    private JRadioButton colorsButton;
    
    /**
     * The button for selecting code generation based on ints
     */
    private JRadioButton intsButton;
    
    /**
     * The text area for the code
     */
    private JTextArea codeTextArea;
    
    /**
     * Default constructor
     */
    ColorBrewerAppPanel()
    {
        super(new BorderLayout());
        
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        JPanel controlPanel = createControlPanel();
        mainSplitPane.setLeftComponent(controlPanel);
        
        JSplitPane tableAndCode = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        tableAndCode.setTopComponent(createTablePanel());
        tableAndCode.setBottomComponent(createCodePanel());
        mainSplitPane.setRightComponent(tableAndCode);
        
        add(mainSplitPane, BorderLayout.CENTER);
    }

    /**
     * Create the control panel
     * 
     * @return The panel
     */
    private JPanel createControlPanel()
    {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        
        typeList = new JList<ColorSchemeType>(
            ColorSchemeType.values());
        typeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel typeListPanel = new JPanel(new GridLayout());
        typeListPanel.setBorder(BorderFactory.createTitledBorder("Type"));
        typeListPanel.add(typeList);
        controlPanel.add(typeListPanel, BorderLayout.NORTH);
        
        nameListModel = new DefaultListModel<String>();
        nameList = new JList<String>(nameListModel);
        nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel nameListPanel = new JPanel(new GridLayout());
        nameListPanel.setBorder(BorderFactory.createTitledBorder("Name"));
        nameListPanel.add(nameList);
        controlPanel.add(nameListPanel);
        
        typeList.addListSelectionListener(e -> 
        {
            ColorSchemeType type = typeList.getSelectedValue();
            updateNameList(type);
        });

        nameList.addListSelectionListener(e -> 
        {
            ColorSchemeType type = typeList.getSelectedValue();
            String name = nameList.getSelectedValue();
            updateColorsTable(type, name);
        });
        return controlPanel;
    }
    
    /**
     * Create the table panel
     * 
     * @return The panel
     */
    private JPanel createTablePanel()
    {
        JPanel tablePanel = new JPanel(new GridLayout(1,1));
                
        colorsTableModel = new DefaultTableModel(new Object[0], 0);
        colorsTable = new JTable(colorsTableModel)
        {
            /**
             * Serial UID
             */
            private static final long serialVersionUID = 6640287516407638807L;

            @Override
            public boolean isCellEditable(int row, int column) 
            {
                return false;
            }
        };
        
        colorsTable.setFont(new Font("Monospaced", Font.PLAIN, 12));
        colorsTable.setDefaultRenderer(Object.class, createCellRenderer());
        colorsTable.setColumnSelectionAllowed(true);
        colorsTable.setRowSelectionAllowed(false);

        ListSelectionModel selectionModel = 
            colorsTable.getColumnModel().getSelectionModel();
        selectionModel.addListSelectionListener(e -> updateCode());
        
        tablePanel.add(new JScrollPane(colorsTable));
        return tablePanel;
    }
    
    /**
     * Create the cell renderer for the color table
     * 
     * @return The cell renderer
     */
    private TableCellRenderer createCellRenderer()
    {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer()
        {
            /**
             * Serial UID
             */
            private static final long serialVersionUID = -284344383487595871L;
            
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column)
            {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                setOpaque(true);
                setHorizontalAlignment(SwingConstants.CENTER);
                Color color = (Color)value;
                if (color == null)
                {
                    color = colorsTable.getBackground();
                    setText("");
                }
                else
                {
                    setText(ColorStrings.createAlignedRgbString(
                        color.getRGB()));
                }
                Color contrastingColor = 
                    Colors.computeContrastingColor(color.getRGB());
                if (isSelected)
                {
                    setBorder(
                        BorderFactory.createMatteBorder(
                            0, 4, 0, 4, contrastingColor));
                }
                else
                {
                    setBorder(
                        BorderFactory.createLineBorder(color, 2));
                }
                setBackground(color);
                setForeground(contrastingColor);
                return this;
            }
        };
        return renderer;
    }
    
    /**
     * Create the panel for the generated code
     * 
     * @return The panel
     */
    private JPanel createCodePanel()
    {
        JPanel codePanel = new JPanel(new BorderLayout());
        
        JPanel codeTypePanel = new JPanel(new FlowLayout());
        
        ButtonGroup buttonGroup = new ButtonGroup();
        colorsButton = new JRadioButton("Colors", true);
        intsButton = new JRadioButton("ints", false);
        buttonGroup.add(colorsButton);
        buttonGroup.add(intsButton);

        ActionListener actionListener = e -> updateCode();
        colorsButton.addActionListener(actionListener);
        intsButton.addActionListener(actionListener);
        
        codeTypePanel.add(colorsButton);
        codeTypePanel.add(intsButton);
        
        codePanel.add(codeTypePanel, BorderLayout.NORTH);
        
        codeTextArea = new JTextArea();
        codeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        codePanel.add(new JScrollPane(codeTextArea), BorderLayout.CENTER);

        return codePanel;
    }
    
    /**
     * Update the code in the code text area based on the currently 
     * selected table column and code type button
     */
    private void updateCode()
    {
        codeTextArea.setText("");
        
        TableColumnModel columnModel = colorsTable.getColumnModel();
        ListSelectionModel selectionModel = columnModel.getSelectionModel();
        int selectedColumnIndex = selectionModel.getMinSelectionIndex();
        if (selectedColumnIndex < 0 || 
            selectedColumnIndex >= columnModel.getColumnCount())
        {
            return;
        }
        List<Color> colors = getColorsOfColumn(selectedColumnIndex);

        ColorSchemeType type = typeList.getSelectedValue();
        String name = nameList.getSelectedValue();

        StringBuilder sb = new StringBuilder();
        
        sb.append("IndexedColorMap1D colorMap =\n");
        sb.append("    IndexedColorMaps.create(ColorBrewer.get(\n");
        sb.append("        ColorSchemeType." 
            + type + ", \"" + name + "\", " + colors.size() + "));\n");
        sb.append("\n");
        sb.append("// Type: " + type + "\n");
        sb.append("// Name: " + name + "\n");
        sb.append("// Size: " + colors.size() + "\n");
        if (colorsButton.isSelected())
        {
            sb.append(createColorsCode(colors));
        }
        else
        {
            sb.append(createIntsCode(colors));
        }
        codeTextArea.setText(sb.toString());
    }
    
    /**
     * Create the code for creating an array containing the given colors,
     * as Color objects
     * 
     * @param colors The colors
     * @return The code
     */
    private String createColorsCode(List<Color> colors)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Color colors[] =");
        sb.append("\n");
        sb.append("{");
        sb.append("\n");
        for (int i = 0; i < colors.size(); i++)
        {
            Color color = colors.get(i);
            sb.append("    new Color(");
            sb.append(ColorStrings.createRgbString(
                color.getRGB(), "%3d", ","));
            sb.append(")");
            if (i < colors.size() - 1)
            {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }
    
    /**
     * Create the code for creating an array containing the given colors,
     * as int values
     * 
     * @param colors The colors
     * @return The code
     */
    private String createIntsCode(List<Color> colors)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("int colors[] =");
        sb.append("\n");
        sb.append("{");
        sb.append("\n");
        for (int i = 0; i < colors.size(); i++)
        {
            Color color = colors.get(i);
            sb.append("    0x" + Integer.toHexString(color.getRGB()));
            if (i < colors.size() - 1)
            {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }
    
    /**
     * Fetch all colors that are contained in the specified column of the
     * colors table
     * 
     * @param columnIndex The column index
     * @return The colors
     */
    private List<Color> getColorsOfColumn(int columnIndex)
    {
        List<Color> colors = new ArrayList<Color>();
        int rows = colorsTable.getRowCount();
        for (int i=0; i<rows; i++)
        {
            Object value = colorsTable.getValueAt(i, columnIndex);
            if (value != null)
            {
                Color color = (Color)value;
                colors.add(color);
            }
        }
        return colors;
    }

    /**
     * Update the list of color scheme names based on the given scheme type
     * 
     * @param type The scheme type
     */
    private void updateNameList(ColorSchemeType type)
    {
        TableColumnModel columnModel = colorsTable.getColumnModel();
        ListSelectionModel selectionModel = columnModel.getSelectionModel();
        int selectedColumnIndex = selectionModel.getMinSelectionIndex();
        
        int selectedIndex = nameList.getSelectedIndex();
        nameListModel.removeAllElements();
        List<String> names = ColorBrewer.getNames(type);
        for (String name : names)
        {
            nameListModel.addElement(name);
        }
        selectedIndex = 
            Math.max(0, Math.min(selectedIndex, nameListModel.size() - 1));
        nameList.setSelectedIndex(selectedIndex);
        
        selectedColumnIndex = Math.max(0, 
            Math.min(selectedColumnIndex, columnModel.getColumnCount() - 1));
        selectionModel.setSelectionInterval(
            selectedColumnIndex, selectedColumnIndex);
    }
    
    /**
     * Update table showing the colors for the given color scheme type and
     * name
     * 
     * @param type The type
     * @param name The name
     */
    private void updateColorsTable(ColorSchemeType type, String name)
    {
        TableColumnModel columnModel = colorsTable.getColumnModel();
        ListSelectionModel selectionModel = columnModel.getSelectionModel();
        int selectedColumnIndex = selectionModel.getMinSelectionIndex();
        
        while (colorsTableModel.getRowCount() > 0)
        {
            colorsTableModel.removeRow(0);
        }
        colorsTableModel.setColumnIdentifiers(new Vector<String>());
        if (type == null || name == null)
        {
            return;
        }
        int max = ColorBrewer.getMax(type, name);
        for (int i = 3; i < max; i++)
        {
            String columnName = String.valueOf(i);
            Vector<Object> columnData =
                new Vector<Object>(ColorBrewer.get(type, name, i));
            colorsTableModel.addColumn(columnName, columnData);
        }
        
        selectedColumnIndex = Math.max(0, 
            Math.min(selectedColumnIndex, columnModel.getColumnCount() - 1));
        selectionModel.setSelectionInterval(
            selectedColumnIndex, selectedColumnIndex);
    }
    
}
