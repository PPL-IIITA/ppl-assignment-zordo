/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boy;

import gift.Gift;
import girl.Girl;
import java.util.ArrayList;

/**
 *
 * @author redith
 */
public abstract class Boy {
    private String name;
    private int budget;
    private int intelligence;
    private int attractiveness;
    private Girl gf;
    private boolean status = false;
    private String type;
    private int minattract;
    private int expense;
    private double happiness;
    private ArrayList<Girl> ex = new ArrayList<Girl>();
    
    public Boy(String name, int budget, int intelligence, int attractiveness, String type, int minattract) {
        this.name = name;
        this.budget = budget;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.type = type;
        this.minattract = minattract;
    }

    public ArrayList<Girl> getEx() {
        return ex;
    }
    
    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
    public abstract void gifther(Girl girl,int gif,Gift[] gift);
    public abstract void gifther2(Girl girl,int gif,Gift[] gift);
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
    public abstract void setHappiness();
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
