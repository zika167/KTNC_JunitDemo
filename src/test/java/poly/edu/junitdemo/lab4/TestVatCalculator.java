package poly.edu.junitdemo.lab4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVatCalculator {

    @Test
    public void testGetVatOnAmount() {
        VatCalculator calc = new VatCalculator(); // Khởi tạo đối tượng cần test
        double expected = 10; // Kỳ vọng thuế của 100 là 10

        // Kiểm tra trường hợp đúng: 100 * 0.1 = 10
        Assert.assertEquals(calc.getVatOnAmount(100), expected, "Thuế VAT của 100 phải là 10");

        // Kiểm tra trường hợp không bằng: 120 * 0.1 = 12 (khác 10)
        Assert.assertNotEquals(calc.getVatOnAmount(120), expected, "Thuế VAT của 120 không thể là 10");
    }
}
