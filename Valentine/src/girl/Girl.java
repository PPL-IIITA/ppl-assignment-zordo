/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

import Boy.Boy;
import gift.Gift;
import java.util.ArrayList;

/**
 *
 * @author redith
 */
public class Girl {
    private String name;
    private int maintaince;
    private int intelligence;
    private int attractiveness;
    private Boy bf;
    private boolean status = false;
    private String type;
    private String criteria;
    private double happiness;
    private ArrayList<Gift> giveme = new ArrayList<Gift>();

    public ArrayList<Gift> getGiveme() {
        return giveme;
    }

    
    public Girl(String name, int maintaince, int intelligence, int attractiveness, String type, String criteria) {
        this.name = name;
        this.maintaince = maintaince;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.type = type;
        this.criteria = criteria;
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

    public void setBf(Boy bf) {
        this.bf = bf;
    }

    public String getCriteria() {
        return criteria;
    }

    public Boy getBf() {
        return bf;
    }

    public double getHappiness() {
        return happiness;
    }
    
    public int getMaintaince() {
        return maintaince;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getName() {
        return name;
    }
    public int getAttractiveness() {
        return attractiveness;
    }
    
}
