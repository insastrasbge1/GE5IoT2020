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
public class Point extends FigureColoree {
    
    public static int RAYON_POINTS = 5;
    
    private double px;
    private double py;

    public Point(Color couleur,double px, double py) {
        super(couleur);
        this.px = px;
        this.py = py;
    }
    
    public Point() {
        this(Color.BLACK,0,0);
    }

    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    }

    /**
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    @Override
    public double maxX() {
        return this.px;
    }

    @Override
    public double minX() {
        return this.px;
    }

    @Override
    public double maxY() {
        return this.py;
    }

    @Override
    public double minY() {
        return this.py;
    }

    @Override
    public void dessine(Graphics g) {
        g.setColor(this.getCouleur());
        g.fillOval((int) (this.px - RAYON_POINTS),
                (int) (this.py-RAYON_POINTS),
                2*RAYON_POINTS,2*RAYON_POINTS);
    }
    
}
