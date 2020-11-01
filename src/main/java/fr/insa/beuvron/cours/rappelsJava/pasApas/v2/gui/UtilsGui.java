/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author francois
 */
public class UtilsGui {

    public static JFrame pack(String titre, JComponent compo) {
        JFrame f = new JFrame(titre);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(compo);
        f.pack();
        f.setVisible(true);
        return f;
    }

    public static JFrame tailleFixee(String titre, JComponent compo, int tx, int ty) {
        JFrame f = new JFrame(titre);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(compo);
        f.setSize(tx, ty);
        f.setVisible(true);
        return f;
    }

}
