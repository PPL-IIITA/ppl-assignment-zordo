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
public class Luxury extends Gift{
    private int rating;
    private int difficulty;    

    public int getDifficulty() {
        return difficulty;
    }

    public int getRating() {
        return rating;
    }

    public Luxury(int rating, int difficulty, String type, int price, int value) {
        super(type, price, value);
        this.rating = rating;
        this.difficulty = difficulty;
    }
    
}
