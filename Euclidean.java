/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euclidean;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class Euclidean {

    /**
     * @param args the command line arguments
     */
    static int find_gcd_euclidean(int a, int b){
        int temp;
        if(a<b){
            temp=a;
            a=b;
            b=temp;
        }
        if(b==0)
            return a;
        else
            return find_gcd_euclidean(b,a%b);
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
                System.out.println("GCD of "+ a +" & "+ b+" is : "+ find_gcd_euclidean(a,b));
        }catch(Exception e){
             System.err.println("Enter valid non-negative integers.");
         }
    }
    
}
