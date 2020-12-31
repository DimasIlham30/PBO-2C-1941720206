/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author USER
 */
public class Peminjaman {

    private int idPeminjaman;
    private int idMobil;
    private Penyewa penyewa = new Penyewa();
    private JenisMobil jenis = new JenisMobil();
    private MobilKeluarga mob = new MobilKeluarga();
    private MobilPickUp pick = new MobilPickUp();
    private String tglPinjam, tglKembali;

    public Peminjaman() {
    }

    public Peminjaman(Penyewa penyewa, JenisMobil jenis, int idMobil, String tanggalPinjam, String tanggalKembali) {
        this.penyewa = penyewa;
        this.jenis = jenis;
        this.idMobil = idMobil;
        this.tglPinjam = tanggalPinjam;
        this.tglKembali = tanggalKembali;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public Penyewa getPenyewa() {
        return penyewa;
    }

    public JenisMobil getJenis() {
        return jenis;
    }

    public MobilKeluarga getMob() {
        return mob;
    }

    public MobilPickUp getPick() {
        return pick;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public void setPenyewa(Penyewa penyewa) {
        this.penyewa = penyewa;
    }

    public void setJenis(JenisMobil jenis) {
        this.jenis = jenis;
    }

    public void setMob(MobilKeluarga mob) {
        this.mob = mob;
    }

    public void setPick(MobilPickUp pick) {
        this.pick = pick;
    }

    

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman pen = new Peminjaman();

        String query = "SELECT * FROM peminjaman p "
                + "LEFT JOIN penyewa a ON p.idpenyewa = a.idpenyewa "
                + "LEFT JOIN jenismobil b ON b.idjenis = p.idjenis "
                + "LEFT JOIN mobilkeluarga c ON c.idmobil = p.idmobil "
                + "LEFT JOIN mobilpickup d ON d.idpickup = p.idmobil "
                + "WHERE p.idpeminjaman = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                pen = new Peminjaman();
                Penyewa py = new Penyewa();
                JenisMobil jm = new JenisMobil();
                MobilKeluarga mk = new MobilKeluarga();
                MobilPickUp mp = new MobilPickUp();
                pen.setPenyewa(py);
                pen.setJenis(jm);
                pen.setIdMobil(mk.getIdMobil());
                pen.setIdMobil(mp.getIdPickUp());

                pen.setIdPeminjaman(rs.getInt("idpeminjaman"));
                pen.getPenyewa().setIdPenyewa(rs.getInt("idpenyewa"));
                pen.getJenis().setIdJenis(rs.getInt("idjenis"));
                pen.getMob().setIdMobil(rs.getInt("idmobil"));
                pen.getPick().setIdPickUp(rs.getInt("idpickup"));
                pen.setTglPinjam(rs.getString("tanggalpinjam"));
                pen.setTglKembali(rs.getString("tanggalkembali"));
                pen.getPenyewa().setNoKtp(rs.getInt("noktp"));
                pen.getPenyewa().setNama(rs.getString("nama"));
                pen.getPenyewa().setAlamat(rs.getString("alamat"));
                pen.getPenyewa().setNoTelp(rs.getString("notelp"));
                pen.getJenis().setJenis(rs.getString("jenis"));
                pen.getJenis().setHargaSewa(rs.getDouble("hargasewa"));
                pen.getMob().setNopol(rs.getString("nopolisimobil"));
                pen.getMob().setMerkMobil(rs.getString("merkmobil"));
                pen.getMob().setWarnaMobil(rs.getString("warnamobil"));
                pen.getMob().setNamaMobil(rs.getString("namamobil"));
                pen.getPick().setNopol(rs.getString("nopolisipickup"));
                pen.getPick().setMerkPickUp(rs.getString("merkpickup"));
                pen.getPick().setWarnaPickUp(rs.getString("warnapickup"));
                pen.getPick().setNamaPickUp(rs.getString("namapickup"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pen;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> Peminjaman = new ArrayList();
        String query = "SELECT * FROM peminjaman p "
                + "LEFT JOIN penyewa a ON p.idpenyewa = a.idpenyewa "
                + "LEFT JOIN jenismobil b ON b.idjenis = p.idjenis "
                + "LEFT JOIN mobilkeluarga c ON c.idmobil = p.idmobil "
                + "LEFT JOIN mobilpickup d ON d.idpickup = p.idmobil ";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                Peminjaman pen = new Peminjaman();
                Penyewa py = new Penyewa();
                JenisMobil jm = new JenisMobil();
                MobilKeluarga mk = new MobilKeluarga();
                MobilPickUp mp = new MobilPickUp();
                pen.setPenyewa(py);
                pen.setJenis(jm);
                pen.setIdMobil(mk.getIdMobil());
                pen.setIdMobil(mp.getIdPickUp());

                pen.setIdPeminjaman(rs.getInt("idpeminjaman"));
                pen.getPenyewa().setIdPenyewa(rs.getInt("idpenyewa"));
                pen.getJenis().setIdJenis(rs.getInt("idjenis"));
                pen.getMob().setIdMobil(rs.getInt("idmobil"));
                pen.getPick().setIdPickUp(rs.getInt("idpickup"));
                pen.setTglPinjam(rs.getString("tanggalpinjam"));
                pen.setTglKembali(rs.getString("tanggalkembali"));
                pen.getPenyewa().setNoKtp(rs.getInt("noktp"));
                pen.getPenyewa().setNama(rs.getString("nama"));
                pen.getPenyewa().setAlamat(rs.getString("alamat"));
                pen.getPenyewa().setNoTelp(rs.getString("notelp"));
                pen.getJenis().setJenis(rs.getString("jenis"));
                pen.getJenis().setHargaSewa(rs.getDouble("hargasewa"));
                pen.getMob().setNopol(rs.getString("nopolisimobil"));
                pen.getMob().setMerkMobil(rs.getString("merkmobil"));
                pen.getMob().setWarnaMobil(rs.getString("warnamobil"));
                pen.getMob().setNamaMobil(rs.getString("namamobil"));
                pen.getPick().setNopol(rs.getString("nopolisipickup"));
                pen.getPick().setMerkPickUp(rs.getString("merkpickup"));
                pen.getPick().setWarnaPickUp(rs.getString("warnapickup"));
                pen.getPick().setNamaPickUp(rs.getString("namapickup"));
                Peminjaman.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Peminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> Peminjaman = new ArrayList();
        String query = "SELECT * FROM peminjaman p "
                + "LEFT JOIN penyewa a ON p.idpenyewa = a.idpenyewa "
                + "LEFT JOIN jenismobil b ON b.idjenis = p.idjenis "
                + "LEFT JOIN mobilkeluarga c ON c.idmobil = p.idmobil "
                + "LEFT JOIN mobilpickup d ON d.idpickup = p.idmobil "
                + "WHERE a.noktp LIKE '%" + keyword + "%'"
                + "OR a.nama LIKE '%" + keyword + "%'"
                + "OR b.jenis LIKE '%" + keyword + "%'"
                + "OR c.nopolisimobil LIKE '%" + keyword + "%'"
                + "OR c.namamobil LIKE '%" + keyword + "%'"
                + "OR d.nopolisipickup LIKE '%" + keyword + "%'"
                + "OR d.namapickup LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(query);

        try {
            while (rs.next()) {
                Peminjaman pen = new Peminjaman();
                pen.setIdPeminjaman(rs.getInt("idpeminjaman"));
                pen.getPenyewa().setIdPenyewa(rs.getInt("idpenyewa"));
                pen.getJenis().setIdJenis(rs.getInt("idjenis"));
                pen.getMob().setIdMobil(rs.getInt("idmobil"));
                pen.getPick().setIdPickUp(rs.getInt("idpickup"));
                pen.setTglPinjam(rs.getString("tanggalpinjam"));
                pen.setTglKembali(rs.getString("tanggalkembali"));
                pen.getPenyewa().setNoKtp(rs.getInt("noktp"));
                pen.getPenyewa().setNama(rs.getString("nama"));
                pen.getPenyewa().setAlamat(rs.getString("alamat"));
                pen.getPenyewa().setNoTelp(rs.getString("notelp"));
                pen.getJenis().setJenis(rs.getString("jenis"));
                pen.getJenis().setHargaSewa(rs.getDouble("hargasewa"));
                pen.getMob().setNopol(rs.getString("nopolisimobil"));
                pen.getMob().setMerkMobil(rs.getString("merkmobil"));
                pen.getMob().setWarnaMobil(rs.getString("warnamobil"));
                pen.getMob().setNamaMobil(rs.getString("namamobil"));
                pen.getPick().setNopol(rs.getString("nopolisipickup"));
                pen.getPick().setMerkPickUp(rs.getString("merkpickup"));
                pen.getPick().setWarnaPickUp(rs.getString("warnapickup"));
                pen.getPick().setNamaPickUp(rs.getString("namapickup"));

                Peminjaman.add(pen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Peminjaman;
    }

    public void save() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        
        if (getById(idPeminjaman).getIdPeminjaman() == 0) {
            try {
                java.util.Date tanggalPinjam = format.parse(this.tglPinjam);
                java.sql.Date sqlTanggalPinjam = new java.sql.Date(tanggalPinjam.getTime());
                java.util.Date tanggalKembali = format.parse(this.tglKembali);
                java.sql.Date sqlTanggalKembali = new java.sql.Date(tanggalKembali.getTime());
                String SQL = "INSERT INTO peminjaman (idpenyewa, idjenis, idmobil, tanggalpinjam, tanggalkembali) VALUES("
                        + "'" + this.getPenyewa().getIdPenyewa() + "',"
                        + "'" + this.getJenis().getIdJenis() + "',"
                        + "'" + this.getMob().getIdMobil() + "' OR '" + this.getPick().getIdPickUp() + "',"
                        + "'" + sqlTanggalPinjam + "',"
                        + "'" + sqlTanggalKembali + "'"
                        + ")";

                this.idPeminjaman = DBHelper.insertQueryGetId(SQL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String SQL = "UPDATE peminjaman SET"
                    + "idpenyewa = '" + this.getPenyewa().getIdPenyewa() + "',"
                    + "idjenis = '" + this.getJenis().getIdJenis() + "',"
                    + "idmobil = '" + this.getMob().getIdMobil() + "' OR '" + this.getPick().getIdPickUp() + "',"
                    + "tanggalpinjam = '" + this.tglPinjam + "',"
                    + "tanggalkembali ='" + this.tglKembali + "'"
                    + ")";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idPeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }

}
