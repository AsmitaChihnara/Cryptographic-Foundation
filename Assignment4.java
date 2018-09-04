/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static int mult_inverse(int a, int n){
        for(int b=1;b<n;b++){
            int val=(a*b)%n;
            if(val<0)
                val+=n;
            if(val==1)
                return b;
        }
        return 0;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int a, n;
        System.out.println("Enter value of a : ");
        a=sc.nextInt();
        System.out.println("Enter value of n : ");
        n = sc.nextInt();
        int b=mult_inverse(a,n);
        if(b==0)
            System.out.println("Multiplicative inverse of "+a+" w.r.t to mod "+n+" doesn't exist. ");
        else
            System.out.println("Multiplicative inverse of "+a+" w.r.t to mod "+n+" : "+b);
    }
    
}
