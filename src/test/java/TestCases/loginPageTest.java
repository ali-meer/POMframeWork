package TestCases;



import baseClass.browserSetupMine;
import objectRepository_WebElementPaths.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class loginPageTest {
    File file;
    FileInputStream fis;
    Properties prop;
    loginPage lp;
    WebDriver driver;

    @BeforeMethod
    public  void  homeNavigation() throws IOException, InterruptedException {
        file = new File(".\\config\\file.properties");
        fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);

        Thread.sleep(3000);
        browserSetupMine bs = new browserSetupMine();
        driver = bs.launchBrowser(prop.getProperty("browsername"), prop.getProperty("baseURL") );
        Thread.sleep(1000);

    }

    @Test
    public  void loginPageTest() throws InterruptedException {
        lp = new loginPage(driver);
        lp.SetSignInBtn();
        lp.SetUsernameTxt("mzakkar@gmail.com");
        lp.SetPasswordTxt("test123");
        lp.SetloginSignInBtn();

    }

    @AfterMethod
    public void closeBrowser(){
        lp.TearDown();

    }

}
