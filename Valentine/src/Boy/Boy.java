/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boy;

import girl.Girl;

/**
 *
 * @author redith
 */
public class Boy {
    private String name;
    private int budget;
    private int intelligence;
    private int attractiveness;
    private Girl gf;
    private boolean status = false;
    private String type;
    private int minattract;
    private double happiness;

    public Boy(String name, int budget, int intelligence, int attractiveness, String type, int minattract) {
        this.name = name;
        this.budget = budget;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.type = type;
        this.minattract = minattract;
    }
 

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public void setGf(Girl gf) {
        this.gf = gf;
    }

    public int getMinattract() {
        return minattract;
    }

    public Girl getGf() {
        return gf;
    }

    public double getHappiness() {
        return happiness;
    }
    
    public int getBudget() {
        return budget;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getName() {
        return name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }



    public int getAttractiveness() {
        return attractiveness;
    }
    
    
}
