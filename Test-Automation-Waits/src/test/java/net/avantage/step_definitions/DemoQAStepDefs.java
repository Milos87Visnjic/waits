package net.avantage.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.DemoQaPage;
import net.avantage.utils.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQAStepDefs {
    DemoQaPage demoQaPage = new DemoQaPage();

    @Given("User navigates to demoQa page")
    public void userNavigatesToDemoQaPage() {
        Driver.get().get("https://demoqa.com/alerts");
    }

    @When("User handles alerts")
    public void user_handles_alerts() {
        demoQaPage.handleAlerts();
    }

    @When("User clicks on first click me button")
    public void user_clicks_on_first_click_me_button() {
        demoQaPage.clickClickMe("alert");
    }

    @When("User clicks on second click me button")
    public void user_clicks_on_second_click_me_button() {
        demoQaPage.clickClickMe("timerAlert");
    }

    @Then("User handles timer alerts")
    public void user_handles_timer_alerts() {
        demoQaPage.handleTimerAlerts();
    }

    @When("User clicks on third click me button")
    public void user_clicks_on_third_click_me_button() {
        demoQaPage.clickClickMe("confirm");
    }

    @Then("User handles confirm alerts")
    public void user_handles_confirm_alerts() {
       demoQaPage.handleConfirmAlerts();
    }

    @When("User clicks on fourth click me button")
    public void user_clicks_on_fourth_click_me_button() {
        demoQaPage.clickClickMe("promt");
    }

    @Then("User handles prompt alerts")
    public void user_handles_prompt_alerts() {
      demoQaPage.handlePromptAlerts();
    }

}
