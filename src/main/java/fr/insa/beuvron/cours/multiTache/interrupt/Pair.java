/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.interrupt;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class Pair extends Thread {

    private Impair impair;

    public Pair(Impair impair) {
        this.impair = impair;
    }

    public Pair() {
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i = i + 2) {
            ThreadUtils.sleepSansInterrupt(900 + (int) (Math.random() * 200));
            System.out.println(i);
            this.impair.interrupt();
            if (i + 2 <= 10) {
                System.out.println("pair s'endord");
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException ex) {
                    System.out.println("pair se réveille");;
                }
            }
        }
    }

    /**
     * @return the impair
     */
    public Impair getImpair() {
        return impair;
    }

    /**
     * @param impair the impair to set
     */
    public void setImpair(Impair impair) {
        this.impair = impair;
    }

}
