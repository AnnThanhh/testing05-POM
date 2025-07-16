package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddEmployee;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ScreenshotUtil;

import java.time.Duration;

public class AddEmployeeTest extends BaseTest {
//    public static void main(String[] args) {
//        //beforeMethod || afterMethod : tiền xử lý và hậu xử lý của việc test
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
//        WebDriver driver = DriverFactory.getDriver();
//        try{
//            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
//            Thread.sleep(1000);
//
//            //lớp loginpage
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.login("Admin", "admin123");
//
//            System.out.println("Đăng nhập thành công");
//            Thread.sleep(2000);
//
//            DashboardPage dashboardPage = new DashboardPage(driver);
//            dashboardPage.goToPimPage();
//            System.out.println("Chuyển hướng sang Pim thành công");
//            Thread.sleep(3000);
//
//            AddEmployee addEmployee = new AddEmployee(driver);
//            addEmployee.goToAddEmployee();
//            System.out.println("Chuyển hướng thành công");
//            Thread.sleep(3000);
//
////            String firstName = "Testing";
////            String lastName = "Automation";
//
//            String filePath = "src/test/java/resources/datatest.xlsv";
////            Sheet sheet = excelreader.loadSheet("", "");
////            string firstName = excelreader.getcelldata(sheet, ,)
//            String firstName = ExcelReader.getCellData(filePath, "sheet1", 1, 0);//dòng 2(có vị trí index 1)l; cột 1/A (vị trí index 0)
//            String lastName = ExcelReader.getCellData(filePath, "sheet1", 1,1);//dòng 2(có vị trí index 1)l; cột 2/B (vị trí index 1)
//            String empId = addEmployee.addNewEmployee(firstName,lastName);
//            System.out.println("Thêm thành công");
//            Thread.sleep(5000);
//
//            Boolean isVerify = addEmployee.verifyNewEmployee(firstName, lastName, empId);
//            if(isVerify){
//                System.out.println("Kết quả trùng khớp");
//            }else{
//                System.out.println("Kết quả k trùng khớp");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Lỗi: " + e.getMessage());
//            ScreenshotUtil.captureScreenshot(driver, "AddEmployeeTest");
//        }finally {
////            driver.quit();
//        }
//    }

    @Test
    public void AddEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //lớp loginpage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        System.out.println("Đăng nhập thành công");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToPimPage();
        System.out.println("Chuyển hướng sang Pim thành công");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add Employee']")));
        AddEmployee addEmployee = new AddEmployee(driver);
        addEmployee.goToAddEmployee();
        System.out.println("Chuyển hướng thành công");
//            String firstName = "Testing";
//            String lastName = "Automation";

        String filePath = "src/test/java/resources/datatest.xlsx";
        String firstName = ExcelReader.getCellData(filePath, "sheet1", 1, 0).trim();//dòng 2(có vị trí index 1)l; cột 1/A (vị trí index 0)
        String lastName = ExcelReader.getCellData(filePath, "sheet1", 1,1).trim();//dòng 2(có vị trí index 1)l; cột 2/B (vị trí index 1)
        String empId = addEmployee.addNewEmployee(firstName,lastName);
        System.out.println("Thêm thành công");

        Boolean isVerify = addEmployee.verifyNewEmployee(firstName, lastName, empId);
        if(isVerify){
            System.out.println("Kết quả trùng khớp");
        }else{
            System.out.println("Kết quả k trùng khớp");
        }

    }


}
