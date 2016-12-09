package task.utils;

import task.utils.predicate.Predicate;

import java.util.Collection;

public class ArrayUtils {

    public static <T> void filter(Collection<? extends T> source, Collection<T> result, Predicate<? super T> predicate) {
        if (source == null || result == null) {
            throw new IllegalArgumentException("Коллекции нет.");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Предиката нет.");
        }
        result.clear();
        for (T arrayValue: source) {
            if (predicate.checkCondition(arrayValue)) {
                result.add(arrayValue);
            }
        }
    }

    public static <T extends Comparable<? super T>> T findMiddleElement(Collection<? extends T> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("Коллекции нет или она пуста.");
        }

        T middle = null;

        for (T firstValue: collection) {
            int amountElementsLess = 0;
            int amountElementsOver = 0;
            for (T secondValue: collection) {
                if (firstValue.compareTo(secondValue) < 0) {
                    amountElementsOver++;
                }
                if (firstValue.compareTo(secondValue) > 0) {
                    amountElementsLess++;
                }
            }
            if (isMiddle(amountElementsLess, amountElementsOver, collection.size()))
            {
                middle = firstValue;
                break;
            }
        }
        return middle;
    }

    private static boolean isMiddle(int amountElementsLess, int amountElementsOver, int amountElementsAll) {

        int even = 0;
        if (amountElementsAll % 2 == 0) {
            even = 1;
        }

        if ((amountElementsOver == amountElementsAll / 2) || (amountElementsLess + even == amountElementsAll / 2)) {
            return true;
        }
        if ((amountElementsOver < amountElementsAll / 2) && (amountElementsLess + even < amountElementsAll / 2)) {
            return true;
        }
        return false;
    }
}
