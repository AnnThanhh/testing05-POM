package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchUsername(String userName){
        WebElement userNameInput = driver.findElement(By.xpath("//label[text()=\"Username\"]/../following-sibling::div/input"));
        userNameInput.sendKeys(userName);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public boolean isUserFound(String userNameExpected){
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]/div"));
        for(WebElement row: rows){
            String actualUserName = row.findElement(By.xpath(".//div[@role=\"cell\"][2]")).getText();
            if(actualUserName.equalsIgnoreCase(userNameExpected)){
                return true;
            }
        }
        return false;
    }
}
