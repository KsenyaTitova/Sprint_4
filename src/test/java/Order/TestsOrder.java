package Order;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePageSamokat;
import pom.OrderPageSamokat;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestsOrder {

    private static WebDriver driver;
    private final String name;
    private final String surName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String colour;
    private final String comment;
    private final boolean result;
    private final int numberButtonOrder;


    public TestsOrder(int numberButtonOrder, String name, String surName, String address, String metroStation, String phoneNumber, String date1, String period, String colour, String comment, boolean result) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date1;
        this.period = period;
        this.colour = colour;
        this.comment = comment;
        this.result = result;
        this.numberButtonOrder = numberButtonOrder;
    }

    @Parameterized.Parameters ()
    public static Object[][] fillOutFormOrder() {
        return new Object [] [] {
                {0, "Ксения", "Титова", "улица Ленина, дом 1, квартира 2", "Лубянка", "89231111111", "27.10.2022", "сутки", "black", "Домофон работает", true},
                {1, "Иван", "Иванов", "ул. Пушкина 55, кв. 2", "Черкизовская", "7900111699166", "01.11.2022", "семеро суток", "", "", true},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void createOrder()  {
        //Объект класса главной страницы
        HomePageSamokat objHomePage = new HomePageSamokat(driver);
        //Объект класса страницы заказа
        OrderPageSamokat objOrderPage = new OrderPageSamokat(driver);
        objHomePage.openHomePage();
        objOrderPage.clickCookieButton();
        //кликаем на кнопку "Заказать"
        objHomePage.clickOrderButton(numberButtonOrder);
        //Заполняем поля ввода в форме "Для кого самокат"
        objOrderPage.inputNameField(name);
        objOrderPage.inputSurnameField(surName);
        objOrderPage.inputAddressField(address);
        objOrderPage.selectMetroStationField(metroStation);
        objOrderPage.inputPhoneNumberField(phoneNumber);
        //Кликаем на кнопку "Далее"
        objOrderPage.clickNextButton();
        //Заполняем поля ввода в форме "Про аренду"
        objOrderPage.selectDateField(date);
        objOrderPage.selectRentalPeriodList(period);
        objOrderPage.selectColourField(colour);
        objOrderPage.inputCommentField(comment);
        //Кликаем на кнопку "Заказать"
        objOrderPage.clickOrderButton();
        //Ждем появления формы с вопросом о подтверждении заказа
        objOrderPage.waitOrderConfirmation();
        //Подтверждаем оформление заказа
        objOrderPage.clickYesButton();
        //Ждем форму об успешно сформированном заказе
        objOrderPage.waitOrderRegistration();
        //Проверяем, что заказ успешно сформирован=появилось окно с текстом "Заказ оформлен"
        Assert.assertEquals("Ожидаемое значение не совпало с фактическим", result, objOrderPage.checkStatusOrderHeader());
    }

    @After
    //Закрыть браузер
    public void tearDown() {
        driver.quit();
    }
}
