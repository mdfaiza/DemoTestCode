package test.java.testPage;



import java.net.URL;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebPageTest {
	private WebDriver oDriver;
	@BeforeTest
	public void setup() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Jenkins\\workspace\\Testi\\chromedriver.exe");
		new DesiredCapabilities();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		oDriver = new RemoteWebDriver(new URL("http://localhost:9091/wd/hub"), capabilities);
		
	}
	
	@Test
	public void test() {
		
String name="mahesh";
oDriver.get("http://localhost:8081/DemoWebPage/");
oDriver.findElement(By.id("myText")).sendKeys(name);
oDriver.findElement(By.xpath("/html/body/button")).click();
String output_name=oDriver.findElement(By.id("demo")).getText();

Assert.assertEquals(name, output_name);
String testColor= oDriver.findElement(By.tagName("body")).getAttribute("bgcolor");
System.out.println(testColor);
Assert.assertEquals(testColor,"blue");

	}
	
	@AfterTest
	public void closeTest() throws Exception {
		
		Thread.sleep(5000);
		oDriver.quit();
	}

}
