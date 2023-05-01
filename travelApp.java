package HackerRankPraktikum.DLL_Perjalanan.TugasHR;

public class travelApp {
    public static void main(String[] args) {

    }
    class DoublyLinkedList{
        Object data;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        DoublyLinkedList(){

        }
        DoublyLinkedList(Object data){
        data = this.data;
        }
        DoublyLinkedList(Object data, DoublyLinkedList next, DoublyLinkedList prev){
            data = this.data;
            next = this.next;
            prev = this.prev;
        }
    }
    class Node{
        private String data;
        private Node next;
        private Node prev;

        private Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

