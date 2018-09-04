/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokey;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class Autokey {

    /**
     * @param args the command line arguments
     */
    static String autokey(String plaintext, int key){
        char[] c =  new char[plaintext.length()];
        int index;
        index=((int)plaintext.charAt(0)-(int)'a'+key)%26;
        if(index<0)
            index+=26;
        c[0]=(char)(index+(int)'a');
        for(int i=1;i<plaintext.length();i++){
            index=((int)plaintext.charAt(i)-(int)'a'+((int)plaintext.charAt(i-1)-(int)'a'))%26;
            if(index<0)
                index+=26;
            c[i]=(char)(index+(int)'a');
        }
        String ciphertxt=new String(c);
        return ciphertxt;
    }
    static String autokey_decr(String plaintext, int key){
        char[] c =  new char[plaintext.length()];
        int index;
        index=((int)plaintext.charAt(0)-(int)'a'-key)%26;
        if(index<0)
            index+=26;
        c[0]=(char)(index+(int)'a');
        for(int i=1;i<plaintext.length();i++){
            index=((int)plaintext.charAt(i)-(int)'a'-((int)c[i-1]-(int)'a'))%26;
            if(index<0)
                index+=26;
            c[i]=(char)(index+(int)'a');
        }
        String ciphertxt=new String(c);
        return ciphertxt;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext for encryption: ");
        String plaintext = sc.next();
        Random r = new Random();
        int key = r.nextInt(26);
        System.out.println("Key = "+key);
        String res=autokey(plaintext,key);
        System.out.println("Encrypted plaintext: "+res);
        System.out.println("Decrypted plaintext: "+autokey_decr(res,key));
    }
    
}
