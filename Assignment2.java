/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static int find_gcd(int a, int b){
        if(a == 0 || b==0)
            return 0;
        if(a==b)
            return a;
        else{
            if(a>b)
                return find_gcd(a-b,b);
            else
                return find_gcd(a,b-a);
        }
           
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
                System.out.println("GCD of "+ a +" & "+ b+" is : "+ find_gcd(a,b));
        }catch(Exception e){
             System.err.println("Enter valid non-negative integers.");
         }

    }
    
}
