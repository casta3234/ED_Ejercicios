/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Little_Monk_and_Goblet_of_Fire;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Solution {
    public static void main(String[] args) {
        Student_Queue q = new Student_Queue();
        Scanner s = new Scanner(System.in);
        int number_of_operations = s.nextInt();
        for (int i = 0; i < number_of_operations; i++) {
            String operation = s.next();
            if (operation.equals("E")) {
                q.enqueue(s.nextInt(), s.nextInt());
            }
            if (operation.equals("D")) {
                q.dequeue();
            }
        }
    }
}
