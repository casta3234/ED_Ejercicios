/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package How_To_Train_Your_Dragon;

/**
 *
 * @author Sebastian
 */
public class Dragon {

    private int days_of_traning;
    private int cost_per_day;
    private Dragon next = null;

    public Dragon() {
        
    }

    public Dragon(int days_of_traning, int cost_per_day) {
        this.days_of_traning = days_of_traning;
        this.cost_per_day = cost_per_day;
    }    
    
    @Override
    public Dragon clone (){
        Dragon temp = new Dragon(this.days_of_traning,this.cost_per_day);
        return temp;
    }

    public int getDays_of_traning() {
        return days_of_traning;
    }

    public void setDays_of_traning(int days_of_traning) {
        this.days_of_traning = days_of_traning;
    }

    public int getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(int cost_per_day) {
        this.cost_per_day = cost_per_day;
    }
    
    
    
    public Dragon get_next() {
        return next;
    }


    
    public void set_next(Dragon siguiente) {
        this.next = siguiente;
    }

    @Override
    public String toString() {
        return "Days of traning: " + this.days_of_traning + ", " + "Cost per day: " + this.cost_per_day +"\n";
    }

    
    
}
