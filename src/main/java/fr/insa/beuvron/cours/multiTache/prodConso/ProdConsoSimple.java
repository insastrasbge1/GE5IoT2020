/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.prodConso;

import fr.insa.beuvron.cours.multiTache.ThreadUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class ProdConsoSimple {

    public static class Ressource {

        private int stockMax;
        private int stockActuel;

        public Ressource(int stockMax) {
            this.stockMax = stockMax;
            this.stockActuel = 0;
        }

        public synchronized void getRessource() {
            System.out.println(Thread.currentThread().getName() + " get ; stock actuel : " + this.stockActuel);
            while (this.getStockActuel() <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    throw new Error("unexpected interrupt ", ex);
                }
            }
            this.stockActuel--;
            this.notify();
        }

        public synchronized void provideRessource() {
            System.out.println(Thread.currentThread().getName() + " provide ; stock actuel : " + this.stockActuel);
            while (this.getStockActuel() >= this.getStockMax()) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    throw new Error("unexpected interrupt ", ex);
                }
            }
            this.stockActuel++;
            this.notify();
        }

        /**
         * @return the stockMax
         */
        public int getStockMax() {
            return stockMax;
        }

        /**
         * @return the stockActuel
         */
        public int getStockActuel() {
            return stockActuel;
        }
    }

    public static class Producteur extends Thread {

        private Ressource ress;
        private long maxTimeToProduce;

        public Producteur(String nom, Ressource ress, long maxTimeToProduce) {
            super(nom);
            this.ress = ress;
            this.maxTimeToProduce = maxTimeToProduce;
        }

        @Override
        public void run() {
            while (true) {
                ThreadUtils.sleepAlea(this.maxTimeToProduce);
                System.out.println(this.getName() + " +1 dispo");
                this.ress.provideRessource();
                System.out.println(this.getName() + " +1 déposée");
            }
        }
    }

    public static class Consommateur extends Thread {

        private Ressource ress;
        private long maxTimeToUse;

        public Consommateur(String nom, Ressource ress, long maxTimeToUse) {
            super(nom);
            this.ress = ress;
            this.maxTimeToUse = maxTimeToUse;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(this.getName() + " -1 necessaire");
                this.ress.getRessource();
                System.out.println(this.getName() + " bosse sur " + this.ress.getStockActuel());
                ThreadUtils.sleepAlea(this.maxTimeToUse);
            }
        }
    }

    public static void testProdSupConso() {
        Ressource res = new Ressource(5);
        Producteur prod1 = new Producteur("prod1", res, 500);
        Producteur prod2 = new Producteur("prod2", res, 500);
        Consommateur conso1 = new Consommateur("conso1", res, 1000);
        Consommateur conso2 = new Consommateur("conso2", res, 1000);
        prod1.start();
        prod2.start();
        conso1.start();
        conso2.start();

    }

    public static void main(String[] args) {
        testProdSupConso();
    }

}
