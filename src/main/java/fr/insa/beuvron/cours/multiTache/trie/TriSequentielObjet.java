/*
 Copyright 2000-2014 Francois de Bertrand de Beuvron

 This file is part of CoursBeuvron.

 CoursBeuvron is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 CoursBeuvron is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.beuvron.cours.multiTache.trie;

import java.util.Arrays;

/**
 *
 * @author francois
 */
public class TriSequentielObjet {

    private int[] tab;
    private int min;
    private int max;

    public TriSequentielObjet(int[] tab, int min, int max) {
        this.tab = tab;
        this.min = min;
        this.max = max;
    }

    public void tri() {
//        System.out.println("sorting " + Arrays.toString(tab) + " between " + min + " and " + max);
        if (max - min < 2) {
            if (tab[min] > tab[max]) {
                int temp = tab[min];
                tab[min] = tab[max];
                tab[max] = temp;
            }
        } else {
            int milieu = (max + min) / 2;
            TriSequentielObjet inf = new TriSequentielObjet(tab, min, milieu);
            TriSequentielObjet sup = new TriSequentielObjet(tab, milieu+1, max);
            inf.tri();
            sup.tri();
            fusion();
        }
//        System.out.println("sorted " + Arrays.toString(tab) + " between " + min + " and " + max);
    }

    private void fusion() {
        int[] fu = new int[max - min + 1];
        int milieu = (max + min) / 2;
        int cur1 = min;
        int cur2 = milieu + 1;
        for (int i = 0; i < fu.length; i++) {
            if (cur1 > milieu) {
                // plus rien dans la première partie
                fu[i] = tab[cur2];
                cur2++;
            } else if (cur2 > max) {
                // plus rien dans la seconde partie
                fu[i] = tab[cur1];
                cur1++;
            } else if (tab[cur1] <= tab[cur2]) {
                fu[i] = tab[cur1];
                cur1++;
            } else {
                fu[i] = tab[cur2];
                cur2++;
            }
        }
        for (int i = 0; i < fu.length; i++) {
            tab[min + i] = fu[i];
        }
    }

    public boolean testTrie() {
        boolean res = true;
        int i = 0;
        while (res && i < tab.length - 1) {
            res = tab[i] <= tab[i + 1];
            i++;
        }
        return res;
    }

    public static int[] tabAlea(int size, int borneMax) {
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * borneMax);
        }
        return res;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int bmax = 5000;
        int[] t = tabAlea(size, bmax);
        TriSequentielObjet to = new TriSequentielObjet(t, 0, t.length-1);
        System.out.println("trie tableau taille : " + size + " (0 <= e < " + bmax + ")");
        long deb = System.currentTimeMillis();
        to.tri();
        long duree = System.currentTimeMillis() - deb;
        System.out.println(to.testTrie());
        System.out.println("in " + duree + " ms");

    }

}
