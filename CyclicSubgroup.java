/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclicsubgroup;
import java.util.ArrayList;

/**
 *
 * @author Asmita
 */


public class CyclicSubgroup {
 public static void cyclic_grp(){
        for(int i=1;i<=9;i++){
            ArrayList<Integer> al = new ArrayList<>();
            int p = 0;
            int start = -1, end = -1;
            int count = 0;
            int flag = 0;
            while(true){
                long res = (long)Math.pow(i,p);
                p++;
                int mod = (int)(res%10);
                if(al.isEmpty()){
                    al.add(mod);
                    start = 0;
                    end = 0;
                    continue;
                }
                if(al.contains(mod)){
                    int pos = al.indexOf(mod);
                    if(pos == start){
                        //fine
                        start++;
                    }
                    else{
                        flag = 1;
                        //System.out.println("Not a cyclic group");
                        break;
                    }
                }
                else{
                    al.add(mod);
                    
                    count++;
                    end = count;
                }
                if(start>end){
                    break;
                }
            }
            if(flag==0)
                System.out.println(i+": "+al);
            else
                System.out.println(i+": Does not belong to cyclic group");
            al.clear();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cyclic_grp();
    }
    
}
