/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplication;

/**
 *
 * @author STUDENT1
 */
public class Multiplication {

    /**
     * @param args the command line arguments
     */
    public static int[] shiftF(int[] a)
    {
        int n = a.length;
        int[] b = a;
        for(int i=0;i<n-1;i++)
        {
            b[i] = b[i+1];            
        }
        b[n-1] = 0;
        return b;
    }
    public static int[] exorF(int[] a, int[] p3)
    {
        int[] temp=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(a[i]==p3[i])
                temp[i]=0;
            else
                temp[i]=1;
        }
        return temp;
        /*int n = a.length;
        int[] b = a;
        for(int i=0;i<n;i++)
        {
            /*if(a[i] == p3[i])
                b[i] = 1;
            else 
                b[i] = 0;
            b[i] = a[i]^p3[i];
        }
        return b;*/
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int[] p1 = new int[]{0,0,1,0,0,1,1,0};
        int[] p2 = new int[]{1,0,0,1,1,1,1,0};
        int[] p3 = new int[]{0,0,0,1,1,0,1,1};
               
        int n = 8;
        
        /*
        int[] p1 = new int[]{1,0,1,0,1};
        int[] p2 = new int[]{1,0,0,0,0};
        int[] p3 = new int[]{0,0,1,0,1};               
        int n = 5;
        */
        int[][] temp = new int[n][n];
        temp[0] = p2;
        int flag = 0;
        System.out.print("\nTemp : 0\n" );
            for(int j=0;j<n;j++)
            {
                System.out.print(temp[0][j]+"\t");
            }
         int[] val = new int[]{0,0,0,0,0,0,0,0};
        for(int i=1;i<n;i++)
        {
            flag = 0;
            if(temp[i-1][0] == 1)
                flag = 1;
            temp[i] = shiftF(temp[i-1]);
            /*System.out.print("\nAfter shift : \n" );
            for(int j=0;j<n;j++)
            {
                System.out.print(temp[i][j]+"\t");
            }*/
            if(flag == 1)
                temp[i] = exorF(temp[i],p3);
            
            System.out.print("\nTemp : "+i+"\n" );
            for(int j=0;j<n;j++)
            {
                System.out.print(temp[i][j]+"\t");
            }
             if(p1[n-i-1] == 1)
                val = exorF(val,temp[i]);
        }
        //int[] val = new int[]{0,0,0,0,0,0,0,0};
        //val = exorF(exorF(temp[1],temp[2]),temp[5]);
        
        /*for(int i=n-1;i>=0;i--)
        {
            if(p1[i] == 1)
                val = exorF(val,temp[n-i-1]);
            System.out.print("\nVal for i "+i +"   " );
            for(int j=0;j<n;j++)
            {
                System.out.print(val[i]);
            }
        }*/
        System.out.print("\nP1 : " );
        for(int i=0;i<n;i++)
        {
            System.out.print(p1[i]+"\t");
        }
        System.out.print("\nP2 : " );
        for(int i=0;i<n;i++)
        {
            System.out.print(p2[i]+"\t");
        }
        System.out.print("\nP3 : " );
        for(int i=0;i<n;i++)
        {
            System.out.print(p3[i]+"\t");
        }
        System.out.print("\nRes : " );
        for(int i=0;i<n;i++)
        {
            System.out.print(val[i]+"\t");
        }
        
        
        
        
        
        
        
        
    }
    
}
