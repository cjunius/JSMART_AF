package jsmart.ui.tests;

import jsmart.base.BasePage;
import jsmart.base.BaseUITest;
import jsmart.base.SmokeTestPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jsmart.utils.ClassFinder;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

import org.slf4j.LoggerFactory;

public class SmokeTests extends BaseUITest {

    private static final String PACKAGE_TO_TEST = "jsmart.ui.pages";

    @DataProvider(name = "pageObjectClasses")
    public Object[][] pageObjectClasses() throws Exception {

        return Arrays.stream(ClassFinder.getClasses(PACKAGE_TO_TEST))
                .filter(clz -> (SmokeTestPage.class).isAssignableFrom(clz) ) //Only classes that implement SmokeTestPage
                .sorted(Comparator.comparing(Class::getSimpleName)) //Order Alphabetically
                .map(Class -> new Object[] { Class })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "pageObjectClasses")
    public void smokeTest(Class<SmokeTestPage> clz) throws Exception {
        LoggerFactory.getLogger(this.getClass().getSimpleName())
            .info("Testing class " + clz.getSimpleName());

        Constructor<SmokeTestPage> cons = clz.getConstructor(WebDriver.class);
        cons.newInstance(driver)
                .navigateTo()
                .verify()
                    .pageLoaded();
    }

}
