package step_definitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utils.DriverFactory;

public class LoginSteps {

    Page page = DriverFactory.getPage();
    LoginPage loginPage = new LoginPage(page);
    DashboardPage dashboardPage = new DashboardPage(page);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(page);

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("User is on the login page");
    }

    @When("the user login with valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login("Admin", "admin123");
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        Assert.assertEquals(dashboardPage.getDashboardTitle(), "Dashboard");
    }

    @When("the user login with invalid credentials {string} and {string}")
    public void theUserLoginWithInvalidCredentialsAnd(String name, String password) {
        loginPage.login(name, password);
    }

    @Then("an error message should be displayed indicating invalid login")
    public void anErrorMessageShouldBeDisplayedIndicatingInvalidLogin() {
        Assert.assertEquals(loginPage.getLoginErrorMsg(), "Invalid credentials");
    }

    @When("the user clicks on the \"Forgot Password\" link")
    public void theUserClicksOnTheLink() {
        loginPage.clickForgotPassword();
    }

    @And("the user submits their email address for password recovery")
    public void theUserSubmitsTheirEmailAddressForPasswordRecovery() {
        resetPasswordPage.resetPassword("iwasse");
    }

    @Then("a password recovery email should be sent to the user's email address")
    public void aPasswordRecoveryEmailShouldBeSentToTheUserSEmailAddress() {
        String infoMsg = resetPasswordPage.getConfirmationMessage();
        Assert.assertEquals(infoMsg, "Reset Password link sent successfully");
    }
}
