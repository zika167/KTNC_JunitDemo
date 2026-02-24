package poly.edu.junitdemo.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    // Test trường hợp số 2 (Kỳ vọng: Pass)
    @Test
    void testIsEventNumber2() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(2);
        Assertions.assertTrue(result, "Lỗi: Số 2 phải là số chẵn");
    }

    // Test trường hợp số 4 (Kỳ vọng: Pass)
    @Test
    void testIsEventNumber4() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(4);
        Assertions.assertTrue(result, "Lỗi: Số 4 phải là số chẵn");
    }

    // Test trường hợp số 3 (Kỳ vọng: Pass - Số 3 là số lẻ)
    @Test
    void testIsEventNumber3() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(3);
        // Vì 3 là số lẻ, isEventNumber trả về false
        Assertions.assertFalse(result, "Số 3 là số lẻ nên phải trả về false");
    }
}