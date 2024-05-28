/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.*;
import koneksi.*;
import model.user;
import DAOimplements.datauser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abaym
 */
public class datauserDAO implements datauser{
    Connection connection;
    
    final String login  = "SELECT * FROM user WHERE username=?, password=?";
    final String insert = "INSERT INTO `user`(`username`, `password`) VALUES (?,?)";
    final String update = "UPDATE user SET username=?,password=? WHERE id=?";
    final String delete = "DELETE FROM user WHERE id=?";
    final String select = "SELECT * FROM user";
    
    public datauserDAO(){
        connection = koneksi.connection();
    }
    
    @Override
    public void select(user u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(user u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(user u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(user u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<user> getAll() {
        List<user>dp = null;
        try{
            dp=new ArrayList<user>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                user b = new user();
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(datauserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
    
}
