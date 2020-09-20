/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorencapsulation;

/**
 *
 * @author user
 */
public class Motor {
    
    private int kecepatan;
    private boolean kontakOn = false;
    
    public void nyalakanMesin(){
        kontakOn = true;
    }
    
    public void matikanMesin(){
       kontakOn = false;
       kecepatan = 0;
    }
    
    public void tambahKecepatan(){
        if(kontakOn == true){
            kecepatan += 5;
        } 
        else {
            System.out.println("Mesin OFF!!!");
        }
    }
    
    public void kurangKecepatan(){
        if(kontakOn == true){
            kecepatan -= 5;
        }
        else {
            System.out.println("Mesin OFF!!!");
        }
    }
    
    public void printStatus(){
        if(kontakOn == true){
            System.out.println("ON");
        } 
        else {
            System.out.println("OFF");
        }
        System.out.println("Kecepatan : " + kecepatan + "\n");
    }
}
