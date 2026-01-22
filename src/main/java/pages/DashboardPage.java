package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage {
    private final Page page;

    public DashboardPage(Page page) {
        this.page = page;
    }

    public Locator getDashboardTitle() {
        return page.locator("h6.oxd-text--h6");
    }
}
