package jsmart.ui.tests;

import jsmart.core.BaseUITest;
import jsmart.core.SmokeTestable;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jsmart.utils.ClassFinder;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class SmokeTests extends BaseUITest {

    private static final String PACKAGE_TO_TEST = "jsmart.ui.pages";

    @DataProvider(name = "pageObjectClasses")
    public Object[][] pageObjectClasses() throws Exception {

        return Arrays.stream(ClassFinder.getClasses(PACKAGE_TO_TEST))
                .filter(clz -> !clz.isInterface()) // filter out interfaces
                .filter(clz -> !Modifier.isAbstract(clz.getModifiers())) // filter out abstract classes
                .filter(clz -> (SmokeTestable.class).isAssignableFrom(clz) ) //Only classes that implement SmokeTestPage
                .sorted(Comparator.comparing(Class::getSimpleName)) //Order Alphabetically
                .map(Class -> new Object[] { Class })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "pageObjectClasses")
    public void smokeTest(Class<SmokeTestable> clz) throws Exception {
        LoggerFactory.getLogger(this.getClass().getSimpleName())
            .info("Testing class " + clz.getSimpleName());

        Constructor<SmokeTestable> cons = clz.getConstructor(WebDriver.class);
        cons.newInstance(driver)
                .navigateTo()
                .verifyPageLoaded();
    }

}
