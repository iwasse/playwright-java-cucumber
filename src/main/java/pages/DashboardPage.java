package pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private final Page page;

    public DashboardPage(Page page) {
        this.page = page;
    }

    public String getDashboardTitle() {
        return page.textContent("h6.oxd-text--h6");
    }
}
