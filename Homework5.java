/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */
package HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Lena", List.of("8 926 333 33 33", "8 926 222 22 99"));
        phonBook.put("Ira", List.of("8 926 333 33 55", "8 926 222 22 00"));
        phonBook.put("Igor", List.of("8 926 333 33 66", "8 926 222 22 44"));
        phonBook.put("Petr", List.of("8 926 333 33 77", "8 926 222 22 11"));
        phonBook.put("Dima", List.of("8 926 333 33 88", "8 926 222 22 22"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Если хотите выйте хотите перестать вводить номера введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonBook);
                        break;
                    case "add":
                        add(phonBook);
                        break;
                    case "all":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}







/*
 * Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Иван Иванов,
Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Иван Иванов, Мария Рыкова, Анна Крутова, Марина Лугова, Анна Владимирова, Петр Лыков, Иван Мечников,
Петр Петин, Петр Лыков, Иван Ежов.
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
 * Отсортировать по убыванию популярности.
 */

package HW5;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class task2 {
    public static void main(String[] args) {
        List<String> workers = List.of( "Иван Иванов" , "Светлана Петрова" , "Кристина Белова" , "Анна Мусина" , "Анна Крутова" , "Иван Юрин" , "Петр Лыков" , 
                                       "Павел Чернов" , "Иван Иванов" , "Петр Чернышов" , "Мария Федорова" , "Марина Светлова" , "Мария Савина" , "Иван Иванов" , 
                                       "Мария Рыкова" , "Анна Крутова" , "Марина Лугова" , "Анна Владимирова" , "Петр Лыков" , "Иван Мечников" , "Петр Петин" , 
                                       "Петр Лыков", "Иван Ежов" );
        System.out.println(repeat(workers));
    }

    public static Map<String, Integer> repeat(List<String> workers) {
        Map<String, Integer> repeatNameCount = new LinkedHashMap<>();

        for (int i = 0; i < workers.size(); i++) {
            if (repeatNameCount.containsKey(workers.get(i))) {
                repeatNameCount.put(workers.get(i), repeatNameCount.get(workers.get(i)) + 1);
            } else {
                repeatNameCount.put(workers.get(i), 1);
            }
        }

        Map<String, Integer> sortedMap = repeatNameCount.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }

}







/*
* Написать метод, который переведет число из римского формата записи в арабский. Например, MMXXII = 2022
*
* Написать метод, который переведёт данное целое число в римский формат.
*
* IV - 4
* VII - 7
* - I = 1
* - V = 5
* - X = 10
* - L = 50
* - C = 100
* - D = 500
* - M = 1000
*/

import java.util.*;


public class Roma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число: 1 - перевод в арабские цифры; 2 - перевод в римские цифры :");
        Integer choise = sc.nextInt();
        if (choise == 1) {
            System.out.printf("Введите римское число: ");
            Scanner f = new Scanner(System.in);
            String word = f.nextLine();
            Integer result = numberTranslation(word);
            System.out.println(result);
            f.close();

        } else if(choise == 2) {
            System.out.printf("Введите арабское число: ");
            Integer word = sc.nextInt();
            String result = numberTranslation2(word);
            System.out.println(result);
        } else {
            System.out.println("Работа окончена");
        }

        sc.close();
    }

    private static Integer numberTranslation(String word) {
        int result = 0;
        int number = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = word.length() - 1; i >= 0; i--) {
            int current = map.get(word.charAt(i));
            if (current < number) {
                result -= current;
            } else {
                result += current;
            }
            number = current;
        }
        return result;
    }

    private static String numberTranslation2(Integer number) {
        String result = "";
        while (number != 0) {
            if (number >= 1000) {
                number -= 1000;
                result += "M";
            } else if (number<1000 && number>900) {
                number -=900;
                result += "CM";
            } else if (number >= 500) {
                number -=500;
                result += "D";
            } else if (number >= 100) {
                number -= 100;
                result += "C";
            } else if (number >= 50) {
                number -= 50;
                result += "L";
            } else if (number >= 10) {
                number -= 10;
                result += "X";
            }else if (number == 9) {
                number -= 9;
                result += "IX";
            }else if (number >= 5) {
                number -= 5;
                result += "V";
            } else if(number == 4){
                number -= 4;
                result+="IV";
            }else if(number > 0){
                number -= 1;
                result+="I";
            } else number = 0;
        }
        return result;
    }
}








/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */

package HW5;

import java.util.Arrays;

public class task3 {

    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void heapify(int[] A, int i, int size) {

        int left = LEFT(i);
        int right = RIGHT(i);

        int largest = i;

        if (left < size && A[left] > A[i]) {
            largest = left;
        }

        if (right < size && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }

    public static int pop(int[] A, int size) {

        if (size <= 0) {
            return -1;
        }

        int top = A[0];

        A[0] = A[size - 1];

        heapify(A, 0, size - 1);

        return top;
    }

    public static void heapsort(int[] A) {

        int n = A.length;

        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(A, i--, n);
        }

        while (n > 0) {
            A[n - 1] = pop(A, n);
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = { 8, 4, 7, 1, 9, 5 };

        heapsort(A);

        System.out.println(Arrays.toString(A));
    }
}


