import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {
    WebDriver driver;
    JavascriptExecutor jse;
    public void invokeBrowser() {
        try{
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("http://formy-project.herokuapp.com/form");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void search(){
        driver.findElement(By.id("first-name")).sendKeys("Ahmed");
        driver.findElement(By.id("last-name")).sendKeys("Osama");
        driver.findElement(By.id("job-title")).sendKeys("Computer Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1000)");
    }

    public static void main(String[] args) {
        Test instance = new Test();
        instance.invokeBrowser();
        instance.search();
    }
}
