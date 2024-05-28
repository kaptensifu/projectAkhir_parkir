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
public class tabelparkir extends AbstractTableModel{
    List<parkir> dp;
    
    public tabelparkir(List<parkir> dp) {
        this.dp = dp;
    }
    

    @Override
    public int getRowCount() {
        return dp.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID PARKIR";
            case 1:
                return "NO.PLAT";
            case 2:
                return "MERK KENDARAAN";
            case 3:
                return "JENIS KENDARAAN";
            case 4:
                return "JAM MASUK";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getIdParkir();
            case 1:
                return dp.get(row).getNoPlat();
            case 2:
                return dp.get(row).getMerkKendaraan();
            case 3:
                return dp.get(row).getJenisKendaraan();
            case 4:
                return dp.get(row).getJamMasuk();
            default:
                return null;
        }
    }
}
