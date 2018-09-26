package task;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.http.impl.io.SocketOutputBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Register extends ReadExcel {
	WebDriver driver;
	// @FindBy(how = How.ID, using = "reg-lastname") public WebElement LastName;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		String Url = "https://www.linkedin.com/";
		driver.get(Url);
	}

	@Test
	public void FailedRegistration() {
		try {
			dataExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("reg-firstname")).sendKeys(String.valueOf(ValidFirstName));
		// FirstName.sendKeys("test");
		driver.findElement(By.id("reg-lastname")).sendKeys(String.valueOf(ValidLastName));
		driver.findElement(By.id("reg-email")).sendKeys(String.valueOf(InvalidEmail));
		driver.findElement(By.id("reg-password")).sendKeys(String.valueOf(Password));
		driver.findElement(By.id("registration-submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='alert-content']")));
		String mailErrorMsg = driver.findElement(By.xpath("//span[@class='alert-content']")).getText();
		System.out.println("Message is " + mailErrorMsg);
		Assert.assertEquals(mailErrorMsg, "Please enter a valid email address");

	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

}