package TestCases;

import baseClass.browserSetupMine;
import objectRepository_WebElementPaths.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readExcel.getExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class doubleDimensionTest extends getExcel {
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

    @Test(dataProvider = "getLoginData")
    public  void loginPageTest(String username, String password) throws InterruptedException {
        lp = new loginPage(driver);
        Thread.sleep(1000);
        lp.gettoastCloseButton();
        Thread.sleep(1000);
        lp.SetSignInBtn();
        Thread.sleep(1000);
        lp.SetUsernameTxt(username);
        Thread.sleep(1000);
        lp.SetPasswordTxt(password);
        Thread.sleep(1000);
        lp.SetloginSignInBtn();
        Thread.sleep(1000);

    }

    @AfterMethod
    public void closeBrowser(){
        lp.TearDown();

    }

}
