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
public class Pair implements Runnable {

    @Override
    public void run() {
        for(int i = 0 ; i <= 10 ; i = i + 2) {
            System.out.println(i);
            try {
                Thread.sleep(900 + (int) (Math.random() * 200));
            } catch (InterruptedException ex) {
                throw new Error("unexpected interrupt ",ex);
            }
        }
    }
    
}
