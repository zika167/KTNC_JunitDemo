package poly.edu.junitdemo.lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static final String VALID_USER = "standard_user";
    private static final String VALID_PASS = "secret_sauce";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Giảm thiểu log rác
        options.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void navigate() {
        driver.get(BASE_URL);
    }

    /**
     * Hàm nhập liệu thông minh: Nhập xong sẽ tự kiểm tra xem dữ liệu đã vào chưa.
     * Nếu chưa vào (do lag, do React chưa nhận), nó sẽ thử lại.
     */
    private void safeInput(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // 1. Xóa sạch dữ liệu cũ bằng phím tắt (Chuẩn nhất cho Mac)
        element.click();
        element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        element.sendKeys(Keys.BACK_SPACE);

        // 2. Nhập dữ liệu mới
        if (text != null && !text.isEmpty()) {
            element.sendKeys(text);

            // 3. QUAN TRỌNG: Đợi cho đến khi ô input thực sự chứa đúng giá trị đó
            // Nếu sau 5 giây mà value vẫn rỗng, Selenium sẽ báo lỗi ngay tại đây thay vì chạy tiếp
            try {
                wait.until(d -> element.getAttribute("value").equals(text));
            } catch (TimeoutException e) {
                // Retry nhẹ 1 lần nếu mạng lag
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    private void performLogin(String u, String p) {
        // Gọi hàm nhập an toàn
        safeInput(By.id("user-name"), u);
        safeInput(By.id("password"), p);

        // Click nút Login
        WebElement btn = driver.findElement(By.id("login-button"));
        btn.click();
    }

    @Test(priority = 1)
    public void testLoginSuccess() {
        performLogin(VALID_USER, VALID_PASS);
        wait.until(ExpectedConditions.urlContains("inventory"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 2)
    public void testLoginFailWithWrongUsername() {
        performLogin("wrong_user", VALID_PASS);
        validateError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void testLoginFailWithWrongPassword() {
        performLogin(VALID_USER, "wrong_password");
        validateError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 4)
    public void testLoginWithEmptyUsername() {
        performLogin("", VALID_PASS);
        validateError("Epic sadface: Username is required");
    }

    @Test(priority = 5)
    public void testLoginWithEmptyPassword() {
        performLogin(VALID_USER, "");
        validateError("Epic sadface: Password is required");
    }

    @Test(priority = 6)
    public void testLoginWithLockedUser() {
        performLogin("locked_out_user", VALID_PASS);
        validateError("Epic sadface: Sorry, this user has been locked out.");
    }

    private void validateError(String expectedMsg) {
        WebElement err = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        Assert.assertEquals(err.getText(), expectedMsg);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}