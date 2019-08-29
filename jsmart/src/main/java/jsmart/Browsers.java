package jsmart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public enum Browsers {

    CHROME {
        public WebDriver initialize() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions().addArguments("--start-maximized");
            return new ChromeDriver(chromeOptions);
        }
    },

    CHROME_HEADLESS {
        public WebDriver initialize() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions().addArguments("--start-maximized", "headless");
            return new ChromeDriver(chromeOptions);
        }
    },

    EDGE {
        public WebDriver initialize() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },

    FIREFOX {
        public WebDriver initialize() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },

    HTML_UNIT {
        public WebDriver initialize() {
            return new HtmlUnitDriver();
        }
    },

    IE {
        public WebDriver initialize() {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    },

    OPERA {
        public WebDriver initialize() {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }
    },

    PHANTOM_JS {
        public WebDriver initialize() {
            WebDriverManager.phantomjs().setup();
            return new PhantomJSDriver();
        }
    };

    public abstract WebDriver initialize();
}
