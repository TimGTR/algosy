package task63;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicPTest {
    @Test
    void testSimpleCase() {
        assertEquals("ABC", DynamicP.getMaxSameString("ABC", "ABC"));
    }

    @Test
    void testNoCommonSubsequence() {
        assertEquals("", DynamicP.getMaxSameString("ABC", "DEF"));
    }

    @Test
    void testPartialMatch() {
        String result = DynamicP.getMaxSameString("ABCBDAB", "BDCABA");
        assertEquals(4, result.length());
    }

    @Test
    void testOneEmptyString() {
        assertEquals("", DynamicP.getMaxSameString("", "ABC"));
        assertEquals("", DynamicP.getMaxSameString("ABC", ""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals("A", DynamicP.getMaxSameString("A", "A"));
        assertEquals("", DynamicP.getMaxSameString("A", "B"));
    }
}