package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import utils.ExcelReader;

@Listeners(listener.ExtentReportListener.class)
public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    @DataProvider(name = "loginData") // cung cấp dữ liệu đầu vào cho các @test
    public Object[][] loginData() {
        String filePath = "src/test/resources/loginData.xlsx";
        String sheetName = "Sheet1";

        //tạo biến số dòng dữ liệu (không bao gồm dòng tiêu đề)
        int rowCount = 4;

        //tạo mảng 2 chiều để lưu dữ liệu
        Object[][] data = new Object[rowCount][3];

        for(int i = 0; i < rowCount; i++){
            //lấy dữ liệu cho username
            data[i][0] = ExcelReader.getCellData(filePath, sheetName, i + 1, 0);

            //lấy dữ liệu cho password
            data[i][1] = ExcelReader.getCellData(filePath, sheetName, i + 1, 1);

            //expectedResult
            data[i][2] = ExcelReader.getCellData(filePath, sheetName, i + 1, 2);
        }
        //trả dữ liệu ra ngoài
        return data;
    }

    @Test (dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult){
        try{
            logger.info("đang test với username: {}" , username);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);

            Thread.sleep(2000);
            Boolean isLogged = driver.getCurrentUrl().contains("Dashboard");
            logger.info("Kết quả thực tế: {}", isLogged);
//            if(Boolean.parseBoolean(expectedResult) == isLogged){
//                System.out.println("test pass");
//
//            }else {
//                System.out.println("test fail");
//            }

            //assertion
            Assert.assertEquals(isLogged,Boolean.parseBoolean(expectedResult), "sai kết quả mong muốn hoặc test fail");
//            System.out.println("test pass");
            logger.info("Test pass");
            //các mức độ log trong log4j
            //Fatal: lỗi nghiêm trọng gây ra crash hệ thống
            //error: lỗi không gây crash hệ thống nhưng cần phải fix
            //warn: cảnh báo
            //info: các thông tin thông thường (thành công, start, stop,...
            //debug: thường dùng cho dev
            //trace: dùng để theo dỗi từng chi tiết nhỏ
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
