package poly.edu.junitdemo.lab4;

// LƯU Ý: Import từ org.testng chứ không phải org.junit
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab4Example {

    @Test
    public void testTestNG() {
        System.out.println("Đang chạy bài test bằng TestNG trên IntelliJ!");
        String message = "Hello TestNG";
        Assert.assertEquals(message, "Hello TestNG");
    }

    @Test(groups = "fast")
    public void testGroup() {
        System.out.println("Đây là bài test thuộc nhóm 'fast'");
        Assert.assertTrue(true);
    }
}
