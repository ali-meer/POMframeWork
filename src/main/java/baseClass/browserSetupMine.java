package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserSetupMine {
    public WebDriver driver;

    public WebDriver launchBrowser(String browsername, String baseURL) throws InterruptedException {
        if(browsername.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browsername.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(browsername.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        Thread.sleep(1000);
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get(baseURL);

        return driver;
    }
   }
