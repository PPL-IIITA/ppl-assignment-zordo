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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author redith
 */
public class Q6 extends Q4{
    
    public static void main(String[] args) throws IOException {
         File out = new File("Gifting.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
            bw.write("");
                          
        } catch (IOException e) {
           }
        commit();
        int i;
        System.out.println("The Original Committed couples :");
       for(i=0;i<g;i++){
          if((girl[i].isStatus()))
            System.out.println(girl[i].getBf().getName()+" "+girl[i].getName());
       }
        int z;
        Random rand = new Random();
            int k = rand.nextInt(c);
            while((k = rand.nextInt(c))==0);
         //int k = Integer.parseInt(args[0]);
        
         z=0;
        while(true){
        gifting();
        calhappy();
        sort();
       
        if(k>c)
                k = c;
        
        breakup(k);
        reset();
        commit_again();
       int j = 0;
       int p = z+1;
       z++;
       System.out.println();
       System.out.println("The Committed couples after the "+p+" break-up and new commitments  are:");
       int count_stop = 0;
       for(i=0;i<g;i++){
          if((girl[i].isStatus()))
            System.out.println(girl[i].getBf().getName()+" "+girl[i].getName());
          else
              count_stop++;
       }
       System.out.println();
       if(count_stop==g){
        System.out.println("No more commitments can occur");
           break;
       }
    }
    
    }
}
