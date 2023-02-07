package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Objects;

public class OrderPageSamokat {

    private final WebDriver driver;

    //Поле ввода имени
    private final By nameField = By.xpath(".//div/input[contains(@placeholder,'Имя')]");
    //Поле ввода фамилии
    private final By surnameField = By.xpath(".//div/input[contains(@placeholder,'Фамилия')]");
    //Поле ввода адреса
    private final By addressField = By.xpath(".//div/input[contains(@placeholder,'Адрес')]");
    //Поле выбора станции метро
    private final By metroStationList = By.xpath(".//div/input[contains(@placeholder,'метро')]");
    //Поле ввода номера телефона
    private final By phoneNumberField = By.xpath(".//div/input[contains(@placeholder,'Телефон:')]");
    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//div/button[contains(text(),'Далее')]");
    //Локатор кнопки для подтверждения о куки
    private final By CookieButton = By.id("rcc-confirm-button");
    //Поле выбора даты, когда привезти самокат
    private final By dateCalendar = By.xpath(".//div/input[contains(@placeholder,'Когда привезти самокат')]");
    //Поле выбора срока аренды
    private final By rentalPeriodList =  By.xpath(".//div[contains(text(),'Срок аренды')]");
    //Чекбокс выбора черного цвета самоката:
    private final By colourBlackCheckbox = By.xpath(".//input[@id='black']");
    //Чекбокс выбора серого цвета самоката:
    private final By colourGreyCheckbox = By.xpath(".//input[@id='grey']");
    //Поле ввода комментария
    private final By commentField = By.xpath(".//div/input[contains(@placeholder,'Комментарий')]");
    //Кнопка "Заказать"
    private final By OrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");
    //Кнопка "Да" в форме подтверждения оформления заказа
    private final By YesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[starts-with(text(),'Да')]");
    //Текст "Заказ оформлен"
    private final By TheOrderHasBeenPlacedHeader = By.xpath("//div[(text()= 'Заказ оформлен')]");

    // конструктор класса
    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для нажатия на кнопку про куки
    public void clickCookieButton () {
        driver.findElement(CookieButton).click();
    }

    // метод для заполнения поля «Имя» из параметра
    public void inputNameField(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    // метод для заполнения поля «Фамилия» из параметра
    public void inputSurnameField(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }

    // метод для заполнения поля «Адрес» из параметра
    public void inputAddressField(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    // метод для заполнения поля «Телефон» из параметра
    public void inputPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // метод для клика на поле «Метро» и выбора станции из списка
    public void selectMetroStationField(String metroStation) {
        WebElement element = driver.findElement(metroStationList);
        new Actions(driver).moveToElement(element).click().sendKeys(metroStation)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    //Метод для нажатия на кнопку "Далее"
    public void clickNextButton() {
        Assert.assertTrue(driver.findElement(nextButton).isEnabled());
        driver.findElement(nextButton).click();
    }

    // метод для клика на поле «Когда привезти самокат» и выбора даты (dd.mm.yyyy)
    public void selectDateField(String date) {
        WebElement element = driver.findElement(dateCalendar);
        new Actions(driver).moveToElement(element).click().sendKeys(date)
                .sendKeys(Keys.ENTER).build().perform();
    }

    // метод для клика на поле «Срок аренды» и выбора срока
    public void selectRentalPeriodList(String period) {
        driver.findElement(rentalPeriodList).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" +period+"']")).click();
    }

    // метод для выбора цвета самоката
    public void selectColourField(String colourScooter) {
        if (Objects.equals(colourScooter, "black")) {
            driver.findElement(colourBlackCheckbox).click();
        } else if (Objects.equals(colourScooter, "grey")) {
            driver.findElement(colourGreyCheckbox).click();
        } else if (Objects.equals(colourScooter, "blackAndGrey")) {
            driver.findElement(colourGreyCheckbox).click();
            driver.findElement(colourBlackCheckbox).click();
        }
    }

    // метод для заполнения поля «Комментарий»из параметра
    public void inputCommentField(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }

    //Метод для нажатия на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(OrderButton).click();
    }

    // метод ожидания загрузки окна с оформленным заказом
    public void waitOrderRegistration(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(TheOrderHasBeenPlacedHeader));
    }

    // метод ожидания загрузки окна с вопросом о подтверждении оформления заказа
    public void waitOrderConfirmation(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(YesButton));
    }

    //Метод для нажатия на кнопку "Да"
    public void clickYesButton() {
        driver.findElement(YesButton).click();
    }

    //Метод для проверки появления окна со статусом заказа
    public boolean checkStatusOrderHeader() {
        WebElement element  = driver.findElement(TheOrderHasBeenPlacedHeader);
        return element.isEnabled();
    }
}
