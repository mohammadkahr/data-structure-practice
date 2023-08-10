import java.util.Scanner;
import java.util.Stack;

public class question3 {
    public static void main(String[] args) {
        //mohammad._.hr
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(change(str));
    }
    static String change(String str){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> finalStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (stack.isEmpty())
                stack.push(temp);
            else if (temp < stack.peek()){
//                boolean add = add(str,stack.peek(),i);    // in char dar ayande toye string hast ya na
                boolean is = is(stack,temp); // in char toye stack hast ya na
                while (!stack.isEmpty() && temp < stack.peek() && !is && add(str,stack.peek(),i)){
                    stack.pop();
                }
                if (!is || stack.isEmpty())
                    stack.push(temp);
            }
            else{
                boolean is = is(stack,temp);
                if (!is)
                    stack.push(temp);
            }
        }
        while (!stack.isEmpty()){
            finalStack.push(stack.pop());
        }
        while (!finalStack.isEmpty()){
            result.append(finalStack.pop());
        }
        return result.toString();
    }
    static boolean is(Stack<Character> stack, char temp){
        Stack<Character> tempStack = new Stack<>();
        boolean isOrNot = false;
        while (!stack.isEmpty()){
            char x = stack.peek();
            if (x == temp)
                isOrNot = true;
            stack.pop();
            tempStack.push(x);
        }
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return isOrNot;
    }
    static boolean add(String str , char temp , int index){
        for (int i = index+1; i < str.length(); i++) {
            if (str.charAt(i) == temp) {
                return true;
            }
        }
        return false;
    }
}
