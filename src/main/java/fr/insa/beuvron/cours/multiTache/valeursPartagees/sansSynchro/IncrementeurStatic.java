/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.valeursPartagees.sansSynchro;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;

/**
 *
 * @author francois
 */
public class IncrementeurStatic extends Thread {
    
    public static final long NBR_INC = 10000000;
    public static int compteur = 0;
    
    @Override
    public void run() {
        for(long i = 0 ; i < IncrementeurStatic.NBR_INC ; i ++) {
            IncrementeurStatic.compteur ++;
        }
    }
    
    public static void test() {
        IncrementeurStatic i1 = new IncrementeurStatic();
        IncrementeurStatic i2 = new IncrementeurStatic();
        i1.start();
        i2.start();
        ThreadUtils.joinSansInterrupt(i1);
        ThreadUtils.joinSansInterrupt(i2);
        System.out.println("compteur final : " + IncrementeurStatic.compteur +
                "(valeur attendue : " + (2 * NBR_INC));
    }
    
    public static void main(String[] args) {
        test();
    }
    
}
