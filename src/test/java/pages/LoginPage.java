package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver; //Webdriver để thao tác với trình duyệt

    //constructor nhận webdriver
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Hàm thực hiện đăng nhập
    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
}
