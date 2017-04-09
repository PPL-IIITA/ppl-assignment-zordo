/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import Boy.Boy;
import Boy.Miser;
import gift.Gift;
import girl.Choosy;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import valentine.Valentine;
import static valentine.Valentine.Count;
import topk.TopKBoy;
import topk.TopKGifts;
import static valentine.Valentine.Count;
/**
 *
 * @author redith
 */
public class Q9 {
    static Boy[] boy;
    static Girl[] girl;
    static int gif;
    static Gift[] gift;
    static Gift[] ogift;
    static int b;
    static int g;
    static int c=0;
     static int count=0;
    public static void commit_q9(int k) throws IOException{
         File ladka = new File("ladka.csv");
        String absladka = ladka.getAbsolutePath();
        File out = new File("Output.txt");
        


        b = Count(absladka)-1;
        boy = new Boy[b];
        Random random = new Random();
        k = random.nextInt(b);
        while((k = random.nextInt(b))==0);
        //System.out.println(k);
        File ladki = new File("ladki1.csv");
        String absladki = ladki.getAbsolutePath();
        
        g = Count(absladki)-1;
        girl = new Girl[g];
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
        Valentine V = new Valentine(boy,girl);
       // System.out.println(g+" "+b);
         int i = 0,j=0;
         for(j=0;j<g;j++){
              if((girl[j].isStatus()))
                  continue;
              //System.out.println(girl[j].getCriteria());
             TopKBoy men = new TopKBoy(boy, k, girl[j].getCriteria());
             String secondary;
             int max = 0;
           for(i=0;i<men.getX().size();i++){ 
              if(girl[j].getCriteria().equalsIgnoreCase("Rich")){
                 secondary = "Attractive";
                 if(men.getX().get(max).getAttractiveness()<men.getX().get(i).getAttractiveness())
                     max = i;
              }
             else if(girl[j].getCriteria().equalsIgnoreCase("Attractive")){
                 secondary = "Intelligent";
                 if(men.getX().get(max).getIntelligence()<men.getX().get(i).getIntelligence())
                     max = i;
             }
             else if(girl[j].getCriteria().equalsIgnoreCase("Intelligent")){
                 secondary = "Rich";
                 if(men.getX().get(max).getBudget()<men.getX().get(i).getBudget())
                     max = i;
             }
           }
           if(men.getX().size()==0)
               break;
              //System.out.println("fuck");
           
                            men.getX().get(max).setStatus(true);
                            girl[j].setStatus(true);
                            men.getX().get(max).setGf(girl[j]);
                            girl[j].setBf(men.getX().get(max));
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date dateobj = new Date();
                            String commit ="Commitment @"+df.format(dateobj)+" "+ men.getX().get(max).getName() + " is committed to "+girl[j].getName()+" "+'\r'+'\n' ;
                            System.out.println(commit);
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
                             c++;
                        
                
              
        }
         
         
    }
   /* public static void gifting(int k) throws IOException{
        File tofa = new File("tofa.csv");
        String abstofa = tofa.getAbsolutePath();
        gif = Count(abstofa)-1;
        if(k>gif)
            k = gif;
        int i,j;
        gift = new Gift[gif];
        Valentine v1= new Valentine(gift);
        
        
       TopKGifts khilona = new TopKGifts(gift,k);
      for(i=0;i<g;i++){
            if((girl[i].isStatus())){
                girl[i].getBf().gifther(girl[i],khilona.x );
            }
        }
    }*/
    public static void main(String[] args) throws IOException {
         Random rand = new Random();
        int k = rand.nextInt();
       
        commit_q9(k);
        
    }
}
