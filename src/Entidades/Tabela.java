
package Entidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
Cristovão Daniel Cuzonda
 */
public class Tabela extends JTable
{

    public Tabela() {
        getTableHeader().setDefaultRenderer(new TabelaHeader());
        getTableHeader().setPreferredSize(new Dimension(0,30));
        setDefaultRenderer(Object.class, new TabelaCell());
    }
    
    private class TabelaHeader extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            com.setBackground(new Color (30,30,30));
            com.setForeground(new Color(255,255,255));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            setRowHeight(30);
            
            return com;
        }
        
    }
    private class TabelaCell extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            if(isCellSelected(row, column)){
               if(row%2==0){
                    comp.setBackground(new Color(33,103,53));
                }else{
                    
                    comp.setBackground(new Color(129,86,127));
                }  
                
            }
            else{
                if(row%2==0){
                    comp.setBackground(new Color(100,100,100));
                }else{
                    
                    comp.setBackground(new Color(255,255,255));
                }}
                setBorder(new EmptyBorder(0,5,0,5));
                comp.setForeground(new Color(30,30,30));
                

    
            return comp;
    }}
    
}
