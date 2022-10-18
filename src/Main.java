import java.util.Scanner;

public class Main {
    public static int InputCheck(Scanner entered_num) {
        int decimal_num;
        do {
            while (!entered_num.hasNextInt()) {
                System.out.println("Помилка!");
                entered_num.next();
            }
            decimal_num = entered_num.nextInt();
        } while (decimal_num < 0);
        return  decimal_num;
    }

    public static void main(String[] args) {
        Scanner entered_num = new Scanner(System.in);
        String action;
        boolean is_stopped = false;
        int matrix_cols, matrix_raws;
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
                    //OPMatrix.display();
                    break;
                case "2":
                    System.out.println("Завдання на РГР");
                    Repository rep = new Repository();
                    rep.Repository();
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

}
