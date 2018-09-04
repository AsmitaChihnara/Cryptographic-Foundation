/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railfencecipher;
import java.util.*;
/**
 *
 * @author Asmita
 */
public class RailFenceCipher {

    /**
     * @param args the command line arguments
     */
    static String railFenceCipherEncrypt(String plaintxt, int key){
        char[][] rail = new char[key][plaintxt.length()];
        for(int i=0;i<key;i++){
            for(int j=0;j<plaintxt.length();j++){
                rail[i][j]='\n';
            }
        }
        int row=-1,col=-1;
        boolean down = true;
        for(int i=0;i<plaintxt.length();i++){
            if(down){
                rail[(++row)%key][(++col)%plaintxt.length()] = plaintxt.charAt(i);
                if(row%key == key-1)
                    down=false;
            }else{
                rail[(--row)%key][(++col)%plaintxt.length()] = plaintxt.charAt(i);
                if(row%key == 0)
                    down=true;
            }
        }
        String cipher = new String();
        int k=0;
        for (int i=0; i < key; i++){
            for (int j=0; j < plaintxt.length(); j++){
                if (rail[i][j]!='\n')
                    cipher=cipher+rail[i][j];
            }
            cipher=cipher+" ";
        }
        return cipher;
    }
    
    static String railFenceCipherDecrypt(String cipher,int key){
        cipher = cipher.replaceAll("\\s+","");
        System.out.println("bhgsahj   "+cipher);
        char[][] rail = new char[key][cipher.length()];
        for(int i=0;i<key;i++){
            for(int j=0;j<cipher.length();j++){
                rail[i][j]='-';
            }
        } 
        int row=-1,col=-1;
        boolean down = true;
        for(int i=0;i<cipher.length();i++){
            if(down){
                rail[(++row)%key][(++col)%cipher.length()] = '*';
                if(row%key == key-1)
                    down=false;
            }else{
                rail[(--row)%key][(++col)%cipher.length()] = '*';
                if(row%key == 0)
                    down=true;
            }
        }
        for (int i=0; i<key; i++){
            for (int j=0; j<cipher.length(); j++){
                System.out.print(rail[i][j]+"\t");
            }
            System.out.println();
        }
        int index = 0;
        for (int i=0; i<key; i++)
            for (int j=0; j<cipher.length(); j++)
                if (rail[i][j] == '*' && index<cipher.length())
                    
                        rail[i][j] = cipher.charAt(index++);
                 
        for (int i=0; i<key; i++){
            for (int j=0; j<cipher.length(); j++){
                System.out.print(rail[i][j]+"\t");
            }
            System.out.println();
        }
        String plaintxt = new String();
        down=true;
        row=-1;
        col=-1;
        for(int i=0;i<cipher.length();i++){
            if(down){
                plaintxt = plaintxt+rail[(++row)%key][(++col)%cipher.length()];
                if(row%key == key-1)
                    down=false;
            }else{
                //System.out.println(row +"  "+col);
                plaintxt=plaintxt+rail[(--row)%key][(++col)%cipher.length()]; 
                if(row%key == 0)
                    down=true;
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
        int key = sc.nextInt();
        String ciphertxt = railFenceCipherEncrypt(plaintxt,key);
        System.out.println("Encrypted cipher text: "+ ciphertxt);
        System.out.println("Decrypted cipher text: "+ railFenceCipherDecrypt(ciphertxt,key));
    }
    
}
