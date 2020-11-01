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
public class Impair extends Thread {

    private Pair connectedPair;

    public Impair(Pair connectedPair) {
        this.connectedPair = connectedPair;
    }

    public Impair() {
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 9; i = i + 2) {
            System.out.println("impair s'endord");
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException ex) {
                System.out.println("impair vient d'être réveillé");
            }
            ThreadUtils.sleepSansInterrupt(900 + (int) (Math.random() * 200));
            System.out.println(i);
            this.connectedPair.interrupt();
        }
    }

    /**
     * @return the connectedPair
     */
    public Pair getConnectedPair() {
        return connectedPair;
    }

    /**
     * @param connectedPair the connectedPair to set
     */
    public void setConnectedPair(Pair connectedPair) {
        this.connectedPair = connectedPair;
    }

}
