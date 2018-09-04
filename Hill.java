/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hill;

import java.util.Scanner;

/**
 *
 * @author STUDENT1
 */
public class Hill {

    /**
     * @param args the command line arguments
     */
    public static int mod(int a, int n){
        if(a<0){
            a*=-1;
            a%=n;
            return n-a;
        }
        return a%n;
    }
    public static int multiInv(int a, int n){
        for(int i=1;i<n;i++){
            if((a*i)%n==1)
                return i;
        }
        return -1;
    }
     public static int[][] matmul(int[][] mat, int[][] key, int mod){
        int m = mat.length;
        int n = key[0].length;
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    result[i][j] = mod(result[i][j]+mod(mat[i][k]*key[k][j],mod),mod);
                }
            }
        }
        return result;
    }
    public static int det(int[][] mat, int mod){
        int n = mat.length;
        if(n==2){
            return mod(mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0], mod);
        }
        else if(n==3){
            int d1 = mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1];
            int d2 = mat[1][0]*mat[2][2]-mat[2][0]*mat[1][2];
            int d3 = mat[1][0]*mat[2][1]-mat[2][0]*mat[1][1];
            int val = mat[0][0]*d1-mat[0][1]*d2+mat[0][2]*d3;
            return mod(val,mod);
        }
        else{
            System.out.println("Did not consider size greater than 3");
            return -1;
        }
    }
    public static int[][] cofactor(int[][] mat){
        int n = mat.length;
        int[][] result = new int[n][n];
        if(n==2){
            result[0][0] = mat[1][1];
            result[0][1] = mat[1][0];
            result[1][0] = mat[0][1];
            result[1][1] = mat[0][0];
        }
        else {
            result[0][0] = mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1];
            result[0][1] = mat[1][0]*mat[2][2]-mat[2][0]*mat[2][2];
            result[0][2] = mat[1][0]*mat[2][1]-mat[2][0]*mat[1][2];
            result[1][0] = mat[0][1]*mat[2][2]-mat[2][1]*mat[0][2];
            result[1][1] = mat[0][0]*mat[2][2]-mat[2][0]*mat[0][2];
            result[1][2] = mat[0][0]*mat[2][1]-mat[2][0]*mat[0][1];
            result[2][0] = mat[0][1]*mat[1][2]-mat[1][1]*mat[0][2];
            result[2][1] = mat[0][0]*mat[1][2]-mat[1][0]*mat[0][2];
            result[2][2] = mat[0][0]*mat[1][1]-mat[1][0]*mat[0][1];
        }
        int mul = 1;
        for(int i=0;i<n;i++){
            if(i%2!=0)
                mul = -1;
            for(int j=0;j<n;j++){
                result[i][j] *= mul;
                mul *= -1;
            }
        }
        return result;
    }
    public static int[][] transpose(int[][] mat){
        int n = mat.length;
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = mat[j][i];
            }
        }
        return result;
    }
    public static int[][] scalar_multi_mod(int[][] mat, int mul, int mod){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = mod(mat[i][j]*mul,mod);
            }
        }
        return mat;
    }
     public static String Hill(String s, int[][] key){
        char[] c = s.toCharArray();
        int n = c.length;
        int mat_size = (int)Math.ceil(n/3);
        int[][] mat = new int[mat_size][3];
        int index = 0;
        for(int i=0;i<mat_size;i++){
            for(int j=0;j<3;j++){
                mat[i][j] = (int)c[index++]-(int)'a';
            }
        }
        int[][] result = matmul(mat, key,26);
        String res = "";
        for(int i=0;i<mat_size;i++){
            for(int j=0;j<3;j++){
                res += (char)(result[i][j]+(int)'a');
            }
        }
        return res;
    }
    public static String HillD(String s, int[][] key){
        int det = det(key, 26);
        //System.out.println(det);
        int[][] cofactor = cofactor(key);
        //printMat(cofactor);
        int[][] transpose = transpose(cofactor);
        //printMat(transpose);
        int det_inv = multiInv(det, 26);
        //System.out.println(det_inv);
        int[][] invmat = scalar_multi_mod(transpose, det_inv, 26);
        
        
        
        char[] c = s.toCharArray();
        int n = c.length;
        int mat_size = (int)Math.ceil(n/3);
        int[][] mat = new int[mat_size][3];
        int index = 0;
        for(int i=0;i<mat_size;i++){
            for(int j=0;j<3;j++){
                mat[i][j] = (int)c[index++]-(int)'a';
            }
        }
        int[][] result = matmul(mat, invmat,26);
        String res = "";
        for(int i=0;i<mat_size;i++){
            for(int j=0;j<3;j++){
                res += (char)(result[i][j]+(int)'a');
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] h_key = {{9,7,11},
                        {4,7,5},
                        {2,21,14}};
        int[][] mat = {{18,0,20},
                        {17,0,1},
                        {7,0,0}};
        int[][] result = matmul(mat, h_key,26);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Enter plaintxt: ");
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        String res = Hill(s, h_key);
        System.out.println("Encryption: "+res+"\tDecryption: "+HillD(res, h_key));
    }
    
}
