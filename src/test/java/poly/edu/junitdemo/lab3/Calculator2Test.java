package poly.edu.junitdemo.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Calculator2Test {
    private Calculator2 calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator2();
    }
    //    Phep cong
    @Test
    public void testAdd(){
        assertEquals(5, calculator.add(2,3), "2 + 3 = 5");
    }
    //    Phep tru
    @Test
    public void testSubtract(){
        assertEquals(-1, calculator.subtract(2,3), "2 - 3 = -1");
    }
    //    phep nhan
    @Test
    public void testMultiply(){
        assertEquals(6, calculator.multiply(2,3), "2 * 3 = 6");
    }
    //    phep chia
    @Test
    public void testDivide(){
        assertEquals(2, calculator.divide(6,3), "6 / 3 = 2");
//        truong hop chia 0
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Cannot divide by Zero");
    }
}
