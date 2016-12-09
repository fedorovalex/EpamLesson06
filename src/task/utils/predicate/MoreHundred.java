package task.utils.predicate;


public class MoreHundred<T extends Number> implements Predicate<T> {

    @Override
    public boolean checkCondition(T number) {
        return number.doubleValue() > 100;
    }
}
