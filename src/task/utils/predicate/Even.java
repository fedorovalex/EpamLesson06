package task.utils.predicate;

public class Even<T extends Number> implements Predicate<T> {

    @Override
    public boolean checkCondition(T number) {
        return number.intValue() % 2 == 0;
    }
}
