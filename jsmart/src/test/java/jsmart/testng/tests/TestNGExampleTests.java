package jsmart.testng.tests;

import org.testng.annotations.*;

public class TestNGExampleTests {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute before starting the TestNG Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This will execute before starting this Class");
    }

    @BeforeGroups("testNG_tests")
    public void beforeGroups() {
        System.out.println("This will execute before any tests in the specified group run");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This will execute before every test method");
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        return new Object[][] {
                {"Value 1"},
                {"Value 2"},
                {"Value 3"},
        };
    }

    @Test(dataProvider="dataProvider", groups="testNG_tests")
    public void test(String value) {
        System.out.println("Executing test with dataprovider value " + value);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This will execute after every test method");
    }

    @AfterGroups("testNG_tests")
    public void afterGroups() {
        System.out.println("This will execute after all tests in the specified group run");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This will execute just before exiting this class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("THis will execute just before exiting the TestNG Suite");
    }

}
