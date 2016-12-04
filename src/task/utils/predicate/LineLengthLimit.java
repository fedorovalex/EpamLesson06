package task.utils.predicate;

public class LineLengthLimit<T extends String> implements Predicate<T> {

    private int maxLength;

    public LineLengthLimit(int border) {
        this.maxLength = border;
    }

    @Override
    public boolean checkCondition(T line) {
        return line.length() <= maxLength;
    }
}
