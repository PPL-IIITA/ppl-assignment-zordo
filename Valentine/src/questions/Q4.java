/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import static questions.Q1.b;
import static questions.Q1.g;
import static valentine.Valentine.Count;

/**
 *
 * @author redith
 */
public class Q4 extends Q3{
    public static void breakup(int k){
        int i;
        File out = new File("breakup.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
        for(i=0;i<k;i++){
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date dateobj = new Date();
                            String commit ="Break up @"+df.format(dateobj)+" "+ girl1[i].getBf().getName() + " broke up with "+girl1[i].getName()+" "+'\r'+'\n' ;
                             try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
            girl1[i].setStatus(false);
            girl1[i].getEx().add(girl1[i].getBf());
            girl1[i].getBf().setStatus(false);
            girl1[i].getBf().getEx().add(girl1[i]);
            girl1[i].setBf(null);
            c--;
        }
        
    }
    public static void reset(){
        int i,j;
        for(i=0;i<count;i++){
            for(j=0;j<g;j++){
                if(girl1[i].equals(girl[j])){
                    girl[j].setStatus(girl1[i].isStatus());
                    if(girl1[i].isStatus())
                        girl[j].setBf(girl1[i].getBf());
                    break;
                }
                
            }
        }
    }
    public static void commit_again(){
        int i;
        File out = new File("CommitafterBreakup.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
        int j,z;
        for(j=0;j<g;j++){
            for(i=0;!(girl[j].isStatus())&&i<b;i++){ 
               //System.out.println("fuck");
               boolean flag = false;
               for(z=0;z<girl[j].getEx().size();z++)
                        if(girl[j].getEx().get(z).equals(boy[i])){
                            flag = true;
                            break;
                        }
               if(flag)
                   continue;
            if(!(boy[i].isStatus())&&!(girl[j].isStatus())){
                        
                      if(boy[i].getBudget()>=girl[j].getMaintaince()&&girl[j].getAttractiveness()>=boy[i].getMinattract()){
                            boy[i].setStatus(true);
                            girl[j].setStatus(true);
                            boy[i].setGf(girl[j]);
                            girl[j].setBf(boy[i]);
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date dateobj = new Date();
                            String commit ="Commitment @"+df.format(dateobj)+" "+ boy[i].getName() + " is committed to "+girl[j].getName()+" "+'\r'+'\n' ;
                             try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
                             c++;
                             
                        }
                }
            
           }   
        }
        
    }
    public static void main(String[] args) throws IOException {
        commit();
        gifting();
        calhappy();
        sort();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter k");
         Random rand = new Random();
         int k;
         while((k = rand.nextInt(c))==0);
        //int k = Integer.parseInt(args[0]);
        if(k>c)
                k = c;
        breakup(k);
        reset();
        commit_again();
         int i=0;
       int j = 0;
       System.out.println("The  Committed couples are:");
       for(i=0;i<g;i++){
           if((girl[i].isStatus()))
            System.out.println(girl[i].getName()+" "+girl[i].getBf().getName());
       }
    }
}
