import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public int[][] data = null;
    private int rows = 0, cols = 0;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(int[][] data) {
        this.data = data.clone();
        rows = this.data.length;
        cols = this.data[0].length;
    }

    public boolean isSquare() {
        return rows == cols;
    }

    public void display() {
        System.out.print("[");
        for (int row = 0; row < rows; ++row) {
            if (row != 0) {
                System.out.print(" ");
            }

            System.out.print("[");

            for (int col = 0; col < cols; ++col) {
                System.out.print(data[row][col]);

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

    public Matrix NotMatchingAmountMatrix(Matrix unitMatrix)
    {
        var rows = unitMatrix.data.length;
        var cols = unitMatrix.data[0].length;
        var diffValueCount = 0;

        Matrix amountMatrix = new Matrix(rows, rows);

        for (int i = 0; i < rows - 1; i++)
        {
            for (int j = i + 1; j < rows; j++)
            {
                for (int k = 0; k < cols; k++)
                {
                    if (unitMatrix.data[i][k] != unitMatrix.data[j][k])
                        diffValueCount++;
                }

                amountMatrix.data[j][i] = cols - diffValueCount;
                diffValueCount = 0;
            }
        }
        return amountMatrix;
    }

    public void DisplayMatrix() {
        for (int row = 0; row < 14; ++row) {
            for (int col = 0; col < 14; ++col) {
                System.out.print(data[row][col] + "\t");
            }
            System.out.println();
        }
    }
    //Заповнення матриці
    public void FillInTheMatrix(Matrix MyMatrix, OperationMatrix OPmatrix, List<String> UniqueList){
        for(int i = 0; i < MyMatrix.rows; i++) {
            for (int j = 0; j < MyMatrix.cols; j++) {
                MyMatrix.data[i][j] = MyMatrix.search(OPmatrix,UniqueList,i,j);
            }
        }
        MyMatrix.display();
    }

    public int search(OperationMatrix OPmatrix,List<String> UniqueList, int i, int j){
        int result = 0;
        for(int k = 0; k < OPmatrix.cols; k++){
            if(OPmatrix.data[i][k].equals(UniqueList.get(j))){
                result = 1;
                break;
            }
            else result = 0;
        }
        return result;
    }
}