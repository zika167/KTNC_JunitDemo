package poly.edu.junitdemo.lab5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test1() {
        // Khởi tạo trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        try {
            String url = "http://www.google.com";
            String title_web = "Google";

            // Bước 1: Truy cập vào trang web
            driver.get(url);

            // Bước 2: Lấy tiêu đề thực tế của trang
            String title = driver.getTitle();

            // Bước 3: So sánh với tiêu đề mong đợi
            if (title.contentEquals(title_web)) {
                System.out.println("Test Pass");
            } else {
                System.out.println("Test Fail");
            }
        } finally {
            // Bước 4: Đóng trình duyệt để giải phóng bộ nhớ
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
