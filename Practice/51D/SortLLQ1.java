package com.app.day51;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

public class SortLLQ1 {

    public static void main(String[] args) {

        /*Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(2);
        node.next.next.next = new Node(8);*/

        Node node = new Node(1);

        Node head = node;

        node = mergeSort(node);

        traverse(node);

    }

    static Node mergeSort(Node node){

        // Base Condition
        if(node == null || node.next == null){
            return node;
        }

        Node h = node;
        // find Mid
        Node mid = findMid(node);
        //sort both LL upto mid and after mid
        Node h1 = h;
        Node h2 = mid.next;
        mid.next = null;

        h1 = mergeSort(h1);
        h2 = mergeSort(h2);

        return merge(h1,h2);

    }

    static Node findMid(Node node){

        Node slow = node;
        Node fast = node;

        while(fast.next != null && fast.next.next != null){
            slow =  slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    static Node merge(Node h1,Node h2){

        Node h = new Node(-1);
        Node curr = h;

        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                curr.next = h1;
                h1 = h1.next;
                curr = curr.next;
              //  curr.next = null;
            }else{
                curr.next = h2;
                h2 = h2.next;
                curr = curr.next;
               // curr.next = null;
            }
        }

        if(h1 != null){
            curr.next = h1;
        }

        if(h2 != null){
            curr.next = h2;
        }

        Node temp = h;
        h = h.next;
        temp.next = null;

        return h;

    }



    public static void traverse(Node node){

        while(node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();

    }
}

