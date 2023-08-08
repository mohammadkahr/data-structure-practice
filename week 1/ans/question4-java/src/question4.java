import java.util.Scanner;

public class question4 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //week1 question4 100 point
        //mohammad._.hr
        int numberOfTests = input.nextInt(); //n
        float [] totalMoney = new float[numberOfTests];
        for (int k = 0; k < numberOfTests; k++) {
            int sizeOfCharacters = input.nextInt();//k
            String [][] character = new String[sizeOfCharacters][2];
            for (int i = 0; i < sizeOfCharacters; i++) {
                character[i][0] = input.next();
                character[i][1] = input.next();
//                character[i][0] = input.next().charAt(0);
//                character[i][1] =input.next().charAt(0);
            }
            int lines = input.nextInt() ;
            input.nextLine() ;
            String [] text = new String[lines];
            for (int i = 0; i < lines; i++) {
                text[i] = input.nextLine();
            }
            float total=0;
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < text[i].length(); j++) {
                    for (int l = 0; l < sizeOfCharacters; l++) {
                        if (text[i].charAt(j) == character[l][0].charAt(0)){
                            total += Integer.parseInt(character[l][1]);
                        }
                    }
                }
            }
            totalMoney[k] = total/100;
        }
        for (int i = 0; i < numberOfTests; i++) {
            System.out.printf("%.2f" ,totalMoney[i] );
            System.out.println("$");
//            System.out.println(totalMoney[i]+"$");
//            printf("%. 2f", val)
        }
    }
}
