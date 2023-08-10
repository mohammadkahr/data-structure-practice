import java.lang.reflect.Array;
import java.util.Scanner;
public class question5 {
    public static void main(String[] args) {
        // mohammad._.hr
        Scanner input = new Scanner(System.in);
        ArrayStack<String> arrayStack = new ArrayStack<>();
        String temp = input.nextLine();
        String [] arr = temp.split(" ");
        for (String s : arr) {
            arrayStack.push(s);
        }
        reverse2(arrayStack, arr.length-1);
        while(!arrayStack.isEmpty()){
            System.out.print(arrayStack.pop() + " ");
        }
    }
    static void reverse(ArrayStack<String> st1){
        if (st1.size()>0){
            String temp =st1.pop();
            reverse(st1);
            st1.push(temp);
        }
    }
    static void reverse2(ArrayStack<String> stack , int n){
        ArrayStack<String> tempStack = new ArrayStack<>();
        String temp ;
        for (int i = 0; i < n; i++) {
            temp = stack.pop();
            for (int j = i; j < n; j++) {
                tempStack.push(stack.pop());
            }
            stack.push(temp);
            for (int j = i; j < n; j++) {
                stack.push(tempStack.pop());
            }
        }
    }
    public static class ArrayStack<E> {
        public static final int CAPACITY = 1000;
        private E[] data;
        private int t = -1;
        public ArrayStack(){this(CAPACITY);}
        public ArrayStack(int capacity){
            data = (E[]) new Object[capacity] ;
        }
        public int size(){
            return (t+1);
        }
        public boolean isEmpty(){
            return (t == -1);
        }
        public void push(E e) throws IllegalAccessError{
            if (size() == data.length){
                throw new IllegalAccessError("Stack is full");
            }
            data[++t] = e ;
        }
        public E top(){
            //peek
            if (isEmpty()){
                return null;
            }
            return data[t];
        }
        public E pop(){
            if (isEmpty()){
                return null;
            }
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }
    }
}
