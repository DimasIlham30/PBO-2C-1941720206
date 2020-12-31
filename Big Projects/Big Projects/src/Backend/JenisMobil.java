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

public class JenisMobil {
    
    private int idjenis;
    private String jenis;
    private double hargasewa;
    
    public JenisMobil(){
        
    }
    
    public JenisMobil(String jenis, double hargasewa){
        this.jenis = jenis;
        this.hargasewa = hargasewa;
    }
    
    public void setIdJenis(int idjenis){
        this.idjenis = idjenis;
    }
    
    public int getIdJenis(){
        return this.idjenis;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public String getJenis(){
        return this.jenis;
    }
    
    public void setHargaSewa(double harga){
        this.hargasewa = harga;
    }
    
    public double getHargaSewa(){
        return this.hargasewa;
    }
    
    @Override
    public String toString(){
        return this.jenis;
    }
    
    public JenisMobil getById(int id) {
        JenisMobil jenmob = new JenisMobil();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jenismobil " + " WHERE idjenis = '" + id + "'");
        try {
            while (rs.next()) {
                jenmob = new JenisMobil();
                jenmob.setIdJenis(rs.getInt("idjenis"));
                jenmob.setJenis(rs.getString("jenis"));
                jenmob.setHargaSewa(rs.getDouble("hargasewa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jenmob;
    }

    public ArrayList<JenisMobil> getAll() {
        ArrayList<JenisMobil> ListJenisMobil = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jenismobil");

        try {
            while (rs.next()) {
                JenisMobil jenmob = new JenisMobil();
                jenmob.setIdJenis(rs.getInt("idjenis"));
                jenmob.setJenis(rs.getString("jenis"));
                jenmob.setHargaSewa(rs.getDouble("hargasewa"));

                ListJenisMobil.add(jenmob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListJenisMobil;
    }

    public ArrayList<JenisMobil> search(String keyword) {
        ArrayList<JenisMobil> ListJenisMobil = new ArrayList();

        String sql = "SELECT * FROM jenismobil WHERE " + " jenis LIKE'%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                JenisMobil jenmob = new JenisMobil();
                jenmob.setIdJenis(rs.getInt("idjenis"));
                jenmob.setJenis(rs.getString("jenis"));
                jenmob.setHargaSewa(rs.getDouble("hargasewa"));

                ListJenisMobil.add(jenmob);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListJenisMobil;
    }

    public void save() {
        if (getById(idjenis).getIdJenis() == 0) {
            String SQL = "INSERT INTO jenismobil (jenis, hargasewa) VALUES ("
                    + "     '" + this.jenis + "', "
                    + "     '" + this.hargasewa + "'"
                    + "     )";
            this.idjenis = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE jenismobil SET "
                    + "     jenis = '" + this.jenis + "', "
                    + "     hargasewa = '" + this.hargasewa + "' "
                    + "     WHERE idjenis = '" + this.idjenis + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM jenismobil  WHERE idjenis = '" + this.idjenis + "'";
        DBHelper.executeQuery(SQL);
    }
}
