package TestCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class screenShot {
  //  static WebDriver driver;
    static String filepath = "C:\\Users\\proph\\IdeaProjects\\POMframwork\\screnShot\\ali.jpg";
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ck12.org/");
        Thread.sleep(3000);

      //  File scrfile = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);


        File scrfile = driver.getScreenshotAs(OutputType.FILE);
        File desctfile = new File(filepath);
        FileUtils.copyFile(scrfile,desctfile);

        driver.close();
    }

}
