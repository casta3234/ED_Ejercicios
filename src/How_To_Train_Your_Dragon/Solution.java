/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package How_To_Train_Your_Dragon;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Solution {
    
    public static void cobrar(List_of_dragons l){
        int deuda = 0;
        int r_days = 0;
        int numero_D =0;        
        while(!l.empty() || numero_D < 5){
            if(numero_D < 5){
                insert_dragon(l);
            }
            l.sort_list();    
            if (r_days == 0) {
                r_days = l.get_days_of_traning(0);
                l.delete_to_the_beginning();
            }
            for (int i = 0; i < l.getSize(); i++) {
                deuda += l.get_cost_per_day(i);
            }            
            r_days--;
            numero_D++;
        }
        System.out.println(deuda);
    }
    
    
    
    public static void insert_dragon(List_of_dragons l){
        Scanner s = new Scanner(System.in);
        l.add_to_the_end(s.nextInt(), s.nextInt());
    }
    
    public static void main(String[] args) {
        List_of_dragons one = new List_of_dragons();
        cobrar(one);
    }
}
