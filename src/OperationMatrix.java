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
        System.out.println("Заповнюємо матрицю операцій:");
        for(int i = 0; i < MyMatrix.rows; i++)
        {
            for(int j = 0; j < MyMatrix.cols; j++)
            {
                MyMatrix.data[i][j]=sc.next();
            }
        }

    }
}
