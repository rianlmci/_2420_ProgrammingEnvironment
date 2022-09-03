package ceIntroToLinkedStructures;

import java.util.NoSuchElementException;

public class NumberStack {
    private Node top;
    private int n;
    private class Node{
        private int data;
        private Node next; // links to the next node

        //Review: this is a constructor
        Node(int data){
            this.data= data;
        }
    }
    /**
     * @return if the stack is empty
     */
    public boolean isEmpty(){
        return n == 0;
    }
    /**
     * @param number new number to be pushed to the top of the stack
     */
    public void push(int number){
        Node newNode = new Node (number);
        newNode.next = top;
        top = newNode;
        n++;
    }
    /**
     * @return new number on top of the stack
     */
    public int pop(){
        //Teacher tips: throw exception as early as possible.
        //Don't use if-else. throw is the if, and code is the else.

        if (isEmpty()){
            throw new NoSuchElementException("Can't remove and element from an empty stack.");
        }
        Node topNode = top;
        top = top.next;
        n--;
        return topNode.data;
    }

    /**
     * @return what's on the top of the stack
     */
    public int peak(){
        if (isEmpty()){
            throw new NoSuchElementException("Can't read top element from an empty stack.");
        }
        return top.data;
    }

    /**
     * @return size of the stack
     */
    public int size(){
        return n;
    }

    //= = = TEST CLIENT = = =//
    public static void main(String[] args){
        NumberStack s = new NumberStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("peek:" + s.peak()); //30
        s.push(40);
        System.out.println("size:" + s.size()); //4
        System.out.println("is empty:" + s.isEmpty()); // false
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("size:" + s.size());
        System.out.println("is empty:" + s.isEmpty()); //true
    }

}
