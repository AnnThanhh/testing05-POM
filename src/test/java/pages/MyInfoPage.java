package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {
    private WebDriver driver;

    public MyInfoPage (WebDriver driver){
        this.driver = driver;
    }

    public String fullNameForm(){
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        return firstName.getAttribute("value").trim() + " " + lastName.getAttribute("value").trim();
    }

    public String getDisplayFullName(){
        return driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText().trim();
    }


    public void setFirstName(String firstName){
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
//        firstNameInput.clear(); trường hợp lý tưởng
        //trường hợp không lý tưởng
        firstNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a")); //COMMAND
        firstNameInput.sendKeys(Keys.chord(Keys.DELETE));
        firstNameInput.sendKeys(firstName);
    }
}
