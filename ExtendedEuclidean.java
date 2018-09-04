/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendedeuclidean;

import java.util.Scanner;

/**
 *
 * @author STUDENT1
 */
public class ExtendedEuclidean {

    /**
     * @param args the command line arguments
     */
    static int extendedEuclidean(int a, int b){
        int r1 = a, r2 = b;
        int s1 = 1, s2 = 0;
        int t1 = 0, t2 = 1;
        int q,r,s,t;
        while(r2>0){
            q=r1/r2;
            r=r1-q*r2;
            r1=r2;
            r2=r;
            s=s1-q*s2;
            s1=s2; s2=s;
            t=t1-q*t2;
            t1=t2;
            t2=t;
        }
        //System.out.println(s1+"     "+t1);
        return r1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a, b;
        try{
            System.out.println("Enter two numbers to find their GCD : ");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();
            b = sc.nextInt();
            if(a<0||b<0){
                System.out.println("Invalid!! Enter non-negative numbers.");
            }else
                System.out.println("GCD of "+ a +" & "+ b+" is : "+ extendedEuclidean(a,b));
        }catch(Exception e){
             System.err.println("Enter valid non-negative integers.");
         }
    }
    
}
