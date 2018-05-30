package cucumberTag.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.StepDefAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



@StepDefAnnotation
public class CucumberTag {


    WebDriver driver = null;



    @Given("^User navigates to rediff$")
    public void user_navigates_to_rediff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

            driver = new ChromeDriver();
            driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
            if(driver == null)
                throw new PendingException();
    }

    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void i_enter_Username_as_and_Password_as(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login1")).sendKeys(arg1);
        driver.findElement(By.id("password")).sendKeys(arg2);
        driver.findElement(By.name("proceed")).click();
        //throw new PendingException();
    }

    @Then("^Login should happen sucessfully$")
    public void login_should_happen_sucessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rd_logout']")));
        String  title = target.getText();
        System.out.println("Title "+title);
        if(title.equals("Logout"))
            System.out.println("Test Pass");
        else{
            System.out.println("Test Failed");

        }
        driver.close();
    }
}
