package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // mohammad._.hr
        //question 3 # week2 # 300 points
        // 243 point daryafti
        Scanner input = new Scanner(System.in);
        int numberOfNumbers = input.nextInt();
        int numberOfCommands = input.nextInt();
        input.nextLine();
        MyLinkedlist linkedlist = new MyLinkedlist<>();
        for (int i = 0; i < numberOfNumbers; i++) {
            linkedlist.addLast(input.nextInt());
            input.nextLine();
        }
        int [][] commands = new int[numberOfCommands][2];
        for (int i = 0; i < numberOfCommands; i++) {
            commands[i][0] = input.nextInt();
            if (commands[i][0] == 2){
                commands[i][1] = input.nextInt();
            }
            input.nextLine();
        }
        MyLinkedlist.Node temp = linkedlist.head.nextNode;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i][0] == 1){
                //MyLinkedlist.Node w = temp.prevNode;
                checkPoints(linkedlist,temp);
                temp = temp.nextNode;
//                if(w==null){
//                 linkedlist.removeFirst();
//                }
//                else {
                linkedlist.remove(temp.prevNode);
//                }
            }//remove
            else if (commands[i][0] == 2){
                linkedlist.addBetween(commands[i][1] , temp , temp.nextNode);
            }//new node
            else if (commands[i][0] == 3){
                if (temp.nextNode != linkedlist.tail) {
                    checkPoints(linkedlist, temp);
                    temp = temp.nextNode;
                }
            }//next node
            else{
                if (temp.prevNode != linkedlist.head) {
                    checkPoints(linkedlist, temp);
                    temp = temp.prevNode;

                }
            }//prev node
        }
        checkPoints(linkedlist,temp);

        MyLinkedlist.Node answer = linkedlist.head.nextNode;
        MyLinkedlist.Node temp2 = answer.nextNode;
        for (int i = 0; i < linkedlist.size; i++) {
            if (answer.points < temp2.points){
                answer = temp2;
            }
            else if (answer.points == temp2.points){
                if ((int)answer.getData() < (int)temp2.getData()){
                    answer = temp2;
                }
            }
            temp2 = temp2.nextNode;
        }
        System.out.print(answer.getData());
    }
    public static void checkPoints(MyLinkedlist linkedlist , MyLinkedlist.Node temp){
        MyLinkedlist.Node befor = temp;
        MyLinkedlist.Node after = temp;
        int tempData = (int)temp.getData() ;
        if (temp.getPrevNode() == linkedlist.head && temp.getNextNode() == linkedlist.tail)
            return;
        while (after != linkedlist.tail){
            if ((int)after.nextNode.getData() > tempData){
                if (after.check){
                    after.nextNode.setPoints(after.nextNode.getPoints()+1);
                }
                else {
                    after.nextNode.setPoints(after.nextNode.getPoints()+2);
                }
                break;
            }
            after=after.nextNode;
        }
        while (befor != linkedlist.head){
            if ((int)befor.prevNode.getData() < tempData ){
                if (befor.check){
                    befor.prevNode.setPoints(befor.prevNode.getPoints()+1);
                }
                else {
                    befor.prevNode.setPoints(befor.prevNode.getPoints()+2);
                }
                break;
            }
            befor=befor.prevNode;
        }
        temp.check = true;
    }

    public static class MyLinkedlist<Item> {
        public class Node<Item> {
            private Item data;
            private boolean check = false;
            private int points =0 ;
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
            public boolean isCheck() {
                return check;
            }
            public void setCheck(boolean check) {
                this.check = check;
            }
            public int getPoints() {
                return points;
            }
            public void setPoints(int points) {
                this.points = points;
            }
        }

        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size = 0;

        //constructor
        public MyLinkedlist() {
            head = new Node(-1, null, tail);
            tail = new Node(-1, head, null);
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
        // add by myself0
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
    }
}

