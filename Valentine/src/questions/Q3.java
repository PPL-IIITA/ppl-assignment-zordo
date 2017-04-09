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
import static java.lang.Math.abs;
import java.util.Random;
import java.util.Scanner;
import valentine.Valentine;
import static valentine.Valentine.*;

/**
 *
 * @author redith
 */
public class Q3 extends Q1{
    static int gif;
    static Gift[] gift;
    static Gift[] ogift;
    static Girl[] girl1 ;
    static Girl[] girl2;
    static int count=0;
    public static void gifting() throws IOException{
        File tofa = new File("tofa.csv");
        String abstofa = tofa.getAbsolutePath();
        gif = Count(abstofa)-1;
        girl1 = new Girl[g];
        girl2 = new Girl[g];
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
       
        for(i=0;i<g;i++){
            if((girl[i].isStatus())){
                girl[i].getBf().gifther(girl[i], gif, gift);
            }
        }
    }
    public static void calhappy(){
        int i;
        for(i=0;i<g;i++){
            if(girl[i].isStatus()){
                girl[i].setHappiness();
                girl[i].getBf().setHappiness();
            }
        }
    }
    public static void sort(){
        int i,j;
        count = 0;
         for(i=0;i<g;i++)
            {
                if(girl[i].isStatus()){
                    girl1[count] = girl[i];
                    girl2[count] = girl[i];
                   
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
         File out = new File("Gifting.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
            bw.write("");
                          
        } catch (IOException e) {
           }
        commit();
        gifting();
        calhappy();
        sort();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter k");
         Random rand = new Random();
        int k = rand.nextInt(c);while((k = rand.nextInt(c))==0);
        //int k = Integer.parseInt(args[0]);
        if(k>c)
                k = c;
        int i,j;
            
        System.out.println("Happy Couples Are:");
        for(i=count-1;i>=count-k;i--){
                System.out.println(girl1[i].getBf().getName()+" "+girl1[i].getName());
        }
        System.out.println("Compatible Couples Are:");
        for(i=count-1;i>=count-k;i--){
            System.out.println(girl2[i].getBf().getName()+" "+girl2[i].getName());
        }
    }
}
