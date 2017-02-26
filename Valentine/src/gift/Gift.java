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
public class Gift {

    /**
     * @param args the command line arguments
     */
    private String type;
    private int price;
    private int value;

    public Gift(String type, int price, int value) {
        this.type = type;
        this.price = price;
        this.value = value;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
   
    
}
