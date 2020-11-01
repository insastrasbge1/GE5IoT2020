/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v1.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author francois
 */
public class CouleurPanel extends JPanel {
    
    private JButton jbChange;
    private JPanel jpCouleur;
    
    public CouleurPanel() {
        this.jbChange = new JButton("change couleur");
        this.jpCouleur = new JPanel();
        
        this.setLayout(new BorderLayout());
        this.add(this.jbChange,BorderLayout.NORTH);
        this.add(this.jpCouleur,BorderLayout.CENTER);
    }
    
}
