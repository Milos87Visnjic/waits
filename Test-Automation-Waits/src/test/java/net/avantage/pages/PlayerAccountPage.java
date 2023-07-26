package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlayerAccountPage extends LoginPage {

    @FindBy(xpath = "//p[contains(@class, 'account')]/span")
    public WebElement loginButton;

    @FindBy(xpath = "//button[contains(@class, 'account')]//span[contains(text(), 'Email')]")
    public WebElement emailButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//div")
    public WebElement avatarInitialsButton;

    @FindBy(xpath = "//div[text()='Player Account']")
    public WebElement playerAccountTab;

    @FindBy(xpath = "//h1[contains(@class,'account')]")

    public WebElement playerAccountName;

    @FindBy(xpath = "//p[text()='Player Profile']")
    public WebElement playerProfileButton;

    @FindBy(xpath = "//p[text()='Nafiseh Ghazimoradi']")
    public WebElement playerProfileName;


    @FindBy(xpath = "//button[@id='accountDropdownTab-tab-Player Account']")
    public WebElement playerAccountButton;

    @FindBy(xpath = "//p[text()='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath = "//p[text()='Edit Communications']")
    public WebElement editCommunicationButton;

    @FindBy(css = "input[name='marketingNotificationsAccepted']")
    public WebElement futureContestsCheckBox;

    @FindBy(name = "isMarketingNotificationsEmailActive")
    public WebElement emailCheckBox;

    @FindBy(name = "isMarketingNotificationsTextActive")
    public WebElement textCheckBox;

    @FindBy(xpath = "//iframe[3]")
    public WebElement iFrameFeedbackSupport;

    @FindBy(xpath = "//iframe[4]")
    public WebElement iFrameBug;

    @FindBy(xpath = "//p[contains(text(),'Contact Us')]")
    public WebElement contactUs;

    @FindBy(xpath = "//span[contains(text(),'Report an issue')]")
    public WebElement reportAnIssue;

    @FindBy(xpath = "//div[@aria-label='Please tell us how we can help:']")
    public WebElement howWeCanHelpTextBox;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    public WebElement textBoxSubmitButton;

    /**
     * This method enables to click AvatrInitials button.
     */

    public void clickOnTheAvatar() {
        wait.until(ExpectedConditions.elementToBeClickable(avatarInitialsButton));
        avatarInitialsButton.click();
    }

    /**
     * this method enables to click contact us button using explicit wait
     */
    public void clickOnContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUs));
        contactUs.click();
    }

    /**
     * this method enables to click report an issue button using explicit wait
     * It is throwing an exception if we don't use BrowserUtils methods.
     * @throws InterruptedException
     */
    public void clickOnReportAnIssue() throws InterruptedException {
        Thread.sleep(1);
        Driver.get().switchTo().frame(iFrameFeedbackSupport);
        wait.until(ExpectedConditions.elementToBeClickable(reportAnIssue));
        reportAnIssue.click();
    }

    /**
     * this method enables to send a bug report using explicit wait
     * It is throwing an exception if we don't use BrowserUtils methods.
     * @throws InterruptedException
     */
    public void reportBug() throws InterruptedException {
        Thread.sleep(2);
        Driver.get().switchTo().frame(iFrameBug);
        wait.until(ExpectedConditions.elementToBeClickable(howWeCanHelpTextBox));
        howWeCanHelpTextBox.click();
        howWeCanHelpTextBox.sendKeys("there is a bug in the website");
        textBoxSubmitButton.click();
    }


    /**
     * This method enables to click PlayerProfile button.
     */

    public void PlayerProfileButton() {
        BrowserUtils.waitForClickablility(playerProfileButton, 5);
        playerProfileButton.click();
    }


    /**
     * This method enables to click Player Account Tab.
     */
    public void PlayerAccountTab() {
        BrowserUtils.waitForClickablility(playerAccountTab, 10);
        playerAccountTab.click();
    }

    /**
     * This method enables to click avatar or userInitials
     */
    public void clickAvatar() throws InterruptedException {
        Thread.sleep(2);
        Driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        try {
            avatar.click();
        } catch (Exception e) {
            avatarInitials.click();
            e.printStackTrace();
        }
    }

    /**
     * This method enables to click Player Account Button
     */
    public void clickPlayerAccountButton() throws InterruptedException {
        Thread.sleep(1);
        wait.until(ExpectedConditions.elementToBeClickable(playerAccountButton));
        playerAccountButton.click();
    }

    /**
     * This method enables to click settings button
     */
    public void clickSettingsButton() {
        BrowserUtils.waitForClickablility(settingsButton, 5);
        settingsButton.click();
    }

    /**
     * This method enables to click Edit Comm Button
     */
    public void clickEditCommButton() {
        BrowserUtils.waitForClickablility(editCommunicationButton, 5);
        editCommunicationButton.click();
    }

    /**
     * This method enables to select check box in Edit Comm
     */
    public void selectCheckBoxEditComm() {
        BrowserUtils.waitForElementToBeSelectable(futureContestsCheckBox, 5);
        if (!futureContestsCheckBox.isSelected()) {
            futureContestsCheckBox.click();
        }
        if (!emailCheckBox.isSelected()) {
            emailCheckBox.click();
        }
        if (!textCheckBox.isSelected()) {
            textCheckBox.click();
        }
    }

    public void validateCheckBoxes() {
        Assert.assertTrue(futureContestsCheckBox.isSelected());
        Assert.assertTrue(emailCheckBox.isSelected());
        Assert.assertTrue(textCheckBox.isSelected());
    }
}

