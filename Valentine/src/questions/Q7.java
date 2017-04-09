/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions;

/**
 *
 * @author redith
 */

import FindingGf.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Q7 {
    static ArrayList<String> allmen = new ArrayList<String>();
    public static void read() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("Guys.txt"));
        String line ;
        while ((line = br.readLine()) != null && !line.isEmpty()){
            allmen.add(line);
        }
        br.close();
    }
       public static void main(String[] args) throws IOException {
        
        read();                           //Inputs the list of name of men
        int i;
        int x = 2;
        for(i=0;i<allmen.size();i++){
            String ret;
            ret = FindingGf.search(allmen.get(i));                // TO search in hashmap. The default case.
            //ret = FindingGf.search(allmen.get(i),x);               //If x = 2 stores and searches in sorted array list, if x =3 stores and searches in unsorted arraylist
                                                                       //for any other x searches in Hashmap.
            System.out.println(allmen.get(i)+" "+ret);
        }
        
        
    }
}
