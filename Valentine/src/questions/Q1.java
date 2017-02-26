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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import valentine.Valentine;
import static valentine.Valentine.Count;

/**
 *
 * @author redith
 */
public class Q1 {
         Boy[] boy;
         Girl[] girl;
         int b;
         int g;
         int c=0;
    public Q1() throws IOException {
        File ladka = new File("ladka.csv");
        String absladka = ladka.getAbsolutePath();
        File out = new File("Output.txt");
        


        this.b = Count(absladka)-1;
        this.boy = new Boy[this.b];
        File ladki = new File("ladki1.csv");
        String absladki = ladki.getAbsolutePath();
        
        this.g = Count(absladki)-1;
        this.girl = new Girl[this.g];
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
        Valentine V = new Valentine(this.boy,this.girl);
       // System.out.println(g+" "+b);
         int i = 0,j=0;
        
         for(j=0;j<this.g;j++){
           for(i=0;!(girl[j].isStatus())&&i<this.b;i++){ 
               //System.out.println("fuck");
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
         //System.out.println(c);
    }
    
     public static void main(String[] args) throws IOException {
        // TODO code application logic here
       Q1 q = new Q1();
       int i=0;
       int j = 0;
       System.out.println("The Committed couples are:");
       for(i=0;i<q.g;i++){
           if((q.girl[i].isStatus()))
            System.out.println(q.girl[i].getName()+" "+q.girl[i].getBf().getName());
       }
    }
    
}
