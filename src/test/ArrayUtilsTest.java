package test;

import org.junit.Test;
import task.utils.ArrayUtils;
import task.utils.predicate.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void TestFilterOnPredicateMoreHundred() {
        List<Double> source = Arrays.asList(13.0, 2.5, 550.8, 2.4, 401.1, 5.0, 70.6, 5.7);
        List<Number> expectation = Arrays.asList(550.8, 401.1);
        Predicate<Number> predicate = new MoreHundred<>();

        List<Number> result = new ArrayList<>();
        ArrayUtils.<Number>filter(source, result, predicate);

        assertTrue( result.equals(expectation) );
    }

    @Test
    public void TestFilterOnPredicateEven() {
        List<Integer> source = Arrays.asList(13, 2, 5, 2, 4, 5, 8, 5);
        List<Integer> expectation = Arrays.asList(2, 2, 4, 8);
        Predicate<Number> predicate = new Even<>();

        List<Integer> result = new ArrayList<>();
        ArrayUtils.<Integer>filter(source, result, predicate);

        assertTrue( result.equals(expectation) );
    }

    @Test
    public void TestFilterOnPredicatePositive() {
        List<Integer> source = Arrays.asList(-13, -2, 5, 2, 4, -5, -8, 5, 0);
        List<Number> expectation = Arrays.asList(5, 2, 4, 5);
        Predicate<Number> predicate = new Positive<>();

        List<Number> result = new ArrayList<>();
        ArrayUtils.<Number>filter(source, result, predicate);

        assertTrue( result.equals(expectation) );
    }

    @Test
    public void TestFilterOnPredicateLineLengthLimit() {
        List<String> source = Arrays.asList("123", "1234", "12345", "1", "12", "123456");
        List<String> expectation = Arrays.asList("123", "1", "12");
        int maxLength = 3;
        Predicate<String> predicate = new LineLengthLimit<>(maxLength);

        List<String> result = new ArrayList<>();
        ArrayUtils.<String>filter(source, result, predicate);

        assertTrue( result.equals(expectation) );
    }

    @Test
    public void TestFindMiddleElementWithIntegerType() {
        List<Integer> source = Arrays.asList(13, 2, 6, 2, 4, 5, 8, 7);
        Integer expectation = 5;
        assertEquals(ArrayUtils.<Integer>findMiddleElement(source), expectation);
    }

    @Test
    public void TestFindMiddleElementWithDoubleType() {
        List<Double> source = Arrays.asList(13.0, 2.0, 6.0, 2.0, 4.0, 5.0, 8.0, 7.0);
        Double expectation = 5.0;
        assertEquals(ArrayUtils.<Double>findMiddleElement(source), expectation);
    }

    @Test
    public void TestFindMiddleElementWithStringType() {
        List<String> source = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        String expectation = "4";
        assertEquals(ArrayUtils.<String>findMiddleElement(source), expectation);
    }
}