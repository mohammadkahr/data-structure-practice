import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class inakStop {
    public static void main(String[] args) {
        //mohammad._.hr
        Scanner input = new Scanner(System.in);
        int nemone = input.nextInt();
        input.nextLine();
        int [] preOrder = new int[nemone];
        int [] inOrder = new int[nemone];
        for (int i = 0; i < nemone; i++) {
            preOrder[i] = input.nextInt();
        }
        input.nextLine();
        for (int i = 0; i < nemone; i++) {
            inOrder[i] = input.nextInt();
        }
        //https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
        System.out.println("step 1");
        convert(preOrder,inOrder,inOrder.length);


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
    public static void convert(int[] preOrder, int[] inOrder ,int n){
        int root = find(inOrder,preOrder[0],n);
        if (root != 0)
            convert(inOrder, Arrays.copyOfRange(preOrder,1,n),root);
        if (root != n-1){
            convert(Arrays.copyOfRange(inOrder,root+1,n)
                    ,Arrays.copyOfRange(preOrder,1+root,n),n-root-1);
        }
        System.out.print(preOrder[0] + " ");
    }
    public static int find(int [] arr,int x , int n){
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }
}
