/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

import static java.lang.Math.log;

/**
 *
 * @author redith
 */
public class Choosy extends Girl {
    
    public Choosy(String name, int maintaince, int intelligence, int attractiveness, String type, String criteria) {
        super(name, maintaince, intelligence, attractiveness, type, criteria);
    }

    
    @Override
    public void setHappiness() {
        double happiness;
        int i;
        int sum= 0;
        for(i=0;i<getGiveme().size();i++)
        {
            if(getGiveme().get(i).getType().equalsIgnoreCase("Luxury"))
                sum += 2*(getGiveme().get(i).getPrice());
            else
                sum+=getGiveme().get(i).getPrice();
        }
        happiness = log(sum);
        super.setHappiness(happiness); //To change body of generated methods, choose Tools | Templates.
    }
 
}
