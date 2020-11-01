/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.exo7;

/**
 *
 * @author francois
 */
public class AsRunnable implements Runnable {
    
    private long nc;
    
    private long resultat;

    public AsRunnable(long nc) {
        this.nc = nc;
    }   

    @Override
    public void run() {
        for(long i = 0 ; i < this.getNc() ; i ++) {
            Math.random();
        }
        this.resultat = getNc();
    }

    /**
     * @return the nc
     */
    public long getNc() {
        return nc;
    }

    /**
     * @return the resultat
     */
    public long getResultat() {
        return resultat;
    }
}
