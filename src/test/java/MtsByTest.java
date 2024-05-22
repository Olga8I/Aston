import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;



@Epic("MTS Tests")
@Feature("MTS Website Tests")
@Owner("My")
@ExtendWith(AllureJunit5.class)
public class MtsByTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void openHomePage() {
        driver.get("https://www.mts.by/");
    }

    @DisplayName("Verify services on MTS.by homepage")
    @Test
    public void testServices() {
        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String pay : services) {
            WebElement serviceInput = driver.findElement(By.id(pay));
            Assert.assertNotNull("Надпись в незаполненном поле " + pay + " не найдена", serviceInput.getAttribute("placeholder"));
        }
    }

    @Test
    public void testPhoneDisplay() {
        WebElement phoneDisplay = driver.findElement(By.id("connection-phone"));
        Assert.assertEquals("Некорректное отображение номера телефона", "Номер телефона: 297777777", phoneDisplay.getText());
    }

    @Test
    public void testSumDisplay() {
        WebElement sumDisplay = driver.findElement(By.id("connection-sum"));
        Assert.assertEquals("Некорректное отображение суммы", "Сумма: 1000 руб.", sumDisplay.getText());
    }

    @Test
    public void testCardDetails() {
        WebElement cardDetails = driver.findElement(By.xpath("//div[@class='app-wrapper__content-container app-wrapper__content-container_fulls']"));
        Assert.assertNotNull("Надпись в незаполненном поле для ввода реквизитов карты не найдена", cardDetails.getAttribute("placeholder"));
    }

    @Test
    public void testPaymentLogos() {
        WebElement paymentLogos = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        List<WebElement> logos = paymentLogos.findElements(By.tagName("img"));
        Assert.assertTrue("Логотипы платежных систем не найдены", logos.size() > 1);
        for (WebElement logo : logos) {
            Assert.assertTrue("Логотип платежной системы не отображается", logo.isDisplayed());
        }
    }

    @After
    public void closeHomePage() {
        driver.close();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
