import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestOzonSamsung {

    @Test
    void checkSamsungPhones() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);

        try{
            driver.get("https://www.ozon.ru");
            Thread.sleep(2000);

            WebElement searchBox = driver.findElement(By.name("text"));
            searchBox.sendKeys("Samsung S25");
            searchBox.sendKeys(Keys.ENTER);

            Thread.sleep(1500);
            WebElement firstProduct = driver.findElement(By.cssSelector("div[data-index='1'],div[data-index='0']"));

            String title = firstProduct.findElement(By.cssSelector("span.tsBody500Medium")).getText();

            String priceText = firstProduct.findElement(By.cssSelector("span.tsHeadline500Medium, span.c310-a1")).getText();

            int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));

            assertTrue(price <= 100000, "Цена слишком высокая!");

        }
        finally {
            Thread.sleep(1000);
            driver.quit();
        }



    }
}