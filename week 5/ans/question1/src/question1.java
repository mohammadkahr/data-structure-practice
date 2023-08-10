import java.util.Scanner;
import java.util.Stack;
public class question1 {
    public static void main(String[] args) {
        //mohammad._.hr
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(infixToPostFix(str));
        // olaviat ha * / + -
    }
    static int precedence(char c){
        if (c =='+' || c == '-')
            return 1;
        else if (c =='*' || c == '/')
            return 2;
        return -1;
    }
    //S*O+(B-E/N)
    static String infixToPostFix(String expression){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length() ; i++) {
            char c = expression.charAt(i);
            //check if char is operator
            if(precedence(c)>0){
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
            else if ( c == ')' ){
                char x = stack.pop();
                while( x != '(' ){
                    result.append(x);
                    x = stack.pop();
                }
            }
            else if(c=='('){
                stack.push(c);
            }
            else{
                result.append(c);
            }
        }
        for (int i = 0; i <= stack.size() ; i++) {
            if (!stack.isEmpty())
                result.append(stack.pop());
        }
        return result.toString();
    }
}
