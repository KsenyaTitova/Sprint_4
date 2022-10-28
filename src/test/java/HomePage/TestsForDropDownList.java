package HomePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePageSamokat;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestsForDropDownList {
    private static WebDriver driver;
    private final int numberButtonDropDown;
    private final String expectedText;

    public TestsForDropDownList(int numberButtonDropDown, String expectedText) {
        this.numberButtonDropDown = numberButtonDropDown;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters (name = "{index} - {0}st arrow")
    public static Object[][] getTextForDropDownList() {
        return new Object [] [] {
                {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkInTextDropDownList () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке, получить текст под стрелочкой
        String actualText = objHomePage.clickArrowInTheDropDownListButton(numberButtonDropDown);
        //Проверить соответствие текста
        assertEquals ("Полученный текст не совпал с ожидаемым", expectedText, actualText);
    }

    @After
    // Закрыть браузер
    public void tearDown() {
        driver.quit();
    }
}
