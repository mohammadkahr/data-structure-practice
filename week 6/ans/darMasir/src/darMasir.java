import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.System.exit;

public class darMasir {
    public static void main(String[] args) {
        //mohammad._.hr
        Scanner input = new Scanner(System.in);
        int numberOfNode = input.nextInt();
        input.nextLine();
        ArrayList<Node<Integer>> arr = new ArrayList<>(numberOfNode);
        Queue<Node<Integer>> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < numberOfNode; i++) {
            Node<Integer> node = new Node<>(0);
            node.setKey(input.nextInt());
            if (i != 0) {
                Node<Integer> temp = queue.peek();
                if (temp.getLeft() == null) {
                    node.parent = temp;
                    temp.setLeft(node);
                } else if (temp.right == null) {
                    node.parent = temp;
                    temp.setRight(node);
                } else {
                    queue.poll();
                    temp = queue.peek();
                    if (temp.left == null) {
                        node.parent = temp;
                        temp.setLeft(node);
                    } else if (temp.right == null) {
                        node.parent = temp;
                        temp.setRight(node);
                    }
                }
            }
            arr.add(node);
            queue.add(node);
        }
        input.nextLine();
        int nemone = input.nextInt();
        int nemoneIndex = 0;
        boolean flag = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getKey() == nemone){
                flag = true;
                nemoneIndex=i;
            }
        }
        if (flag == false){
            System.out.println("There is no path to the given node.");
            exit(0);
        }

        Stack<Integer> stack = new Stack<>();
        Node<Integer> parent = arr.get(nemoneIndex);
        while (parent != null){
            stack.push(parent.getKey());
            parent = parent.getParent();
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty())
                System.out.print(",");
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
}
