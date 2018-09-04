/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineardiophantine;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class LinearDiophantine {

    /**
     * @param args the command line arguments
     */
    public static int s,t;
    static int extendedEuclidean(int a, int b){
        int r1 = a, r2 = b;
        int s1 = 1, s2 = 0;
        int t1 = 0, t2 = 1;
        int q,r;
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
        s=s1;t=t1;
        return r1;
    }
    
    static void linearDiophantine(int a,int b,int c){
        int d = extendedEuclidean(a,b);
        float x0 = (c/d)*s;
        float y0 = (c/d)*t;
        System.out.println("General solution: ");
        System.out.println("x = "+x0+" + k * "+(float)(b/d));
        System.out.println("y = "+y0+" - k * "+(float)(a/d));
        System.out.println("where k is an integer.");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficients a, b, c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        linearDiophantine(a,b,c);
    }
    
}
