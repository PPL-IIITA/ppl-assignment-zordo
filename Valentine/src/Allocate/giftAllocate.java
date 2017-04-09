/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allocate;

import gift.Gift;
import girl.Girl;
import java.io.File;
import java.io.IOException;
import valentine.Valentine;
import static valentine.Valentine.Count;

/**
 *
 * @author redith
 */
public class giftAllocate {
    private static int gif;
    private static Gift[] gift;
    private static void storeSort() throws IOException{
         File tofa = new File("tofa.csv");
        String abstofa = tofa.getAbsolutePath();
        gif = Count(abstofa)-1;
        
        int i,j;
        gift = new Gift[gif];
        
        Valentine v1= new Valentine(gift);
        
        for(i=1;i<gif;i++){
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
       
    }
    private static void giftAlgo1(Girl[] girl){
        int i;
        for(i=0;i<girl.length;i++){
            if((girl[i].isStatus())){
                girl[i].getBf().gifther(girl[i], gif, gift);
            }
        }
    }
    private static void giftAlgo2(Girl[] girl){
        int i;
        for(i=0;i<girl.length;i++){
            if((girl[i].isStatus())){
                girl[i].getBf().gifther2(girl[i], gif, gift);
            }
        }
    }
    public static void gifther(Girl[] girl,int i) throws IOException{
        storeSort();
        if(i==2){
            giftAlgo2(girl);
        }
        else
            giftAlgo1(girl);
    }
    public static void gifther(Girl[] girl) throws IOException{
        storeSort();
        giftAlgo1(girl);
    }
}
