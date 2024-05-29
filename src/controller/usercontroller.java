/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAO.datauserDAO;
import DAOimplements.datauser;
import model.*;
import projectpbo.adminPetugas;
/**
 *
 * @author abaym
 */
public class usercontroller {
    adminPetugas frame;
    datauser impldatauser;
    List<user> dp;
    
    public usercontroller(adminPetugas frame){
        this.frame = frame;
        impldatauser = new datauserDAO();
        dp = impldatauser.getAll();
        
    }
    public void isitabel(){
        dp = impldatauser.getAll();
        tabeluser mp = new tabeluser(dp);
        frame.getTabeluser().setModel(mp);
    }
    
    public void insert(){
        user dp = new user();
        dp.setUsername(frame.getUsername().getText());
        dp.setPassword(new String(frame.getPassword().getPassword()));
        impldatauser.insert(dp);
        
    }
    
    public void update(){
        user dp = new user();
        dp.setUsername(frame.getUsername().getText());
        dp.setPassword(new String(frame.getPassword().getPassword()));
        dp.setId(Integer.parseInt(frame.getId().getText()));
        impldatauser.update(dp);
        
    }
    
    public void delete(){
        user dp = new user();
        dp.setId(Integer.parseInt(frame.getId().getText()));
        impldatauser.delete(dp);
    }
}
