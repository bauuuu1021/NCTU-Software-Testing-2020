import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        // Maximize NCTU website
        driver.get("https://www.nctu.edu.tw/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Enter latest news website
        driver.get("https://www.nctu.edu.tw/news");

        // print out the title & content of the latest news

        driver.findElement(By.xpath("//*[@id=\"modRandomArticle208\"]/div[1]/div/h4/a")).click();
        System.out.println("Title of the latest news : " + driver.findElement(By.xpath("//*[@id=\"ar-header\"]")).getText());
        System.out.println("Content of the latest news :\n" + driver.findElement(By.xpath("//*[@id=\"k2Container\"]/div[2]")).getText());
        driver.navigate().back();

        // Enter the second latest news and print out the title & content
        driver.findElement(By.xpath("//*[@id=\"modRandomArticle208\"]/div[2]/div/h4/a")).click();
        System.out.println("Title of the 2nd latest news : " + driver.findElement(By.xpath("//*[@id=\"ar-header\"]")).getText());
        System.out.println("Content of the 2nd latest news :\n" + driver.findElement(By.xpath("//*[@id=\"k2Container\"]/div[2]")).getText());


        // Google my student ID
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        search.clear();
        search.sendKeys("0856101");
        search.sendKeys(Keys.RETURN);
        System.out.println("First result of searching my student ID : " + driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3")).getText());

        driver.quit();

    }
}
