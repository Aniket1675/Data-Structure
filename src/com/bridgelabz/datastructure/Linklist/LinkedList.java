package com.bridgelabz.datastructure.Linklist;

public class LinkedList {
    public Node head;  //head of the linked list. i.e first element.
    public int size;   //number of elements in the list.


    public LinkedList() {
        head = null;
        size = 0;
    }

    //main functon to run the program.
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFront(10);
        list.addBack(12);

        list.display();

        list.addFront(8);
        list.addFront(6);
        list.addBack(20);

        list.display();

        list.delete(3);
        list.display();

        list.deleteFront();
        list.display();

        list.deleteBack();
        list.display();
    }

    //function to add elements at the front of the list.
    public void addFront(int number) {
        System.out.println("Inserting node at front : " + number);
        Node node = new Node(number);
        if (head == null) {
            head = node;
            size++;
            return;
        }

        node.next = head;
        head = node;
        size++;
    }

    //function to add elements at the back of the list.
    public void addBack(int number) {
        System.out.println("Inserting node at back  : " + number);
        Node node = new Node(number);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    //function to remove element from the front of the list.
    public void deleteFront() {
        System.out.println("delete front Operation.");
        if (head == null) {
            return;
        }

        head = head.next;
        size--;
    }

    //function to remove elements from the back of the list.
    public void deleteBack() {
        System.out.println("delete back Operation.");
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    //function to remove element at a specific position.
    public void delete(int position) {
        System.out.println("delete element at position : " + position);
        if (head == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        int x = 0;
        while (temp.next != null && x < position - 1) {
            temp = temp.next;
            x++;
        }

        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
        size--;
    }

    //function to display the list.
    public void display() {
        System.out.print("LinkedList : ");
        if (head == null) {
            System.out.println(" ");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
