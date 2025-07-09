package scripts;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class CompareInfo {
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
            dashboardPage.goToMyInfoPage();

            Thread.sleep(5000);
            MyInfoPage myInfoPage = new MyInfoPage(driver);
            String fullNameForm = myInfoPage.fullNameForm();
            String fullNameDisplay = myInfoPage.getDisplayFullName();

            if(fullNameForm.equalsIgnoreCase(fullNameDisplay)){
                System.out.println("Kết quả trùng khớp");
            }else {
                System.out.println("Kết quả không trùng khớp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }
    }
}
