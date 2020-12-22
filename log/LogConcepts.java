package Log_Concept;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;
import BaseClass.BrowserSetupOne;


public class LogConcepts {

	static BrowserSetupOne obs;
	
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void OpenBrowser(String keyword , String url) throws InterruptedException {
		
		
		//DOMConfigurator is Used: this class is used for reading configuration files.
		
		//configure(Element element)
        //Configure log4j using a configuration element as defined in the log4j.dtd.
		//to read log4j.xml
		
		DOMConfigurator.configure("D:\\Amit_JavaPrograming\\TestNG_Concepts\\Logs\\log4j.xml");
		log.startTestCase("Starting Execution");
		 
		obs= new BrowserSetupOne();
		obs.StartBrowser(keyword, url);
	
		System.out.println("Starting the browser session"); 
		
		log.info("Chrome Opened"); 
	}
	
	@Test(priority = 0, enabled = false)
	public void BrokenLinks() throws InterruptedException {
		obs.BrokenLinks();
		log.info("BrokenLinks");
	}
	
	@Test(priority = 1, enabled = true )
	public void getTitle() throws InterruptedException {
		obs.getTitle();
		log.info("getTitle");
	}

	@AfterMethod
	public void TearDown() {
		obs.quit();
		log.info("Closing the Browser");
	}
}