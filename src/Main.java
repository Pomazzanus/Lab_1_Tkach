import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entered_num = new Scanner(System.in);
        String action;
        boolean is_stopped = false;
        int matrix_cols, matrix_raws;
        List<String> UniqueOP = new ArrayList<>();
        while(!is_stopped){
            System.out.println("\n______________\n1)Створити матрицю\n2)Завдання на РГР\n3)Вихід\n");
            action = entered_num.next();
            switch (action){
                case "1":
                    System.out.println("Введіть кількість рядків:");
                    matrix_raws = InputCheck(entered_num);
                    System.out.println("Введіть кількість стовпців:");
                    matrix_cols = InputCheck(entered_num);
                    OperationMatrix OPMatrix = new OperationMatrix(matrix_raws, matrix_cols);
                    // заповнюємо матрицю
                    OPMatrix.FillInTheMatrix(OPMatrix);
                    OPMatrix.display();
                    // знаходимо всі різнотипні операції, які виконує ГВС (потом в один метод соберу)
                    System.out.println("\nВсі різнотипні операції:");
                    UniqueOP = OPMatrix.UniqueOperations(OPMatrix);
                    System.out.println(UniqueOP.toString());
                    System.out.println("Кількість різнотипних операцій: " + UniqueOP.size());
                    System.out.println("\nМатриця суміжності:");
                    Matrix AdjacencyMatrix = new Matrix(OPMatrix.rows, UniqueOP.size());
                    AdjacencyMatrix.FillInTheMatrix(AdjacencyMatrix,OPMatrix,UniqueOP);
                    System.out.println("\nМатриця не співпадаючих операцій:");
                    Matrix nonMatchingOperationsMatrix = new Matrix(OPMatrix.rows,
                            OPMatrix.rows);
                    nonMatchingOperationsMatrix = nonMatchingOperationsMatrix.NotMatchingAmountMatrix(AdjacencyMatrix);
                    nonMatchingOperationsMatrix.DisplayMatrix();
                    break;
                case "2":
                    System.out.println("Завдання на РГР:");
                    Repository OurRepository = new Repository();
                    OurRepository.Get_repository().display();
                    // знаходимо всі різнотипні операції, які виконує ГВС
                    System.out.println("\nВсі різнотипні операції:");
                    UniqueOP = OurRepository.Get_repository().UniqueOperations(OurRepository.Get_repository());
                    System.out.println(UniqueOP.toString());
                    System.out.println("Кількість різнотипних операцій: " + UniqueOP.size());
                    System.out.println("\nМатриця суміжності:");
                    Matrix AdjacencyMatrix1 = new Matrix(OurRepository.Get_repository().rows, UniqueOP.size());
                    AdjacencyMatrix1.FillInTheMatrix(AdjacencyMatrix1,OurRepository.Get_repository(),UniqueOP);
                    System.out.println("\nМатриця не співпадаючих операцій:");
                    Matrix nonMatchingOperationsMatrix1 = new Matrix(OurRepository.Get_repository().rows,
                            OurRepository.Get_repository().rows);
                    nonMatchingOperationsMatrix1 = nonMatchingOperationsMatrix1.NotMatchingAmountMatrix(AdjacencyMatrix1);
                    nonMatchingOperationsMatrix1.DisplayMatrix();
                    break;
                case "3":
                    System.out.print("Goodbye!");
                    is_stopped = true;
                    break;
                default:
                    break;

            }
        }
    }

    // ввід int значень
    public static int InputCheck(Scanner entered_num) {
        int decimal_num;
        do {
            while (!entered_num.hasNextInt()) {
                System.out.println("Помилка!");
                entered_num.next();
            }
            decimal_num = entered_num.nextInt();
        } while (decimal_num < 2);
        return  decimal_num;
    }

}
