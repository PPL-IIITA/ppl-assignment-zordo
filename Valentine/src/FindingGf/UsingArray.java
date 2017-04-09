/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindingGf;

import Boy.Boy;
import girl.Girl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import valentine.Valentine;
import static valentine.Valentine.Count;

/**
 *
 * @author redith
 */
public class UsingArray {
    ArrayList<ArrayList<String>> committed = new ArrayList<ArrayList<String>>();
    int index=0;
    public void store() throws IOException{
        Boy[] boy;
        Girl[] girl;
        int b;
        int g;
        int c=0;
        File ladka = new File("ladka.csv");
        String absladka = ladka.getAbsolutePath();
        File out = new File("Output.txt");
        b = Count(absladka)-1;
        boy = new Boy[b];
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
           for(i=0;!(girl[j].isStatus())&&i<b;i++){ 
          
               //System.out.println("fuck");
            if(!(boy[i].isStatus())&&!(girl[j].isStatus())){
                        
                      if(boy[i].getBudget()>=girl[j].getMaintaince()&&girl[j].getAttractiveness()>=boy[i].getMinattract()){
                            boy[i].setStatus(true);
                            girl[j].setStatus(true);
                            boy[i].setGf(girl[j]);
                            girl[j].setBf(boy[i]);
                            committed.add(new ArrayList<String>(Arrays.asList(boy[i].getName(),girl[j].getName())));
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
                             index++;
                        }
                }
           }   
        }
        
    }
    public String search(String guy){
        int i;
        for(i=0;i<committed.size();i++){
            if(committed.get(i).get(0).equalsIgnoreCase(guy))
                return committed.get(i).get(1); 
        }
        return "Not Committed";
    }
}

   
