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

public class MobilKeluarga {
    
    private int idmobil;
    private JenisMobil jm = new JenisMobil();
    private String nopol;
    private String merkmobil;
    private String warnamobil;
    private String namamobil;
    
    public MobilKeluarga(){
        
    }
    
    public MobilKeluarga(JenisMobil jm, String nopol, String merk, String warna, String nama){
        this.jm = jm;
        this.nopol = nopol;
        this.merkmobil = merk;
        this.warnamobil = warna;
        this.namamobil = nama;
    }
    
    public void setIdMobil(int idMobil){
        this.idmobil = idMobil;
    }
    
    public int getIdMobil(){
        return idmobil;
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
    
    public void setMerkMobil(String merk){
        this.merkmobil = merk;
    }
    
    public String getMerkMobil(){
        return merkmobil;
    }
    
    public void setWarnaMobil(String warna){
        this.warnamobil = warna;
    }
    
    public String getWarnaMobil(){
        return warnamobil;
    }
    
    public void setNamaMobil(String merk){
        this.namamobil = merk;
    }
    
    public String getNamaMobil(){
        return namamobil;
    }
    
    
    public MobilKeluarga getById(int id) {
        MobilKeluarga mk = new MobilKeluarga();

        String query = "SELECT "
                + "m.idmobil AS idmobil, "
                + "m.nopolisimobil AS nopolisimobil, "
                + "m.merkmobil AS merkmobil, "
                + "m.warnamobil AS warnamobil, "
                + "m.namamobil AS namamobil, "
                + "j.idjenis AS idjenis, "
                + "j.jenis AS jenis, "
                + "j.hargasewa AS hargasewa "
                + "FROM mobilkeluarga AS m "
                + "LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis "
                + "WHERE m.idmobil = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                mk = new MobilKeluarga();
                mk.setIdMobil(rs.getInt("idmobil"));
                mk.getJenis().setJenis(rs.getString("jenis"));
                mk.setNopol(rs.getString("nopolisimobil"));
                mk.setMerkMobil(rs.getString("merkmobil"));
                mk.setWarnaMobil(rs.getString("warnamobil"));
                mk.setNamaMobil(rs.getString("namamobil"));
                mk.getJenis().setHargaSewa(rs.getDouble("hargasewa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mk;
    }

    public ArrayList<MobilKeluarga> getAll() {
        ArrayList<MobilKeluarga> ListMobilKeluarga = new ArrayList();
        
        String query = "SELECT "
                + "m.idmobil AS idmobil, "
                + "m.nopolisimobil AS nopolisimobil, "
                + "m.merkmobil AS merkmobil, "
                + "m.warnamobil AS warnamobil, "
                + "m.namamobil AS namamobil, "
                + "j.idjenis AS idjenis, "
                + "j.jenis AS jenis, "
                + "j.hargasewa AS hargasewa "
                + "FROM mobilkeluarga AS m "
                + "LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis ";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                MobilKeluarga mk = new MobilKeluarga();
                mk.setIdMobil(rs.getInt("idmobil"));
                mk.getJenis().setJenis(rs.getString("jenis"));
                mk.setNopol(rs.getString("nopolisimobil"));
                mk.setMerkMobil(rs.getString("merkmobil"));
                mk.setWarnaMobil(rs.getString("warnamobil"));
                mk.setNamaMobil(rs.getString("namamobil"));
                mk.getJenis().setHargaSewa(rs.getDouble("hargasewa"));

                ListMobilKeluarga.add(mk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMobilKeluarga;
    }

    public ArrayList<MobilKeluarga> search(String keyword) {
        ArrayList<MobilKeluarga> ListMobilKeluarga = new ArrayList();

        String query = "SELECT m.idmobil AS idmobil, m.nopolisimobil AS nopolisimobil, m.merkmobil AS merkmobil, m.warnamobil AS warnamobil, m.namamobil AS namamobil, j.idjenis AS idjenis, j.jenis AS jenis, j.hargasewa AS hargasewa "
                + "FROM mobilkeluarga AS m LEFT JOIN jenismobil AS j ON m.idjenis = j.idjenis "
                + "WHERE m.nopolisimobil LIKE '%" + keyword + "%'"
                + "OR m.namamobil LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                MobilKeluarga mk = new MobilKeluarga();
                mk.setIdMobil(rs.getInt("idmobil"));
                mk.getJenis().setJenis(rs.getString("jenis"));
                mk.setNopol(rs.getString("nopolisimobil"));
                mk.setMerkMobil(rs.getString("merkmobil"));
                mk.setWarnaMobil(rs.getString("warnamobil"));
                mk.setNamaMobil(rs.getString("namamobil"));
                mk.getJenis().setHargaSewa(rs.getDouble("hargasewa"));

                ListMobilKeluarga.add(mk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMobilKeluarga;
    }

    public void save() {
        if (getById(idmobil).getIdMobil() == 0) {
            String SQL = "INSERT INTO mobilkeluarga (idjenis, nopolisimobil, merkmobil, warnamobil, namamobil) VALUES("
                    + "'" + this.getJenis().getIdJenis()+ "',"
                    + "'" + this.nopol + "',"
                    + "'" + this.merkmobil + "',"
                    + "'" + this.warnamobil + "',"
                    + "'" + this.namamobil + "'"
                    + ")";

            this.idmobil = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE mobilkeluarga SET "
                    + "idjenis = '" + this.getJenis().getIdJenis() + "',"
                    + "nopolisimobil = '" + this.nopol + "',"
                    + "merkmobil = '" + this.merkmobil + "',"
                    + "warnamobil = '" + this.warnamobil + "',"
                    + "namamobil = '" + this.namamobil + "'"
                    + "WHERE idmobil = '" + this.idmobil + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM mobilKeluarga WHERE idmobil = '" + this.idmobil + "'";
        DBHelper.executeQuery(SQL);
    }
}
