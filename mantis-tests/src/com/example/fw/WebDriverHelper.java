package com.example.fw;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class WebDriverHelper {

 /*   public static WebDriver driver;
    private final ApplicationManager manager;
    private WebDriverWait wait;

    public WebDriverHelper(ApplicationManager manager) {
        this.manager = manager;
        String browser = manager.getProperty("browser");
        if ("firefox".equals(browser)) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new FirefoxDriver(capabilities);
        } else if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/resources/browserdrivers/chromedriver");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(capabilities);
        } else if ("ie".equals(browser)) {
            System.setProperty("webdriver.ie.driver", "src/resources/browserdrivers/IEDriverServer");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else {
            throw new Error("Unsupported browser: " + browser);
        }
        String baseUrl = manager.getProperty("baseUrl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 10);
    }

    protected void stop() {
        driver.close();
    }*/
}
