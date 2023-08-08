import org.w3c.dom.Node;

import java.security.PublicKey;
import java.util.Objects;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        // mohammad._.hr
        // 4003623039
        //question 2 # week2 # 200 points
        Scanner input = new Scanner(System.in);
        MyLinkedList linkedList = new MyLinkedList<>();
        int numbers = input.nextInt();
        int rounds = input.nextInt();
        for (int i = 0; i < numbers; i++) {
            linkedList.addLast(i+1);
        }
        String command ;int first , last;
        for (int i = 0; i < rounds; i++) {
            command = input.next();
            if (Objects.equals(command, "NAME")){
                first = input.nextInt();
                input.nextLine();
                solveName(linkedList,first);
            }
            else {
                first = input.nextInt();
                last = input.nextInt();
                revers(linkedList,first,last);
            }
        }



    }
    public static void solveName(MyLinkedList linkedList,int index){
//        MyLinkedList.Node answer = linkedList.head.getNext();
        MyLinkedList.Node first = linkedList.head;
        for (int i = 1; i < index; i++) {
            first = first.getNext();
        }
        // first be head eshare mikone va az 1 ya 0 shoro mishe
        System.out.println(first.getData());

    }
    public static void revers(MyLinkedList linkedList,int first,int last){
        MyLinkedList.Node fir = linkedList.head;
        MyLinkedList.Node las = linkedList.head;
        if (linkedList.isEmpty() || linkedList.size == 1)
            return;
        for (int i = 1; i < first; i++) {
            fir = fir.getNext();
        }
        for (int i = 1; i < last; i++) {
            las = las.getNext();
        }
        int len = last-first;
        if (len%2==1){
            len++;
        }
        MyLinkedList.Node temp = new MyLinkedList.Node<>(-1,null);
        for (int i = 0; i < len/2; i++) {
            temp.setData(fir.getData());
            fir.setData(las.getData());
            las.setData(temp.getData());
            fir = fir.getNext();
            las = las.getNext();
        }

    }
    public static MyLinkedList.Node revers2(MyLinkedList linkedList, int first, int last){
        MyLinkedList.Node head = linkedList.head;
        if (first == last){
            return head;
        }
        MyLinkedList.Node revs = null,revsPrev = null;
        MyLinkedList.Node revend = null,revendNext = null;
        int i = 1;
        MyLinkedList.Node curr = head;
        while (curr!=null && i <= last) {
            if (i < first)
                revsPrev = curr;
            if (i == first)
                revs = curr;
            if (i == last) {
                revend = curr;
                revendNext = curr.next;
            }
            curr = curr.next;
            i++;
        }
        revend.setNext(null);
        revend = reverse(revs);
        if (revsPrev!=null)
            revsPrev.next = revend;
        else
            head = revend;
        revs.next = revendNext;
        return head;
    }
    public static MyLinkedList.Node reverse(MyLinkedList.Node node){
        MyLinkedList.Node prev= null;
        MyLinkedList.Node current = node ;
        while (current != null){
            MyLinkedList.Node next = current.next;
            current.setNext(prev);
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public static class MyLinkedList<E>{
        private static class Node<E>{
            private E data;
            private Node<E> next;
            //contracture
            public Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
            //setters and getters
            public E getData() {
                return data;
            }
            public void setData(E data) {
                this.data = data;
            }
            public Node<E> getNext() {
                return next;
            }
            public void setNext(Node<E> next) {
                this.next = next;
            }
        }
        private Node<E> head = null;
        private Node<E> tail = null;
//        private Node head = null;
//        private Node tail = null;
        private int size = 0;
        //contracture
        public MyLinkedList() {
        }
        //methods
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return (size==0);
        }
        public E last(){
            if (isEmpty()){
                return null;
            }
            return tail.getData();
        }
        public E first(){
            if (isEmpty()){
                return null;
            }
            return head.getData();
        }
        public void addFirst(E e){
            head = new Node<>(e,head);
            if (size==0){
                tail=head;
            }
            size++;
        }
        public void addLast(E e){
            Node<E> newest = new Node<>(e,null);
            if (isEmpty()){
                head = newest;
            }
            else {
                tail.setNext(newest);
            }
            tail=newest;
            size++;
        }
        public E removeFirst(){
            if (isEmpty()){
                return null;
            }
            E answer = head.getData();
            head = head.getNext();
            size--;
            if (size==0){
                tail = null;
            }
            return answer;
        }

    }
}
