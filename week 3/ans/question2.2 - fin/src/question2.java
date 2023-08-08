import java.util.Objects;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        // mohammad._.hr
        //question 2 # week2 # 200 points
        Scanner input = new Scanner(System.in);
        MyLinkedList linkedList = new MyLinkedList<>();
        int numbers = input.nextInt();
        int rounds = input.nextInt();
        for (int i = 0; i < numbers; i++) {
            linkedList.addLast(i+1);
        }
        String command; int first , last ;
        for (int i = 0; i < rounds; i++) {
            command = input.next();
            if (Objects.equals(command, "NAME")){
                first = input.nextInt();
                solveName(linkedList,first);
            }
            else {
                first =input.nextInt();
                last =input.nextInt();
                reverse(linkedList,first,last);
            }
        }
    }
    public static void reverse(MyLinkedList linkedList,int first,int last){
        MyLinkedList.Node fir = linkedList.header;
        MyLinkedList.Node las = linkedList.header;

        int len = last-first+1;

        if (linkedList.isEmpty() || linkedList.size()==1){
            return;
        }

        for (int i = 0; i < first; i++) {
            fir = fir.getNext();
        }
        for (int i = 0; i < last; i++) {
            las = las.getNext();
        }
        for (int i = 0; i < len/2; i++) {
            Object temp = fir.getElement();
            fir.setElement(las.getElement());
            las.setElement(temp);
            fir = fir.getNext();
            las = las.getPrev();
        }

    }
    public static void solveName(MyLinkedList linkedList,int index){
        MyLinkedList.Node temp = linkedList.header;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        System.out.println(temp.getElement());
    }
    public static class MyLinkedList<E>{
        private class Node<E>{
            private E element;
            private Node<E> prev ;
            private Node<E> next ;
            // constructor
            public Node(E element, Node<E> prev, Node<E> next) {
                this.element = element;
                this.prev = prev;
                this.next = next;
            }
            // setters and getters
            public E getElement(){
                return  element;
            }
            public void setElement(E element) {
                this.element = element;
            }
            public Node<E> getPrev() {
                return prev;
            }
            public void setPrev(Node<E> prev) {
                this.prev = prev;
            }
            public Node<E> getNext() {
                return next;
            }
            public void setNext(Node<E> next) {
                this.next = next;
            }
        }
        private Node<E> header;
        private Node<E> trailer;
        private int size = 0;
        //constructor
        public MyLinkedList() {
            header = new Node<>(null,null,null);
            trailer = new Node<>(null,header,null);
            header.setNext(trailer);
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public E first(){
            if (isEmpty())
                return null;
            return header.getNext().getElement();
        }
        public E last(){
            if (isEmpty())
                return null;
            return trailer.getPrev().getElement();
        }
        private void addBetween(E e , Node<E> predecessor , Node<E> successor){
            Node<E> newest = new Node<>(e,predecessor,successor);
            predecessor.setNext(newest);
            successor.setPrev(newest);
            size++;
        }
        private E remove(Node<E> node){
            Node<E> predecessor = node.getPrev();
            Node<E> successor = node.getNext();
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            return node.getElement();
        }
        public void addFirst(E e){
            addBetween(e,header,header.getNext());
        }
        public void addLast(E e){
            addBetween(e,trailer.getPrev(),trailer);
        }
        public E removeFirst(){
            if (isEmpty())
                return null;
            return remove(header.getNext());
        }
        public E removeLast(){
            if (isEmpty())
                return null;
            return remove(trailer.getPrev());
        }
    }
}
