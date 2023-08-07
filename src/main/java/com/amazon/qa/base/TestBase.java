package com.amazon.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class TestBase 
{
	public static WebDriver driver;
	String url;
	String browser;
	String path;
	
    public TestBase()
    {
    	path=System.getProperty("user.dir");
    	FileReader reader = null;
		try {
			reader = new FileReader(path+"\\src\\main\\java\\com\\maven\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Properties props=new Properties();
        try {
			props.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        url=props.getProperty("browserURL");
        browser=props.getProperty("browser");
    }
    public void initialization() throws InterruptedException
    {
    	if(browser.equalsIgnoreCase("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver",path+"\\chromedriver_win32 (3)\\chromedriver.exe");
    		driver= new ChromeDriver();
    	}
    	driver.get(url);
    	driver.manage().window().maximize();
    	Thread.sleep(15000);
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void close()
    {
    	driver.quit();
    }
}
