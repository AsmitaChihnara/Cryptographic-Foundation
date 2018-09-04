/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.Scanner;

/**
 *
 * @author STUDENT1
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static int calc_mod(int a,int n){
        if(a>=0)
            return a%n;
        else
            return (a%n)+n;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a, n;
        try{
            System.out.println("Enter two numbers a and n to find a mod n : ");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
            n = sc.nextInt();
            System.out.println(a+" mod "+n+" = "+calc_mod(a,n));
        }catch(Exception e){
             System.err.println("Enter valid integers.");
         }
    }
    
}
