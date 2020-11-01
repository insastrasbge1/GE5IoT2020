/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v0;

import fr.insa.beuvron.cours.rappelsJava.pasApas.v2.Point;

/**
 *
 * @author francois
 */
public class Segment {
    
    private Point debut;
    private Point fin;

    public Segment(Point debut, Point fin) {
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "[" + debut + "," + fin + ']';
    }
    
    

    /**
     * @return the debut
     */
    public Point getDebut() {
        return debut;
    }

    /**
     * @return the fin
     */
    public Point getFin() {
        return fin;
    }
    
    
    
}
