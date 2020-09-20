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
public class MotorDemo {
    
    public static void main(String[] args) {
        Motor mtr = new Motor();
        mtr.printStatus();
        mtr.kecepatan = 50;
        mtr.printStatus();
    }
}
