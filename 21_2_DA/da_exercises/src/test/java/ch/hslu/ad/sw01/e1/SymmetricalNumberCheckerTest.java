package ch.hslu.ad.sw01.e1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricalNumberCheckerTest {
    @ParameterizedTest
    @CsvSource({"1,1", "1,5", "1,0", "2,11", "2,99", "2,33", "3,131", "3, 414", "4,1331", "4,2002", "4,5775"})
    void testIsSymmetrical(int size, int number) {
        assertTrue(new SymmetricalNumberChecker().isSymmetrical(size, number));
    }

    @ParameterizedTest
    @CsvSource({"2,12", "2,29", "2,73", "3,132", "3,415", "4,1531", "4,200", "4,5675"})
    void testIsNotSymmetrical(int size, int number) {
        assertFalse(new SymmetricalNumberChecker().isSymmetrical(size, number));
    }

    @ParameterizedTest
    @CsvSource({"2,12,22", "2,29,33", "2,73,77", "3,132,141", "3,415,424", "4,1531,1551", "4,5675,5775"})
    void testNextBiggestSymmetrical(int size, int number, int result){
        assertEquals(result, new SymmetricalNumberChecker().getNextBiggestSymmetrical(size, number));
    }
}