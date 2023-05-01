package HackerRankPraktikum.DLL_Perjalanan.TugasHR;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedList DLL = new DoublyLinkedList();

        //Perintah awal + kota
        while (true){
            String[] masukan1  = input.nextLine().split(" ");
            if (masukan1[0].equals("MASUK")){
                DLL.TAMBAHdata(masukan1[1]);
            } else if (masukan1[0].equals("SISIP")) {
                DLL.SISIPdata(masukan1[1],Integer.parseInt(masukan1[2]));
            } else if (masukan1[0].equals("HAPUS")) {
                DLL.HAPUSdata(Integer.parseInt(masukan1[1]));
            } else if (masukan1[0].equals("SIMPAN")) {
                System.out.println("Mode Perjalanan");
                break;
            }
        }
        //Dibawah perintah Simpan pada output
        while (true){
            String[] masukan2 = input.nextLine().split(" ");
            if (masukan2[0].equals("PERGI")) {
                if (masukan2[1].equals("NEXT")){DLL.cetakAfter();  }
                else if (masukan2[1].equals("BEFORE")) {DLL.cetakBefore();
                }
            } else if (masukan2[0].equals("SELESAI")) {
                System.exit(0);
            }
        }
    }
}
class DoublyLinkedList {
    private Node now,front, back;    int size = 0;

    //Untuk menambahkan kota tujuan setelah kota sekarang
    public void TAMBAHdata(Object data) {
        Node tmp = new Node(data);
        if (front == null) {
            front = back = tmp;
        } else {
            back.next = tmp;
            tmp.prev = back;
            back = tmp;
        }
        now = front;
        size++;

    }
    //Apabila ada perintah untuk meghapus tujuan
    public void HAPUSdata(int idx){
        Node now = front;
        if(idx < size){
            if(front.next == null) {
                front = back = null;}
            else if (idx == 0) {
                front = front.next;
                front.prev = null;
                this.now = front;}
            else {
                for (int i = 0; i < idx; i++) {
                    now = now.next;}
                if (now == back){
                    back = now.prev;
                    now.prev.next = null;}
                else {
                    now.prev.next = now.next;
                    now.next.prev = now.prev;}}
            size--;
        }
    }
    //Behavior untuk menyisipkan kota sesuai dengan index yang di inputkan
    public void SISIPdata(Object data, int idxKe) {
        Node tmp = new Node(data);
        if (idxKe <= size){
            if (front == null) {
                front = back = tmp;
            }else if(idxKe == 0){
                tmp.next = front;
                front.prev = tmp;
                front = tmp;
                now = front;
            } else if (idxKe == size) {
                TAMBAHdata(data);
                return;
            } else {
                Node curr = front;
                for (int i = 0; i < idxKe - 1; i++) {
                    curr = curr.next;
                }
                tmp.next = curr.next;
                tmp.prev = curr;
                curr.next.prev = tmp;
                curr.next = tmp;
            }
            size++;
        }
    }
    //Method yang digunakan apabila ada perintah before
    public void cetakBefore(){
        if(now.prev != null){now = now.prev;
            System.out.println("Sedang berada di " + now.data);
        }else {
            System.out.println("Tujuan tidak valid");
        }
    }
    //Method mencetak setelah - kota yang dituju
    public void cetakAfter(){
        if (now.next != null) {
            now = now.next;
            System.out.println("Sedang berada di " + now.data);
        } else {
            System.out.println("Tujuan tidak valid");
        }
    }
}


class Node{
    Object data;Node next, prev;
    Node (){}
    Node(Object data){
        this.data = data;
    }
}




