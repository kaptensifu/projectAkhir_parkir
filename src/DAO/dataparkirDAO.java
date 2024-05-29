/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.*;
import model.parkir;
import DAOimplements.dataparkir;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abaym
 */
public class dataparkirDAO implements dataparkir{

    Connection connection;
    
    final String insert = "INSERT INTO `parkir`(`no_plat`, `merk_kendaraan`, jenis_kendaraan) VALUES (?,?,?)";
    final String update = "UPDATE parkir SET lama_parkir=?, biaya_parkir=? WHERE id_parkir=?";
    final String delete = "DELETE FROM parkir WHERE id_parkir=?";
    final String select = "SELECT * FROM parkir";
    final String select2 = "SELECT * FROM parkir WHERE biaya_parkir IS NULL";
    
    public dataparkirDAO(){
        connection = koneksi.connection();
    }
    

    @Override
    public void insert(parkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement .RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNoPlat());
            statement.setString(2, p.getMerkKendaraan());
            statement.setString(3, p.getJenisKendaraan());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(parkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, Statement .RETURN_GENERATED_KEYS);
            statement.setDouble(1, p.getLamaParkir());
            statement.setInt(2, p.getBiaya());
            statement.setInt(3, p.getIdParkir());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();;
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(parkir p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, p.getIdParkir());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<parkir> getAll() {
        List<parkir>dp = null;
        try{
            dp=new ArrayList<parkir>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                parkir b = new parkir();
                b.setIdParkir(rs.getInt("id_parkir"));
                b.setNoPlat(rs.getString("no_plat"));
                b.setMerkKendaraan(rs.getString("merk_kendaraan"));
                b.setJenisKendaraan(rs.getString("jenis_kendaraan"));
                b.setJamMasuk(rs.getString("jam_masuk"));
                b.setLamaParkir(rs.getInt("lama_parkir"));
                b.setBiaya(rs.getInt("biaya_parkir"));
                
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(datauserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }

    @Override
    public List<parkir> getAll2() {
       List<parkir>dp = null;
        try{
            dp=new ArrayList<parkir>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select2);
            while(rs.next()){
                parkir b = new parkir();
                b.setIdParkir(rs.getInt("id_parkir"));
                b.setNoPlat(rs.getString("no_plat"));
                b.setMerkKendaraan(rs.getString("merk_kendaraan"));
                b.setJenisKendaraan(rs.getString("jenis_kendaraan"));
                b.setJamMasuk(rs.getString("jam_masuk"));
                b.setLamaParkir(rs.getInt("lama_parkir"));
                b.setBiaya(rs.getInt("biaya_parkir"));
                
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(datauserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
    
    
}
