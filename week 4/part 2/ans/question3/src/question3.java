import java.util.Scanner;
import java.util.Stack;
public class question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //mohammad._.hr
        //4003623039
        //week4 # question3 # 100 point
        while (input.hasNext()){
            isMatched(input.nextLine());
        }
        input.close();
    }
    public static void isMatched(String str){
        Stack<Character> stack = new Stack<>();
        final String opening = "([{<";
        final String closing = ")]}>";
        int counter = 1;
        for (char c : str.toCharArray()) {
            if (opening.indexOf(c) != -1){
                stack.push(c);
            }
            else if (closing.indexOf(c) != -1){
                if (stack.isEmpty()){
                    System.out.println("NO "+counter);
                    return;
                }
                if (closing.indexOf(c) != opening.indexOf(stack.pop())){
                    System.out.println("NO "+counter);
                    return;
                }
            }
            counter++;
        }
        if (stack.isEmpty()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO "+(str.length()+1));
        }
    }
}
