/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Little_Monk_and_Goblet_of_Fire;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sebastian
 */
public class Student_Queue {
    private Student head = null;
    
    public boolean empty (){
        return this.head == null;
    }
    public void enqueue (int school, int roll_number) {
        Student newNodo = new Student(school,  roll_number);
        if (empty()){
            this.head = newNodo;
        }
        else{
            Student temp = this.head;
            while(temp.getSchool()!=school && temp.get_next() != null){                
                temp = temp.get_next();                
            }
            if(temp.get_next() == null){
                temp.set_next(newNodo);    
            }
            else{
                while (temp.get_next().getSchool() == school) {                    
                    temp = temp.get_next();
                }
                Student temp2 = temp.get_next();
                temp.set_next(newNodo);
                newNodo.set_next(temp2);
            }
        }
    }
    
    public Student peek(){
        return this.head;
    }
    
    public void dequeue(){
        Student temp = this.head;       
        this.head = this.head.get_next();       
        System.gc();    
        System.out.println(temp.toString());       
    }
    
    public  void delete(){
        Student temp = this.head;
        this.head = this.head.get_next();
        temp = null;
        System.gc();
    }
    public  void print(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Student temp = this.head;
        try{
            while(temp != null){
                bw.write(temp.toString());
                temp = temp.get_next();
            }
            bw.flush();
        }
        catch(IOException ex){
        }
    }    
}
