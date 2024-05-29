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
import projectpbo.petugasKeluar;
/**
 *
 * @author abaym
 */
public class parkirpetugascontroller {
    petugasRiwayat frame;
    petugasBuat frameBuat;
    petugasKeluar frameKeluar;
    dataparkir impldataparkir;
    public int biaya;
    List<parkir> dp;
    
    public parkirpetugascontroller(petugasRiwayat frame){
        this.frame = frame;
        impldataparkir = new dataparkirDAO();
        dp = impldataparkir.getAll();
    }
    
    public parkirpetugascontroller(petugasBuat frameBuat){
        this.frameBuat = frameBuat;
        impldataparkir = new dataparkirDAO();
        dp = impldataparkir.getAll();
    }
    
    public parkirpetugascontroller(petugasKeluar frameKeluar){
        this.frameKeluar = frameKeluar;
        impldataparkir = new dataparkirDAO();
        dp = impldataparkir.getAll();
    }
    
    public void isitabel(){
        dp = impldataparkir.getAll();
        tabelparkir mp = new tabelparkir(dp);
        frame.getTabelparkir().setModel(mp);
    }
    
    public void isitabel(petugasKeluar frameKeluar){
        dp = impldataparkir.getAll2();
        tabelparkir mp = new tabelparkir(dp);
        frameKeluar.getTabelparkir().setModel(mp);
    }
    
    public void insert(){
       parkir dp = new parkir();
       dp.setNoPlat(frameBuat.getPlat().getText());
       dp.setMerkKendaraan(frameBuat.getMerk().getText());
       dp.setJenisKendaraan(frameBuat.getJenis());
       impldataparkir.insert(dp);
    }
    
    public void update(){
       parkir dp = new parkir();
       dp.setLamaParkir(Integer.parseInt(frameKeluar.getLamaParkir().getText()));
        System.out.println(frameKeluar.getJenisKendaraan());
       if("mobil".equals(frameKeluar.getJenisKendaraan())){
           biaya=dp.menghitungMobil();
       }else{
           biaya=dp.menghitungMotor();
       }
       dp.setJenisKendaraan(frameKeluar.getJenisKendaraan());
       dp.setIdParkir(Integer.parseInt(frameKeluar.getIdParkir().getText()));
       dp.setBiaya(biaya);
       impldataparkir.update(dp);
    }
    
    public void delete(){
        parkir dp = new parkir();
        dp.setIdParkir(Integer.parseInt(frame.getId().getText()));
        impldataparkir.delete(dp);
    }
}
