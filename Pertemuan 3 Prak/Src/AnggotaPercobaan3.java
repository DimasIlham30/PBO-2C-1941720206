/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KoperasiGetterSetter;

/**
 *
 * @author user
 */
public class Anggota {
    
    public String nama;
    private String alamat;
    private float simpanan;
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public float getSimpanan(){
        return simpanan;
    }
    
    public void setor (float uang){
        simpanan += uang;
    }
    
    public void pinjam (float uang){
        simpanan -= uang;
    }
}
