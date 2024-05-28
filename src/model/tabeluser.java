/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author abaym
 */
public class tabeluser extends AbstractTableModel{
    List<user> dp;
    
    public tabeluser(List<user> dp) {
        this.dp = dp;
    }
    

    @Override
    public int getRowCount() {
        return dp.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "USERNAME";
            case 1:
                return "PASSWORD";
            case 2:
                return "ROLE";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getUsername();
            case 1:
                return dp.get(row).getPassword();
            case 2:
                return dp.get(row).getRole();
            default:
                return null;
        }
    }
}
