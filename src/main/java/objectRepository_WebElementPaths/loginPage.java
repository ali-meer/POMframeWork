package objectRepository_WebElementPaths;

import baseClass.browserSetupMine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//ul/li/a/span[contains(text(),'sign in')]")
    private WebElement  SignInBtn;

    public void SetSignInBtn() throws InterruptedException {
        Thread.sleep(1000);
        SignInBtn.click();
    }

    @FindBy(name = "login")
            private WebElement usernameTxt;

    public void SetUsernameTxt(String username) throws InterruptedException {
        Thread.sleep(1000);
        usernameTxt.sendKeys(username);

    }

    @FindBy(name = "token")
    private WebElement passwordTxt;

    public void SetPasswordTxt(String password) throws InterruptedException {
        Thread.sleep(1000);
        passwordTxt.sendKeys(password);
        Thread.sleep(1000);
    }

    @FindBy(xpath ="//input[@value='Sign In']")
    private WebElement  loginSignInBtn;

    public void SetloginSignInBtn() throws InterruptedException {
        Thread.sleep(1000);
        loginSignInBtn.click();
    }

    @FindBy(xpath ="//ul/li[3]/a[contains(text(),'Library')]")
    private WebElement  libraryBtn;

    public void SetlibraryBtn() throws InterruptedException {
        Thread.sleep(1000);
        libraryBtn.click();
    }


    @FindBy(xpath ="//a[@id='dropdown-create']")
    private WebElement  dropdownCreateNewBtn;

    public void SetdropdownCreateNewBtn() throws InterruptedException {
        Thread.sleep(1000);
        dropdownCreateNewBtn.click();
    }

    @FindBy(xpath = "//ul/li[4]/a[contains(text(),' Quiz')]")
    private WebElement dropdownQuizTxt;

    public void SetdropdownQuizTxt(String dropdownQuiz) throws InterruptedException {
        Thread.sleep(1000);
        dropdownQuizTxt.sendKeys(dropdownQuiz);
        Thread.sleep(1000);
    }

    public void getTitle() throws InterruptedException {
        Thread.sleep(1000);
        String titlePage = driver.getTitle();
        System.out.println(titlePage);
        Thread.sleep(3000);
    }

    public void TearDown() {
        driver.close();
    }

    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        @FindBy(xpath = "//div[@id='toast-close-button']")
        private WebElement toastCloseButton;
        public void gettoastCloseButton() {
            if(toastCloseButton.isDisplayed())
            {
                toastCloseButton.click();
            }else
            {
                System.out.println("No toastCloseButton is present");
            }
        }




    }
