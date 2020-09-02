package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayModifier {
    public static <T> void changeValues(T[] arr, int iFirst, int iLast) {
        try {
            T valFirst = arr[iFirst];
            arr[iFirst] = arr[iLast];
            arr[iLast] = valFirst;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(String.format("Indexes must be from 0 to %d: first %d, last %d", arr.length-1, iFirst, iLast));
        }
    }

    public static <T> void printArray(T[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].toString());
            if (i < arr.length - 1){
                System.out.print("; ");
            }
        }
        System.out.println("}");
    }

    public static <T> ArrayList<T> toArrayList(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }
}