1. Реализовать алгоритм сортировки слиянием

package HW3;

import java.util.Arrays;
import java.util.Random;

public class task1 {

    public static void main(String[] args) {
        int[] array1 = randomArr();
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] randomArr() {
        Random rand = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return arr;
    }

    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sort1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sort2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sort1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sort1[index1] < sort2[index2]
                    ? sort1[index1++]
                    : sort2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sort1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sort2[index2++];
        }
        return result;
    }

}



2. Пусть дан произвольный список целых чисел, удалить из него чётные числа

public class task2 {

    public static List<Integer> getRandomList() {
        Random random = new Random();
        int size = 20;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list.toString());
        return list;
    }

    public static List<Integer> deletEvenNum(List<Integer> list) {

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }

        }
        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        deletEvenNum(getRandomList());
    }
}




3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package HW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task3 {
    public static List<Integer> getRandomList(int size) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100));
        }

        System.out.println(randomList.toString());
        return randomList;
    }

    public static void getRezult(List<Integer> list) {
        int min = Collections.min(list);
        int max = Collections.max(list);
        int count = list.size();
        int sum = 0;
        
        for (Integer i : list) {
            sum += i;
        }

        double result = sum / count;

        System.out.printf("Минимальное: %d, максимальное: %d, среднее арифметичское: %f", min, max, result);

    }

    public static void main(String[] args) {
        getRezult(getRandomList(20));
    }

}
