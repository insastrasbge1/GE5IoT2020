/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.basic;

/**
 *
 * @author francois
 */
public class PairImpair {
    
    public static void gogogo() {
        Thread pairT = new Thread(new Pair());
        Thread impairT = new Thread(new Impair());
        pairT.start();
        impairT.start();
    }
    
    public static void main(String[] args) {
        gogogo();
    }
}
