import java.util.Scanner;

public class Tamrin {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //question 1
        //4003623039
        //100 point
        int total;
        boolean onOff = true ;
        int numberOfNumbers = input.nextInt();
        int [] numbers = new int[numberOfNumbers] ;
        for (int i = 0; i < numberOfNumbers; i++) {
            numbers[i] = input.nextInt();
        }
        //
        for (int i = 0; i < numberOfNumbers; i++) {
            total = 0;
            for (int j = i; j < numberOfNumbers; j++) {
                total += numbers[j];
                if(total == 0){
                    System.out.println("TRUE");
                    onOff = false;
                    break;
                }
            }
            if (!onOff) break;
        }
        if (onOff) System.out.println("FALSE");
    }
}
