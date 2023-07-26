package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(60));
    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//img")
    public WebElement avatar;

    @FindBy(xpath = "(//button[contains(@class,'account')]//div)[1]")
    public WebElement avatarInitials;

    @FindBy(xpath = "//button[@aria-label='open drawer']")
    public WebElement hamburgerMenu;

    @FindBy(css = "div[class='casino-jss24']")
    public WebElement obscureElementIrs;

    @FindBy(css="div[class='casino-jss68 casino-jss70 casino-jss27 casino-jss69']")
    public WebElement obscureElementIrs2;

    @FindBy(css = "header[class='casino-jss40 casino-jss29 casino-jss30 casino-jss36 casino-jss22 mui-fixed casino-jss47']")
    public WebElement obscureElementIrs3;

    @FindBy(css = "div[class='onetrust-pc-dark-filter ot-fade-in']")
    public WebElement obscuringElementCookieBanner;


    /**
     * provides accepting all cookies
     */
    public void acceptCookies(){
        System.out.println(Driver.get().manage().timeouts().getPageLoadTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookies));
        acceptAllCookies.click();
    }

    /**
     * provides accepting +18 age question.
     */
    public void acceptAge(){
        wait.until(ExpectedConditions.titleIs("Play Avantage Baccarat"));
        wait.until(ExpectedConditions.visibilityOf(yesButton));
        BrowserUtils.waitForClickablility(yesButton,5);
        BrowserUtils.clickWithJS(yesButton);
    }

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}