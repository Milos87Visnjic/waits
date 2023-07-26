package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQaPage extends BasePage {
    @FindBy(className = "text-success")
    public WebElement confirmResultText;

    @FindBy(id = "promptResult")
    public WebElement promptResultText;

    public WebElement clickMeButton(String name) {
        String css = "button#" + name + "Button";
        return Driver.get().findElement(By.cssSelector(css));
    }

    public void clickClickMe(String alertName) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(clickMeButton(alertName), 5);
        clickMeButton(alertName).click();
    }

    public void handleAlerts() {
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void handleTimerAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void handleConfirmAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(confirmResultText.getText());
    }

    public void handlePromptAlerts() {
        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("NeoTech");
        alert.accept();
        System.out.println(promptResultText.getText());
    }

}
