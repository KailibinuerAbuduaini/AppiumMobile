package com.automation.step_definitions;

import com.automation.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}