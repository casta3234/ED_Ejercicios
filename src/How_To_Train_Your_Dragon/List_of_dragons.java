/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package How_To_Train_Your_Dragon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sebastian
 */
public class List_of_dragons {
    
    private Dragon head = null;

    public boolean empty(){
        return this.head == null; 
        
    }
    
    public int getSize(){
        int i = 0;
        Dragon temp = this.head;
        while(temp != null){
            i++;
            temp = temp.get_next();
        }
        return i;
    }
    
    public void add_to_the_beginning(int DP, int CD){
        Dragon newNodo = new Dragon(DP,CD);
        newNodo.set_next(this.head);
        this.head = newNodo;
    }
    
    public void add_to_the_end(int DP, int CD){
        Dragon newNodo = new Dragon(DP,CD);
        if (empty()){
            this.head = newNodo;
        }
        else{
            Dragon temp = this.head;
            while(temp.get_next() != null){
                temp = temp.get_next();         
            }
            temp.set_next(newNodo);
        }        
    }
    
    public void add_in_the_position(int DP, int CD, int position){
        Dragon newNodo = new Dragon(DP,CD);
        Dragon temp = this.head;
        for(int i = 0; i < position-1; i++ ){
            temp = temp.get_next();
        }
        newNodo.set_next(temp.get_next()); 
        temp.set_next(newNodo);
    }
       
    public void delete_to_the_beginning(){
        Dragon temp = this.head;
        this.head = this.head.get_next();
        temp = null;
        System.gc();
    }
    
    public void delete_to_the_end(){
        Dragon pre = this.head;
        Dragon temp = this.head.get_next().get_next();
        while (temp != null){            
            pre = pre.get_next();
            temp = temp.get_next();
        }        
        pre.set_next(null);
        System.gc();
    }
    
    public void delete_the_position(int posicion){
        Dragon temp = this.head;
        Dragon eliminado;
        for(int i = 0; i < posicion-1; i++){
            temp = temp.get_next();
        }
        eliminado = temp.get_next();
        temp.set_next(temp.get_next().get_next()); 
        eliminado = null;        
        System.gc();
    }
       
    
    public int getIndex(int CD){
        Dragon temp = this.head;
        int index = 0;        
        do {
            if (temp.getCost_per_day()== CD) {
                break;
            }            
                temp = temp.get_next();
                index++;            
        }
        while (index < getSize());
        
        if(index == this.getSize()){
            return -1;
        }
        else{
            return index;
        }
    }    
    
    public int get_cost_per_day(int index){
        Dragon temp = this.head;
        if(index < getSize()){
            if (index > 0){
                for(int i = 0; i < index; i++){
                    temp = temp.get_next();
                }
                return temp.getCost_per_day();
            }
            else
                return temp.getCost_per_day();
        }
        else
            return -1;
    }
    public int get_days_of_traning(int index){
        Dragon temp = this.head;
        if(index < getSize()){
            if (index > 0){
                for(int i = 0; i < index; i++){
                    temp = temp.get_next();
                }
                return temp.getDays_of_traning();
            }
            else
                return temp.getDays_of_traning();
        }
        else
            return -1;
    }
    
    public void sort_list(){
        List_of_dragons temp = new List_of_dragons();
        int list_size = this.getSize();
        for (int i = 0; i < list_size; i++) {
            temp.add_to_the_end(this.get_days_of_traning(this.find_less_cost()), this.get_cost_per_day(this.find_less_cost()));
            if (this.getSize()>2) {
                this.delete_the_position(this.find_less_cost());
                }
            else{
                if (this.find_less_cost() ==1) {
                    this.head = new Dragon(this.get_days_of_traning(0), get_cost_per_day(0));
                }
                else{
                    this.head = new Dragon(this.get_days_of_traning(1), get_cost_per_day(1));
                }
            }            
        }
        this.head = temp.head;
    }
    
    public int find_less_cost(){
        Dragon temp = this.head;
        int index = -1;
        int less = Integer.MAX_VALUE;
        for (int i = 0; i < this.getSize(); i++) {
            if(this.get_cost_per_day(i)<less){
                less = this.get_cost_per_day(i);
            }          
        }
        return this.getIndex(less);
    }
    
    public void print(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Dragon temp = this.head;
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
