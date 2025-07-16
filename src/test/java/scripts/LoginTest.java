package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelReader;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData") // cung cấp dữ liệu đầu vào cho các @test
    public Object[][] loginData() {
        String filePath = "src/test/java/resources/loginData.xlsx";
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
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);

            Thread.sleep(2000);
            Boolean isLogged = driver.getCurrentUrl().contains("dashboard");
            System.out.println(isLogged);
            if(Boolean.parseBoolean(expectedResult) == isLogged){
                System.out.println("test pass");
            }else {
                System.out.println("test fail");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
