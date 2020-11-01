/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author francois
 */
public class Segment extends FigureColoree {
    
    private Point debut;
    private Point fin;

    public Segment(Color couleur,Point debut, Point fin) {
        super(couleur);
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

    @Override
    public double maxX() {
        return Math.max(this.debut.maxX(), this.fin.maxX());
    }

    @Override
    public double minX() {
        return Math.min(this.debut.minX(), this.fin.minX());
    }

    @Override
    public double maxY() {
        return Math.max(this.debut.maxY(), this.fin.maxY());
    }

    @Override
    public double minY() {
        return Math.min(this.debut.minY(), this.fin.minY());
    }

    @Override
    public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.drawLine((int) this.debut.getPx(),
                (int) this.debut.getPy(),
                (int) this.fin.getPx(),
                (int) this.fin.getPx());
    }
    
    
    
}
