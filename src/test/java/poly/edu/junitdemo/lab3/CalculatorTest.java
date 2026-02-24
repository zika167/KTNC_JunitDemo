package poly.edu.junitdemo.lab3;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    private Calculator calc;

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll - Chạy một lần duy nhất trước toàn bộ bài test");
    }

    @BeforeEach
    void init() {
        calc = new Calculator();
        System.out.println("@BeforeEach - Đã khởi tạo Calculator cho bài test mới");
    }

    @Test
    @DisplayName("Kiểm tra phép cộng")
    void testAdd() {
        System.out.println("   Đang chạy: testAdd");
        Assertions.assertEquals(5, calc.add(2, 3));
    }

    @Test
    @DisplayName("Kiểm tra phép trừ")
    void testSubtract() {
        System.out.println("   Đang chạy: testSubtract");
         Assertions.assertEquals(1, calc.subtract(3, 2));
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Dọn dẹp sau khi kết thúc một bài test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - Đã hoàn thành toàn bộ. Chạy một lần duy nhất cuối cùng");
    }
}