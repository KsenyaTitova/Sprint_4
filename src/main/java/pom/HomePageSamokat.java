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
    private final By responseAboutTheCostText = By.xpath(".//div[@class='accordion__panel']/p[contains(text(),'Сутки — 400 рублей')]");
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
    private static final By OrderButtonTopOfThePage = By.className("Button_Button__ra12g");
    //Локатор кнопки "Заказать" внизу страницы
    private final By OrderButtonBottomOfThePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // конструктор класса
    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для открытия главной страницы приложения Яндекс.Самокат
    public void openHomePage() {
        driver.get(url);
    }

    //Метод для нажатия на стрелочку в выпадающем списке
    public String clickArrowInTheDropDownListButton(int numberButtonDropDown) {
        if (numberButtonDropDown == 1) {//выбрали первую стрелочку
            WebElement element = driver.findElement(questionAboutTheCostField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutTheCostText).getText();
        } else if (numberButtonDropDown == 2) {//выбрали вторую стрелочку
            WebElement element = driver.findElement(questionAboutTheNumberOfScootersField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutTheNumberOfScootersText).getText();
        } else if (numberButtonDropDown == 3) {//выбрали третью стрелочку
            WebElement element = driver.findElement(questionOfRentalTimeField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseOfRentalTimeText).getText();
        } else if (numberButtonDropDown == 4) {//выбрали четвертую стрелочку
            WebElement element = driver.findElement(questionAboutTheOrderForTodayField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutTheOrderForTodayText).getText();
        } else if (numberButtonDropDown == 5) {//выбрали пятую стрелочку
            WebElement element = driver.findElement(questionOfExtendingTheOrderField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseOfExtendingTheOrderText).getText();
        } else if (numberButtonDropDown == 6) {//выбрали шестую стрелочку
            WebElement element = driver.findElement(questionAboutChargingField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutChargingText).getText();
        } else if (numberButtonDropDown == 7) {//выбрали седьмую стрелочку
            WebElement element = driver.findElement(questionAboutCancelingAnOrderField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutCancelingAnOrderText).getText();
        } else if (numberButtonDropDown == 8) {//выбрали восьмую стрелочку
            WebElement element = driver.findElement(questionAboutTheOrderAreaField);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(responseAboutTheOrderAreaText).getText();
        }
        return null;
    }

    //Метод для нажатия на кнопку "заказать". 0 - кнопка вверху страницы, 1 - кнопка внизу страницы
    public void clickOrderButton(int numberButtonOrder) {
        if (numberButtonOrder == 0) {
            driver.findElement(OrderButtonTopOfThePage).click();
        } else if (numberButtonOrder == 1) {
            WebElement element = driver.findElement(OrderButtonBottomOfThePage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.visibilityOfElementLocated(OrderButtonBottomOfThePage));
            element.click();
        }
    }
}
