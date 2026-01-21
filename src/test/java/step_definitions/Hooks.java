package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getPage();
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
