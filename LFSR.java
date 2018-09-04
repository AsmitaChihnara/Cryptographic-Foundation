/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfsr;
import java.util.*;
/**
 *
 * @author STUDENT1
 */
public class LFSR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int b4=0;
        int b3=0;
        int b2=0;
        int b1=0;
        int b0=1;
        
        for(int i=0;i<20;i++){
            System.out.print(b0);
            b4 = b0^b1;
            b0=b1;b1=b2;b2=b3;b3=b4;
        }
        
    }
    
}
