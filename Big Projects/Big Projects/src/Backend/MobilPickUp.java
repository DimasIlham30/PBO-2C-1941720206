/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author USER
 */

import java.util.ArrayList;
import java.sql.*;

public class MobilPickUp {
    
    private int idpickup;
    private JenisMobil jm = new JenisMobil();
    private String nopol;
    private String merkpickup;
    private String warnapickup;
    private String namapickup;
    
    public MobilPickUp(){
        
    }
    
    public MobilPickUp(JenisMobil jm, String nopol, String merk, String warna, String nama){
        this.jm = jm;
        this.nopol = nopol;
        this.merkpickup = merk;
        this.warnapickup = warna;
        this.namapickup = nama;
    }
    
    public void setIdPickUp(int idPickUp){
        this.idpickup = idPickUp;
    }
    
    public int getIdPickUp(){
        return idpickup;
    }
    
    public void setJenis(JenisMobil jenis){
        this.jm = jenis;
    }
    
    public JenisMobil getJenis(){
        return jm;
    }
    
    public void setNopol(String nopol){
        this.nopol = nopol;
    }
    
    public String getNopol(){
        return nopol;
    }
    
    public void setMerkPickUp(String merk){
        this.merkpickup = merk;
    }
    
    public String getMerkPickUp(){
        return merkpickup;
    }
    
    public void setWarnaPickUp(String warna){
        this.warnapickup = warna;
    }
    
    public String getWarnaPickUp(){
        return warnapickup;
    }
    
    public void setNamaPickUp(String nama){
        this.namapickup = nama;
    }
    
    public String getNamaPickUp(){
        return namapickup;
    }
    
    
    public MobilPickUp getById(int id) {
        MobilPickUp mp = new MobilPickUp();

        String query = "SELECT "
                + "m.idpickup AS idpickup, "
                + "m.nopolisipickup AS nopolisipickup, "
                + "m.merkpickup AS merkpickup, "
                + "m.warnapickup AS warnapickup, "
                + "m.namapickup AS namapickup, "
                + "j.idjenis AS idjenis, "
                + "j.jenis AS jenis, "
                + "j.hargasewa AS hargasewa "
                + "FROM mobilpickup AS m "
                + "LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis "
                + "WHERE m.idpickup = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                mp = new MobilPickUp();
                mp.setIdPickUp(rs.getInt("idpickup"));
                mp.getJenis().setJenis(rs.getString("jenis"));
                mp.setNopol(rs.getString("nopolisipickup"));
                mp.setMerkPickUp(rs.getString("merkpickup"));
                mp.setWarnaPickUp(rs.getString("warnapickup"));
                mp.setNamaPickUp(rs.getString("namapickup"));
                mp.getJenis().setHargaSewa(rs.getDouble("hargasewa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mp;
    }

    public ArrayList<MobilPickUp> getAll() {
        ArrayList<MobilPickUp> ListMobilPickUp = new ArrayList();
        
        String query = "SELECT "
                + "m.idpickup AS idpickup, "
                + "m.nopolisipickup AS nopolisipickup, "
                + "m.merkpickup AS merkpickup, "
                + "m.warnapickup AS warnapickup, "
                + "m.namapickup AS namapickup, "
                + "j.idjenis AS idjenis, "
                + "j.jenis AS jenis, "
                + "j.hargasewa AS hargasewa "
                + "FROM mobilpickup AS m "
                + "LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis ";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                MobilPickUp mp = new MobilPickUp();
                mp.setIdPickUp(rs.getInt("idpickup"));
                mp.getJenis().setJenis(rs.getString("jenis"));
                mp.setNopol(rs.getString("nopolisipickup"));
                mp.setMerkPickUp(rs.getString("merkpickup"));
                mp.setWarnaPickUp(rs.getString("warnapickup"));
                mp.setNamaPickUp(rs.getString("namapickup"));
                mp.getJenis().setHargaSewa(rs.getDouble("hargasewa"));

                ListMobilPickUp.add(mp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMobilPickUp;
    }

    public ArrayList<MobilPickUp> search(String keyword) {
        ArrayList<MobilPickUp> ListMobilPickUp = new ArrayList();

        String query = "SELECT m.idpickup AS idpickup, m.nopolisipickup AS nopolisipickup, m.merkpickup AS merkpickup, m.warnapickup AS warnapickup, m.namapickup AS namapickup, j.idjenis AS idjenis, j.jenis AS jenis, j.hargasewa AS hargasewa "
                + "FROM mobilpickup AS m LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis "
                + "WHERE m.nopolisipickup LIKE '%" + keyword + "%'"
                + "OR m.namapickup LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                MobilPickUp mp = new MobilPickUp();
                mp.setIdPickUp(rs.getInt("idpickup"));
                mp.getJenis().setJenis(rs.getString("jenis"));
                mp.setNopol(rs.getString("nopolisipickup"));
                mp.setMerkPickUp(rs.getString("merkpickup"));
                mp.setWarnaPickUp(rs.getString("warnapickup"));
                mp.setNamaPickUp(rs.getString("namapickup"));
                mp.getJenis().setHargaSewa(rs.getDouble("hargasewa"));

                ListMobilPickUp.add(mp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMobilPickUp;
    }

    public void save() {
        if (getById(idpickup).getIdPickUp() == 0) {
            String SQL = "INSERT INTO mobilpickup (idjenis, nopolisipickup, merkpickup, warnapickup, namapickup) VALUES("
                    + "'" + this.getJenis().getIdJenis()+ "',"
                    + "'" + this.nopol + "',"
                    + "'" + this.merkpickup + "',"
                    + "'" + this.warnapickup + "',"
                    + "'" + this.namapickup + "'"
                    + ")";

            this.idpickup = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE mobilpickup SET "
                    + "idjenis = '" + this.getJenis().getIdJenis() + "',"
                    + "nopolisipickup = '" + this.nopol + "',"
                    + "merkpickup = '" + this.merkpickup + "',"
                    + "warnapickup = '" + this.warnapickup + "',"
                    + "namapickup = '" + this.namapickup + "'"
                    + "WHERE idpickup = '" + this.idpickup + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM mobilpickup WHERE idpickup = '" + this.idpickup + "'";
        DBHelper.executeQuery(SQL);
    }
}
