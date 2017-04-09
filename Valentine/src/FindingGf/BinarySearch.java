/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindingGf;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author redith
 */
public class BinarySearch extends UsingArray{
    @Override
    public void store() throws IOException{
        super.store();
        int i;
    Collections.sort(committed, new Comparator<ArrayList<String>>() {
    @Override
     public int compare(ArrayList<String> o1, ArrayList<String> o2) {
            return o1.get(0).compareTo(o2.get(0));
  }
    });    
    }
    @Override
    public String search(String guy){
        String ladki = binarySearch(committed,guy,0,index-1);
        return ladki;
    }
    public String binarySearch(ArrayList<ArrayList<String>> committed,String guy,int l,int h){
        if(h>=l){
            int m = l + (h-1)/2;
            if((committed.get(m).get(0)).equals(guy))
                return committed.get(m).get(1);
            if((committed.get(m).get(0)).compareTo(guy)>0){
                return binarySearch(committed,guy,l,m-1);
            }
            else
                return binarySearch(committed,guy,m+1,h);
        }
          return "Not committed";
    }
}
