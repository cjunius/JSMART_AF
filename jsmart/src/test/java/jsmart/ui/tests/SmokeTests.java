package jsmart.ui.tests;

import jsmart.base.BasePage;
import jsmart.base.BaseUITest;
import jsmart.base.SmokeTestPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jsmart.utils.ClassFinder;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class SmokeTests extends BaseUITest {

    @DataProvider(name = "pageObjectClasses")
    public Object[][] pageObjectClasses() throws Exception {
        return Arrays.stream(ClassFinder.getClasses("jsmart.ui.pages"))
                .filter(clz -> (SmokeTestPage.class).isAssignableFrom(clz) )
                .map(Class -> new Object[] { Class })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "pageObjectClasses")
    public void smokeTest(Class clz) throws Exception {
        System.out.println("Testing class " + clz.getCanonicalName());
        Constructor<SmokeTestPage> cons = clz.getConstructor(WebDriver.class);
        cons.newInstance(driver)
                .navigateTo()
                .verify()
                    .pageLoaded();
    }

}
