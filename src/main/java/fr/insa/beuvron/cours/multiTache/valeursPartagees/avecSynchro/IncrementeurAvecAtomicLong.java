/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.valeursPartagees.avecSynchro;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author francois
 */
public class IncrementeurAvecAtomicLong implements Runnable {

    public static final long NBR_INC = 1000000;

    public AtomicInteger compteur = new AtomicInteger(0);

    @Override
    public void run() {
        for (long i = 0; i < IncrementeurAvecAtomicLong.NBR_INC; i++) {
            this.compteur.getAndIncrement();
        }
    }

    public static void test() {
        long curTime = System.currentTimeMillis();
        IncrementeurAvecAtomicLong i1 = new IncrementeurAvecAtomicLong();
        int nbrThread = 50;
        Thread[] bosseurs = new Thread[nbrThread];
        for (int i = 0; i < nbrThread; i++) {
            bosseurs[i] = new Thread(i1);
            bosseurs[i].start();
        }
        for (int i = 0; i < nbrThread; i++) {
            ThreadUtils.joinSansInterrupt(bosseurs[i]);
        }
        System.out.println("compteur final : " + i1.compteur
                + "(valeur attendue : " + (nbrThread * NBR_INC));
        System.out.println("temps : " + (System.currentTimeMillis() - curTime));
    }

    public static void main(String[] args) {
        test();
    }

}
