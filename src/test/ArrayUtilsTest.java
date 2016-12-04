package test;

import org.junit.Test;
import task.utils.ArrayUtils;
import task.utils.predicate.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void TestFilterOnPredicateMoreHundred() {
        Double[] source = {13.0, 2.5, 550.8, 2.4, 401.1, 5.0, 70.6, 5.7};
        Double[] expectation = {550.8, 401.1};
        Predicate<Number> predicate = new MoreHundred<>();
        assertTrue( Arrays.equals(expectation, ArrayUtils.<Double>filter(source, predicate)) );

    }

    @Test
    public void TestFilterOnPredicateEven() {
        Integer[] source = {13, 2, 5, 2, 4, 5, 8, 5};
        Integer[] expectation = {2, 2, 4, 8};
        Predicate<Number> predicate = new Even<>();
        assertTrue( Arrays.equals(expectation, ArrayUtils.<Integer>filter(source, predicate)) );
    }

    @Test
    public void TestFilterOnPredicatePositive() {
        Number[] source = {-13, -2, 5, 2, 4, -5, -8, 5, 0};
        Number[] expectation = {5, 2, 4, 5};
        Predicate<Number> predicate = new Positive<>();
        assertTrue( Arrays.equals(expectation, ArrayUtils.<Number>filter(source, predicate)) );
    }

    @Test
    public void TestFilterOnPredicateLineLengthLimit() {
        String[] source = {"123", "1234", "12345", "1", "12", "123456"};
        String[] expectation = {"123", "1", "12"};
        int maxLength = 3;
        Predicate<String> predicate = new LineLengthLimit<>(maxLength);
        assertTrue( Arrays.equals(expectation, ArrayUtils.<String>filter(source, predicate)) );
    }

    @Test
    public void TestFindMiddleElementWithIntegerType() {
        Integer[] source = {13, 2, 6, 2, 4, 5, 8, 7};
        Integer expectation = 5;
        assertEquals(ArrayUtils.<Integer>findMiddleElement(source), expectation);
    }

    @Test
    public void TestFindMiddleElementWithDoubleType() {
        Double[] source = {13.0, 2.0, 6.0, 2.0, 4.0, 5.0, 8.0, 7.0};
        Double expectation = 5.0;
        assertEquals(ArrayUtils.<Double>findMiddleElement(source), expectation);
    }

    @Test
    public void TestFindMiddleElementWithStringType() {
        String[] source = {"1", "2", "3", "4", "5", "6", "7"};
        String expectation = "4";
        assertEquals(ArrayUtils.<String>findMiddleElement(source), expectation);
    }
}