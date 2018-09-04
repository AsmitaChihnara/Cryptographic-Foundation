/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere;
import java.util.*;

/**
 *
 * @author STUDENT1
 */
public class Vigenere {

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
    public static String Vigenere(String s, int[] key){
        char[] c = s.toCharArray();
        int key_len = key.length;
        int n = c.length;
        int j = 0;
        String res = "";
        for(int i=0;i<n;i++){
            j = j%key_len;
            c[i] = (char)(mod((((int)c[i]-(int)'a')+key[j]),26)+(int)'a');
            j++;
            res += c[i];
        }
        return res;
    }
    public static String VigenereD(String s, int[] key){
        char[] c = s.toCharArray();
        int key_len = key.length;
        int n = c.length;
        int j = 0;
        String res = "";
        for(int i=0;i<n;i++){
            j = j%key_len;
            c[i] = (char)(mod((((int)c[i]-(int)'a')-key[j]),26)+(int)'a');
            j++;
            res += c[i];
        }
        return res;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter plaintxt: ");
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        int[] v_key = {15,0,18,2,0,11};
        String res = Vigenere(s, v_key);
        System.out.println("Encryption: "+res+"\tDecryption: "+VigenereD(res, v_key));
    }
    
}
