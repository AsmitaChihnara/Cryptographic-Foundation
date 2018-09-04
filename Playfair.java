/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfair;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class Playfair {

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
    public static String Playfair(String s, char[][] key){
        int n = s.length();
        if(n%2!=0){
            s += "x";
        }
        char[] c = s.toCharArray();
        n = c.length;
        String res = "";
        for(int i=0;i<n;i+=2){
            char a = c[i];
            char b = c[i+1];
            int[] posa = getPos(a, key);
            int[] posb = getPos(b, key);
            if(posa[0]==posb[0] && posa[1]==posb[1]){
                c[i] = key[posa[0]][posa[1]];
                c[i+1] = key[posa[0]][posa[1]];
            }
            else if(posa[0]==posb[0]){
                c[i] = key[posa[0]][(posa[1]+1)%5];
                c[i+1] = key[posb[0]][(posb[1]+1)%5];
            }
            else if(posa[1]==posb[1]){
                c[i] = key[(posa[0]+1)%5][posa[1]];
                c[i+1] = key[(posb[0]+1)%5][posb[1]];
            }
            else{
                
                c[i] = key[posa[0]][posb[1]];
                c[i+1] = key[posb[0]][posa[1]];
            }
            res += c[i]+""+c[i+1];
        }
        return res;
    }
    public static String PlayfairD(String s, char[][] key){
        int n = s.length();
        if(n%2!=0){
            s += "x";
        }
        char[] c = s.toCharArray();
        n = c.length;
        String res = "";
        for(int i=0;i<n;i+=2){
            char a = c[i];
            char b = c[i+1];
            int[] posa = getPos(a, key);
            int[] posb = getPos(b, key);
            if(posa[0]==posb[0] && posa[1]==posb[1]){
                c[i] = key[posa[0]][posa[1]];
                c[i+1] = key[posa[0]][posa[1]];
            }
            else if(posa[0]==posb[0]){
                c[i] = key[posa[0]][mod((posa[1]-1),5)];
                c[i+1] = key[posb[0]][mod((posb[1]-1),5)];
            }
            else if(posa[1]==posb[1]){
                c[i] = key[mod((posa[0]-1),5)][posa[1]];
                c[i+1] = key[mod((posb[0]+1),5)][posb[1]];
            }
            else{
                
                c[i] = key[posa[0]][posb[1]];
                c[i+1] = key[posb[0]][posa[1]];
            }
            res += c[i]+""+c[i+1];
        }
        //res=res.replace('$', 'i');
        return res;
    }
    public static int[] getPos(char a, char[][] key){
        if(a=='i' || a=='j'){
            int[] res = {2,3};
            return res;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(a==key[i][j]){
                    int[] res = {i,j};
                    return res;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext for encryption: ");
        String s = sc.next();
        char[][] sec_key ={{'l','g','d','b','a'},
                            {'q','m','h','e','c'},
                            {'u','r','n','$','f'},
                            {'x','v','s','o','k'},
                            {'z','y','w','t','p'}};
        String res = Playfair(s, sec_key);
        System.out.println("Encryption: "+res+"\tDecryption: "+PlayfairD(res, sec_key));
    }
    
}
