/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2;

import java.awt.Color;

/**
 *
 * @author francois
 */
public abstract class FigureColoree extends Figure {
    
    private Color couleur;
    
    public FigureColoree(Color couleur) {
        this.couleur = couleur;
    }
    
    public abstract double maxX();
    public abstract double minX();
    public abstract double maxY();
    public abstract double minY();

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    
    
}
