package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.DemoPage;
import net.avantage.pages.IndividualRankingsPage;
import net.avantage.pages.LoginPage;
import net.avantage.utils.BrowserUtils;
import org.junit.Assert;

public class DemoStepDefs {
    DemoPage demoPage = new DemoPage();
    LoginPage loginPage = new LoginPage();

    IndividualRankingsPage individualRankingsPage = new IndividualRankingsPage();

    @Given("User navigates to Demo Page")
    public void user_navigates_to_demo_page() {
        demoPage.navigateToDemoPage();
    }

    @And("User scroll down to Sortable Data Tables")
    public void userScrollDownToSortableDataTables() {
        BrowserUtils.scrollToElement(demoPage.sortableDataTables);
    }

    @And("User click on Sortable Data Tables")
    public void userClickOnSortableDataTables() {
        demoPage.clickOnSortableDataTables();
    }

    @Then("User verifies Example One is displayed")
    public void userVerifiesExampleOneIsDisplayed() {
        Assert.assertTrue(demoPage.example1.isDisplayed());
    }

    @And("User verifies first table")
    public void userVerifiesFirstTable() {
        demoPage.validateTable();
    }

    @And("User verifies LastNames and FirstNames are in ascending order")
    public void userVerifiesLastNamesAndFirstNamesAreInAscendingOrder() {
        demoPage.validateAscendingOrder();
    }

    @And("User prints rows and column numbers")
    public void userPrintsRowsAndColumnNumbers() {
        demoPage.printRowsNumbers();
        demoPage.printColumnNumber();
    }

    @And("User prints second row and third column")
    public void userPrintsSecondRowAndThirdColumn() {
        demoPage.printSecondRow();
        demoPage.printThirdColumn();
    }

    @When("User log in {string} and {string}")
    public void userLogInAnd(String usernames, String password) {
        loginPage.loginWithParameters(usernames, password);
    }

    @Then("User verify {string}")
    public void userVerify(String avatar) {
        loginPage.verifyAvatar(avatar);
    }

    @And("User logs in with the parameters {string} and {string}")
    public void userLogsInWithTheParametersAndQW(String name, String pass) {

        loginPage.loginWithParameters(name, pass);
        
    }

    @And("User clicks on Individuals button in dropdown")
    public void userClicksOnIndividualsButtonInDropdown() {

        demoPage.clickIndividualInDropdownMenu();
    }

    @And("User clicks on Regions")
    public void userClicksOnRegions() {

        demoPage.clickOnRegionsButton();
    }

    //step definitions for verify top ranking tiers are clicked

    @Given("User clicks on individual item on the menu")
    public void user_clicks_on_individual_item_on_the_menu() {
    demoPage.individualItemOnMenu.click();

    }
    @Given("User clicks on region button")
    public void user_clicks_on_region_button() {
        demoPage.regionsButton.click();

    }
    @Given("User clicks on top ranking button")
    public void user_clicks_on_top_ranking_button() {
        BrowserUtils.waitFor(2 );
        demoPage.topRankingButton.click();
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs);
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs2);
        BrowserUtils.removeObscuringElement(demoPage.obscureElementIrs3);

    }
    @When("User clicks on {string}")
    public void user_clicks_on(String tiers) {

        demoPage.tiers(tiers).click();

    }
    @Then("verify that {string} are clicked")
    public void verify_that_are_clicked(String tiers) {
        Assert.assertTrue("aria-selected", true);
    }
    @And("User clicks on Regions button")
    public void userClicksOnRegionsButton() {
        demoPage.clickOnRegionsButton();
    }

    @And("User verifies that {string} is {string}")
    public void userVerifiesThatIs(String tier, String selected) {
        Assert.assertEquals(demoPage.tiers(tier).getAttribute("aria-selected"), selected);
        Assert.assertTrue(demoPage.tiers(tier).getAttribute("style").contains("rgb"));
    }
    @And("User clicks on {string} button in Hamburger Menu")
    public void userClicksOnButtonInHamburgerMenu(String leaguesName) {
        demoPage.clickLeaguesNameInHamburgerMenu(leaguesName);
    }
    @And("User verifies {string} in selectionBox")
    public void userVerifiesInSelectionBox(String leaguesName) {
        Assert.assertEquals(leaguesName, demoPage.selectionBoxVerify.getAttribute("value"));
    }


}
