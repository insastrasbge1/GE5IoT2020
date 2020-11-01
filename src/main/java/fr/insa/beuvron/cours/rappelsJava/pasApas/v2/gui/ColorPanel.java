/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author francois
 */
public class ColorPanel extends JPanel implements ActionListener{
    
    private JButton jbChange;
    private JPanel jpCouleur;
    
    public ColorPanel() {
        
        this.jbChange = new JButton("change couleur");
        this.jbChange.addActionListener(this);
        this.jpCouleur = new JPanel();
        
        this.setLayout(new BorderLayout());
        this.add(this.jbChange,BorderLayout.NORTH);
        this.add(this.jpCouleur,BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        JPanel deuxCouleurs = new JPanel(new GridLayout(1, 2, 5, 5));
        ColorPanel p1 = new ColorPanel();
        p1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        deuxCouleurs.add(p1);
        ColorPanel p2 = new ColorPanel();
        p2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        deuxCouleurs.add(p2);
        UtilsGui.tailleFixee("deux paneaux", deuxCouleurs, 400, 200);
        // UtilsGui.tailleFixee("coucou", new ColorPanel(), 400, 300);
    }

    public static Color couleurAlea() {
        return new Color((int)(Math.random()*256),
                (int)(Math.random()*256),
                (int)(Math.random()*256));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.jpCouleur.setBackground(couleurAlea());
    }
    
}
