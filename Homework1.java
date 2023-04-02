1

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        int i = iScanner.nextInt();
        System.out.printf("Треугольное число: %d\n", giveMeNumber(i));
        iScanner.close();
    }

    public static int giveMeNumber(int a) {
        return (a * (a + 1)) / 2;
    }
}



2
public class lesson01 {


    public static void main(String[] args) {

        int i, j;
        boolean check;

        for (i = 2; i < 1000; i++) {
            check = true;

            for (j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    // если число нацело разделилось на какое-либо стоящее перед ним, то это непростое (false)
                    check = false;
                    // System.out.print(j);
                    // System.out.println(check);
                    break;
                }
            }

            if (check) {
                System.out.println(i + " простое");
 
            }
        }
    }
}



3
package Seminars.Seminar1;
import java.util.Scanner;

public class hw1_3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Введите первое число:");
        Scanner n1 = new Scanner(System.in);
        int num1 = n1.nextInt();
        
        System.out.println("Введите второе число:");
        Scanner n2 = new Scanner(System.in);
        int num2 = n2.nextInt();

        System.out.println("Введите операцию:");
        char operation = scanner.next().charAt(0);

        int result = 0;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            }
    System.out.println("Результат операции: " + result);
    n1.close();
    n2.close();
    }
}
