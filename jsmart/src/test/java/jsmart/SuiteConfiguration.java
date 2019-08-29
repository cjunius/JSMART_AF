package jsmart;

public class SuiteConfiguration {

    protected Environments ENVIRNONMENT = Environments.valueOf(System.getProperty("env", "PROD"));
    protected Browsers BROWSER = Browsers.valueOf(System.getProperty("browser", "CHROME_HEADLESS"));

}
