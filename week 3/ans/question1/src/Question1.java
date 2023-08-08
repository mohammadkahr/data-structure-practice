import java.util.Scanner;

public class Question1 {
    public static Scanner input = new Scanner(System.in);
    //public static MyLinkedlist linkedlist = new MyLinkedlist<>();
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week3 # question1 # 200 points
        int numberOfNumbers = input.nextInt();
        MyLinkedlist linkedlist = new MyLinkedlist<>();
        for (int i = 0; i < numberOfNumbers; i++) {
            linkedlist.addLast(input.nextInt());
        }

        int counterDay = 0 ;
        while (linkedlist.solve(linkedlist)){
            counterDay++;
        }
        System.out.println(counterDay);

    }

    public static class MyLinkedlist<Item> {
        public class Node<Item>{
            private Item data ;
            private Node<Item> nextNode ;
            private Node<Item> prevNode ;
            //constructor
            public Node(Item data, Node<Item> nextNode , Node<Item> prevNode) {
                this.data = data;
                this.nextNode = prevNode;
                this.prevNode = nextNode ;
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
        private int size = 0 ;
        //constructor
        public MyLinkedlist() {
            head = new Node<>(null,null,null);
            tail = new Node<>(null,head,null );
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
        public boolean isEmpty(){
            return size==0;
        }
        public Item first(){
            if(isEmpty()){
                return null;
            }
            return head.getNextNode().getData();
        }
        public Item last(){
            if(isEmpty()){
                return null;
            }
            return tail.getPrevNode().getData();
        }
        private void addBetween(Item i ,Node<Item> predecessor , Node<Item> successor){
            Node<Item> newest = new Node<>(i,predecessor,successor);
            predecessor.setNextNode(newest);
            successor.setPrevNode(newest);
            size++;
        }
        private Item remove(Node<Item> node){
            Node<Item> predecessor = node.getPrevNode();
            Node<Item> successor = node.getNextNode();
            predecessor.setNextNode(successor);
            successor.setPrevNode(predecessor);
            size--;
            return node.getData();
        }
        public void addFirst(Item item){
            addBetween(item,head,head.getNextNode());
        }
        public void addLast(Item item){
             addBetween(item, tail.getPrevNode(), tail);
        }
        public Item removeFirst(){
            if(isEmpty()){
                return null ;
            }
            return remove(head.getNextNode()) ;
        }
        public Item removeLast(){
            if(isEmpty()){
                return null ;
            }
            return remove(tail.getPrevNode());
        }
        // add by myself
        public Item get(int index){
            Node<Item> f = head.getNextNode();
            if (index > size || index < 0){
                throw new IndexOutOfBoundsException();
            }
            if (index < size && index > 0){
                for (int i = 0; i < index; i++) {
                    f = f.getNextNode();
                }
                return f.getData();
            }
            if (head == null && index == 0){
                return null;
            }
            if (index==0){
                return head.getNextNode().getData();
            }
            if (index == size){
                return tail.getData();
            }
            return null;
        }
        public boolean solve(MyLinkedlist linkedlist){
            boolean isOk = false;
            Node<Item> current = tail.getPrevNode() ;
            while(current != head.getNextNode()){
                if ((int)current.getData() < (int) current.getPrevNode().getData()){
                    current = current.getPrevNode();
                    linkedlist.remove(current.getNextNode());
                    isOk = true ;
                }
                else{
                    current = current.getPrevNode();
                }
            }
            return isOk;
        }

    }
}
