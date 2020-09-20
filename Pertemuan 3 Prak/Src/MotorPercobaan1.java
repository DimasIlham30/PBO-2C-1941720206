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
    
    public int kecepatan;
    public boolean kontakOn = false;
    
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
