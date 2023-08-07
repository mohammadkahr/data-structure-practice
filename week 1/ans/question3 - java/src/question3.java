import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.System.exit;
public class question3 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //question 3  week1  100 point
        //4003623039
        //mohammad._.hr
        int row = input.nextInt();
        int column = input.nextInt();
        int [][] matrix = new int[row][column];
        int [][] matrix1 = new int[row][column];
        int [][] matrixNew = new int[row][column-1];
        int [][] matrix1New = new int[row-1][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = input.nextInt();
                matrix1[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j+1< column) {
                    matrixNew[i][j] = abs(matrix[i][j+1] - matrix[i][j]);
                }
            }
        }
         //sort new matrix row
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column-2; j++) {
                    if (matrixNew[i][j] > matrixNew[i][j+1]){
                        int tmp = matrixNew[i][j];
                        matrixNew[i][j] = matrixNew[i][j+1];
                        matrixNew[i][j+1] = tmp ;
                        isSorted = false;
                    }
                }
            }
        }
        // Comparison
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column-1; j++) {
                if (matrixNew[i][j] != j+1){
                    System.out.println("Wicked");
                    exit(0) ;
                }
            }
        }
        //start column
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (j+1 < row) {
                    matrix1New[j][i] = abs(matrix1[j+1][i] - matrix1[j][i]);
                }
            }
        }
        // sort matrix column
        isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row-2; j++) {
                    if (matrix1New[j][i] > matrix1New[j+1][i]){
                        int temp1 = matrix1New[j][i];
                        matrix1New[j][i] = matrix1New[j+1][i];
                        matrix1New[j+1][i] = temp1 ;
                        isSorted = false;
                    }
                }
            }
        }
        // Comparison
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix1New[i][j] != i+1){
                    System.out.println("Wicked");
                    exit(0) ;
                }
            }
        }
        System.out.println("Tame");
    }
}
