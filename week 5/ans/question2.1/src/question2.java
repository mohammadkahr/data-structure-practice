import java.util.Scanner;
import java.util.Stack;
public class question2 {
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week 5 # 200 points # kamel shod
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(convert(str));
    }
    static String convert(String str){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> finalStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( c == '/'){
                while(!stack.isEmpty() && stack.peek()=='/'){
                    stack.pop();
                }
                stack.push(c);
            }
            else if (c == '.'){
                if (str.charAt(i+1) =='.' && str.charAt(i+2)=='.') {
                    for (int j = 0; j < 3; j++) {
                        stack.push('.');
                    }
                    i+=2;
                }
                else if (str.charAt(i+1) =='.'){
                    int counterEsl = 0;
                    while (counterEsl != 2 && !stack.isEmpty()){
                        char temp = stack.peek();
                        if (temp == '/')
                            counterEsl++;
                        stack.pop();
                    }
                }
            }
            else{
                stack.push(c);
            }
        }
        //reverse a stack
        while (!stack.isEmpty()){
            finalStack.push(stack.pop());
        }
        //add to string
        while (!finalStack.isEmpty()){
            result.append(finalStack.pop());
        }
        int cou = result.length()-1;
        if (result.charAt(cou) == '/'){
            result.deleteCharAt(cou);
        }
        if (result.length() == 0){
            result.append('/');
        }
        return result.toString() ;
    }
}
