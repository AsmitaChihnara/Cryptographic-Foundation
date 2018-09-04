/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1ciphers;
import java.util.*;
import java.math.*;
/**
 *
 * @author STUDENT1
 */
public class Assignment1ciphers {

    /**
     * @param args the command line arguments
     */
    static String additiveCipher(String plaintxt,int key){
        
        char[] c =  new char[plaintxt.length()];
        
        int index;
        for(int i=0;i<plaintxt.length();i++){
            index=((int)plaintxt.charAt(i)-(int)'a'+key)%26+(int)'a';
            c[i]=(char)index;
        }
        String ciphertxt=new String(c);
        return ciphertxt;
       // System.out.println("Ciphertext: "+ciphertxt);
    }
    static String additive_decr(String plaintxt,int key){
        
        char[] c =  new char[plaintxt.length()];
        
        int index;
        for(int i=0;i<plaintxt.length();i++){
            index=((int)plaintxt.charAt(i)-(int)'a'-key)%26;
            if(index<0)
                index+=26;
            c[i]=(char)(index+(int)'a');
        }
        String ciphertxt=new String(c);
        return ciphertxt;
       // System.out.println("Ciphertext: "+ciphertxt);
    }
    static String multiplicativeCipher(String plaintxt,int key){
        char[] c =  new char[plaintxt.length()];
        
        int index;
        for(int i=0;i<plaintxt.length();i++){
            index=(((int)plaintxt.charAt(i)-(int)'a')*key)%26+(int)'a';
            c[i]=(char)index;
        }
        String ciphertxt=new String(c);
        return ciphertxt;
       // System.out.println("Ciphertext: "+ciphertxt);
    }
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
    static String multiplicative_decr(String plaintxt,int key){
        char[] c =  new char[plaintxt.length()];
        
        int index,mi;
        for(int i=0;i<plaintxt.length();i++){
            mi=multiplicativeInverse(26,key);
            if(mi==-1)
                return new String("doesn't exist");
            index=(((int)plaintxt.charAt(i)-(int)'a')*mi)%26;
            if(index<0)
                index+=26;
            c[i]=(char)(index+(int)'a');
        }
        String ciphertxt=new String(c);
        return ciphertxt;
       // System.out.println("Ciphertext: "+ciphertxt);
    }
    static String affineCipher(String plaintxt,int k1, int k2){
        return (additiveCipher(multiplicativeCipher(plaintxt,k1),k2));
    }
    static String affine_decr(String plaintxt,int k1, int k2){
        return (multiplicative_decr(additive_decr(plaintxt,k2),k1));
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext for encryption: ");
        String plaintext = sc.next();
        int option=1,key,key1;
        Random r = new Random();
        String res = new String();
        while(option!=0){
            System.out.println("-------------------------------");
            System.out.println("1. Additive Cipher");
            System.out.println("2. Caeser Cipher");
            System.out.println("3. Multiplicative Cipher");
            System.out.println("4. Affine Cipher");
            System.out.println("0. Quit");
            System.out.print("Enter corresponding options: ");
            option = sc.nextInt();
            switch(option){
                case 1: key = r.nextInt(26);
                        System.out.println("Additive Cipher: (key = "+key+")");
                        res=additiveCipher(plaintext,key);
                        System.out.println("Cipher text: "+res);
                        System.out.println("decrypted plaintext: "+additive_decr(res,key));
                        break;
                case 2: System.out.println("Caeser Cipher: ");
                        res=additiveCipher(plaintext,3);
                        System.out.println("Cipher text: "+res);
                        System.out.println("decrypted plaintext: "+additive_decr(res,3));
                        break;
                case 3: key = r.nextInt(26);
                        System.out.println("Multiplicative Cipher: (key = "+key+")");
                        res=multiplicativeCipher(plaintext,key);
                        System.out.println("Cipher text: "+res);
                        System.out.println("decrypted plaintext: "+multiplicative_decr(res,key));
                        break;
                case 4: key = r.nextInt(26);
                        key1 = r.nextInt(26);
                        System.out.println("Affine Cipher: (key1 = "+key+", key2 = "+key1+")");
                        res=affineCipher(plaintext,key,key1);
                        System.out.println("Cipher text: "+res);
                        System.out.println("decrypted plaintext: "+affine_decr(res,key,key1));
                        break;
                default: break;
            }
            
        }
    }
    
}
