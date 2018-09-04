/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.*;
import java.math.BigInteger;
/**
 *
 * @author STUDENT1
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    static BigInteger factorial(int n){
        BigInteger f = new BigInteger("1");
        if(n==0||n==1){
             return BigInteger.ONE;
         }else
             return factorial(n-1).multiply(BigInteger.valueOf(n));
     }
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        System.out.println("Enter a no. to find factorial: ");
        try{
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            if(n<0){
                System.out.println("Invalid!! Enter a non-negative number.");
            }else
                System.out.println("Factorial = "+factorial(n));
         }catch(Exception e){
             System.err.println("Enter a valid non-negative integer.");
         }
    }
    
}
