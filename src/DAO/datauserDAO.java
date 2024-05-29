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
    final String insert = "INSERT INTO `user`(`username`, `password`, role) VALUES (?,?,'petugas')";
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
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement .RETURN_GENERATED_KEYS);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            
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
    public void update(user u) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
                    
            statement.setInt(3, u.getId());
            statement.executeUpdate();
            
            
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
    public void delete(user u) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, u.getId());
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
    public List<user> getAll() {
        List<user>dp = null;
        try{
            dp=new ArrayList<user>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                user b = new user();
                b.setId(rs.getInt("id"));
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setRole(rs.getString("role"));
                dp.add(b);
            }
        }catch(SQLException ex){
            Logger.getLogger(datauserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
    
}
