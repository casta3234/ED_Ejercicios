/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Little_Monk_and_Goblet_of_Fire;

/**
 *
 * @author Sebastian
 */
public class Student {

    private int school ;
    private int roll_number;
    private Student next = null;

    public Student() {
        
    }

    public Student(int school, int roll_number) {
        this.school = school;
        this.roll_number = roll_number;
    }

    
    
    @Override
    public Student clone (){
        Student temp = new Student(this.school, this.roll_number);
        return temp;
    }
    
    public Student get_next() {
        return next;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    
    
    public void set_next(Student siguiente) {
        this.next = siguiente;
    }

    @Override
    public String toString() {
        return this.school+ " "  + this.roll_number + "\n";
    }
    
}
