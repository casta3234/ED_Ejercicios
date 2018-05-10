/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ESimples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sebastian
 */
public class List {
    
    private Node head = null;

    public boolean empty(){
        return this.head == null; 
        
    }
    
    public int getSize(){
        int i = 0;
        Node temp = this.head;
        while(temp != null){
            i++;
            temp = temp.get_next();
        }
        return i;
    }
    
    public void add_to_the_beginning(Object o){
        Node newNodo = new Node(o);
        newNodo.set_next(this.head);
        this.head = newNodo;
    }
    
    public void add_to_the_end(Object o){
        Node newNodo = new Node(o);
        if (empty()){
            this.head = newNodo;
        }
        else{
            Node temp = this.head;
            while(temp.get_next() != null){
                temp = temp.get_next();         
            }
            temp.set_next(newNodo);
        }        
    }
    
    public void add_in_the_position(Object nodeToInsert, int position){
        Node newNodo = new Node(nodeToInsert);
        Node temp = this.head;
        for(int i = 0; i < position-1; i++ ){
            temp = temp.get_next();
        }
        newNodo.set_next(temp.get_next()); 
        temp.set_next(newNodo);
    }
       
    public void delete_to_the_beginning(){
        Node temp = this.head;
        this.head = this.head.get_next();
        temp = null;
        System.gc();
    }
    
    public void delete_to_the_end(){
        Node pre = this.head;
        Node temp = this.head.get_next().get_next();
        while (temp != null){            
            pre = pre.get_next();
            temp = temp.get_next();
        }        
        pre.set_next(null);
        System.gc();
    }
    
    public void delete_the_position(int posicion){
        Node temp = this.head;
        Node eliminado;
        for(int i = 0; i < posicion-1; i++){
            temp = temp.get_next();
        }
        eliminado = temp.get_next();
        temp.set_next(temp.get_next().get_next()); 
        eliminado = null;        
        System.gc();
    }
    
    public void inverse(){
        Stack ptemp = new Stack();
        Node temp = this.head;
        
        while(temp != null){
            ptemp.push(temp.clone());
            temp = temp.get_next();
        }
        
        this.head = ptemp.peek();
    }
    
    public int getIndex(Object o){
        Node temp = this.head;
        int index = 0;        
        do {
            if (temp.get_object().equals(o)) {
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
    
    public Object get_object(int index){
        Node temp = this.head;
        if(index < getSize()){
            if (index > 0){
                for(int i = 0; i < index; i++){
                    temp = temp.get_next();
                }
                return temp.get_object();
            }
            else
                return temp.get_object();
        }
        else
            return null;
    }
    
    public void print(){
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = this.head;
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
