package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployee {
    private WebDriver driver;

    public AddEmployee (WebDriver driver){
        this.driver = driver;
    }

    public void goToAddEmployee (){
        driver.findElement(By.xpath("//a[text()=\"Add Employee\"]")).click();
    }

    public String addNewEmployee(String firstName, String lastName){
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        String empID = driver.findElement(By.xpath("//label[text()=\"Employee Id\"]/../following-sibling::div/input")).getAttribute("value").trim();
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        return empID;
    }

    public Boolean verifyNewEmployee(String expectedFirstName, String expectedLastName, String expectedEmpId){
        String actualFirstName = driver.findElement(By.name("firstName")).getAttribute("value").trim();
        String actualLastName = driver.findElement(By.name("lastName")).getAttribute("value").trim();
        String actualEmpId = driver.findElement(By.xpath("//label[text()=\"Employee Id\"]/../following-sibling::div/input")).getAttribute("value").trim();

        return expectedFirstName.equals(actualFirstName) && expectedLastName.equals(actualLastName) && expectedEmpId.equals(actualEmpId);
    }
}
