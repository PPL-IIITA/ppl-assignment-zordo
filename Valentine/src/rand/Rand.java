/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rand;

/**
 *
 * @author redith
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Rand {
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        String[] gift = {"Utility","Luxury","Essential"};
        String[] boy = {"Geek","Generous","Miser"};
        String[] girl = {"Choosy","Desperate","Normal"};
        String[] criteria ={"Rich","Attractive","Intelligent"};
        File guys = new File("Guys.txt");
        try (BufferedWriter bw7 = new BufferedWriter(new FileWriter(guys,false))) {
                String commit;

			bw7.write("");
                        } catch (IOException e) {
                            }
        
        File ladki = new File("ladki1.csv");
        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(ladki,false))) {
                String commit;
                        commit ="Name,Maintaince,Intelligence,Attractive,Type,Criteria"+'\r'+'\n';

			bw1.write(commit);
                        } catch (IOException e) {
                            }
        File ladka = new File("ladka.csv");
        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(ladka,false))) {
			String commit="Name,Budget,Intelligence,Attractive,Type,Minimum"+'\r'+'\n';
                            bw2.write(commit);
                            
                        } catch (IOException e) {
                            }
        File tofa = new File("tofa.csv");
         try (BufferedWriter bw3 = new BufferedWriter(new FileWriter(tofa,false))) {
                            String commit = "Type,Price,Value"+'\r'+'\n';
                            bw3.write(commit);
                            
                        } catch (IOException e) {
                            }
        Random random = new Random();
        int b,g,n;
        /*Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        g = sc.nextInt();
        n = sc.nextInt();
        sc.close();*/
        b= random.nextInt(100);
        g = random.nextInt(200);
        n = random.nextInt(300);
        //System.out.println(b+" "+g+" "+n);
        int i,j;
        for(i=0;i<n;i++){
        int select = random.nextInt(gift.length);
        String type = gift[select];
        int price = random.nextInt(100000);
        int value = random.nextInt(100000);
        int zzz =  0;
        int yyy = 0;
        try (BufferedWriter bw4 = new BufferedWriter(new FileWriter(tofa,true))) {
                    String commit;
                    if(type.equalsIgnoreCase("Essential"))
                            commit =type+","+price+","+value+'\r'+'\n';
                    else
                        commit =type+","+price+","+value+","+zzz+","+yyy+'\r'+'\n';
                    bw4.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
        
        }
        for(i=0;i<b;i++){
            int len = random.nextInt(20);
            if(len==0)
                len=10;
            StringBuilder sb = new StringBuilder( len );
            for( j = 0; j < len; j++ ) 
                    sb.append( AB.charAt( random.nextInt(AB.length()) ) );
            String name = sb.toString();
            int budg = random.nextInt(100000);
            int intel = random.nextInt(200);
            int attra = random.nextInt(200);
            int pos = random.nextInt(boy.length);
            String type = boy[pos];
            int min = random.nextInt(200);
             try (BufferedWriter bw10 = new BufferedWriter(new FileWriter(guys,true))) {
                String commit;

			bw10.write(name+'\r'+'\n');
                        } catch (IOException e) {
                            }
            try (BufferedWriter bw5 = new BufferedWriter(new FileWriter(ladka,true))) {
			
                        String commit = name+","+budg+","+intel+","+attra+","+type+","+min+'\r'+'\n';
                            bw5.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
        }
        for(i=0;i<g;i++){
            int len = random.nextInt(20);
            if(len==0)
                len=10;
            StringBuilder sb = new StringBuilder( len );
            for( j = 0; j < len; j++ ) 
                    sb.append( AB.charAt( random.nextInt(AB.length()) ) );
            String name = sb.toString();
            int maint = random.nextInt(100000);
            int intel = random.nextInt(200);
            int attra = random.nextInt(200);
            int pos = random.nextInt(girl.length);
            String type = girl[pos];
            int zz = random.nextInt(criteria.length);
            String crit = criteria[zz];
            try (BufferedWriter bw6 = new BufferedWriter(new FileWriter(ladki,true))) {
			
                        String commit = name+","+maint+","+intel+","+attra+","+type+","+crit+'\r'+'\n';
                            bw6.write(commit);
                            //bw.newLine();
                        } catch (IOException e) {
                            }
        
        }
        
    }
}
