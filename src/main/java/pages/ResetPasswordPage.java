package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ResetPasswordPage {
    private final Page page;

    public ResetPasswordPage(Page page) {
        this.page = page;
    }

    public void resetPassword(String username) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username")).fill(username);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset Password")).click();
    }

    public Locator getConfirmationMessage() {
        return page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Reset Password link sent"));
    }
}
