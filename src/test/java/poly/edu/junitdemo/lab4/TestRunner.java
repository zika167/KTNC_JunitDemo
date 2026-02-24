package poly.edu.junitdemo.lab4;

import org.testng.TestNG;
import java.util.Arrays;

public class TestRunner {
    public static void main(String[] args) {
        // Tạo instance TestNG
        TestNG testng = new TestNG();
        
        // Thêm các test class
        testng.setTestClasses(new Class[] { demoOne.class, demoTwo.class });
        
        // Chạy test
        testng.run();
        
        System.out.println("All tests completed successfully!");
    }
}