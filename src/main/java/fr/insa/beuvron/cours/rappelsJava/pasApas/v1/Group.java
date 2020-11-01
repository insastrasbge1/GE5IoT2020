/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.rappelsJava.pasApas.v1;

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
}
