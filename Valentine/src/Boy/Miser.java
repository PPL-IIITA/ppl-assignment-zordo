/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boy;

import gift.Gift;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import questions.Q1;

/**
 *
 * @author redith
 */
public class Miser extends Boy{
    
    public Miser(String name, int budget, int intelligence, int attractiveness, String type, int minattract) {
        super(name, budget, intelligence, attractiveness, type, minattract);
    }
    @Override
    public void setHappiness() {
        double happiness = getBudget() - getExpense(); 
        super.setHappiness(happiness); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void gifther(Girl girl,int gif,Gift[] gift){
        int j;
        int sum = 0;
        File out = new File("Gifting.txt");
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        for(j=0;j<gif;j++){
            if(sum<girl.getMaintaince()){
                sum+=gift[j].getPrice();
                if(sum>getBudget()&&!(girl.getGiveme().isEmpty())){
                        setBudget(sum);
                                
                                
                }
                girl.getGiveme().add(gift[j]);
                String kya =getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+girl.getName()+" "+'\r'+'\n';
                System.out.print(kya);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                    bw.write(kya);
                              // bw.newLine();
                    } catch (IOException e) {
                                }        
                                
                            }
                            
                            else
                                break;
         }
        setExpense(sum);
        
    }

    @Override
    public void gifther2(Girl girl, int gif, Gift[] gift) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int j;
        int i;
        int sum = 0;
        int flag1=-1,flag2=-1,flag3=-1;
        File out = new File("Gifting.txt");
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
         for(i=0;i<gif;i++){
            if(gift[i].getType().equalsIgnoreCase("Essential")){
                flag1 = i;
                sum+=gift[i].getPrice();
                girl.getGiveme().add(gift[i]);
                String kya =getName()+" gifted object #"+gift[i]+"@"+df.format(dateobj)+" to "+girl.getName()+" "+'\r'+'\n';
                System.out.print(kya);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                    bw.write(kya);
                              // bw.newLine();
                    } catch (IOException e) {
                                }
                break;
            }
        }
        for(i=0;i<gif;i++){
            if(gift[i].getType().equalsIgnoreCase("Luxury")){
                flag2 = i;
                sum+=gift[i].getPrice();
                girl.getGiveme().add(gift[i]);
                String kya =getName()+" gifted object #"+gift[i]+"@"+df.format(dateobj)+" to "+girl.getName()+" "+'\r'+'\n';
                System.out.print(kya);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                    bw.write(kya);
                              // bw.newLine();
                    } catch (IOException e) {
                                }
                break;
            }
        }
         for(i=0;i<gif;i++){
            if(gift[i].getType().equalsIgnoreCase("Utility")){
                flag3 = i;
                sum+=gift[i].getPrice();
                girl.getGiveme().add(gift[i]);
                String kya =getName()+" gifted object #"+gift[i]+"@"+df.format(dateobj)+" to "+girl.getName()+" "+'\r'+'\n';
                System.out.print(kya);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                    bw.write(kya);
                              // bw.newLine();
                    } catch (IOException e) {
                                }
                break;
            }
        }
        if(sum>getBudget()){
            setExpense(sum);
            return;
        }
        for(j=0;j<gif;j++){
            if(j==flag1||j==flag2||j==flag3)
                continue;
            if(sum<girl.getMaintaince()){
                sum+=gift[j].getPrice();
                if(sum>getBudget()&&!(girl.getGiveme().isEmpty())){
                        setBudget(sum);
                                
                                
                }
                girl.getGiveme().add(gift[j]);
                String kya =getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+girl.getName()+" "+'\r'+'\n';
                System.out.print(kya);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                    bw.write(kya);
                              // bw.newLine();
                    } catch (IOException e) {
                                }        
                                
                            }
                            
                            else
                                break;
         }
        setExpense(sum);
    }
    
    
    
}
