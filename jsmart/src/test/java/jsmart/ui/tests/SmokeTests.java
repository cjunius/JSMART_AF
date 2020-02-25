package jsmart.ui.tests;

import jsmart.base.BasePage;
import jsmart.base.BaseUITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jsmart.utils.ClassFinder;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class SmokeTests extends BaseUITest {

    @DataProvider(name = "pageObjectClasses")
    public Object[][] pageObjectClasses() throws Exception {
        Class[] classes = ClassFinder.getClasses("jsmart.ui.pages");
        return Arrays.stream(classes)
                .filter(clz -> (BasePage.class).isAssignableFrom(clz) )
                .map(Class -> new Object[] { Class })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "pageObjectClasses")
    public void smokeTest(Class clz) throws Exception {
        System.out.println("Testing class " + clz.getCanonicalName());
        Constructor<BasePage> cons = clz.getConstructor(WebDriver.class);
        BasePage testPage = cons.newInstance(driver);
        testPage
                .navigateTo()
                .verify()
                    .pageLoaded();
    }

}
