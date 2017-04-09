/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topk;


import gift.Gift;
import java.util.ArrayList;

/**
 *
 * @author redith
 */
public class TopKGifts {
    ArrayList<Gift> x = new ArrayList<Gift>();

    public TopKGifts(Gift[] gift,int k) {
        int i,j;
        for(i=1;i<gift.length;i++){
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
        for(i=0;i<gift.length;i++){
           x.add(gift[i]);
           if(x.size()==k)
               break;
       }
    }
    public ArrayList<Gift> getX() {
        return x;
    }
    
}
