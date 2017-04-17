package ru.padzhev.java.algorithm.sorting;

import java.util.Arrays;

/**
 * Created by Sergey Padzhev on 17.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {10, 9, 7, 8, 1, 3, 2, 5, 4, 6};
        System.out.println(Arrays.toString(unsortedArray));
        choiceSort(unsortedArray);
        bubbleSort(unsortedArray);
        insertionSort(unsortedArray);
    }

    private static void insertionSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);

        System.out.println("Сортировка вставками");

        //проходим по массиву
        //выбираем элемент

        //устанавливаем элемент на законное место

        long start = System.nanoTime();
        int element;
        int indexToInsert;

        for (int index = 0; index < array.length; index++) {
            element = array[index];

            indexToInsert = index;

            while (indexToInsert > 0
                    && array[indexToInsert-1] > element) {
                array[indexToInsert] = array[indexToInsert - 1];
                indexToInsert--;
                array[indexToInsert] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] unsortedArray) {
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);

        System.out.println("Сортировка пузырьком");

        //проходим по массиву
        //сравниваем два соседних элемента
        //повторить, пока не отсортируем

        long start = System.nanoTime();
        int changeCounter;

        do {
            changeCounter = 0;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    changeCounter++;
                }
            }
        } while (changeCounter > 0);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }

    private static void choiceSort(int[] unsortedArray) {
//  Помещаем 1-ый элемент массива в min, проходим по массиву,
// сравниваем каждый элемент с min. Находим минимальный элемент,
// меняем местами 1-ый и минимальный элемент. Повторяем с оставшимимся элементами.
        int[] array = Arrays.copyOf(unsortedArray, unsortedArray.length);
        System.out.println("Сортировка выбором");

        long start = System.nanoTime();
        int indexMin;
        for (int index = 0; index < array.length - 1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < array.length; indexToScan++) {
                if (array[indexMin] > array[indexToScan]) {
                    indexMin = indexToScan;
                }
            }

            int temp = array[index];
            array[index] = array[indexMin];
            array[indexMin] = temp;
        }

        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }
}