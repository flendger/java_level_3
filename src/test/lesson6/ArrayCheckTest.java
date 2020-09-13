package test.lesson6;

import lesson6.ArrayCheck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ArrayCheckTest {

    //1 - try to throw RunTimeException
    @Test
    public void shouldThrowRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                try {
                    ArrayCheck.getArrayAfter4(new int[]{1, 2, 3, 3, 7});
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        });
    }

    @Test
    public void shouldRetrieveArrayAfter4() {
        //2 - try correct input
        Assertions.assertArrayEquals(new int[]{1, 7}, ArrayCheck.getArrayAfter4(new int[]{4, 2, 4, 1, 7}));

        //3 - try if 4 is at the end of array - return empty int array
        Assertions.assertArrayEquals(new int[]{}, ArrayCheck.getArrayAfter4(new int[]{1, 2, 4, 4}));
    }

    @Test
    public void shouldReturnFalseCheckArrayOn1or4() {
        Assertions.assertFalse(ArrayCheck.checkArrayOn1or4(new int[] {1, 1, 1, 1}));
        Assertions.assertFalse(ArrayCheck.checkArrayOn1or4(new int[] {4, 4, 4, 4}));
        Assertions.assertFalse(ArrayCheck.checkArrayOn1or4(new int[] {5, 3, 7, 0}));
    }

    @Test
    public void shouldReturnTrueCheckArrayOn1or4() {
        Assertions.assertTrue(ArrayCheck.checkArrayOn1or4(new int[] {1, 4, 4, 1}));
        Assertions.assertTrue(ArrayCheck.checkArrayOn1or4(new int[] {1, 4, 3, 6}));
    }
}