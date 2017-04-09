/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

import Boy.Boy;
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

/**
 *
 * @author redith
 */
public class Q5 extends Q1{
    public static void sort_boy() throws IOException{
         File ladka = new File("ladka.csv");
        String absladka = ladka.getAbsolutePath();
        b = Count(absladka)-1;
        boy = new Boy[b];
        Valentine V = new Valentine(boy);
        int i,j;
        for(i=1;i<b;i++){
            for(j=i;j>0;j--){
                if(boy[j].getAttractiveness()<boy[j-1].getAttractiveness()){
                    Boy temp = boy[j];
                    boy[j] = boy[j-1];
                    boy[j-1] = temp;
                }
            }
        }
    }
    public static void sort_girl() throws IOException{
        File ladki = new File("ladki1.csv");
        String absladki = ladki.getAbsolutePath();
        g = Count(absladki)-1;
        girl = new Girl[g];
        Valentine V = new Valentine(girl);
        int i,j;
        for(i=1;i<g;i++){
            for(j=i;j>0;j--){
                if(girl[j].getMaintaince()<girl[j-1].getMaintaince()){
                    Girl temp = girl[j];
                    girl[j] = girl[j-1];
                    girl[j-1] = temp;
                }
            }
        }
    }
    public static void new_commit() throws IOException{
     
        File out = new File("OutputQ5.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
        
        int i=0,j=0,k;
        while(i<b&&j<g){
            
            for(k=0;!(girl[j].isStatus())&&k<b;k++){ 
                if(!(boy[k].isStatus())&&!(girl[j].isStatus())){
                        
                      if(boy[k].getBudget()>=girl[j].getMaintaince()&&girl[j].getAttractiveness()>=boy[k].getMinattract()){
                            boy[k].setStatus(true);
                            girl[j].setStatus(true);
                            boy[k].setGf(girl[j]);
                            girl[j].setBf(boy[k]);
                            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                            Date dateobj = new Date();
                            String commit ="Commitment @"+df.format(dateobj)+" "+ boy[k].getName() + " is committed to "+girl[j].getName()+" "+'\r'+'\n' ;
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
           j++;
           if(boy[i].isStatus()){
               i++;
               continue;
           }
           int max = -1; 
           int x = -1;
           for(k=0;k<g;k++){
               if(boy[i].getBudget()<girl[k].getMaintaince())
                   break;
               if(!(girl[k].isStatus())){
                   if(max<girl[k].getAttractiveness()){
                       max = girl[k].getAttractiveness();
                       x = k;
                   }
               }
           } 
           if(x!=-1)
            if(girl[x].getAttractiveness()<boy[i].getMinattract())
                x = -1;
               //System.out.println("fuck");
            if(x!=-1){
                boy[i].setStatus(true);
                girl[x].setStatus(true);
                boy[i].setGf(girl[x]);
                girl[x].setBf(boy[i]);
                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Date dateobj = new Date();
                String commit ="Commitment @"+df.format(dateobj)+" "+ boy[i].getName() + " is committed to "+girl[x].getName()+" "+'\r'+'\n' ;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
	//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                     bw.write(commit);
                            //bw.newLine();
                } catch (IOException e) {
                        }
                   c++;
               }
        
            i++;
        } 
    }
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter 1 for allotment algo of Q1, any other number for Q5");
         Random rand = new Random();
        int i = rand.nextInt(3);
        if(i==1){
            commit();
        }
        else{
            sort_girl();
            sort_boy();
            new_commit();
        }
        System.out.println("The Committed couples are:");
       for(i=0;i<g;i++){
           if((girl[i].isStatus()))
            System.out.println(girl[i].getBf().getName()+" "+girl[i].getName());
       }
            
    }
}
