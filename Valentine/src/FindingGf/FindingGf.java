/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindingGf ;

import java.io.IOException;

/**
 *
 * @author redith
 */
public class FindingGf {
    public static String search(String guy,int i) throws IOException{
        HashTable code = new HashTable();
        if(i==2){
            
            ((BinarySearch)code).store();   //  To commit and store committed couples in a storted array list.
            return ((BinarySearch)code).search(guy);
        }
        else if(i==3){
            ((UsingArray)code).store(); //      To commit and store committed couples in an unsorted array list.
            return ((UsingArray)code).search(guy);
        }
        code.store();
        return code.search(guy);
    }
    public static String search(String guy) throws IOException{
        HashTable code = new HashTable();
        code.store();
        return code.search(guy); 
    }
}
