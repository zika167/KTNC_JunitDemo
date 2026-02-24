package poly.edu.junitdemo.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test Suite")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("Test phép cộng: 5 + 3 = 8")
    public void testAddPositiveNumbers() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 phải bằng 8");
    }

    @Test
    @DisplayName("Test phép cộng: -5 + 3 = -2")
    public void testAddNegativeNumbers() {
        int result = calculator.add(-5, 3);
        assertEquals(-2, result, "-5 + 3 phải bằng -2");
    }

    @Test
    @DisplayName("Test phép cộng: 0 + 0 = 0")
    public void testAddZeros() {
        int result = calculator.add(0, 0);
        assertEquals(0, result, "0 + 0 phải bằng 0");
    }

    @Test
    @DisplayName("Test phép cộng: kết quả không bằng 10")
    public void testAddNotEquals() {
        int result = calculator.add(5, 3);
        assertNotEquals(10, result, "5 + 3 không phải là 10");
    }

    // ========== TEST PHÉP TRỪ ==========
    @Test
    @DisplayName("Test phép trừ: 10 - 3 = 7")
    public void testSubtractPositiveNumbers() {
        int result = calculator.subtract(10, 3);
        assertEquals(7, result, "10 - 3 phải bằng 7");
    }

    @Test
    @DisplayName("Test phép trừ: 3 - 10 = -7")
    public void testSubtractNegativeResult() {
        int result = calculator.subtract(3, 10);
        assertEquals(-7, result, "3 - 10 phải bằng -7");
    }

    @Test
    @DisplayName("Test phép trừ: 5 - 5 = 0")
    public void testSubtractSameNumbers() {
        int result = calculator.subtract(5, 5);
        assertEquals(0, result, "5 - 5 phải bằng 0");
    }

    @Test
    @DisplayName("Test phép trừ: kết quả không bằng 5")
    public void testSubtractNotEquals() {
        int result = calculator.subtract(10, 3);
        assertNotEquals(5, result, "10 - 3 không phải là 5");
    }


    @Test
    @DisplayName("Test phép nhân: 4 * 5 = 20")
    public void testMultiplyPositiveNumbers() {
        int result = calculator.multiply(4, 5);
        assertEquals(20, result, "4 * 5 phải bằng 20");
    }

    @Test
    @DisplayName("Test phép nhân: -4 * 5 = -20")
    public void testMultiplyNegativeNumbers() {
        int result = calculator.multiply(-4, 5);
        assertEquals(-20, result, "-4 * 5 phải bằng -20");
    }

    @Test
    @DisplayName("Test phép nhân: 5 * 0 = 0")
    public void testMultiplyByZero() {
        int result = calculator.multiply(5, 0);
        assertEquals(0, result, "5 * 0 phải bằng 0");
    }

    @Test
    @DisplayName("Test phép nhân: kết quả không bằng 15")
    public void testMultiplyNotEquals() {
        int result = calculator.multiply(4, 5);
        assertNotEquals(15, result, "4 * 5 không phải là 15");
    }


    @Test
    @DisplayName("Test phép chia: 20 / 4 = 5.0")
    public void testDividePositiveNumbers() {
        double result = calculator.divide(20, 4);
        assertEquals(5.0, result, "20 / 4 phải bằng 5.0");
    }

    @Test
    @DisplayName("Test phép chia: 10 / 3 ≈ 3.333...")
    public void testDivideWithDecimal() {
        double result = calculator.divide(10, 3);
        assertEquals(3.333, result, 0.001, "10 / 3 phải xấp xỉ 3.333");
    }

    @Test
    @DisplayName("Test phép chia: -20 / 4 = -5.0")
    public void testDivideNegativeNumbers() {
        double result = calculator.divide(-20, 4);
        assertEquals(-5.0, result, "-20 / 4 phải bằng -5.0");
    }

    @Test
    @DisplayName("Test phép chia: kết quả không bằng 3.0")
    public void testDivideNotEquals() {
        double result = calculator.divide(20, 4);
        assertNotEquals(3.0, result, "20 / 4 không phải là 3.0");
    }

    @Test
    @DisplayName("Test phép chia cho 0: phải ném ngoại lệ")
    public void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Chia cho 0 phải ném IllegalArgumentException");
    }


    @Test
    @DisplayName("Test assertTrue: 5 + 3 > 7")
    public void testAssertTrue() {
        int result = calculator.add(5, 3);
        assertTrue(result > 7, "5 + 3 phải lớn hơn 7");
    }

    @Test
    @DisplayName("Test assertFalse: 5 + 3 < 5")
    public void testAssertFalse() {
        int result = calculator.add(5, 3);
        assertFalse(result < 5, "5 + 3 không được nhỏ hơn 5");
    }

    @Test
    @DisplayName("Test assertNull: giá trị null")
    public void testAssertNull() {
        Object value = null;
        assertNull(value, "Giá trị phải là null");
    }

    @Test
    @DisplayName("Test assertNotNull: giá trị không null")
    public void testAssertNotNull() {
        Calculator calc = new Calculator();
        assertNotNull(calc, "Calculator không được null");
    }
}
