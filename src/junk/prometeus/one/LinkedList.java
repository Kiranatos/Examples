package junk.prometeus.one;

//package com.tasks3.linkedlist;

public class LinkedList {
    
    private Node primary;
    private Node last;    
    
	public LinkedList() {
		//PUT YOUR CODE HERE
                if (primary == null) { 
                    primary = new Node();                    
                }
                last = primary;
                last.setData(null);
		//PUT YOUR CODE HERE
	}

	public void add(Integer data) {
                //PUT YOUR CODE HERE
                Node n = new Node();
                n.setData(data);
                last.setNext(n);
                last = n;                
                //PUT YOUR CODE HERE
	}

	public Integer get(int index) {
                //PUT YOUR CODE HERE
                if (index < 0) return null;
                int k = -1;
                Node first = primary;
                Node second = first.getNext();                
                while (second!=null) {
                    k++;
                    if (k==index) return second.getData();
                    
                    first = second;                    
                    second = second.getNext();
                }
                return null;
                //PUT YOUR CODE HERE
	}

	public boolean delete(int index) {
                //PUT YOUR CODE HERE
                if (index < 0) return false;
                int k = -1;
                Node first = primary;
                Node second = first.getNext();                
                while (second!=null) {
                    k++;
                    if (k==index) {                        
                        first.setNext(second.getNext());                        
                        return true;                        
                    }
                    
                    first = second;                    
                    second = second.getNext();
                }
                return false;
                //PUT YOUR CODE HERE
	}

	public int size() {
                //PUT YOUR CODE HERE
                int k = 0;
                Node first = primary;
                Node second = first.getNext();                
                while (second!=null) {
                    k++;
                    first = second;                    
                    second = second.getNext();
                }                
                return k;
                //PUT YOUR CODE HERE
	}
} 


