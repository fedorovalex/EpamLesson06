package task.utils;

import task.utils.predicate.Predicate;

import java.util.Arrays;

public class ArrayUtils {

    public static <T> T[] filter(T[] array, Predicate<? super T> predicate) {
        if (array == null) {
            throw new IllegalArgumentException("Массива нет.");
        }
        if (array.length == 0) {
            return array;
        }
        T[] result = Arrays.copyOf(array, array.length);
        int resultNumber = 0;
        for (T arrayValue: array) {
            if (predicate.checkCondition(arrayValue)) {
                result[resultNumber] = arrayValue;
                resultNumber++;
            }
        }
        return Arrays.copyOf(result, resultNumber);
    }
}
