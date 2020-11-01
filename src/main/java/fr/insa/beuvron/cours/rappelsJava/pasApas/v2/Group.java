/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francois
 */
public class Group extends Figure {
    
    private List<Figure> figs;
    
    public Group(List<Figure> figs) {
        this.figs = figs;
    }
    
    public Group() {
        this(new ArrayList<Figure>());
    }

    /**
     * @return the figs
     */
    public List<Figure> getFigs() {
        return figs;
    }

    /**
     * @param figs the figs to set
     */
    public void setFigs(List<Figure> figs) {
        this.figs = figs;
    }

    @Override
    public double maxX() {
        if (this.figs.size() == 0) {
            return 0;
        } else {
            double res = this.figs.get(0).maxX();
            for(int i = 1 ; i < this.figs.size() ; i ++) {
                res = Math.max(res, this.figs.get(i).maxX());
            }
            return res;
        }
    }

    @Override
    public double minX() {
        if (this.figs.size() == 0) {
            return 0;
        } else {
            double res = this.figs.get(0).minX();
            for(int i = 1 ; i < this.figs.size() ; i ++) {
                res = Math.min(res, this.figs.get(i).minX());
            }
            return res;
        }
    }

    @Override
    public double maxY() {
        if (this.figs.size() == 0) {
            return 0;
        } else {
            double res = this.figs.get(0).maxY();
            for(int i = 1 ; i < this.figs.size() ; i ++) {
                res = Math.max(res, this.figs.get(i).maxY());
            }
            return res;
        }
    }

    @Override
    public double minY() {
        if (this.figs.size() == 0) {
            return 0;
        } else {
            double res = this.figs.get(0).minY();
            for(int i = 1 ; i < this.figs.size() ; i ++) {
                res = Math.min(res, this.figs.get(i).minY());
            }
            return res;
        }
    }
    
    public static Group groupTest() {
        Point p1 = new Point(Color.blue, 10, 20);
        Point p2 = new Point(Color.red, 100, 20);
        Point p3 = new Point(Color.green, 100, 100);
        Segment s1 = new Segment(Color.blue, p1, p3);
        Group res = new Group();
        res.figs.add(p1);
        res.figs.add(p2);
        res.figs.add(p3);
        res.figs.add(s1);
        return res;
    }

    @Override
    public void dessine(Graphics g) {
        for (Figure f : this.figs) {
            f.dessine(g);
        }
    }
}
