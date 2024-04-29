import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsByTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        WebElement blockTitle = driver.findElement(By.xpath("//div[contains(text(), 'Онлайн пополнение без комиссии')]"));
        assert blockTitle.isDisplayed() : "Название блока не отображается";

        WebElement paymentLogos = driver.findElement(By.xpath("//div[@class='payment-logos']"));
        assert paymentLogos.findElements(By.tagName("img")).size() > 0 : "Логотипы платежных систем не найдены";

        WebElement learnMoreLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        learnMoreLink.click();

        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.id("button button__default"));
        continueButton.click();

        driver.quit();
    }
}