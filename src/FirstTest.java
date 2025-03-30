import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest extends CoreTestCase {
    //private AppiumDriver driver;

    public MainPageObject MainPageObject;
    @Override
    public void setUp() throws Exception{
        super.setUp();
        MainPageObject = new MainPageObject(driver);
        MainPageObject.waitForElementAndClick(By.xpath("//*[contains(@text,'Пропустить')]"), "Невозможно нажать на пропуск", 60);
    }

    @Override
    public void tearDown() throws Exception{
        driver.quit();
        super.tearDown();
    }

    //@Test
    //public void firstTest() {
    //    System.out.println("Our first test");
    //}

//    @Test
//    public void testSearch() {
//        MainPageObject.waitForElementAndClick(By.xpath("//*[contains(@text,'Поиск по Википедии')]"),
//                "Невозможно нажать на поле ввода",
//                15);
//        MainPageObject.waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
//                "DNS",
//                "Невозможно найти поле ввода",
//                5);
//        MainPageObject.waitForElementAndClick(By.xpath("//*[@class='android.view.ViewGroup']//*[@text='российская торговая сеть по продаже бытовой техники и электроники']"),
//                "Невозможно найти DNS",
//                15);
//        WebElement description_element = MainPageObject.waitForElementPresent(By.id("pcs-edit-section-title-description"),
//                "Невозможно найти описание", 15);
//        String result = description_element.getText();
//
//        Assert.assertEquals("Найдено несовпадение в описании статьи",
//                "Russian chain of stores", result);
//    }

//    @Test
//    public void testSearchElement() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("DNS");
//        SearchPageObject.waitForSearchResult("российская торговая сеть по продаже бытовой техники и электроники");
//    }

    @Test
    public void testWiki() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Хоббит, или Туда и обратно");
        SearchPageObject.waitForSearchResult("повесть Джона Р. Р. Толкина (1937)");
        SearchPageObject.initSave();
        SearchPageObject.typeListName("Хоббит");
        SearchPageObject.clickOkButton();
        driver.navigate().back();
        driver.navigate().back();
        SearchPageObject.clickBackButton();
        SearchPageObject.initSavedList();
        SearchPageObject.clickNotNowButton();
        SearchPageObject.longPressOnListByTitle("Хоббит", 3);
        SearchPageObject.clickDeleteListButton();
        SearchPageObject.clickOkButton();
    }


}

