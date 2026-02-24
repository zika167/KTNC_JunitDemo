package poly.edu.junitdemo.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberUtilsTest {

    @ParameterizedTest(name = "Kiểm tra số {0} - Kỳ vọng: {1}")
    @CsvSource({
            "1, true",    // Số nguyên dương nhỏ nhất
            "100, true",  // Số nguyên dương lớn
            "0, false",   // Số 0 (không phải nguyên dương)
            "-1, false",  // Số âm
            "-100, false" // Số âm lớn
    })
    void testIsPositiveNumber(int inputNumber, boolean expectedResult) {
        NumberUtils utils = new NumberUtils();
        boolean actualResult = utils.isPositiveNumber(inputNumber);

        Assertions.assertEquals(expectedResult, actualResult,
                "Lỗi tại giá trị: " + inputNumber);
    }
}