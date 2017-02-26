/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import gift.Gift;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import valentine.Valentine;
import static valentine.Valentine.Count;

/**
 *
 * @author redith
 */
public class Q2 {
    int gif;
    Gift[] gift;
    Gift[] ogift;
    Q1 q1 = new Q1();
    Girl[] girl1 ;
    Girl[] girl2;
    int count=0;
        public Q2() throws IOException{
            File tofa = new File("tofa.csv");
            String abstofa = tofa.getAbsolutePath();
             this.gif = Count(abstofa)-1;
             girl1 = new Girl[q1.g];
             girl2 = new Girl[q1.g];
             int i,j;
             gift = new Gift[gif];
             ogift = new Gift[gif];
            Valentine v1= new Valentine(gift);
            for(i=0;i<gif;i++)
                ogift[i] = gift[i];
            for(i=1;i<gif;i++){
                for(j=i;j>0;j--){
                    if(gift[j].getPrice()<gift[j-1].getPrice()){
                        Gift temp = gift[j];
                        gift[j] = gift[j-1];
                        gift[j-1] = temp;
                    }
                    else
                        break;
                }
            }
            File out = new File("Gifting.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            //for(i=0;i<gif;i++)
              //  System.out.println(gift[i].getPrice());
            for(i=0;i<q1.g;i++){
                if((q1.girl[i].isStatus())){
                    //System.out.println(q1.girl[i].getName());
                    String crap=q1.girl[i].getBf().getType();
                    String gfcrap = q1.girl[i].getType();
                    int sum = 0;
                    if(crap.equalsIgnoreCase("Miser")){
                        
                        for(j=0;j<gif;j++){
                            if(sum<q1.girl[i].getMaintaince()){
                                sum+=gift[j].getPrice();
                                if(sum>q1.girl[i].getBf().getBudget()&&!(q1.girl[i].getGiveme().isEmpty())){
                                q1.girl[i].getBf().setBudget(sum);
                                
                                
                            }
                               q1.girl[i].getGiveme().add(gift[j]);
                               String kya =q1.girl[i].getBf().getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+q1.girl[i].getName()+" "+'\r'+'\n';
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
                        
                        
                        //System.out.println(sum);
                            q1.girl[i].getBf().setHappiness((double)(q1.girl[i].getBf().getBudget()-sum));
                            //System.out.println(q1.girl[i].getBf().getHappiness());
                         sum = 0;
                         int size = q1.girl[i].getGiveme().size();
                         int k;
                        switch (gfcrap){
                            case "Choosy" :
                                for(k=0;k<size;k++){
                                    if(q1.girl[i].getGiveme().get(k).getType().equalsIgnoreCase("Luxury"))
                                            sum+= 2*(q1.girl[i].getGiveme().get(k).getPrice());
                                    else
                                        sum+=(q1.girl[i].getGiveme().get(k).getPrice());
                                }
                                double stuff = log(sum);
                                q1.girl[i].setHappiness(stuff);
                                break;
                            case "Normal" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                q1.girl[i].setHappiness(sum);
                                break;
                            case "Desperate" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                double exo = exp(sum);
                                q1.girl[i].setHappiness(exo);
                                break;
                            default :
                                break;
                           
                        }
                       // System.out.println(q1.girl[i].getHappiness());
                        
                        
                    }
                    else if(crap.equalsIgnoreCase("Generous")){
                        for(j=0;j<gif;j++){
                            if(sum<q1.girl[i].getBf().getBudget()){
                                 
                                sum+=gift[j].getPrice();
                                if(sum>q1.girl[i].getBf().getBudget()&&!(q1.girl[i].getGiveme().isEmpty())){
                                sum-=gift[j].getPrice();
                                
                            }
                                else{
                                q1.girl[i].getGiveme().add(gift[j]);
                                String kya1 =q1.girl[i].getBf().getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+q1.girl[i].getName()+" "+'\r'+'\n';
                                System.out.print(kya1);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                bw.write(kya1);
                                //bw.newLine();
                            } catch (IOException e) {
                                } 
                            }
                            }
                            else
                                break;
                        }
                        
                        
                        
                         sum = 0;
                         int size = q1.girl[i].getGiveme().size();
                         int k;
                        switch (gfcrap){
                            case "Choosy" :
                                for(k=0;k<size;k++){
                                    if(q1.girl[i].getGiveme().get(k).getType().equalsIgnoreCase("Luxury"))
                                            sum+= 2*(q1.girl[i].getGiveme().get(k).getPrice());
                                    else
                                        sum+=(q1.girl[i].getGiveme().get(k).getPrice());
                                }
                                double stuff = log(sum);
                                q1.girl[i].setHappiness(stuff);
                                break;
                            case "Normal" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                q1.girl[i].setHappiness(sum);
                                break;
                            case "Desperate" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                double exo = exp(sum);
                                q1.girl[i].setHappiness(exo);
                                break;
                            default :
                                break;
                           
                        }
                        q1.girl[i].getBf().setHappiness(q1.girl[i].getHappiness());
                        //System.out.println(q1.girl[i].getHappiness());
                        
                    }
                    else if(crap.equalsIgnoreCase("Geek")){
                        for(j=0;j<gif;j++){
                            if(sum<q1.girl[i].getMaintaince()){
                                sum+=gift[j].getPrice();
                                if(sum>q1.girl[i].getBf().getBudget()&&!(q1.girl[i].getGiveme().isEmpty())){
                                q1.girl[i].getBf().setBudget(sum);
                                
                            }
                                
                                
                                    q1.girl[i].getGiveme().add(gift[j]);
                                    String kyay =q1.girl[i].getBf().getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+q1.girl[i].getName()+" "+'\r'+'\n';
                                    System.out.print(kyay);
                                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                    bw.write(kyay);
                                    //bw.newLine();
                                    } catch (IOException e) {
                                    } 
                                
                                
                            }
                           
                            else 
                                break;
                         }
               
                         
                        for(;j<gif;j++){
                            if(gift[j].getType().equalsIgnoreCase("Luxury"))
                            {   sum+=gift[j].getPrice();
                            if(sum<=q1.girl[i].getBf().getBudget()){
                                q1.girl[i].getGiveme().add(gift[j]);
                                String kyax =q1.girl[i].getBf().getName()+" gifted object #"+gift[j]+"@"+df.format(dateobj)+" to "+q1.girl[i].getName()+" "+'\r'+'\n';
                                System.out.print(kyax);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                bw.write(kyax);
                                //bw.newLine();
                            } catch (IOException e) {
                                } 
                            
                                break;}
                            else
                                sum-=gift[j].getPrice();}
                        }
                        q1.girl[i].getBf().setHappiness((double)q1.girl[i].getIntelligence());
                        sum = 0;
                         int size = q1.girl[i].getGiveme().size();
                         int k;
                        switch (gfcrap){
                            case "Choosy" :
                                for(k=0;k<size;k++){
                                    if(q1.girl[i].getGiveme().get(k).getType().equalsIgnoreCase("Luxury"))
                                            sum+= 2*(q1.girl[i].getGiveme().get(k).getPrice());
                                    else
                                        sum+=(q1.girl[i].getGiveme().get(k).getPrice());
                                }
                                double stuff = log(sum);
                                q1.girl[i].setHappiness(stuff);
                                break;
                            case "Normal" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                q1.girl[i].setHappiness(sum);
                                break;
                            case "Desperate" :
                                for(k=0;k<size;k++){
                                            sum+= (q1.girl[i].getGiveme().get(k).getPrice());
                                    
                                        sum+=(q1.girl[i].getGiveme().get(k).getValue());
                                }
                                double exo = exp(sum);
                                q1.girl[i].setHappiness(exo);
                                break;
                            default :
                                break;
                           
                        }
                        //System.out.println(q1.girl[i].getHappiness());
                    }
                }
                
                   
            }
            for(i=0;i<q1.g;i++)
            {
                if(q1.girl[i].isStatus()){
                    girl1[count] = q1.girl[i];
                    girl2[count] = q1.girl[i];
                   
                    count++;
                }
            }
            
            for(i=1;i<count;i++)
            {
                //System.out.println(count+" "+n);
                // System.out.println(girl1[i].getHappiness());
                for(j=i;j>0;j--)
                {
                    
                    if(sumhappy(girl1[j])<sumhappy(girl1[j-1])){
                        Girl temp = girl1[j];
                        girl1[j] = girl1[j-1];
                        girl1[j-1] = temp;
                    }
                    else
                        break;
                        
                }
            }
            for(i=1;i<count;i++)
            {
                for(j=i;j>0;j--){
                    if(comp(girl2[j])<comp(girl2[j-1])){
                        Girl temp = girl2[j];
                        girl2[j] = girl2[j-1];
                        girl2[j-1] = temp;
                    }
                    else
                        break;
                }
            }
        }
        public static double sumhappy(Girl ob){
            double sum =  ob.getHappiness() + ob.getBf().getHappiness();
            return sum;
        }
        public static int comp(Girl ob){
            int att;
            att = ob.getAttractiveness() - ob.getBf().getAttractiveness();
            int intel;
            intel = ob.getIntelligence() - ob.getBf().getIntelligence();
            int money;
            money = ob.getBf().getBudget() - ob.getMaintaince();
            int sum = abs(money)+abs(intel)+abs(att);
            return sum;
        }
        public static void main(String[] args) throws IOException {
            Q2 q2 = new Q2();
            int k = Integer.parseInt(args[0]);
            if(k>q2.q1.c)
                k = q2.q1.c;
            //int n = q2.q1.g;
            int i,j;
            
            System.out.println("Happy Couples Are:");
            for(i=q2.count-1;i>=q2.count-k;i--){
                System.out.println(q2.girl1[i].getName()+" "+q2.girl1[i].getBf().getName());
            }
            System.out.println("Compatible Couples Are:");
            for(i=q2.count-1;i>=q2.count-k;i--){
                System.out.println(q2.girl2[i].getName()+" "+q2.girl2[i].getBf().getName());
            }
            
    }
}
