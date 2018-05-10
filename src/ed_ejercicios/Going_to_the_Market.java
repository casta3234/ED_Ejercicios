/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_ejercicios;

import ED_ESimples.List;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Going_to_the_Market {
    
    private static void fill_list(List l) {
        Scanner s = new Scanner(System.in);
        int number_of_data= s.nextInt();
        for (int i = 0; i < number_of_data; i++) {
            l.add_to_the_beginning(s.next());
            l.add_to_the_beginning(s.nextDouble());
        }

    }
    
    public static void list_price (List l){
        double total_price = 0;
        Scanner s = new Scanner(System.in);
        fill_list(l);
        int number_of_objects = s.nextInt();
        for (int i = 0; i < number_of_objects; i++) {
            String item = s.next();
            int quantity = s.nextInt();
            int index = l.getIndex(item)-1;
            total_price += ((double) l.get_object(index)) * quantity;            
        }
        System.out.println("R$ "+total_price);
    }
    
    public static void main(String[] args) {  
        Scanner s = new Scanner(System.in);
        int test_cases = s.nextInt();
        for (int i = 0; i < test_cases; i++) {
            List l = new List();
            list_price(l);    
        }
    }
}
