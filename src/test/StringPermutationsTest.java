package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringPermutationsTest {

    @Test
    @DisplayName("permuteall")
    public void getAllPermutations() {
        int ten=100/10;
        assertEquals(10, ten);
    }

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(num-> Integer.valueOf(num).intValue())
                .sum() > 5, () -> "Sum should be greater than 5");
    }

    @Test
    void swap() {
    }

    @Test
    void permute() {
    }
}