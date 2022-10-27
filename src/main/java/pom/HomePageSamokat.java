package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSamokat {

    private final WebDriver driver;

    //Ссылка на главную страницу приложения Яндекс.самокат
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Локатор выпадающего списка с текстом: Сколько это стоит? И как оплатить?
    private final By questionAboutTheCostField = By.xpath(".//div[@class='accordion__button' and contains(text(),'Сколько это стоит')]");
    //Локатор текста: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private final By responseAboutTheCostText =  By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Сутки — 400 рублей')]");
    //Локатор выпадающего списка с текстом: Хочу сразу несколько самокатов! Так можно?
    private final By questionAboutTheNumberOfScootersField = By.xpath(".//div[@class='accordion__button' and contains(text(),'несколько самокатов')]");
    //Локатор текста: Пока что у нас так: один заказ — один самокат...
    private final By responseAboutTheNumberOfScootersText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'один заказ — один самокат')]");
    //Локатор выпадающего списка с текстом: Как рассчитывается время аренды?
    private final By questionOfRentalTimeField = By.xpath(".//div[@class='accordion__button' and contains(text(),'время аренды')]");
    //Локатор текста: Допустим, вы оформляете..
    private final By responseOfRentalTimeText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Отсчёт времени аренды')]");
    //Локатор выпадающего списка с текстом: Можно ли заказать самокат прямо на сегодня?
    private final By questionAboutTheOrderForTodayField = By.xpath(".//div[@class='accordion__button' and contains(text(),'заказать самокат прямо на сегодня')]");
    //Локатор текста: Только начиная с завтрашнего дня. ...
    private final By responseAboutTheOrderForTodayText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Только начиная с завтрашнего дня')]");
    //Локатор выпадающего списка с текстом: Можно ли продлить заказ или вернуть самокат раньше?
    private final By questionOfExtendingTheOrderField = By.xpath(".//div[@class='accordion__button' and contains(text(),'продлить заказ или вернуть самокат')]");
    //Локатор текста: Пока что нет! Но...
    private final By responseOfExtendingTheOrderText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Пока что нет!')]");
    //Локатор выпадающего списка с текстом: Вы привозите зарядку вместе с самокатом?
    private final By questionAboutChargingField = By.xpath(".//div[@class='accordion__button' and contains(text(),'привозите зарядку')]");
    //Локатор текста: Самокат приезжает к вам...
    private final By responseAboutChargingText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Зарядка не понадобится')]");
    //Локатор выпадающего списка с текстом: Можно ли отменить заказ?
    private final By questionAboutCancelingAnOrderField = By.xpath(".//div[@class='accordion__button' and contains(text(),'отменить заказ')]");
    //Локатор текста: Да, пока самокат не привезли...
    private final By responseAboutCancelingAnOrderText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'пока самокат не привезли')]");
    //Локатор выпадающего списка с текстом: Я жизу за МКАДом, привезёте?
    private final By questionAboutTheOrderAreaField = By.xpath(".//div[@class='accordion__button' and contains(text(),'МКАД')]");
    //Локатор текста: Да, обязательно...
    private final By responseAboutTheOrderAreaText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Да, обязательно. Всем самокатов!')]");
    //Локатор кнопки "Заказать" вверху страницы
    private final By OrderButtonTopOfThePage = By.className("Button_Button__ra12g");
    //Локатор кнопки "Заказать" внизу страницы
    private final By OrderButtonBottomOfThePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // конструктор класса
    public HomePageSamokat (WebDriver driver) {
        this.driver = driver;
    }

    //Метод для открытия главной страницы приложения Яндекс.Самокат
    public void openHomePage () {
        driver.get(url);
    }

    //Метод для нажатия на 1 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton1 () {
        WebElement element = driver.findElement(questionAboutTheCostField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 2 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton2 () {
        WebElement element = driver.findElement(questionAboutTheNumberOfScootersField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 3 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton3 () {
        WebElement element = driver.findElement(questionOfRentalTimeField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 4 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton4 () {
        WebElement element = driver.findElement(questionAboutTheOrderForTodayField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 5 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton5 () {
        WebElement element = driver.findElement(questionOfExtendingTheOrderField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 6 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton6 () {
        WebElement element = driver.findElement(questionAboutChargingField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 7 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton7 () {
        WebElement element = driver.findElement(questionAboutCancelingAnOrderField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для нажатия на 8 стрелочку в выпадающем списке
    public void clickArrowInTheDropDownListButton8 () {
        WebElement element = driver.findElement(questionAboutTheOrderAreaField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    // методы для получения текста
    // Метод для получения ответа под 1 стрелочкой
    public String TextInTheDropDownList1 () {
        return driver.findElement(responseAboutTheCostText).getText();
    }

    // Метод для получения ответа под 2 стрелочкой
    public String TextInTheDropDownList2 () {
        return driver.findElement(responseAboutTheNumberOfScootersText).getText();
    }

    // Метод для получения ответа под 3 стрелочкой
    public String TextInTheDropDownList3 () {
        return driver.findElement(responseOfRentalTimeText).getText();
    }

    // Метод для получения ответа под 4 стрелочкой
    public String TextInTheDropDownList4 () {
        return driver.findElement(responseAboutTheOrderForTodayText).getText();
    }

    // Метод для получения ответа под 5 стрелочкой
    public String TextInTheDropDownList5 () {
        return driver.findElement(responseOfExtendingTheOrderText).getText();
    }

    // Метод для получения ответа под 6 стрелочкой
    public String TextInTheDropDownList6 () {
        return driver.findElement(responseAboutChargingText).getText();
    }

    // Метод для получения ответа под 7 стрелочкой
    public String TextInTheDropDownList7 () {
        return driver.findElement(responseAboutCancelingAnOrderText).getText();
    }

    // Метод для получения ответа под 8 стрелочкой
    public String TextInTheDropDownList8 () {
        return driver.findElement(responseAboutTheOrderAreaText).getText();
    }

    //Метод для нажатия на кнопку "заказать" вверху страницы
    public void clickOrderButtonTopOfThePage () {
        driver.findElement(OrderButtonTopOfThePage).click();
    }

    //Метод для нажатия на кнопку "заказать" внизу страницы
    public void clickOrderButtonBottomOfThePage () {
        WebElement element = driver.findElement(OrderButtonBottomOfThePage);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(OrderButtonBottomOfThePage));
        element.click();
    }
}
