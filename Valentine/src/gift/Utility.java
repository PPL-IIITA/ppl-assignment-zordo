/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

/**
 *
 * @author redith
 */
public class Utility extends Gift{
    private int utlvalue;
    private int utlclass;  

    public Utility(int utlvalue, int utlclass, String type, int price, int value) {
        super(type, price, value);
        this.utlvalue = utlvalue;
        this.utlclass = utlclass;
    }

    public int getUtlclass() {
        return utlclass;
    }

    public int getUtlvalue() {
        return utlvalue;
    }

    public void setUtlclass(int utlclass) {
        this.utlclass = utlclass;
    }

    public void setUtlvalue(int utlvalue) {
        this.utlvalue = utlvalue;
    }
    
}
