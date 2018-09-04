/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixinverse;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class MatrixInverse {

    /**
     * @param args the command line arguments
     */
    static int r2;
    static int extendedEuclidean(int a, int b){
        int r1 = b; r2 = a;
        int t1 = 0, t2 = 1;
        int q,r,t;
        while(r2>0){
            q=r1/r2;
            r=r1-q*r2;
            r1=r2;
            r2=r;
            t=t1-q*t2;
            t1=t2;
            t2=t;
        }
        //System.out.println(s1+"     "+t1);
         
            return t1;
    }
    static int multiplicativeInverse(int n,int num){
        int inverse = extendedEuclidean(num,n);
        //System.out.println(" t1 "+inverse);
        if(r2==0){
            if(inverse<0)
                return inverse+n;
            else
                 return inverse;
        }else
            return -1;
    }
    static void order2_inverse(int n){
        System.out.println("Enter matrix:");
        Scanner sc = new Scanner(System.in);
        int arr[][]=new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++)
                arr[i][j]=sc.nextInt();
        }
        int det = arr[0][0]*arr[1][1]-arr[0][1]*arr[1][0];
        det = det%n;
        if(det<0)
            det+=n;
        det = multiplicativeInverse(n,det);
        if(det==-1 || det==0){
            System.out.println("Inverse doesn't exist!!");
            return;
        }
        int cofact_arr[][]=new int[2][2];
        cofact_arr[0][0]=arr[1][1];
        cofact_arr[0][1]=-arr[0][1];
        cofact_arr[1][0]=-arr[1][0];
        cofact_arr[1][1]=arr[0][0];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++){
                cofact_arr[i][j]=(cofact_arr[i][j]*det)%n;
                if(cofact_arr[i][j]<0)
                    cofact_arr[i][j]+=n;
            }
        System.out.println("Inverse of the matrix is ");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(cofact_arr[i][j]+"\t");
            }System.out.println();
        }
    }
    static void order3_inverse(int n){
        System.out.println("Enter matrix:");
        Scanner sc = new Scanner(System.in);
        int arr[][]=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                arr[i][j]=sc.nextInt();
        }
        int det = arr[0][0]*(arr[1][1]*arr[2][2] - arr[1][2]*arr[2][1])
                    - arr[0][1]*(arr[1][0]*arr[2][2] - arr[1][2]*arr[2][1])
                    + arr[0][2]*(arr[1][0]*arr[2][1] - arr[1][1]*arr[2][0]);
        det = det%n;
        if(det<0)
            det+=n;
        det = multiplicativeInverse(n,det);
        if(det==-1 || det==0){
            System.out.println("Inverse doesn't exist!!");
            return;
        }
        int[][] cofac = new int[3][3];
            
            cofac[0][0] = arr[1][1]*arr[2][2] - arr[1][2]*arr[2][1];
            cofac[0][1] = -arr[1][0]*arr[2][2] + arr[1][2]*arr[2][1];
            cofac[0][2] = arr[1][0]*arr[2][1] - arr[1][1]*arr[2][0];
            cofac[1][0] = -arr[0][1]*arr[2][2] + arr[0][2]*arr[2][1];
            cofac[1][1] = arr[0][0]*arr[2][2] - arr[0][2]*arr[2][0];
            cofac[1][2] = -arr[0][0]*arr[2][1] + arr[0][1]*arr[2][0];
            cofac[2][0] = arr[0][1]*arr[1][2] - arr[0][2]*arr[1][1];
            cofac[2][1] = -arr[0][0]*arr[1][2] + arr[0][2]*arr[1][0];
            cofac[2][2] = arr[0][0]*arr[1][1] - arr[0][1]*arr[1][0];
            
            int ad3[][] = {{det*cofac[0][0], det*cofac[1][0], det*cofac[2][0]}, 
                            {det*cofac[0][1], det*cofac[1][1], det*cofac[2][1]},
                            {det*cofac[0][2], det*cofac[1][2], det*cofac[2][2]}};
            
            for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                cofac[i][j]=(cofac[i][j])%n;
                if(cofac[i][j]<0)
                    cofac[i][j]+=n;
            }
        System.out.println("Inverse of the matrix is ");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(cofac[i][j]+"\t");
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter order of matrix(2 or 3): ");
        int o = sc.nextInt();
        if(o==2)
            order2_inverse(n);
        else
            order3_inverse(n);
    }
    
}
