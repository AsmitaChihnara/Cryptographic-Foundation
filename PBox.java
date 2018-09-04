/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbox;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class PBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of inputs: ");
        int n = sc.nextInt();
        int[][] arr= new int[2][n];
        System.out.println("Enter nos: ");
        for(int i=0;i<n;i++){
            arr[0][i]=sc.nextInt();
            arr[1][i]=i+1;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n-1;i++){
                if(arr[0][i]>arr[0][i+1]){
                    int temp=arr[0][i];
                    arr[0][i]=arr[0][i+1];
                    arr[0][i+1]=temp;
                    
                    temp=arr[1][i];
                    arr[1][i]=arr[1][i+1];
                    arr[1][i+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[0][i]+"\t");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(arr[1][i]+"\t");
        }
    }
    
}
