/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAO.dataparkirDAO;
import DAOimplements.dataparkir;
import model.*;
import projectpbo.adminRiwayat;
import projectpbo.petugasRiwayat;
import projectpbo.petugasBuat;
/**
 *
 * @author abaym
 */
public class parkircontroller {
    adminRiwayat frame;
    dataparkir impldataparkir;
    List<parkir> dp;
    
    public parkircontroller(adminRiwayat frame){
        this.frame = frame;
        
        impldataparkir = new dataparkirDAO();
        dp = impldataparkir.getAll();
        
    }
    
    

    
    public void isitabel(){
        dp = impldataparkir.getAll();
        tabelparkir mp = new tabelparkir(dp);
        frame.getTabelparkir().setModel(mp);
    }
    
    public void insert(){
       
    }
    
    public void update(){
        
        
    }
    
    public void delete(){
        parkir dp = new parkir();
        dp.setIdParkir(Integer.parseInt(frame.getId_parkir().getText()));
        impldataparkir.delete(dp);
    }
}
