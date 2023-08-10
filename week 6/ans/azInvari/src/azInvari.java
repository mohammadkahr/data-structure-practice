import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class azInvari {
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week 6 # 200 points # question 4
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

        // https://www.geeksforgeeks.org/zigzag-tree-traversal/
        Stack<Node<Integer>> currentLevel = new Stack<>();
        Stack<Node<Integer>> nextLevel = new Stack<>();
        boolean leftToRight = true;

        currentLevel.push(arr.get(0));
        while (!currentLevel.isEmpty()){
            Node<Integer> node = currentLevel.pop();
            System.out.print(node.getKey()+" ");
            if (leftToRight){
                if (node.getLeft() != null)
                    nextLevel.push(node.getLeft());
                if (node.getRight() != null)
                    nextLevel.push(node.getRight());
            }
            else {
                if (node.getRight() != null)
                    nextLevel.push(node.getRight());
                if (node.getLeft() != null)
                    nextLevel.push(node.getLeft());
            }
            if (currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node<Integer>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
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
}
