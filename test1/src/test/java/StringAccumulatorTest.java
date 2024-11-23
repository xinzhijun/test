import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Qi Wang
 * @create 2024/7/22
 */
public class StringAccumulatorTest {

    private final StringAccumulator accumulator = new StringAccumulator();

    @Test
    public void testEmptyString() {
        Assertions.assertEquals(accumulator.add(""),0);
    }

    @Test
    public void testOneNumber() {
        Assertions.assertEquals(accumulator.add("1"),1);
    }

    @Test
    public void testTwoNumbers() {
        Assertions.assertEquals(accumulator.add("1,2"),3);
    }

    @Test
    public void testUnknownAmountOfNumbers() {
        Assertions.assertEquals(accumulator.add("1,2,3,4,5"),15);
    }

    @Test
    public void testNewLinesBetweenNumbers() {
        Assertions.assertEquals(accumulator.add("1\n2,3"),6);
    }

    @Test
    public void testDifferentDelimiters() {
        Assertions.assertEquals(accumulator.add("//;\n1;2"),3);
    }


    @Test
    public void testNumbersBiggerThan1000() {
        Assertions.assertEquals(accumulator.add("2,1001"),2);
    }

    @Test
    public void testDelimitersOfAnyLength() {
        Assertions.assertEquals(accumulator.add("//***\n1***2***3"),6);
    }

    @Test
    public void testMultipleDelimiters() {
        Assertions.assertEquals(accumulator.add("//*|%\n1*2%3"),6);
    }

    @Test
    public void testMultipleDelimitersWithLengthLongerThanOneCharacter() {
        Assertions.assertEquals(accumulator.add("//***|%%%\n1***2%%%3"),6);
    }


    @Test
    public void testNegativeNumbers() {
        boolean thrown = false;
        try {
            accumulator.add("1,-2,3,-4");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        Assertions.assertTrue(thrown);


    }
}
