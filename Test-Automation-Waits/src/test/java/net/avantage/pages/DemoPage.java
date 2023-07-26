package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DemoPage extends BasePage {

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowsInTable;

    @FindBy(xpath = "//table[@id='table1']//tbody/tr[1]/td")
    public List<WebElement> columnsOfTheTable;

    @FindBy(css = "h4:nth-of-type(1)")
    public WebElement example1;

    @FindBy(xpath = "//table[@id='table1']//tr/td[1]")
    public List<WebElement> rowsOfTable;

    @FindBy(css = "a[href$='tables']")
    public WebElement sortableDataTables;

    @FindBy(xpath = "//table[@id='table1']//tr/td[2]")
    public List<WebElement> firstNames;

    @FindBy(xpath = "//a[contains(@href, 'rankings/individual')]//p")
    public WebElement individualHamburgerMenuXpath;

    @FindBy(xpath = "a[href*= 'individual']>p")
    public WebElement individualHamburgerMenuCss;

    @FindBy(xpath = "//nav//span[contains(text(),'Regions')]")
    public WebElement regionsButton;


    @FindBy(css = "a[href*='individual']")
    public WebElement individualItemOnMenu;

    @FindBy(xpath = "//span[text()='Top Rankings']")
    public WebElement topRankingButton;

    @FindBy(css = "div[aria-haspopup='listbox']~input")
    public WebElement selectionBoxVerify;


    public WebElement locateLeaguesInHamburgerMenu(String leaguesName) {
        String css = "a[href*='" + leaguesName + "']";
        return Driver.get().findElement(By.cssSelector(css));
    }

    public WebElement tiers(String tiers) {
        String css = "button#simple-tab-" + tiers + "";
        return Driver.get().findElement(By.cssSelector(css));
    }


    /**
     * This method provides to locate Header of table dynamically
     *
     * @param columnNumber
     * @return
     */
    public WebElement locateHeaderOfTable(int columnNumber) {
        String xpath = "//table[@id='table1']//tr/th[" + columnNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    /**
     * This method enables to locate rows and columns of the table dynamically
     *
     * @param rowNumber
     * @param columnNumber
     * @return
     */
    public WebElement locateTable(int rowNumber, int columnNumber) {
        String xpath = "//table[@id='table1']//tr[" + rowNumber + "]/td[" + columnNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public WebElement locateTiersXpath(String tiers) {
        String xpath = "//div[contains(text(), '" + tiers + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }


    public WebElement ValidateClicked(String tiers) {
        String xpath = "//button[@id='simple-tab-" + tiers.toLowerCase() + "' and @aria-selected='true']";
        return Driver.get().findElement(By.xpath(xpath));
    }


    public WebElement locateTiersCss(String tiers) {
        String css = "button[id='" + tiers + "']";
        return Driver.get().findElement(By.xpath(css));
    }


    /**
     * This method provides to get rows number in the table.
     */
    public void getRowsNumber() {
        System.out.println(rowsInTable.size());
    }

    /**
     * This method provides to get column number in the table.
     */
    public void getColumnNumber() {
        System.out.println(columnsOfTheTable.size());
    }

    /**
     * This method enables to navigate to desired page
     */
    public void navigateToDemoPage() {
        Driver.get().get(ConfigurationReader.get("herOku_URL"));
    }

    /**
     * This method enables to click data tables
     */
    public void clickOnSortableDataTables() {
        BrowserUtils.waitForClickablility(sortableDataTables, 3);
        sortableDataTables.click();
    }

    /**
     * This method enables to print and validate whole table
     */
    public void validateTable() {
        //headers
        for (int i = 1; i <= columnsOfTheTable.size(); i++) {
            if ((i == 1) || (i == 2)) {
                System.out.print(locateHeaderOfTable(i).getText() + " \t");
            } else if ((i == 3) || (i == 5)) {
                System.out.print(locateHeaderOfTable(i).getText() + "  \t\t\t\t\t");
            } else {
                System.out.print(locateHeaderOfTable(i).getText() + "  \t\t\t");
            }
        }
        System.out.println();
        //rows
        for (int i = 1; i <= rowsOfTable.size(); i++) {
            //columns
            for (int j = 1; j <= columnsOfTheTable.size(); j++) {
                if (((i == 4) && (j == 5)) || ((i == 4) && (j == 3)) || ((i == 3) && (j == 4))) {
                    System.out.print(locateTable(i, j).getText() + " \t");
                } else {
                    System.out.print(locateTable(i, j).getText() + " \t\t");
                }
                if (j == 3) {
                    Assert.assertTrue(locateTable(i, j).getText().contains("@"));
                } else if (j == 4) {
                    Assert.assertTrue(locateTable(i, j).getText().contains("$"));
                } else if (j == 5) {
                    Assert.assertTrue(locateTable(i, j).getText().contains("www"));
                } else {
                    Assert.assertTrue(locateTable(i, j).isDisplayed());
                }
            }
            System.out.println();
        }
    }

    /**
     * This method enables to check whether the column is in ascending order
     */
    public void validateAscendingOrder() {
        System.out.println("*****************************");
        locateHeaderOfTable(1).click();
        BrowserUtils.checkTheListInAscendingOrder(rowsOfTable);
        System.out.println("*****************************");
        locateHeaderOfTable(2).click();
        BrowserUtils.checkTheListInAscendingOrder(firstNames);
    }

    /**
     * This method provides to print rows number in the table.
     */
    public void printRowsNumbers() {
        System.out.println("*****************************");
        System.out.println("There are " + rowsOfTable.size() + " rows in the table");
    }

    /**
     * This method provides to print column number in the table.
     */
    public void printColumnNumber() {
        System.out.println("*****************************");
        System.out.println("There are " + columnsOfTheTable.size() + " columns in the table");
    }

    /**
     * This method enables to print second row
     */
    public void printSecondRow() {
        System.out.println("*****************************");
        System.out.println("****** The Second Row ********");
        for (int i = 1; i <= rowsOfTable.size(); i++) {
            System.out.print(locateTable(2, i).getText() + " ");
        }
        System.out.println();
    }

    /**
     * This method enables to print third column.
     */
    public void printThirdColumn() {
        System.out.println("*****************************");
        System.out.println("****** The Third Column ********");
        for (int i = 1; i <= rowsOfTable.size(); i++) {
            System.out.println(locateTable(i, 3).getText());
        }
    }

    /**
     * This method enables to click individuals button in dropdown menu.
     */
    public void clickIndividualInDropdownMenu() {
        BrowserUtils.waitForClickablility(individualHamburgerMenuXpath, 15);
        individualHamburgerMenuXpath.click();
    }

    public void clickOnTheHamburgerMenu() {
        BrowserUtils.waitForVisibility(avatar, 5);
        BrowserUtils.waitForClickablility(hamburgerMenu, 5);
        hamburgerMenu.click();
    }


    public void clickOnTiers(String tiers) {
        BrowserUtils.waitForClickablility(locateTiersXpath(tiers), 3);
        locateTiersXpath(tiers).click();

    }

    public void clickOnRegionsButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(regionsButton, 5);
        regionsButton.click();
    }

    public void clickLeaguesNameInHamburgerMenu(String leaguesName) {
        BrowserUtils.waitForClickablility(locateLeaguesInHamburgerMenu(leaguesName), 5);
        locateLeaguesInHamburgerMenu(leaguesName).click();
    }

}
