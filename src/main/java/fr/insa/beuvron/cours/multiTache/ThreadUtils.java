/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache;

/**
 *
 * @author francois
 */
public class ThreadUtils {

    public static void joinSansInterrupt(Thread t) {
        try {
            t.join();
        } catch (InterruptedException ex) {
            throw new Error("interruption non attendue", ex);
        }
    }

    public static void sleepAlea(long maxTimeMs) {
        long timeMs = (long) ((Math.random()) * maxTimeMs);
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException ex) {
            throw new Error("unexpected interrupt ", ex);
        }
    }

    public static void sleepSansInterrupt(long timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException ex) {
            throw new Error("unexpected interrupt ", ex);
        }
    }

}
