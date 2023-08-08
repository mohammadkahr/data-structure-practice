package com.company;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	    // mohammad._.hr
        // 4003623039
        //question 2 # week2 # 200 points
        Scanner input = new Scanner(System.in);
        MyLinkedlist linkedlist = new MyLinkedlist<>();
        int numbers = input.nextInt();
        int rounds = input.nextInt();
        for (int i = 0; i < numbers; i++) {
            linkedlist.addLast(i+1);
        }
        //print
//        for (int i = 0; i < linkedlist.size; i++) {
//            System.out.println(linkedlist.get(i));
//        }
        String command; int first , last ;
        for (int i = 0; i < rounds; i++) {
            command = input.next();
            if (Objects.equals(command, "NAME")){
                first = input.nextInt();
                input.nextLine();
                System.out.println(linkedlist.get(first-1));
            }
            else{
                first = input.nextInt();
                last = input.nextInt();
                input.nextLine();
                linkedlist.revers(first,last);
//                int size = last - first +1;
//                size /=2 ;
//                //last--;
//                //first--;
//                for (int j = 0; j < size; j++) {
//                    //swap(linkedlist.get(first),linkedlist.get(last));
//                    if (first < last || last-first == 1 ) {
//
//                        //linkedlist.swap(first,last);
//                        //linkedlist.swap((int) linkedlist.get(first), (int) linkedlist.get(last));
//                    }
//                    first++;
//                    last--;
//                }
            }
            //print
            for (int k = 0; i < linkedlist.size-2; k++) {
                System.out.println(linkedlist.get(k));
            }
        }
//        //print
//        for (int i = 0; i < linkedlist.size; i++) {
//            System.out.println(linkedlist.get(i));
//        }
    }

    public static class MyLinkedlist<Item> {
        public class Node<Item> {
            private Item data;
            private Node<Item> nextNode;
            private Node<Item> prevNode;

            //constructor
            public Node(Item data, Node<Item> nextNode, Node<Item> prevNode) {
                this.data = data;
                this.nextNode = prevNode;
                this.prevNode = nextNode;
            }

            //getters and setters
            public Item getData() {
                return data;
            }
            public void setData(Item data) {
                this.data = data;
            }
            public Node<Item> getNextNode() {
                return nextNode;
            }
            public void setNextNode(Node<Item> nextNode) {
                this.nextNode = nextNode;
            }
            public Node<Item> getPrevNode() {
                return prevNode;
            }
            public void setPrevNode(Node<Item> prevNode) {
                this.prevNode = prevNode;
            }
        }

        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size = 0;

        //constructor
        public MyLinkedlist() {
            head = new Node<>(null, null, null);
            tail = new Node<>(null, head, null);
            head.setNextNode(tail);
            tail.setPrevNode(head);
        }
        //setters and getters
        public Node<Item> getHead() {
            return head;
        }
        public void setHead(Node<Item> head) {
            this.head = head;
        }
        public Node<Item> getTail() {
            return tail;
        }
        public void setTail(Node<Item> tail) {
            this.tail = tail;
        }
        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }
        // methods
        public boolean isEmpty() {
            return size == 0;
        }
        public Item first() {
            if (isEmpty()) {
                return null;
            }
            return head.getNextNode().getData();
        }
        public Item last() {
            if (isEmpty()) {
                return null;
            }
            return tail.getPrevNode().getData();
        }
        private void addBetween(Item i, Node<Item> predecessor, Node<Item> successor) {
            Node<Item> newest = new Node<>(i, predecessor, successor);
            predecessor.setNextNode(newest);
            successor.setPrevNode(newest);
            size++;
        }
        private Item remove(Node<Item> node) {
            Node<Item> predecessor = node.getPrevNode();
            Node<Item> successor = node.getNextNode();
            predecessor.setNextNode(successor);
            successor.setPrevNode(predecessor);
            size--;
            return node.getData();
        }
        public void addFirst(Item item) {
            addBetween(item, head, head.getNextNode());
        }
        public void addLast(Item item) {
            addBetween(item, tail.getPrevNode(), tail);
        }
        public Item removeFirst() {
            if (isEmpty()) {
                return null;
            }
            return remove(head.getNextNode());
        }
        public Item removeLast() {
            if (isEmpty()) {
                return null;
            }
            return remove(tail.getPrevNode());
        }

        // add by myself
        public Item get(int index) {
            Node<Item> f = head.getNextNode();
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (index < size && index > 0) {
                for (int i = 0; i < index; i++) {
                    f = f.getNextNode();
                }
                return f.getData();
            }
            if (head == null && index == 0) {
                return null;
            }
            if (index == 0) {
                return head.getNextNode().getData();
            }
            if (index == size) {
                return tail.prevNode.getData();
            }
            return null;
        }
        public void revers(int first , int last){
            Node fir = head.getNextNode();
            Node las = head.getNextNode();
            if (first==last)
                return;
            if (isEmpty() || size == 1)
                return;
            for (int i = 1; i < first; i++) {
                fir = fir.getNextNode();
            }
            for (int i = 1; i < last; i++) {
                las = las.getNextNode();
            }
            int len = last-first +1;
            len /= 2;
            for (int i = 0; i < len; i++) {
                int temp =(int) fir.getData();
                fir.setData(las.getData());
                las.setData(temp);
                fir = fir.getNextNode();
                las = las.getNextNode();


            }


        }



        public void swap(int x ,int y){
            if (x==y)
                return;
            Node prevX = null, currX = head.getNextNode();
            while (currX != null && (int)currX.getData() != x) {
                prevX = currX;
                currX = currX.nextNode;
            }
            Node prevY = null, currY = head.getNextNode();
            while (currY != null && (int)currY.getData() != y) {
                prevY = currY;
                currY = currY.nextNode;
            }
            if (currX == null || currY == null)
                return;




            if (prevX != null)
                prevX.nextNode = currY;
            else
                head = currY;
            if (prevY != null)
                prevY.nextNode = currX;
            else // make x the new head
                head = currX;

            // Swap next pointers
            Node temp = currX.nextNode;
            currX.nextNode = currY.nextNode;
            currY.nextNode = temp;

//
//
        }
//        public void swap(int first , int last){
//            if (first == last){
//                return;
//            }
//            Node<Item> prevFirst = null ,currFirst = null;
//            while (currFirst != null && (int)currFirst.data != first) {
//                prevFirst = currFirst;
//                currFirst = currFirst.nextNode;
//            }
//            Node prevLast = null, currLast = head;
//            while (currLast != null && (int)currLast.data != last) {
//                prevLast = currLast;
//                currLast = currLast.nextNode;
//            }
//            if (currFirst == null || currLast == null) {
//                return;
//            }
//            if (prevFirst != null)
//                prevFirst.nextNode = currLast;
//            else
//                head = currLast;
//
//            if (prevLast != null)
//                prevLast.nextNode = currFirst;
//            else
//                head = currFirst;
//
//            Node temp = currFirst.nextNode;
//            currFirst.nextNode = currLast.nextNode;
//            currLast.nextNode = temp;
//        }
//        public void revers(MyLinkedlist linkedlist,int first ,int last){
//            while (first != last){
//                swap(linkedlist.get(first) , linkedlist.get(last));
//            }
//        }

        //private void swap(LinkedList linkedList ,int first, int last) {





//            Node<Item> temp = first;
//            first.setData(last.getData());
//            last.setData(temp.getData());
//        }
    }
}
