/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

import static java.lang.Math.exp;

/**
 *
 * @author redith
 */
public class Desperate extends Girl {
    
    public Desperate(String name, int maintaince, int intelligence, int attractiveness, String type, String criteria) {
        super(name, maintaince, intelligence, attractiveness, type, criteria);
    }
    @Override
     public void setHappiness() {
        int sum=0;
        int i;
        for(i=0;i<getGiveme().size();i++)
        {
            sum += getGiveme().get(i).getPrice() ;
        }
        double happiness = exp(sum);
        super.setHappiness(happiness); //To change body of generated methods, choose Tools | Templates.
    }
    
}
