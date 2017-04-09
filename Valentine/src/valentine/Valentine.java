/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valentine;

/**
 *
 * @author redith
 */
import Boy.*;
import gift.*;
import girl.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
public class Valentine {
    
   
     
    public Valentine(Boy[] boy, Girl[] girl) throws IOException {
         
        readCSVguy(boy);
       
        
          readCSVgirl(girl);
          
        
}
     public Valentine(Boy[] boy) throws IOException {
         
        readCSVguy(boy);
       
        
   //       readCSVgirl(girl);
          
        
}
      public Valentine(Girl[] girl) throws IOException {
         
 //       readCSVguy(boy);
       
        
          readCSVgirl(girl);
          
        
}
    public Valentine(Gift[] gift) throws IOException{
        readCSVgift(gift);
    }
            
    public static void readCSVgift(Gift[] gift) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("tofa.csv"));
        String line = br.readLine(); // Reading header, Ignoring 
        int i = 0;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            String type = fields[0];
            int price = Integer.parseInt(fields[1]);
            int value = Integer.parseInt(fields[2]);
            if(type.equalsIgnoreCase("Luxury")){
             int a = Integer.parseInt(fields[3]);
             int b = Integer.parseInt(fields[4]);
             gift[i] = new Luxury(a,b,type,price,value); 
            }
            else if(type.equalsIgnoreCase("Utility")){
               int a = Integer.parseInt(fields[3]);
             int b = Integer.parseInt(fields[4]);
             gift[i] = new Utility(a,b,type,price,value);  
            }
            else 
                gift[i] = new Gift(type,price,value);
           i++;
             }
        br.close();
    }
    public static void readCSVguy(Boy[] boy) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("ladka.csv"));
        String line = br.readLine(); // Reading header, Ignoring 
        int i = 0;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            String name = fields[0];
            int budget = Integer.parseInt(fields[1]);
            int intel = Integer.parseInt(fields[2]);
            int attr = Integer.parseInt(fields[3]);
            String type = fields[4];
            int min =  Integer.parseInt(fields[5]);
            if(type.equalsIgnoreCase("Miser"))
                boy[i] = new Miser(name,budget,intel,attr,type,min);
            else if(type.equalsIgnoreCase("Generous"))
                 boy[i] = new Generous(name,budget,intel,attr,type,min);
            else if(type.equalsIgnoreCase("Geek"))
                 boy[i] = new Geek(name,budget,intel,attr,type,min);
           i++;
             }
        br.close();
           
    }
     public static void readCSVgirl(Girl[] girl) throws FileNotFoundException, IOException {
        BufferedReader br2 = new BufferedReader(new FileReader("ladki1.csv"));
        String line = br2.readLine(); // Reading header, Ignoring 
        int i = 0;
        while ((line = br2.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            String name = fields[0];
            int maintain = Integer.parseInt(fields[1]);
            int intel = Integer.parseInt(fields[2]);
            int attr = Integer.parseInt(fields[3]);
            String type = fields[4];
            String crit =  fields[5];
            if(type.equalsIgnoreCase("Choosy"))
                girl[i] = new Choosy(name,maintain,intel,attr,type,crit);
            else if(type.equalsIgnoreCase("Normal"))
                girl[i] = new Normal(name,maintain,intel,attr,type,crit);
            else if(type.equalsIgnoreCase("Desperate"))
                girl[i] = new Desperate(name,maintain,intel,attr,type,crit);
           i++;
             }
        br2.close();
           
    }
    public static int Count(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean endsWithoutNewLine = false;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n')
                        ++count;
                }
                endsWithoutNewLine = (c[readChars - 1] != '\n');
            }
            if(endsWithoutNewLine) {
                ++count;
            }
            return count;
        } finally {
            is.close();
        }
    }
    

    
    
}
