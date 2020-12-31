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

public class Penyewa {
    
    private int idPenyewa, noKtp;
    private String nama, alamat, noTelp;

    public Penyewa() {
    }

    public Penyewa(int noKtp, String nama, String alamat, String noTelp) {
        this.noKtp = noKtp;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public int getIdPenyewa() {
        return idPenyewa;
    }

    public int getNoKtp() {
        return noKtp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setIdPenyewa(int idPenyewa) {
        this.idPenyewa = idPenyewa;
    }

    public void setNoKtp(int noKtp) {
        this.noKtp = noKtp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    @Override
    public String toString(){
        return nama;
    }
    
    public Penyewa getById(int id) {
        Penyewa py = new Penyewa();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penyewa " + " WHERE idpenyewa = '" + id + "'");
        try {
            while (rs.next()) {
                py = new Penyewa();
                py.setIdPenyewa(rs.getInt("idpenyewa"));
                py.setNoKtp(rs.getInt("noktp"));
                py.setNama(rs.getString("nama"));
                py.setAlamat(rs.getString("alamat"));
                py.setNoTelp(rs.getString("notelp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return py;
    }

    public ArrayList<Penyewa> getAll() {
        ArrayList<Penyewa> ListPenyewa= new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penyewa");

        try {
            while (rs.next()) {
                Penyewa py = new Penyewa();
                py.setIdPenyewa(rs.getInt("idpenyewa"));
                py.setNoKtp(rs.getInt("noktp"));
                py.setNama(rs.getString("nama"));
                py.setAlamat(rs.getString("alamat"));
                py.setNoTelp(rs.getString("notelp"));

                ListPenyewa.add(py);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPenyewa;
    }

    public ArrayList<Penyewa> search(String keyword) {
        ArrayList<Penyewa> ListPenyewa = new ArrayList();

        String sql = "SELECT * FROM penyewa WHERE " + " nama LIKE'%" + keyword + "%' "
                + "     OR noktp LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Penyewa py = new Penyewa();
                py.setIdPenyewa(rs.getInt("idpenyewa"));
                py.setNoKtp(rs.getInt("noktp"));
                py.setNama(rs.getString("nama"));
                py.setAlamat(rs.getString("alamat"));
                py.setNoTelp(rs.getString("notelp"));

                ListPenyewa.add(py);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPenyewa;
    }

    public void save() {
        if (getById(idPenyewa).getIdPenyewa() == 0) {
            String SQL = "INSERT INTO penyewa (noktp, nama, alamat, notelp) VALUES ("
                    + "     '" + this.noKtp + "', "
                    + "     '" + this.nama + "', "
                    + "     '" + this.alamat + "',"
                    + "     '" + this.noTelp + "'"
                    + "     )";
            this.idPenyewa = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE penyewa SET "
                    + "     noktp = '" + this.noKtp + "', "
                    + "     nama = '" + this.nama + "', "
                    + "     alamat = '" + this.alamat + "', "
                    + "     notelp = '" + this.noTelp + "' "
                    + "     WHERE idpenyewa = '" + this.idPenyewa + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM penyewa  WHERE idpenyewa = '" + this.idPenyewa + "'";
        DBHelper.executeQuery(SQL);
    }
}
