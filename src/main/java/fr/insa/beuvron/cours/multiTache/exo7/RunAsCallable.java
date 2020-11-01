/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.exo7;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class RunAsCallable {

    public static void test(int nbrThread, long nc) {
        int nbrCPU = Runtime.getRuntime().availableProcessors();
        ExecutorService ex = Executors.newFixedThreadPool(
                Math.max(1, nbrCPU - 2));
        long curTime = System.currentTimeMillis();
        ArrayList<Future<Long>> resultats = new ArrayList<>();
        for (int i = 0; i < nbrThread; i++) {
            resultats.add(ex.submit(new AsCallable(nc)));
        }
        long valFinale = 0;
        for (int i = 0; i < nbrThread; i++) {
            try {
                valFinale = resultats.get(i).get() + valFinale;
            } catch (InterruptedException | ExecutionException ex1) {
                throw new Error("unexpected problem : " + ex1);
            }
        }
        System.out.println("compteur final : " + valFinale
                + "(valeur attendue : " + (nbrThread * nc));
        System.out.println("temps : " + (System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
        test(50, 100000);
    }

}
