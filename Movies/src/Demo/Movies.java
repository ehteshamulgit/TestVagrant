package Demo;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Movies
{
WebDriver driver;

@BeforeMethod
public void setUp()
{ 

System.setProperty("webdriver.chrome.driver","C:\\Users\\NWA\\Downloads\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
driver.get("https://www.imdb.com/");
driver.manage().window().maximize();

}

@Test
public void extractMovieDetails() throws InterruptedException
{

//IMDB

WebElement e1 = driver.findElement(By.xpath("//input[@placeholder='Search IMDb']"));
e1.sendKeys("Pushpa The Rise");
Thread.sleep(4000);
e1.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);

WebElement e2 = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li[1]/div/ul[1]/li[1]/a"));
WebElement e3 = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li[2]/div/ul[1]/li[1]/a"));

String release_Date = e2.getText();
String country = e3.getText();

System.out.println("Result from IMDB");

System.out.println(release_Date);
        System.out.println(country);


       
//WIKIPEDIA

        driver.get("https://www.wikipedia.org/");
driver.manage().window().maximize();

WebElement w4 = driver.findElement(By.xpath("//input[@id='searchInput']"));

w4.sendKeys("Pushpa The Rise");
Thread.sleep(4000);
w4.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);

WebElement e5 = driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[12]/td/div/ul/li"));
WebElement e6 = driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[14]/td"));

String release_DateWiki = e5.getText();
String countryWiki = e6.getText();

System.out.println("Result from WIKIPEDIA");

System.out.println(release_DateWiki);
System.out.println(countryWiki);


  }


}
