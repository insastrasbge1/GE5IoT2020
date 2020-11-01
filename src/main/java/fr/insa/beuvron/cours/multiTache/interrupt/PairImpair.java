/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.interrupt;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;


/**
 *
 * @author francois
 */
public class PairImpair {
    
    public static void gogogo() {
        Pair pairT = new Pair();
        Impair impairT = new Impair(pairT) ;
        pairT.setImpair(impairT);
        pairT.start();
        impairT.start();
        ThreadUtils.joinSansInterrupt(pairT);
        ThreadUtils.joinSansInterrupt(impairT);
        System.out.println("tout est fini");
    }
    
    public static void main(String[] args) {
        gogogo();
    }
}
