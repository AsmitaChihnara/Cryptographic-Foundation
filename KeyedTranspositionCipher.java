/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyedtranspositioncipher;

import java.util.*;
import java.math.*;
/**
 *
 * @author Asmita
 */
public class KeyedTranspositionCipher {

    /**
     * @param args the command line arguments
     */
    static String keyedTranspositionCipherEncrypt(String plaintxt, String key)
    {            
       int[] order = new int[key.length()];
       int[] s_order = new int[key.length()];
       for(int i=0;i<key.length();i++){
           order[i]=(int)key.charAt(i);
           s_order[i]=order[i];
       }
       Arrays.sort(s_order);
       //store
       int row = plaintxt.length()/key.length();
       if(plaintxt.length()%key.length()!=0)
           row=row+1;          
       char[][] table=new char[row+1][key.length()];
       for(int j=0;j<key.length();j++){
           table[0][j]=(char)order[j];
       }
       for(int i=1;i<row+1;i++){
           for(int j=0;j<key.length();j++){
               table[i][j]='*';
           }
       }
       /*for(int i=0;i<row+1;i++){
           for(int j=0;j<key.length();j++){
               System.out.print(table[i][j]);
           }System.out.println();
       }*/
       int index=0;
       for(int i=1;i<row+1;i++){
           for(int j=0;j<key.length() && index<plaintxt.length();j++){
               table[i][j]=plaintxt.charAt(index++);
           }
       }
       //read
       String cipher = new String();
       for(int i=0;i<key.length();i++){
           int col = s_order[i];
           for(int j=0;j<key.length();j++){
               if(col==table[0][j])
                   for(int k=1;k<row+1;k++){
                       cipher = cipher + table[k][j];
                   }
           }
       }
       return cipher;
    }
    
    static String keyedTranspositionCipherDecrypt(String cipher, String key){
        int[] order = new int[key.length()];
        int[] s_order = new int[key.length()];
        for(int i=0;i<key.length();i++){
            order[i]=(int)key.charAt(i);
            s_order[i]=order[i];
        }
        Arrays.sort(s_order);
        int row = cipher.length()/key.length();
        char[][] table=new char[row+1][key.length()];
        for(int j=0;j<key.length();j++){
           table[0][j]=(char)order[j];
        }
        
        int index=0;
        for(int i=0;i<key.length();i++){
            int col = s_order[i];
            for(int j=0;j<key.length();j++){
                if(col==table[0][j])
                    for(int k=1;k<row+1;k++){
                        table[k][j]=cipher.charAt(index++);
                    }
            }
        }
        String plaintxt=new String();
        for(int i=1;i<row+1;i++){
            for(int j=0;j<key.length() && table[i][j]!='*';j++){
                plaintxt = plaintxt + table[i][j];
            }
        }
        return plaintxt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext to encrypt: ");
        String plaintxt = sc.next();
        System.out.println("Enter key: ");
        String key = sc.next();
        String ciphertxt = keyedTranspositionCipherEncrypt(plaintxt,key);
        System.out.println("Encrypted cipher text: "+ ciphertxt);
        System.out.println("Decrypted cipher text: "+ keyedTranspositionCipherDecrypt(ciphertxt,key));
    }
    
}
