import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import static java.lang.System.exit;

public class bilbilak {
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week 6 # 200 points # question 1
        Scanner input = new Scanner(System.in);
        int nemone = input.nextInt();
        input.nextLine();
        ArrayList<Node<Integer>> arr = new ArrayList<>(nemone);
        Queue<Node<Integer>> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < nemone; i++) {
            Node<Integer> node = new Node<>(0);
            node.setKey(input.nextInt());
            if (i != 0) {
                Node<Integer> temp = queue.peek();
                if (temp.getLeft() == null) {
                    node.parent = temp;
                    temp.setLeft(node);
                }
                else if (temp.right == null) {
                    node.parent = temp;
                    temp.setRight(node);
                }
                else {
                    queue.poll();
                    temp = queue.peek();
                    if (temp.left == null) {
                        node.parent = temp;
                        temp.setLeft(node);
                    }
                    else if (temp.right == null) {
                        node.parent = temp;
                        temp.setRight(node);
                    }
                }
            }
            arr.add(node);
            queue.add(node);
        }
        input.nextLine();
        int first = input.nextInt();
        int second = input.nextInt();
        int firsIndex = 0, secondIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getKey() == first)
                firsIndex = i;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getKey() == second)
                secondIndex = i;
        }
        if (first == second) System.out.println(first);
        else{
            Node<Integer> parent = arr.get(firsIndex);
            while (true){
                Node<Integer> parent2 = arr.get(secondIndex);
                for (int i = 0; i < arr.size(); i++) {
                    if (parent == parent2){
                        System.out.println(parent.getKey());
                        exit(0);
                    }
                    if (parent2.getParent() != null)
                        parent2 = parent2.getParent();
                    else
                        break;
                }
                if (parent.getParent() != null)
                    parent = parent.getParent();
                else
                    break;
            }
        }
    }
    public static class Node<E> {
        private E key;
        private Node<E> left, right , parent;

        public Node(E item) {
            key = item;
            left = right = parent = null;
        }

        public E getKey() {
            return key;
        }
        public void setKey(E key) {
            this.key = key;
        }
        public Node<E> getLeft() {
            return left;
        }
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        public Node<E> getRight() {
            return right;
        }
        public void setRight(Node<E> right) {
            this.right = right;
        }
        public Node<E> getParent() {
            return parent;
        }
        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }
    public static class ArrayQueue<E> {
        private E[] data;
        private int first = 0;
        private int siez = 0;
        private static final int CAPACITY = 1000;
        public ArrayQueue() {
            this(CAPACITY);
        }
        public ArrayQueue(int capacity) {
            data = (E[]) new Object[capacity];
        }
        public int size() {
            return siez;
        }
        public boolean isEmpty() {
            return (siez == 0);
        }
        public void enqueue(E e) {
//        if (siez == 0 ) {
//            System.out.println("Queue is full");
//        }
            int avail = (first + siez) % data.length;
            data[avail] = e;
            siez++;
        }
        public E first() {
            if (isEmpty()) {
                return null;
            }
            return data[first];
        }
        public E dequeue() {
            if (isEmpty()) {
                return null;
            }
            E answer = data[first];
            data[first] = null;
            first = (first + 1) % data.length;
            siez--;
            return answer;
        }
    }
}
