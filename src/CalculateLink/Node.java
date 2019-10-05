package CalculateLink;

public class Node {
    Object data;
    Node next;

    Node(){
        this.data = null;
        this.next = null;
    }

    Node(Object data){
        this.data = data;
    }

    Node(Object data ,Node next){
        this.data = data;
        this.next = next;
    }
}
