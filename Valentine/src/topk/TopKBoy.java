/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topk;

import Boy.Boy;
import java.util.ArrayList;

/**
 *
 * @author redith
 */
public class TopKBoy {
   ArrayList<Boy> x = new ArrayList<Boy>();
   
   public TopKBoy(Boy[] b,int k,String crit){
       Boy[] boy = new Boy[b.length];
       int i,j;
       for(i=0;i<b.length;i++)
           boy[i] = b[i];
       if(crit.equalsIgnoreCase("Rich")){
       for(i=1;i<b.length;i++){
            for(j=i;j>0;j--){
                if(boy[j].getBudget()>boy[j-1].getBudget()){
                    Boy temp = boy[j];
                    boy[j] = boy[j-1];
                    boy[j-1] = temp;
                }
                else
                    break;
            }
        }
       }
       else if(crit.equalsIgnoreCase("Attractive")){
            for(i=1;i<b.length;i++){
            for(j=i;j>0;j--){
                if(boy[j].getAttractiveness()>boy[j-1].getAttractiveness()){
                    Boy temp = boy[j];
                    boy[j] = boy[j-1];
                    boy[j-1] = temp;
                }
                else
                    break;
            }
        }
       }
       else if(crit.equalsIgnoreCase("Intelligence")){
            for(i=1;i<b.length;i++){
            for(j=i;j>0;j--){
                if(boy[j].getIntelligence()>boy[j-1].getIntelligence()){
                    Boy temp = boy[j];
                    boy[j] = boy[j-1];
                    boy[j-1] = temp;
                }
                else
                    break;
            }
        }
       }
       
       for(i=0;i<boy.length;i++){
           if(!(boy[i].isStatus())){
                x.add(boy[i]);
                //System.out.println("lul");
           }
           if(x.size()==k)
               break;
       }
   }

    public ArrayList<Boy> getX() {
        return x;
    }
   
    
}
