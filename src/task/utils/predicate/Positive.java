package task.utils.predicate;

public class Positive<T extends Number> implements Predicate<T> {

    @Override
    public boolean checkCondition(T number) {
        return number.intValue() > 0;
    }
}
