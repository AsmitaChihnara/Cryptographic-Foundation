/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rail_keyed;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author STUDENT1
 */
public class Rail_keyed {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Plain text: ");
        String s = br.readLine();
        System.out.print("Enter the key for tranposition key: ");
        String Key = br.readLine();
        try{
            StringTokenizer st = new StringTokenizer(Key);
            int[] key = new int[s.length()];
            for(int i=0;i<s.length();i++){
                key[i] = Integer.parseInt(st.nextToken());
            }
        
            String mid = trans_rail_Encrypt(s, key);
            System.out.println("Mid text: "+mid);


            String plain = trans_rail_Decrypt(mid, key);
            System.out.println("Plain text: "+plain);
        }
        catch(Exception e){
            System.out.println("Something wrong with keys");
        }
    }
    public static String trans_rail_Encrypt(String s, int[] key){
        String a = transEncrypt(s, key);
        String b = railfenceEncrypt(a);
        return b;
    }
    public static String trans_rail_Decrypt(String s, int[] key){
        String a = railfenceDecrypt(s);
        String b = transDecrypt(a, key);
        return b;
    }
    public static String railfenceEncrypt(String s){
        char[] c = s.toCharArray();
        ArrayList<Character> al1 = new ArrayList<>();
        ArrayList<Character> al2 = new ArrayList<>();
        int n = c.length;
        for(int i=0;i<n;i++){
            if(i%2==0)
                al1.add(c[i]);
            else
                al2.add(c[i]);
        }
        String res = "";
        for(char ch:al1){
            res += ch;
        }
        for(char ch:al2){
            res += ch;
        }
        return res;
    }
    public static String railfenceDecrypt(String s){
        int n = s.length();
        int f = (n+1)/2;
        char[] first = s.substring(0, f).toCharArray();
        char[] sec = s.substring(f).toCharArray();
        int j = 0, k = 0;
        char[] str = new char[n];
        for(int i=0;i<n;i++){
            if(i%2==0){
                str[i] = first[j++];
            }
            else
                str[i] = sec[k++];
        }
        
        return String.valueOf(str);
    }
    public static String transEncrypt(String s, int[] key){
        int n = s.length();
        char[] res = new char[n];
        char[] c = s.toCharArray();
        for(int i=0;i<n;i++){
            res[i] = c[key[i]-1];
        }
        return String.valueOf(res);
    }
    public static String transDecrypt(String s, int[] key){
        int[] d_key = getDecryptKey(key);
        return transEncrypt(s, d_key);
    }
    public static int[] getDecryptKey(int[] key){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = key.length;
        for(int i=0;i<n;i++){
            map.put(key[i], i+1);
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = map.get(i+1);
        }
        return res;
    }
    
}
