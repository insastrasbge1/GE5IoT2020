/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2.gui;

import fr.insa.beuvron.cours.rappelsJava.pasApas.v2.Group;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author francois
 */
public class DessinPanel extends JPanel{
    
    private Group scene;
    
    public DessinPanel(Group scene) {
        this.scene = scene;
    }
    
    public DessinPanel() {
        this(new Group());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.scene.dessine(g);
    }
        
    public static void main(String[] args) {
        DessinPanel dp = new DessinPanel(Group.groupTest());
        UtilsGui.tailleFixee("test", dp, 400, 300);        
    }
    
}
