import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MtsByTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String pay : services) {
            WebElement serviceInput = driver.findElement(By.id(pay));
            assert serviceInput.getAttribute("placeholder") != null : "Надпись в незаполненном поле " + pay + " не найдена";
        }

        WebElement phoneDisplay = driver.findElement(By.id("connection-phone"));
        assert phoneDisplay.getText().equals("Номер телефона: 297777777") : "Некорректное отображение номера телефона";

        WebElement sumDisplay = driver.findElement(By.id("connection-sum"));
        assert sumDisplay.getText().equals("Сумма: 1000 руб.") : "Некорректное отображение суммы";

        WebElement cardDetails = driver.findElement(By.xpath("//div[@class='app-wrapper__content-container app-wrapper__content-container_fulls']"));;
        assert cardDetails.getAttribute("placeholder") != null : "Надпись в незаполненном поле для ввода реквизитов карты не найдена";

        WebElement paymentLogos = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        assert paymentLogos.findElements(By.tagName("img")).size() > 0 : "Логотипы платежных систем не найдены";

        driver.quit();
    }
}


