import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationMatrix {
    public String[][] data;
    public int rows, cols;

    public OperationMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new String[rows][cols];
    }

    public OperationMatrix(String[][] data) {
        this.data = data.clone();
        rows = this.data.length;
        cols = this.data[0].length;
    }

    public void display() {
        System.out.print("[");
        for (int row = 0; row < rows; ++row) {
            if (row != 0) {
                System.out.print(" ");
            }

            System.out.print("[");

            for (int col = 0; col < cols; ++col) {
                System.out.printf(data[row][col]);

                if (col != cols - 1) {
                    System.out.print(" ");
                }
            }

            System.out.print("]");

            if (row == rows - 1) {
                System.out.print("]");
            }

            System.out.println();
        }
    }

    //Заповнення матриці
    public void FillInTheMatrix(OperationMatrix MyMatrix){
        Scanner sc = new Scanner(System.in);
        String new_data;
        System.out.println("Заповнюємо матрицю операцій:");
        for(int i = 0; i < MyMatrix.rows; i++)
        {
            for(int j = 0; j < MyMatrix.cols; j++)
            {
                new_data = sc.next();
                // додаємо можливість ввести пустий рядок
                if(new_data.equals("null")){
                    MyMatrix.data[i][j] = " ";
                }
                else{
                    MyMatrix.data[i][j] = new_data;
                }
            }
        }

    }

    public List<String>  UniqueOperations(OperationMatrix MyMatrix){
        List<String> UnOperat = new ArrayList<>();
        for(int i = 0; i < MyMatrix.rows; i++)
        {
            for(int j = 0; j < MyMatrix.cols; j++) {
                if(!MyMatrix.data[i][j].equals(" ") && !UnOperat.contains(MyMatrix.data[i][j])){
                    UnOperat.add(MyMatrix.data[i][j]);
                }
            }
        }
        return UnOperat;
    }
}
