package poly.edu.junitdemo.lab8;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8, "5 + 3 should equal 8");
    }
    
    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 4);
        Assert.assertEquals(result, 6, "10 - 4 should equal 6");
    }
    
    @Test
    public void testMultiply() {
        int result = calculator.multiply(6, 7);
        Assert.assertEquals(result, 42, "6 * 7 should equal 42");
    }
    
    @Test
    public void testDivide() {
        double result = calculator.divide(10, 2);
        Assert.assertEquals(result, 5.0, "10 / 2 should equal 5.0");
    }
    
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
