package main.lesson6;

import java.util.Arrays;

public class ArrayCheck {

    /*
    Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    иначе в методе необходимо выбросить RuntimeException. Написать набор тестов
    для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public static int[] getArrayAfter4(int[] arr) {
        int lastIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastIdx = i;
            }
        }

        if (lastIdx == -1) {
            throw new RuntimeException();
        }

        return Arrays.copyOfRange(arr, lastIdx + 1, arr.length);
    }


    /*
    Написать метод, который проверяет состав массива из чисел 1 и 4.
    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public static boolean checkArrayOn1or4(int[] arr) {
        boolean isOne = false;
        boolean isFour = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                isOne = true;
            } else if (arr[i] == 4) {
                isFour = true;
            }

            if (isOne && isFour) {
                break;
            }
        }
        return (isOne && isFour);
    }
}
