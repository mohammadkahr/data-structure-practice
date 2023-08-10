import java.util.Scanner;

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
        PrintPost tree = new PrintPost();
        tree.printPost(inOrder, preOrder, 0, inOrder.length-1);
    }
    public static int search(int[] in, int startIn, int endIn, int data) {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)
                return i;
        return i;
    }
    public static class PrintPost {
        static int preIndex = 0;
        void printPost(int[] in, int[] pre, int inStrt, int inEnd) {
            if (inStrt > inEnd)
                return;
            // Find index of next item in preorder traversal in
            // inorder.
            int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);

            // traverse left tree
            printPost(in, pre, inStrt, inIndex - 1);

            // traverse right tree
            printPost(in, pre, inIndex + 1, inEnd);

            // print root node at the end of traversal
            System.out.print(in[inIndex] + " ");
        }
    }
}
