/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2;

import java.awt.Graphics;

/**
 *
 * @author francois
 */
public abstract class Figure {
    
    public abstract double maxX();
    public abstract double minX();
    public abstract double maxY();
    public abstract double minY();
   
    public abstract void dessine(Graphics g);
}
