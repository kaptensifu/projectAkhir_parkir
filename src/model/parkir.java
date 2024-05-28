/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author abaym
 */
public class parkir {
    private String idParkir;
    private String noPlat;
    private String merkKendaraan;
    private String jenisKendaraan;
    private String jamMasuk;
    private double lamaParkir;
    private int biaya;
    private final int hargaMotor=2000;
    private final int hargaMobil=5000;

    public String getIdParkir() {
        return idParkir;
    }

    public void setIdParkir(String idParkir) {
        this.idParkir = idParkir;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public double getLamaParkir() {
        return lamaParkir;
    }

    public void setLamaParkir(int lamaParkir) {
        this.lamaParkir = lamaParkir;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    
    public int menghitungMotor(){
        return (int) (hargaMotor*lamaParkir);
    }
    
    public int menghitungMobil(){
        return (int) (hargaMobil*lamaParkir);
    }
}
