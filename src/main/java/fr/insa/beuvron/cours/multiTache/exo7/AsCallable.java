/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.exo7;

import java.util.concurrent.Callable;

/**
 *
 * @author francois
 */
public class AsCallable implements Callable<Long> {


    private long nc;
    
    public AsCallable(long nc) {
        this.nc = nc;
    }   


    @Override
    public Long call() throws Exception {
        for(long i = 0 ; i < this.nc ; i ++) {
            Math.random();
        }
        return this.nc;
    }
    
}
