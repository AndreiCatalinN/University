/*
 * Author: Andrei Negura
 * JDK: Java 10
 * Description: A program that creates 2 ordered linked lists
 * and then merges them into a ordered, result linked list.
 * */

package com.company;

public class Main {

    public static Node list1, list2, head1, head2;

    public static void main(String[] args) {
        createLists();
        // first node
        Node result = new Node();
        Node rHead = result;

        while (head1.next != null && head2.next != null) {
            if (head1.data <= head2.data) {
                // add data
                result.data = head1.data;
                //create link
                result.next = new Node();
                //move to next result node
                result = result.next;
                //move to next list node
                head1 = head1.next;
            }

            if (head1.data > head2.data) {
                // add data
                result.data = head2.data;
                //create link
                result.next = new Node();
                //move to next result node
                result = result.next;
                //move to next list node
                head2 = head2.next;
            }
        }

        while (head1.next != null) {
            // add data
            result.data = head1.data;
            //create link
            result.next = new Node();
            //move to next result node
            result = result.next;
            //move to next list node
            head1 = head1.next;
        }

        while (head2.next != null) {
            // add data
            result.data = head2.data;
            //create link
            result.next = new Node();
            //move to next result node
            result = result.next;
            //move to next list node
            head2 = head2.next;
        }

        while (rHead.next != null) {
            System.out.print(rHead.data + " -> ");
            rHead = rHead.next;
        }
    }

    public static void createLists() {

        list1 = new Node();
        head1 = list1;
        for (int i = 1; i <= 6; i++) {
            list1.data = i;
            list1.next = new Node();
            list1 = list1.next;
        }

        list2 = new Node();
        head2 = list2;
        for (int i = 1; i <= 5; i += 2) {
            list2.data = i;
            list2.next = new Node();
            list2 = list2.next;
        }

//        while(head1.next != null){
//            System.out.print(head1.data + " -> ");
//            head1 = head1.next;
//        }
//        System.out.println();
//        while(head2.next != null){
//            System.out.print(head2.data + " -> ");
//            head2 = head2.next;
//        }
    }
}
