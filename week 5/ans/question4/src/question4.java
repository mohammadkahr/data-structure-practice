import java.util.Scanner;
import java.util.Stack;

public class question4 {
    public static void main(String[] args) {
        //mohammad._.hr
        //4003623039
        //week 5 # 200 points #
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int numberOfNumbers = input.nextInt();
        input.nextLine();
        for (int i = 0; i < numberOfNumbers; i++) {
            Integer temp = input.nextInt();
            stack1.push(temp);
            stack2.push(temp);
        }
        for (int i = 0; i < numberOfNumbers; i++) {
            stack3.push(stack2.pop());
        }
        for (int i = 0; i < numberOfNumbers; i++) {
            if ((i%2)==0) {
                System.out.print(stack3.pop() + " ");
            }
            else
                System.out.print(stack1.pop() + " ");
        }
    }
}