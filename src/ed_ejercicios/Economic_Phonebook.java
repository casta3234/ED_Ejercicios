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
 * @author Sebastian
 */
public class Economic_Phonebook {
    public static void no_printed_numbers(List l){
        int savedNumbers = 0;
        fill_list(l);        
        for (int i = 0; i < l.getSize()-1 ; i++) {
            String stringPreNumber = (String) l.get_object(i);
            String stringEvaluatedNumber = (String) l.get_object(i+1);
            char [] digitsPreNumber = stringPreNumber.toCharArray();
            char [] digitsEvaluatedNumber = stringEvaluatedNumber.toCharArray();
            for (int j = 0; j < digitsPreNumber.length; j++) {
                if (digitsPreNumber[j]==digitsEvaluatedNumber[j]) {
                    savedNumbers++;
                }
                else{
                    break;  
                }
            }
        }
        System.out.println(savedNumbers);
    }

    private static void fill_list(List l) {
        Scanner s = new Scanner(System.in);
        int number_of_data= s.nextInt();
        for (int i = 0; i < number_of_data; i++) {
            l.add_to_the_beginning(s.next());
        }
    }
    
    public static void main(String[] args) {
        while (true){    
            List l = new List();                        
            no_printed_numbers(l);
        }
    }
}
