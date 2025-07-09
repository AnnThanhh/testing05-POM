package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddEmployee;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;

import javax.swing.plaf.TableHeaderUI;

public class AddEmployeeTest {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        WebDriver driver = DriverFactory.getDriver("chrome");
        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            Thread.sleep(5000);

            //lớp loginpage
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123");

            System.out.println("Đăng nhập thành công");
            Thread.sleep(5000);

            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.goToPimPage();
            System.out.println("Chuyển hướng sang Pim thành công");
            Thread.sleep(3000);

            AddEmployee addEmployee = new AddEmployee(driver);
            addEmployee.goToAddEmployee();
            System.out.println("Chuyển hướng thành công");
            Thread.sleep(3000);

            String firstName = "Testing";
            String lastName = "Automation";
            String empId = addEmployee.addNewEmployee(firstName,lastName);
            System.out.println("Thêm thành công");
            Thread.sleep(5000);

            Boolean isVerify = addEmployee.verifyNewEmployee(firstName, lastName, empId);
            if(isVerify){
                System.out.println("Kết quả trùng khớp");
            }else{
                System.out.println("Kết quả k trùng khớp");
            }


        } catch (InterruptedException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }finally {
//            driver.quit();
        }
    }
}
