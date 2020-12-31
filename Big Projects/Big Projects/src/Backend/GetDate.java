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

import java.util.*;
import java.sql.*;

public class GetDate {

    public static void main(String[] args) {

        int tahun = 2020, bulan = 11, hari = 23, jam = 00, menit = 07, detik = 33;
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.set(tahun, bulan, hari, jam, menit, detik);
        System.out.println("Tanggal : " + gCal.getTime());
        
        java.sql.Timestamp stmp = new java.sql.Timestamp(tahun, bulan, hari, jam, menit, detik, 0);
        stmp.toString();
        System.out.println(stmp.getTime());
    }
}
