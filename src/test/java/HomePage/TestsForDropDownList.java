package HomePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePageSamokat;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TestsForDropDownList {
    private static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkInTextDropDownListFirstDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton1();
        //Ожидаемый текст
        String expected  ="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        //Проверить соответствие текста
        assertEquals ("Нажали 1 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList1());
    }
    @Test
    public void checkInTextDropDownListSecondDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton2();
        //Ожидаемый текст
        String expected="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        //Проверить соответствие текста
        assertEquals ("Нажали 2 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList2());
    }
    @Test
    public void checkInTextDropDownListThirdDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton3();
        //Ожидаемый текст
        String expected="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        //Проверить соответствие текста
        assertEquals ("Нажали 3 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList3());
    }
    @Test
    public void checkInTextDropDownListFourthDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton4();
        //Ожидаемый текст
        String expected="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        //Проверить соответствие текста
        assertEquals ("Нажали 4 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList4());
    }
    @Test
    public void checkInTextDropDownListFifthDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton5();
        //Ожидаемый текст
        String expected="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        //Проверить соответствие текста
        assertEquals ("Нажали 5 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList5());
    }
    @Test
    public void checkInTextDropDownListSixthDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton6();
        //Ожидаемый текст
        String expected="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        //Проверить соответствие текста
        assertEquals ("Нажали 6 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList6());
    }
    @Test
    public void checkInTextDropDownListSeventhDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton7();
        //Ожидаемый текст
        String expected="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        //Проверить соответствие текста
        assertEquals ("Нажали 7 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList7());
    }
    @Test
    public void checkInTextDropDownListEighthDropOutTheTextMatched () {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        objHomePage.openHomePage();
        //Кликнуть на стрелочку в списке
        objHomePage.clickArrowInTheDropDownListButton8();
        //Ожидаемый текст
        String expected="Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        //Проверить соответствие текста
        assertEquals ("Нажали 8 стрелочку. Полученный текст не совпал с ожидаемым", expected, objHomePage.TextInTheDropDownList8());
    }

    @After
    // Закрыть браузер
    public void tearDown() {
        driver.quit();
    }
}
