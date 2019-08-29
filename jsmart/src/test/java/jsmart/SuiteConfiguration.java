package jsmart;

import java.util.logging.Level;

import org.testng.annotations.BeforeClass;

public class SuiteConfiguration {

    protected Environments environment;
    protected Browsers browser;

    @BeforeClass
    public void suiteSetup() {
        environment = Environments.valueOf(System.getProperty("jsmart.env", "PROD"));
        browser = Browsers.valueOf(System.getProperty("jsmart.browser", "CHROME_HEADLESS"));

        //Disabled most selenium messages
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.WARNING);
    }
    
}
