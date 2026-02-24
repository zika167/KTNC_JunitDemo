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

    // Test trường hợp số 3 (Kỳ vọng: Fail - Để quan sát thanh màu đỏ)
    @Test
    void testIsEventNumber3() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(3);
        // Vì 3 là số lẻ, isEventNumber trả về false, nên assertTrue(false) sẽ gây lỗi
        Assertions.assertTrue(result, "Số 3 không phải số chẵn nên bài test này sẽ báo Đỏ");
    }
}