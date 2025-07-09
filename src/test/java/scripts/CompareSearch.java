package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CompareSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(10000);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123");

            Thread.sleep(5000);
            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.goToAdminPage();

            Thread.sleep(5000);
            AdminPage adminPage = new AdminPage(driver);
            adminPage.searchUsername("admin");
            Thread.sleep(5000);

            Boolean isUserFound = adminPage.isUserFound("admin");
            if(isUserFound){
                System.out.println("Tìm thấy user");
            }else {
                System.out.println("không tìm thấy user");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }
    }
}
