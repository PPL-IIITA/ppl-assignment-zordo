/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *
 * @author redith
 */
public class Normal extends Girl{
    
    public Normal(String name, int maintaince, int intelligence, int attractiveness, String type, String criteria) {
        super(name, maintaince, intelligence, attractiveness, type, criteria);
    }

    
    @Override
    public void setHappiness() {
        int sum=0;
        int i;
        for(i=0;i<getGiveme().size();i++)
        {
            sum += (getGiveme().get(i).getPrice() + getGiveme().get(i).getValue());
        }
        double happiness = sum;
        super.setHappiness(happiness); //To change body of generated methods, choose Tools | Templates.
    }
    
}
